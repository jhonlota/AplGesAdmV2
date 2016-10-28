/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Jhon Lopez
 */
public class PolizasPK {

    private String fkcontrato;
    private String numeropoliza;
        private String tipopoliza;

    public PolizasPK() {
    }

    public PolizasPK(String fkcontrato, String numeropoliza, String tipopoliza) {
        this.fkcontrato = fkcontrato;
        this.numeropoliza = numeropoliza;
        this.tipopoliza = tipopoliza;
    }
    
    public String getFkcontrato() {
        return fkcontrato;
    }

    public void setFkcontrato(String fkcontrato) {
        this.fkcontrato = fkcontrato;
    }

    public String getNumeropoliza() {
        return numeropoliza;
    }

    public void setNumeropoliza(String numeropoliza) {
        this.numeropoliza = numeropoliza;
    }
    
    
    public String getTipopoliza() {
        return tipopoliza;
    }

    public void setTipopoliza(String tipopoliza) {
        this.tipopoliza = tipopoliza;
    }
}
