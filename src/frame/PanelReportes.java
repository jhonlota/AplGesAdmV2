/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ExternoPanelInformes.java
 *
 * Created on 27/11/2012, 04:59:29 PM
 */
package frame;

import clases.ClaseGeneral;
import clases.ClaseInformacion;
import clases.ClaseInformes;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author Jhon Lopez
 */
public class PanelReportes extends javax.swing.JPanel {

    ClaseInformes informes = new ClaseInformes();
    private List listaCALC = new ArrayList();
    private ClaseInformacion informacion = new ClaseInformacion();
    private FrameCarga frameCarga = new FrameCarga();
    private Thread hilo1 = new ThreadCargaCuentaCUENTAINTERNA();
    private Thread hilo2 = new ThreadCargaCUENTAINTERNA_SALDOSCAJA();
    private Thread hilo3 = new ThreadCargaCUENTAINTERNA_TOTALINGRESOS();
    private Thread hilo4 = new ThreadCargaComprobanteCUENTAINTERNA();
    private Thread hilo5 = new ThreadCargaCUENTAINTERNA_TOTALCOMPROBANTE();
    private Thread hilo6 = new ThreadCargaResumenegresosreembolso();
    private Thread hilo7 = new ThreadCargaComprobantesnoreembolsados();

    /**
     * Creates new form ExternoPanelInformes
     */
    public PanelReportes() {
        initComponents();
        /**/
        /**///Oculto debido a que no genera ningun beneficio, ya exite un informe igual, 
        //queda a la espera de ver si el otro es funcional, o debe colocarse nuevamnte en el PanelCombrobante.

        cinfo_2.setVisible(false);
        cinfo_3.setVisible(false);
        cinfo_5.setVisible(false);
        jLabel_23.setVisible(false);
        jLabel_24.setVisible(false);
        jLabel_25.setVisible(false);
        jTextField_29.setVisible(false);
        jLabel_36.setVisible(false);
        jLabel_37.setVisible(false);
        jLabel_38.setVisible(false);
        jLabel_59.setVisible(false);
        jLabel_62.setVisible(false);
        jLabel_63.setVisible(false);
        jLabel_64.setVisible(false);
        jLabel_60.setVisible(false);
        jTextField_9.setVisible(false);
        jTextField_10.setVisible(false);
        jTextField_13.setVisible(false);
        jTextField_14.setVisible(false);
        jTextField_24.setVisible(false);
        jTextField_25.setVisible(false);
        jTextField_36.setVisible(false);
        jSeparator4.setVisible(false);
        cuentainterna_2.setVisible(false);
        cuentainterna_3.setVisible(false);
        cuentainterna_5.setVisible(false);
        fechainicial_5.setVisible(false);
        fechafinal_5.setVisible(false);
        /**/

        fechainicial_1.setFormats(new SimpleDateFormat("yyyy-MM-dd"));
        fechafinal_1.setFormats(new SimpleDateFormat("yyyy-MM-dd"));
        fechainicial_2.setFormats(new SimpleDateFormat("yyyy-MM-dd"));
        fechafinal_2.setFormats(new SimpleDateFormat("yyyy-MM-dd"));
        fechainicial_3.setFormats(new SimpleDateFormat("yyyy-MM-dd"));
        fechafinal_3.setFormats(new SimpleDateFormat("yyyy-MM-dd"));
        fechainicial_5.setFormats(new SimpleDateFormat("yyyy-MM-dd"));
        fechafinal_5.setFormats(new SimpleDateFormat("yyyy-MM-dd"));

        fechainicial_1.setDate(new Date(ClaseInformacion.calendario.getTimeInMillis()));
        fechafinal_1.setDate(new Date(ClaseInformacion.calendario.getTimeInMillis()));
        fechainicial_2.setDate(new Date(ClaseInformacion.calendario.getTimeInMillis()));
        fechafinal_2.setDate(new Date(ClaseInformacion.calendario.getTimeInMillis()));
        fechainicial_3.setDate(new Date(ClaseInformacion.calendario.getTimeInMillis()));
        fechafinal_3.setDate(new Date(ClaseInformacion.calendario.getTimeInMillis()));
        fechainicial_5.setDate(new Date(ClaseInformacion.calendario.getTimeInMillis()));
        fechafinal_5.setDate(new Date(ClaseInformacion.calendario.getTimeInMillis()));

        ano_4.setText(ClaseGeneral.controlUtilidades.anoServidor());
        ano_5.setText(ClaseGeneral.controlUtilidades.anoServidor());
        ano_6.setText(ClaseGeneral.controlUtilidades.anoServidor());
        ano_7.setText(ClaseGeneral.controlUtilidades.anoServidor());

        tipopago_4.setEditable(true);
        fechaaplicacion_4.setEditable(true);
        tipopago_5.setEditable(true);
        tipopago_6.setEditable(true);
        fechaaplicacion_6.setEditable(true);
        AutoCompleteDecorator.decorate(tipopago_4);
        AutoCompleteDecorator.decorate(fechaaplicacion_4);
        AutoCompleteDecorator.decorate(tipopago_5);
        AutoCompleteDecorator.decorate(tipopago_6);
        AutoCompleteDecorator.decorate(fechaaplicacion_6);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel_3 = new javax.swing.JLabel();
        soporte_1 = new javax.swing.JTextField();
        jTextField_1 = new javax.swing.JTextField();
        jLabel_4 = new javax.swing.JLabel();
        soportesaldo_1 = new javax.swing.JTextField();
        jTextField_2 = new javax.swing.JTextField();
        jLabel_5 = new javax.swing.JLabel();
        fechainicial_1 = new org.jdesktop.swingx.JXDatePicker();
        jTextField_3 = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel_6 = new javax.swing.JLabel();
        fechafinal_1 = new org.jdesktop.swingx.JXDatePicker();
        jTextField_22 = new javax.swing.JTextField();
        jLabel_7 = new javax.swing.JLabel();
        jLabel_8 = new javax.swing.JLabel();
        cuentainterna_1 = new javax.swing.JTextField();
        jTextField_4 = new javax.swing.JTextField();
        jLabel_9 = new javax.swing.JLabel();
        jLabel_10 = new javax.swing.JLabel();
        cinfo_1 = new javax.swing.JTextField();
        jTextField_5 = new javax.swing.JTextField();
        jLabel_11 = new javax.swing.JLabel();
        jLabel_12 = new javax.swing.JLabel();
        cuenta_1 = new javax.swing.JTextField();
        jTextField_6 = new javax.swing.JTextField();
        jLabel_79 = new javax.swing.JLabel();
        jLabel_80 = new javax.swing.JLabel();
        subgrupo_1 = new javax.swing.JTextField();
        jTextField_30 = new javax.swing.JTextField();
        jLabel_13 = new javax.swing.JLabel();
        checkEstandar1 = new javax.swing.JCheckBox();
        checkSinSaldoEgreso1 = new javax.swing.JCheckBox();
        checkSinSaldoDescripcion1 = new javax.swing.JCheckBox();
        jLabel_14 = new javax.swing.JLabel();
        botonVerCuentaCUENTAINTERNA = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel_19 = new javax.swing.JLabel();
        soportesaldo_2 = new javax.swing.JTextField();
        jTextField_7 = new javax.swing.JTextField();
        jLabel_20 = new javax.swing.JLabel();
        fechainicial_2 = new org.jdesktop.swingx.JXDatePicker();
        jTextField_8 = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel_21 = new javax.swing.JLabel();
        fechafinal_2 = new org.jdesktop.swingx.JXDatePicker();
        jTextField_23 = new javax.swing.JTextField();
        jLabel_22 = new javax.swing.JLabel();
        jLabel_23 = new javax.swing.JLabel();
        cuentainterna_2 = new javax.swing.JTextField();
        jTextField_9 = new javax.swing.JTextField();
        jLabel_24 = new javax.swing.JLabel();
        jLabel_25 = new javax.swing.JLabel();
        cinfo_2 = new javax.swing.JTextField();
        jTextField_10 = new javax.swing.JTextField();
        jLabel_26 = new javax.swing.JLabel();
        cuenta_2 = new javax.swing.JTextField();
        jTextField_11 = new javax.swing.JTextField();
        jLabel_81 = new javax.swing.JLabel();
        jLabel_82 = new javax.swing.JLabel();
        subgrupo_2 = new javax.swing.JTextField();
        jTextField_31 = new javax.swing.JTextField();
        jLabel_27 = new javax.swing.JLabel();
        checkEstandar2 = new javax.swing.JCheckBox();
        checkConSubgrupos2 = new javax.swing.JCheckBox();
        jLabel_28 = new javax.swing.JLabel();
        botonVerCUENTAINTERNA_SALDOSCAJA = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel_33 = new javax.swing.JLabel();
        fechainicial_3 = new org.jdesktop.swingx.JXDatePicker();
        jTextField_12 = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel_34 = new javax.swing.JLabel();
        fechafinal_3 = new org.jdesktop.swingx.JXDatePicker();
        jTextField_35 = new javax.swing.JTextField();
        jLabel_35 = new javax.swing.JLabel();
        jLabel_36 = new javax.swing.JLabel();
        cuentainterna_3 = new javax.swing.JTextField();
        jTextField_13 = new javax.swing.JTextField();
        jLabel_37 = new javax.swing.JLabel();
        jLabel_38 = new javax.swing.JLabel();
        cinfo_3 = new javax.swing.JTextField();
        jTextField_14 = new javax.swing.JTextField();
        jLabel_39 = new javax.swing.JLabel();
        cuenta_3 = new javax.swing.JTextField();
        jTextField_15 = new javax.swing.JTextField();
        jLabel_78 = new javax.swing.JLabel();
        jLabel_40 = new javax.swing.JLabel();
        botonVerCUENTAINTERNA_TOTALINGRESOS = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel_45 = new javax.swing.JLabel();
        documento_4 = new javax.swing.JTextField();
        jTextField_16 = new javax.swing.JTextField();
        jLabel_46 = new javax.swing.JLabel();
        tipopago_4 = new javax.swing.JComboBox();
        jTextField_17 = new javax.swing.JTextField();
        jLabel_47 = new javax.swing.JLabel();
        fechaaplicacion_4 = new javax.swing.JComboBox();
        jTextField_18 = new javax.swing.JTextField();
        jLabel_76 = new javax.swing.JLabel();
        ano_4 = new javax.swing.JTextField();
        jTextField_33 = new javax.swing.JTextField();
        jLabel_48 = new javax.swing.JLabel();
        jLabel_49 = new javax.swing.JLabel();
        cuentainterna_4 = new javax.swing.JTextField();
        jTextField_19 = new javax.swing.JTextField();
        jLabel_50 = new javax.swing.JLabel();
        jLabel_51 = new javax.swing.JLabel();
        cinfo_4 = new javax.swing.JTextField();
        jTextField_20 = new javax.swing.JTextField();
        jLabel_83 = new javax.swing.JLabel();
        jLabel_84 = new javax.swing.JLabel();
        subgrupo_4 = new javax.swing.JTextField();
        jTextField_34 = new javax.swing.JTextField();
        jLabel_52 = new javax.swing.JLabel();
        checkEstandar_4 = new javax.swing.JCheckBox();
        checkAgrupadoComprobante_4 = new javax.swing.JCheckBox();
        jLabel_53 = new javax.swing.JLabel();
        botonVerComprobanteCUENTAINTERNA = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel_58 = new javax.swing.JLabel();
        tipopago_5 = new javax.swing.JComboBox();
        jTextField_21 = new javax.swing.JTextField();
        jLabel_59 = new javax.swing.JLabel();
        fechainicial_5 = new org.jdesktop.swingx.JXDatePicker();
        jTextField_29 = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel_60 = new javax.swing.JLabel();
        fechafinal_5 = new org.jdesktop.swingx.JXDatePicker();
        jTextField_36 = new javax.swing.JTextField();
        jLabel_75 = new javax.swing.JLabel();
        ano_5 = new javax.swing.JTextField();
        jTextField_32 = new javax.swing.JTextField();
        jLabel_61 = new javax.swing.JLabel();
        jLabel_62 = new javax.swing.JLabel();
        cuentainterna_5 = new javax.swing.JTextField();
        jTextField_24 = new javax.swing.JTextField();
        jLabel_63 = new javax.swing.JLabel();
        jLabel_64 = new javax.swing.JLabel();
        cinfo_5 = new javax.swing.JTextField();
        jTextField_25 = new javax.swing.JTextField();
        jLabel_77 = new javax.swing.JLabel();
        jLabel_65 = new javax.swing.JLabel();
        botonVerTotalComprobanteCUENTAINTERNA = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel_70 = new javax.swing.JLabel();
        tipopago_6 = new javax.swing.JComboBox();
        jTextField_26 = new javax.swing.JTextField();
        jLabel_71 = new javax.swing.JLabel();
        fechaaplicacion_6 = new javax.swing.JComboBox();
        jTextField_27 = new javax.swing.JTextField();
        jLabel_72 = new javax.swing.JLabel();
        ano_6 = new javax.swing.JTextField();
        jTextField_28 = new javax.swing.JTextField();
        jLabel_73 = new javax.swing.JLabel();
        jLabel_74 = new javax.swing.JLabel();
        botonVerResumenegresosreembolso = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel_86 = new javax.swing.JLabel();
        fechaaplicacion_7 = new javax.swing.JTextField();
        jTextField_38 = new javax.swing.JTextField();
        jLabel_87 = new javax.swing.JLabel();
        ano_7 = new javax.swing.JTextField();
        jTextField_39 = new javax.swing.JTextField();
        jLabel_88 = new javax.swing.JLabel();
        jLabel_89 = new javax.swing.JLabel();
        botonVerComprobantesnoreembolsados = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(550, 500));
        setLayout(new java.awt.BorderLayout());

