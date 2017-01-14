/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author Jhon Lopez
 */
public class ClaseEncriptarDesencriptar {

    public static String encriptarCadena(String cadena, String linea1, String linea2) {
        String resultado = "";
        for (int pos = 0; pos < cadena.length(); pos++) {
            if (pos == 0) {
                resultado = encriptarCaracter(cadena.substring(pos, pos + 1), cadena.length(), pos, linea1, linea2);
            } else {
                resultado += encriptarCaracter(cadena.substring(pos, pos + 1), cadena.length(), pos, linea1, linea2);
            }
        }
        return resultado;
    }

    public static String encriptarCaracter(String caracter, int variable, int indice, String linea1, String linea2) {
        int ind;
        if (linea1.indexOf(caracter) != -1) {
            ind = (linea1.indexOf(caracter) + variable + indice) % linea1.length();
            return linea2.substring(ind, ind + 1);
        }
        return caracter;
    }

    public static String desencriptaCadena(String cadena, String linea1, String linea2) {
        String original = "";
        for (int pos = 0; pos < cadena.length(); pos++) {
            if (pos == 0) {
                original = desencriptaCaracter(cadena.substring(pos, pos + 1), cadena.length(), pos, linea1, linea2);
            } else {
                original += desencriptaCaracter(cadena.substring(pos, pos + 1), cadena.length(), pos, linea1, linea2);
            }
        }
        return original;
    }

    public static String desencriptaCaracter(String caracter, int variable, int indice, String linea1, String linea2) {
        int ind;
        if (linea2.indexOf(caracter) != -1) {
            if ((linea2.indexOf(caracter) - variable - indice) > 0) {
                ind = (linea2.indexOf(caracter) - variable - indice) % linea2.length();
            } else {
                ind = (linea1.length()) + ((linea2.indexOf(caracter) - variable - indice) % linea2.length());
            }
            ind = ind % linea2.length();
            return linea1.substring(ind, ind + 1);
        } else {
            return caracter;
        }
    }
}
