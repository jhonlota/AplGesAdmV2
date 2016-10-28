/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Jhon Lopez
 */
public class SoportescuentasPK {

    private String fkcuenta;
    private int id;

    public SoportescuentasPK() {
    }

    public SoportescuentasPK(String fkcuenta, int id) {
        this.fkcuenta = fkcuenta;
        this.id = id;
    }

    public String getFkcuenta() {
        return fkcuenta;
    }

    public void setFkcuenta(String fkcuenta) {
        this.fkcuenta = fkcuenta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
