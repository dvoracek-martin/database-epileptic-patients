package cz.cvut.fit.genepi.serviceImpl.card;

import java.io.Serializable;

import org.springframework.stereotype.Service;

import cz.cvut.fit.genepi.entity.card.DiagnosticTestScalpEEGEntity;
import cz.cvut.fit.genepi.service.card.DiagnosticTestScalpEEGService;
import cz.cvut.fit.genepi.serviceImpl.GenericServiceImpl;

@Service
public class DiagnosticTestScalpEEGServiceImpl  extends
GenericServiceImpl<DiagnosticTestScalpEEGEntity, Serializable> implements
DiagnosticTestScalpEEGService {
}
