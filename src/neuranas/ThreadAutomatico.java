/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package neuranas;

import clases.ClaseGeneral;
import frame.FramePrincipal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;

/**
 *
 * @author Jhon Lopez
 */
public class ThreadAutomatico extends Thread {

    private List list = new ArrayList();
    DefaultListModel modeloLista = new DefaultListModel();
    private Object objeto = new Object();

    @Override
    public void interrupt() {
        super.interrupt();
    }

    @Override
    public void run() {
        while (true) {
            try {

                modeloLista = new DefaultListModel();
                list = ClaseGeneral.controlObservacionescontratos.findTiempoFkcontratoObservacionInObservacionescontratosBy();

                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).toString().contains("DOCUMENTO DIGITALIZADO")) {
                        modeloLista.addElement("<html><p><img src=\"" + ClaseGeneral.servidor + "/AGA/src/frame/imagenes/aceptado.png\"/>"
                                + " " + list.get(i).toString().substring(0, list.get(i).toString().indexOf("*-*")) + "</p></html>");
                    } else {
                        modeloLista.addElement("<html><p><img src=\"" + ClaseGeneral.servidor + "/AGA/src/frame/imagenes/alerta.png\"/>"
                                + " " + list.get(i).toString().substring(0, list.get(i).toString().indexOf("*-*")) + "</p></html>");
                    }
                }

                if (!modeloLista.equals(FramePrincipal.listaContratos.getModel())) {
                    FramePrincipal.listaContratos.setModel(modeloLista);
                }

                modeloLista = new DefaultListModel();
                list = ClaseGeneral.controlObservacionescuentas.findTiempoFkcuentaObservacionInObservacionescuentasBy();

                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).toString().contains("ENTREGA PRESUPUESTO")) {
                        modeloLista.addElement("<html><p><img src=\"" + ClaseGeneral.servidor + "/AGA/src/frame/imagenes/aceptado.png\"/>"
                                + " " + list.get(i).toString().substring(0, list.get(i).toString().indexOf("*-*")) + "</p></html>");
                    } else {
                        modeloLista.addElement("<html><p><img src=\"" + ClaseGeneral.servidor + "/AGA/src/frame/imagenes/alerta.png\"/>"
                                + " " + list.get(i).toString().substring(0, list.get(i).toString().indexOf("*-*")) + "</p></html>");
                    }
                }

                if (!modeloLista.equals(FramePrincipal.listaCuentas.getModel())) {
                    FramePrincipal.listaCuentas.setModel(modeloLista);
                }

                modeloLista = new DefaultListModel();
                list = ClaseGeneral.controlContratos.findTiempoContratoCecopnumeroprocesoInContratosBy();

                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).toString().contains("SECOP")) {
                        modeloLista.addElement("<html><p><img src=\"" + ClaseGeneral.servidor + "/AGA/src/frame/imagenes/aceptado.png\"/>"
                                + " " + list.get(i).toString().substring(0, list.get(i).toString().indexOf("//")) + "</p></html>");
                    } else if (Integer.parseInt(list.get(i).toString().substring(2, list.get(i).toString().indexOf(")"))) < 0) {
                        modeloLista.addElement("<html><p><img src=\"" + ClaseGeneral.servidor + "/AGA/src/frame/imagenes/reloj.png\"/>"
                                + " " + list.get(i).toString().substring(0, list.get(i).toString().indexOf("//")) + "</p></html>");
                    } else if (Integer.parseInt(list.get(i).toString().substring(2, list.get(i).toString().indexOf(")"))) >= 0
                            && Integer.parseInt(list.get(i).toString().substring(2, list.get(i).toString().indexOf(")"))) <= 3) {
                        modeloLista.addElement("<html><p><img src=\"" + ClaseGeneral.servidor + "/AGA/src/frame/imagenes/alerta.png\"/>"
                                + " " + list.get(i).toString().substring(0, list.get(i).toString().indexOf("//")) + "</p></html>");
                    } else {
                        modeloLista.addElement("<html><p><img src=\"" + ClaseGeneral.servidor + "/AGA/src/frame/imagenes/exclamacion.png\"/>"
                                + " " + list.get(i).toString().substring(0, list.get(i).toString().indexOf("//")) + "</p></html>");
                    }
                }
                
                if (!modeloLista.equals(FramePrincipal.listaContratosSECOP.getModel())) {
                    FramePrincipal.listaContratosSECOP.setModel(modeloLista);
                }

                modeloLista = new DefaultListModel();
                list = ClaseGeneral.controlObservacionescuentas.findTiempoFkcuentaObservacionInObservacionescuentasByCalificacion();

                for (int i = 0; i < list.size(); i++) {
                    modeloLista.addElement("<html><p><img src=\"" + ClaseGeneral.servidor + "/AGA/src/frame/imagenes/alerta.png\"/>"
                            + " " + list.get(i).toString().substring(0, list.get(i).toString().indexOf("*-*")) + "</p></html>");
                }

                if (!modeloLista.equals(FramePrincipal.listaCuentas.getModel())) {
                    FramePrincipal.listaCalificaciontramites.setModel(modeloLista);
                }
            } catch (Exception ex) {
//                System.out.println(ex);
            }

            synchronized (objeto) {
                try {
                    objeto.wait(600000);//60 Segundos//1 Minuto
                } catch (InterruptedException e) {
                }
            }
        }

    }
}
