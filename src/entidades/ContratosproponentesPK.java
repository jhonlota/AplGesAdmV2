/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidades;


public class ContratosproponentesPK {
    
    private String fkcontrato;
    private String fktercero;

    public ContratosproponentesPK() {
    }

    public ContratosproponentesPK(String fkcontrato, String fktercero) {
        this.fkcontrato = fkcontrato;
        this.fktercero = fktercero;
    }

    public String getFkcontrato() {
        return fkcontrato;
    }

    public void setFkcontrato(String fkcontrato) {
        this.fkcontrato = fkcontrato;
    }

    public String getFktercero() {
        return fktercero;
    }

    public void setFktercero(String fktercero) {
        this.fktercero = fktercero;
    }       
    
}