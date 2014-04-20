package cz.cvut.fit.genepi.businessLayer.serviceImpl;

import cz.cvut.fit.genepi.businessLayer.VO.form.ExportParamsVO;
import cz.cvut.fit.genepi.businessLayer.service.*;
import cz.cvut.fit.genepi.dataLayer.entity.ExportParamsEntity;
import cz.cvut.fit.genepi.dataLayer.entity.PatientEntity;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class ExportServiceImpl implements ExportService {

    @Autowired
    private PatientService patientService;

    @Autowired
    private ExportToPdfService exportToPdfService;

    @Autowired
    private ExportToXlsxService exportToXlsxService;

    @Autowired
    private ExportToDocxService exportToDocxService;

    @Autowired
    private ExportToTxtService exportToTxtService;

    @Autowired
    private ExportToCsvService exportToCsvService;

    @Autowired
    private UserService userService;

    @Autowired
    private Mapper dozer;

    @Override
    @Transactional
    public String performExport(ExportParamsVO exportParams, Locale locale, String exportType, boolean anonymize, List<Integer> patientIds, boolean toTable) {

        List<PatientEntity> patientList = new ArrayList<>();
        for (int patientId : patientIds) {
            patientList.add(patientService.getPatientDisplayByIdWithAllLists(patientId));
        }

        ExportParamsEntity exportParamsEntity = dozer.map(exportParams, ExportParamsEntity.class);
        Authentication auth = SecurityContextHolder.getContext()
                .getAuthentication();

        String url = null;

        /*
         * set all mandatory variables to true
         */
        exportParamsEntity.setPatient(true);
        exportParamsEntity.setPatientId(true);
        exportParamsEntity.setContactFirstName(true);
        exportParamsEntity.setContactLastName(true);
        exportParamsEntity.setPatientNin(true);
        exportParamsEntity.setPatientBirthday(true);
        exportParamsEntity.setPatientGender(true);
        exportParamsEntity.setContactCountry(true);
        exportParamsEntity.setContactAddressCity(true);
        exportParamsEntity.setContactAddressStreet(true);
        exportParamsEntity.setContactAddressHn(true);
        exportParamsEntity.setContactPhoneNumber(true);
        exportParamsEntity.setContactEmail(true);
        exportParamsEntity.setPatientAgeAtTheBeginningOfEpilepsy(true);


        switch (exportType) {
            case "pdf":
                try {
                    url = exportToPdfService.export(patientList,
                            userService.getUserByUsername(auth.getName()), locale,
                            exportParamsEntity, anonymize, toTable);

                } catch (FileNotFoundException e) {
              /*  logger.logError(
                        "File wasn't found when trying to export to pdf.", e);*/
                }
                break;
            case "xlsx":
                url = exportToXlsxService.export(patientList,
                        userService.getUserByUsername(auth.getName()), locale,
                        exportParamsEntity, anonymize);

                break;
            case "docx":
                url = exportToDocxService.export(patientList,
                        userService.getUserByUsername(auth.getName()), locale,
                        exportParamsEntity, anonymize, toTable);

                break;
            case "txt":
                url = exportToTxtService.export(patientList,
                        userService.getUserByUsername(auth.getName()), locale,
                        exportParamsEntity, anonymize);

                break;
            case "csv":
                url = exportToCsvService.export(patientList,
                        userService.getUserByUsername(auth.getName()), locale,
                        exportParamsEntity, anonymize);

                break;
        }
        return url;
    }

}
