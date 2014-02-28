package cz.cvut.fit.genepi.businessLayer.serviceImpl;

import cz.cvut.fit.genepi.businessLayer.service.AnonymizeService;
import cz.cvut.fit.genepi.dataLayer.entity.ContactEntity;
import cz.cvut.fit.genepi.dataLayer.entity.PatientEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Jan on 28.2.14.
 */
@Service
public class AnonymizeServiceImpl implements AnonymizeService {

    public void anonymizePatients(List<PatientEntity> patients) {
        ContactEntity anonymizedContact = new ContactEntity();
        anonymizedContact.setAddressCity("****");
        anonymizedContact.setLastName("****");
        anonymizedContact.setAddressCountry("****");
        anonymizedContact.setAddressHn("****");
        anonymizedContact.setAddressPostalcode("****");
        anonymizedContact.setAddressStreet("****");
        anonymizedContact.setEmail("****");
        anonymizedContact.setFirstName("****");
        anonymizedContact.setPhoneNumber("****");

        for (PatientEntity patient : patients) {
          patient.setContact(anonymizedContact);
            patient.setNin("****");
        }
    }
}
