/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import frame.ExternoPanelExportar;
import frame.ExternoPanelAccionesCuentas;
import frame.ExternoPanelFktercero;
import frame.ExternoPanelCuentainterna;
import frame.ExternoPanelEntrega;
import frame.PanelReportes;
import frame.ExternoPanelImportar;
import frame.ExternoPanelContrasena;
import frame.ExternoPanelCodigocubs;
import frame.ExternoPanelAccionesContratos;
import frame.ExternoPanelCalificacionTramites;
import java.awt.Cursor;
import java.awt.Desktop;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

/**
 *
 * @author Jhon Lopez
 */
public class ClaseMensaje {

    // Ingreso un comentario
    
    public static void informacion(String mensaje) {
        JDialog.setDefaultLookAndFeelDecorated(true);
        JOptionPane.showMessageDialog(null, mensaje, null, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void informacionImagen(ImageIcon imagen) {
        javax.swing.JLabel labelImagen = new javax.swing.JLabel();
        labelImagen.setIcon(imagen);
        labelImagen.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        labelImagen.setFocusable(false);
        JDialog.setDefaultLookAndFeelDecorated(true);
        JOptionPane.showMessageDialog(null, labelImagen, null, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void informacionGuardarBD(String clase) {
        JDialog.setDefaultLookAndFeelDecorated(true);
        JOptionPane.showMessageDialog(null, clase + " se creo con éxito.", null, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void informacionActualizarBD(String clase) {
        JDialog.setDefaultLookAndFeelDecorated(true);
        JOptionPane.showMessageDialog(null, clase + " se edito con éxito.", null, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void informacionEliminarBD(String clase) {
        JDialog.setDefaultLookAndFeelDecorated(true);
        JOptionPane.showMessageDialog(null, clase + " se borro con éxito.", null, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void error(String mensaje) {
        JDialog.setDefaultLookAndFeelDecorated(true);
        JOptionPane.showMessageDialog(null, mensaje, null, JOptionPane.ERROR_MESSAGE);
    }

    public static void errorFind(String toString, String ex) {
        JDialog.setDefaultLookAndFeelDecorated(true);
        JOptionPane.showMessageDialog(null, "Error al buscar\n" + toString + "\n" + ex, null, JOptionPane.ERROR_MESSAGE);
    }

    public static void errorGuardarBD() {
        JDialog.setDefaultLookAndFeelDecorated(true);
        JOptionPane.showMessageDialog(null, "Error al guardar en la base de datos.", null, JOptionPane.ERROR_MESSAGE);
    }

    public static void errorActualizarBD() {
        JDialog.setDefaultLookAndFeelDecorated(true);
        JOptionPane.showMessageDialog(null, "Error al actualizar en la base de datos.", null, JOptionPane.ERROR_MESSAGE);
    }

    public static void errorEliminarBD() {
        JDialog.setDefaultLookAndFeelDecorated(true);
        JOptionPane.showMessageDialog(null, "Error al eliminar en la base de datos.", null, JOptionPane.ERROR_MESSAGE);
    }

    public static void html(String mensaje) {
        JTextPane jTextPane = new JTextPane();
        jTextPane.setContentType("text/html");
        jTextPane.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        jTextPane.setEditable(false);
        jTextPane.setOpaque(false);
        jTextPane.setText(mensaje);

        jTextPane.addHyperlinkListener(new HyperlinkListener() {
            @Override
            public void hyperlinkUpdate(HyperlinkEvent hle) {
                if (HyperlinkEvent.EventType.ACTIVATED.equals(hle.getEventType())) {
                    System.out.println(hle.getURL());
                    Desktop desktop = Desktop.getDesktop();
                    try {
                        desktop.browse(hle.getURL().toURI());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        JOptionPane.showMessageDialog(null, jTextPane, null, JOptionPane.PLAIN_MESSAGE);
    }

    public static String ingresar(String mensaje) {
        JDialog.setDefaultLookAndFeelDecorated(true);
        return JOptionPane.showInputDialog(null, mensaje, null, JOptionPane.QUESTION_MESSAGE);
    }

    public static int preguntar() {
        JDialog.setDefaultLookAndFeelDecorated(true);
        return JOptionPane.showOptionDialog(null, "¿Está seguro que desea llevar a cabo esta acción?", null, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
    }

    public static boolean preguntar(String mensaje) {
        JDialog.setDefaultLookAndFeelDecorated(true);
        return (JOptionPane.showOptionDialog(null, mensaje, null, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null) == JOptionPane.YES_OPTION);//Si reponde SI retorna 'true'
    }

    public static void panel(JTextArea jTextArea) {
        JDialog.setDefaultLookAndFeelDecorated(true);
        JOptionPane.showMessageDialog(null, jTextArea, null, JOptionPane.PLAIN_MESSAGE);
    }

    public static void panel(JPanel jPanel) {
        JDialog.setDefaultLookAndFeelDecorated(true);
        JOptionPane.showMessageDialog(null, jPanel, null, JOptionPane.PLAIN_MESSAGE);
    }

    public static int panel(ExternoPanelAccionesContratos panelAccionesContratos) {
        JDialog.setDefaultLookAndFeelDecorated(true);
        return JOptionPane.showOptionDialog(null, panelAccionesContratos, null, JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);
    }

    public static int panel(ExternoPanelAccionesCuentas panelAccionesCuentas) {
        JDialog.setDefaultLookAndFeelDecorated(true);
        return JOptionPane.showOptionDialog(null, panelAccionesCuentas, null, JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);
    }

    public static int panel(ExternoPanelCalificacionTramites panelCalificacionTramites) {
        JDialog.setDefaultLookAndFeelDecorated(true);
        return JOptionPane.showOptionDialog(null, panelCalificacionTramites, null, JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);
    }

    public static void panel(ExternoPanelCuentainterna panelCuentainterna) {
        JDialog.setDefaultLookAndFeelDecorated(true);
        JOptionPane.showMessageDialog(null, panelCuentainterna, null, JOptionPane.PLAIN_MESSAGE);
    }

    public static void panel(ExternoPanelContrasena panelContrasena) {
        JDialog.setDefaultLookAndFeelDecorated(true);
        JOptionPane.showMessageDialog(null, panelContrasena, null, JOptionPane.PLAIN_MESSAGE);
    }

    public static void panel(ExternoPanelCodigocubs panelCodigocubs) {
        JDialog.setDefaultLookAndFeelDecorated(true);
        JOptionPane.showMessageDialog(null, panelCodigocubs, null, JOptionPane.PLAIN_MESSAGE);
    }

    public static int panel(ExternoPanelEntrega panelEntrega) {
        JDialog.setDefaultLookAndFeelDecorated(true);
        return JOptionPane.showOptionDialog(null, panelEntrega, null, JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);
    }

    public static int panel(ExternoPanelExportar panelExportar) {
        JDialog.setDefaultLookAndFeelDecorated(true);
        return JOptionPane.showOptionDialog(null, panelExportar, null, JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);
    }

    public static void panel(ExternoPanelFktercero panelFktercero) {
        JDialog.setDefaultLookAndFeelDecorated(true);
        JOptionPane.showMessageDialog(null, panelFktercero, null, JOptionPane.PLAIN_MESSAGE);
    }

    public static void panel(PanelReportes panelInformes) {
        JDialog.setDefaultLookAndFeelDecorated(true);
        JOptionPane.showMessageDialog(null, panelInformes, null, JOptionPane.PLAIN_MESSAGE);
    }

    public static int panel(ExternoPanelImportar panelImportar) {
        JDialog.setDefaultLookAndFeelDecorated(true);
        return JOptionPane.showOptionDialog(null, panelImportar, null, JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);
    }
}
