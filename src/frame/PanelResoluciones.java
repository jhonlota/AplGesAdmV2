/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PanelComprobantes.java
 *
 * Created on 16/01/2012, 05:14:48 PM
 */
package frame;

import clases.ClaseGeneral;
import clases.ClaseInformacion;
import clases.ClaseMensaje;
import entidades.Resoluciones;
import entidades.ResolucionesPK;
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
public class PanelResoluciones extends javax.swing.JPanel {

    private List lista = new ArrayList();
    private List listaCALC = new ArrayList();
    private ClaseInformacion informacion = new ClaseInformacion();
    private String estado = "";

    /**
     * Creates new form PanelComprobantes
     */
    public PanelResoluciones() {
        initComponents();

        fecha.setFormats(new SimpleDateFormat("yyyy-MM-dd"));
        fechainicio.setFormats(new SimpleDateFormat("yyyy-MM-dd"));
        fechaterminacion.setFormats(new SimpleDateFormat("yyyy-MM-dd"));

        fecha.setDate(new Date(ClaseInformacion.calendario.getTimeInMillis()));
        fechainicio.setDate(new Date(ClaseInformacion.calendario.getTimeInMillis()));
        fechaterminacion.setDate(new Date(ClaseInformacion.calendario.getTimeInMillis()));

        ano.setText(ClaseGeneral.controlUtilidades.anoServidor());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBalanceSoportes = new javax.swing.JPanel();
        scrollPaneBalanceSoportes = new javax.swing.JScrollPane();
        textAreaBalanceSoportes = new javax.swing.JTextArea();
        jLabelId = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabelFecha = new javax.swing.JLabel();
        fecha = new org.jdesktop.swingx.JXDatePicker();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabelAno = new javax.swing.JLabel();
        ano = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabelVehiculo = new javax.swing.JLabel();
        vehiculo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabelAcuerdo = new javax.swing.JLabel();
        acuerdo = new javax.swing.JComboBox();
        botonAyuda1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabelFkterceroordenadorgasto = new javax.swing.JLabel();
        fkterceroordenadorgasto = new javax.swing.JTextField();
        botonBuscarFkterceroordenadorgasto = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabelTipo = new javax.swing.JLabel();
        tipo = new javax.swing.JComboBox();
        botonAyuda2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        isfindesemana = new javax.swing.JCheckBox();
        jTextField3 = new javax.swing.JTextField();
        jLabelFechainicio = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        fechainicio = new org.jdesktop.swingx.JXDatePicker();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabelFechaterminacion = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        fechaterminacion = new org.jdesktop.swingx.JXDatePicker();
        jLabel10 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jPanelObservacion = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        observacion = new javax.swing.JTextArea();

        panelBalanceSoportes.setMinimumSize(new java.awt.Dimension(750, 250));
        panelBalanceSoportes.setPreferredSize(new java.awt.Dimension(750, 250));
        panelBalanceSoportes.setLayout(new java.awt.BorderLayout());

        scrollPaneBalanceSoportes.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        textAreaBalanceSoportes.setEditable(false);
        textAreaBalanceSoportes.setColumns(20);
        textAreaBalanceSoportes.setLineWrap(true);
        textAreaBalanceSoportes.setRows(5);
        textAreaBalanceSoportes.setWrapStyleWord(true);
        textAreaBalanceSoportes.setMargin(new java.awt.Insets(10, 10, 10, 10));
        scrollPaneBalanceSoportes.setViewportView(textAreaBalanceSoportes);

        panelBalanceSoportes.add(scrollPaneBalanceSoportes, java.awt.BorderLayout.CENTER);

        setName("panelResoluciones"); // NOI18N
        setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabelId.setText("NUMERO : ");
        jLabelId.setPreferredSize(new java.awt.Dimension(70, 25));
        add(jLabelId);

        id.setBackground(ClaseGeneral.verde);
        id.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        id.setForeground(ClaseGeneral.rojo);
        id.setText("0");
        id.setFocusable(false);
        id.setMargin(new java.awt.Insets(2, 4, 2, 4));
        id.setPreferredSize(new java.awt.Dimension(150, 25));
        add(id);

        jLabel1.setPreferredSize(new java.awt.Dimension(20, 25));
        add(jLabel1);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setPreferredSize(new java.awt.Dimension(20, 25));
        add(jSeparator1);

        jLabelFecha.setText("FECHA ELABORACION : ");
        jLabelFecha.setPreferredSize(new java.awt.Dimension(140, 25));
        add(jLabelFecha);

        fecha.setFocusable(false);
        fecha.setMaximumSize(new java.awt.Dimension(120, 25));
        fecha.setMinimumSize(new java.awt.Dimension(120, 25));
        fecha.setPreferredSize(new java.awt.Dimension(120, 25));
        add(fecha);

        jLabel2.setPreferredSize(new java.awt.Dimension(20, 25));
        add(jLabel2);

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator2.setPreferredSize(new java.awt.Dimension(20, 25));
        add(jSeparator2);

        jLabelAno.setText("AÑO : ");
        jLabelAno.setPreferredSize(new java.awt.Dimension(45, 25));
        add(jLabelAno);

        ano.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ano.setText("0");
        ano.setMargin(new java.awt.Insets(2, 4, 2, 4));
        ano.setPreferredSize(new java.awt.Dimension(75, 25));
        ano.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TextFieldFocusGained(evt);
            }
        });
        add(ano);

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField1.setEnabled(false);
        jTextField1.setFocusable(false);
        jTextField1.setMargin(new java.awt.Insets(2, 4, 2, 4));
        jTextField1.setOpaque(false);
        jTextField1.setPreferredSize(new java.awt.Dimension(80, 25));
        add(jTextField1);

        jLabel3.setPreferredSize(new java.awt.Dimension(810, 15));
        add(jLabel3);

        jLabelVehiculo.setText("VEHICULO : ");
        jLabelVehiculo.setPreferredSize(new java.awt.Dimension(75, 25));
        add(jLabelVehiculo);

        vehiculo.setBackground(ClaseGeneral.campo);
        vehiculo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        vehiculo.setText("0");
        vehiculo.setMargin(new java.awt.Insets(2, 4, 2, 4));
        vehiculo.setPreferredSize(new java.awt.Dimension(140, 25));
        vehiculo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TextFieldFocusGained(evt);
            }
        });
        add(vehiculo);

        jLabel4.setPreferredSize(new java.awt.Dimension(20, 25));
        add(jLabel4);

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator3.setPreferredSize(new java.awt.Dimension(15, 25));
        add(jSeparator3);

        jLabelAcuerdo.setText("ACUERDO : ");
        jLabelAcuerdo.setPreferredSize(new java.awt.Dimension(75, 25));
        add(jLabelAcuerdo);

        acuerdo.setBackground(ClaseGeneral.campo);
        acuerdo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        acuerdo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione", "Acuerdo No. 025 de 2014", "Acuerdo No. 025 de 2014 y Resolucion No. 2252", "Acuerdo No. 025 de 2014 y Resolucion No. 2253", "Acuerdo No. 025 de 2014 y Resolucion No. 2784", "Acuerdo No. 025 de 2014 y Resolucion No. 3478", "Acuerdo No. 004 de 1996", "Acuerdo No. 004 de 1996 y Resolucion No. 2252", "Acuerdo No. 004 de 1996 y Resolucion No. 2253", "Acuerdo No. 004 de 1996 y Resolucion No. 2784", "Acuerdo No. 004 de 1996 y Resolucion No. 3478", "Resolucion No. 013", "No Aplica" }));
        acuerdo.setPreferredSize(new java.awt.Dimension(430, 25));
        add(acuerdo);

        botonAyuda1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos24/info.png"))); // NOI18N
        botonAyuda1.setFocusable(false);
        botonAyuda1.setPreferredSize(new java.awt.Dimension(25, 24));
        botonAyuda1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAyuda1ActionPerformed(evt);
            }
        });
        add(botonAyuda1);

        jLabel5.setPreferredSize(new java.awt.Dimension(810, 10));
        add(jLabel5);

        jLabelFkterceroordenadorgasto.setText("CÉDULA DEL ORDENADOR DE GASTO : ");
        jLabelFkterceroordenadorgasto.setPreferredSize(new java.awt.Dimension(230, 25));
        add(jLabelFkterceroordenadorgasto);

        fkterceroordenadorgasto.setBackground(ClaseGeneral.campo);
        fkterceroordenadorgasto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fkterceroordenadorgasto.setFocusable(false);
        fkterceroordenadorgasto.setMargin(new java.awt.Insets(2, 4, 2, 4));
        fkterceroordenadorgasto.setPreferredSize(new java.awt.Dimension(545, 25));
        add(fkterceroordenadorgasto);

        botonBuscarFkterceroordenadorgasto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos24/search_user.png"))); // NOI18N
        botonBuscarFkterceroordenadorgasto.setFocusable(false);
        botonBuscarFkterceroordenadorgasto.setName("botonBuscarFkterceroordenadorgasto"); // NOI18N
        botonBuscarFkterceroordenadorgasto.setPreferredSize(new java.awt.Dimension(25, 24));
        botonBuscarFkterceroordenadorgasto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarFkterceroordenadorgastoActionPerformed(evt);
            }
        });
        add(botonBuscarFkterceroordenadorgasto);

        jLabel6.setPreferredSize(new java.awt.Dimension(810, 10));
        add(jLabel6);

        jLabelTipo.setText("TIPO DE RESOLUCION : ");
        jLabelTipo.setPreferredSize(new java.awt.Dimension(145, 25));
        add(jLabelTipo);

        tipo.setBackground(ClaseGeneral.campo);
        tipo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione", "APERTURA CAJA Y FONDO", "AYUDA ECONÓMICA", "CANDIDATOS A ELECCIONES", "COMISIÓN ACADÉMICA Y VIÁTICOS", "COMISIÓN DE SERVICIOS Y VIÁTICOS", "DOCENTES OCASIONALES", "GASTOS DE VIAJE", "GASTOS DE VIAJE Y TIQUETES AÉREOS", "TIQUETES AÉREOS" }));
        tipo.setPreferredSize(new java.awt.Dimension(280, 25));
        add(tipo);

        botonAyuda2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos24/info.png"))); // NOI18N
        botonAyuda2.setFocusable(false);
        botonAyuda2.setPreferredSize(new java.awt.Dimension(25, 24));
        botonAyuda2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAyuda2ActionPerformed(evt);
            }
        });
        add(botonAyuda2);

        jLabel7.setPreferredSize(new java.awt.Dimension(20, 25));
        add(jLabel7);

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator4.setPreferredSize(new java.awt.Dimension(20, 25));
        add(jSeparator4);

        isfindesemana.setBackground(ClaseGeneral.campo);
        isfindesemana.setText("SELECCIONE SI ES FIN DE SEMANA");
        isfindesemana.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        isfindesemana.setBorderPainted(true);
        isfindesemana.setPreferredSize(new java.awt.Dimension(240, 25));
        add(isfindesemana);

        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField3.setEnabled(false);
        jTextField3.setFocusable(false);
        jTextField3.setMargin(new java.awt.Insets(2, 4, 2, 4));
        jTextField3.setOpaque(false);
        jTextField3.setPreferredSize(new java.awt.Dimension(50, 25));
        add(jTextField3);

        jLabelFechainicio.setText("FECHA INICIO DEL ACTO : ");
        jLabelFechainicio.setPreferredSize(new java.awt.Dimension(160, 25));
        add(jLabelFechainicio);

        jPanel1.setBackground(ClaseGeneral.campo);
        jPanel1.setMaximumSize(new java.awt.Dimension(140, 25));
        jPanel1.setMinimumSize(new java.awt.Dimension(140, 25));
        jPanel1.setPreferredSize(new java.awt.Dimension(140, 25));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        fechainicio.setFocusable(false);
        fechainicio.setMaximumSize(new java.awt.Dimension(120, 25));
        fechainicio.setMinimumSize(new java.awt.Dimension(120, 25));
        fechainicio.setPreferredSize(new java.awt.Dimension(120, 25));
        jPanel1.add(fechainicio);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel8.setMaximumSize(new java.awt.Dimension(20, 26));
        jLabel8.setMinimumSize(new java.awt.Dimension(20, 26));
        jLabel8.setPreferredSize(new java.awt.Dimension(20, 26));
        jPanel1.add(jLabel8);

        add(jPanel1);

        jLabel9.setPreferredSize(new java.awt.Dimension(20, 25));
        add(jLabel9);

        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator5.setPreferredSize(new java.awt.Dimension(20, 25));
        add(jSeparator5);

        jLabelFechaterminacion.setText("FECHA TERMINACIÓN : ");
        jLabelFechaterminacion.setPreferredSize(new java.awt.Dimension(140, 25));
        add(jLabelFechaterminacion);

        jPanel8.setBackground(ClaseGeneral.campo);
        jPanel8.setMaximumSize(new java.awt.Dimension(140, 25));
        jPanel8.setMinimumSize(new java.awt.Dimension(140, 25));
        jPanel8.setPreferredSize(new java.awt.Dimension(140, 25));
        jPanel8.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        fechaterminacion.setFocusable(false);
        fechaterminacion.setMaximumSize(new java.awt.Dimension(120, 25));
        fechaterminacion.setMinimumSize(new java.awt.Dimension(120, 25));
        fechaterminacion.setPreferredSize(new java.awt.Dimension(120, 25));
        jPanel8.add(fechaterminacion);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel10.setMaximumSize(new java.awt.Dimension(20, 26));
        jLabel10.setMinimumSize(new java.awt.Dimension(20, 26));
        jLabel10.setPreferredSize(new java.awt.Dimension(20, 26));
        jPanel8.add(jLabel10);

        add(jPanel8);

        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField4.setEnabled(false);
        jTextField4.setFocusable(false);
        jTextField4.setMargin(new java.awt.Insets(2, 4, 2, 4));
        jTextField4.setOpaque(false);
        jTextField4.setPreferredSize(new java.awt.Dimension(160, 25));
        add(jTextField4);

        jLabel11.setPreferredSize(new java.awt.Dimension(810, 10));
        add(jLabel11);

        jPanelObservacion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "OBSERVACIÓN", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13))); // NOI18N
        jPanelObservacion.setPreferredSize(new java.awt.Dimension(810, 120));
        jPanelObservacion.setLayout(new java.awt.BorderLayout());

        jScrollPane2.setPreferredSize(new java.awt.Dimension(430, 70));

        observacion.setBackground(ClaseGeneral.campo);
        observacion.setColumns(20);
        observacion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        observacion.setLineWrap(true);
        observacion.setRows(5);
        observacion.setWrapStyleWord(true);
        observacion.setMargin(new java.awt.Insets(2, 5, 2, 5));
        observacion.setPreferredSize(new java.awt.Dimension(430, 70));
        observacion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TextAreaFocusGained(evt);
            }
        });
        jScrollPane2.setViewportView(observacion);

        jPanelObservacion.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        add(jPanelObservacion);
    }// </editor-fold>//GEN-END:initComponents

    private void TextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TextFieldFocusGained
        javax.swing.JTextField componente = (javax.swing.JTextField) evt.getComponent();
        componente.selectAll();
        componente.requestFocus();
    }//GEN-LAST:event_TextFieldFocusGained

    private void TextAreaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TextAreaFocusGained
        javax.swing.JTextArea componente = (javax.swing.JTextArea) evt.getSource();
        componente.selectAll();
        componente.requestFocus();
    }//GEN-LAST:event_TextAreaFocusGained

    private void botonBuscarFkterceroordenadorgastoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarFkterceroordenadorgastoActionPerformed
        javax.swing.JButton componente = (javax.swing.JButton) evt.getSource();
        String eventoFktercero = componente.getName();
