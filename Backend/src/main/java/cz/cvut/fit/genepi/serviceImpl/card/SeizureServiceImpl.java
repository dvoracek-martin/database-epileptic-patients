package cz.cvut.fit.genepi.serviceImpl.card;

import java.io.Serializable;

import org.springframework.stereotype.Service;

import cz.cvut.fit.genepi.entity.card.SeizureEntity;
import cz.cvut.fit.genepi.service.card.SeizureService;
import cz.cvut.fit.genepi.serviceImpl.GenericServiceImpl;

@Service
public class SeizureServiceImpl  extends
GenericServiceImpl<SeizureEntity, Serializable> implements
SeizureService {
}
