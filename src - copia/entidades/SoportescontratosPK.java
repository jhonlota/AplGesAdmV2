/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Jhon Lopez
 */
public class SoportescontratosPK {

    private String fkcontrato;
    private int id;

    public SoportescontratosPK() {
    }

    public SoportescontratosPK(String fkcontrato, int id) {
        this.fkcontrato = fkcontrato;
        this.id = id;
    }

    public String getFkcontrato() {
        return fkcontrato;
    }

    public void setFkcontrato(String fkcontrato) {
        this.fkcontrato = fkcontrato;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
