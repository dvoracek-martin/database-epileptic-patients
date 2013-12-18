package cz.cvut.fit.genepi.util;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import cz.cvut.fit.genepi.businessLayer.service.PatientService;
import cz.cvut.fit.genepi.dataLayer.entity.PatientEntity;

public class JSONEncoder {
	@Autowired
	private PatientService patientService;
	
	@SuppressWarnings("unchecked")
	public  String encode(List<PatientEntity> patientList,
			int maxResults, int pageNumber) {
		JSONArray patientListJSON = new JSONArray();

		for (PatientEntity patient : patientList) {
			JSONArray patientInfoJSON = new JSONArray();
			JSONObject patientContactInfoJSON = new JSONObject();
			patientContactInfoJSON.put("patientID", patient.getContact()
					.getId());
			patientContactInfoJSON.put("patientLastName", patient.getContact()
					.getLastName());
			patientContactInfoJSON.put("patientFirstName", patient.getContact()
					.getFirstName());
			patientContactInfoJSON.put("nin", patient.getNin());
			patientContactInfoJSON.put("addressCity", patient.getContact()
					.getAddressCity());
			patientContactInfoJSON.put("addressStreet", patient.getContact()
					.getAddressStreet());
			patientContactInfoJSON.put("addressHn", patient.getContact()
					.getAddressHn());
			patientInfoJSON.add(patientContactInfoJSON);

			patientListJSON.add(patientInfoJSON);
		}

		JSONObject obj = new JSONObject();
		obj.put("patientList", patientListJSON);

		System.out.println(obj);
		StringWriter out = new StringWriter();
		try {
			obj.writeJSONString(out);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String jsonText = out.toString();

		return jsonText;
	}
}
