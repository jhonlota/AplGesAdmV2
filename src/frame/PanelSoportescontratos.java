/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PanelSoportescontratosContratos.java
 *
 * Created on 16/01/2012, 05:14:48 PM
 */
package frame;

import clases.ClaseGeneral;
import clases.ClaseInformacion;
import entidades.Soportescontratos;
import entidades.SoportescontratosPK;
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
public class PanelSoportescontratos extends javax.swing.JPanel {

    private List lista = new ArrayList();
    private ClaseInformacion informacion = new ClaseInformacion();

    /**
     * Creates new form PanelSoportescontratosContratos
     */
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public PanelSoportescontratos() {
        initComponents();
        
        subgrupo.setEditable(true);
        cinfo.setEditable(true);

        AutoCompleteDecorator.decorate(subgrupo);
        AutoCompleteDecorator.decorate(cinfo);

        fecha.setFormats(new SimpleDateFormat("yyyy-MM-dd"));
        fecha.setDate(new Date(ClaseInformacion.calendario.getTimeInMillis()));

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

        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        fkcontrato = new javax.swing.JTextField();
        jTextField15 = new javax.swing.JTextField();
        jLabel72 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tipo = new javax.swing.JComboBox();
        numero = new javax.swing.JTextField();
        cuenta = new javax.swing.JTextField();
        actividad = new javax.swing.JTextField();
        subgrupo = new javax.swing.JComboBox();
        ccostos = new javax.swing.JTextField();
        cinfo = new javax.swing.JComboBox();
        valor = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        fecha = new org.jdesktop.swingx.JXDatePicker();
        jLabel29 = new javax.swing.JLabel();
        jTextField16 = new javax.swing.JTextField();
        valorTotal = new javax.swing.JTextField();
        jLabel74 = new javax.swing.JLabel();
        jScrollPane = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("C. COSTOS");
        jLabel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel7.setPreferredSize(new java.awt.Dimension(90, 25));

        setName("panelSoportescontratos"); // NOI18N
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

        jLabel72.setPreferredSize(new java.awt.Dimension(810, 25));
        add(jLabel72);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setPreferredSize(new java.awt.Dimension(810, 70));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("TIPO SOPORTE");
        jLabel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel10.setPreferredSize(new java.awt.Dimension(140, 25));
        jPanel1.add(jLabel10);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("NÚMERO");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel2.setPreferredSize(new java.awt.Dimension(100, 25));
        jPanel1.add(jLabel2);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("FUENTE");
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel3.setPreferredSize(new java.awt.Dimension(80, 25));
        jPanel1.add(jLabel3);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("ACTIVIDAD");
        jLabel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel4.setPreferredSize(new java.awt.Dimension(80, 25));
        jPanel1.add(jLabel4);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("EGRESOS");
        jLabel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel5.setPreferredSize(new java.awt.Dimension(80, 25));
        jPanel1.add(jLabel5);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("C. COSTOS");
        jLabel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel6.setPreferredSize(new java.awt.Dimension(80, 25));
        jPanel1.add(jLabel6);

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("C. INFO");
        jLabel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel8.setPreferredSize(new java.awt.Dimension(80, 25));
        jPanel1.add(jLabel8);

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("VALOR");
        jLabel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel9.setPreferredSize(new java.awt.Dimension(120, 25));
        jPanel1.add(jLabel9);

        tipo.setBackground(ClaseGeneral.campo);
        tipo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione", "Ajuste Crédito", "Ajuste Debito", "Certificado", "Registro" }));
        tipo.setPreferredSize(new java.awt.Dimension(140, 25));
        jPanel1.add(tipo);

        numero.setBackground(ClaseGeneral.campo);
        numero.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        numero.setText("0");
        numero.setMargin(new java.awt.Insets(2, 4, 2, 4));
        numero.setPreferredSize(new java.awt.Dimension(100, 25));
        numero.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TextFieldFocusGained(evt);
            }
        });
        jPanel1.add(numero);

        cuenta.setBackground(ClaseGeneral.campo);
        cuenta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cuenta.setText("0");
        cuenta.setMargin(new java.awt.Insets(2, 4, 2, 4));
        cuenta.setPreferredSize(new java.awt.Dimension(80, 25));
        cuenta.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TextFieldFocusGained(evt);
            }
        });
        jPanel1.add(cuenta);

        actividad.setBackground(ClaseGeneral.campo);
        actividad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        actividad.setText("0");
        actividad.setMargin(new java.awt.Insets(2, 4, 2, 4));
        actividad.setPreferredSize(new java.awt.Dimension(80, 25));
        actividad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TextFieldFocusGained(evt);
            }
        });
        jPanel1.add(actividad);

        subgrupo.setBackground(ClaseGeneral.campo);
        subgrupo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        subgrupo.setModel(ClaseGeneral.controlSubgrupo.COMBOCodigoInSubgrupoBy());
        subgrupo.setSelectedItem("0");
        subgrupo.setOpaque(false);
        subgrupo.setPreferredSize(new java.awt.Dimension(80, 25));
        jPanel1.add(subgrupo);

        ccostos.setBackground(ClaseGeneral.campo);
        ccostos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ccostos.setText("0");
        ccostos.setMargin(new java.awt.Insets(2, 4, 2, 4));
        ccostos.setPreferredSize(new java.awt.Dimension(80, 25));
        ccostos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TextFieldFocusGained(evt);
            }
        });
        jPanel1.add(ccostos);

        cinfo.setBackground(ClaseGeneral.campo);
        cinfo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cinfo.setModel(ClaseGeneral.controlCinfo.COMBOCodigoInCinfoBy());
        cinfo.setSelectedItem("0");
        cinfo.setOpaque(false);
        cinfo.setPreferredSize(new java.awt.Dimension(80, 25));
        jPanel1.add(cinfo);

        valor.setBackground(ClaseGeneral.campo);
        valor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        valor.setText("0");
        valor.setMargin(new java.awt.Insets(2, 4, 2, 4));
        valor.setPreferredSize(new java.awt.Dimension(120, 25));
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
        jPanel1.add(valor);

        add(jPanel1);

        jLabel50.setText("FECHA : ");
        jLabel50.setPreferredSize(new java.awt.Dimension(60, 25));
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

        jTextField16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField16.setEnabled(false);
        jTextField16.setFocusable(false);
        jTextField16.setMargin(new java.awt.Insets(2, 4, 2, 4));
        jTextField16.setOpaque(false);
        jTextField16.setPreferredSize(new java.awt.Dimension(465, 25));
        add(jTextField16);

        valorTotal.setBackground(ClaseGeneral.verde);
        valorTotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        valorTotal.setForeground(new java.awt.Color(255, 0, 0));
        valorTotal.setText("0");
        valorTotal.setFocusable(false);
        valorTotal.setMargin(new java.awt.Insets(2, 4, 2, 4));
        valorTotal.setPreferredSize(new java.awt.Dimension(130, 25));
        add(valorTotal);

        jLabel74.setPreferredSize(new java.awt.Dimension(810, 25));
        add(jLabel74);

        jScrollPane.setPreferredSize(new java.awt.Dimension(810, 370));

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "TIPO SOPORTE", "NÚMERO", "FUENTE", "ACTIVIDAD", "EGRESOS", "C. COSTOS", "C. INFO", "VALOR"
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
        ClaseGeneral.soportescontratos = new Soportescontratos();
        ClaseGeneral.soportescontratosPK = new SoportescontratosPK();
        ClaseGeneral.soportescontratosPK.setFkcontrato(fkcontrato.getText());
        ClaseGeneral.soportescontratosPK.setId(0);
        ClaseGeneral.soportescontratos.setSoportescontratosPK(ClaseGeneral.soportescontratosPK);
        ClaseGeneral.soportescontratos.setTipo("" + tipo.getSelectedItem());
        ClaseGeneral.soportescontratos.setNumero(numero.getText());
        ClaseGeneral.soportescontratos.setFecha(fecha.getDate());
        ClaseGeneral.soportescontratos.setCuenta(cuenta.getText());
        ClaseGeneral.soportescontratos.setActividad(actividad.getText());
        ClaseGeneral.soportescontratos.setSubgrupo("" + subgrupo.getSelectedItem());
        ClaseGeneral.soportescontratos.setCcostos(ccostos.getText());
        ClaseGeneral.soportescontratos.setCinfo("" + cinfo.getSelectedItem());
        ClaseGeneral.soportescontratos.setValor(BigDecimal.valueOf(Long.parseLong("" + valor.getText().trim().replace(".", ""))));

        if (ClaseGeneral.controlSoportescontratos.verify(ClaseGeneral.soportescontratos)) {
            try {
                ClaseGeneral.controlSoportescontratos.create(ClaseGeneral.soportescontratos);
            } catch (Exception ex) {
                Logger.getLogger(PanelSoportescontratos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void metodoConsultar() {
        try {
            fkcontrato.setText(ClaseGeneral.soportescontratos.getSoportescontratosPK().getFkcontrato());
            tipo.setSelectedItem(ClaseGeneral.soportescontratos.getTipo());
            numero.setText(ClaseGeneral.soportescontratos.getNumero());
            fecha.setDate(ClaseGeneral.soportescontratos.getFecha());
            cuenta.setText(ClaseGeneral.soportescontratos.getCuenta());
            actividad.setText(ClaseGeneral.soportescontratos.getActividad());
            subgrupo.setSelectedItem(ClaseGeneral.soportescontratos.getSubgrupo());
            ccostos.setText(ClaseGeneral.soportescontratos.getCcostos());
            cinfo.setSelectedItem(ClaseGeneral.soportescontratos.getCinfo());
            valor.setText("" + ClaseInformacion.formatoDecimal.format(ClaseGeneral.soportescontratos.getValor()));

            fkcontrato.setFocusable(false);
            numero.setFocusable(false);
            tipo.setEnabled(false);
        } catch (Exception ex) {
            Logger.getLogger(PanelResoluciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void metodoActualizar() {
        Soportescontratos soportescontratosId = ClaseGeneral.soportescontratos;
        soportescontratosId.setSoportescontratosPK(ClaseGeneral.soportescontratos.getSoportescontratosPK());

        ClaseGeneral.soportescontratos = new Soportescontratos();
        ClaseGeneral.soportescontratosPK = new SoportescontratosPK();
        ClaseGeneral.soportescontratosPK.setFkcontrato(fkcontrato.getText());
        //ClaseGeneral.soportescontratosPK.setId();
        ClaseGeneral.soportescontratos.setSoportescontratosPK(ClaseGeneral.soportescontratosPK);
        ClaseGeneral.soportescontratos.setTipo("" + tipo.getSelectedItem());
        ClaseGeneral.soportescontratos.setNumero(numero.getText());
        ClaseGeneral.soportescontratos.setFecha(fecha.getDate());
        ClaseGeneral.soportescontratos.setCuenta(cuenta.getText());
        ClaseGeneral.soportescontratos.setActividad(actividad.getText());
        ClaseGeneral.soportescontratos.setSubgrupo("" + subgrupo.getSelectedItem());
        ClaseGeneral.soportescontratos.setCcostos(ccostos.getText());
        ClaseGeneral.soportescontratos.setCinfo("" + cinfo.getSelectedItem());
        ClaseGeneral.soportescontratos.setValor(BigDecimal.valueOf(Long.parseLong("" + valor.getText().trim().replace(".", ""))));

        if (ClaseGeneral.controlSoportescontratos.verify(ClaseGeneral.soportescontratos)) {
            try {
                ClaseGeneral.controlSoportescontratos.edit(ClaseGeneral.soportescontratos, soportescontratosId);
            } catch (Exception ex) {
                Logger.getLogger(PanelSoportescontratos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void metodoEliminar() {
        try {
            ClaseGeneral.soportescontratosPK = new SoportescontratosPK();
            ClaseGeneral.soportescontratosPK.setFkcontrato(fkcontrato.getText());
            ClaseGeneral.soportescontratosPK.setId(ClaseGeneral.soportescontratos.getSoportescontratosPK().getId());

            ClaseGeneral.controlSoportescontratos.destroy(ClaseGeneral.soportescontratosPK);
        } catch (Exception ex) {
            Logger.getLogger(PanelSoportescontratos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void metodoMostrar() {
        BigDecimal valTotal = BigDecimal.ZERO;
        ClaseGeneral.soportescontratos = new Soportescontratos();
        lista = ClaseGeneral.controlSoportescontratos.findAllInSoportescontratosByFkcontrato(fkcontrato.getText());

        jTable.getColumnModel().getColumn(7).setCellRenderer(informacion.modeloDerecha);

        for (int i = 0; i < 100; i++) {
            jTable.setValueAt("", i, 0);
            jTable.setValueAt("", i, 1);
            jTable.setValueAt("", i, 2);
            jTable.setValueAt("", i, 3);
            jTable.setValueAt("", i, 4);
            jTable.setValueAt("", i, 5);
            jTable.setValueAt("", i, 6);
            jTable.setValueAt("", i, 7);
        }

        int i = 0;
        for (Object lista1 : lista) {
            ClaseGeneral.soportescontratos = (Soportescontratos) lista1;
            jTable.setValueAt("" + ClaseGeneral.soportescontratos.getTipo(), i, 0);
            jTable.setValueAt("" + ClaseGeneral.soportescontratos.getNumero(), i, 1);
            jTable.setValueAt("" + ClaseGeneral.soportescontratos.getCuenta(), i, 2);
            jTable.setValueAt("" + ClaseGeneral.soportescontratos.getActividad(), i, 3);
            jTable.setValueAt("" + ClaseGeneral.soportescontratos.getSubgrupo(), i, 4);
            jTable.setValueAt("" + ClaseGeneral.soportescontratos.getCcostos(), i, 5);
            jTable.setValueAt("" + ClaseGeneral.soportescontratos.getCinfo(), i, 6);
            jTable.setValueAt("" + ClaseInformacion.formatoDecimal.format(ClaseGeneral.soportescontratos.getValor()), i, 7);

            if (ClaseGeneral.soportescontratos.getTipo().equals("Registro")
                    || ClaseGeneral.soportescontratos.getTipo().equals("Ajuste Debito")) {
                valTotal = valTotal.add(ClaseGeneral.soportescontratos.getValor());
            } else if (ClaseGeneral.soportescontratos.getTipo().equals("Ajuste Crédito")) {
                valTotal = valTotal.subtract(ClaseGeneral.soportescontratos.getValor());
            }
            i++;
        }

        jTable.clearSelection();
        jTable.getColumnModel().getColumn(0).setPreferredWidth(150);
        jTable.getColumnModel().getColumn(1).setPreferredWidth(110);
        jTable.getColumnModel().getColumn(2).setPreferredWidth(85);
        jTable.getColumnModel().getColumn(3).setPreferredWidth(85);
        jTable.getColumnModel().getColumn(4).setPreferredWidth(85);
        jTable.getColumnModel().getColumn(5).setPreferredWidth(85);
        jTable.getColumnModel().getColumn(6).setPreferredWidth(85);
        jTable.getColumnModel().getColumn(7).setPreferredWidth(125);
        valorTotal.setText("" + ClaseInformacion.formatoDecimal.format(valTotal));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField actividad;
    public javax.swing.JTextField ccostos;
    public javax.swing.JComboBox cinfo;
    public javax.swing.JTextField cuenta;
    private org.jdesktop.swingx.JXDatePicker fecha;
    private javax.swing.JTextField fkcontrato;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel9;
    public javax.swing.JScrollPane jScrollPane;
    public javax.swing.JTable jTable;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField numero;
    public javax.swing.JComboBox subgrupo;
    private javax.swing.JComboBox tipo;
    private javax.swing.JTextField valor;
    private javax.swing.JTextField valorTotal;
    // End of variables declaration//GEN-END:variables
}
