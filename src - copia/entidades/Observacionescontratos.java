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
public class Observacionescontratos {
    protected ObservacionescontratosPK observacionescontratosPK = new ObservacionescontratosPK();
    private String dependencia;
    private String observacion;
    public String tabla = "observacionescontratos(fecha, fkcontrato, dependencia, observacion)";

    public Observacionescontratos() {
    }

    public Observacionescontratos(ObservacionescontratosPK observacionescontratosPK) {
        this.observacionescontratosPK = observacionescontratosPK;
    }

    public Observacionescontratos(String fkcontrato, Timestamp fecha) {
        this.observacionescontratosPK = new ObservacionescontratosPK(fkcontrato, fecha);
    }

    public ObservacionescontratosPK getObservacionescontratosPK() {
        return observacionescontratosPK;
    }

    public void setObservacionescontratosPK(ObservacionescontratosPK observacionescontratosPK) {
        this.observacionescontratosPK = observacionescontratosPK;
    }

    public String getDependencia() {
        return dependencia;
    }

    public void setDependencia(String dependencia) {
        this.dependencia = dependencia;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
}
