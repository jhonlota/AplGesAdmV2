/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Jhon Lopez
 */
public class FacturascomprobantesPK {

    private int fkcomprobante;
    private String numero;
    private int ano;

    public FacturascomprobantesPK() {
    }

    public FacturascomprobantesPK(int fkcomprobante, String numero, int ano) {
        this.fkcomprobante = fkcomprobante;
        this.numero = numero;
        this.ano = ano;
    }

    public int getFkcomprobante() {
        return fkcomprobante;
    }

    public void setFkcomprobante(int fkcomprobante) {
        this.fkcomprobante = fkcomprobante;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
}
