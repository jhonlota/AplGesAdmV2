/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entidades;

/**
 *
 * @author Jhon Lopez
 */
public class CubsPK {
    private String descripcion;
    private String fkcontrato;

    public CubsPK() {
    }

    public CubsPK(String descripcion, String fkcontrato) {
        this.descripcion = descripcion;
        this.fkcontrato = fkcontrato;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFkcontrato() {
        return fkcontrato;
    }

    public void setFkcontrato(String fkcontrato) {
        this.fkcontrato = fkcontrato;
    }
}
