/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * IFramSolicitudesOferta.java
 *
 * Created on 4/01/2012, 09:52:57 AM
 */
package frame;

import clases.ClaseBaseDatos;
import clases.ClaseGeneral;
import clases.ClaseInformacion;
import clases.ClaseInformes;
import clases.ClaseMensaje;
import entidades.Solicitudesoferta;
import java.awt.Rectangle;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Jhon Lopez
 */
public class IFrameSolicitudesoferta extends javax.swing.JInternalFrame {

    private List lista = new ArrayList();
    private int posicion;
    private PanelSolicitudesOferta panelPrincipal = new PanelSolicitudesOferta();
    private ClaseBaseDatos datos = new ClaseBaseDatos();
    private ClaseInformacion informacion = new ClaseInformacion();
    private FrameCarga frameCarga = new FrameCarga();
    private Thread hilo = new ThreadCarga();

    /**
     * Creates new form IFrameContrato
     */
    public IFrameSolicitudesoferta() {
        this.panelPrincipal = new PanelSolicitudesOferta();
        initComponents();
        //datos.conectar();
        ano.setSelectedItem(ClaseGeneral.controlUtilidades.anoServidor());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar = new javax.swing.JToolBar();
        botonNuevo = new javax.swing.JButton();
        botonGuardar = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        botonConsultar = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        botonActualizar = new javax.swing.JButton();
        botonAnular = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JToolBar.Separator();
        botonReiniciar = new javax.swing.JButton();
        jSeparator8 = new javax.swing.JToolBar.Separator();
        botonVer = new javax.swing.JButton();
        jToolBarConsultar = new javax.swing.JToolBar();
        botonBuscar = new javax.swing.JButton();
        ano = new javax.swing.JComboBox();
        textoPosicionBuscar = new javax.swing.JTextField();
        botonAnterior = new javax.swing.JButton();
        botonSiguiente = new javax.swing.JButton();
        jPanel = new javax.swing.JPanel();

        setTitle("Solicitudes de Oferta");

        jToolBar.setFloatable(false);

        botonNuevo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        botonNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos48/new_page.png"))); // NOI18N
        botonNuevo.setText("Nuevo");
        botonNuevo.setFocusable(false);
        botonNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonNuevo.setIconTextGap(1);
        botonNuevo.setMargin(new java.awt.Insets(2, 2, 2, 2));
        botonNuevo.setMaximumSize(new java.awt.Dimension(75, 65));
        botonNuevo.setMinimumSize(new java.awt.Dimension(75, 65));
        botonNuevo.setPreferredSize(new java.awt.Dimension(75, 65));
        botonNuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNuevoActionPerformed(evt);
            }
        });
        jToolBar.add(botonNuevo);

        botonGuardar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        botonGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos48/save.png"))); // NOI18N
        botonGuardar.setText("Guardar");
        botonGuardar.setFocusable(false);
        botonGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonGuardar.setIconTextGap(1);
        botonGuardar.setMargin(new java.awt.Insets(2, 2, 2, 2));
        botonGuardar.setMaximumSize(new java.awt.Dimension(75, 65));
        botonGuardar.setMinimumSize(new java.awt.Dimension(75, 65));
        botonGuardar.setPreferredSize(new java.awt.Dimension(75, 65));
        botonGuardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });
        jToolBar.add(botonGuardar);
        jToolBar.add(jSeparator5);

        botonConsultar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        botonConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos48/search.png"))); // NOI18N
        botonConsultar.setText("Consultar");
        botonConsultar.setFocusable(false);
        botonConsultar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonConsultar.setIconTextGap(1);
        botonConsultar.setMargin(new java.awt.Insets(2, 2, 2, 2));
        botonConsultar.setMaximumSize(new java.awt.Dimension(75, 65));
        botonConsultar.setMinimumSize(new java.awt.Dimension(75, 65));
        botonConsultar.setPreferredSize(new java.awt.Dimension(75, 65));
        botonConsultar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonConsultarActionPerformed(evt);
            }
        });
        jToolBar.add(botonConsultar);
        jToolBar.add(jSeparator6);

        botonActualizar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        botonActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos48/save_edit.png"))); // NOI18N
        botonActualizar.setText("Actualizar");
        botonActualizar.setFocusable(false);
        botonActualizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonActualizar.setIconTextGap(1);
        botonActualizar.setMargin(new java.awt.Insets(2, 2, 2, 2));
        botonActualizar.setMaximumSize(new java.awt.Dimension(75, 65));
        botonActualizar.setMinimumSize(new java.awt.Dimension(75, 65));
        botonActualizar.setPreferredSize(new java.awt.Dimension(75, 65));
        botonActualizar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActualizarActionPerformed(evt);
            }
        });
        jToolBar.add(botonActualizar);

        botonAnular.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        botonAnular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos48/block.png"))); // NOI18N
        botonAnular.setText("Anular");
        botonAnular.setFocusable(false);
        botonAnular.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonAnular.setIconTextGap(1);
        botonAnular.setMargin(new java.awt.Insets(2, 2, 2, 2));
        botonAnular.setMaximumSize(new java.awt.Dimension(75, 65));
        botonAnular.setMinimumSize(new java.awt.Dimension(75, 65));
        botonAnular.setPreferredSize(new java.awt.Dimension(75, 65));
        botonAnular.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonAnular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAnularActionPerformed(evt);
            }
        });
        jToolBar.add(botonAnular);
        jToolBar.add(jSeparator7);

        botonReiniciar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        botonReiniciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos48/refresh.png"))); // NOI18N
        botonReiniciar.setText("Reiniciar");
        botonReiniciar.setFocusable(false);
        botonReiniciar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonReiniciar.setIconTextGap(1);
        botonReiniciar.setMargin(new java.awt.Insets(2, 2, 2, 2));
        botonReiniciar.setMaximumSize(new java.awt.Dimension(75, 65));
        botonReiniciar.setMinimumSize(new java.awt.Dimension(75, 65));
        botonReiniciar.setPreferredSize(new java.awt.Dimension(75, 65));
        botonReiniciar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonReiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonReiniciarActionPerformed(evt);
            }
        });
        jToolBar.add(botonReiniciar);
        jToolBar.add(jSeparator8);

        botonVer.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        botonVer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos48/text_page.png"))); // NOI18N
        botonVer.setText("Ver pdf");
        botonVer.setFocusable(false);
        botonVer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonVer.setIconTextGap(1);
        botonVer.setMargin(new java.awt.Insets(2, 2, 2, 2));
        botonVer.setMaximumSize(new java.awt.Dimension(75, 65));
        botonVer.setMinimumSize(new java.awt.Dimension(75, 65));
        botonVer.setPreferredSize(new java.awt.Dimension(75, 65));
        botonVer.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVerActionPerformed(evt);
            }
        });
        jToolBar.add(botonVer);

        getContentPane().add(jToolBar, java.awt.BorderLayout.NORTH);

        jToolBarConsultar.setFloatable(false);

        botonBuscar.setBackground(ClaseGeneral.boton);
        botonBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos24/search.png"))); // NOI18N
        botonBuscar.setText("Buscar");
        botonBuscar.setFocusable(false);
        botonBuscar.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        botonBuscar.setMaximumSize(new java.awt.Dimension(100, 25));
        botonBuscar.setMinimumSize(new java.awt.Dimension(100, 25));
        botonBuscar.setPreferredSize(new java.awt.Dimension(100, 25));
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });
        jToolBarConsultar.add(botonBuscar);

        ano.setBackground(ClaseGeneral.campo);
        ano.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ano.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2011", "2012", "2013", "2014", "2015", "2016", "2017" }));
        ano.setSelectedItem(ClaseGeneral.controlUtilidades.anoServidor());
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

    private void botonNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNuevoActionPerformed
        metodoLimpiar();

        panelPrincipal = new PanelSolicitudesOferta();
        jPanel.add(panelPrincipal, java.awt.BorderLayout.CENTER);
        jPanel.setVisible(false);
        jPanel.setVisible(true);
        metodoEstado("nuevo");
        FramePrincipal.metodoEntidadSeleccionada("Solicitud de Oferta", "Solicitudes *");
}//GEN-LAST:event_botonNuevoActionPerformed

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        panelPrincipal.metodoInsertar();
        if (ClaseGeneral.controlSolicitudesoferta.verify(ClaseGeneral.solicitudesoferta, "create")) {
            metodoLimpiar();
            metodoEstado("guardar");
        } else {
            ClaseMensaje.error("Error - Falta completar información.\n\n" + ClaseGeneral.errorValidacion);
        }
}//GEN-LAST:event_botonGuardarActionPerformed

    private void botonConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonConsultarActionPerformed
        metodoLimpiar();

        panelPrincipal = new PanelSolicitudesOferta();

        ClaseGeneral.parametro = "CAST(ID AS TEXT)";
        ClaseGeneral.valor = "%%";
        panelPrincipal.metodoMostrar(Integer.parseInt("" + ano.getSelectedItem()));
