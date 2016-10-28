/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package neuranas;

import clases.ClaseMensaje;
import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author Jhon Lopez
 */
public class Leer {

    FileReader fr = null;
    BufferedReader br = null;

    public ArrayList<String> MetodoLeer(File file) {
        ArrayList<String> lista = new ArrayList<String>();

        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);

            String linea;
            while ((linea = br.readLine()) != null) {
                lista.add(linea);
            }
        } catch (Exception e) {
            ClaseMensaje.error("ERROR AL IMPORTAR");
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e) {
                ClaseMensaje.error("ERROR AL IMPORTAR");
            }
        }

        return lista;
    }
}
