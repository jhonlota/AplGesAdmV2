package entidades;

import java.math.BigDecimal;

public class Tercerosresoluciones {

    public String tabla = "tercerosresolucion(ano, fkresolucion, fktercero, valor, destino, objetivo, soporte, tarifa, salario, diario, fkcomprobante, fkcuenta)";//id, 
    private int id;
    private int ano;
    private int fkresolucion;
    private String fktercero;
    private BigDecimal valor;
    private String destino;
    private String objetivo;
    private String soporte;
    private String tarifa;
    private BigDecimal salario;
    private double diario;
    private String fkcomprobante;
    private String fkcuenta;

    public Tercerosresoluciones() {
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

    public void setFktercero(String fktercero) {
        this.fktercero = fktercero;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public void setSoporte(String soporte) {
        this.soporte = soporte;
    }

    public void setTarifa(String tarifa) {
        this.tarifa = tarifa;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public void setDiario(double diario) {
        this.diario = diario;
    }

    public void setFkcomprobante(String fkcomprobante) {
        this.fkcomprobante = fkcomprobante;
    }

    public void setFkcuenta(String fkcuenta) {
        this.fkcuenta = fkcuenta;
    }
    
    public int getId() {
        return id;
    }

    public int getAno() {
        return ano;
    }

    public int getFkresolucion() {
        return fkresolucion;
    }

    public String getFktercero() {
        return fktercero;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public String getDestino() {
        return destino;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public String getSoporte() {
        return soporte;
    }

    public String getTarifa() {
        return tarifa;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public double getDiario() {
        return diario;
    }

    public String getFkcomprobante() {
        return fkcomprobante;
    }

    public String getFkcuenta() {
        return fkcuenta;
    }
}
