package cz.cvut.fit.test;

import cz.cvut.fit.genepi.businessLayer.VO.display.PatientDisplayVO;
import cz.cvut.fit.genepi.businessLayer.VO.form.AnamnesisVO;
import cz.cvut.fit.genepi.businessLayer.service.PatientService;
import cz.cvut.fit.genepi.businessLayer.service.card.AnamnesisService;
import cz.cvut.fit.genepi.dataLayer.entity.PatientEntity;
import cz.cvut.fit.genepi.dataLayer.entity.card.AnamnesisEntity;
import cz.cvut.fit.genepi.presentationLayer.controller.card.AnamnesisController;
import org.joda.time.LocalDate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Date;

import static org.hamcrest.Matchers.isA;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:anamnesisControllerTestContext.xml"})
@WebAppConfiguration
public class AnamnesisControllerTest {

    private MockMvc mockMvc;

    @Autowired
    @Qualifier("patientService")
    private PatientService patientServiceMock;

    @Autowired
    @Qualifier("anamnesisService")
    private AnamnesisService anamnesisServiceMock;

    // Add WebApplicationContext field here
    @Autowired
    private WebApplicationContext webApplicationContext;

    // The setUp() method is omitted.
    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(
                new AnamnesisController(patientServiceMock,
                        anamnesisServiceMock)).build();
    }

    @After
    public void reset_mocks() {
        reset(patientServiceMock);
        reset(anamnesisServiceMock);
    }

    @Test
    public void anamnesisCreateGET() throws Exception {
        PatientDisplayVO found = new PatientDisplayVO();
        found.setId(1);

        when(patientServiceMock.getPatientDisplayByIdWithDoctor(1)).thenReturn(found);

        mockMvc.perform(get("/patient/{patientId}/anamnesis/create", 1))
                .andExpect(status().isOk())
                .andExpect(view().name("patient/anamnesis/formView"))
                .andExpect(
                        model().attribute("patient", isA(PatientDisplayVO.class)))
                .andExpect(
                        model().attribute("anamnesis",
                                isA(AnamnesisVO.class)));

        verify(patientServiceMock, times(1)).getPatientDisplayByIdWithDoctor(1);
        verifyNoMoreInteractions(patientServiceMock);
    }

    @Test
    public void anamnesisCreatePOST_AnamnesisEntityValid() throws Exception {

        AnamnesisVO anamnesis = new AnamnesisVO();
        anamnesis.setDate(new Date());
        anamnesis.setBeginningEpilepsy(new Date());

        mockMvc.perform(
                post("/patient/{patientId}/anamnesis/save", 1)
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .content(
                                Util.convertObjectToFormUrlEncodedBytes(anamnesis))
                        .sessionAttr("anamnesis", anamnesis))
                .andExpect(model().attributeHasNoErrors("anamnesis"))
                .andExpect(status().isMovedTemporarily())
                .andExpect(view().name("redirect:/patient/1/anamnesis/list"));

        verify(anamnesisServiceMock, times(1)).save(AnamnesisEntity.class,anamnesis);
        verifyNoMoreInteractions(anamnesisServiceMock);
    }

    @Test
    public void anamnesisCreatePOST_AnamnesisEntityNotValid() throws Exception {
        String nonCnsComorbidity = Util.createStringWithLength(900);

        LocalDate now = new LocalDate();
        LocalDate date = now.plusDays(1);
        Date tomorrow = date.toDate();

        AnamnesisVO anamnesis = new AnamnesisVO();
        anamnesis.setNonCnsComorbidity(nonCnsComorbidity);
        anamnesis.setDate(tomorrow);
        anamnesis.setBeginningEpilepsy(tomorrow);

        mockMvc.perform(
                post("/patient/{patientId}/anamnesis/save", 1)
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .content(
                                Util.convertObjectToFormUrlEncodedBytes(anamnesis))
                        .sessionAttr("anamnesis", anamnesis))
                .andExpect(status().isOk())
                .andExpect(view().name("patient/anamnesis/formView"))
                .andExpect(model().attributeHasFieldErrors("anamnesis", "date"))
                .andExpect(
                        model().attributeHasFieldErrors("anamnesis",
                                "beginningEpilepsy"))
                .andExpect(
                        model().attributeHasFieldErrors("anamnesis",
                                "nonCnsComorbidity"));

        verifyZeroInteractions(anamnesisServiceMock);
    }

