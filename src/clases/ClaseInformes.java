/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;
import formatos.Clase;
import java.util.Map;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 * @author Jhon Lopez
 */
public class ClaseInformes {

    private Clase clase = new Clase();
    private ClaseInformacion informacion = new ClaseInformacion();
    private ClaseBaseDatos datos = new ClaseBaseDatos();

    public void formatoCondicion(Map parametros) {
        try {
            URL url = clase.getClass().getResource("FormatoCondicion.jasper");
            parametros.put("SUBREPORT_DIR", "" + clase.getClass().getResource(""));

            JasperReport reporte = (JasperReport) JRLoader.loadObject(url);
            JasperPrint imprimir = JasperFillManager.fillReport(reporte, parametros, ClaseBaseDatos.conexion);
            long aleatorio = ClaseInformacion.LongAletario();
            JasperExportManager.exportReportToPdfFile(imprimir, "observacion_" + aleatorio + ".pdf");

            File file = new File("observacion_" + aleatorio + ".pdf");
            if (file.getAbsoluteFile().exists()) {
                try {
                    Desktop.getDesktop().open(file);
                } catch (IOException ex) {
                    Logger.getLogger(ClaseInformes.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
            }
        } catch (JRException ex) {
            //Logger.getLogger(ClaseInformes.class.getName()).log(Level.SEVERE, null, ex);
            ClaseMensaje.error("ERROR AL MOMENTO DE REALIZAR LA ACCION\n" + ex);
        }
    }

    public void formatoCondicionContratos(Map parametros) {
        try {
            URL url = clase.getClass().getResource("FormatoCondicionContratos.jasper");
            parametros.put("SUBREPORT_DIR", "" + clase.getClass().getResource(""));

            JasperReport reporte = (JasperReport) JRLoader.loadObject(url);
            JasperPrint imprimir = JasperFillManager.fillReport(reporte, parametros, ClaseBaseDatos.conexion);
            long aleatorio = ClaseInformacion.LongAletario();
            JasperExportManager.exportReportToPdfFile(imprimir, "observacion_" + aleatorio + ".pdf");

            File file = new File("observacion_" + aleatorio + ".pdf");
            if (file.getAbsoluteFile().exists()) {
                try {
                    Desktop.getDesktop().open(file);
                } catch (IOException ex) {
                    Logger.getLogger(ClaseInformes.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
            }
        } catch (JRException ex) {
            //Logger.getLogger(ClaseInformes.class.getName()).log(Level.SEVERE, null, ex);
            ClaseMensaje.error("ERROR AL MOMENTO DE REALIZAR LA ACCION\n" + ex);
        }
    }

    public void formatoCondicionContratosDigitalizados(Map parametros) {
        try {
            URL url = clase.getClass().getResource("FormatoCondicionContratosDigitalizados.jasper");
            parametros.put("SUBREPORT_DIR", "" + clase.getClass().getResource(""));

            JasperReport reporte = (JasperReport) JRLoader.loadObject(url);
            JasperPrint imprimir = JasperFillManager.fillReport(reporte, parametros, ClaseBaseDatos.conexion);
            long aleatorio = ClaseInformacion.LongAletario();
            JasperExportManager.exportReportToPdfFile(imprimir, "observacion_" + aleatorio + ".pdf");

            File file = new File("observacion_" + aleatorio + ".pdf");
            if (file.getAbsoluteFile().exists()) {
                try {
                    Desktop.getDesktop().open(file);
                } catch (IOException ex) {
                    Logger.getLogger(ClaseInformes.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
            }
        } catch (JRException ex) {
            //Logger.getLogger(ClaseInformes.class.getName()).log(Level.SEVERE, null, ex);
            ClaseMensaje.error("ERROR AL MOMENTO DE REALIZAR LA ACCION\n" + ex);
        }
    }

    public void formatoCondicionCuentas(Map parametros) {
        try {

            URL url = clase.getClass().getResource("FormatoCondicionCuentas.jasper");
            parametros.put("SUBREPORT_DIR", "" + clase.getClass().getResource(""));

            JasperReport reporte = (JasperReport) JRLoader.loadObject(url);
            JasperPrint imprimir = JasperFillManager.fillReport(reporte, parametros, ClaseBaseDatos.conexion);
            long aleatorio = ClaseInformacion.LongAletario();
            JasperExportManager.exportReportToPdfFile(imprimir, "observacion_" + aleatorio + ".pdf");

            File file = new File("observacion_" + aleatorio + ".pdf");
            if (file.getAbsoluteFile().exists()) {
                try {
                    Desktop.getDesktop().open(file);
                } catch (IOException ex) {
                    Logger.getLogger(ClaseInformes.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
            }
        } catch (JRException ex) {
            //Logger.getLogger(ClaseInformes.class.getName()).log(Level.SEVERE, null, ex);
            ClaseMensaje.error("ERROR AL MOMENTO DE REALIZAR LA ACCION\n" + ex);
        }
    }

    public void formatoCumplido(Map parametros) {
        try {
            URL url = clase.getClass().getResource("FormatoCumplido.jasper");
            parametros.put("SUBREPORT_DIR", "" + clase.getClass().getResource(""));

            JasperReport reporte = (JasperReport) JRLoader.loadObject(url);
            JasperPrint imprimir = JasperFillManager.fillReport(reporte, parametros, ClaseBaseDatos.conexion);
            long aleatorio = ClaseInformacion.LongAletario();
            JasperExportManager.exportReportToPdfFile(imprimir, "cumplido_" + aleatorio + ".pdf");

            File file = new File("cumplido_" + aleatorio + ".pdf");
            if (file.getAbsoluteFile().exists()) {
                try {
                    Desktop.getDesktop().open(file);
                } catch (IOException ex) {
                    Logger.getLogger(ClaseInformes.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
            }
        } catch (JRException ex) {
            //Logger.getLogger(ClaseInformes.class.getName()).log(Level.SEVERE, null, ex);
            ClaseMensaje.error("ERROR AL MOMENTO DE REALIZAR LA ACCION\n" + ex);
        }
    }

    public void formatoResolucion(Map parametros) {
        try {
            URL url = clase.getClass().getResource("FormatoResolucion.jasper");
            parametros.put("SUBREPORT_DIR", "" + clase.getClass().getResource(""));

            JasperReport reporte = (JasperReport) JRLoader.loadObject(url);
            JasperPrint imprimir = JasperFillManager.fillReport(reporte, parametros, ClaseBaseDatos.conexion);
            long aleatorio = ClaseInformacion.LongAletario();
            JasperExportManager.exportReportToPdfFile(imprimir, "resolucion_" + aleatorio + ".pdf");

            File file = new File("resolucion_" + aleatorio + ".pdf");
            if (file.getAbsoluteFile().exists()) {
                try {
                    Desktop.getDesktop().open(file);
                } catch (IOException ex) {
                    Logger.getLogger(ClaseInformes.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
            }
        } catch (JRException ex) {
            //Logger.getLogger(ClaseInformes.class.getName()).log(Level.SEVERE, null, ex);
            ClaseMensaje.error("ERROR AL MOMENTO DE REALIZAR LA ACCION\n" + ex);
        }
    }

    public void formatoEntrega(Map parametros) {
        try {
            URL url = clase.getClass().getResource("FormatoEntrega.jasper");
            parametros.put("SUBREPORT_DIR", "" + clase.getClass().getResource(""));

            JasperReport reporte = (JasperReport) JRLoader.loadObject(url);
            JasperPrint imprimir = JasperFillManager.fillReport(reporte, parametros, ClaseBaseDatos.conexion);
            long aleatorio = ClaseInformacion.LongAletario();
            JasperExportManager.exportReportToPdfFile(imprimir, "entrega_" + aleatorio + ".pdf");

            File file = new File("entrega_" + aleatorio + ".pdf");
            if (file.getAbsoluteFile().exists()) {
                try {
                    Desktop.getDesktop().open(file);
                } catch (IOException ex) {
                    Logger.getLogger(ClaseInformes.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
            }
        } catch (JRException ex) {
            //Logger.getLogger(ClaseInformes.class.getName()).log(Level.SEVERE, null, ex);
            ClaseMensaje.error("ERROR AL MOMENTO DE REALIZAR LA ACCION\n" + ex);
        }
    }

    public void formatoComprobante(Map parametros) {
        try {
            URL url = clase.getClass().getResource("FormatoComprobante.jasper");
            parametros.put("SUBREPORT_DIR", "" + clase.getClass().getResource(""));

            JasperReport reporte = (JasperReport) JRLoader.loadObject(url);
            JasperPrint imprimir = JasperFillManager.fillReport(reporte, parametros, ClaseBaseDatos.conexion);
            long aleatorio = ClaseInformacion.LongAletario();
            JasperExportManager.exportReportToPdfFile(imprimir, "comprobante_" + aleatorio + ".pdf");

            File file = new File("comprobante_" + aleatorio + ".pdf");
            if (file.getAbsoluteFile().exists()) {
                try {
                    Desktop.getDesktop().open(file);
                } catch (IOException ex) {
                    Logger.getLogger(ClaseInformes.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
            }
        } catch (JRException ex) {
            //Logger.getLogger(ClaseInformes.class.getName()).log(Level.SEVERE, null, ex);
            ClaseMensaje.error("ERROR AL MOMENTO DE REALIZAR LA ACCION\n" + ex);
        }
    }

    public void formatoSolicitudOferta(Map parametros){
        try {
            URL url = clase.getClass().getResource("FormatoSolicitudoferta.jasper");
            parametros.put("SUBREPORT_DIR", "" + clase.getClass().getResource(""));

            JasperReport reporte = (JasperReport) JRLoader.loadObject(url);
            JasperPrint imprimir = JasperFillManager.fillReport(reporte, parametros, ClaseBaseDatos.conexion);
            long aleatorio = ClaseInformacion.LongAletario();
            JasperExportManager.exportReportToPdfFile(imprimir, "solicitudoferta_" + aleatorio + ".pdf");

            File file = new File("solicitudoferta_" + aleatorio + ".pdf");
            if (file.getAbsoluteFile().exists()) {
                try {
                    Desktop.getDesktop().open(file);
                } catch (IOException ex) {
                    Logger.getLogger(ClaseInformes.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
            }
        } catch (JRException ex) {
            //Logger.getLogger(ClaseInformes.class.getName()).log(Level.SEVERE, null, ex);
            ClaseMensaje.error("ERROR AL MOMENTO DE REALIZAR LA ACCION\n" + ex);
        }
    }

    public void formatoContrato(Map parametros) {
        try {
            parametros.put("SUBREPORT_DIR", "" + clase.getClass().getResource(""));
            parametros.put("isAnexoOrdenContractual", "-");

            //BORRAR
            List<String> keys = new ArrayList<String>(parametros.keySet());
            for (String key : keys) {
                System.out.println(key + ": " + parametros.get(key));
            }

            URL url;
            if (ClaseGeneral.contratos.getTipocontrato().equals("1: C1 Prestación de Servicios")
                    || ClaseGeneral.contratos.getTipocontrato().equals("2: C2 Consultoría")) {
                url = clase.getClass().getResource("OrdenContractualServicios.jasper");
            } else {
                url = clase.getClass().getResource("OrdenContractual.jasper");
            }

            System.out.println("PASA");

            JasperReport reporte = (JasperReport) JRLoader.loadObject(url);
            JasperPrint imprimir = JasperFillManager.fillReport(reporte, parametros, ClaseBaseDatos.conexion);
            long aleatorio = ClaseInformacion.LongAletario();
            JasperExportManager.exportReportToPdfFile(imprimir, "contrato_" + aleatorio + ".pdf");

            File file = new File("contrato_" + aleatorio + ".pdf");
            if (file.getAbsoluteFile().exists()) {
                try {
                    Desktop.getDesktop().open(file);
                } catch (IOException ex) {
                    Logger.getLogger(ClaseInformes.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
            }
        } catch (JRException ex) {
            //Logger.getLogger(ClaseInformes.class.getName()).log(Level.SEVERE, null, ex);
            ClaseMensaje.error("ERROR AL MOMENTO DE REALIZAR LA ACCION\n" + ex);
        }

        try {
            parametros.put("SUBREPORT_DIR", "" + clase.getClass().getResource(""));

            URL url;
            if (ClaseGeneral.contratos.getTipocontrato().equals("1: C1 Prestación de Servicios")
                    || ClaseGeneral.contratos.getTipocontrato().equals("2: C2 Consultoría")) {
                url = clase.getClass().getResource("OrdenContractualServiciosAtras.jasper");
            } else {
                url = clase.getClass().getResource("OrdenContractualAtras.jasper");
            }

            JasperReport reporte = (JasperReport) JRLoader.loadObject(url);
            JasperPrint imprimir = JasperFillManager.fillReport(reporte, parametros, ClaseBaseDatos.conexion);
            long aleatorio = ClaseInformacion.LongAletario();
            JasperExportManager.exportReportToPdfFile(imprimir, "contratoatras_" + aleatorio + ".pdf");

            File file = new File("contratoatras_" + aleatorio + ".pdf");
            if (file.getAbsoluteFile().exists()) {
                try {
                    Desktop.getDesktop().open(file);
                } catch (IOException ex) {
                    Logger.getLogger(ClaseInformes.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
            }
        } catch (JRException ex) {
            //Logger.getLogger(ClaseInformes.class.getName()).log(Level.SEVERE, null, ex);
            ClaseMensaje.error("ERROR AL MOMENTO DE REALIZAR LA ACCION\n" + ex);
        }
    }

    public void formatoInformeComprobantesNOREEMBOLSADOS(Map parametros) {
        try {
            URL url = clase.getClass().getResource("InformeComprobantes_NOREEMBOLSADOS.jasper");
            parametros.put("SUBREPORT_DIR", "" + clase.getClass().getResource(""));

            JasperReport reporte = (JasperReport) JRLoader.loadObject(url);
            JasperPrint imprimir = JasperFillManager.fillReport(reporte, parametros, ClaseBaseDatos.conexion);
            long aleatorio = ClaseInformacion.LongAletario();
            JasperExportManager.exportReportToPdfFile(imprimir, "InformeComprobantes_NOREEMBOLSADOS_" + aleatorio + ".pdf");

            File file = new File("InformeComprobantes_NOREEMBOLSADOS_" + aleatorio + ".pdf");
            if (file.getAbsoluteFile().exists()) {
                try {
                    Desktop.getDesktop().open(file);
                } catch (IOException ex) {
                    Logger.getLogger(ClaseInformes.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
            }
        } catch (JRException ex) {
            //Logger.getLogger(ClaseInformes.class.getName()).log(Level.SEVERE, null, ex);
            ClaseMensaje.error("ERROR AL MOMENTO DE REALIZAR LA ACCION\n" + ex);
        }
    }

    public void formatoInformeComprobanteCUENTAINTERNA(Map parametros) {
        try {
            URL url = clase.getClass().getResource("InformeComprobanteCUENTAINTERNA.jasper");
            parametros.put("SUBREPORT_DIR", "" + clase.getClass().getResource(""));

            JasperReport reporte = (JasperReport) JRLoader.loadObject(url);
            JasperPrint imprimir = JasperFillManager.fillReport(reporte, parametros, ClaseBaseDatos.conexion);
            long aleatorio = ClaseInformacion.LongAletario();
            JasperExportManager.exportReportToPdfFile(imprimir, "informecomprobanteCUENTAINTERNA_" + aleatorio + ".pdf");

            File file = new File("informecomprobanteCUENTAINTERNA_" + aleatorio + ".pdf");
            if (file.getAbsoluteFile().exists()) {
                try {
                    Desktop.getDesktop().open(file);
                } catch (IOException ex) {
                    Logger.getLogger(ClaseInformes.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
            }
        } catch (JRException ex) {
            //Logger.getLogger(ClaseInformes.class.getName()).log(Level.SEVERE, null, ex);
            ClaseMensaje.error("ERROR AL MOMENTO DE REALIZAR LA ACCION\n" + ex);
        }
    }

    public void formatoInformeComprobanteAGRUPADOCOMPROBANTE(Map parametros) {
        try {
            URL url = clase.getClass().getResource("InformeComprobanteAGRUPADOCOMPROBANTE.jasper");
            parametros.put("SUBREPORT_DIR", "" + clase.getClass().getResource(""));

            JasperReport reporte = (JasperReport) JRLoader.loadObject(url);
            JasperPrint imprimir = JasperFillManager.fillReport(reporte, parametros, ClaseBaseDatos.conexion);
            long aleatorio = ClaseInformacion.LongAletario();
            JasperExportManager.exportReportToPdfFile(imprimir, "informecomprobanteAGRUPADOCOMPROBANTE_" + aleatorio + ".pdf");

            File file = new File("informecomprobanteAGRUPADOCOMPROBANTE_" + aleatorio + ".pdf");
            if (file.getAbsoluteFile().exists()) {
                try {
                    Desktop.getDesktop().open(file);
                } catch (IOException ex) {
                    Logger.getLogger(ClaseInformes.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
            }
        } catch (JRException ex) {
            Logger.getLogger(ClaseInformes.class.getName()).log(Level.SEVERE, null, ex);
            ClaseMensaje.error("ERROR AL MOMENTO DE REALIZAR LA ACCION\n" + ex);
        }
    }

    public void formatoInformeCuentaCUENTAINTERNA(Map parametros) {
        try {
            URL url = clase.getClass().getResource("InformeCuentaCUENTAINTERNA.jasper");
            parametros.put("SUBREPORT_DIR", "" + clase.getClass().getResource(""));

            JasperReport reporte = (JasperReport) JRLoader.loadObject(url);
            JasperPrint imprimir = JasperFillManager.fillReport(reporte, parametros, ClaseBaseDatos.conexion);
            long aleatorio = ClaseInformacion.LongAletario();
            JasperExportManager.exportReportToPdfFile(imprimir, "informecuentaCUENTAINTERNA_" + aleatorio + ".pdf");

            File file = new File("informecuentaCUENTAINTERNA_" + aleatorio + ".pdf");
            if (file.getAbsoluteFile().exists()) {
                try {
                    Desktop.getDesktop().open(file);
                } catch (IOException ex) {
                    Logger.getLogger(ClaseInformes.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
            }
        } catch (JRException ex) {
            //Logger.getLogger(ClaseInformes.class.getName()).log(Level.SEVERE, null, ex);
            ClaseMensaje.error("ERROR AL MOMENTO DE REALIZAR LA ACCION\n" + ex);
        }
    }

    public void formatoInformeCuentaCUENTAINTERNA_SIN_SALDO_DESCRIPCION(Map parametros) {
        try {
            URL url = clase.getClass().getResource("InformeCuentaCUENTAINTERNA_SIN_SALDO_DESCRIPCION.jasper");
            parametros.put("SUBREPORT_DIR", "" + clase.getClass().getResource(""));

            JasperReport reporte = (JasperReport) JRLoader.loadObject(url);
            JasperPrint imprimir = JasperFillManager.fillReport(reporte, parametros, ClaseBaseDatos.conexion);
            long aleatorio = ClaseInformacion.LongAletario();
            JasperExportManager.exportReportToPdfFile(imprimir, "informecuentaCUENTAINTERNA_SIN_SALDO_DESCRIPCION_" + aleatorio + ".pdf");

            File file = new File("informecuentaCUENTAINTERNA_SIN_SALDO_DESCRIPCION_" + aleatorio + ".pdf");
            if (file.getAbsoluteFile().exists()) {
                try {
                    Desktop.getDesktop().open(file);
                } catch (IOException ex) {
                    Logger.getLogger(ClaseInformes.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
            }
        } catch (JRException ex) {
            //Logger.getLogger(ClaseInformes.class.getName()).log(Level.SEVERE, null, ex);
            ClaseMensaje.error("ERROR AL MOMENTO DE REALIZAR LA ACCION\n" + ex);
        }
    }

    public void formatoInformeCuentaCUENTAINTERNA_SIN_SALDO_EGRESO(Map parametros) {
        try {
            URL url = clase.getClass().getResource("InformeCuentaCUENTAINTERNA_SIN_SALDO_EGRESO.jasper");
            parametros.put("SUBREPORT_DIR", "" + clase.getClass().getResource(""));

            JasperReport reporte = (JasperReport) JRLoader.loadObject(url);
            JasperPrint imprimir = JasperFillManager.fillReport(reporte, parametros, ClaseBaseDatos.conexion);
            long aleatorio = ClaseInformacion.LongAletario();
            JasperExportManager.exportReportToPdfFile(imprimir, "informecuentaCUENTAINTERNA_SIN_SALDO_EGRESO_" + aleatorio + ".pdf");

            File file = new File("informecuentaCUENTAINTERNA_SIN_SALDO_EGRESO_" + aleatorio + ".pdf");
            if (file.getAbsoluteFile().exists()) {
                try {
                    Desktop.getDesktop().open(file);
                } catch (IOException ex) {
                    Logger.getLogger(ClaseInformes.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
            }
        } catch (JRException ex) {
            //Logger.getLogger(ClaseInformes.class.getName()).log(Level.SEVERE, null, ex);
            ClaseMensaje.error("ERROR AL MOMENTO DE REALIZAR LA ACCION\n" + ex);
        }
    }

    public void formatoInformeTotalComprobanteCUENTAINTERNA(Map parametros) {
        try {
            URL url = clase.getClass().getResource("InformeTotalComprobanteCUENTAINTERNA.jasper");
            parametros.put("SUBREPORT_DIR", "" + clase.getClass().getResource(""));

            JasperReport reporte = (JasperReport) JRLoader.loadObject(url);
            JasperPrint imprimir = JasperFillManager.fillReport(reporte, parametros, ClaseBaseDatos.conexion);
            long aleatorio = ClaseInformacion.LongAletario();
            JasperExportManager.exportReportToPdfFile(imprimir, "informetotalcomprobanteCUENTAINTERNA_" + aleatorio + ".pdf");

            File file = new File("informetotalcomprobanteCUENTAINTERNA_" + aleatorio + ".pdf");
            if (file.getAbsoluteFile().exists()) {
                try {
                    Desktop.getDesktop().open(file);
                } catch (IOException ex) {
                    Logger.getLogger(ClaseInformes.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
            }
        } catch (JRException ex) {
            //Logger.getLogger(ClaseInformes.class.getName()).log(Level.SEVERE, null, ex);
            ClaseMensaje.error("ERROR AL MOMENTO DE REALIZAR LA ACCION\n" + ex);
        }
    }

    public void formatoInformeTotalCuentaCUENTAINTERNA_SALDOSCAJA(Map parametros) {
        try {
            URL url = clase.getClass().getResource("InformeTotalCuentaCUENTAINTERNA_SALDOSCAJA.jasper");
            parametros.put("SUBREPORT_DIR", "" + clase.getClass().getResource(""));

            JasperReport reporte = (JasperReport) JRLoader.loadObject(url);
            JasperPrint imprimir = JasperFillManager.fillReport(reporte, parametros, ClaseBaseDatos.conexion);
            long aleatorio = ClaseInformacion.LongAletario();
            JasperExportManager.exportReportToPdfFile(imprimir, "informetotalcuentaCUENTAINTERNA_SALDOSCAJA_" + aleatorio + ".pdf");

            File file = new File("informetotalcuentaCUENTAINTERNA_SALDOSCAJA_" + aleatorio + ".pdf");
            if (file.getAbsoluteFile().exists()) {
                try {
                    Desktop.getDesktop().open(file);
                } catch (IOException ex) {
                    Logger.getLogger(ClaseInformes.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
            }
        } catch (JRException ex) {
            //Logger.getLogger(ClaseInformes.class.getName()).log(Level.SEVERE, null, ex);
            ClaseMensaje.error("ERROR AL MOMENTO DE REALIZAR LA ACCION\n" + ex);
        }
    }

    public void formatoInformeTotalCuentaCUENTAINTERNA_SALDOSCAJA_SUBGRUPOS(Map parametros) {
        try {
            URL url = clase.getClass().getResource("InformeTotalCuentaCUENTAINTERNA_SALDOSCAJA_SUBGRUPOS.jasper");
            parametros.put("SUBREPORT_DIR", "" + clase.getClass().getResource(""));

            JasperReport reporte = (JasperReport) JRLoader.loadObject(url);
            JasperPrint imprimir = JasperFillManager.fillReport(reporte, parametros, ClaseBaseDatos.conexion);
            long aleatorio = ClaseInformacion.LongAletario();
            JasperExportManager.exportReportToPdfFile(imprimir, "informetotalcuentaCUENTAINTERNA_SALDOSCAJA_SUBGRUPOS_" + aleatorio + ".pdf");

            File file = new File("informetotalcuentaCUENTAINTERNA_SALDOSCAJA_SUBGRUPOS_" + aleatorio + ".pdf");
            if (file.getAbsoluteFile().exists()) {
                try {
                    Desktop.getDesktop().open(file);
                } catch (IOException ex) {
                    Logger.getLogger(ClaseInformes.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
            }
        } catch (JRException ex) {
            //Logger.getLogger(ClaseInformes.class.getName()).log(Level.SEVERE, null, ex);
            ClaseMensaje.error("ERROR AL MOMENTO DE REALIZAR LA ACCION\n" + ex);
        }
    }

    public void formatoInformeTotalCuentaCUENTAINTERNA_TOTALINGRESOS(Map parametros) {
        try {
            URL url = clase.getClass().getResource("InformeTotalCuentaCUENTAINTERNA_TOTALINGRESOS.jasper");
            parametros.put("SUBREPORT_DIR", "" + clase.getClass().getResource(""));

            JasperReport reporte = (JasperReport) JRLoader.loadObject(url);
            JasperPrint imprimir = JasperFillManager.fillReport(reporte, parametros, ClaseBaseDatos.conexion);
            long aleatorio = ClaseInformacion.LongAletario();
            JasperExportManager.exportReportToPdfFile(imprimir, "informetotalcuentaCUENTAINTERNA_TOTALINGRESOS_" + aleatorio + ".pdf");

            File file = new File("informetotalcuentaCUENTAINTERNA_TOTALINGRESOS_" + aleatorio + ".pdf");
            if (file.getAbsoluteFile().exists()) {
                try {
                    Desktop.getDesktop().open(file);
                } catch (IOException ex) {
                    Logger.getLogger(ClaseInformes.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
            }
        } catch (JRException ex) {
            //Logger.getLogger(ClaseInformes.class.getName()).log(Level.SEVERE, null, ex);
            ClaseMensaje.error("ERROR AL MOMENTO DE REALIZAR LA ACCION\n" + ex);
        }
    }

    public void formatoInformeResumenEgresosReembolso(Map parametros) {
        try {
            URL url = clase.getClass().getResource("InformeResumenEgresos.jasper");
            parametros.put("SUBREPORT_DIR", "" + clase.getClass().getResource(""));

            JasperReport reporte = (JasperReport) JRLoader.loadObject(url);
            JasperPrint imprimir = JasperFillManager.fillReport(reporte, parametros, ClaseBaseDatos.conexion);
            long aleatorio = ClaseInformacion.LongAletario();
            JasperExportManager.exportReportToPdfFile(imprimir, "InformeResumenEgresos_" + aleatorio + ".pdf");

            File file = new File("InformeResumenEgresos_" + aleatorio + ".pdf");
            if (file.getAbsoluteFile().exists()) {
                try {
                    Desktop.getDesktop().open(file);
                } catch (IOException ex) {
                    Logger.getLogger(ClaseInformes.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
            }
        } catch (JRException ex) {
            //Logger.getLogger(ClaseInformes.class.getName()).log(Level.SEVERE, null, ex);
            ClaseMensaje.error("ERROR AL MOMENTO DE REALIZAR LA ACCION\n" + ex);
        }
    }

    public void formatoExportar(Date fechaInicio, Date fechaFinal) {
        try {
            long aleatorio = ClaseInformacion.LongAletario();
            String archivo = "archivo_" + aleatorio + ".txt";
            List<String> arreglo = new ArrayList<String>();

            String sql = "SELECT "
                    + "DISTINCT(CONTRATOS.CONTRATO) AS CONTRATO,"
                    + "CONTRATOS.TIPOCONTRATO AS TIPOCONTRATO,"
                    + "CONTRATOS.FECHAADJUDICACION AS FECHAADJUDICACION,"
                    + "CONTRATOS.OBJETO AS OBJETO,"
                    + "CONTRATOS.VALOR AS VALOR,"
                    + "FK_TERCERO.ID AS FK_TERCERO_ID,"
                    + "FK_TERCERO.NOMBRE AS FK_TERCERO_NOMBRE,"
                    + "FK_TERCERO.REGIMEN AS FK_TERCERO_REGIMEN,"
                    + "CONTRATOS.FECHASUSCRIPCION AS FECHASUSCRIPCION,"
                    + "FK_TERCEROINTERSUPER.ID AS FK_TERCEROINTERSUPER_ID,"
                    + "FK_TERCEROINTERSUPER.NOMBRE AS FK_TERCEROINTERSUPER_NOMBRE,"
                    + "CONTRATOS.TIPOVINCULACIONINTERSUPER AS TIPOVINCULACIONINTER,"
                    + "CONTRATOS.UNIDADDURACION AS UNIDADDURACION,"
                    + "CONTRATOS.PLAZO AS PLAZO,"
                    + "CONTRATOS.ANTICIPIO AS ANTICIPIO,"
                    + "CONTRATOS.FECHAINICIO AS FECHAINICIO,"
                    + "CONTRATOS.FECHATERMINACION AS FECHATERMINACION,"
                    + "CONTRATOS.MODALIDAD AS MODALIDAD,"
                    + "CONTRATOS.CAUSAL AS CAUSAL,"
                    + "CONTRATOS.FECHAADJUDICACION AS FECHAADJUDICACION,"
                    + "CONTRATOS.TIPOTERMINACION AS TIPOTERMINACION,"
                    + "CONTRATOS.DOCUMENTOTERMINACION AS DOCUMENTOTERMINACION,"
                    + "CONTRATOS.CODIGOPROYECTO AS CODIGOPROYECTO,"
                    + "CONTRATOS.CODIGOACTIVIDAD AS CODIGOACTIVIDAD,"
                    + "CONTRATOS.FECHAINICIALACTIVIDAD AS FECHAINICIALACTIVIDAD,"
                    + "CONTRATOS.FECHAFINALACTIVIDAD AS FECHAFINALACTIVIDAD,"
                    + "CONTRATOS.PORCENTAJEACTIVIDAD AS PORCENTAJEACTIVIDAD,"
                    + "CONTRATOS.TIPOACTAAVANCE AS TIPOACTAAVANCE,"
                    + "CONTRATOS.FECHAACTAAVANCE AS FECHAACTAAVANCE,"
                    + "CONTRATOS.PORCENTAJEAVANCE AS PORCENTAJEAVANCE,"
                    + "SOPORTESCONTRATOS_CD.NUMERO AS CERTIFICADO,"
                    + "SOPORTESCONTRATOS_RD.NUMERO AS REGISTRO "
                    + "FROM "
                    + "CONTRATOS CONTRATOS,"
                    + "TERCEROS FK_TERCERO,"
                    + "TERCEROS FK_TERCEROINTERSUPER,"
                    + "SOPORTESCONTRATOS SOPORTESCONTRATOS_CD,"
                    + "SOPORTESCONTRATOS SOPORTESCONTRATOS_RD "
                    + "WHERE "
                    + "CONTRATOS.FECHAINICIO BETWEEN ('" + ClaseInformacion.ConvertirFecha(fechaInicio) + "'::DATE) AND "
                    + "('" + ClaseInformacion.ConvertirFecha(fechaFinal) + "'::DATE) "
                    + "AND CONTRATOS.FKTERCERO = FK_TERCERO.ID || ' - ' || FK_TERCERO.NOMBRE "
                    + "AND CONTRATOS.FKTERCEROINTERSUPER = FK_TERCEROINTERSUPER.ID || ' - ' || FK_TERCEROINTERSUPER.NOMBRE "
                    + "AND CONTRATOS.CONTRATO = SOPORTESCONTRATOS_CD.FKCONTRATO "
                    + "AND SOPORTESCONTRATOS_CD.TIPO = 'Certificado' "
                    + "AND CONTRATOS.CONTRATO = SOPORTESCONTRATOS_RD.FKCONTRATO "
                    + "AND SOPORTESCONTRATOS_RD.TIPO = 'Registro'";
            try {
                datos.query(sql);
                String texto = "";
                while (ClaseBaseDatos.resultado.next()) {
                    texto = ClaseBaseDatos.resultado.getString("CONTRATO") + ";";
                    texto += "" + ";";
                    texto += ClaseBaseDatos.resultado.getString("TIPOCONTRATO") + ";";
                    texto += "" + ";";
                    texto += "" + ";";
                    texto += "" + ClaseBaseDatos.resultado.getDate("FECHAADJUDICACION") + ";";
                    texto += ClaseBaseDatos.resultado.getString("OBJETO") + ";";
                    texto += "" + ClaseBaseDatos.resultado.getLong("VALOR") + ";";
                    texto += ClaseBaseDatos.resultado.getString("FK_TERCERO_ID") + ";";
                    texto += "" + ";";
                    texto += ClaseBaseDatos.resultado.getString("FK_TERCERO_NOMBRE") + ";";
                    texto += ClaseBaseDatos.resultado.getString("FK_TERCERO_REGIMEN") + ";";
                    texto += "" + ClaseBaseDatos.resultado.getDate("FECHASUSCRIPCION") + ";";
                    texto += ClaseBaseDatos.resultado.getString("FK_TERCEROINTERSUPER_ID") + ";";
                    texto += ClaseBaseDatos.resultado.getString("FK_TERCEROINTERSUPER_NOMBRE") + ";";
                    texto += ClaseBaseDatos.resultado.getString("TIPOVINCULACIONINTER") + ";";
                    texto += ClaseBaseDatos.resultado.getString("PLAZO") + ";";
                    texto += ClaseBaseDatos.resultado.getString("UNIDADDURACION") + ";";
                    texto += ClaseBaseDatos.resultado.getString("ANTICIPIO") + ";";
                    texto += "" + ";";
                    texto += "" + ClaseBaseDatos.resultado.getDate("FECHAINICIO") + ";";
                    texto += "" + ClaseBaseDatos.resultado.getDate("FECHATERMINACION") + ";";
                    texto += "SI" + ";";
                    texto += "NO" + ";";
                    texto += "999999" + ";";
                    texto += ClaseBaseDatos.resultado.getString("CODIGOPROYECTO") + ";";
                    texto += ClaseBaseDatos.resultado.getString("CODIGOACTIVIDAD") + ";";
                    texto += "" + ClaseBaseDatos.resultado.getDate("FECHAINICIALACTIVIDAD") + ";";
                    texto += "" + ClaseBaseDatos.resultado.getString("FECHAFINALACTIVIDAD") + ";";
                    texto += ClaseBaseDatos.resultado.getString("PORCENTAJEACTIVIDAD") + ";";
                    texto += "999999" + ";";
                    texto += "999999" + ";";
                    texto += "999999" + ";";
                    texto += "999999" + ";";
                    texto += "999999" + ";";
                    texto += "999999" + ";";
                    texto += "999999" + ";";
                    texto += "999999" + ";";
                    texto += "999999" + ";";
                    texto += "999999" + ";";
                    texto += ClaseBaseDatos.resultado.getString("TIPOACTAAVANCE") + ";";
                    texto += "" + ClaseBaseDatos.resultado.getDate("FECHAACTAAVANCE") + ";";
                    texto += ClaseBaseDatos.resultado.getString("PORCENTAJEAVANCE") + ";";
                    texto += "999999" + ";";
                    texto += "999999" + ";";
                    texto += "999999" + ";";
                    texto += "999999" + ";";
                    texto += "999999" + ";";
                    texto += ClaseBaseDatos.resultado.getString("CERTIFICADO") + ";";
                    texto += ClaseBaseDatos.resultado.getString("REGISTRO") + ";";
                    texto = ClaseInformacion.CambiarAcentos(texto);

                    if (arreglo.size() > 0) {
                        if (!arreglo.get(arreglo.size() - 1).equals(texto)) {
                            arreglo.add(texto);
                        }
                    } else {
                        arreglo.add(texto);
                    }
                }

                ClaseGeneral.escribir.MetodoEscribir(arreglo, archivo);

                datos.query("SELECT "
                        + "ANEXOSCONTRATOS.DOCUMENTO AS DOCUMENTO,"
                        + "ANEXOSCONTRATOS.ARCHIVO AS ARCHIVO,"
                        + "CONTRATOS.CONTRATO AS CONTRATO,"
                        + "CONTRATOS.FECHASUSCRIPCION AS FECHASUSCRIPCION "
                        + "FROM "
                        + "ANEXOSCONTRATOS INNER JOIN CONTRATOS ON ANEXOSCONTRATOS.FKCONTRATO = CONTRATOS.CONTRATO "
                        + "WHERE "
                        + "ANEXOSCONTRATOS.FECHA BETWEEN ('" + ClaseInformacion.ConvertirFecha(fechaInicio) + "'::DATE) AND "
                        + "('" + ClaseInformacion.ConvertirFecha(fechaFinal) + "'::DATE) "
                        + "AND ( ANEXOSCONTRATOS.DOCUMENTO = 'Acta de Inicio' "
                        + "OR ANEXOSCONTRATOS.DOCUMENTO = 'Acta de Seguimiento' "
                        + "OR ANEXOSCONTRATOS.DOCUMENTO = 'Acta de Finalización' "
                        + "OR ANEXOSCONTRATOS.DOCUMENTO = 'Acta de Liquidación') "
                        + "ORDER BY DOCUMENTO, CONTRATO");

                String mensaje = "<html><font face='tahoma' size='-1'><p>Los siguientes contratos poseen ANEXOS dentro del periodo a reportar.<br>"
                        + "Por favor verifique que estos se encuentren en el reporte.</p><ul>";
                while (ClaseBaseDatos.resultado.next()) {
                    mensaje += "<li>" + ClaseBaseDatos.resultado.getString("DOCUMENTO");
                    mensaje += " : " + ClaseBaseDatos.resultado.getString("CONTRATO");
                    mensaje += " - (" + ClaseBaseDatos.resultado.getString("FECHASUSCRIPCION").substring(0, 10) + ")";
                    mensaje += "<a href='http:" + ClaseGeneral.servidor + "/UmVbZxut/archivos/" + ClaseBaseDatos.resultado.getString("ARCHIVO") + "'> VER</a></li>";
                }

                if (!mensaje.equals("<html><font face='tahoma' size='-1'><p>Los siguientes contratos poseen ANEXOS dentro del periodo a reportar.<br>"
                        + "Por favor verifique que estos se encuentren en el reporte.</p><ul>")) {
                    mensaje += "</ul></font></html>";
                    ClaseMensaje.html(mensaje);
                }
            } catch (SQLException ex) {
                ClaseMensaje.error("ERROR AL MOMENTO DE REALIZAR LA ACCION\n" + ex);
            }

            File file = new File(archivo);
            if (file.getAbsoluteFile().exists()) {
                try {
                    Desktop.getDesktop().open(file);
                } catch (IOException ex) {
                    Logger.getLogger(ClaseInformes.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
            }
        } catch (Exception ex) {
            //Logger.getLogger(ClaseInformes.class.getName()).log(Level.SEVERE, null, ex);
            ClaseMensaje.error("ERROR AL MOMENTO DE REALIZAR LA ACCION\n" + ex);
        }
    }
}
