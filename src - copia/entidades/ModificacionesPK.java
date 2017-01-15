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
public class ModificacionesPK {
    private String fkcontrato;
    private Date fechamodifprorr;

    public ModificacionesPK() {
    }

    public ModificacionesPK(String fkcontrato, Date fechamodifprorr) {
        this.fkcontrato = fkcontrato;
        this.fechamodifprorr = fechamodifprorr;
    }

    public String getFkcontrato() {
        return fkcontrato;
    }

    public void setFkcontrato(String fkcontrato) {
        this.fkcontrato = fkcontrato;
    }

    public Date getFechamodifprorr() {
        return fechamodifprorr;
    }

    public void setFechamodifprorr(Date fechamodifprorr) {
        this.fechamodifprorr = fechamodifprorr;
    }
}