//        panelPrincipal.metodoMostrarBienesSolicitudesOferta();

        jPanel.add(panelPrincipal, java.awt.BorderLayout.CENTER);
        jPanel.setVisible(false);
        jPanel.setVisible(true);
        jToolBarConsultar.setVisible(true);

        lista = ClaseGeneral.controlSolicitudesoferta.findAllInSolicitudesofertaByORDERBYAno(Integer.parseInt("" + ano.getSelectedItem()));

        if (!lista.isEmpty()) {
            posicion = 0;
            ClaseGeneral.solicitudesoferta = (Solicitudesoferta) lista.get(posicion);
            panelPrincipal.metodoConsultar();
        } else {
            posicion = -1;
        }

        textoPosicionBuscar.setText((posicion + 1) + " / " + lista.size());
        panelPrincipal.jTable.changeSelection(posicion, 0, false, false);
        metodoEstado("consultar");
}//GEN-LAST:event_botonConsultarActionPerformed

    private void botonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarActionPerformed
        if (!lista.isEmpty()) {
            panelPrincipal.metodoActualizar();
        }
        if (ClaseGeneral.controlSolicitudesoferta.verify(ClaseGeneral.solicitudesoferta, "update")) {
            metodoLimpiar();
            metodoEstado("actualizar");
        } else {
            ClaseMensaje.error("Error - Falta completar información.\n\n" + ClaseGeneral.errorValidacion);
        }
}//GEN-LAST:event_botonActualizarActionPerformed

    private void botonAnularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAnularActionPerformed
        int opcion = -1;
        opcion = ClaseMensaje.preguntar();
        if (opcion == JOptionPane.YES_OPTION) {
            if (!lista.isEmpty()) {
                panelPrincipal.metodoAnular();
            }
            metodoLimpiar();
            metodoEstado("eliminar");
        }
}//GEN-LAST:event_botonAnularActionPerformed

    private void botonReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonReiniciarActionPerformed
        metodoLimpiar();
        metodoEstado("reiniciar");
}//GEN-LAST:event_botonReiniciarActionPerformed

    private void botonAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAnteriorActionPerformed
        try {
            posicion--;
            if (posicion < 0) {
                posicion = lista.size() - 1;
            }
            textoPosicionBuscar.setText((posicion + 1) + " / " + lista.size());
            ClaseGeneral.solicitudesoferta = (Solicitudesoferta) lista.get(posicion);
            panelPrincipal.metodoConsultar();
            Rectangle r = panelPrincipal.jTable.getCellRect(posicion, 0, true);
            panelPrincipal.jScrollPane.getViewport().scrollRectToVisible(r);
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
            ClaseGeneral.solicitudesoferta = (Solicitudesoferta) lista.get(posicion);
            panelPrincipal.metodoConsultar();
            Rectangle r = panelPrincipal.jTable.getCellRect(posicion, 0, true);
            panelPrincipal.jScrollPane.getViewport().scrollRectToVisible(r);
            panelPrincipal.jTable.changeSelection(posicion, 0, false, false);
        } catch (Exception e) {
        }
}//GEN-LAST:event_botonSiguienteActionPerformed

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        ExternoPanelBuscarSolicitudesOferta panelSolicitudesOferta = new ExternoPanelBuscarSolicitudesOferta(panelPrincipal);
        ClaseMensaje.panel(panelSolicitudesOferta);

        if (panelSolicitudesOferta.solicitudesoferta.equals("")) {
            posicion = -1;
            metodoLimpiar();
            metodoEstado("reiniciar");
        } else {
            lista = panelSolicitudesOferta.listaSolicitudesOferta;
            
            panelPrincipal.metodoMostrar(lista);

            posicion = panelSolicitudesOferta.posicion;
            ClaseGeneral.solicitudesoferta = (Solicitudesoferta) lista.get(posicion);
            panelPrincipal.metodoConsultar();

            textoPosicionBuscar.setText((posicion + 1) + " / " + lista.size());
        }

    }//GEN-LAST:event_botonBuscarActionPerformed

    private void botonVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVerActionPerformed
        try {
            frameCarga.setVisible(true);
            frameCarga.pack();
            frameCarga.setSize(280, 100);
            frameCarga.setLocationRelativeTo(null);
            frameCarga.setResizable(false);
            hilo = new ThreadCarga();
            hilo.start();
        } catch (Exception e) {
        }
}//GEN-LAST:event_botonVerActionPerformed

    private void anoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_anoItemStateChanged
        ClaseGeneral.parametro = "CAST(ID AS TEXT)";
        ClaseGeneral.valor = "%%";
        metodoBuscar(Integer.parseInt("" + ano.getSelectedItem()));
    }//GEN-LAST:event_anoItemStateChanged

    public void metodoBuscar(int intAno) {
        /**///int intAno = ClaseGeneral.comprobantes.getAno();
        /**/
        metodoLimpiar();

        /**/        panelPrincipal = new PanelSolicitudesOferta();
        panelPrincipal.metodoMostrarBienesSolicitudesOferta();
        /**/
        jPanel.add(panelPrincipal, java.awt.BorderLayout.CENTER);
        /**/
        jPanel.setVisible(false);
        /**/
        jPanel.setVisible(true);
        /**/
        jToolBarConsultar.setVisible(true);

        lista = ClaseGeneral.controlSolicitudesoferta.findAllInSolicitudesofertaByAno(intAno);
        if (!lista.isEmpty()) {
            posicion = 0;
            ClaseGeneral.solicitudesoferta = (Solicitudesoferta) lista.get(posicion);
            panelPrincipal.metodoConsultar();
            /**///ano.setSelectedItem("" + intAno);
            metodoEstado("consultar");
        } else {
            posicion = -1;
            /**///ClaseMensaje.error("El Comprobante NO existe.");
            metodoLimpiar();
            metodoEstado("reiniciar");
        }
    }

    public void metodoEstado(String estado) {
        try {
            datos.query("SELECT * FROM ESTADOS " + "WHERE " + "VENTANA = '" + panelPrincipal.getName() + "' AND " + "USUARIO = '" + ClaseGeneral.perfil + "' AND " + "ESTADO = '" + estado + "'");
            while (ClaseBaseDatos.resultado.next()) {
                botonNuevo.setEnabled(Boolean.parseBoolean(ClaseBaseDatos.resultado.getString("NUEVO")));
                botonGuardar.setEnabled(Boolean.parseBoolean(ClaseBaseDatos.resultado.getString("GUARDAR")));
                botonConsultar.setEnabled(Boolean.parseBoolean(ClaseBaseDatos.resultado.getString("CONSULTAR")));
                botonActualizar.setEnabled(Boolean.parseBoolean(ClaseBaseDatos.resultado.getString("ACTUALIZAR")));
                botonAnular.setEnabled(Boolean.parseBoolean(ClaseBaseDatos.resultado.getString("ELIMINAR")));
                botonReiniciar.setEnabled(Boolean.parseBoolean(ClaseBaseDatos.resultado.getString("REINICIAR")));
                botonVer.setEnabled(Boolean.parseBoolean(ClaseBaseDatos.resultado.getString("VER")));
            }

            if (botonNuevo.isEnabled()) {
                botonNuevo.setBackground(ClaseGeneral.boton);
            } else {
                botonNuevo.setBackground(ClaseGeneral.gris);
            }
            if (botonGuardar.isEnabled()) {
                botonGuardar.setBackground(ClaseGeneral.boton);
            } else {
                botonGuardar.setBackground(ClaseGeneral.gris);
            }
            if (botonConsultar.isEnabled()) {
                botonConsultar.setBackground(ClaseGeneral.boton);
            } else {
                botonConsultar.setBackground(ClaseGeneral.gris);
            }
            if (botonActualizar.isEnabled()) {
                botonActualizar.setBackground(ClaseGeneral.boton);
            } else {
                botonActualizar.setBackground(ClaseGeneral.gris);
            }
            if (botonAnular.isEnabled()) {
                botonAnular.setBackground(ClaseGeneral.boton);
            } else {
                botonAnular.setBackground(ClaseGeneral.gris);
            }
            if (botonReiniciar.isEnabled()) {
                botonReiniciar.setBackground(ClaseGeneral.boton);
            } else {
                botonReiniciar.setBackground(ClaseGeneral.gris);
            }
            if (botonVer.isEnabled()) {
                botonVer.setBackground(ClaseGeneral.boton);
            } else {
                botonVer.setBackground(ClaseGeneral.gris);
            }

            if (ClaseGeneral.perfil.equals("usuario")
                    && estado.equals("nuevo")) {
                panelPrincipal.fechaelaboracion.setEnabled(false);
                panelPrincipal.ano.setFocusable(false);
                panelPrincipal.jTabbedPane.setVisible(false);
            } else if (ClaseGeneral.perfil.equals("usuario")
                    && estado.equals("consultar")) {
                panelPrincipal.fechaelaboracion.setEnabled(false);
                panelPrincipal.ano.setFocusable(false);
                panelPrincipal.jTabbedPane.setVisible(true);
            } else if (ClaseGeneral.perfil.equals("root")
                    && estado.equals("nuevo")) {
                panelPrincipal.fechaelaboracion.setEnabled(true);
                panelPrincipal.ano.setFocusable(true);
                panelPrincipal.jTabbedPane.setVisible(false);
            } else if (ClaseGeneral.perfil.equals("root")
                    && estado.equals("consultar")) {
                panelPrincipal.fechaelaboracion.setEnabled(false);
                panelPrincipal.ano.setFocusable(false);
                panelPrincipal.jTabbedPane.setVisible(true);
            }
        } catch (SQLException ex) {
            Logger.getLogger(IFrameSolicitudesoferta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void metodoLimpiar() {
        jPanel.removeAll();
        jPanel.setVisible(false);
        jPanel.setVisible(true);
        jToolBarConsultar.setVisible(false);

        textoPosicionBuscar.setText("");
        ClaseInformacion.LimpiarPrincipales();
    }

    class ThreadCarga extends Thread {

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
                parametros.put("ID", ClaseGeneral.solicitudesoferta.getId());
                parametros.put("ANO", ClaseGeneral.solicitudesoferta.getAno());
                parametros.put("DEPENDENCIA", ClaseGeneral.dependencia);

                ClaseInformes informes = new ClaseInformes();
                informes.formatoSolicitudOferta(parametros);
            } catch (Exception e) {
                ClaseMensaje.error("Error al mostrar el archivo.\n" + e);
            }
            /**
             *
             */
            frameCarga.jProgressBar.setIndeterminate(false);
            frameCarga.dispose();
            hilo = null;
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox ano;
    private javax.swing.JButton botonActualizar;
    private javax.swing.JButton botonAnterior;
    private javax.swing.JButton botonAnular;
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonConsultar;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JButton botonNuevo;
    private javax.swing.JButton botonReiniciar;
    private javax.swing.JButton botonSiguiente;
    private javax.swing.JButton botonVer;
    private javax.swing.JPanel jPanel;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JToolBar.Separator jSeparator7;
    private javax.swing.JToolBar.Separator jSeparator8;
    private javax.swing.JToolBar jToolBar;
    private javax.swing.JToolBar jToolBarConsultar;
    private javax.swing.JTextField textoPosicionBuscar;
    // End of variables declaration//GEN-END:variables
}
