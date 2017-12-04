package foo;

/**
 * Created by THINK on 11/30/2017.
 */

    import net.sf.jasperreports.engine.JRDataSource;
    import net.sf.jasperreports.engine.JREmptyDataSource;
    import net.sf.jasperreports.engine.JRException;
    import net.sf.jasperreports.engine.JasperCompileManager;
    import net.sf.jasperreports.engine.JasperExportManager;
    import net.sf.jasperreports.engine.JasperFillManager;
    import net.sf.jasperreports.engine.JasperPrint;
    import net.sf.jasperreports.engine.JasperReport;
//    import net.sf.jasperreports.engine.export.JRPdfExporter;
    import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
    import net.sf.jasperreports.export.ExporterInput;
    import net.sf.jasperreports.export.OutputStreamExporterOutput;
    import net.sf.jasperreports.export.SimpleExporterInput;
    import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
//    import net.sf.jasperreports.export.SimplePdfExporterConfiguration;

    import net.sf.jasperreports.engine.export.JRXlsExporter;
    import net.sf.jasperreports.export.SimpleXlsExporterConfiguration;
    import net.sf.jasperreports.export.SimpleXlsxExporterConfiguration;


    import java.io.File;
    import java.io.IOException;
    import java.sql.Connection;
    import java.sql.SQLException;
    import java.util.HashMap;
    import java.util.Map;

    import DBConnection.ConnectionUtils;

/**
 * Created by THINK on 11/29/2017.
 */

public class xlsxFromXMLFile {
    public static void main(String[] args) throws JRException, ClassNotFoundException,SQLException {
        String reportSrcFile = "C:/Personal/LabExperiment/Develop_JasperReports/JasperSampleStylke/ProtelDesignv5.jrxml";

        // First, compile jrxml file.
        JasperReport jasperReport =    JasperCompileManager.compileReport(reportSrcFile);

        Connection conn = ConnectionUtils.getConnection();

        // Parameters for report
        Map<String, Object> parameters = new HashMap<String, Object>();

        JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, conn);

        // Make sure the output directory exists.
        File outDir = new File("C:/Personal/LabExperiment/Develop_JasperReports/jasperoutput");
        outDir.mkdirs();

        // PDF Exportor.
        JRXlsxExporter exporter = new JRXlsxExporter();

        ExporterInput exporterInput = new SimpleExporterInput(print);
        // ExporterInput
        exporter.setExporterInput(exporterInput);

        // ExporterOutput
        OutputStreamExporterOutput exporterOutput = new SimpleOutputStreamExporterOutput(
                "C:/Personal/LabExperiment/Develop_JasperReports/jasperoutput/FirstJasperReport.xlsx");
        // Output
        exporter.setExporterOutput(exporterOutput);

        //
        SimpleXlsxExporterConfiguration configuration = new SimpleXlsxExporterConfiguration ();
        exporter.setConfiguration(configuration);
        exporter.exportReport();

        System.out.print("Done!");
    }
}