//        System.out.println("EVENTO = "+eventoFktercero);
        ExternoPanelFktercero panelFktercero = new ExternoPanelFktercero();
        ClaseMensaje.panel(panelFktercero);

        if (eventoFktercero.equals("botonBuscarFkterceroordenadorgasto")) {
            if (!panelFktercero.fktercero.equals("Seleccione - ")) {
                fkterceroordenadorgasto.setText(panelFktercero.fktercero);
            }
        }
    }//GEN-LAST:event_botonBuscarFkterceroordenadorgastoActionPerformed

    private void botonAyuda1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAyuda1ActionPerformed
        ClaseMensaje.informacion("<html><body>"
                + "Elija su opción según el tipo de Personal<br/>"
                + "<ul>"
                + "  <li>Acuerdo No. 025 de 2014 <b>\"Ayudas Económicas - Estudiantes\"</b></li>"
                + "  <li>Acuerdo No. 025 de 2014 y Resolución No. 2252 <b>\"Personal Docente y Motoristas (Año 2013)\"</b></li>"
                + "  <li>Acuerdo No. 025 de 2014 y Resolución No. 2253 <b>\"Personal No Nombrado y No Docente\"</b></li>"
                + "  <li>Acuerdo No. 025 de 2014 y Resolución No. 2784 <b>\"Personal Docente y Motoristas (Año 2014)\"</b></li>"
                + "  <li>Acuerdo No. 025 de 2014 y Resolución No. 3478 <b>\"Personal Docente y Motoristas (Año 2015)\"</b></li>"
                + "  <li>Acuerdo No. 004 de 1996 <b>\"Ayudas Económicas - Estudiantes\"</b></li>"
                + "  <li>Acuerdo No. 004 de 1996 y Resolución No. 2252 <b>\"Personal Docente y Motoristas (Año 2013)\"</b></li>"
                + "  <li>Acuerdo No. 004 de 1996 y Resolución No. 2253 <b>\"Personal No Nombrado y No Docente\"</b></li>"
                + "  <li>Acuerdo No. 004 de 1996 y Resolución No. 2784 <b>\"Personal Docente y Motoristas (Año 2014)\"</b></li>"
                + "  <li>Acuerdo No. 004 de 1996 y Resolución No. 3478 <b>\"Personal Docente y Motoristas (Año 2015)\"</b></li>"
                + "  <li>Resolución No. 013 <b>\"Docentes Ocasionales\"</b></li></ul>"
                + "</body></html>");
    }//GEN-LAST:event_botonAyuda1ActionPerformed

    private void botonAyuda2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAyuda2ActionPerformed
        ClaseMensaje.informacion("<html><body>"
                + "Elija su opción según el subgrupo<br/>"
                + "<ul>"
                + "  <li>AYUDA ECONOMICA <b>\"101\"</b></li>"
                + "  <li>CANDIDATOS A ELECCIONES</b></li>"
                + "  <li>COMISION ACADEMICA Y VIATICOS <b>\"072\"</b></li>"
                + "  <li>COMISION DE SERVICIOS Y VIATICOS <b>\"072\"</b></li>"
                + "  <li>DOCENTES OCASIONALES <b>\"040\"</b></li>"
                + "  <li>GASTOS DE VIAJE <b>\"072\"</b></li>"
                + "  <li>GASTOS DE VIAJE Y TIQUETES AEREOS <b>\"072 y 073\"</b></li>"
                + "  <li>TIQUETES AEREOS <b>\"073\"</b></li>"
                + "</ul>"
                + "</body></html>");
    }//GEN-LAST:event_botonAyuda2ActionPerformed

    public void metodoInsertar() {
        ClaseGeneral.resoluciones = new Resoluciones();
        ClaseGeneral.resolucionesPK = new ResolucionesPK();
        ClaseGeneral.resolucionesPK.setId(Integer.parseInt("" + id.getText()));
        ClaseGeneral.resoluciones.setAcuerdo("" + acuerdo.getSelectedItem());
        ClaseGeneral.resolucionesPK.setAno(Integer.parseInt("" + ano.getText()));
        ClaseGeneral.resoluciones.setFecha(fecha.getDate());
        ClaseGeneral.resoluciones.setFechainicio(fechainicio.getDate());
        ClaseGeneral.resoluciones.setFechaterminacion(fechaterminacion.getDate());
        ClaseGeneral.resoluciones.setFkterceroordenadorgasto("" + fkterceroordenadorgasto.getText());
        ClaseGeneral.resoluciones.setObservacion("" + observacion.getText());
        ClaseGeneral.resoluciones.setTipo("" + tipo.getSelectedItem());
        ClaseGeneral.resoluciones.setVehiculo("" + vehiculo.getText());
        ClaseGeneral.resoluciones.setIsfindesemana(isfindesemana.isSelected());
        ClaseGeneral.resoluciones.setResolucionPK(ClaseGeneral.resolucionesPK);

        if (ClaseGeneral.controlResoluciones.verify(ClaseGeneral.resoluciones)) {
            try {
                ClaseGeneral.controlResoluciones.create(ClaseGeneral.resoluciones);
            } catch (Exception ex) {
                Logger.getLogger(PanelResoluciones.class.getName()).log(Level.SEVERE, null, ex);
            }

            estado = "nuevo";
        }
    }

    public void metodoConsultar() {
        try {
            id.setText("" + ClaseGeneral.resoluciones.getResolucionPK().getId());
            acuerdo.setSelectedItem("" + ClaseGeneral.resoluciones.getAcuerdo());
            ano.setText("" + ClaseGeneral.resoluciones.getResolucionPK().getAno());
            fecha.setDate(ClaseGeneral.resoluciones.getFecha());
            fechainicio.setDate(ClaseGeneral.resoluciones.getFechainicio());
            fechaterminacion.setDate(ClaseGeneral.resoluciones.getFechaterminacion());
            fkterceroordenadorgasto.setText("" + ClaseGeneral.resoluciones.getFkterceroordenadorgasto());
            observacion.setText("" + ClaseGeneral.resoluciones.getObservacion());
            tipo.setSelectedItem("" + ClaseGeneral.resoluciones.getTipo());
            vehiculo.setText("" + ClaseGeneral.resoluciones.getVehiculo());
            isfindesemana.setSelected(ClaseGeneral.resoluciones.getIsfindesemana());

            /**/ FramePrincipal.metodoEntidadSeleccionada("Resoluciones", "Resolucion *");
            // ClaseGeneral.parametro = "CAST(ID AS TEXT)";
            // ClaseGeneral.valor = id.getText();

            estado = "consultar";
        } catch (Exception ex) {
            Logger.getLogger(PanelResoluciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void metodoActualizar() {
        Resoluciones resolucionId = ClaseGeneral.resoluciones;
        resolucionId.setResolucionPK(ClaseGeneral.resoluciones.getResolucionPK());
        ClaseGeneral.resoluciones = new Resoluciones();
        ClaseGeneral.resolucionesPK = new ResolucionesPK();
        ClaseGeneral.resolucionesPK.setId(Integer.parseInt("" + id.getText()));
        ClaseGeneral.resoluciones.setAcuerdo("" + acuerdo.getSelectedItem());
        ClaseGeneral.resolucionesPK.setAno(Integer.parseInt("" + ano.getText()));
        ClaseGeneral.resoluciones.setFecha(fecha.getDate());
        ClaseGeneral.resoluciones.setFechainicio(fechainicio.getDate());
        ClaseGeneral.resoluciones.setFechaterminacion(fechaterminacion.getDate());
        ClaseGeneral.resoluciones.setFkterceroordenadorgasto("" + fkterceroordenadorgasto.getText());
        ClaseGeneral.resoluciones.setObservacion("" + observacion.getText());
        ClaseGeneral.resoluciones.setTipo("" + tipo.getSelectedItem());
        ClaseGeneral.resoluciones.setVehiculo("" + vehiculo.getText());
        ClaseGeneral.resoluciones.setIsfindesemana(isfindesemana.isSelected());
        ClaseGeneral.resoluciones.setResolucionPK(ClaseGeneral.resolucionesPK);
        if (ClaseGeneral.controlResoluciones.verify(ClaseGeneral.resoluciones)) {
            try {
                ClaseGeneral.controlResoluciones.edit(ClaseGeneral.resoluciones, resolucionId);
            } catch (Exception ex) {
                Logger.getLogger(PanelResoluciones.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void metodoAnular() {
        try {
            observacion.append("\n[ANULADO]");
            metodoActualizar();
            
            ClaseGeneral.controlTercerosresoluciones.destroyFkresolucionAno(ClaseGeneral.resoluciones);
            ClaseGeneral.controlSoportesresoluciones.destroyFkresolucionAno(ClaseGeneral.resoluciones);
        } catch (Exception ex) {
            Logger.getLogger(PanelResoluciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox acuerdo;
    public javax.swing.JTextField ano;
    private javax.swing.JButton botonAyuda1;
    private javax.swing.JButton botonAyuda2;
    private javax.swing.JButton botonBuscarFkterceroordenadorgasto;
    public org.jdesktop.swingx.JXDatePicker fecha;
    private org.jdesktop.swingx.JXDatePicker fechainicio;
    private org.jdesktop.swingx.JXDatePicker fechaterminacion;
    private javax.swing.JTextField fkterceroordenadorgasto;
    private javax.swing.JTextField id;
    private javax.swing.JCheckBox isfindesemana;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelAcuerdo;
    private javax.swing.JLabel jLabelAno;
    private javax.swing.JLabel jLabelFecha;
    private javax.swing.JLabel jLabelFechainicio;
    private javax.swing.JLabel jLabelFechaterminacion;
    private javax.swing.JLabel jLabelFkterceroordenadorgasto;
    private javax.swing.JLabel jLabelId;
    private javax.swing.JLabel jLabelTipo;
    private javax.swing.JLabel jLabelVehiculo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanelObservacion;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextArea observacion;
    private javax.swing.JPanel panelBalanceSoportes;
    private javax.swing.JScrollPane scrollPaneBalanceSoportes;
    private javax.swing.JTextArea textAreaBalanceSoportes;
    private javax.swing.JComboBox tipo;
    private javax.swing.JTextField vehiculo;
    // End of variables declaration//GEN-END:variables
}
