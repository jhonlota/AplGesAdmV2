/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.sql.Timestamp;

/**
 *
 * @author Jhon Lopez
 */
public class ObservacionescontratosPK {

    private String fkcontrato;
    private Timestamp fecha;

    public ObservacionescontratosPK() {
    }

    public ObservacionescontratosPK(String fkcontrato, Timestamp fecha) {
        this.fkcontrato = fkcontrato;
        this.fecha = fecha;
    }

    public String getFkcontrato() {
        return fkcontrato;
    }

    public void setFkcontrato(String fkcontrato) {
        this.fkcontrato = fkcontrato;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }
}
