/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PanelFacturascomprobantes.java
 *
 * Created on 16/01/2012, 05:14:48 PM
 */
package frame;

import clases.ClaseGeneral;
import clases.ClaseInformacion;
import entidades.Facturascomprobantes;
import entidades.FacturascomprobantesPK;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jhon Lopez
 */
public class PanelFacturascomprobantes extends javax.swing.JPanel {

    private List lista = new ArrayList();
    private ClaseInformacion informacion = new ClaseInformacion();

    /**
     * Creates new form PanelFacturascomprobantes
     */
    public PanelFacturascomprobantes() {
        initComponents();

        fkcomprobante.setText("" + ClaseGeneral.comprobantes.getId());
        ano.setText("" + ClaseGeneral.comprobantes.getAno());

        fecha.setFormats(new SimpleDateFormat("yyyy-MM-dd"));
        fecha.setDate(new Date(ClaseInformacion.calendario.getTimeInMillis()));
        metodoMostrar();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        fkcomprobante = new javax.swing.JTextField();
        jLabel75 = new javax.swing.JLabel();
        jSeparator21 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        ano = new javax.swing.JTextField();
        jTextField15 = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        numero = new javax.swing.JTextField();
        jLabel79 = new javax.swing.JLabel();
        jSeparator18 = new javax.swing.JSeparator();
        jLabel50 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        fecha = new org.jdesktop.swingx.JXDatePicker();
        jLabel29 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jSeparator17 = new javax.swing.JSeparator();
        jLabel49 = new javax.swing.JLabel();
        valor = new javax.swing.JTextField();
        jLabel71 = new javax.swing.JLabel();
        jScrollPane = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();

        setName("panelFacturascomprobantes"); // NOI18N
        setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel2.setText("NÚMERO DE LA SOLICITUD : ");
        jLabel2.setPreferredSize(new java.awt.Dimension(175, 25));
        add(jLabel2);

        fkcomprobante.setBackground(ClaseGeneral.verde);
        fkcomprobante.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        fkcomprobante.setForeground(ClaseGeneral.rojo);
        fkcomprobante.setFocusable(false);
        fkcomprobante.setMargin(new java.awt.Insets(2, 4, 2, 4));
        fkcomprobante.setPreferredSize(new java.awt.Dimension(150, 25));
        add(fkcomprobante);

        jLabel75.setPreferredSize(new java.awt.Dimension(20, 25));
        add(jLabel75);

        jSeparator21.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator21.setPreferredSize(new java.awt.Dimension(20, 25));
        add(jSeparator21);

        jLabel3.setText("AÑO : ");
        jLabel3.setPreferredSize(new java.awt.Dimension(60, 25));
        add(jLabel3);

        ano.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ano.setText("0");
        ano.setFocusable(false);
        ano.setMargin(new java.awt.Insets(2, 4, 2, 4));
        ano.setPreferredSize(new java.awt.Dimension(75, 25));
        add(ano);

        jTextField15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField15.setEnabled(false);
        jTextField15.setFocusable(false);
        jTextField15.setMargin(new java.awt.Insets(2, 4, 2, 4));
        jTextField15.setOpaque(false);
        jTextField15.setPreferredSize(new java.awt.Dimension(280, 25));
        add(jTextField15);

        jLabel52.setText("NÚMERO FACTURA : ");
        jLabel52.setPreferredSize(new java.awt.Dimension(130, 25));
        add(jLabel52);

        numero.setBackground(ClaseGeneral.campo);
        numero.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        numero.setText("0");
        numero.setMargin(new java.awt.Insets(2, 4, 2, 4));
        numero.setPreferredSize(new java.awt.Dimension(160, 25));
        add(numero);

        jLabel79.setPreferredSize(new java.awt.Dimension(15, 25));
        add(jLabel79);

        jSeparator18.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator18.setPreferredSize(new java.awt.Dimension(20, 25));
        add(jSeparator18);

        jLabel50.setText("FECHA : ");
        jLabel50.setPreferredSize(new java.awt.Dimension(55, 25));
        add(jLabel50);

        jPanel9.setBackground(ClaseGeneral.campo);
        jPanel9.setMaximumSize(new java.awt.Dimension(140, 25));
        jPanel9.setMinimumSize(new java.awt.Dimension(140, 25));
        jPanel9.setPreferredSize(new java.awt.Dimension(140, 25));
        jPanel9.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        fecha.setFocusable(false);
        fecha.setMaximumSize(new java.awt.Dimension(120, 25));
        fecha.setMinimumSize(new java.awt.Dimension(120, 25));
        fecha.setPreferredSize(new java.awt.Dimension(120, 25));
        jPanel9.add(fecha);

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel29.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel29.setMaximumSize(new java.awt.Dimension(20, 26));
        jLabel29.setMinimumSize(new java.awt.Dimension(20, 26));
        jLabel29.setPreferredSize(new java.awt.Dimension(20, 26));
        jPanel9.add(jLabel29);

        add(jPanel9);

        jLabel80.setPreferredSize(new java.awt.Dimension(15, 25));
        add(jLabel80);

        jSeparator17.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator17.setPreferredSize(new java.awt.Dimension(20, 25));
        add(jSeparator17);

        jLabel49.setText("VALOR : ");
        jLabel49.setPreferredSize(new java.awt.Dimension(60, 25));
        add(jLabel49);

        valor.setBackground(ClaseGeneral.campo);
        valor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        valor.setText("0");
        valor.setMargin(new java.awt.Insets(2, 4, 2, 4));
        valor.setPreferredSize(new java.awt.Dimension(150, 25));
        valor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TextFieldFocusGained(evt);
            }
        });
        valor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TextFieldKeyReleased(evt);
            }
        });
        add(valor);

        jLabel71.setPreferredSize(new java.awt.Dimension(810, 30));
        add(jLabel71);

        jScrollPane.setPreferredSize(new java.awt.Dimension(810, 470));

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "FACTURA", "FECHA", "VALOR"
            }
        ));
        jTable.setEnabled(false);
        jTable.setFocusable(false);
        jTable.setIntercellSpacing(new java.awt.Dimension(2, 2));
        jTable.setRowHeight(20);
        jTable.setSelectionBackground(ClaseGeneral.campo);
        jScrollPane.setViewportView(jTable);

        add(jScrollPane);
    }// </editor-fold>//GEN-END:initComponents

    private void TextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TextFieldFocusGained
        javax.swing.JTextField componente = (javax.swing.JTextField) evt.getComponent();
        componente.selectAll();
        componente.requestFocus();
    }//GEN-LAST:event_TextFieldFocusGained

    private void TextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextFieldKeyReleased
        try {
            valor.setText(ClaseInformacion.formatoDecimal.format(Long.parseLong(valor.getText().trim().replace(".", ""))));
        } catch (Exception ex) {
            Logger.getLogger(PanelPolizas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_TextFieldKeyReleased

    public void metodoInsertar() {
        ClaseGeneral.facturascomprobantes = new Facturascomprobantes();
        ClaseGeneral.facturascomprobantesPK = new FacturascomprobantesPK();
        ClaseGeneral.facturascomprobantesPK.setFkcomprobante(Integer.parseInt("" + fkcomprobante.getText()));
        ClaseGeneral.facturascomprobantesPK.setNumero(numero.getText());
        ClaseGeneral.facturascomprobantesPK.setAno(Integer.parseInt("" + ano.getText()));
        ClaseGeneral.facturascomprobantes.setFacturascomprobantesPK(ClaseGeneral.facturascomprobantesPK);
        ClaseGeneral.facturascomprobantes.setValor(BigDecimal.valueOf(Long.parseLong("" + valor.getText().trim().replace(".", ""))));
        ClaseGeneral.facturascomprobantes.setFecha(fecha.getDate());

        try {
            ClaseGeneral.controlFacturascomprobantes.create(ClaseGeneral.facturascomprobantes);
        } catch (Exception ex) {
            Logger.getLogger(PanelFacturascomprobantes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void metodoConsultar() {
        try {
            fkcomprobante.setText("" + ClaseGeneral.facturascomprobantes.getFacturascomprobantesPK().getFkcomprobante());
            numero.setText(ClaseGeneral.facturascomprobantes.getFacturascomprobantesPK().getNumero());
            ano.setText("" + ClaseGeneral.facturascomprobantes.getFacturascomprobantesPK().getAno());
            valor.setText("" + ClaseInformacion.formatoDecimal.format(ClaseGeneral.facturascomprobantes.getValor()));
            fecha.setDate(ClaseGeneral.facturascomprobantes.getFecha());

            fkcomprobante.setFocusable(false);
            numero.setEditable(false);
            //ano.setEditable(false);
        } catch (Exception ex) {
            Logger.getLogger(PanelResoluciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void metodoActualizar() {
        Facturascomprobantes facturascomprobantesId = ClaseGeneral.facturascomprobantes;
        facturascomprobantesId.setFacturascomprobantesPK(ClaseGeneral.facturascomprobantes.getFacturascomprobantesPK());

        ClaseGeneral.facturascomprobantes = new Facturascomprobantes();
        ClaseGeneral.facturascomprobantesPK = new FacturascomprobantesPK();
        ClaseGeneral.facturascomprobantesPK.setFkcomprobante(Integer.parseInt("" + fkcomprobante.getText()));
        ClaseGeneral.facturascomprobantesPK.setNumero(numero.getText());
        ClaseGeneral.facturascomprobantesPK.setAno(Integer.parseInt("" + ano.getText()));
        ClaseGeneral.facturascomprobantes.setFacturascomprobantesPK(ClaseGeneral.facturascomprobantesPK);
        ClaseGeneral.facturascomprobantes.setValor(BigDecimal.valueOf(Long.parseLong("" + valor.getText().trim().replace(".", ""))));
        ClaseGeneral.facturascomprobantes.setFecha(fecha.getDate());

        try {
            ClaseGeneral.controlFacturascomprobantes.edit(ClaseGeneral.facturascomprobantes, facturascomprobantesId);
        } catch (Exception ex) {
            Logger.getLogger(PanelFacturascomprobantes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void metodoEliminar() {
        try {
            ClaseGeneral.facturascomprobantesPK = new FacturascomprobantesPK();
            ClaseGeneral.facturascomprobantesPK.setFkcomprobante(Integer.parseInt("" + fkcomprobante.getText()));
            ClaseGeneral.facturascomprobantesPK.setNumero(numero.getText());
            ClaseGeneral.facturascomprobantesPK.setAno(Integer.parseInt("" + ano.getText()));

            ClaseGeneral.controlFacturascomprobantes.destroy(ClaseGeneral.facturascomprobantesPK);
        } catch (Exception ex) {
            Logger.getLogger(PanelFacturascomprobantes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public final void metodoMostrar() {
        ClaseGeneral.facturascomprobantes = new Facturascomprobantes();
        lista = ClaseGeneral.controlFacturascomprobantes.findAllInFacturascomprobantesByFkcomprobante(Integer.parseInt("" + fkcomprobante.getText()), Integer.parseInt("" + ano.getText()));

        for (int i = 0; i < 100; i++) {
            jTable.setValueAt("", i, 0);
            jTable.setValueAt("", i, 1);
            jTable.setValueAt("", i, 2);
        }

        int i = 0;
        for (Object lista1 : lista) {
            ClaseGeneral.facturascomprobantes = (Facturascomprobantes) lista1;
            jTable.setValueAt("" + ClaseGeneral.facturascomprobantes.getFacturascomprobantesPK().getNumero(), i, 0);
            jTable.setValueAt("" + ClaseGeneral.facturascomprobantes.getFecha(), i, 1);
            jTable.setValueAt("" + ClaseInformacion.formatoDecimal.format(ClaseGeneral.facturascomprobantes.getValor()), i, 2);
            i++;
        }

        jTable.clearSelection();
        jTable.getColumnModel().getColumn(0).setPreferredWidth(270);
        jTable.getColumnModel().getColumn(1).setPreferredWidth(270);
        jTable.getColumnModel().getColumn(1).setPreferredWidth(270);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField ano;
    private org.jdesktop.swingx.JXDatePicker fecha;
    public javax.swing.JTextField fkcomprobante;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JPanel jPanel9;
    public javax.swing.JScrollPane jScrollPane;
    private javax.swing.JSeparator jSeparator17;
    private javax.swing.JSeparator jSeparator18;
    private javax.swing.JSeparator jSeparator21;
    public javax.swing.JTable jTable;
    private javax.swing.JTextField jTextField15;
    public javax.swing.JTextField numero;
    public javax.swing.JTextField valor;
    // End of variables declaration//GEN-END:variables
}
