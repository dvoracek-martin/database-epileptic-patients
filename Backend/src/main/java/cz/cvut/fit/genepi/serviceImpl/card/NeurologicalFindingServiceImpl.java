package cz.cvut.fit.genepi.serviceImpl.card;

import java.io.Serializable;

import org.springframework.stereotype.Service;

import cz.cvut.fit.genepi.entity.card.NeurologicalFindingEntity;
import cz.cvut.fit.genepi.service.card.NeurologicalFindingService;
import cz.cvut.fit.genepi.serviceImpl.GenericServiceImpl;

@Service
public class NeurologicalFindingServiceImpl  extends
GenericServiceImpl<NeurologicalFindingEntity, Serializable> implements
NeurologicalFindingService {
}
