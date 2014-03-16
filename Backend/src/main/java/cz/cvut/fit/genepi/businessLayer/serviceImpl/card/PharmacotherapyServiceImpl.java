package cz.cvut.fit.genepi.businessLayer.serviceImpl.card;

import cz.cvut.fit.genepi.businessLayer.VO.display.card.PharmacotherapyDisplayVO;
import cz.cvut.fit.genepi.businessLayer.VO.form.card.PharmacotherapyVO;
import cz.cvut.fit.genepi.businessLayer.service.card.PharmacotherapyService;
import cz.cvut.fit.genepi.dataLayer.entity.card.PharmacotherapyEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PharmacotherapyServiceImpl
        extends GenericCardServiceImpl<PharmacotherapyDisplayVO,PharmacotherapyVO, PharmacotherapyEntity>
        implements PharmacotherapyService {

}
