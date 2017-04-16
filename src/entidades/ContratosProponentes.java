/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidades;

public class ContratosProponentes {
    
    protected ContratosProponentesPK contratosProponentesPK = new ContratosProponentesPK();
    private int numerofolios;
    private int valorsiniva;
    private int valortotal;
    public String tabla = "contratosproponentes(fkcontrato, fktercero, numerofolios, valorsiniva, valortotal)";

    public ContratosProponentes() {
    }

    public ContratosProponentes(ContratosProponentesPK contratosProponentesPK) {
        this.contratosProponentesPK = contratosProponentesPK;
    } 

    public ContratosProponentes(int numerofolios, int valorsiniva, int valortotal) {
        this.numerofolios = numerofolios;
        this.valorsiniva = valorsiniva;
        this.valortotal = valortotal;
    }

    public ContratosProponentesPK getContratosProponentesPK() {
        return contratosProponentesPK;
    }

    public void setContratosProponentesPK(ContratosProponentesPK contratosProponentesPK) {
        this.contratosProponentesPK = contratosProponentesPK;
    }

    public int getNumerofolios() {
        return numerofolios;
    }

    public void setNumerofolios(int numerofolios) {
        this.numerofolios = numerofolios;
    }

    public int getValorsiniva() {
        return valorsiniva;
    }

    public void setValorsiniva(int valorsiniva) {
        this.valorsiniva = valorsiniva;
    }

    public int getValortotal() {
        return valortotal;
    }

    public void setValortotal(int valortotal) {
        this.valortotal = valortotal;
    }

    public String getTabla() {
        return tabla;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }
    
}
