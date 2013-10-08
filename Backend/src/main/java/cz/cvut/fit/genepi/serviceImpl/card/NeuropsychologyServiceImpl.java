package cz.cvut.fit.genepi.serviceImpl.card;

import java.io.Serializable;

import org.springframework.stereotype.Service;

import cz.cvut.fit.genepi.entity.card.NeuropsychologyEntity;
import cz.cvut.fit.genepi.service.card.NeuropsychologyService;
import cz.cvut.fit.genepi.serviceImpl.GenericServiceImpl;

@Service
public class NeuropsychologyServiceImpl  extends
GenericServiceImpl<NeuropsychologyEntity, Serializable> implements
NeuropsychologyService {
}
