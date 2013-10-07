package cz.cvut.fit.genepi.serviceImpl.card;

import java.io.Serializable;

import org.springframework.stereotype.Service;

import cz.cvut.fit.genepi.entity.card.HistologyEntity;
import cz.cvut.fit.genepi.service.card.HistologyService;
import cz.cvut.fit.genepi.serviceImpl.GenericServiceImpl;

@Service
public class HistologyServiceImpl  extends
GenericServiceImpl<HistologyEntity, Serializable> implements
HistologyService {
}
