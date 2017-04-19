/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidades;

import java.math.BigDecimal;

public class ContratosProponentes {
    
    protected ContratosProponentesPK contratosProponentesPK = new ContratosProponentesPK();
    private BigDecimal numerofolios;
    private BigDecimal valorsiniva;
    private BigDecimal valortotal;
    public String tabla = "contratosproponentes(fkcontrato, fktercero, numerofolios, valorsiniva, valortotal)";

    public ContratosProponentes() {
    }

    public ContratosProponentes(ContratosProponentesPK contratosProponentesPK) {
        this.contratosProponentesPK = contratosProponentesPK;
    } 

    public ContratosProponentes(BigDecimal numerofolios, BigDecimal valorsiniva, BigDecimal valortotal) {
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

    public BigDecimal getNumerofolios() {
        return numerofolios;
    }

    public void setNumerofolios(BigDecimal numerofolios) {
        this.numerofolios = numerofolios;
    }

    public BigDecimal getValorsiniva() {
        return valorsiniva;
    }

    public void setValorsiniva(BigDecimal valorsiniva) {
        this.valorsiniva = valorsiniva;
    }

    public BigDecimal getValortotal() {
        return valortotal;
    }

    public void setValortotal(BigDecimal valortotal) {
        this.valortotal = valortotal;
    }

    public String getTabla() {
        return tabla;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }   
    
}