//	@Test
//	public void anamnesisDeleteGET() throws Exception {
//		AnamnesisEntity anamnesis = new AnamnesisEntity();
//		anamnesis.setId(1);
//
//		mockMvc.perform(
//				get("/patient/{patientID}/anamnesis/{anamnesisId}/delete", 1, anamnesis.getId()))
//				.andExpect(status().isMovedTemporarily())
//				.andExpect(view().name("redirect:/patient/1/anamnesis/list"));
//
//		verify(anamnesisServiceMock, times(1)).delete(anamnesis);
//		verifyNoMoreInteractions(anamnesisServiceMock);
//	}

    @Test
    public void anamnesisEditGET() throws Exception {
        PatientDisplayVO patient = new PatientDisplayVO();
        patient.setId(1);

        AnamnesisVO anamnesis = new AnamnesisVO();
        anamnesis.setId(1);

        when(patientServiceMock.getPatientDisplayByIdWithDoctor(1)).thenReturn(patient);
        when(anamnesisServiceMock.getById(AnamnesisVO.class,AnamnesisEntity.class, 1)).thenReturn(anamnesis);

        mockMvc.perform(get("/patient/{patientId}/anamnesis/{anamnesisId}/edit", 1, 1))
                .andExpect(status().isOk())
                .andExpect(view().name("patient/anamnesis/formView"))
                .andExpect(
                        model().attribute("patient", isA(PatientDisplayVO.class)))
                .andExpect(
                        model().attribute("anamnesis",
                                isA(AnamnesisVO.class)));

        verify(patientServiceMock, times(1)).getPatientDisplayByIdWithDoctor(1);
        verifyNoMoreInteractions(patientServiceMock);

        verify(anamnesisServiceMock, times(1)).getById(AnamnesisVO.class,AnamnesisEntity.class, 1);
        verifyNoMoreInteractions(anamnesisServiceMock);
    }

    @Test
    public void anamnesisEditPOST_AnamnesisEntityValid() throws Exception {

        AnamnesisVO anamnesis = new AnamnesisVO();
        anamnesis.setDate(new Date());
        anamnesis.setBeginningEpilepsy(new Date());

        mockMvc.perform(
                post("/patient/{patientId}/anamnesis/save", 1)
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .content(
                                Util.convertObjectToFormUrlEncodedBytes(anamnesis))
                        .sessionAttr("anamnesis", anamnesis))
                .andExpect(model().attributeHasNoErrors("anamnesis"))
                .andExpect(status().isMovedTemporarily())
                .andExpect(view().name("redirect:/patient/1/anamnesis/list"));

        verify(anamnesisServiceMock, times(1)).save(AnamnesisEntity.class,anamnesis);
        verifyNoMoreInteractions(anamnesisServiceMock);
    }

    @Test
    public void anamnesisEditPOST_AnamnesisEntityNotValid() throws Exception {
        String nonCnsComorbidity = Util.createStringWithLength(900);

        LocalDate now = new LocalDate();
        LocalDate date = now.plusDays(1);
        Date tomorrow = date.toDate();

        AnamnesisVO anamnesis = new AnamnesisVO();
        anamnesis.setNonCnsComorbidity(nonCnsComorbidity);
        anamnesis.setDate(tomorrow);
        anamnesis.setBeginningEpilepsy(tomorrow);

        mockMvc.perform(
                post("/patient/{patientId}/anamnesis/save", 1)
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .content(
                                Util.convertObjectToFormUrlEncodedBytes(anamnesis))
                        .sessionAttr("anamnesis", anamnesis))
                .andExpect(status().isOk())
                .andExpect(view().name("patient/anamnesis/formView"))
                .andExpect(model().attributeHasFieldErrors("anamnesis", "date"))
                .andExpect(
                        model().attributeHasFieldErrors("anamnesis",
                                "beginningEpilepsy"))
                .andExpect(
                        model().attributeHasFieldErrors("anamnesis",
                                "nonCnsComorbidity"));

        verifyZeroInteractions(anamnesisServiceMock);
    }

    // anamnesisHideGET
    // anamnesisUnhideGET

    @Test
    public void list_PatientEntityFound() throws Exception {
        PatientDisplayVO found = new PatientDisplayVO();
        found.setId(1);

        when(patientServiceMock.getPatientDisplayByIdWithAnamnesisList(1)).thenReturn(
                found);

        mockMvc.perform(get("/patient/{patientId}/anamnesis/list", 1))
                .andExpect(status().isOk())
                .andExpect(view().name("patient/anamnesis/listView"))
                .andExpect(
                        model().attribute("patient", isA(PatientDisplayVO.class)));

        verify(patientServiceMock, times(1)).getPatientDisplayByIdWithAnamnesisList(1);
        verifyNoMoreInteractions(patientServiceMock);
    }

	/*
     * @Test public void list_PatientEntityNotFound() throws Exception {
	 * when(patientServiceMock.findByID(PatientEntity.class, 1)).thenReturn(
	 * null);
	 * 
	 * mockMvc.perform(get("/patient/{patientID}/anamnesis/list", 1))
	 * .andExpect(status().isNotFound()) .andExpect(view().name("error/404"))
	 * .andExpect(forwardedUrl("/WEB-INF/jsp/error/404.jsp"));
	 * 
	 * verify(patientServiceMock, times(1)).findByID(PatientEntity.class, 1);
	 * verifyZeroInteractions(anamnesisServiceMock); }
	 */

}