        jTabbedPane1.setBackground(ClaseGeneral.boton);
        jTabbedPane1.setOpaque(true);

        jPanel1.setMaximumSize(new java.awt.Dimension(550, 520));
        jPanel1.setMinimumSize(new java.awt.Dimension(550, 520));
        jPanel1.setPreferredSize(new java.awt.Dimension(550, 520));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel_3.setText("SOPORTE : ");
        jLabel_3.setPreferredSize(new java.awt.Dimension(90, 25));
        jPanel1.add(jLabel_3);

        soporte_1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        soporte_1.setMargin(new java.awt.Insets(2, 4, 2, 4));
        soporte_1.setPreferredSize(new java.awt.Dimension(150, 25));
        jPanel1.add(soporte_1);

        jTextField_1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField_1.setEnabled(false);
        jTextField_1.setFocusable(false);
        jTextField_1.setMargin(new java.awt.Insets(2, 4, 2, 4));
        jTextField_1.setOpaque(false);
        jTextField_1.setPreferredSize(new java.awt.Dimension(560, 25));
        jPanel1.add(jTextField_1);

        jLabel_4.setText("SOPORTE (SALDO) : ");
        jLabel_4.setPreferredSize(new java.awt.Dimension(130, 25));
        jPanel1.add(jLabel_4);

        soportesaldo_1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        soportesaldo_1.setText("#SALDO");
        soportesaldo_1.setMargin(new java.awt.Insets(2, 4, 2, 4));
        soportesaldo_1.setName("SOPORTE"); // NOI18N
        soportesaldo_1.setPreferredSize(new java.awt.Dimension(150, 25));
        jPanel1.add(soportesaldo_1);

        jTextField_2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField_2.setEnabled(false);
        jTextField_2.setFocusable(false);
        jTextField_2.setMargin(new java.awt.Insets(2, 4, 2, 4));
        jTextField_2.setOpaque(false);
        jTextField_2.setPreferredSize(new java.awt.Dimension(520, 25));
        jPanel1.add(jTextField_2);

        jLabel_5.setText("FECHA PRESUPUESTAL INICIAL : ");
        jLabel_5.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanel1.add(jLabel_5);

        fechainicial_1.setFocusable(false);
        fechainicial_1.setMaximumSize(new java.awt.Dimension(120, 25));
        fechainicial_1.setMinimumSize(new java.awt.Dimension(120, 25));
        fechainicial_1.setPreferredSize(new java.awt.Dimension(120, 25));
        jPanel1.add(fechainicial_1);

        jTextField_3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField_3.setBorder(null);
        jTextField_3.setEnabled(false);
        jTextField_3.setFocusable(false);
        jTextField_3.setMargin(new java.awt.Insets(2, 4, 2, 4));
        jTextField_3.setOpaque(false);
        jTextField_3.setPreferredSize(new java.awt.Dimension(10, 25));
        jPanel1.add(jTextField_3);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setPreferredSize(new java.awt.Dimension(10, 25));
        jPanel1.add(jSeparator1);

        jLabel_6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel_6.setText("FINAL : ");
        jLabel_6.setPreferredSize(new java.awt.Dimension(55, 25));
        jPanel1.add(jLabel_6);

        fechafinal_1.setFocusable(false);
        fechafinal_1.setMaximumSize(new java.awt.Dimension(120, 25));
        fechafinal_1.setMinimumSize(new java.awt.Dimension(120, 25));
        fechafinal_1.setPreferredSize(new java.awt.Dimension(120, 25));
        jPanel1.add(fechafinal_1);

        jTextField_22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField_22.setEnabled(false);
        jTextField_22.setFocusable(false);
        jTextField_22.setMargin(new java.awt.Insets(2, 4, 2, 4));
        jTextField_22.setOpaque(false);
        jTextField_22.setPreferredSize(new java.awt.Dimension(265, 25));
        jPanel1.add(jTextField_22);

        jLabel_7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel_7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_7.setPreferredSize(new java.awt.Dimension(810, 10));
        jPanel1.add(jLabel_7);

        jLabel_8.setText("CUENTA INTERNA : ");
        jLabel_8.setPreferredSize(new java.awt.Dimension(120, 25));
        jPanel1.add(jLabel_8);

