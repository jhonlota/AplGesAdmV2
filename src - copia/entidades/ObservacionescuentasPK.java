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
public class ObservacionescuentasPK {

    private String fkcuenta;
    private Timestamp fecha;

    public ObservacionescuentasPK() {
    }

    public ObservacionescuentasPK(String fkcuenta, Timestamp fecha) {
        this.fkcuenta = fkcuenta;
        this.fecha = fecha;
    }

    public String getFkcuenta() {
        return fkcuenta;
    }

    public void setFkcuenta(String fkcuenta) {
        this.fkcuenta = fkcuenta;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }
}
