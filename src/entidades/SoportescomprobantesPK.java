/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Jhon Lopez
 */
public class SoportescomprobantesPK {

    private int fkcomprobante;
    private int id;
    private int ano;

    public SoportescomprobantesPK() {
    }

    public SoportescomprobantesPK(int fkcomprobante, int id, int ano) {
        this.fkcomprobante = fkcomprobante;
        this.id = id;
        this.ano = ano;
    }

    public int getFkcomprobante() {
        return fkcomprobante;
    }

    public void setFkcomprobante(int fkcomprobante) {
        this.fkcomprobante = fkcomprobante;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
}
