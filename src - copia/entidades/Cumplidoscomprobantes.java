/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Jhon Lopez
 */
public class Cumplidoscomprobantes {

    protected CumplidoscomprobantesPK cumplidoscomprobantesPK = new CumplidoscomprobantesPK();
    private String contenido;
    private String fktercerofuncionario;
    public String tabla = "cumplidoscomprobantes("
            + "fkcomprobante, ano, contenido, fktercerofuncionario)";

    public Cumplidoscomprobantes() {
    }

    public Cumplidoscomprobantes(CumplidoscomprobantesPK cumplidoscomprobantesPK) {
        this.cumplidoscomprobantesPK = cumplidoscomprobantesPK;
    }

    public Cumplidoscomprobantes(int fkcomprobante, int ano) {
        this.cumplidoscomprobantesPK = new CumplidoscomprobantesPK(fkcomprobante, ano);
    }

    public CumplidoscomprobantesPK getCumplidoscomprobantesPK() {
        return cumplidoscomprobantesPK;
    }

    public void setCumplidoscomprobantesPK(CumplidoscomprobantesPK cumplidoscomprobantesPK) {
        this.cumplidoscomprobantesPK = cumplidoscomprobantesPK;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getFktercerofuncionario() {
        return fktercerofuncionario;
    }

    public void setFktercerofuncionario(String fktercerofuncionario) {
        this.fktercerofuncionario = fktercerofuncionario;
    }
}
