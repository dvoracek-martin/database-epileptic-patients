package cz.cvut.fit.genepi.serviceImpl.card;

import org.springframework.stereotype.Service;

import cz.cvut.fit.genepi.entity.card.OperationEntity;
import cz.cvut.fit.genepi.service.card.OperationService;
import cz.cvut.fit.genepi.serviceImpl.GenericServiceImpl;

@Service
public class OperationServiceImpl  extends
GenericServiceImpl<OperationEntity> implements
OperationService {
}