        cuentainterna_1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cuentainterna_1.setMargin(new java.awt.Insets(2, 4, 2, 4));
        cuentainterna_1.setPreferredSize(new java.awt.Dimension(85, 25));
        cuentainterna_1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textFieldFocusGained(evt);
            }
        });
        jPanel1.add(cuentainterna_1);

        jTextField_4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField_4.setEnabled(false);
        jTextField_4.setFocusable(false);
        jTextField_4.setMargin(new java.awt.Insets(2, 4, 2, 4));
        jTextField_4.setOpaque(false);
        jTextField_4.setPreferredSize(new java.awt.Dimension(595, 25));
        jPanel1.add(jTextField_4);

        jLabel_9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel_9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_9.setText("------>");
        jLabel_9.setPreferredSize(new java.awt.Dimension(50, 24));
        jPanel1.add(jLabel_9);

        jLabel_10.setText("C. INFO : ");
        jLabel_10.setPreferredSize(new java.awt.Dimension(65, 25));
        jPanel1.add(jLabel_10);

        cinfo_1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cinfo_1.setMargin(new java.awt.Insets(2, 4, 2, 4));
        cinfo_1.setPreferredSize(new java.awt.Dimension(85, 25));
        cinfo_1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textFieldFocusGained(evt);
            }
        });
        jPanel1.add(cinfo_1);

        jTextField_5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField_5.setEnabled(false);
        jTextField_5.setFocusable(false);
        jTextField_5.setMargin(new java.awt.Insets(2, 4, 2, 4));
        jTextField_5.setOpaque(false);
        jTextField_5.setPreferredSize(new java.awt.Dimension(595, 25));
        jPanel1.add(jTextField_5);

        jLabel_11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel_11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_11.setText("------>");
        jLabel_11.setPreferredSize(new java.awt.Dimension(50, 24));
        jPanel1.add(jLabel_11);

        jLabel_12.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel_12.setText("FUENTE : ");
        jLabel_12.setPreferredSize(new java.awt.Dimension(75, 25));
        jPanel1.add(jLabel_12);

        cuenta_1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cuenta_1.setText("04");
        cuenta_1.setMargin(new java.awt.Insets(2, 4, 2, 4));
        cuenta_1.setPreferredSize(new java.awt.Dimension(85, 25));
        cuenta_1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textFieldFocusGained(evt);
            }
        });
        jPanel1.add(cuenta_1);

        jTextField_6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField_6.setEnabled(false);
        jTextField_6.setFocusable(false);
        jTextField_6.setMargin(new java.awt.Insets(2, 4, 2, 4));
        jTextField_6.setOpaque(false);
        jTextField_6.setPreferredSize(new java.awt.Dimension(585, 25));
        jPanel1.add(jTextField_6);

        jLabel_79.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel_79.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_79.setText("------>");
        jLabel_79.setPreferredSize(new java.awt.Dimension(50, 24));
        jPanel1.add(jLabel_79);

        jLabel_80.setText("EGRESOS : ");
        jLabel_80.setPreferredSize(new java.awt.Dimension(85, 25));
        jPanel1.add(jLabel_80);

        subgrupo_1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        subgrupo_1.setMargin(new java.awt.Insets(2, 4, 2, 4));
        subgrupo_1.setPreferredSize(new java.awt.Dimension(85, 25));
        subgrupo_1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textFieldFocusGained(evt);
            }
        });
        jPanel1.add(subgrupo_1);

        jTextField_30.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField_30.setEnabled(false);
        jTextField_30.setFocusable(false);
        jTextField_30.setMargin(new java.awt.Insets(2, 4, 2, 4));
        jTextField_30.setOpaque(false);
        jTextField_30.setPreferredSize(new java.awt.Dimension(575, 25));
        jPanel1.add(jTextField_30);

        jLabel_13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel_13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_13.setPreferredSize(new java.awt.Dimension(810, 10));
        jPanel1.add(jLabel_13);

        checkEstandar1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        checkEstandar1.setSelected(true);
        checkEstandar1.setText("INFORME ESTANDAR");
        checkEstandar1.setPreferredSize(new java.awt.Dimension(810, 18));
        jPanel1.add(checkEstandar1);

        checkSinSaldoEgreso1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        checkSinSaldoEgreso1.setText("INFORME SIN SALDO Y SIN EGRESOS");
        checkSinSaldoEgreso1.setPreferredSize(new java.awt.Dimension(810, 18));
        jPanel1.add(checkSinSaldoEgreso1);

        checkSinSaldoDescripcion1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        checkSinSaldoDescripcion1.setText("INFORME SIN SALDOS Y SIN DESCRIPCION");
        checkSinSaldoDescripcion1.setPreferredSize(new java.awt.Dimension(810, 18));
        jPanel1.add(checkSinSaldoDescripcion1);

        jLabel_14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel_14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_14.setPreferredSize(new java.awt.Dimension(695, 24));
        jPanel1.add(jLabel_14);

        botonVerCuentaCUENTAINTERNA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos24/text_page.png"))); // NOI18N
        botonVerCuentaCUENTAINTERNA.setText("Ver pdf");
        botonVerCuentaCUENTAINTERNA.setFocusable(false);
        botonVerCuentaCUENTAINTERNA.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        botonVerCuentaCUENTAINTERNA.setName("botonVerCuentaCUENTAINTERNA"); // NOI18N
        botonVerCuentaCUENTAINTERNA.setPreferredSize(new java.awt.Dimension(110, 24));
        botonVerCuentaCUENTAINTERNA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVerCuentaCUENTAINTERNA(evt);
            }
        });
        jPanel1.add(botonVerCuentaCUENTAINTERNA);

        jTabbedPane1.addTab("MOVIMIENTO DE DISPONIBILIDAD DE CAJA (CUENTAS)", jPanel1);

        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel_19.setText("SOPORTE (SALDO) : ");
        jLabel_19.setPreferredSize(new java.awt.Dimension(130, 25));
        jPanel2.add(jLabel_19);

        soportesaldo_2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        soportesaldo_2.setText("#SALDO");
        soportesaldo_2.setMargin(new java.awt.Insets(2, 4, 2, 4));
        soportesaldo_2.setName("SOPORTE"); // NOI18N
        soportesaldo_2.setPreferredSize(new java.awt.Dimension(150, 25));
        jPanel2.add(soportesaldo_2);

        jTextField_7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField_7.setEnabled(false);
        jTextField_7.setFocusable(false);
        jTextField_7.setMargin(new java.awt.Insets(2, 4, 2, 4));
        jTextField_7.setOpaque(false);
        jTextField_7.setPreferredSize(new java.awt.Dimension(520, 25));
        jPanel2.add(jTextField_7);

        jLabel_20.setText("FECHA PRESUPUESTAL INICIAL : ");
        jLabel_20.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanel2.add(jLabel_20);

        fechainicial_2.setFocusable(false);
        fechainicial_2.setMaximumSize(new java.awt.Dimension(120, 25));
        fechainicial_2.setMinimumSize(new java.awt.Dimension(120, 25));
        fechainicial_2.setPreferredSize(new java.awt.Dimension(120, 25));
        jPanel2.add(fechainicial_2);

        jTextField_8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField_8.setBorder(null);
        jTextField_8.setEnabled(false);
        jTextField_8.setFocusable(false);
        jTextField_8.setMargin(new java.awt.Insets(2, 4, 2, 4));
        jTextField_8.setOpaque(false);
        jTextField_8.setPreferredSize(new java.awt.Dimension(10, 25));
        jPanel2.add(jTextField_8);

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator2.setPreferredSize(new java.awt.Dimension(10, 25));
        jPanel2.add(jSeparator2);

        jLabel_21.setText("FINAL : ");
        jLabel_21.setPreferredSize(new java.awt.Dimension(55, 25));
        jPanel2.add(jLabel_21);

        fechafinal_2.setFocusable(false);
        fechafinal_2.setMaximumSize(new java.awt.Dimension(120, 25));
        fechafinal_2.setMinimumSize(new java.awt.Dimension(120, 25));
        fechafinal_2.setPreferredSize(new java.awt.Dimension(120, 25));
        jPanel2.add(fechafinal_2);

        jTextField_23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField_23.setEnabled(false);
        jTextField_23.setFocusable(false);
        jTextField_23.setMargin(new java.awt.Insets(2, 4, 2, 4));
        jTextField_23.setOpaque(false);
        jTextField_23.setPreferredSize(new java.awt.Dimension(265, 25));
        jPanel2.add(jTextField_23);

        jLabel_22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel_22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_22.setPreferredSize(new java.awt.Dimension(810, 10));
        jPanel2.add(jLabel_22);

        jLabel_23.setText("CUENTA INTERNA : ");
        jLabel_23.setPreferredSize(new java.awt.Dimension(120, 25));
        jPanel2.add(jLabel_23);

        cuentainterna_2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cuentainterna_2.setMargin(new java.awt.Insets(2, 4, 2, 4));
        cuentainterna_2.setPreferredSize(new java.awt.Dimension(85, 25));
        cuentainterna_2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textFieldFocusGained(evt);
            }
        });
        jPanel2.add(cuentainterna_2);

        jTextField_9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField_9.setEnabled(false);
        jTextField_9.setFocusable(false);
        jTextField_9.setMargin(new java.awt.Insets(2, 4, 2, 4));
        jTextField_9.setOpaque(false);
        jTextField_9.setPreferredSize(new java.awt.Dimension(595, 25));
        jPanel2.add(jTextField_9);

        jLabel_24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel_24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_24.setText("------>");
        jLabel_24.setPreferredSize(new java.awt.Dimension(50, 24));
        jPanel2.add(jLabel_24);

        jLabel_25.setText("C. INFO : ");
        jLabel_25.setPreferredSize(new java.awt.Dimension(65, 25));
        jPanel2.add(jLabel_25);

        cinfo_2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cinfo_2.setMargin(new java.awt.Insets(2, 4, 2, 4));
        cinfo_2.setPreferredSize(new java.awt.Dimension(85, 25));
        cinfo_2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textFieldFocusGained(evt);
            }
        });
        jPanel2.add(cinfo_2);

        jTextField_10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField_10.setEnabled(false);
        jTextField_10.setFocusable(false);
        jTextField_10.setMargin(new java.awt.Insets(2, 4, 2, 4));
        jTextField_10.setOpaque(false);
        jTextField_10.setPreferredSize(new java.awt.Dimension(595, 25));
        jPanel2.add(jTextField_10);

        jLabel_26.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel_26.setText("FUENTE : ");
        jLabel_26.setPreferredSize(new java.awt.Dimension(75, 25));
        jPanel2.add(jLabel_26);

        cuenta_2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cuenta_2.setText("04");
        cuenta_2.setMargin(new java.awt.Insets(2, 4, 2, 4));
        cuenta_2.setPreferredSize(new java.awt.Dimension(85, 25));
        cuenta_2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textFieldFocusGained(evt);
            }
        });
        jPanel2.add(cuenta_2);

        jTextField_11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField_11.setEnabled(false);
        jTextField_11.setFocusable(false);
        jTextField_11.setMargin(new java.awt.Insets(2, 4, 2, 4));
        jTextField_11.setOpaque(false);
        jTextField_11.setPreferredSize(new java.awt.Dimension(640, 25));
        jPanel2.add(jTextField_11);

        jLabel_81.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel_81.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_81.setText("------>");
        jLabel_81.setPreferredSize(new java.awt.Dimension(50, 24));
        jPanel2.add(jLabel_81);

        jLabel_82.setText("EGRESOS : ");
        jLabel_82.setPreferredSize(new java.awt.Dimension(85, 25));
        jPanel2.add(jLabel_82);

        subgrupo_2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        subgrupo_2.setMargin(new java.awt.Insets(2, 4, 2, 4));
        subgrupo_2.setPreferredSize(new java.awt.Dimension(85, 25));
        subgrupo_2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textFieldFocusGained(evt);
            }
        });
        jPanel2.add(subgrupo_2);

        jTextField_31.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField_31.setEnabled(false);
        jTextField_31.setFocusable(false);
        jTextField_31.setMargin(new java.awt.Insets(2, 4, 2, 4));
        jTextField_31.setOpaque(false);
        jTextField_31.setPreferredSize(new java.awt.Dimension(575, 25));
        jPanel2.add(jTextField_31);

        jLabel_27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel_27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_27.setPreferredSize(new java.awt.Dimension(810, 10));
        jPanel2.add(jLabel_27);

        checkEstandar2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        checkEstandar2.setSelected(true);
        checkEstandar2.setText("INFORME ESTANDAR");
        checkEstandar2.setPreferredSize(new java.awt.Dimension(810, 18));
        jPanel2.add(checkEstandar2);

        checkConSubgrupos2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        checkConSubgrupos2.setText("INFORME CON EGRESOS");
        checkConSubgrupos2.setPreferredSize(new java.awt.Dimension(810, 18));
        jPanel2.add(checkConSubgrupos2);

        jLabel_28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel_28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_28.setPreferredSize(new java.awt.Dimension(695, 24));
        jPanel2.add(jLabel_28);

        botonVerCUENTAINTERNA_SALDOSCAJA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos24/text_page.png"))); // NOI18N
        botonVerCUENTAINTERNA_SALDOSCAJA.setText("Ver pdf");
        botonVerCUENTAINTERNA_SALDOSCAJA.setFocusable(false);
        botonVerCUENTAINTERNA_SALDOSCAJA.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        botonVerCUENTAINTERNA_SALDOSCAJA.setName("botonVerCUENTAINTERNA_SALDOSCAJA"); // NOI18N
        botonVerCUENTAINTERNA_SALDOSCAJA.setPreferredSize(new java.awt.Dimension(110, 24));
        botonVerCUENTAINTERNA_SALDOSCAJA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVerCUENTAINTERNA_SALDOSCAJA(evt);
            }
        });
        jPanel2.add(botonVerCUENTAINTERNA_SALDOSCAJA);

        jTabbedPane1.addTab("SALDOS DE CAJA (CUENTAS)", jPanel2);

        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel_33.setText("FECHA PRESUPUESTAL INICIAL : ");
        jLabel_33.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanel3.add(jLabel_33);

        fechainicial_3.setFocusable(false);
        fechainicial_3.setMaximumSize(new java.awt.Dimension(120, 25));
        fechainicial_3.setMinimumSize(new java.awt.Dimension(120, 25));
        fechainicial_3.setPreferredSize(new java.awt.Dimension(120, 25));
        jPanel3.add(fechainicial_3);

        jTextField_12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField_12.setBorder(null);
        jTextField_12.setEnabled(false);
        jTextField_12.setFocusable(false);
        jTextField_12.setMargin(new java.awt.Insets(2, 4, 2, 4));
        jTextField_12.setOpaque(false);
        jTextField_12.setPreferredSize(new java.awt.Dimension(10, 25));
        jPanel3.add(jTextField_12);

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator3.setPreferredSize(new java.awt.Dimension(10, 25));
        jPanel3.add(jSeparator3);

        jLabel_34.setText("FINAL : ");
        jLabel_34.setPreferredSize(new java.awt.Dimension(55, 25));
        jPanel3.add(jLabel_34);

        fechafinal_3.setFocusable(false);
        fechafinal_3.setMaximumSize(new java.awt.Dimension(120, 25));
        fechafinal_3.setMinimumSize(new java.awt.Dimension(120, 25));
        fechafinal_3.setPreferredSize(new java.awt.Dimension(120, 25));
        jPanel3.add(fechafinal_3);

        jTextField_35.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField_35.setEnabled(false);
        jTextField_35.setFocusable(false);
        jTextField_35.setMargin(new java.awt.Insets(2, 4, 2, 4));
        jTextField_35.setOpaque(false);
        jTextField_35.setPreferredSize(new java.awt.Dimension(265, 25));
        jPanel3.add(jTextField_35);

        jLabel_35.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel_35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_35.setPreferredSize(new java.awt.Dimension(810, 10));
        jPanel3.add(jLabel_35);

        jLabel_36.setText("CUENTA INTERNA : ");
        jLabel_36.setPreferredSize(new java.awt.Dimension(120, 25));
        jPanel3.add(jLabel_36);

        cuentainterna_3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cuentainterna_3.setMargin(new java.awt.Insets(2, 4, 2, 4));
        cuentainterna_3.setPreferredSize(new java.awt.Dimension(85, 25));
        cuentainterna_3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textFieldFocusGained(evt);
            }
        });
        jPanel3.add(cuentainterna_3);

        jTextField_13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField_13.setEnabled(false);
        jTextField_13.setFocusable(false);
        jTextField_13.setMargin(new java.awt.Insets(2, 4, 2, 4));
        jTextField_13.setOpaque(false);
        jTextField_13.setPreferredSize(new java.awt.Dimension(595, 25));
        jPanel3.add(jTextField_13);

        jLabel_37.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel_37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_37.setText("------>");
        jLabel_37.setPreferredSize(new java.awt.Dimension(50, 24));
        jPanel3.add(jLabel_37);

        jLabel_38.setText("C. INFO : ");
        jLabel_38.setPreferredSize(new java.awt.Dimension(65, 25));
        jPanel3.add(jLabel_38);

        cinfo_3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cinfo_3.setMargin(new java.awt.Insets(2, 4, 2, 4));
        cinfo_3.setPreferredSize(new java.awt.Dimension(85, 25));
        cinfo_3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textFieldFocusGained(evt);
            }
        });
        jPanel3.add(cinfo_3);

        jTextField_14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField_14.setEnabled(false);
        jTextField_14.setFocusable(false);
        jTextField_14.setMargin(new java.awt.Insets(2, 4, 2, 4));
        jTextField_14.setOpaque(false);
        jTextField_14.setPreferredSize(new java.awt.Dimension(595, 25));
        jPanel3.add(jTextField_14);

        jLabel_39.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel_39.setText("FUENTE : ");
        jLabel_39.setPreferredSize(new java.awt.Dimension(75, 25));
        jPanel3.add(jLabel_39);

        cuenta_3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cuenta_3.setText("04");
        cuenta_3.setMargin(new java.awt.Insets(2, 4, 2, 4));
        cuenta_3.setPreferredSize(new java.awt.Dimension(85, 25));
        cuenta_3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textFieldFocusGained(evt);
            }
        });
        jPanel3.add(cuenta_3);

        jTextField_15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField_15.setEnabled(false);
        jTextField_15.setFocusable(false);
        jTextField_15.setMargin(new java.awt.Insets(2, 4, 2, 4));
        jTextField_15.setOpaque(false);
        jTextField_15.setPreferredSize(new java.awt.Dimension(640, 25));
        jPanel3.add(jTextField_15);

        jLabel_78.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel_78.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_78.setPreferredSize(new java.awt.Dimension(810, 10));
        jPanel3.add(jLabel_78);

        jLabel_40.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel_40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_40.setPreferredSize(new java.awt.Dimension(695, 24));
        jPanel3.add(jLabel_40);

        botonVerCUENTAINTERNA_TOTALINGRESOS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos24/text_page.png"))); // NOI18N
        botonVerCUENTAINTERNA_TOTALINGRESOS.setText("Ver pdf");
        botonVerCUENTAINTERNA_TOTALINGRESOS.setFocusable(false);
        botonVerCUENTAINTERNA_TOTALINGRESOS.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        botonVerCUENTAINTERNA_TOTALINGRESOS.setName("botonVerCUENTAINTERNA_TOTALINGRESOS"); // NOI18N
        botonVerCUENTAINTERNA_TOTALINGRESOS.setPreferredSize(new java.awt.Dimension(110, 24));
        botonVerCUENTAINTERNA_TOTALINGRESOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVerCUENTAINTERNA_TOTALINGRESOS(evt);
            }
        });
        jPanel3.add(botonVerCUENTAINTERNA_TOTALINGRESOS);

        jTabbedPane1.addTab("TOTAL INGRESOS (CUENTAS)", jPanel3);

        jPanel4.setMaximumSize(new java.awt.Dimension(550, 520));
        jPanel4.setMinimumSize(new java.awt.Dimension(550, 520));
        jPanel4.setPreferredSize(new java.awt.Dimension(550, 520));
        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel_45.setText("SOPORTE (REEMBOLSO) : ");
        jLabel_45.setPreferredSize(new java.awt.Dimension(160, 25));
        jPanel4.add(jLabel_45);

        documento_4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        documento_4.setText("FR-");
        documento_4.setMargin(new java.awt.Insets(2, 4, 2, 4));
        documento_4.setName("SOPORTE"); // NOI18N
        documento_4.setPreferredSize(new java.awt.Dimension(150, 25));
        jPanel4.add(documento_4);

        jTextField_16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField_16.setEnabled(false);
        jTextField_16.setFocusable(false);
        jTextField_16.setMargin(new java.awt.Insets(2, 4, 2, 4));
        jTextField_16.setOpaque(false);
        jTextField_16.setPreferredSize(new java.awt.Dimension(490, 25));
        jPanel4.add(jTextField_16);

        jLabel_46.setText("FORMA DE PAGO : ");
        jLabel_46.setPreferredSize(new java.awt.Dimension(120, 25));
        jPanel4.add(jLabel_46);

        tipopago_4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tipopago_4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione", "Fondo Renovable", "Caja Menor" }));
        tipopago_4.setName("TIPOPAGO"); // NOI18N
        tipopago_4.setPreferredSize(new java.awt.Dimension(180, 25));
        jPanel4.add(tipopago_4);

        jTextField_17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField_17.setEnabled(false);
        jTextField_17.setFocusable(false);
        jTextField_17.setMargin(new java.awt.Insets(2, 4, 2, 4));
        jTextField_17.setOpaque(false);
        jTextField_17.setPreferredSize(new java.awt.Dimension(500, 25));
        jPanel4.add(jTextField_17);

        jLabel_47.setText("FECHA APLICACION : ");
        jLabel_47.setPreferredSize(new java.awt.Dimension(130, 25));
        jPanel4.add(jLabel_47);

        fechaaplicacion_4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fechaaplicacion_4.setModel(ClaseGeneral.controlComprobantes.COMBOFechaaplicacionInComprobantesBy());
        fechaaplicacion_4.setPreferredSize(new java.awt.Dimension(220, 25));
        jPanel4.add(fechaaplicacion_4);

        jTextField_18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField_18.setEnabled(false);
        jTextField_18.setFocusable(false);
        jTextField_18.setMargin(new java.awt.Insets(2, 4, 2, 4));
        jTextField_18.setOpaque(false);
        jTextField_18.setPreferredSize(new java.awt.Dimension(450, 25));
        jPanel4.add(jTextField_18);

        jLabel_76.setText("AÑO : ");
        jLabel_76.setPreferredSize(new java.awt.Dimension(50, 25));
        jPanel4.add(jLabel_76);

        ano_4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ano_4.setMargin(new java.awt.Insets(2, 4, 2, 4));
        ano_4.setPreferredSize(new java.awt.Dimension(85, 25));
        ano_4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textFieldFocusGained(evt);
            }
        });
        jPanel4.add(ano_4);

        jTextField_33.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField_33.setEnabled(false);
        jTextField_33.setFocusable(false);
        jTextField_33.setMargin(new java.awt.Insets(2, 4, 2, 4));
        jTextField_33.setOpaque(false);
        jTextField_33.setPreferredSize(new java.awt.Dimension(665, 25));
        jPanel4.add(jTextField_33);

        jLabel_48.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel_48.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_48.setPreferredSize(new java.awt.Dimension(810, 10));
        jPanel4.add(jLabel_48);

        jLabel_49.setText("CUENTA INTERNA : ");
        jLabel_49.setPreferredSize(new java.awt.Dimension(120, 25));
        jPanel4.add(jLabel_49);

        cuentainterna_4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cuentainterna_4.setMargin(new java.awt.Insets(2, 4, 2, 4));
        cuentainterna_4.setPreferredSize(new java.awt.Dimension(85, 25));
        cuentainterna_4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textFieldFocusGained(evt);
            }
        });
        jPanel4.add(cuentainterna_4);

        jTextField_19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField_19.setEnabled(false);
        jTextField_19.setFocusable(false);
        jTextField_19.setMargin(new java.awt.Insets(2, 4, 2, 4));
        jTextField_19.setOpaque(false);
        jTextField_19.setPreferredSize(new java.awt.Dimension(595, 25));
        jPanel4.add(jTextField_19);

        jLabel_50.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel_50.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_50.setText("------>");
        jLabel_50.setPreferredSize(new java.awt.Dimension(50, 24));
        jPanel4.add(jLabel_50);

        jLabel_51.setText("C. INFO : ");
        jLabel_51.setPreferredSize(new java.awt.Dimension(65, 25));
        jPanel4.add(jLabel_51);

        cinfo_4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cinfo_4.setMargin(new java.awt.Insets(2, 4, 2, 4));
        cinfo_4.setPreferredSize(new java.awt.Dimension(85, 25));
        cinfo_4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textFieldFocusGained(evt);
            }
        });
        jPanel4.add(cinfo_4);

        jTextField_20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField_20.setEnabled(false);
        jTextField_20.setFocusable(false);
        jTextField_20.setMargin(new java.awt.Insets(2, 4, 2, 4));
        jTextField_20.setOpaque(false);
        jTextField_20.setPreferredSize(new java.awt.Dimension(595, 25));
        jPanel4.add(jTextField_20);

        jLabel_83.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel_83.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_83.setText("------>");
        jLabel_83.setPreferredSize(new java.awt.Dimension(50, 24));
        jPanel4.add(jLabel_83);

        jLabel_84.setText("EGRESOS : ");
        jLabel_84.setPreferredSize(new java.awt.Dimension(85, 25));
        jPanel4.add(jLabel_84);

        subgrupo_4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        subgrupo_4.setMargin(new java.awt.Insets(2, 4, 2, 4));
        subgrupo_4.setPreferredSize(new java.awt.Dimension(85, 25));
        subgrupo_4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textFieldFocusGained(evt);
            }
        });
        jPanel4.add(subgrupo_4);

        jTextField_34.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField_34.setEnabled(false);
        jTextField_34.setFocusable(false);
        jTextField_34.setMargin(new java.awt.Insets(2, 4, 2, 4));
        jTextField_34.setOpaque(false);
        jTextField_34.setPreferredSize(new java.awt.Dimension(575, 25));
        jPanel4.add(jTextField_34);

        jLabel_52.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel_52.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_52.setPreferredSize(new java.awt.Dimension(810, 10));
        jPanel4.add(jLabel_52);

        checkEstandar_4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        checkEstandar_4.setSelected(true);
        checkEstandar_4.setText("ESTANDAR");
        checkEstandar_4.setPreferredSize(new java.awt.Dimension(810, 18));
        jPanel4.add(checkEstandar_4);

        checkAgrupadoComprobante_4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        checkAgrupadoComprobante_4.setText("AGRUPADO POR COMPROBANTE");
        checkAgrupadoComprobante_4.setPreferredSize(new java.awt.Dimension(810, 18));
        jPanel4.add(checkAgrupadoComprobante_4);

        jLabel_53.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel_53.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_53.setPreferredSize(new java.awt.Dimension(695, 24));
        jPanel4.add(jLabel_53);

        botonVerComprobanteCUENTAINTERNA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos24/text_page.png"))); // NOI18N
        botonVerComprobanteCUENTAINTERNA.setText("Ver pdf");
        botonVerComprobanteCUENTAINTERNA.setFocusable(false);
        botonVerComprobanteCUENTAINTERNA.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        botonVerComprobanteCUENTAINTERNA.setName("botonVerComprobanteCUENTAINTERNA"); // NOI18N
        botonVerComprobanteCUENTAINTERNA.setPreferredSize(new java.awt.Dimension(110, 24));
        botonVerComprobanteCUENTAINTERNA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVerComprobanteCUENTAINTERNA(evt);
            }
        });
        jPanel4.add(botonVerComprobanteCUENTAINTERNA);

        jTabbedPane1.addTab("INFORME DE MOVIMIENTO DE COMPROBANTES DE EGRESO", jPanel4);

        jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel_58.setText("FORMA DE PAGO : ");
        jLabel_58.setPreferredSize(new java.awt.Dimension(120, 25));
        jPanel5.add(jLabel_58);

        tipopago_5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tipopago_5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione", "Fondo Renovable", "Caja Menor" }));
        tipopago_5.setName("TIPOPAGO"); // NOI18N
        tipopago_5.setPreferredSize(new java.awt.Dimension(180, 25));
        jPanel5.add(tipopago_5);

        jTextField_21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField_21.setEnabled(false);
        jTextField_21.setFocusable(false);
        jTextField_21.setMargin(new java.awt.Insets(2, 4, 2, 4));
        jTextField_21.setOpaque(false);
        jTextField_21.setPreferredSize(new java.awt.Dimension(500, 25));
        jPanel5.add(jTextField_21);

        jLabel_59.setText("FECHA APLICACION INICIAL : ");
        jLabel_59.setPreferredSize(new java.awt.Dimension(190, 25));
        jPanel5.add(jLabel_59);

        fechainicial_5.setFocusable(false);
        fechainicial_5.setMaximumSize(new java.awt.Dimension(120, 25));
        fechainicial_5.setMinimumSize(new java.awt.Dimension(120, 25));
        fechainicial_5.setPreferredSize(new java.awt.Dimension(120, 25));
        jPanel5.add(fechainicial_5);

        jTextField_29.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField_29.setBorder(null);
        jTextField_29.setEnabled(false);
        jTextField_29.setFocusable(false);
        jTextField_29.setMargin(new java.awt.Insets(2, 4, 2, 4));
        jTextField_29.setOpaque(false);
        jTextField_29.setPreferredSize(new java.awt.Dimension(20, 25));
        jPanel5.add(jTextField_29);

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator4.setPreferredSize(new java.awt.Dimension(10, 25));
        jPanel5.add(jSeparator4);

        jLabel_60.setText("FINAL : ");
        jLabel_60.setPreferredSize(new java.awt.Dimension(55, 25));
        jPanel5.add(jLabel_60);

        fechafinal_5.setFocusable(false);
        fechafinal_5.setMaximumSize(new java.awt.Dimension(120, 25));
        fechafinal_5.setMinimumSize(new java.awt.Dimension(120, 25));
        fechafinal_5.setPreferredSize(new java.awt.Dimension(120, 25));
        jPanel5.add(fechafinal_5);

        jTextField_36.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField_36.setEnabled(false);
        jTextField_36.setFocusable(false);
        jTextField_36.setMargin(new java.awt.Insets(2, 4, 2, 4));
        jTextField_36.setOpaque(false);
        jTextField_36.setPreferredSize(new java.awt.Dimension(265, 25));
        jPanel5.add(jTextField_36);

        jLabel_75.setText("AÑO : ");
        jLabel_75.setPreferredSize(new java.awt.Dimension(50, 25));
        jPanel5.add(jLabel_75);

        ano_5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ano_5.setMargin(new java.awt.Insets(2, 4, 2, 4));
        ano_5.setPreferredSize(new java.awt.Dimension(85, 25));
        ano_5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textFieldFocusGained(evt);
            }
        });
        jPanel5.add(ano_5);

        jTextField_32.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField_32.setEnabled(false);
        jTextField_32.setFocusable(false);
        jTextField_32.setMargin(new java.awt.Insets(2, 4, 2, 4));
        jTextField_32.setOpaque(false);
        jTextField_32.setPreferredSize(new java.awt.Dimension(665, 25));
        jPanel5.add(jTextField_32);

        jLabel_61.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel_61.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_61.setPreferredSize(new java.awt.Dimension(810, 10));
        jPanel5.add(jLabel_61);

        jLabel_62.setText("CUENTA INTERNA : ");
        jLabel_62.setPreferredSize(new java.awt.Dimension(120, 25));
        jPanel5.add(jLabel_62);

        cuentainterna_5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cuentainterna_5.setMargin(new java.awt.Insets(2, 4, 2, 4));
        cuentainterna_5.setPreferredSize(new java.awt.Dimension(85, 25));
        cuentainterna_5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textFieldFocusGained(evt);
            }
        });
        jPanel5.add(cuentainterna_5);

        jTextField_24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField_24.setEnabled(false);
        jTextField_24.setFocusable(false);
        jTextField_24.setMargin(new java.awt.Insets(2, 4, 2, 4));
        jTextField_24.setOpaque(false);
        jTextField_24.setPreferredSize(new java.awt.Dimension(595, 25));
        jPanel5.add(jTextField_24);

        jLabel_63.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel_63.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_63.setText("------>");
        jLabel_63.setPreferredSize(new java.awt.Dimension(50, 24));
        jPanel5.add(jLabel_63);

        jLabel_64.setText("C. INFO : ");
        jLabel_64.setPreferredSize(new java.awt.Dimension(65, 25));
        jPanel5.add(jLabel_64);

        cinfo_5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cinfo_5.setMargin(new java.awt.Insets(2, 4, 2, 4));
        cinfo_5.setPreferredSize(new java.awt.Dimension(85, 25));
        cinfo_5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textFieldFocusGained(evt);
            }
        });
        jPanel5.add(cinfo_5);

        jTextField_25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField_25.setEnabled(false);
        jTextField_25.setFocusable(false);
        jTextField_25.setMargin(new java.awt.Insets(2, 4, 2, 4));
        jTextField_25.setOpaque(false);
        jTextField_25.setPreferredSize(new java.awt.Dimension(595, 25));
        jPanel5.add(jTextField_25);

        jLabel_77.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel_77.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_77.setPreferredSize(new java.awt.Dimension(810, 10));
        jPanel5.add(jLabel_77);

        jLabel_65.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel_65.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_65.setPreferredSize(new java.awt.Dimension(695, 24));
        jPanel5.add(jLabel_65);

        botonVerTotalComprobanteCUENTAINTERNA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos24/text_page.png"))); // NOI18N
        botonVerTotalComprobanteCUENTAINTERNA.setText("Ver pdf");
        botonVerTotalComprobanteCUENTAINTERNA.setFocusable(false);
        botonVerTotalComprobanteCUENTAINTERNA.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        botonVerTotalComprobanteCUENTAINTERNA.setName("botonVerTotalComprobanteCUENTAINTERNA"); // NOI18N
        botonVerTotalComprobanteCUENTAINTERNA.setPreferredSize(new java.awt.Dimension(110, 24));
        botonVerTotalComprobanteCUENTAINTERNA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVerCUENTAINTERNA_TOTALCOMPROBANTE(evt);
            }
        });
        jPanel5.add(botonVerTotalComprobanteCUENTAINTERNA);

        jTabbedPane1.addTab("TOTAL DE COMPROBANTES DE EGRESO", jPanel5);

        jPanel6.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel_70.setText("FORMA DE PAGO : ");
        jLabel_70.setPreferredSize(new java.awt.Dimension(120, 25));
        jPanel6.add(jLabel_70);

        tipopago_6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tipopago_6.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione", "Fondo Renovable", "Caja Menor" }));
        tipopago_6.setName("TIPOPAGO"); // NOI18N
        tipopago_6.setPreferredSize(new java.awt.Dimension(180, 25));
        jPanel6.add(tipopago_6);

        jTextField_26.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField_26.setEnabled(false);
        jTextField_26.setFocusable(false);
        jTextField_26.setMargin(new java.awt.Insets(2, 4, 2, 4));
        jTextField_26.setOpaque(false);
        jTextField_26.setPreferredSize(new java.awt.Dimension(500, 25));
        jPanel6.add(jTextField_26);

        jLabel_71.setText("FECHA APLICACION : ");
        jLabel_71.setPreferredSize(new java.awt.Dimension(130, 25));
        jPanel6.add(jLabel_71);

        fechaaplicacion_6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fechaaplicacion_6.setModel(ClaseGeneral.controlComprobantes.COMBOFechaaplicacionInComprobantesBy());
        fechaaplicacion_6.setPreferredSize(new java.awt.Dimension(180, 25));
        jPanel6.add(fechaaplicacion_6);

        jTextField_27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField_27.setEnabled(false);
        jTextField_27.setFocusable(false);
        jTextField_27.setMargin(new java.awt.Insets(2, 4, 2, 4));
        jTextField_27.setOpaque(false);
        jTextField_27.setPreferredSize(new java.awt.Dimension(490, 25));
        jPanel6.add(jTextField_27);

        jLabel_72.setText("AÑO : ");
        jLabel_72.setPreferredSize(new java.awt.Dimension(50, 25));
        jPanel6.add(jLabel_72);

        ano_6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ano_6.setMargin(new java.awt.Insets(2, 4, 2, 4));
        ano_6.setPreferredSize(new java.awt.Dimension(85, 25));
        ano_6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textFieldFocusGained(evt);
            }
        });
        jPanel6.add(ano_6);

        jTextField_28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField_28.setEnabled(false);
        jTextField_28.setFocusable(false);
        jTextField_28.setMargin(new java.awt.Insets(2, 4, 2, 4));
        jTextField_28.setOpaque(false);
        jTextField_28.setPreferredSize(new java.awt.Dimension(665, 25));
        jPanel6.add(jTextField_28);

        jLabel_73.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel_73.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_73.setPreferredSize(new java.awt.Dimension(810, 10));
        jPanel6.add(jLabel_73);

        jLabel_74.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel_74.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_74.setPreferredSize(new java.awt.Dimension(695, 24));
        jPanel6.add(jLabel_74);

        botonVerResumenegresosreembolso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos24/text_page.png"))); // NOI18N
        botonVerResumenegresosreembolso.setText("Ver pdf");
        botonVerResumenegresosreembolso.setFocusable(false);
        botonVerResumenegresosreembolso.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        botonVerResumenegresosreembolso.setName("botonVerResumenegresosreembolso"); // NOI18N
        botonVerResumenegresosreembolso.setPreferredSize(new java.awt.Dimension(110, 24));
        botonVerResumenegresosreembolso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVerResumenegresosreembolso(evt);
            }
        });
        jPanel6.add(botonVerResumenegresosreembolso);

        jTabbedPane1.addTab("RESUMEN IMPUTACION COMPROBANTES DE EGRESOS", jPanel6);

        jPanel7.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel_86.setText("FECHA APLICACION : ");
        jLabel_86.setPreferredSize(new java.awt.Dimension(130, 25));
        jPanel7.add(jLabel_86);

        fechaaplicacion_7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fechaaplicacion_7.setText("2000-01-01");
        fechaaplicacion_7.setFocusable(false);
        fechaaplicacion_7.setMargin(new java.awt.Insets(2, 4, 2, 4));
        fechaaplicacion_7.setPreferredSize(new java.awt.Dimension(180, 25));
        jPanel7.add(fechaaplicacion_7);

        jTextField_38.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField_38.setEnabled(false);
        jTextField_38.setFocusable(false);
        jTextField_38.setMargin(new java.awt.Insets(2, 4, 2, 4));
        jTextField_38.setOpaque(false);
        jTextField_38.setPreferredSize(new java.awt.Dimension(490, 25));
        jPanel7.add(jTextField_38);

        jLabel_87.setText("AÑO : ");
        jLabel_87.setPreferredSize(new java.awt.Dimension(50, 25));
        jPanel7.add(jLabel_87);

        ano_7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ano_7.setMargin(new java.awt.Insets(2, 4, 2, 4));
        ano_7.setPreferredSize(new java.awt.Dimension(85, 25));
        ano_7.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textFieldFocusGained(evt);
            }
        });
        jPanel7.add(ano_7);

        jTextField_39.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField_39.setEnabled(false);
        jTextField_39.setFocusable(false);
        jTextField_39.setMargin(new java.awt.Insets(2, 4, 2, 4));
        jTextField_39.setOpaque(false);
        jTextField_39.setPreferredSize(new java.awt.Dimension(665, 25));
        jPanel7.add(jTextField_39);

        jLabel_88.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel_88.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_88.setPreferredSize(new java.awt.Dimension(810, 10));
        jPanel7.add(jLabel_88);

        jLabel_89.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel_89.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_89.setPreferredSize(new java.awt.Dimension(695, 24));
        jPanel7.add(jLabel_89);

        botonVerComprobantesnoreembolsados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos24/text_page.png"))); // NOI18N
        botonVerComprobantesnoreembolsados.setText("Ver pdf");
        botonVerComprobantesnoreembolsados.setFocusable(false);
        botonVerComprobantesnoreembolsados.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        botonVerComprobantesnoreembolsados.setName("botonVerComprobantesnoreembolsados"); // NOI18N
        botonVerComprobantesnoreembolsados.setPreferredSize(new java.awt.Dimension(110, 24));
        botonVerComprobantesnoreembolsados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVerComprobantesnoreembolsados(evt);
            }
        });
        jPanel7.add(botonVerComprobantesnoreembolsados);

        jTabbedPane1.addTab("RESUMEN COMPROBANTES NO REEMBOLSADOS", jPanel7);

        add(jTabbedPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void botonVerCuentaCUENTAINTERNA(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVerCuentaCUENTAINTERNA
        try {
            frameCarga.setVisible(true);
            frameCarga.pack();
            frameCarga.setSize(280, 100);
            frameCarga.setLocationRelativeTo(null);
            frameCarga.setResizable(false);
            hilo1 = new ThreadCargaCuentaCUENTAINTERNA();
            hilo1.start();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_botonVerCuentaCUENTAINTERNA

    class ThreadCargaCuentaCUENTAINTERNA extends Thread {

        @Override
        public void run() {
            frameCarga.jProgressBar.setIndeterminate(true);
            frameCarga.jProgressBar.setMinimum(1);
            frameCarga.jProgressBar.setMaximum(100);
            /**
             *
             */
            try {
                Map parametros = new HashMap();
                parametros.put("CINFO", "%" + cinfo_1.getText() + "%");
                parametros.put("CUENTAINTERNA", "%" + cuentainterna_1.getText() + "%");
                parametros.put("CUENTA", cuenta_1.getText());
                parametros.put("SUBGRUPO", "%" + subgrupo_1.getText() + "%");
                parametros.put("FECHAINICIAL", fechainicial_1.getDate());
                parametros.put("FECHAFINAL", fechafinal_1.getDate());
                parametros.put("SOPORTESALDO", soportesaldo_1.getText());
                parametros.put("SOPORTE", "%" + soporte_1.getText() + "%");
                if (checkEstandar1.isSelected()) {
                    informes.formatoInformeCuentaCUENTAINTERNA(parametros);
                }
                if (checkSinSaldoDescripcion1.isSelected()) {
                    informes.formatoInformeCuentaCUENTAINTERNA_SIN_SALDO_DESCRIPCION(parametros);
                }
                if (checkSinSaldoEgreso1.isSelected()) {
                    informes.formatoInformeCuentaCUENTAINTERNA_SIN_SALDO_EGRESO(parametros);
                }
            } catch (Exception ex) {
                Logger.getLogger(PanelReportes.class.getName()).log(Level.SEVERE, null, ex);
            }
            /**
             *
             */
            frameCarga.jProgressBar.setIndeterminate(false);
            frameCarga.dispose();
            hilo1 = null;
        }
    }

    private void botonVerCUENTAINTERNA_SALDOSCAJA(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVerCUENTAINTERNA_SALDOSCAJA
        try {
            frameCarga.setVisible(true);
            frameCarga.pack();
            frameCarga.setSize(280, 100);
            frameCarga.setLocationRelativeTo(null);
            frameCarga.setResizable(false);
            hilo2 = new ThreadCargaCUENTAINTERNA_SALDOSCAJA();
            hilo2.start();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_botonVerCUENTAINTERNA_SALDOSCAJA

    class ThreadCargaCUENTAINTERNA_SALDOSCAJA extends Thread {

        @Override
        public void run() {
            frameCarga.jProgressBar.setIndeterminate(true);
            frameCarga.jProgressBar.setMinimum(1);
            frameCarga.jProgressBar.setMaximum(100);
            /**
             *
             */
            try {
                Map parametros = new HashMap();
                parametros.put("CINFO", "%" + cinfo_2.getText() + "%");
                parametros.put("CUENTAINTERNA", "%" + cuentainterna_2.getText() + "%");
                parametros.put("CUENTA", cuenta_2.getText());
                parametros.put("SUBGRUPO", "%" + subgrupo_2.getText() + "%");
                parametros.put("FECHAINICIAL", fechainicial_2.getDate());
                parametros.put("FECHAFINAL", fechafinal_2.getDate());
                parametros.put("SOPORTESALDO", soportesaldo_2.getText());
                if (checkEstandar2.isSelected()) {
                    informes.formatoInformeTotalCuentaCUENTAINTERNA_SALDOSCAJA(parametros);
                }
                if (checkConSubgrupos2.isSelected()) {
                    informes.formatoInformeTotalCuentaCUENTAINTERNA_SALDOSCAJA_SUBGRUPOS(parametros);
                }
            } catch (Exception ex) {
                Logger.getLogger(PanelReportes.class.getName()).log(Level.SEVERE, null, ex);
            }
            /**
             *
             */
            frameCarga.jProgressBar.setIndeterminate(false);
            frameCarga.dispose();
            hilo2 = null;
        }
    }

    private void botonVerCUENTAINTERNA_TOTALINGRESOS(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVerCUENTAINTERNA_TOTALINGRESOS
        try {
            frameCarga.setVisible(true);
            frameCarga.pack();
            frameCarga.setSize(280, 100);
            frameCarga.setLocationRelativeTo(null);
            frameCarga.setResizable(false);
            hilo3 = new ThreadCargaCUENTAINTERNA_TOTALINGRESOS();
            hilo3.start();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_botonVerCUENTAINTERNA_TOTALINGRESOS

    class ThreadCargaCUENTAINTERNA_TOTALINGRESOS extends Thread {

        @Override
        public void run() {
            frameCarga.jProgressBar.setIndeterminate(true);
            frameCarga.jProgressBar.setMinimum(1);
            frameCarga.jProgressBar.setMaximum(100);
            /**
             *
             */
            try {
                Map parametros = new HashMap();
                parametros.put("CINFO", "%" + cinfo_3.getText() + "%");
                parametros.put("CUENTAINTERNA", "%" + cuentainterna_3.getText() + "%");
                parametros.put("CUENTA", cuenta_3.getText());
                parametros.put("FECHAINICIAL", fechainicial_3.getDate());
                parametros.put("FECHAFINAL", fechafinal_3.getDate());
                informes.formatoInformeTotalCuentaCUENTAINTERNA_TOTALINGRESOS(parametros);
            } catch (Exception ex) {
                Logger.getLogger(PanelReportes.class.getName()).log(Level.SEVERE, null, ex);
            }
            /**
             *
             */
            frameCarga.jProgressBar.setIndeterminate(false);
            frameCarga.dispose();
            hilo3 = null;
        }
    }

    private void textFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textFieldFocusGained
        javax.swing.JTextField componente = (javax.swing.JTextField) evt.getComponent();
        componente.selectAll();
        componente.requestFocus();
    }//GEN-LAST:event_textFieldFocusGained

    private void botonVerComprobanteCUENTAINTERNA(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVerComprobanteCUENTAINTERNA
        try {
            frameCarga.setVisible(true);
            frameCarga.pack();
            frameCarga.setSize(280, 100);
            frameCarga.setLocationRelativeTo(null);
            frameCarga.setResizable(false);
            hilo4 = new ThreadCargaComprobanteCUENTAINTERNA();
            hilo4.start();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_botonVerComprobanteCUENTAINTERNA

    class ThreadCargaComprobanteCUENTAINTERNA extends Thread {

        @Override
        public void run() {
            frameCarga.jProgressBar.setIndeterminate(true);
            frameCarga.jProgressBar.setMinimum(1);
            frameCarga.jProgressBar.setMaximum(100);
            /**
             *
             */
            try {
                Map parametros = new HashMap();
                parametros.put("CINFO", "%" + cinfo_4.getText() + "%");
                parametros.put("CUENTAINTERNA", "%" + cuentainterna_4.getText() + "%");
                parametros.put("SUBGRUPO", "%" + subgrupo_4.getText() + "%");

                if (fechaaplicacion_4.getSelectedItem().equals("Todo el AÑO - Reembolsados")) {
                    parametros.put("FECHAAPLICACION_INICIAL", ClaseInformacion.ConvertirFecha(ano_4.getText() + "-01-01"));
                    parametros.put("FECHAAPLICACION_FINAL", ClaseInformacion.ConvertirFecha(ano_4.getText() + "-12-31"));
                } else {
                    parametros.put("FECHAAPLICACION_INICIAL", ClaseInformacion.ConvertirFecha("" + fechaaplicacion_4.getSelectedItem()));
                    parametros.put("FECHAAPLICACION_FINAL", ClaseInformacion.ConvertirFecha("" + fechaaplicacion_4.getSelectedItem()));
                }

                parametros.put("DOCUMENTO", documento_4.getText());
                parametros.put("TIPOPAGO", "" + tipopago_4.getSelectedItem());
                parametros.put("ANO", Integer.parseInt(ano_4.getText()));
                if (checkEstandar_4.isSelected()) {
                    informes.formatoInformeComprobanteCUENTAINTERNA(parametros);
                }
                if (checkAgrupadoComprobante_4.isSelected()) {
                    informes.formatoInformeComprobanteAGRUPADOCOMPROBANTE(parametros);
                }
            } catch (Exception ex) {
                Logger.getLogger(PanelReportes.class.getName()).log(Level.SEVERE, null, ex);
            }
            /**
             *
             */
            frameCarga.jProgressBar.setIndeterminate(false);
            frameCarga.dispose();
            hilo4 = null;
        }
    }

    private void botonVerCUENTAINTERNA_TOTALCOMPROBANTE(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVerCUENTAINTERNA_TOTALCOMPROBANTE
        try {
            frameCarga.setVisible(true);
            frameCarga.pack();
            frameCarga.setSize(280, 100);
            frameCarga.setLocationRelativeTo(null);
            frameCarga.setResizable(false);
            hilo5 = new ThreadCargaCUENTAINTERNA_TOTALCOMPROBANTE();
            hilo5.start();
        } catch (Exception e) {
        }
        }//GEN-LAST:event_botonVerCUENTAINTERNA_TOTALCOMPROBANTE

    class ThreadCargaCUENTAINTERNA_TOTALCOMPROBANTE extends Thread {

        @Override
        public void run() {
            frameCarga.jProgressBar.setIndeterminate(true);
            frameCarga.jProgressBar.setMinimum(1);
            frameCarga.jProgressBar.setMaximum(100);
            /**
             *
             */
            try {
                Map parametros = new HashMap();
                parametros.put("CINFO", "%" + cinfo_5.getText() + "%");
                parametros.put("CUENTAINTERNA", "%" + cuentainterna_5.getText() + "%");
                parametros.put("TIPOPAGO", "" + tipopago_5.getSelectedItem());
                parametros.put("FECHAINICIAL", fechainicial_5.getDate());
                parametros.put("FECHAFINAL", fechafinal_5.getDate());
                parametros.put("ANO", Integer.parseInt(ano_5.getText()));
                informes.formatoInformeTotalComprobanteCUENTAINTERNA(parametros);
            } catch (Exception ex) {
                Logger.getLogger(PanelReportes.class.getName()).log(Level.SEVERE, null, ex);
            }
            /**
             *
             */
            frameCarga.jProgressBar.setIndeterminate(false);
            frameCarga.dispose();
            hilo5 = null;
        }
    }

    private void botonVerResumenegresosreembolso(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVerResumenegresosreembolso
        try {

            try {
                frameCarga.setVisible(true);
                frameCarga.pack();
                frameCarga.setSize(280, 100);
                frameCarga.setLocationRelativeTo(null);
                frameCarga.setResizable(false);
                hilo6 = new ThreadCargaResumenegresosreembolso();
                hilo6.start();
            } catch (Exception e) {
            }
        } catch (Exception ex) {
            Logger.getLogger(PanelReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botonVerResumenegresosreembolso

    private void botonVerComprobantesnoreembolsados(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVerComprobantesnoreembolsados
        try {

            try {
                frameCarga.setVisible(true);
                frameCarga.pack();
                frameCarga.setSize(280, 100);
                frameCarga.setLocationRelativeTo(null);
                frameCarga.setResizable(false);
                hilo7 = new ThreadCargaComprobantesnoreembolsados();
                hilo7.start();
            } catch (Exception e) {
            }
        } catch (Exception ex) {
            Logger.getLogger(PanelReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botonVerComprobantesnoreembolsados

    class ThreadCargaResumenegresosreembolso extends Thread {

        @Override
        public void run() {
            frameCarga.jProgressBar.setIndeterminate(true);
            frameCarga.jProgressBar.setMinimum(1);
            frameCarga.jProgressBar.setMaximum(100);
            /**
             *
             */
            try {
                Map parametros = new HashMap();
                parametros.put("ano", Integer.parseInt(ano_6.getText()));
                if (fechaaplicacion_6.getSelectedItem().equals("Todo el AÑO - Reembolsados")) {
                    parametros.put("FECHAAPLICACION_INICIAL", ClaseInformacion.ConvertirFecha(ano_6.getText() + "-01-01"));
                    parametros.put("FECHAAPLICACION_FINAL", ClaseInformacion.ConvertirFecha(ano_6.getText() + "-12-31"));
                } else {
                    parametros.put("FECHAAPLICACION_INICIAL", ClaseInformacion.ConvertirFecha("" + fechaaplicacion_6.getSelectedItem()));
                    parametros.put("FECHAAPLICACION_FINAL", ClaseInformacion.ConvertirFecha("" + fechaaplicacion_6.getSelectedItem()));
                }
                parametros.put("tipopago", "" + tipopago_6.getSelectedItem());
                informes.formatoInformeResumenEgresosReembolso(parametros);
            } catch (Exception ex) {
                Logger.getLogger(PanelReportes.class.getName()).log(Level.SEVERE, null, ex);
            }
            /**
             *
             */
            frameCarga.jProgressBar.setIndeterminate(false);
            frameCarga.dispose();
            hilo6 = null;
        }
    }

    class ThreadCargaComprobantesnoreembolsados extends Thread {

        @Override
        public void run() {
            frameCarga.jProgressBar.setIndeterminate(true);
            frameCarga.jProgressBar.setMinimum(1);
            frameCarga.jProgressBar.setMaximum(100);
            /**
             *
             */
            try {
                Map parametros = new HashMap();
                parametros.put("FECHAAPLICACION", ClaseInformacion.ConvertirFecha("" + fechaaplicacion_7.getText()));
                parametros.put("ANO", Integer.parseInt(ano_7.getText()));
                ClaseInformes informes = new ClaseInformes();
                informes.formatoInformeComprobantesNOREEMBOLSADOS(parametros);
            } catch (Exception ex) {
                Logger.getLogger(PanelReportes.class.getName()).log(Level.SEVERE, null, ex);
            }
            /**
             *
             */
            frameCarga.jProgressBar.setIndeterminate(false);
            frameCarga.dispose();
            hilo7 = null;
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField ano_4;
    public javax.swing.JTextField ano_5;
    public javax.swing.JTextField ano_6;
    public javax.swing.JTextField ano_7;
    private javax.swing.JButton botonVerCUENTAINTERNA_SALDOSCAJA;
    private javax.swing.JButton botonVerCUENTAINTERNA_TOTALINGRESOS;
    private javax.swing.JButton botonVerComprobanteCUENTAINTERNA;
    private javax.swing.JButton botonVerComprobantesnoreembolsados;
    private javax.swing.JButton botonVerCuentaCUENTAINTERNA;
    private javax.swing.JButton botonVerResumenegresosreembolso;
    private javax.swing.JButton botonVerTotalComprobanteCUENTAINTERNA;
    public static javax.swing.JCheckBox checkAgrupadoComprobante_4;
    public static javax.swing.JCheckBox checkConSubgrupos2;
    public static javax.swing.JCheckBox checkEstandar1;
    public static javax.swing.JCheckBox checkEstandar2;
    public static javax.swing.JCheckBox checkEstandar_4;
    public static javax.swing.JCheckBox checkSinSaldoDescripcion1;
    public static javax.swing.JCheckBox checkSinSaldoEgreso1;
    public javax.swing.JTextField cinfo_1;
    public javax.swing.JTextField cinfo_2;
    public javax.swing.JTextField cinfo_3;
    public javax.swing.JTextField cinfo_4;
    public javax.swing.JTextField cinfo_5;
    public javax.swing.JTextField cuenta_1;
    public javax.swing.JTextField cuenta_2;
    public javax.swing.JTextField cuenta_3;
    public javax.swing.JTextField cuentainterna_1;
    public javax.swing.JTextField cuentainterna_2;
    public javax.swing.JTextField cuentainterna_3;
    public javax.swing.JTextField cuentainterna_4;
    public javax.swing.JTextField cuentainterna_5;
    public static javax.swing.JTextField documento_4;
    public javax.swing.JComboBox fechaaplicacion_4;
    public javax.swing.JComboBox fechaaplicacion_6;
    public static javax.swing.JTextField fechaaplicacion_7;
    public org.jdesktop.swingx.JXDatePicker fechafinal_1;
    public org.jdesktop.swingx.JXDatePicker fechafinal_2;
    public org.jdesktop.swingx.JXDatePicker fechafinal_3;
    public org.jdesktop.swingx.JXDatePicker fechafinal_5;
    public org.jdesktop.swingx.JXDatePicker fechainicial_1;
    public org.jdesktop.swingx.JXDatePicker fechainicial_2;
    public org.jdesktop.swingx.JXDatePicker fechainicial_3;
    public org.jdesktop.swingx.JXDatePicker fechainicial_5;
    private javax.swing.JLabel jLabel_10;
    private javax.swing.JLabel jLabel_11;
    private javax.swing.JLabel jLabel_12;
    private javax.swing.JLabel jLabel_13;
    private javax.swing.JLabel jLabel_14;
    private javax.swing.JLabel jLabel_19;
    private javax.swing.JLabel jLabel_20;
    private javax.swing.JLabel jLabel_21;
    private javax.swing.JLabel jLabel_22;
    private javax.swing.JLabel jLabel_23;
    private javax.swing.JLabel jLabel_24;
    private javax.swing.JLabel jLabel_25;
    private javax.swing.JLabel jLabel_26;
    private javax.swing.JLabel jLabel_27;
    private javax.swing.JLabel jLabel_28;
    private javax.swing.JLabel jLabel_3;
    private javax.swing.JLabel jLabel_33;
    private javax.swing.JLabel jLabel_34;
    private javax.swing.JLabel jLabel_35;
    private javax.swing.JLabel jLabel_36;
    private javax.swing.JLabel jLabel_37;
    private javax.swing.JLabel jLabel_38;
    private javax.swing.JLabel jLabel_39;
    private javax.swing.JLabel jLabel_4;
    private javax.swing.JLabel jLabel_40;
    private javax.swing.JLabel jLabel_45;
    private javax.swing.JLabel jLabel_46;
    private javax.swing.JLabel jLabel_47;
    private javax.swing.JLabel jLabel_48;
    private javax.swing.JLabel jLabel_49;
    private javax.swing.JLabel jLabel_5;
    private javax.swing.JLabel jLabel_50;
    private javax.swing.JLabel jLabel_51;
    private javax.swing.JLabel jLabel_52;
    private javax.swing.JLabel jLabel_53;
    private javax.swing.JLabel jLabel_58;
    private javax.swing.JLabel jLabel_59;
    private javax.swing.JLabel jLabel_6;
    private javax.swing.JLabel jLabel_60;
    private javax.swing.JLabel jLabel_61;
    private javax.swing.JLabel jLabel_62;
    private javax.swing.JLabel jLabel_63;
    private javax.swing.JLabel jLabel_64;
    private javax.swing.JLabel jLabel_65;
    private javax.swing.JLabel jLabel_7;
    private javax.swing.JLabel jLabel_70;
    private javax.swing.JLabel jLabel_71;
    private javax.swing.JLabel jLabel_72;
    private javax.swing.JLabel jLabel_73;
    private javax.swing.JLabel jLabel_74;
    private javax.swing.JLabel jLabel_75;
    private javax.swing.JLabel jLabel_76;
    private javax.swing.JLabel jLabel_77;
    private javax.swing.JLabel jLabel_78;
    private javax.swing.JLabel jLabel_79;
    private javax.swing.JLabel jLabel_8;
    private javax.swing.JLabel jLabel_80;
    private javax.swing.JLabel jLabel_81;
    private javax.swing.JLabel jLabel_82;
    private javax.swing.JLabel jLabel_83;
    private javax.swing.JLabel jLabel_84;
    private javax.swing.JLabel jLabel_86;
    private javax.swing.JLabel jLabel_87;
    private javax.swing.JLabel jLabel_88;
    private javax.swing.JLabel jLabel_89;
    private javax.swing.JLabel jLabel_9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField_1;
    private javax.swing.JTextField jTextField_10;
    private javax.swing.JTextField jTextField_11;
    private javax.swing.JTextField jTextField_12;
    private javax.swing.JTextField jTextField_13;
    private javax.swing.JTextField jTextField_14;
    private javax.swing.JTextField jTextField_15;
    private javax.swing.JTextField jTextField_16;
    private javax.swing.JTextField jTextField_17;
    private javax.swing.JTextField jTextField_18;
    private javax.swing.JTextField jTextField_19;
    private javax.swing.JTextField jTextField_2;
    private javax.swing.JTextField jTextField_20;
    private javax.swing.JTextField jTextField_21;
    private javax.swing.JTextField jTextField_22;
    private javax.swing.JTextField jTextField_23;
    private javax.swing.JTextField jTextField_24;
    private javax.swing.JTextField jTextField_25;
    private javax.swing.JTextField jTextField_26;
    private javax.swing.JTextField jTextField_27;
    private javax.swing.JTextField jTextField_28;
    private javax.swing.JTextField jTextField_29;
    private javax.swing.JTextField jTextField_3;
    private javax.swing.JTextField jTextField_30;
    private javax.swing.JTextField jTextField_31;
    private javax.swing.JTextField jTextField_32;
    private javax.swing.JTextField jTextField_33;
    private javax.swing.JTextField jTextField_34;
    private javax.swing.JTextField jTextField_35;
    private javax.swing.JTextField jTextField_36;
    private javax.swing.JTextField jTextField_38;
    private javax.swing.JTextField jTextField_39;
    private javax.swing.JTextField jTextField_4;
    private javax.swing.JTextField jTextField_5;
    private javax.swing.JTextField jTextField_6;
    private javax.swing.JTextField jTextField_7;
    private javax.swing.JTextField jTextField_8;
    private javax.swing.JTextField jTextField_9;
    public static javax.swing.JTextField soporte_1;
    public static javax.swing.JTextField soportesaldo_1;
    public static javax.swing.JTextField soportesaldo_2;
    public javax.swing.JTextField subgrupo_1;
    public javax.swing.JTextField subgrupo_2;
    public javax.swing.JTextField subgrupo_4;
    public javax.swing.JComboBox tipopago_4;
    public javax.swing.JComboBox tipopago_5;
    public javax.swing.JComboBox tipopago_6;
    // End of variables declaration//GEN-END:variables
}
