package cz.cvut.fit.genepi.businessLayer.serviceImpl;

import cz.cvut.fit.genepi.businessLayer.VO.display.ContactDisplayVO;
import cz.cvut.fit.genepi.businessLayer.VO.display.PatientDisplayVO;
import cz.cvut.fit.genepi.businessLayer.service.AnonymizeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnonymizeServiceImpl implements AnonymizeService {

    public void anonymizePatients(List<PatientDisplayVO> patients) {
        ContactDisplayVO anonymizedContact = new ContactDisplayVO();
        anonymizedContact.setAddressCity("****");
        anonymizedContact.setLastName("****");
        anonymizedContact.setAddressCountry("****");
        anonymizedContact.setAddressHn("****");
        anonymizedContact.setAddressPostalcode("****");
        anonymizedContact.setAddressStreet("****");
        anonymizedContact.setEmail("****");
        anonymizedContact.setFirstName("****");
        anonymizedContact.setPhoneNumber("****");

        for (PatientDisplayVO patient : patients) {
            patient.setContact(anonymizedContact);
            patient.setNin("****");
        }
    }
}
