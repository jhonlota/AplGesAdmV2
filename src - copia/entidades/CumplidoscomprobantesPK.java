/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Jhon Lopez
 */
public class CumplidoscomprobantesPK {

    private int fkcomprobante;
    private int ano;

    public CumplidoscomprobantesPK() {
    }

    public CumplidoscomprobantesPK(int fkcomprobante, int ano) {
        this.fkcomprobante = fkcomprobante;
        this.ano = ano;
    }

    public int getFkcomprobante() {
        return fkcomprobante;
    }

    public void setFkcomprobante(int fkcomprobante) {
        this.fkcomprobante = fkcomprobante;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
}
