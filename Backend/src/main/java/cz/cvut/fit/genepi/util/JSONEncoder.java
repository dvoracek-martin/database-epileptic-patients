package cz.cvut.fit.genepi.util;

import cz.cvut.fit.genepi.businessLayer.BO.display.PatientDisplayBO;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

public class JSONEncoder {

    @SuppressWarnings("unchecked")
    public String encode(List<PatientDisplayBO> patientList, int patientsCount) {
        JSONArray patientListJSON = new JSONArray();

        for (PatientDisplayBO patient : patientList) {
            JSONArray patientInfoJSON = new JSONArray();
            JSONObject patientContactInfoJSON = new JSONObject();
            patientContactInfoJSON.put("patientID", patient.getId());
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
        obj.put("patientsCount", patientsCount);

        StringWriter out = new StringWriter();
        try {
            obj.writeJSONString(out);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return out.toString();
    }
}
