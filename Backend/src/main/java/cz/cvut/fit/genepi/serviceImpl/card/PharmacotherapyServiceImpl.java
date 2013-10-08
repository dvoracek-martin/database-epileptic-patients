package cz.cvut.fit.genepi.serviceImpl.card;

import java.io.Serializable;

import org.springframework.stereotype.Service;

import cz.cvut.fit.genepi.entity.card.PharmacotherapyEntity;
import cz.cvut.fit.genepi.service.card.PharmacotherapyService;
import cz.cvut.fit.genepi.serviceImpl.GenericServiceImpl;

@Service
public class PharmacotherapyServiceImpl  extends
GenericServiceImpl<PharmacotherapyEntity, Serializable> implements
PharmacotherapyService {
}
