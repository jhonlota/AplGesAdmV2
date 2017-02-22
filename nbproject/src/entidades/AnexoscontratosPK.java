/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.Date;

/**
 *
 * @author Jhon Lopez
 */
public class AnexoscontratosPK {

    private String fkcontrato;
    private String documento;
    private Date fecha;

    public AnexoscontratosPK() {
    }

    public AnexoscontratosPK(String fkcontrato, String documento, Date fecha) {
        this.fkcontrato = fkcontrato;
        this.documento = documento;
        this.fecha = fecha;
    }

    public String getFkcontrato() {
        return fkcontrato;
    }

    public void setFkcontrato(String fkcontrato) {
        this.fkcontrato = fkcontrato;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
