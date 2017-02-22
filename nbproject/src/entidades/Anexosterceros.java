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
public class Anexosterceros {

    protected AnexostercerosPK anexostercerosPK = new AnexostercerosPK();
    private String archivo;
    private String descripcion;
    public String tabla = "anexosterceros(documento, fecha, fktercero, archivo, descripcion)";

    public Anexosterceros() {
    }

    public Anexosterceros(AnexostercerosPK anexostercerosPK) {
        this.anexostercerosPK = anexostercerosPK;
    }

    public Anexosterceros(String fktercero, String documento, Date fecha) {
        this.anexostercerosPK = new AnexostercerosPK(fktercero, documento, fecha);
    }

    public AnexostercerosPK getAnexostercerosPK() {
        return anexostercerosPK;
    }

    public void setAnexostercerosPK(AnexostercerosPK anexostercerosPK) {
        this.anexostercerosPK = anexostercerosPK;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }
    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
