package cz.cvut.fit.genepi.businessLayer.serviceImpl.card;

import cz.cvut.fit.genepi.businessLayer.BO.display.card.PharmacotherapyDisplayBO;
import cz.cvut.fit.genepi.businessLayer.BO.form.card.PharmacotherapyFormBO;
import cz.cvut.fit.genepi.businessLayer.service.card.PharmacotherapyService;
import cz.cvut.fit.genepi.dataLayer.entity.card.PharmacotherapyEntity;
import org.springframework.stereotype.Service;

@Service
public class PharmacotherapyServiceImpl
        extends GenericCardServiceImpl<PharmacotherapyDisplayBO, PharmacotherapyFormBO, PharmacotherapyEntity>
        implements PharmacotherapyService {

}
