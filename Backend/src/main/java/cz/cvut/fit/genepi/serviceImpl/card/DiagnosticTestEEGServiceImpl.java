package cz.cvut.fit.genepi.serviceImpl.card;

import java.io.Serializable;

import org.springframework.stereotype.Service;

import cz.cvut.fit.genepi.entity.card.DiagnosticTestEEGEntity;
import cz.cvut.fit.genepi.service.card.DiagnosticTestEEGService;
import cz.cvut.fit.genepi.serviceImpl.GenericServiceImpl;

@Service
public class DiagnosticTestEEGServiceImpl  extends
GenericServiceImpl<DiagnosticTestEEGEntity, Serializable> implements
DiagnosticTestEEGService {
}
