package cz.cvut.fit.genepi.businessLayer.serviceImpl;


import cz.cvut.fit.genepi.businessLayer.service.ExportToCsvService;
import cz.cvut.fit.genepi.businessLayer.service.ExportToXlsxService;
import cz.cvut.fit.genepi.dataLayer.entity.ExportParamsEntity;
import cz.cvut.fit.genepi.dataLayer.entity.PatientEntity;
import cz.cvut.fit.genepi.dataLayer.entity.UserEntity;
import cz.cvut.fit.genepi.util.LoggingService;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Locale;

@Service
public class ExportToCsvServiceImpl implements ExportToCsvService {

    @Autowired
    private ExportToXlsxService exportToXlsService;

    /**
     * The Constant logger.
     */
    private LoggingService logger = new LoggingService();

    public String export(java.util.List<PatientEntity> patientList,
                         UserEntity user, Locale locale, ExportParamsEntity exportParams, boolean anonymize) {

        String name = exportToXlsService.export(patientList, user, locale, exportParams, anonymize).replace("xls", "csv");

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
                        "Couldn't create new file when trying to save csv file.",
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
                        "Couldn't create new file when trying to save csv file.",
                        e);
            }
        }

        exportCsv(downloadFolder + name.replace("csv", "xls"), downloadFolder + name);
        cleanup(downloadFolder + name.replace("csv", "xls"));
        return name;
    }

    /**
     * Converts xls to csv
     *
     * @param input
     * @param output
     */
    private void exportCsv(String input, String output) {
        try {
            BufferedWriter bw = new BufferedWriter
                    (new OutputStreamWriter(new FileOutputStream(output), "UTF-8"));

            WorkbookSettings ws = new WorkbookSettings();
            ws.setEncoding("Cp1252");

            Workbook w = Workbook.getWorkbook(new File(input), ws);

            // Gets the sheets from workbook
            for (int sheet = 0; sheet < w.getNumberOfSheets(); sheet++) {
                Sheet s = w.getSheet(sheet);

                bw.write(s.getName());
                bw.newLine();

                Cell[] row = null;

                for (int i = 0; i < s.getRows(); i++) {
                    row = s.getRow(i);

                    if (row.length > 0) {
                        bw.write(row[0].getContents());
                        for (int j = 1; j < row.length; j++) {
                            bw.write(',');
                            bw.write(row[j].getContents());
                        }
                    }
                    bw.newLine();
                }
            }
            bw.flush();
            bw.close();
        } catch (UnsupportedEncodingException e) {
            System.err.println(e.toString());
        } catch (IOException e) {
            System.err.println(e.toString());
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }


    /**
     * Deletes the original xls file
     *
     * @param input
     */
    private void cleanup(String input) {
        File f = new File(input);
        f.delete();
    }
}