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
public class Observacionescuentas {

    protected ObservacionescuentasPK observacionescuentasPK = new ObservacionescuentasPK();
    private String dependencia;
    private String observacion;
    public String tabla = "observacionescuentas(fecha, fkcuenta, dependencia, observacion)";

    public Observacionescuentas() {
    }

    public Observacionescuentas(ObservacionescuentasPK observacionescuentasPK) {
        this.observacionescuentasPK = observacionescuentasPK;
    }

    public Observacionescuentas(String fkcuenta, Timestamp fecha) {
        this.observacionescuentasPK = new ObservacionescuentasPK(fkcuenta, fecha);
    }

    public ObservacionescuentasPK getObservacionescuentasPK() {
        return observacionescuentasPK;
    }

    public void setObservacionescuentasPK(ObservacionescuentasPK observacionescuentasPK) {
        this.observacionescuentasPK = observacionescuentasPK;
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
