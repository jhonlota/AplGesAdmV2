/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidades;

/**
 *
 * @author User
 */
public class SoportesresolucionesPK {
    private int fkresolucion;
    private int id;
    private int ano;

    public SoportesresolucionesPK() {
    }

    public SoportesresolucionesPK(int fkresolucion, int id, int ano) {
        this.fkresolucion = fkresolucion;
        this.id = id;
        this.ano = ano;
    }

    public int getFkresolucion() {
        return fkresolucion;
    }

    
    public int getId() {
        return id;
    }

    public int getAno() {
        return ano;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }    

    public void setFkresolucion(int fkresolucion) {
        this.fkresolucion = fkresolucion;
    }
    
    
}
