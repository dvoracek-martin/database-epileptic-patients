package cz.cvut.fit.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import cz.cvut.fit.genepi.controller.card.AnamnesisController;
import cz.cvut.fit.genepi.entity.PatientEntity;
import cz.cvut.fit.genepi.service.PatientService;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:anamnesisControllerTestContext.xml",
		"classpath:applicationContext.xml" })
@WebAppConfiguration
public class AnamnesisControllerTest {

	private MockMvc mockMvc;

	@Autowired
	@Qualifier("patientService")
	private PatientService patientServiceMock;

	// Add WebApplicationContext field here

	// The setUp() method is omitted.
    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new AnamnesisController(patientServiceMock))
                .build();
    }

	@Test
	public void findByID_AnamnesisEntityFound() throws Exception {
		PatientEntity found = new PatientEntity();
		found.setId(1);

		when(patientServiceMock.findByID(PatientEntity.class, 1)).thenReturn(found);

		mockMvc.perform(get("/patient/{patientID}/anamnesis/list", 1))
				.andExpect(status().isOk())
				.andExpect(view().name("patient/anamnesis/listView"))
				/*.andExpect(forwardedUrl("/WEB-INF/views/patient/anamnesis/listView.jsp"))
				.andExpect(model().attribute("todo", hasProperty("id", is(1L))))
				.andExpect(
						model().attribute("todo",
								hasProperty("description", is("Lorem ipsum"))))
				.andExpect(
						model().attribute("todo",
								hasProperty("title", is("Foo"))))*/;

		verify(patientServiceMock, times(1)).findByID(PatientEntity.class, 1);
		verifyNoMoreInteractions(patientServiceMock);
	}
}
