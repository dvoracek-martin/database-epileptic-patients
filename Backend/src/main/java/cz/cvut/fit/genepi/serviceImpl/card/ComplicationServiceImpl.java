package cz.cvut.fit.genepi.serviceImpl.card;

import java.io.Serializable;

import org.springframework.stereotype.Service;

import cz.cvut.fit.genepi.entity.card.ComplicationEntity;
import cz.cvut.fit.genepi.service.card.ComplicationService;
import cz.cvut.fit.genepi.serviceImpl.GenericServiceImpl;

@Service
public class ComplicationServiceImpl  extends
GenericServiceImpl<ComplicationEntity, Serializable> implements
ComplicationService {
}