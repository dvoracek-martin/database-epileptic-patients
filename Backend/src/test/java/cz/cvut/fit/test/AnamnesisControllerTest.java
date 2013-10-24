package cz.cvut.fit.test;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

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

import cz.cvut.fit.genepi.controller.card.AnamnesisController;
import cz.cvut.fit.genepi.entity.PatientEntity;
import cz.cvut.fit.genepi.entity.card.AnamnesisEntity;
import cz.cvut.fit.genepi.service.PatientService;
import cz.cvut.fit.genepi.service.RoleService;
import cz.cvut.fit.genepi.service.card.AnamnesisService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:anamnesisControllerTestContext.xml" })
@WebAppConfiguration
public class AnamnesisControllerTest {

	private MockMvc mockMvc;

	@Autowired
	@Qualifier("patientService")
	private PatientService patientServiceMock;

	@Autowired
	@Qualifier("anamnesisService")
	private AnamnesisService anamnesisServiceMock;

	@Autowired
	@Qualifier("roleService")
	private RoleService roleServiceMock;

	// Add WebApplicationContext field here
	@Autowired
	private WebApplicationContext webApplicationContext;

	// The setUp() method is omitted.
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(
				new AnamnesisController(patientServiceMock,
						anamnesisServiceMock, roleServiceMock)).build();
	}
	
	@After
	public void reset_mocks() {
		reset(patientServiceMock);
	    reset(anamnesisServiceMock);
	    reset(roleServiceMock);
	}

	@Test
	public void list_PatientEntityFound() throws Exception {
		PatientEntity found = new PatientEntity();
		found.setId(1);

		when(patientServiceMock.getPatientByIdWithAnamnesisList(1)).thenReturn(
				found);

		mockMvc.perform(get("/patient/{patientID}/anamnesis/list", 1))
				.andExpect(status().isOk())
				.andExpect(view().name("patient/anamnesis/listView"))
				.andExpect(
						model().attribute("patient", is(PatientEntity.class)));

		verify(patientServiceMock, times(1)).getPatientByIdWithAnamnesisList(1);
		verifyNoMoreInteractions(patientServiceMock);
	}

	/*@Test
	public void list_PatientEntityNotFound() throws Exception {
		when(patientServiceMock.findByID(PatientEntity.class, 1)).thenReturn(
				null);

		mockMvc.perform(get("/patient/{patientID}/anamnesis/list", 1))
				.andExpect(status().isNotFound())
				.andExpect(view().name("error/404"))
				.andExpect(forwardedUrl("/WEB-INF/jsp/error/404.jsp"));

		verify(patientServiceMock, times(1)).findByID(PatientEntity.class, 1);
		verifyZeroInteractions(anamnesisServiceMock);
	}*/

	@Test
	public void create_AnamnesisEntityNotValid() throws Exception {
		String nonCnsComorbidity = Util.createStringWithLength(500);

		AnamnesisEntity anamnesis = new AnamnesisEntity();
		anamnesis.setNonCnsComorbidity(nonCnsComorbidity);

		mockMvc.perform(
				post("/patient/{patientID}/anamnesis/create", 1)
						.contentType(MediaType.APPLICATION_FORM_URLENCODED)
						.content(
								Util.convertObjectToFormUrlEncodedBytes(anamnesis))
						.sessionAttr("anamnesis", anamnesis))
				.andExpect(status().isOk())
				.andExpect(view().name("patient/anamnesis/createView"))
				.andExpect(model().attributeHasFieldErrors("anamnesis", "date"));
		verifyZeroInteractions(anamnesisServiceMock);
	}

	// FIXME: set all properties which has validation. Anamnesis which is saved
	// and tested is different by Hashcode, dunno why
	/*
	 * @Test public void create_AnamnesisEntityValid() throws Exception {
	 * 
	 * AnamnesisEntity anamnesis = new AnamnesisEntity();
	 * anamnesis.setNonCnsComorbidity("nonCnsComorbidity");
	 * 
	 * mockMvc.perform( post("/patient/{patientID}/anamnesis/create", 1)
	 * .contentType(MediaType.APPLICATION_FORM_URLENCODED) .content(
	 * TestUtil.convertObjectToFormUrlEncodedBytes(anamnesis))
	 * .sessionAttr("anamnesis", anamnesis))
	 * .andExpect(status().isMovedTemporarily())
	 * .andExpect(view().name("redirect:/patient/1/anamnesis/list"))
	 * .andExpect(redirectedUrl("/patient/1/anamnesis/list"));
	 * 
	 * verify(anamnesisServiceMock, times(1)).save(anamnesis);
	 * verifyNoMoreInteractions(anamnesisServiceMock); }
	 */
}
