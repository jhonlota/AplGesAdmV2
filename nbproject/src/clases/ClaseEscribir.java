/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.*;
import java.util.List;

/**
 *
 * @author Jhon Lopez
 */
public class ClaseEscribir {

    FileWriter fichero = null;
    PrintWriter pw = null;

    public void MetodoEscribir(List<String> arreglo, String archivo) {
        try {
            fichero = new FileWriter(archivo);
            pw = new PrintWriter(fichero);

            for (int i = 0; i < arreglo.size(); i++) {
                pw.println(arreglo.get(i));
            }
        } catch (Exception ex) {
            ClaseMensaje.error("ERROR AL MOMENTO DE REALIZAR LA ACCION\n" + ex);
        } finally {
            try {
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception ex) {
                ClaseMensaje.error("ERROR AL MOMENTO DE REALIZAR LA ACCION\n" + ex);
            }
        }
    }
}
