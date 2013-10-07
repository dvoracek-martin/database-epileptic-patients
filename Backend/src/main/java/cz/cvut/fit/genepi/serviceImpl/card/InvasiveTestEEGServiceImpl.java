package cz.cvut.fit.genepi.serviceImpl.card;

import java.io.Serializable;

import org.springframework.stereotype.Service;

import cz.cvut.fit.genepi.entity.card.InvasiveTestEEGEntity;
import cz.cvut.fit.genepi.service.card.InvasiveTestEEGService;
import cz.cvut.fit.genepi.serviceImpl.GenericServiceImpl;

@Service
public class InvasiveTestEEGServiceImpl  extends
GenericServiceImpl<InvasiveTestEEGEntity, Serializable> implements
InvasiveTestEEGService {
}
