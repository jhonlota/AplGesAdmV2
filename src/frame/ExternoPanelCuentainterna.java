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
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author Jhon Lopez
 */
public class ExternoPanelCuentainterna extends javax.swing.JPanel {

    /** Creates new form ExternoPanelEntrega */
    public ExternoPanelCuentainterna() {
        initComponents();
        cuentainterna.setEditable(true);
        AutoCompleteDecorator.decorate(cuentainterna);
        
    }

    /**
	 * This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        labeltexto = new javax.swing.JLabel();
        separador1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        cuentainterna = new javax.swing.JComboBox();
        jTextField1 = new javax.swing.JTextField();

        setMaximumSize(new java.awt.Dimension(750, 290));
        setMinimumSize(new java.awt.Dimension(750, 290));
        setPreferredSize(new java.awt.Dimension(750, 290));

        jLabel1.setBackground(ClaseGeneral.titulo);
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cuenta Interna");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setOpaque(true);
        jLabel1.setPreferredSize(new java.awt.Dimension(740, 25));
        add(jLabel1);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setPreferredSize(new java.awt.Dimension(740, 10));
        add(jLabel2);

        labeltexto.setText("<html><p align = center>Concepto</p></html>");
        labeltexto.setPreferredSize(new java.awt.Dimension(740, 160));
        add(labeltexto);

        separador1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        separador1.setPreferredSize(new java.awt.Dimension(740, 10));
        add(separador1);

        jLabel4.setText("CUENTA INTERNA : ");
        jLabel4.setPreferredSize(new java.awt.Dimension(130, 25));
        add(jLabel4);

        cuentainterna.setBackground(ClaseGeneral.campo);
        cuentainterna.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cuentainterna.setModel(ClaseGeneral.controlCuentainterna.COMBOCodigoInCuentainternaBy());
        cuentainterna.setSelectedItem("0");
        cuentainterna.setPreferredSize(new java.awt.Dimension(120, 25));
        add(cuentainterna);

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField1.setEnabled(false);
        jTextField1.setFocusable(false);
        jTextField1.setMargin(new java.awt.Insets(2, 4, 2, 4));
        jTextField1.setOpaque(false);
        jTextField1.setPreferredSize(new java.awt.Dimension(480, 25));
        add(jTextField1);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox cuentainterna;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextField1;
    public javax.swing.JLabel labeltexto;
    private javax.swing.JSeparator separador1;
    // End of variables declaration//GEN-END:variables
}
