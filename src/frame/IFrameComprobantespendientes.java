/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * IFrameContrato.java
 *
 * Created on 4/01/2012, 09:52:57 AM
 */
package frame;

import clases.ClaseGeneral;
import clases.ClaseInformacion;
import entidades.Comprobantes;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jhon Lopez
 */
public class IFrameComprobantespendientes extends javax.swing.JInternalFrame {

    private List lista = new ArrayList();
    private int posicion;
    private PanelComprobantespendientes panelPrincipal;

    /** Creates new form IFrameContrato */
    public IFrameComprobantespendientes() {
        initComponents();
        //datos.conectar();
        
        ano.setSelectedItem(ClaseGeneral.controlUtilidades.anoServidor());
        panelPrincipal = new PanelComprobantespendientes(Integer.parseInt("" + ano.getSelectedItem()));
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

        jToolBarConsultar = new javax.swing.JToolBar();
        botonBuscar = new javax.swing.JButton();
        ano = new javax.swing.JComboBox();
        textoPosicionBuscar = new javax.swing.JTextField();
        botonAnterior = new javax.swing.JButton();
        botonSiguiente = new javax.swing.JButton();
        jPanel = new javax.swing.JPanel();

        setTitle("Pendientes");

        jToolBarConsultar.setFloatable(false);

        botonBuscar.setBackground(ClaseGeneral.boton);
        botonBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos24/search.png"))); // NOI18N
        botonBuscar.setText("Buscar");
        botonBuscar.setEnabled(false);
        botonBuscar.setFocusable(false);
        botonBuscar.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        botonBuscar.setMaximumSize(new java.awt.Dimension(100, 25));
        botonBuscar.setMinimumSize(new java.awt.Dimension(100, 25));
        botonBuscar.setPreferredSize(new java.awt.Dimension(100, 25));
        jToolBarConsultar.add(botonBuscar);

        ano.setBackground(ClaseGeneral.campo);
        ano.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ano.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2011", "2012", "2013", "2014", "2015" }));
        ano.setMaximumSize(new java.awt.Dimension(70, 24));
        ano.setMinimumSize(new java.awt.Dimension(70, 24));
        ano.setPreferredSize(new java.awt.Dimension(70, 24));
        ano.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                anoItemStateChanged(evt);
            }
        });
        jToolBarConsultar.add(ano);

        textoPosicionBuscar.setFocusable(false);
        textoPosicionBuscar.setMaximumSize(new java.awt.Dimension(150, 25));
        textoPosicionBuscar.setMinimumSize(new java.awt.Dimension(150, 25));
        textoPosicionBuscar.setPreferredSize(new java.awt.Dimension(150, 25));
        jToolBarConsultar.add(textoPosicionBuscar);

        botonAnterior.setBackground(ClaseGeneral.boton);
        botonAnterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos24/back.png"))); // NOI18N
        botonAnterior.setText("Anterior");
        botonAnterior.setFocusable(false);
        botonAnterior.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        botonAnterior.setMaximumSize(new java.awt.Dimension(100, 25));
        botonAnterior.setMinimumSize(new java.awt.Dimension(100, 25));
        botonAnterior.setPreferredSize(new java.awt.Dimension(100, 25));
        botonAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAnteriorActionPerformed(evt);
            }
        });
        jToolBarConsultar.add(botonAnterior);

        botonSiguiente.setBackground(ClaseGeneral.boton);
        botonSiguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos24/next.png"))); // NOI18N
        botonSiguiente.setText("Siguiente");
        botonSiguiente.setFocusable(false);
        botonSiguiente.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        botonSiguiente.setMaximumSize(new java.awt.Dimension(100, 25));
        botonSiguiente.setMinimumSize(new java.awt.Dimension(100, 25));
        botonSiguiente.setPreferredSize(new java.awt.Dimension(100, 25));
        botonSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSiguienteActionPerformed(evt);
            }
        });
        jToolBarConsultar.add(botonSiguiente);

        getContentPane().add(jToolBarConsultar, java.awt.BorderLayout.SOUTH);

        jPanel.setLayout(new java.awt.BorderLayout());
        getContentPane().add(jPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAnteriorActionPerformed
        try {
            posicion--;
            if (posicion < 0) {
                posicion = lista.size() - 1;
            }
            textoPosicionBuscar.setText((posicion + 1) + " / " + lista.size());
            ClaseGeneral.comprobantespendientes = (Comprobantes) lista.get(posicion);
            Rectangle r = panelPrincipal.jTable.getCellRect( posicion, 0, true);
            panelPrincipal.jScrollPane.getViewport().scrollRectToVisible (r);
            panelPrincipal.jTable.changeSelection(posicion, 0, false, false);
        } catch (Exception e) {
        }
}//GEN-LAST:event_botonAnteriorActionPerformed

    private void botonSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSiguienteActionPerformed
        try {
            posicion++;
            if (posicion == lista.size()) {
                posicion = 0;
            }
            if (lista.isEmpty()) {
                posicion = -1;
            }
            textoPosicionBuscar.setText((posicion + 1) + " / " + lista.size());
            ClaseGeneral.comprobantespendientes = (Comprobantes) lista.get(posicion);
            Rectangle r = panelPrincipal.jTable.getCellRect( posicion, 0, true);
            panelPrincipal.jScrollPane.getViewport().scrollRectToVisible (r);
            panelPrincipal.jTable.changeSelection(posicion, 0, false, false);
        } catch (Exception e) {
        }
}//GEN-LAST:event_botonSiguienteActionPerformed

    private void anoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_anoItemStateChanged
        metodoBuscar();
    }//GEN-LAST:event_anoItemStateChanged
    
    public void metodoBuscar() {
        metodoLimpiar();

        panelPrincipal = new PanelComprobantespendientes(Integer.parseInt("" + ano.getSelectedItem()));
        jPanel.add(panelPrincipal, java.awt.BorderLayout.CENTER);
        jPanel.setVisible(false);
        jPanel.setVisible(true);
        jToolBarConsultar.setVisible(true);

        lista = ClaseGeneral.controlComprobantes.findAllInComprobantesByAno(Integer.parseInt("" + ano.getSelectedItem()));

        if (!lista.isEmpty()) {
            posicion = 0;
            ClaseGeneral.comprobantespendientes = (Comprobantes) lista.get(posicion);
        } else {
            posicion = -1;
//            metodoLimpiar();
        }

        textoPosicionBuscar.setText((posicion + 1) + " / " + lista.size());
        panelPrincipal.jTable.changeSelection(posicion, 0, false, false);
    }

    public void metodoLimpiar() {
        jPanel.removeAll();
        jPanel.setVisible(false);
        jPanel.setVisible(true);
        jToolBarConsultar.setVisible(false);

        textoPosicionBuscar.setText("");
        ClaseInformacion.LimpiarSecundarios();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox ano;
    private javax.swing.JButton botonAnterior;
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonSiguiente;
    private javax.swing.JPanel jPanel;
    private javax.swing.JToolBar jToolBarConsultar;
    private javax.swing.JTextField textoPosicionBuscar;
    // End of variables declaration//GEN-END:variables
}
