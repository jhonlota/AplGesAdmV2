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
public class Anexoscontratos {
    protected AnexoscontratosPK anexoscontratosPK = new AnexoscontratosPK();
    private String archivo;
    private String descripcion;
    public String tabla = "anexoscontratos(documento, fecha, fkcontrato, archivo, descripcion)";

    public Anexoscontratos() {
    }

    public Anexoscontratos(AnexoscontratosPK anexoscontratosPK) {
        this.anexoscontratosPK = anexoscontratosPK;
    }

    public Anexoscontratos(String fkcontrato, String documento, Date fecha) {
        this.anexoscontratosPK = new AnexoscontratosPK(fkcontrato, documento, fecha);
    }

    public AnexoscontratosPK getAnexoscontratosPK() {
        return anexoscontratosPK;
    }

    public void setAnexoscontratosPK(AnexoscontratosPK anexoscontratosPK) {
        this.anexoscontratosPK = anexoscontratosPK;
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
