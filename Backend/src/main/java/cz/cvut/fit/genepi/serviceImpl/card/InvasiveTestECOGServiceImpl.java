package cz.cvut.fit.genepi.serviceImpl.card;

import java.io.Serializable;

import org.springframework.stereotype.Service;

import cz.cvut.fit.genepi.entity.card.InvasiveTestECOGEntity;
import cz.cvut.fit.genepi.service.card.InvasiveTestECOGService;
import cz.cvut.fit.genepi.serviceImpl.GenericServiceImpl;

@Service
public class InvasiveTestECOGServiceImpl  extends
GenericServiceImpl<InvasiveTestECOGEntity, Serializable> implements
InvasiveTestECOGService {
}
