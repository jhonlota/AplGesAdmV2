/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Jhon Lopez
 */
public class ClaseLeer {

    FileReader fr = null;
    BufferedReader br = null;

    public ArrayList<String> MetodoLeer(File file) {
        ArrayList<String> lista = new ArrayList<String>();

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "iso-8859-1"));
            
            String linea;
            while ((linea = br.readLine()) != null) {
                lista.add(linea);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al importar " + file.getName() + "\n" + e, null, JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al importar " + file.getName(), null, JOptionPane.ERROR_MESSAGE);
            }
        }

        return lista;
    }
}
