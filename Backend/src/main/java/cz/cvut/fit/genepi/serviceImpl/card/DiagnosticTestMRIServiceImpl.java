package cz.cvut.fit.genepi.serviceImpl.card;

import java.io.Serializable;

import org.springframework.stereotype.Service;

import cz.cvut.fit.genepi.entity.card.DiagnosticTestMRIEntity;
import cz.cvut.fit.genepi.service.card.DiagnosticTestMRIService;
import cz.cvut.fit.genepi.serviceImpl.GenericServiceImpl;

@Service
public class DiagnosticTestMRIServiceImpl  extends
GenericServiceImpl<DiagnosticTestMRIEntity, Serializable> implements
DiagnosticTestMRIService {
}
