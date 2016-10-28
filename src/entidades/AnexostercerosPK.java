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
public class AnexostercerosPK {

    private String fktercero;
    private String documento;
    private Date fecha;

    public AnexostercerosPK() {
    }

    public AnexostercerosPK(String fktercero, String documento, Date fecha) {
        this.fktercero = fktercero;
        this.documento = documento;
        this.fecha = fecha;
    }

    public String getFktercero() {
        return fktercero;
    }

    public void setFktercero(String fktercero) {
        this.fktercero = fktercero;
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
