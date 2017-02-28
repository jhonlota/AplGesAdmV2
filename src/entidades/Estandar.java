/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Jhon Lopez
 */
public class Estandar {

    private String modulo;
    private String campo;
    private String valor;
    public String tabla = "estandar(modulo, campo, valor)";

    public Estandar() {
    }

    public Estandar(String modulo, String campo, String valor) {
        this.modulo = modulo;
        this.campo = campo;
        this.valor = valor;
    }

    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
