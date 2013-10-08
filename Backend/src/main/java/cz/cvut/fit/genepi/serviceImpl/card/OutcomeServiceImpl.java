package cz.cvut.fit.genepi.serviceImpl.card;

import java.io.Serializable;

import org.springframework.stereotype.Service;

import cz.cvut.fit.genepi.entity.card.OutcomeEntity;
import cz.cvut.fit.genepi.service.card.OutcomeService;
import cz.cvut.fit.genepi.serviceImpl.GenericServiceImpl;

@Service
public class OutcomeServiceImpl  extends
GenericServiceImpl<OutcomeEntity, Serializable> implements
OutcomeService {
}
