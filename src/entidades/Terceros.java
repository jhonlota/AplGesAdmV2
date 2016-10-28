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
public class Terceros {

    private String id;
    private String direccion;
    private String email;
    private String ip;
    private String nombre;
    private String telefono;
    private String tipoid;
    private String cargo;
    private String dependencia;
    private String edificio;
    private String nombrebanco;
    private String numerocuenta;
    private String oficina;
    private String perfil;
    private String profesion;
    private String regimen;
    private String tipocuenta;
    private BigDecimal salario;
    private String idrepresentante;
    private String tipoidrepresentante;
    private String nombrerepresentante;
    private String sedebanco;
    private String sededependencia;
    public String tabla = "terceros(id, direccion, email, nombre, telefono, tipoid, cargo, dependencia, "
            + "edificio, nombrebanco, numerocuenta, oficina, profesion, regimen, "
            + "tipocuenta, perfil, ip, salario, idrepresentante, tipoidrepresentante, nombrerepresentante, sedebanco, sededependencia)";

    public Terceros() {//Contrcutor por DEFAULT
    }

    public Terceros(String id) {///Constructor con la Primary Key
        this.id = id;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDependencia() {
        return dependencia;
    }

    public void setDependencia(String dependencia) {
        this.dependencia = dependencia;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEdificio() {
        return edificio;
    }

    public void setEdificio(String edificio) {
        this.edificio = edificio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombrebanco() {
        return nombrebanco;
    }

    public void setNombrebanco(String nombrebanco) {
        this.nombrebanco = nombrebanco;
    }

    public String getNumerocuenta() {
        return numerocuenta;
    }

    public void setNumerocuenta(String numerocuenta) {
        this.numerocuenta = numerocuenta;
    }

    public String getOficina() {
        return oficina;
    }

    public void setOficina(String oficina) {
        this.oficina = oficina;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getRegimen() {
        return regimen;
    }

    public void setRegimen(String regimen) {
        this.regimen = regimen;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTipocuenta() {
        return tipocuenta;
    }

    public void setTipocuenta(String tipocuenta) {
        this.tipocuenta = tipocuenta;
    }

    public String getTipoid() {
        return tipoid;
    }

    public void setTipoid(String tipoid) {
        this.tipoid = tipoid;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getIdrepresentante() {
        return idrepresentante;
    }

    public void setIdrepresentante(String idrepresentante) {
        this.idrepresentante = idrepresentante;
    }

    public String getTipoidrepresentante() {
        return tipoidrepresentante;
    }

    public void setTipoidrepresentante(String tipoidrepresentante) {
        this.tipoidrepresentante = tipoidrepresentante;
    }

    public String getNombrerepresentante() {
        return nombrerepresentante;
    }

    public void setNombrerepresentante(String nombrerepresentante) {
        this.nombrerepresentante = nombrerepresentante;
    }

    public String getSedebanco() {
        return sedebanco;
    }

    public void setSedebanco(String sedebanco) {
        this.sedebanco = sedebanco;
    }

    public String getSededependencia() {
        return sededependencia;
    }

    public void setSededependencia(String sededependencia) {
        this.sededependencia = sededependencia;
    }

    public String getTabla() {
        return tabla;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }
    
    
}
