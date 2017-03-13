/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

 /*
 * ExternoPanelEntrega.java
 *
 * Created on 27/11/2012, 04:01:30 PM
 */
package frame;

import clases.ClaseGeneral;
import clases.ClaseInformes;
import clases.ClaseMensaje;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Jhon Lopez
 */
public class ExternoPanelImprimirContratos extends javax.swing.JPanel {

    private FrameCarga frameCarga = new FrameCarga();
    private Thread hiloEstudiosPrevios = new ThreadCargaEstudiosPrevios();
    private Thread hiloFichaTecnica= new ThreadCargaFichaTecnica();
    private Thread hiloEstimacionPresupuesto = new ThreadCargaEstimacionPresupuesto();
    private Thread hiloContratos = new ThreadCargaContratos();
    private Thread hiloAnexoContrato = new ThreadCargaAnexoContrato();
    private PanelContratos panelContratos = new PanelContratos();

    /**
     * Creates new form ExternoPanelEntrega
     */
    public ExternoPanelImprimirContratos(PanelContratos panelContratos) {
        initComponents();
        this.panelContratos = panelContratos;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        botonEstudiosPrevios = new javax.swing.JButton();
        botonFichaTecnica = new javax.swing.JButton();
        botonEstimacionPresupuesto = new javax.swing.JButton();
        botonInvitacionMinimaCuantia = new javax.swing.JButton();
        botonInformeEvaluacion = new javax.swing.JButton();
        botonContrato = new javax.swing.JButton();
        botonAnexoContrato = new javax.swing.JButton();
        botonActaAprobacionPoliza = new javax.swing.JButton();
        botonActaInicio = new javax.swing.JButton();
        botonActaLiquidacion = new javax.swing.JButton();
        botonActaDesignacionSupervisor = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(410, 400));

        jLabel1.setBackground(ClaseGeneral.titulo);
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Entrega de Documentos");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setOpaque(true);
        jLabel1.setPreferredSize(new java.awt.Dimension(250, 25));
        add(jLabel1);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setPreferredSize(new java.awt.Dimension(250, 10));
        add(jLabel2);

