/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PanelPlanestrategicocontratosContratos.java
 *
 * Created on 16/01/2012, 05:14:48 PM
 */
package frame;

import clases.ClaseGeneral;
import clases.ClaseInformacion;
import entidades.Planestrategicocontratos;
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
public class PanelPlanestrategicocontratos extends javax.swing.JPanel {

    private List lista = new ArrayList();
    private ClaseInformacion informacion = new ClaseInformacion();

    /**
     * Creates new form PanelPlanestrategicocontratosContratos
     */
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public PanelPlanestrategicocontratos() {
        initComponents();
        
        eje.setEditable(true);
        estrategia.setEditable(true);
        programa.setEditable(true);
        subgrupo.setEditable(true);
        cinfo.setEditable(true);

        AutoCompleteDecorator.decorate(eje);
        AutoCompleteDecorator.decorate(estrategia);
        AutoCompleteDecorator.decorate(programa);
        AutoCompleteDecorator.decorate(subgrupo);
        AutoCompleteDecorator.decorate(cinfo);

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
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        eje = new javax.swing.JComboBox();
        estrategia = new javax.swing.JComboBox();
        programa = new javax.swing.JComboBox();
        subgrupo = new javax.swing.JComboBox();
        cinfo = new javax.swing.JComboBox();
        jLabel32 = new javax.swing.JLabel();
        proyecto = new javax.swing.JTextField();
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
        jLabel10.setText("EJE");
        jLabel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel10.setPreferredSize(new java.awt.Dimension(60, 25));
        jPanel1.add(jLabel10);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("ESTRATEGIA");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel2.setPreferredSize(new java.awt.Dimension(90, 25));
        jPanel1.add(jLabel2);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("PROGRAMA");
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel3.setPreferredSize(new java.awt.Dimension(465, 25));
        jPanel1.add(jLabel3);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("SUBGRUPO");
        jLabel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel5.setPreferredSize(new java.awt.Dimension(80, 25));
        jPanel1.add(jLabel5);

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("C. INFO");
        jLabel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel8.setPreferredSize(new java.awt.Dimension(80, 25));
        jPanel1.add(jLabel8);

        eje.setBackground(ClaseGeneral.campo);
        eje.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        eje.setModel(ClaseGeneral.controlPlanestrategico.COMBOEjeInPlanestrategicoBy());
        eje.setSelectedItem("0");
        eje.setOpaque(false);
        eje.setPreferredSize(new java.awt.Dimension(60, 25));
        jPanel1.add(eje);

        estrategia.setBackground(ClaseGeneral.campo);
        estrategia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        estrategia.setModel(ClaseGeneral.controlPlanestrategico.COMBOEstrategiaInPlanestrategicoBy());
        estrategia.setSelectedItem("0");
        estrategia.setOpaque(false);
        estrategia.setPreferredSize(new java.awt.Dimension(90, 25));
        jPanel1.add(estrategia);

        programa.setBackground(ClaseGeneral.campo);
        programa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        programa.setModel(ClaseGeneral.controlPlanestrategico.COMBOProgramaInPlanestrategicoBy());
        programa.setSelectedItem("0");
        programa.setOpaque(false);
        programa.setPreferredSize(new java.awt.Dimension(465, 25));
        jPanel1.add(programa);

        subgrupo.setBackground(ClaseGeneral.campo);
        subgrupo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        subgrupo.setModel(ClaseGeneral.controlSubgrupo.COMBOCodigoInSubgrupoBy());
        subgrupo.setSelectedItem("0");
        subgrupo.setOpaque(false);
        subgrupo.setPreferredSize(new java.awt.Dimension(80, 25));
        jPanel1.add(subgrupo);

        cinfo.setBackground(ClaseGeneral.campo);
        cinfo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cinfo.setModel(ClaseGeneral.controlCinfo.COMBOCodigoInCinfoBy());
        cinfo.setSelectedItem("0");
        cinfo.setOpaque(false);
        cinfo.setPreferredSize(new java.awt.Dimension(80, 25));
        jPanel1.add(cinfo);

        add(jPanel1);

        jLabel32.setText("NOMBRE DEL PROYECTO : ");
        jLabel32.setPreferredSize(new java.awt.Dimension(160, 25));
        add(jLabel32);

        proyecto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        proyecto.setMargin(new java.awt.Insets(2, 4, 2, 4));
        proyecto.setPreferredSize(new java.awt.Dimension(645, 25));
        add(proyecto);

        jLabel74.setPreferredSize(new java.awt.Dimension(810, 25));
        add(jLabel74);

        jScrollPane.setPreferredSize(new java.awt.Dimension(810, 370));

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "EJE", "ESTRATEGIA", "PROGRAMA", "SUBGRUPO", "C. INFO"
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
        ClaseGeneral.planestrategicocontratos = new Planestrategicocontratos();
        ClaseGeneral.planestrategicocontratos.setFkcontrato(fkcontrato.getText());
        ClaseGeneral.planestrategicocontratos.setId(0);
        ClaseGeneral.planestrategicocontratos.setEje("" + eje.getSelectedItem());
        ClaseGeneral.planestrategicocontratos.setEstrategia("" + estrategia.getSelectedItem());
        ClaseGeneral.planestrategicocontratos.setPrograma("" + programa.getSelectedItem());
        ClaseGeneral.planestrategicocontratos.setProyecto(proyecto.getText());
        ClaseGeneral.planestrategicocontratos.setSubgrupo("" + subgrupo.getSelectedItem());
        ClaseGeneral.planestrategicocontratos.setCinfo("" + cinfo.getSelectedItem());

            try {
                ClaseGeneral.controlPlanestrategicocontratos.create(ClaseGeneral.planestrategicocontratos);
            } catch (Exception ex) {
                Logger.getLogger(PanelPlanestrategicocontratos.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    public void metodoConsultar() {
        try {
            fkcontrato.setText(ClaseGeneral.planestrategicocontratos.getFkcontrato());
            eje.setSelectedItem(ClaseGeneral.planestrategicocontratos.getEje());
            estrategia.setSelectedItem(ClaseGeneral.planestrategicocontratos.getEstrategia());
            programa.setSelectedItem(ClaseGeneral.planestrategicocontratos.getPrograma());
            proyecto.setText(ClaseGeneral.planestrategicocontratos.getProyecto());
            subgrupo.setSelectedItem(ClaseGeneral.planestrategicocontratos.getSubgrupo());
            cinfo.setSelectedItem(ClaseGeneral.planestrategicocontratos.getCinfo());

            fkcontrato.setFocusable(false);
        } catch (Exception ex) {
            Logger.getLogger(PanelResoluciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void metodoActualizar() {
//        Planestrategicocontratos planestrategicocontratosId = ClaseGeneral.planestrategicocontratos;
//
//        ClaseGeneral.planestrategicocontratos = new Planestrategicocontratos();
//        ClaseGeneral.planestrategicocontratosPK = new PlanestrategicocontratosPK();
//        ClaseGeneral.planestrategicocontratosPK.setFkcontrato(fkcontrato.getText());
//        //ClaseGeneral.planestrategicocontratosPK.setId();
//        ClaseGeneral.planestrategicocontratos.setPlanestrategicocontratosPK(ClaseGeneral.planestrategicocontratosPK);
//        ClaseGeneral.planestrategicocontratos.setTipo("" + tipo.getSelectedItem());
//        ClaseGeneral.planestrategicocontratos.setNumero(numero.getText());
//        ClaseGeneral.planestrategicocontratos.setFecha(fecha.getDate());
//        ClaseGeneral.planestrategicocontratos.setCuenta(cuenta.getText());
//        ClaseGeneral.planestrategicocontratos.setActividad(actividad.getText());
//        ClaseGeneral.planestrategicocontratos.setSubgrupo("" + subgrupo.getSelectedItem());
//        ClaseGeneral.planestrategicocontratos.setCcostos(ccostos.getText());
//        ClaseGeneral.planestrategicocontratos.setCinfo("" + cinfo.getSelectedItem());
//        ClaseGeneral.planestrategicocontratos.setValor(BigDecimal.valueOf(Long.parseLong("" + valor.getText().trim().replace(".", ""))));
//
//        if (ClaseGeneral.controlPlanestrategicocontratos.verify(ClaseGeneral.planestrategicocontratos)) {
//            try {
//                ClaseGeneral.controlPlanestrategicocontratos.edit(ClaseGeneral.planestrategicocontratos, planestrategicocontratosId);
//            } catch (Exception ex) {
//                Logger.getLogger(PanelPlanestrategicocontratos.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
    }

    public void metodoEliminar() {
        try {
//            ClaseGeneral.planestrategicocontratosPK = new PlanestrategicocontratosPK();
//            ClaseGeneral.planestrategicocontratosPK.setFkcontrato(fkcontrato.getText());
//            ClaseGeneral.planestrategicocontratosPK.setId(ClaseGeneral.planestrategicocontratos.getPlanestrategicocontratosPK().getId());
//
//            ClaseGeneral.controlPlanestrategicocontratos.destroy(ClaseGeneral.planestrategicocontratosPK);
        } catch (Exception ex) {
            Logger.getLogger(PanelPlanestrategicocontratos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void metodoMostrar() {
//        BigDecimal valTotal = BigDecimal.ZERO;
        ClaseGeneral.planestrategicocontratos = new Planestrategicocontratos();
        lista = ClaseGeneral.controlPlanestrategicocontratos.findAllInPlanestrategicocontratosByFkcontrato(fkcontrato.getText());

//        jTable.getColumnModel().getColumn(7).setCellRenderer(informacion.modeloDerecha);

        for (int i = 0; i < 100; i++) {
            jTable.setValueAt("", i, 0);
            jTable.setValueAt("", i, 1);
            jTable.setValueAt("", i, 2);
            jTable.setValueAt("", i, 3);
            jTable.setValueAt("", i, 4);
//            jTable.setValueAt("", i, 5);
//            jTable.setValueAt("", i, 6);
//            jTable.setValueAt("", i, 7);
        }

//        int i = 0;
//        for (Object lista1 : lista) {
//            ClaseGeneral.planestrategicocontratos = (Planestrategicocontratos) lista1;
//            jTable.setValueAt("" + ClaseGeneral.planestrategicocontratos.getTipo(), i, 0);
//            jTable.setValueAt("" + ClaseGeneral.planestrategicocontratos.getNumero(), i, 1);
//            jTable.setValueAt("" + ClaseGeneral.planestrategicocontratos.getCuenta(), i, 2);
//            jTable.setValueAt("" + ClaseGeneral.planestrategicocontratos.getActividad(), i, 3);
//            jTable.setValueAt("" + ClaseGeneral.planestrategicocontratos.getSubgrupo(), i, 4);
//            jTable.setValueAt("" + ClaseGeneral.planestrategicocontratos.getCcostos(), i, 5);
//            jTable.setValueAt("" + ClaseGeneral.planestrategicocontratos.getCinfo(), i, 6);
//            jTable.setValueAt("" + ClaseInformacion.formatoDecimal.format(ClaseGeneral.planestrategicocontratos.getValor()), i, 7);
//
//            if (ClaseGeneral.planestrategicocontratos.getTipo().equals("Registro")
//                    || ClaseGeneral.planestrategicocontratos.getTipo().equals("Ajuste Debito")) {
//                valTotal = valTotal.add(ClaseGeneral.planestrategicocontratos.getValor());
//            } else if (ClaseGeneral.planestrategicocontratos.getTipo().equals("Ajuste Crédito")) {
//                valTotal = valTotal.subtract(ClaseGeneral.planestrategicocontratos.getValor());
//            }
//            i++;
//        }

        jTable.clearSelection();
        jTable.getColumnModel().getColumn(0).setPreferredWidth(150);
        jTable.getColumnModel().getColumn(1).setPreferredWidth(110);
        jTable.getColumnModel().getColumn(2).setPreferredWidth(85);
        jTable.getColumnModel().getColumn(3).setPreferredWidth(85);
        jTable.getColumnModel().getColumn(4).setPreferredWidth(85);
//        jTable.getColumnModel().getColumn(5).setPreferredWidth(85);
//        jTable.getColumnModel().getColumn(6).setPreferredWidth(85);
//        jTable.getColumnModel().getColumn(7).setPreferredWidth(125);
//        valorTotal.setText("" + ClaseInformacion.formatoDecimal.format(valTotal));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox cinfo;
    public javax.swing.JComboBox eje;
    public javax.swing.JComboBox estrategia;
    private javax.swing.JTextField fkcontrato;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JScrollPane jScrollPane;
    public javax.swing.JTable jTable;
    private javax.swing.JTextField jTextField15;
    public javax.swing.JComboBox programa;
    private javax.swing.JTextField proyecto;
    public javax.swing.JComboBox subgrupo;
    // End of variables declaration//GEN-END:variables
}
