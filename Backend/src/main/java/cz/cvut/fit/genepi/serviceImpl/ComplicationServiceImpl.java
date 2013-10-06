package cz.cvut.fit.genepi.serviceImpl;

import java.io.Serializable;

import org.springframework.stereotype.Service;

import cz.cvut.fit.genepi.entity.ComplicationEntity;
import cz.cvut.fit.genepi.service.ComplicationService;

@Service
public class ComplicationServiceImpl  extends
GenericServiceImpl<ComplicationEntity, Serializable> implements
ComplicationService {
}
