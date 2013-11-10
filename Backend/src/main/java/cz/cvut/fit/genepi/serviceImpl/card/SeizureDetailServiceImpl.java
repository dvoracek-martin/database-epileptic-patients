package cz.cvut.fit.genepi.serviceImpl.card;

import java.io.Serializable;

import org.springframework.stereotype.Service;

import cz.cvut.fit.genepi.entity.card.SeizureDetailEntity;
import cz.cvut.fit.genepi.service.card.SeizureDetailService;
import cz.cvut.fit.genepi.serviceImpl.GenericServiceImpl;

@Service
public class SeizureDetailServiceImpl extends
		GenericServiceImpl<SeizureDetailEntity, Serializable> implements
		SeizureDetailService {

}
