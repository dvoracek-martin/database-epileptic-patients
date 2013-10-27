package cz.cvut.fit.genepi.serviceImpl;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.itextpdf.text.DocumentException;

import cz.cvut.fit.genepi.entity.PatientEntity;
import cz.cvut.fit.genepi.entity.UserEntity;
import cz.cvut.fit.genepi.service.ExportToCsvService;

@Service
public class ExportToCsvServiceImpl implements ExportToCsvService{

	@Override
	public void export(PatientEntity patient, UserEntity user,
			List<String> exports, List<String> listOfPossibleCards)
			throws FileNotFoundException, DocumentException {
		// TODO Auto-generated method stub
		
	}

}
