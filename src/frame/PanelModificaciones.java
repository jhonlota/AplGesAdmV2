/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PanelModificaciones.java
 *
 * Created on 16/01/2012, 05:14:48 PM
 */
package frame;

import clases.ClaseGeneral;
import clases.ClaseInformacion;
import clases.ClaseMensaje;
import entidades.Modificaciones;
import entidades.ModificacionesPK;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author Jhon Lopez
 */
public class PanelModificaciones extends javax.swing.JPanel {

    private List lista = new ArrayList();
    private ClaseInformacion informacion = new ClaseInformacion();

    /**
     * Creates new form PanelModificaciones
     */
    public PanelModificaciones() {
        initComponents();

        tipomodifprorr.setEditable(true);
        AutoCompleteDecorator.decorate(tipomodifprorr);
        fechamodifprorr.setFormats(new SimpleDateFormat("yyyy-MM-dd"));
        fechamodifprorr.setDate(new Date(ClaseInformacion.calendario.getTimeInMillis()));

        fkcontrato.setText(ClaseGeneral.contratos.getContrato());
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

        jLabel1 = new javax.swing.JLabel();
        fkcontrato = new javax.swing.JTextField();
        jTextField15 = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        tipomodifprorr = new javax.swing.JComboBox();
        jTextField33 = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        valortotalmodifprorr = new javax.swing.JTextField();
        botonAyuda1 = new javax.swing.JButton();
        jTextField11 = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        fechamodifprorr = new org.jdesktop.swingx.JXDatePicker();
        jTextField26 = new javax.swing.JTextField();
        jLabel71 = new javax.swing.JLabel();
        jScrollPane = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();

        setName("panelModificaciones"); // NOI18N
        setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel1.setText("NÚMERO DEL CONTRATO : ");
        jLabel1.setPreferredSize(new java.awt.Dimension(160, 25));
        add(jLabel1);

        fkcontrato.setBackground(ClaseGeneral.verde);
        fkcontrato.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        fkcontrato.setForeground(ClaseGeneral.rojo);
        fkcontrato.setFocusable(false);
        fkcontrato.setMargin(new java.awt.Insets(2, 4, 2, 4));
        fkcontrato.setPreferredSize(new java.awt.Dimension(300, 25));
        add(fkcontrato);

        jTextField15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField15.setEnabled(false);
        jTextField15.setFocusable(false);
        jTextField15.setMargin(new java.awt.Insets(2, 4, 2, 4));
        jTextField15.setOpaque(false);
        jTextField15.setPreferredSize(new java.awt.Dimension(340, 25));
        add(jTextField15);

        jLabel48.setText("TIPO DE LA MODIFICACIÓN : ");
        jLabel48.setPreferredSize(new java.awt.Dimension(170, 25));
        add(jLabel48);

        tipomodifprorr.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tipomodifprorr.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione", "0: Adición", "1: Prórroga", "2: Adición y Prórroga", "3: Suspensión", "4: Reinicio" }));
        tipomodifprorr.setPreferredSize(new java.awt.Dimension(180, 25));
        add(tipomodifprorr);

        jTextField33.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField33.setEnabled(false);
        jTextField33.setFocusable(false);
        jTextField33.setMargin(new java.awt.Insets(2, 4, 2, 4));
        jTextField33.setOpaque(false);
        jTextField33.setPreferredSize(new java.awt.Dimension(450, 25));
        add(jTextField33);

        jLabel49.setText("VALOR TOTAL DE LAS ADICIONES : ");
        jLabel49.setPreferredSize(new java.awt.Dimension(210, 25));
        add(jLabel49);

        valortotalmodifprorr.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        valortotalmodifprorr.setText("0");
        valortotalmodifprorr.setMargin(new java.awt.Insets(2, 4, 2, 4));
        valortotalmodifprorr.setPreferredSize(new java.awt.Dimension(150, 25));
        valortotalmodifprorr.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TextFieldFocusGained(evt);
            }
        });
        valortotalmodifprorr.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TextFieldKeyReleased(evt);
            }
        });
        add(valortotalmodifprorr);

        botonAyuda1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos24/info.png"))); // NOI18N
        botonAyuda1.setFocusable(false);
        botonAyuda1.setPreferredSize(new java.awt.Dimension(25, 24));
        botonAyuda1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAyuda1ActionPerformed(evt);
            }
        });
        add(botonAyuda1);

        jTextField11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField11.setEnabled(false);
        jTextField11.setFocusable(false);
        jTextField11.setMargin(new java.awt.Insets(2, 4, 2, 4));
        jTextField11.setOpaque(false);
        jTextField11.setPreferredSize(new java.awt.Dimension(410, 25));
        add(jTextField11);

        jLabel50.setText("FECHA DE LA MODIFICACIÓN Y/O PRÓRROGA : ");
        jLabel50.setPreferredSize(new java.awt.Dimension(275, 25));
        add(jLabel50);

        fechamodifprorr.setFocusable(false);
        fechamodifprorr.setMaximumSize(new java.awt.Dimension(120, 25));
        fechamodifprorr.setMinimumSize(new java.awt.Dimension(120, 25));
        fechamodifprorr.setPreferredSize(new java.awt.Dimension(120, 25));
        add(fechamodifprorr);

        jTextField26.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField26.setEnabled(false);
        jTextField26.setFocusable(false);
        jTextField26.setMargin(new java.awt.Insets(2, 4, 2, 4));
        jTextField26.setOpaque(false);
        jTextField26.setPreferredSize(new java.awt.Dimension(405, 25));
        add(jTextField26);

        jLabel71.setPreferredSize(new java.awt.Dimension(810, 25));
        add(jLabel71);

        jScrollPane.setPreferredSize(new java.awt.Dimension(810, 415));

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
                "TIPO DE LA MODIFICACIÓN", "VALOR TOTAL DE LAS ADICIONES", "FECHA DE LA MODIFICACIÓN Y/O PRÓRROGA"
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
            valortotalmodifprorr.setText(ClaseInformacion.formatoDecimal.format(Long.parseLong(valortotalmodifprorr.getText().trim().replace(".", ""))));
        } catch (Exception ex) {
            Logger.getLogger(PanelPolizas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_TextFieldKeyReleased

    private void botonAyuda1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAyuda1ActionPerformed
        ClaseMensaje.informacion("A la fecha de rendición");
    }//GEN-LAST:event_botonAyuda1ActionPerformed

    public void metodoInsertar() {
        ClaseGeneral.modificaciones = new Modificaciones();
        ClaseGeneral.modificacionesPK = new ModificacionesPK();
        ClaseGeneral.modificacionesPK.setFkcontrato(fkcontrato.getText());
        ClaseGeneral.modificacionesPK.setFechamodifprorr(fechamodifprorr.getDate());
        ClaseGeneral.modificaciones.setModificacionesPK(ClaseGeneral.modificacionesPK);
        ClaseGeneral.modificaciones.setTipomodifprorr("" + tipomodifprorr.getSelectedItem());
        ClaseGeneral.modificaciones.setValortotalmodifprorr(BigDecimal.valueOf(Long.parseLong("" + valortotalmodifprorr.getText().trim().replace(".", ""))));

        try {
            ClaseGeneral.controlModificaciones.create(ClaseGeneral.modificaciones);
        } catch (Exception ex) {
            Logger.getLogger(PanelModificaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void metodoConsultar() {
        try {
            fkcontrato.setText(ClaseGeneral.modificaciones.getModificacionesPK().getFkcontrato());
            tipomodifprorr.setSelectedItem(ClaseGeneral.modificaciones.getTipomodifprorr());
            valortotalmodifprorr.setText("" + ClaseInformacion.formatoDecimal.format(ClaseGeneral.modificaciones.getValortotalmodifprorr()));
            fechamodifprorr.setDate(ClaseGeneral.modificaciones.getModificacionesPK().getFechamodifprorr());

            fkcontrato.setFocusable(false);
            fechamodifprorr.setEditable(false);
        } catch (Exception ex) {
            Logger.getLogger(PanelResoluciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void metodoActualizar() {
        Modificaciones modificacionesId = ClaseGeneral.modificaciones;
        modificacionesId.setModificacionesPK(ClaseGeneral.modificaciones.getModificacionesPK());

        ClaseGeneral.modificaciones = new Modificaciones();
        ClaseGeneral.modificacionesPK = new ModificacionesPK();
        ClaseGeneral.modificacionesPK.setFkcontrato(fkcontrato.getText());
        ClaseGeneral.modificacionesPK.setFechamodifprorr(fechamodifprorr.getDate());
        ClaseGeneral.modificaciones.setModificacionesPK(ClaseGeneral.modificacionesPK);
        ClaseGeneral.modificaciones.setTipomodifprorr("" + tipomodifprorr.getSelectedItem());
        ClaseGeneral.modificaciones.setValortotalmodifprorr(BigDecimal.valueOf(Long.parseLong("" + valortotalmodifprorr.getText().trim().replace(".", ""))));

        try {
            ClaseGeneral.controlModificaciones.edit(ClaseGeneral.modificaciones, modificacionesId);
        } catch (Exception ex) {
            Logger.getLogger(PanelModificaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void metodoEliminar() {
        try {
            ClaseGeneral.modificacionesPK = new ModificacionesPK();
            ClaseGeneral.modificacionesPK.setFkcontrato(fkcontrato.getText());
            ClaseGeneral.modificacionesPK.setFechamodifprorr(fechamodifprorr.getDate());

            ClaseGeneral.controlModificaciones.destroy(ClaseGeneral.modificacionesPK);
        } catch (Exception ex) {
            Logger.getLogger(PanelModificaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public final void metodoMostrar() {
        ClaseGeneral.modificaciones = new Modificaciones();
        lista = ClaseGeneral.controlModificaciones.findAllInModificacionesByFkcontrato(fkcontrato.getText());

        for (int i = 0; i < 100; i++) {
            jTable.setValueAt("", i, 0);
            jTable.setValueAt("", i, 1);
            jTable.setValueAt("", i, 2);
        }

        int i = 0;
        for (Object lista1 : lista) {
            ClaseGeneral.modificaciones = (Modificaciones) lista1;
            jTable.setValueAt("" + ClaseGeneral.modificaciones.getTipomodifprorr(), i, 0);
            jTable.setValueAt("" + ClaseInformacion.formatoDecimal.format(ClaseGeneral.modificaciones.getValortotalmodifprorr()), i, 1);
            jTable.setValueAt("" + ClaseGeneral.modificaciones.getModificacionesPK().getFechamodifprorr(), i, 2);
            i++;
        }

        jTable.clearSelection();
        jTable.getColumnModel().getColumn(0).setPreferredWidth(200);
        jTable.getColumnModel().getColumn(1).setPreferredWidth(250);
        jTable.getColumnModel().getColumn(2).setPreferredWidth(360);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAyuda1;
    private org.jdesktop.swingx.JXDatePicker fechamodifprorr;
    private javax.swing.JTextField fkcontrato;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel71;
    public javax.swing.JScrollPane jScrollPane;
    public javax.swing.JTable jTable;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField26;
    private javax.swing.JTextField jTextField33;
    private javax.swing.JComboBox tipomodifprorr;
    private javax.swing.JTextField valortotalmodifprorr;
    // End of variables declaration//GEN-END:variables

}
