package foo;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by THINK on 11/29/2017.
 */

//public class pdfFromXMLFile {
//    public static void main(String[] arg) {
//        String hi = "Hello World";
//        System.out.println(hi);
//    }
//}
//
//
public class Foo {
    public static void main(String[] args) throws JRException, IOException {
        // Compile jrxml file.
        JasperReport jasperReport = JasperCompileManager.compileReport("C:/Personal/LabExperiment/Develop_JasperReports/JasperSampleStylke/StyledTextReport.jrxml");

        // Parameters for report
        Map<String, Object> parameters = new HashMap<String, Object>();

        // DataSource
        // This is simple example, no database.
        // then using empty datasource.
        JRDataSource dataSource = new JREmptyDataSource();

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

        // Make sure the output directory exists.
        File outDir = new File("C:/Personal/LabExperiment/Develop_JasperReports/jasperoutput");
        outDir.mkdirs();

        // Export to PDF.
        JasperExportManager.exportReportToPdfFile(jasperPrint,"C:/Personal/LabExperiment/Develop_JasperReports/jasperoutput/StyledTextReport.pdf");
        System.out.println("Done!");
    }
}