        botonEstudiosPrevios.setText("Estudios Previos");
        botonEstudiosPrevios.setPreferredSize(new java.awt.Dimension(250, 25));
        botonEstudiosPrevios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEstudiosPreviosActionPerformed(evt);
            }
        });
        add(botonEstudiosPrevios);

        botonFichaTecnica.setText("Ficha Técnica");
        botonFichaTecnica.setPreferredSize(new java.awt.Dimension(250, 25));
        botonFichaTecnica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonFichaTecnicaActionPerformed(evt);
            }
        });
        add(botonFichaTecnica);

        botonEstimacionPresupuesto.setText("Estimación del Presupuesto");
        botonEstimacionPresupuesto.setPreferredSize(new java.awt.Dimension(250, 25));
        botonEstimacionPresupuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEstimacionPresupuestoActionPerformed(evt);
            }
        });
        add(botonEstimacionPresupuesto);

        botonInvitacionMinimaCuantia.setText("Invitación Minima Cuantía");
        botonInvitacionMinimaCuantia.setEnabled(false);
        botonInvitacionMinimaCuantia.setPreferredSize(new java.awt.Dimension(250, 25));
        botonInvitacionMinimaCuantia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonInvitacionMinimaCuantiaActionPerformed(evt);
            }
        });
        add(botonInvitacionMinimaCuantia);

        botonInformeEvaluacion.setText("Informe de Evaluación");
        botonInformeEvaluacion.setEnabled(false);
        botonInformeEvaluacion.setPreferredSize(new java.awt.Dimension(250, 25));
        botonInformeEvaluacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonInformeEvaluacionActionPerformed(evt);
            }
        });
        add(botonInformeEvaluacion);

        botonContrato.setText("Orden Contractual");
        botonContrato.setPreferredSize(new java.awt.Dimension(250, 25));
        botonContrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonContratoActionPerformed(evt);
            }
        });
        add(botonContrato);

        botonAnexoContrato.setText("Anexo Orden Contractual");
        botonAnexoContrato.setPreferredSize(new java.awt.Dimension(250, 25));
        botonAnexoContrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAnexoContratoActionPerformed(evt);
            }
        });
        add(botonAnexoContrato);

        botonActaAprobacionPoliza.setText("Acta Aprobación Póliza");
        botonActaAprobacionPoliza.setEnabled(false);
        botonActaAprobacionPoliza.setPreferredSize(new java.awt.Dimension(250, 25));
        botonActaAprobacionPoliza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActaAprobacionPolizaActionPerformed(evt);
            }
        });
        add(botonActaAprobacionPoliza);

        botonActaInicio.setText("Acta de Inicio");
        botonActaInicio.setEnabled(false);
        botonActaInicio.setPreferredSize(new java.awt.Dimension(250, 25));
        botonActaInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActaInicioActionPerformed(evt);
            }
        });
        add(botonActaInicio);

        botonActaLiquidacion.setText("Acta de Liquidación");
        botonActaLiquidacion.setEnabled(false);
        botonActaLiquidacion.setPreferredSize(new java.awt.Dimension(250, 25));
        botonActaLiquidacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActaLiquidacionActionPerformed(evt);
            }
        });
        add(botonActaLiquidacion);

        botonActaDesignacionSupervisor.setText("Acta de Designación Supervisor");
        botonActaDesignacionSupervisor.setEnabled(false);
        botonActaDesignacionSupervisor.setPreferredSize(new java.awt.Dimension(250, 25));
        botonActaDesignacionSupervisor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActaDesignacionSupervisorActionPerformed(evt);
            }
        });
        add(botonActaDesignacionSupervisor);
    }// </editor-fold>//GEN-END:initComponents

    private void botonEstudiosPreviosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEstudiosPreviosActionPerformed
        // TODO add your handling code here:
        try {
            frameCarga.setVisible(true);
            frameCarga.pack();
            frameCarga.setSize(280, 100);
            frameCarga.setLocationRelativeTo(null);
            frameCarga.setResizable(false);
            hiloEstudiosPrevios = new ThreadCargaEstudiosPrevios();
            hiloEstudiosPrevios.start();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_botonEstudiosPreviosActionPerformed

    private void botonFichaTecnicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonFichaTecnicaActionPerformed
        // TODO add your handling code here:
        try {
            frameCarga.setVisible(true);
            frameCarga.pack();
            frameCarga.setSize(280, 100);
            frameCarga.setLocationRelativeTo(null);
            frameCarga.setResizable(false);
            hiloFichaTecnica = new ThreadCargaFichaTecnica();
            hiloFichaTecnica.start();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_botonFichaTecnicaActionPerformed

    private void botonEstimacionPresupuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEstimacionPresupuestoActionPerformed
        // TODO add your handling code here:
        try {
            frameCarga.setVisible(true);
            frameCarga.pack();
            frameCarga.setSize(280, 100);
            frameCarga.setLocationRelativeTo(null);
            frameCarga.setResizable(false);
            hiloEstimacionPresupuesto = new ThreadCargaEstimacionPresupuesto();
            hiloEstimacionPresupuesto.start();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_botonEstimacionPresupuestoActionPerformed

    private void botonInvitacionMinimaCuantiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonInvitacionMinimaCuantiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonInvitacionMinimaCuantiaActionPerformed

    private void botonInformeEvaluacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonInformeEvaluacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonInformeEvaluacionActionPerformed

    private void botonContratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonContratoActionPerformed
        try {
            String textoValorSoportesContratos = panelContratos.valorsoportescontratos.getText().replace(".", "");
            String textoValorTotalConIvaCUBS = panelContratos.valortotalconivaCUBS.getText().replace(".", "");
            String textoValorTotalSinIvaCUBS = panelContratos.valortotalsinivaCUBS.getText().replace(".", "");
            String textoValor = "" + ClaseGeneral.contratos.getValor();
            String textoValorSinIva = "" + ClaseGeneral.contratos.getValorsiniva();

            if (textoValor.equals(textoValorSoportesContratos)
                    && textoValor.equals(textoValorTotalConIvaCUBS)
                    && textoValorSinIva.equals(textoValorTotalSinIvaCUBS)) {
                frameCarga.setVisible(true);
                frameCarga.pack();
                frameCarga.setSize(280, 100);
                frameCarga.setLocationRelativeTo(null);
                frameCarga.setResizable(false);
                hiloContratos = new ThreadCargaContratos();
                hiloContratos.start();
            } else {
                ClaseMensaje.error("NO SE PUEDE IMPRIMIR:\n"
                        + "Los valores del Contrato no concuerdan con los CUBS y Soportes");
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_botonContratoActionPerformed

    private void botonAnexoContratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAnexoContratoActionPerformed
        try {
            frameCarga.setVisible(true);
            frameCarga.pack();
            frameCarga.setSize(280, 100);
            frameCarga.setLocationRelativeTo(null);
            frameCarga.setResizable(false);
            hiloAnexoContrato = new ThreadCargaAnexoContrato();
            hiloAnexoContrato.start();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_botonAnexoContratoActionPerformed

    private void botonActaAprobacionPolizaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActaAprobacionPolizaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonActaAprobacionPolizaActionPerformed

    private void botonActaInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActaInicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonActaInicioActionPerformed

    private void botonActaLiquidacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActaLiquidacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonActaLiquidacionActionPerformed

    private void botonActaDesignacionSupervisorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActaDesignacionSupervisorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonActaDesignacionSupervisorActionPerformed

    class ThreadCargaEstudiosPrevios extends Thread {

        @Override
        public void run() {
            frameCarga.jProgressBar.setIndeterminate(true);
            frameCarga.jProgressBar.setMinimum(1);
            frameCarga.jProgressBar.setMaximum(100);
            /**
             *
             */
            try {
                Map<String, String> parametros = new HashMap<String, String>();
                parametros.put("CONTRATO", ClaseGeneral.contratos.getContrato());

                ClaseInformes informes = new ClaseInformes();
                informes.formatoEstudiosPrevios(parametros);
            } catch (Exception e) {
                ClaseMensaje.error("Error al mostrar el archivo.\n" + e);
            }
            /**
             *
             */
            frameCarga.jProgressBar.setIndeterminate(false);
            frameCarga.dispose();
            hiloEstudiosPrevios = null;
        }
    }
    
    class ThreadCargaFichaTecnica extends Thread {

        @Override
        public void run() {
            frameCarga.jProgressBar.setIndeterminate(true);
            frameCarga.jProgressBar.setMinimum(1);
            frameCarga.jProgressBar.setMaximum(100);
            /**
             *
             */
            try {
                Map<String, String> parametros = new HashMap<String, String>();
                parametros.put("CONTRATO", ClaseGeneral.contratos.getContrato());

                ClaseInformes informes = new ClaseInformes();
                informes.formatoFichaTecnica(parametros);
            } catch (Exception e) {
                ClaseMensaje.error("Error al mostrar el archivo.\n" + e);
            }
            /**
             *
             */
            frameCarga.jProgressBar.setIndeterminate(false);
            frameCarga.dispose();
            hiloFichaTecnica = null;
        }
    }
    
    class ThreadCargaEstimacionPresupuesto extends Thread {

        @Override
        public void run() {
            frameCarga.jProgressBar.setIndeterminate(true);
            frameCarga.jProgressBar.setMinimum(1);
            frameCarga.jProgressBar.setMaximum(100);
            /**
             *
             */
            try {
                Map<String, String> parametros = new HashMap<String, String>();
                parametros.put("CONTRATO", ClaseGeneral.contratos.getContrato());

                ClaseInformes informes = new ClaseInformes();
                informes.formatoEstimacionPresupuesto(parametros);
            } catch (Exception e) {
                ClaseMensaje.error("Error al mostrar el archivo.\n" + e);
            }
            /**
             *
             */
            frameCarga.jProgressBar.setIndeterminate(false);
            frameCarga.dispose();
            hiloEstimacionPresupuesto = null;
        }
    }
    
    class ThreadCargaContratos extends Thread {

        @Override
        public void run() {
            frameCarga.jProgressBar.setIndeterminate(true);
            frameCarga.jProgressBar.setMinimum(1);
            frameCarga.jProgressBar.setMaximum(100);
            /**
             *
             */
            try {
                Map<String, String> parametros = new HashMap<String, String>();
                parametros.put("CONTRATO", ClaseGeneral.contratos.getContrato());

                ClaseInformes informes = new ClaseInformes();

                if (ClaseGeneral.controlCubs.findCALCInCubsByFkcontrato(ClaseGeneral.contratos.getContrato()) > 8) {
                    parametros.put("isAnexoOrdenContractual", "ANEXO ORDEN CONTRACTUAL");
                } else {
                    parametros.put("isAnexoOrdenContractual", "-");
                }

                informes.formatoContrato(parametros);
            } catch (Exception e) {
                ClaseMensaje.error("Error al mostrar el archivo.\n" + e);
            }
            /**
             *
             */
            frameCarga.jProgressBar.setIndeterminate(false);
            frameCarga.dispose();
            hiloContratos = null;
        }
    }

    class ThreadCargaAnexoContrato extends Thread {

        @Override
        public void run() {
            frameCarga.jProgressBar.setIndeterminate(true);
            frameCarga.jProgressBar.setMinimum(1);
            frameCarga.jProgressBar.setMaximum(100);
            /**
             *
             */
            try {
                Map<String, String> parametros = new HashMap<String, String>();
                parametros.put("CONTRATO", ClaseGeneral.contratos.getContrato());

                ClaseInformes informes = new ClaseInformes();
                informes.formatoAnexoContrato(parametros);
            } catch (Exception e) {
                ClaseMensaje.error("Error al mostrar el archivo.\n" + e);
            }
            /**
             *
             */
            frameCarga.jProgressBar.setIndeterminate(false);
            frameCarga.dispose();
            hiloAnexoContrato = null;
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonActaAprobacionPoliza;
    private javax.swing.JButton botonActaDesignacionSupervisor;
    private javax.swing.JButton botonActaInicio;
    private javax.swing.JButton botonActaLiquidacion;
    private javax.swing.JButton botonAnexoContrato;
    private javax.swing.JButton botonContrato;
    private javax.swing.JButton botonEstimacionPresupuesto;
    private javax.swing.JButton botonEstudiosPrevios;
    private javax.swing.JButton botonFichaTecnica;
    private javax.swing.JButton botonInformeEvaluacion;
    private javax.swing.JButton botonInvitacionMinimaCuantia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
