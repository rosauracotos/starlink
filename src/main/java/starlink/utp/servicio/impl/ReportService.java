package starlink.utp.servicio.impl;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Map;

@Service
public class ReportService {

    @Autowired
    private DataSource dataSource;

    public byte[] generateReport(String reportName, Map<String, Object> parameters) throws JRException {
        // Cargar el archivo .jrxml desde el classpath
        InputStream reportStream = getClass().getResourceAsStream("/reports/" + reportName + ".jrxml");

        // Compilar el archivo .jrxml
        JasperReport jasperReport = JasperCompileManager.compileReport(reportStream);

        // Obtener la conexión desde el DataSource
        try (Connection connection = DataSourceUtils.getConnection(dataSource)) {
            // Rellenar el reporte con la conexión a la base de datos
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, connection);

            // Exportar el reporte a un byte array (PDF en este caso)
            return JasperExportManager.exportReportToPdf(jasperPrint);
        } catch (Exception e) {
            throw new JRException("Error generating report", e);
        }
    }
}
