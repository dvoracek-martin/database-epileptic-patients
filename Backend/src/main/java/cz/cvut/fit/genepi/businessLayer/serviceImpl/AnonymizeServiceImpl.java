package cz.cvut.fit.genepi.businessLayer.serviceImpl;

import cz.cvut.fit.genepi.businessLayer.BO.display.ContactDisplayBO;
import cz.cvut.fit.genepi.businessLayer.BO.display.PatientDisplayBO;
import cz.cvut.fit.genepi.businessLayer.service.AnonymizeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnonymizeServiceImpl implements AnonymizeService {

    public void anonymizePatients(List<PatientDisplayBO> patients) {
        ContactDisplayBO anonymizedContact = new ContactDisplayBO();
        anonymizedContact.setAddressCity("****");
        anonymizedContact.setLastName("****");
        anonymizedContact.setAddressCountry("****");
        anonymizedContact.setAddressHn("****");
        anonymizedContact.setAddressPostalcode("****");
        anonymizedContact.setAddressStreet("****");
        anonymizedContact.setEmail("****");
        anonymizedContact.setFirstName("****");
        anonymizedContact.setPhoneNumber("****");

        for (PatientDisplayBO patient : patients) {
            patient.setContact(anonymizedContact);
            patient.setNin("****");
        }
    }
}
