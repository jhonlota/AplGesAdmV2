/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PanelObservacionescuentas.java
 *
 * Created on 16/01/2012, 05:14:48 PM
 */
package frame;

import clases.ClaseGeneral;
import clases.ClaseInformacion;
import entidades.Observacionescuentas;
import entidades.ObservacionescuentasPK;
import java.sql.Timestamp;
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
public class PanelObservacionescuentas extends javax.swing.JPanel {

    private List lista = new ArrayList();
    private ClaseInformacion informacion = new ClaseInformacion();

    /**
     * Creates new form PanelObservacionescuentas
     */
    public PanelObservacionescuentas() {
        initComponents();

        dependencia.setEditable(true);
        AutoCompleteDecorator.decorate(dependencia);
        fecha.setFormats(new SimpleDateFormat("yyyy-MM-dd"));
        fecha.setDate(new Date(ClaseInformacion.calendario.getTimeInMillis()));

        fkcuenta.setText(ClaseGeneral.cuentas.getSoporte());
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
        fkcuenta = new javax.swing.JTextField();
        jTextField15 = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        dependencia = new javax.swing.JComboBox();
        jLabel73 = new javax.swing.JLabel();
        jSeparator16 = new javax.swing.JSeparator();
        jLabel50 = new javax.swing.JLabel();
        fecha = new org.jdesktop.swingx.JXDatePicker();
        jTextField16 = new javax.swing.JTextField();
        jLabel72 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        observacion = new javax.swing.JTextArea();
        jLabel71 = new javax.swing.JLabel();
        jScrollPane = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();

        setName("panelObservacionescuentas"); // NOI18N
        setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel1.setText("SOPORTE DE LA CUENTA : ");
        jLabel1.setPreferredSize(new java.awt.Dimension(165, 25));
        add(jLabel1);

        fkcuenta.setBackground(ClaseGeneral.verde);
        fkcuenta.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        fkcuenta.setForeground(ClaseGeneral.rojo);
        fkcuenta.setFocusable(false);
        fkcuenta.setMargin(new java.awt.Insets(2, 4, 2, 4));
        fkcuenta.setPreferredSize(new java.awt.Dimension(150, 25));
        add(fkcuenta);

        jTextField15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField15.setEnabled(false);
        jTextField15.setFocusable(false);
        jTextField15.setMargin(new java.awt.Insets(2, 4, 2, 4));
        jTextField15.setOpaque(false);
        jTextField15.setPreferredSize(new java.awt.Dimension(485, 25));
        add(jTextField15);

        jLabel48.setText("DEPENDENCIA : ");
        jLabel48.setPreferredSize(new java.awt.Dimension(100, 25));
        add(jLabel48);

        dependencia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        dependencia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-", "ARTES GRAFICAS", "DECANATO", "DEPARTAMENTO DE BIOLOGIA", "DEPARTAMENTO DE FISICA", "DEPARTAMENTO DE MATEMATICAS", "DEPARTAMENTO DE QUIMICA" }));
        dependencia.setPreferredSize(new java.awt.Dimension(300, 25));
        //dependencia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-", "COORDINACIÓN DE ÁREA ADMINISTRATIVA", "VICE-DECANATURA DE INVESTIGACIONES", "ESCUELA DE INGENIERIA INDUSTRIAL" }));
        add(dependencia);

        jLabel73.setPreferredSize(new java.awt.Dimension(20, 25));
        add(jLabel73);

        jSeparator16.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator16.setPreferredSize(new java.awt.Dimension(20, 25));
        add(jSeparator16);

        jLabel50.setText("FECHA : ");
        jLabel50.setPreferredSize(new java.awt.Dimension(60, 25));
        add(jLabel50);

        fecha.setFocusable(false);
        fecha.setMaximumSize(new java.awt.Dimension(120, 25));
        fecha.setMinimumSize(new java.awt.Dimension(120, 25));
        fecha.setPreferredSize(new java.awt.Dimension(120, 25));
        add(fecha);

        jTextField16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField16.setEnabled(false);
        jTextField16.setFocusable(false);
        jTextField16.setMargin(new java.awt.Insets(2, 4, 2, 4));
        jTextField16.setOpaque(false);
        jTextField16.setPreferredSize(new java.awt.Dimension(160, 25));
        add(jTextField16);

        jLabel72.setPreferredSize(new java.awt.Dimension(810, 25));
        add(jLabel72);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "OBSERVACIÓN", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13))); // NOI18N
        jPanel5.setPreferredSize(new java.awt.Dimension(810, 120));
        jPanel5.setLayout(new java.awt.BorderLayout());

        jScrollPane2.setPreferredSize(new java.awt.Dimension(430, 70));

        observacion.setColumns(20);
        observacion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        observacion.setLineWrap(true);
        observacion.setRows(15);
        observacion.setWrapStyleWord(true);
        observacion.setMargin(new java.awt.Insets(2, 5, 2, 5));
        jScrollPane2.setViewportView(observacion);

        jPanel5.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        add(jPanel5);

        jLabel71.setPreferredSize(new java.awt.Dimension(810, 25));
        add(jLabel71);

        jScrollPane.setPreferredSize(new java.awt.Dimension(810, 320));

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "FECHA", "OBSERVACIÓN"
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

    public void metodoInsertar() {
        ClaseGeneral.observacionescuentas = new Observacionescuentas();
        ClaseGeneral.observacionescuentasPK = new ObservacionescuentasPK();
        ClaseGeneral.observacionescuentasPK.setFkcuenta(fkcuenta.getText());
        ClaseGeneral.observacionescuentasPK.setFecha(Timestamp.valueOf(ClaseInformacion.ConvertirFecha(fecha.getDate()) + " 12:00:00"));
        ClaseGeneral.observacionescuentas.setObservacionescuentasPK(ClaseGeneral.observacionescuentasPK);
        ClaseGeneral.observacionescuentas.setDependencia("" + dependencia.getSelectedItem());
        ClaseGeneral.observacionescuentas.setObservacion(observacion.getText().toUpperCase());

        try {
            ClaseGeneral.controlObservacionescuentas.create(ClaseGeneral.observacionescuentas);
        } catch (Exception ex) {
            Logger.getLogger(PanelObservacionescuentas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void metodoConsultar() {
        try {
            fkcuenta.setText(ClaseGeneral.observacionescuentas.getObservacionescuentasPK().getFkcuenta());
            dependencia.setSelectedItem(ClaseGeneral.observacionescuentas.getDependencia());
            fecha.setDate(ClaseGeneral.observacionescuentas.getObservacionescuentasPK().getFecha());
            observacion.setText(ClaseGeneral.observacionescuentas.getObservacion());

            fkcuenta.setFocusable(false);
            fecha.setEditable(false);
        } catch (Exception ex) {
            Logger.getLogger(PanelResoluciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void metodoActualizar() {
        Observacionescuentas observacionescuentasId = ClaseGeneral.observacionescuentas;
        observacionescuentasId.setObservacionescuentasPK(ClaseGeneral.observacionescuentas.getObservacionescuentasPK());

        ClaseGeneral.observacionescuentas = new Observacionescuentas();
        ClaseGeneral.observacionescuentasPK = new ObservacionescuentasPK();
        ClaseGeneral.observacionescuentasPK.setFkcuenta(fkcuenta.getText());
        ClaseGeneral.observacionescuentasPK.setFecha(Timestamp.valueOf(ClaseInformacion.ConvertirFecha(fecha.getDate()) + " 12:00:00"));
        ClaseGeneral.observacionescuentas.setObservacionescuentasPK(ClaseGeneral.observacionescuentasPK);
        ClaseGeneral.observacionescuentas.setDependencia("" + dependencia.getSelectedItem());
        ClaseGeneral.observacionescuentas.setObservacion(observacion.getText().toUpperCase());

        try {
            ClaseGeneral.controlObservacionescuentas.edit(ClaseGeneral.observacionescuentas, observacionescuentasId);
        } catch (Exception ex) {
            Logger.getLogger(PanelObservacionescuentas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void metodoEliminar() {
        try {
            ClaseGeneral.observacionescuentasPK = new ObservacionescuentasPK();
            ClaseGeneral.observacionescuentasPK.setFkcuenta(fkcuenta.getText());
            ClaseGeneral.observacionescuentasPK.setFecha(ClaseGeneral.observacionescuentas.getObservacionescuentasPK().getFecha());

            ClaseGeneral.controlObservacionescuentas.destroy(ClaseGeneral.observacionescuentasPK);
        } catch (Exception ex) {
            Logger.getLogger(PanelObservacionescuentas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public final void metodoMostrar() {
        ClaseGeneral.observacionescuentas = new Observacionescuentas();
        lista = ClaseGeneral.controlObservacionescuentas.findAllInObservacionescuentasByFkcuenta(fkcuenta.getText());

        for (int i = 0; i < 100; i++) {
            jTable.setValueAt("", i, 0);
            jTable.setValueAt("", i, 1);
        }

        int i = 0;
        for (Object lista1 : lista) {
            ClaseGeneral.observacionescuentas = (Observacionescuentas) lista1;
            jTable.setValueAt("" + ClaseGeneral.observacionescuentas.getObservacionescuentasPK().getFecha().toString().substring(0, 19), i, 0);
            jTable.setValueAt("" + ClaseGeneral.observacionescuentas.getObservacion(), i, 1);
            i++;
        }

        jTable.clearSelection();
        jTable.getColumnModel().getColumn(0).setPreferredWidth(120);
        jTable.getColumnModel().getColumn(1).setPreferredWidth(690);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox dependencia;
    public org.jdesktop.swingx.JXDatePicker fecha;
    public javax.swing.JTextField fkcuenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JPanel jPanel5;
    public javax.swing.JScrollPane jScrollPane;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator16;
    public javax.swing.JTable jTable;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    public javax.swing.JTextArea observacion;
    // End of variables declaration//GEN-END:variables
}
