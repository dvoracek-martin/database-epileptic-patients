package cz.cvut.fit.genepi.businessLayer.serviceImpl;

import cz.cvut.fit.genepi.businessLayer.service.ExportToDocxService;
import cz.cvut.fit.genepi.businessLayer.service.ExportToPdfService;
import cz.cvut.fit.genepi.dataLayer.entity.ExportParamsEntity;
import cz.cvut.fit.genepi.dataLayer.entity.PatientEntity;
import cz.cvut.fit.genepi.dataLayer.entity.UserEntity;
import cz.cvut.fit.genepi.util.LoggingService;
import org.apache.poi.xwpf.converter.pdf.PdfConverter;
import org.apache.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Locale;

// TODO: Auto-generated Javadoc

/**
 * The Class ExportToPdfServiceImpl.
 * Export to pdf is done by creating docx and then converting this docx to pdf.
 * In the end the original docx file is deleted and only pdf file remains
 */
@Service
public class ExportToPdfServiceImpl implements ExportToPdfService {

    @Autowired
    private ExportToDocxService exportToDocxService;


    /**
     * The Constant logger.
     */
    private LoggingService logger = new LoggingService();

    /**
     * Creates pdf file and also a docx file that is source for the conversion to the pdf
     *
     * @param patientList  as List of PatientEntity
     * @param user         as UserEntity
     * @param locale       as Locale
     * @param exportParams as ExportParamsEntity
     * @param anonymize
     * @return
     */
    public String export(java.util.List<PatientEntity> patientList,
                         UserEntity user, Locale locale, ExportParamsEntity exportParams, boolean anonymize, boolean toTable) {
        logger.setLogger(ExportToPdfServiceImpl.class);

        String name = exportToDocxService.export(patientList, user, locale, exportParams, anonymize, toTable).replace("docx", "pdf");

        String downloadFolder = System.getProperty("user.home")
                + System.getProperty("file.separator") + "Download_Links"
                + System.getProperty("file.separator");
        File f = null;
        String os = System.getProperty("os.name").toLowerCase();
        if (os.indexOf("win") >= 0) {
            downloadFolder.replace("\\", "/");
            name = name.replace(":", "_");
            f = new File(downloadFolder + name);
            if (!f.getParentFile().exists())
                f.getParentFile().mkdirs();
            if (f.exists())
                f.delete();
            try {
                f.createNewFile();
            } catch (IOException e) {
                logger.logError(
                        "Couldn't create new file when trying to save pdf file.",
                        e);
            }

        } else {
            downloadFolder = "/usr/local/tomcat/webapps/GENEPI/resources/downloads/";

            f = new File(downloadFolder + name);
            if (!f.getParentFile().exists())
                f.getParentFile().mkdirs();
            if (f.exists())
                f.delete();
            try {
                f.createNewFile();
            } catch (IOException e) {
                logger.logError(
                        "Couldn't create new file when trying to save pdf file.",
                        e);
            }
        }
        exportPdf(downloadFolder + name.replace("pdf", "docx"), downloadFolder + name);
        cleanup(downloadFolder + name.replace("pdf", "docx"));
        return name;
    }

    /**
     * Transforms docx to pdf
     *
     * @param input
     * @param output
     */
    private void exportPdf(String input, String output) {
        InputStream in = null;
        try {
            in = new FileInputStream(new File(input));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        XWPFDocument document = null;
        try {
            document = new XWPFDocument(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        PdfOptions options = PdfOptions.create();
        OutputStream out = null;
        try {
            out = new FileOutputStream(new File(output));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            PdfConverter.getInstance().convert(document, out, options);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deletes the original docx file
     *
     * @param input
     */
    private void cleanup(String input) {
        File f = new File(input);
        f.delete();
    }
}
