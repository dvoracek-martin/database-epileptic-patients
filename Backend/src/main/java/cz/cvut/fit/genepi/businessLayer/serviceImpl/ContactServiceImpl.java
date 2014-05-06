package cz.cvut.fit.genepi.businessLayer.serviceImpl;

import cz.cvut.fit.genepi.businessLayer.BO.form.ContactFormBO;
import cz.cvut.fit.genepi.businessLayer.service.ContactService;
import cz.cvut.fit.genepi.dataLayer.entity.ContactEntity;
import org.springframework.stereotype.Service;

/**
 * The Class ContactServiceImpl.
 */
@Service
public class ContactServiceImpl extends
        GenericServiceImpl<ContactFormBO, ContactEntity> implements
        ContactService {

}
