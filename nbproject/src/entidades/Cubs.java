/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.math.BigDecimal;

/**
 *
 * @author Jhon Lopez
 */
public class Cubs {

    protected CubsPK cubsPK;
    private BigDecimal cantidad;
    private String certificado;
    private String codigo;
    private BigDecimal valor;
    private BigDecimal valorsiniva;
    private BigDecimal valortotal;
    private BigDecimal valortotalsiniva;
    public String tabla = "cubs(descripcion, fkcontrato, cantidad, certificado, codigo, valor,"
            + "valorsiniva, valortotal, valortotalsiniva)";

    public Cubs() {
    }

    public Cubs(CubsPK cubsPK) {
        this.cubsPK = cubsPK;
    }

    public Cubs(String descripcion, String fkcontrato) {
        this.cubsPK = new CubsPK(descripcion, fkcontrato);
    }

    public CubsPK getCubsPK() {
        return cubsPK;
    }

    public void setCubsPK(CubsPK cubsPK) {
        this.cubsPK = cubsPK;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public String getCertificado() {
        return certificado;
    }

    public void setCertificado(String certificado) {
        this.certificado = certificado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
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

    public BigDecimal getValortotalsiniva() {
        return valortotalsiniva;
    }

    public void setValortotalsiniva(BigDecimal valortotalsiniva) {
        this.valortotalsiniva = valortotalsiniva;
    }
}
