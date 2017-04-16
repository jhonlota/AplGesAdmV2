/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PanelContratosProponentes.java
 *
 */
package frame;

import clases.ClaseGeneral;
import clases.ClaseInformacion;
import clases.ClaseMensaje;
import entidades.Bienessolicitudesoferta;
import entidades.BienessolicitudesofertaPK;
import entidades.ContratosProponentes;
import entidades.ContratosProponentesPK;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PanelContratosProponentes extends javax.swing.JPanel {

    private List lista = new ArrayList();
    private ClaseInformacion informacion = new ClaseInformacion();

    /**
     * Creates new form PanelBienesSolicitudesOFerta
     */
    public PanelContratosProponentes() {
        initComponents();
        
        numerofolios.setEditable(true);
        valorsiniva.setEditable(true);
        valortotal.setEditable(true);

        fkcontrato.setText("" + ClaseGeneral.contratos.getContrato());
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
        jLabel73 = new javax.swing.JLabel();
        jSeparator16 = new javax.swing.JSeparator();
        jTextField15 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        fktercero = new javax.swing.JTextField();
        botonBuscarFktercero = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        numerofolios = new javax.swing.JTextField();
        jLabel75 = new javax.swing.JLabel();
        jSeparator17 = new javax.swing.JSeparator();
        jTextField17 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        valorsiniva = new javax.swing.JTextField();
        jLabel77 = new javax.swing.JLabel();
        jSeparator18 = new javax.swing.JSeparator();
        jTextField18 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        valortotal = new javax.swing.JTextField();
        jLabel78 = new javax.swing.JLabel();
        jSeparator19 = new javax.swing.JSeparator();
        jTextField16 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jScrollPane = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();

        setName("panelBienessolicitudesoferta"); // NOI18N
        setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel1.setText("CONTRATO:");
        jLabel1.setPreferredSize(new java.awt.Dimension(80, 25));
        add(jLabel1);

        fkcontrato.setBackground(ClaseGeneral.verde);
        fkcontrato.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        fkcontrato.setForeground(ClaseGeneral.rojo);
        fkcontrato.setFocusable(false);
        fkcontrato.setMargin(new java.awt.Insets(2, 4, 2, 4));
        fkcontrato.setPreferredSize(new java.awt.Dimension(270, 25));
        add(fkcontrato);

        jLabel73.setPreferredSize(new java.awt.Dimension(20, 25));
        add(jLabel73);

        jSeparator16.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator16.setPreferredSize(new java.awt.Dimension(20, 25));
        add(jSeparator16);

        jTextField15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField15.setEnabled(false);
        jTextField15.setFocusable(false);
        jTextField15.setMargin(new java.awt.Insets(2, 4, 2, 4));
        jTextField15.setPreferredSize(new java.awt.Dimension(400, 25));
        add(jTextField15);

        jLabel2.setText("CÉDULA / NIT DEL PROPONENTE :");
        jLabel2.setPreferredSize(new java.awt.Dimension(215, 25));
        add(jLabel2);

        fktercero.setBackground(ClaseGeneral.campo);
        fktercero.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fktercero.setFocusable(false);
        fktercero.setMargin(new java.awt.Insets(2, 4, 2, 4));
        fktercero.setPreferredSize(new java.awt.Dimension(560, 25));
        add(fktercero);

        botonBuscarFktercero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos24/search.png"))); // NOI18N
        botonBuscarFktercero.setFocusable(false);
        botonBuscarFktercero.setName("botonBuscarFktercero"); // NOI18N
        botonBuscarFktercero.setPreferredSize(new java.awt.Dimension(25, 24));
        botonBuscarFktercero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarFkterceroActionPerformed(evt);
            }
        });
        add(botonBuscarFktercero);

        jLabel3.setText("NÚMERO DE FOLIOS:");
        jLabel3.setPreferredSize(new java.awt.Dimension(150, 25));
        add(jLabel3);

        numerofolios.setBackground(ClaseGeneral.campo);
        numerofolios.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        numerofolios.setMargin(new java.awt.Insets(2, 4, 2, 4));
        numerofolios.setPreferredSize(new java.awt.Dimension(100, 25));
        add(numerofolios);

        jLabel75.setPreferredSize(new java.awt.Dimension(20, 25));
        add(jLabel75);

        jSeparator17.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator17.setPreferredSize(new java.awt.Dimension(20, 25));
        add(jSeparator17);

        jTextField17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField17.setEnabled(false);
        jTextField17.setFocusable(false);
        jTextField17.setMargin(new java.awt.Insets(2, 4, 2, 4));
        jTextField17.setPreferredSize(new java.awt.Dimension(500, 25));
        add(jTextField17);

        jLabel4.setText("VALOR SIN IVA:");
        jLabel4.setPreferredSize(new java.awt.Dimension(110, 25));
        add(jLabel4);

        valorsiniva.setBackground(ClaseGeneral.campo);
        valorsiniva.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        valorsiniva.setMargin(new java.awt.Insets(2, 4, 2, 4));
        valorsiniva.setPreferredSize(new java.awt.Dimension(140, 25));
        add(valorsiniva);

        jLabel77.setPreferredSize(new java.awt.Dimension(20, 25));
        add(jLabel77);

        jSeparator18.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator18.setPreferredSize(new java.awt.Dimension(20, 25));
        add(jSeparator18);

        jTextField18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField18.setEnabled(false);
        jTextField18.setFocusable(false);
        jTextField18.setMargin(new java.awt.Insets(2, 4, 2, 4));
        jTextField18.setPreferredSize(new java.awt.Dimension(500, 25));
        add(jTextField18);

        jLabel6.setText("VALOR TOTAL:");
        jLabel6.setPreferredSize(new java.awt.Dimension(110, 25));
        add(jLabel6);

        valortotal.setBackground(ClaseGeneral.campo);
        valortotal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        valortotal.setMargin(new java.awt.Insets(2, 4, 2, 4));
        valortotal.setPreferredSize(new java.awt.Dimension(140, 25));
        add(valortotal);

        jLabel78.setPreferredSize(new java.awt.Dimension(20, 25));
        add(jLabel78);

        jSeparator19.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator19.setPreferredSize(new java.awt.Dimension(20, 25));
        add(jSeparator19);

        jTextField16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField16.setEnabled(false);
        jTextField16.setFocusable(false);
        jTextField16.setMargin(new java.awt.Insets(2, 4, 2, 4));
        jTextField16.setPreferredSize(new java.awt.Dimension(500, 25));
        add(jTextField16);

        jLabel5.setPreferredSize(new java.awt.Dimension(810, 20));
        add(jLabel5);

        jLabel74.setPreferredSize(new java.awt.Dimension(810, 25));
        add(jLabel74);

        jScrollPane.setPreferredSize(new java.awt.Dimension(810, 295));

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "TERCERO", "FOLIOS", "VALOR SIN IVA", "VALOR TOTAL"
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

    private void botonBuscarFkterceroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarFkterceroActionPerformed
        javax.swing.JButton componente = (javax.swing.JButton) evt.getSource();
        String eventoFktercero = componente.getName();
        System.out.println("eventofktercero ="+eventoFktercero);
        ExternoPanelFktercero panelFktercero = new ExternoPanelFktercero();
        ClaseMensaje.panel(panelFktercero);

        if (eventoFktercero.equals("botonBuscarFktercero")) {
            if (!panelFktercero.fktercero.equals("Seleccione - ")) {
                fktercero.setText(panelFktercero.fktercero);
            }
//        } else if (eventoFktercero.equals("botonBuscarFktercerointersuper")) {
//            if (!panelFktercero.fktercero.equals("Seleccione - ")) {
//                fktercerointersuper.setText(panelFktercero.fktercero);
//            }
//        } else if (eventoFktercero.equals("botonBuscarFkterceroordenadorgasto")) {
//            if (!panelFktercero.fktercero.equals("Seleccione - ")) {
//                fkterceroordenadorgasto.setText(panelFktercero.fktercero);
//            }
//        } else if (eventoFktercero.equals("botonBuscarFktercerofuncionario")) {
//            if (!panelFktercero.fktercero.equals("Seleccione - ")) {
//                fktercerofuncionario.setText(panelFktercero.fktercero);
//            }
        }
    }//GEN-LAST:event_botonBuscarFkterceroActionPerformed

    public void metodoInsertar() {
        ClaseGeneral.contratosProponentes = new ContratosProponentes();
        ClaseGeneral.contratosProponentesPK = new ContratosProponentesPK();
        
        ClaseGeneral.contratosProponentesPK.setFkcontrato(""+fkcontrato.getText());
        ClaseGeneral.contratosProponentesPK.setFktercero(""+fktercero.getText());
        
        ClaseGeneral.contratosProponentes.setContratosProponentesPK(ClaseGeneral.contratosProponentesPK);
        ClaseGeneral.contratosProponentes.setNumerofolios(Integer.parseInt(""+numerofolios.getText()));
        ClaseGeneral.contratosProponentes.setValorsiniva(Integer.parseInt(""+valorsiniva.getText()));
        ClaseGeneral.contratosProponentes.setValortotal(Integer.parseInt(""+valortotal.getText())); 

        if (ClaseGeneral.controlContratosProponentes.verify(ClaseGeneral.contratosProponentes)) {
            try {
                ClaseGeneral.controlContratosProponentes.create(ClaseGeneral.contratosProponentes);
            } catch (Exception ex) {
                Logger.getLogger(PanelContratosProponentes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void metodoConsultar() {
        try {
            fkcontrato.setText(""+ClaseGeneral.contratosProponentes.getContratosProponentesPK().getFkcontrato());
            fktercero.setText(""+ClaseGeneral.contratosProponentes.getContratosProponentesPK().getFktercero());
            numerofolios.setText(""+ClaseGeneral.contratosProponentes.getNumerofolios());
            valorsiniva.setText(""+ClaseGeneral.contratosProponentes.getValorsiniva());
            valortotal.setText(""+ClaseGeneral.contratosProponentes.getValortotal());
            
        } catch (Exception ex) {
            Logger.getLogger(PanelSolicitudesOferta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void metodoActualizar() {
        
        ContratosProponentes contratosProponentesId = ClaseGeneral.contratosProponentes;
        contratosProponentesId.setContratosProponentesPK(ClaseGeneral.contratosProponentes.getContratosProponentesPK());
        
        ClaseGeneral.contratosProponentes = new ContratosProponentes();        
        ClaseGeneral.contratosProponentesPK = new ContratosProponentesPK();
        ClaseGeneral.contratosProponentesPK.setFkcontrato(""+fkcontrato.getText());
        ClaseGeneral.contratosProponentesPK.setFktercero(""+fktercero.getText());
        ClaseGeneral.contratosProponentes.setContratosProponentesPK(ClaseGeneral.contratosProponentesPK);
        ClaseGeneral.contratosProponentes.setNumerofolios(Integer.parseInt(numerofolios.getText()));
        ClaseGeneral.contratosProponentes.setValorsiniva(Integer.parseInt(valorsiniva.getText()));
        ClaseGeneral.contratosProponentes.setValortotal(Integer.parseInt(valortotal.getText()));

        if (ClaseGeneral.controlContratosProponentes.verify(ClaseGeneral.contratosProponentes)) {
            try {
                ClaseGeneral.controlContratosProponentes.edit(ClaseGeneral.contratosProponentes, contratosProponentesId);
            } catch (Exception ex) {
                Logger.getLogger(PanelContratosProponentes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void metodoEliminar() {
        try {
            
//            ClaseGeneral.bienessolicitudesofertaPK = new BienessolicitudesofertaPK();
            ClaseGeneral.contratosProponentesPK = new ContratosProponentesPK();
//            ClaseGeneral.bienessolicitudesofertaPK.setFksolicitudoferta(fkcontrato.getText());
            ClaseGeneral.contratosProponentesPK.setFkcontrato(fkcontrato.getText());
            ClaseGeneral.contratosProponentesPK.setFktercero(fktercero.getText());

            ClaseGeneral.controlContratosProponentes.destroy(ClaseGeneral.contratosProponentesPK);
        } catch (Exception ex) {
            Logger.getLogger(PanelContratosProponentes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void metodoMostrar() {
        BigDecimal valTotal = BigDecimal.ZERO;
//        ClaseGeneral.bienessolicitudesoferta = new Bienessolicitudesoferta();
        ClaseGeneral.contratosProponentes = new ContratosProponentes();
//        lista = ClaseGeneral.controlBienessolicitudesoferta.findAllInBienessolicitudesofertaByFksolicitudofertaAno(fkcontrato.getText(), ClaseGeneral.solicitudesoferta.getAno());
        lista = ClaseGeneral.controlContratosProponentes.findAllInContratosProponentesByFkcontratoFktercero(fkcontrato.getText(), fktercero.getText());
        
        jTable.getColumnModel().getColumn(3).setCellRenderer(informacion.modeloDerecha);

        for (int i = 0; i < 100; i++) {
            jTable.setValueAt("", i, 0);
            jTable.setValueAt("", i, 1);
            jTable.setValueAt("", i, 2);
            jTable.setValueAt("", i, 3);
        }

        int i = 0;
        for (Object lista1 : lista) {
            ClaseGeneral.contratosProponentes = (ContratosProponentes) lista1;
            jTable.setValueAt("" + ClaseGeneral.contratosProponentes.getContratosProponentesPK().getFktercero(), i, 0);
            jTable.setValueAt("" + ClaseGeneral.contratosProponentes.getNumerofolios(), i, 1);
            jTable.setValueAt("" + ClaseGeneral.contratosProponentes.getValorsiniva(), i, 2);
            jTable.setValueAt("" + ClaseGeneral.contratosProponentes.getValortotal(), i, 3);
            i++;
        }

        jTable.clearSelection();
        jTable.getColumnModel().getColumn(0).setPreferredWidth(210);
        jTable.getColumnModel().getColumn(1).setPreferredWidth(110);
        jTable.getColumnModel().getColumn(2).setPreferredWidth(110);
        jTable.getColumnModel().getColumn(3).setPreferredWidth(10);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBuscarFktercero;
    private javax.swing.JTextField fkcontrato;
    private javax.swing.JTextField fktercero;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    public javax.swing.JScrollPane jScrollPane;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator17;
    private javax.swing.JSeparator jSeparator18;
    private javax.swing.JSeparator jSeparator19;
    public javax.swing.JTable jTable;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField numerofolios;
    private javax.swing.JTextField valorsiniva;
    private javax.swing.JTextField valortotal;
    // End of variables declaration//GEN-END:variables
}
