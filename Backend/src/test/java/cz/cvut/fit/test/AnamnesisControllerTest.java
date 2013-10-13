package cz.cvut.fit.test;

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
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:anamnesisControllerTestContext.xml",
		"file:src/main/webapp/WEB-INF/applicationContext.xml" })
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

	@Test
	public void findByID_PatientEntityFound() throws Exception {
		PatientEntity found = new PatientEntity();
		found.setId(1);

		when(patientServiceMock.findByID(PatientEntity.class, 1)).thenReturn(
				found);

		mockMvc.perform(get("/patient/{patientID}/anamnesis/list", 1))
				.andExpect(status().isOk())
				.andExpect(view().name("patient/anamnesis/listView"))

				/*
				 * .andExpect(
				 * forwardedUrl("/WEB-INF/views/patient/anamnesis/listView.jsp"
				 * ))
				 */
				.andExpect(
						model().attribute("patient", is(PatientEntity.class)));

		verify(patientServiceMock, times(1)).findByID(PatientEntity.class, 1);
		verifyNoMoreInteractions(patientServiceMock);
	}

	/*
	 * @Test public void FindByID_PatientEntityNotFound() throws Exception {
	 * when(patientServiceMock.findByID(PatientEntity.class, 1)).thenThrow( new
	 * Exception());
	 * 
	 * mockMvc.perform(get("/patient/{patientID}/anamnesis/list", 1))
	 * .andExpect(status().isNotFound()) .andExpect(view().name("error/404"))
	 * .andExpect(forwardedUrl("/WEB-INF/jsp/error/404.jsp"));
	 * 
	 * verify(patientServiceMock, times(1)).findByID(PatientEntity.class, 1);
	 * verifyZeroInteractions(anamnesisServiceMock); }
	 */

	@Test
	public void create_AnamnesisEntityNotValid() throws Exception {
		String nonCnsComorbidity = TestUtil.createStringWithLength(500);

		AnamnesisEntity anamnesis = new AnamnesisEntity();
		anamnesis.setNonCnsComorbidity(nonCnsComorbidity);

		mockMvc.perform(
				post("/patient/{patientID}/anamnesis/create", 1)
						.contentType(MediaType.APPLICATION_FORM_URLENCODED)
						.content(
								TestUtil.convertObjectToFormUrlEncodedBytes(anamnesis))
						.sessionAttr("anamnesis", anamnesis))
				.andExpect(status().isOk())
				.andExpect(view().name("patient/anamnesis/createView"))
		// .andExpect(forwardedUrl("/WEB-INF/jsp/todo/add.jsp"))
		// FIXME: no errors return
		/*
		 * .andExpect(model().attributeHasFieldErrors("anamnesis",
		 * "nonCnsComorbidity"))
		 */;

		verifyZeroInteractions(anamnesisServiceMock);
	}

	@Test
	public void create_AnamnesisEntityValid() throws Exception {

		AnamnesisEntity anamnesis = new AnamnesisEntity();
		anamnesis.setNonCnsComorbidity("nonCnsComorbidity");

		mockMvc.perform(
				post("/patient/{patientID}/anamnesis/create", 1)
						.contentType(MediaType.APPLICATION_FORM_URLENCODED)
						.content(
								TestUtil.convertObjectToFormUrlEncodedBytes(anamnesis))
						.sessionAttr("anamnesis", anamnesis))
				.andExpect(status().isMovedTemporarily())
				.andExpect(view().name("redirect:todo/{id}"))
				.andExpect(redirectedUrl("/todo/1"))
				.andExpect(model().attribute("id", is("1")))
				.andExpect(
						flash().attribute("feedbackMessage",
								is("Todo entry: title was added.")));

		verify(anamnesisServiceMock, times(1)).save(anamnesis);
		verifyNoMoreInteractions(anamnesisServiceMock);
	}
}
