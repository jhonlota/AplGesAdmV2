/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidades;

/**
 *
 * @author andres
 */
public class ServiciossolicitudesofertaPK {
    
    private String fksolicitudoferta;
    private int id;
    private int ano;

    public ServiciossolicitudesofertaPK() {
    }

    public ServiciossolicitudesofertaPK(String fksolicitudoferta, int id, int ano) {
        this.fksolicitudoferta = fksolicitudoferta;
        this.id = id;
        this.ano = ano;
    }

    public String getFksolicitudoferta() {
        return fksolicitudoferta;
    }

    public void setFksolicitudoferta(String fksolicitudoferta) {
        this.fksolicitudoferta = fksolicitudoferta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
    
    
}
