/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Jhon Lopez
 */
public class Contratos {

    private String contrato;
    private String anticipio;
    private BigDecimal cantidadespreciosvariables;
    private String causal;
    private String codigoactividad;
    private String codigodepartamento;
    private String codigomodalidad;
    private String codigomunicipio;
    private String codigoproyecto;
    private String codigotipo;
    private String documentoterminacion;
    private Date fechaactaavance;
    private Date fechaadjudicacion;
    private Date fechacierre;
    private Date fechafinalactividad;
    private Date fechainicialactividad;
    private Date fechainicio;
    private Date fechalegalizacion;
    private Date fechaperfeccionamiento;
    private Date fechasuscripcion;
    private Date fechaterminacion;
    private String fktercero;
    private String fktercerofuncionario;
    private String fktercerointersuper;
    private String fkterceroordenadorgasto;
    private String inversion;
    private BigDecimal ley80;
    private String modalidad;
    private String monedapago;
    private String obervaciones;
    private String objeto;
    private String plazo;
    private String porcentajeactividad;
    private String porcentajeavance;
    private String resolucionadjudicacion;
    private BigDecimal tasacambio;
    private String tipoactaavance;
    private String tipocontrato;
    private String tipointerventoria;
    private String tipoterminacion;
    private String tipovinculacionintersuper;
    private String unidadduracion;
    private BigDecimal valor;
    private BigDecimal valoradministracion;
    private BigDecimal valorimprevisto;
    private BigDecimal valorivaobra;
    private BigDecimal valormonedaextranjera;
    private BigDecimal valorsaldo;
    private BigDecimal valorutilidad;
    private String nombreproyecto;
    private String formapago;
    private String tiempogarantia;
    private String contratovigente;
    private Date fechaterminacionvigente;
    private BigDecimal valorsiniva;
    private String secopcodigoproceso;
    private String secopnumeroproceso;
    private String secopnumeroconstancia;
    private Date secopfechapublicacion;
    private String alcance;
    private String analisisriesgos;
    private String condicionesentrega;
    private String diastiempopago;
    private String estimacion;
    private String facultad;
    private Date fechaactainicio;
    private Date fechaentrega;
    private Date fechafichatecnica;
    private Date fechainvitacion;
    private String lugarejecucion;
    private String modalidadarticulo;
    private String modalidadfundamento;
    private String necesidad;
    private String objetoespecifico;
    private String obligacionescontratista;
    private String obligacionesuniversidad;
    private String observacionesactainicio;
    private String perfilrequerido;
    private String planadquisicion;
    private String requerimientostecnicos;
    private String tipotiempopago;
    private String tipoestimacion;
    private String tipofinanciacion;
    private String valorletras;
    public String tabla = "contratos(contrato, anticipio, cantidadespreciosvariables, causal, codigoactividad, "
            + "codigodepartamento, codigomodalidad, codigomunicipio, codigoproyecto, "
            + "codigotipo, documentoterminacion, fechaactaavance, fechaadjudicacion, "
            + "fechacierre, fechafinalactividad, fechainicialactividad, fechainicio, "
            + "fechalegalizacion, fechaperfeccionamiento, fechasuscripcion, "
            + "fechaterminacion, fktercero, fktercerointersuper, fkterceroordenadorgasto, "
            + "inversion, ley80, modalidad, monedapago, obervaciones, objeto, "
            + "plazo, porcentajeactividad, porcentajeavance, resolucionadjudicacion, "
            + "tasacambio, tipoactaavance, tipocontrato, tipointerventoria, "
            + "tipoterminacion, tipovinculacionintersuper, unidadduracion, valor, "
            + "valoradministracion, valorimprevisto, valorivaobra, valormonedaextranjera, "
            + "valorsaldo, valorutilidad, nombreproyecto, formapago, tiempogarantia, "
            + "contratovigente, fechaterminacionvigente, fktercerofuncionario, "
            + "valorsiniva, secopcodigoproceso, secopnumeroproceso,  secopnumeroconstancia, "
            + "secopfechapublicacion, "
            + "alcance, "
            + "analisisriesgos, "
            + "condicionesentrega, "
            + "diastiempopago, "
            + "estimacion, "
            + "facultad, "
            + "fechaactainicio, "
            + "fechaentrega, "
            + "fechafichatecnica, "
            + "fechainvitacion, "
            + "lugarejecucion, "
            + "modalidadarticulo, "
            + "modalidadfundamento, "
            + "necesidad, "
            + "objetoespecifico, "
            + "obligacionescontratista, "
            + "obligacionesuniversidad, "
            + "observacionesactainicio, "
            + "perfilrequerido, "
            + "planadquisicion, "
            + "requerimientostecnicos, "
            + "tipotiempopago, "
            + "tipoestimacion, "
            + "tipofinanciacion, "
            + "valorletras)";

    public Contratos() {
    }

    public String getContrato() {
        return contrato;
    }

    public void setContrato(String contrato) {
        this.contrato = contrato;
    }

    public String getAnticipio() {
        return anticipio;
    }

    public void setAnticipio(String anticipio) {
        this.anticipio = anticipio;
    }

    public BigDecimal getCantidadespreciosvariables() {
        return cantidadespreciosvariables;
    }

    public void setCantidadespreciosvariables(BigDecimal cantidadespreciosvariables) {
        this.cantidadespreciosvariables = cantidadespreciosvariables;
    }

    public String getCausal() {
        return causal;
    }

    public void setCausal(String causal) {
        this.causal = causal;
    }

    public String getCodigoactividad() {
        return codigoactividad;
    }

    public void setCodigoactividad(String codigoactividad) {
        this.codigoactividad = codigoactividad;
    }

    public String getCodigodepartamento() {
        return codigodepartamento;
    }

    public void setCodigodepartamento(String codigodepartamento) {
        this.codigodepartamento = codigodepartamento;
    }

    public String getCodigomodalidad() {
        return codigomodalidad;
    }

    public void setCodigomodalidad(String codigomodalidad) {
        this.codigomodalidad = codigomodalidad;
    }

    public String getCodigomunicipio() {
        return codigomunicipio;
    }

    public void setCodigomunicipio(String codigomunicipio) {
        this.codigomunicipio = codigomunicipio;
    }

    public String getCodigoproyecto() {
        return codigoproyecto;
    }

    public void setCodigoproyecto(String codigoproyecto) {
        this.codigoproyecto = codigoproyecto;
    }

    public String getCodigotipo() {
        return codigotipo;
    }

    public void setCodigotipo(String codigotipo) {
        this.codigotipo = codigotipo;
    }

    public String getDocumentoterminacion() {
        return documentoterminacion;
    }

    public void setDocumentoterminacion(String documentoterminacion) {
        this.documentoterminacion = documentoterminacion;
    }

    public Date getFechaactaavance() {
        return fechaactaavance;
    }

    public void setFechaactaavance(Date fechaactaavance) {
        this.fechaactaavance = fechaactaavance;
    }

    public Date getFechaadjudicacion() {
        return fechaadjudicacion;
    }

    public void setFechaadjudicacion(Date fechaadjudicacion) {
        this.fechaadjudicacion = fechaadjudicacion;
    }

    public Date getFechacierre() {
        return fechacierre;
    }

    public void setFechacierre(Date fechacierre) {
        this.fechacierre = fechacierre;
    }

    public Date getFechafinalactividad() {
        return fechafinalactividad;
    }

    public void setFechafinalactividad(Date fechafinalactividad) {
        this.fechafinalactividad = fechafinalactividad;
    }

    public Date getFechainicialactividad() {
        return fechainicialactividad;
    }

    public void setFechainicialactividad(Date fechainicialactividad) {
        this.fechainicialactividad = fechainicialactividad;
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public Date getFechalegalizacion() {
        return fechalegalizacion;
    }

    public void setFechalegalizacion(Date fechalegalizacion) {
        this.fechalegalizacion = fechalegalizacion;
    }

    public Date getFechaperfeccionamiento() {
        return fechaperfeccionamiento;
    }

    public void setFechaperfeccionamiento(Date fechaperfeccionamiento) {
        this.fechaperfeccionamiento = fechaperfeccionamiento;
    }

    public Date getFechasuscripcion() {
        return fechasuscripcion;
    }

    public void setFechasuscripcion(Date fechasuscripcion) {
        this.fechasuscripcion = fechasuscripcion;
    }

    public Date getFechaterminacion() {
        return fechaterminacion;
    }

    public void setFechaterminacion(Date fechaterminacion) {
        this.fechaterminacion = fechaterminacion;
    }

    public String getFktercero() {
        return fktercero;
    }

    public void setFktercero(String fktercero) {
        this.fktercero = fktercero;
    }

    public String getFktercerofuncionario() {
        return fktercerofuncionario;
    }

    public void setFktercerofuncionario(String fktercerofuncionario) {
        this.fktercerofuncionario = fktercerofuncionario;
    }

    public String getFktercerointersuper() {
        return fktercerointersuper;
    }

    public void setFktercerointersuper(String fktercerointersuper) {
        this.fktercerointersuper = fktercerointersuper;
    }

    public String getFkterceroordenadorgasto() {
        return fkterceroordenadorgasto;
    }

    public void setFkterceroordenadorgasto(String fkterceroordenadorgasto) {
        this.fkterceroordenadorgasto = fkterceroordenadorgasto;
    }

    public String getInversion() {
        return inversion;
    }

    public void setInversion(String inversion) {
        this.inversion = inversion;
    }

    public BigDecimal getLey80() {
        return ley80;
    }

    public void setLey80(BigDecimal ley80) {
        this.ley80 = ley80;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public String getMonedapago() {
        return monedapago;
    }

    public void setMonedapago(String monedapago) {
        this.monedapago = monedapago;
    }

    public String getObervaciones() {
        return obervaciones;
    }

    public void setObervaciones(String obervaciones) {
        this.obervaciones = obervaciones;
    }

    public String getObjeto() {
        return objeto;
    }

    public void setObjeto(String objeto) {
        this.objeto = objeto;
    }

    public String getPlazo() {
        return plazo;
    }

    public void setPlazo(String plazo) {
        this.plazo = plazo;
    }

    public String getPorcentajeactividad() {
        return porcentajeactividad;
    }

    public void setPorcentajeactividad(String porcentajeactividad) {
        this.porcentajeactividad = porcentajeactividad;
    }

    public String getPorcentajeavance() {
        return porcentajeavance;
    }

    public void setPorcentajeavance(String porcentajeavance) {
        this.porcentajeavance = porcentajeavance;
    }

    public String getResolucionadjudicacion() {
        return resolucionadjudicacion;
    }

    public void setResolucionadjudicacion(String resolucionadjudicacion) {
        this.resolucionadjudicacion = resolucionadjudicacion;
    }

    public BigDecimal getTasacambio() {
        return tasacambio;
    }

    public void setTasacambio(BigDecimal tasacambio) {
        this.tasacambio = tasacambio;
    }

    public String getTipoactaavance() {
        return tipoactaavance;
    }

    public void setTipoactaavance(String tipoactaavance) {
        this.tipoactaavance = tipoactaavance;
    }

    public String getTipocontrato() {
        return tipocontrato;
    }

    public void setTipocontrato(String tipocontrato) {
        this.tipocontrato = tipocontrato;
    }

    public String getTipointerventoria() {
        return tipointerventoria;
    }

    public void setTipointerventoria(String tipointerventoria) {
        this.tipointerventoria = tipointerventoria;
    }

    public String getTipoterminacion() {
        return tipoterminacion;
    }

    public void setTipoterminacion(String tipoterminacion) {
        this.tipoterminacion = tipoterminacion;
    }

    public String getTipovinculacionintersuper() {
        return tipovinculacionintersuper;
    }

    public void setTipovinculacionintersuper(String tipovinculacionintersuper) {
        this.tipovinculacionintersuper = tipovinculacionintersuper;
    }

    public String getUnidadduracion() {
        return unidadduracion;
    }

    public void setUnidadduracion(String unidadduracion) {
        this.unidadduracion = unidadduracion;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getValoradministracion() {
        return valoradministracion;
    }

    public void setValoradministracion(BigDecimal valoradministracion) {
        this.valoradministracion = valoradministracion;
    }

    public BigDecimal getValorimprevisto() {
        return valorimprevisto;
    }

    public void setValorimprevisto(BigDecimal valorimprevisto) {
        this.valorimprevisto = valorimprevisto;
    }

    public BigDecimal getValorivaobra() {
        return valorivaobra;
    }

    public void setValorivaobra(BigDecimal valorivaobra) {
        this.valorivaobra = valorivaobra;
    }

    public BigDecimal getValormonedaextranjera() {
        return valormonedaextranjera;
    }

    public void setValormonedaextranjera(BigDecimal valormonedaextranjera) {
        this.valormonedaextranjera = valormonedaextranjera;
    }

    public BigDecimal getValorsaldo() {
        return valorsaldo;
    }

    public void setValorsaldo(BigDecimal valorsaldo) {
        this.valorsaldo = valorsaldo;
    }

    public BigDecimal getValorutilidad() {
        return valorutilidad;
    }

    public void setValorutilidad(BigDecimal valorutilidad) {
        this.valorutilidad = valorutilidad;
    }

    public String getNombreproyecto() {
        return nombreproyecto;
    }

    public void setNombreproyecto(String nombreproyecto) {
        this.nombreproyecto = nombreproyecto;
    }

    public String getFormapago() {
        return formapago;
    }

    public void setFormapago(String formapago) {
        this.formapago = formapago;
    }

    public String getTiempogarantia() {
        return tiempogarantia;
    }

    public void setTiempogarantia(String tiempogarantia) {
        this.tiempogarantia = tiempogarantia;
    }

    public String getContratovigente() {
        return contratovigente;
    }

    public void setContratovigente(String contratovigente) {
        this.contratovigente = contratovigente;
    }

    public Date getFechaterminacionvigente() {
        return fechaterminacionvigente;
    }

    public void setFechaterminacionvigente(Date fechaterminacionvigente) {
        this.fechaterminacionvigente = fechaterminacionvigente;
    }

    public BigDecimal getValorsiniva() {
        return valorsiniva;
    }

    public void setValorsiniva(BigDecimal valorsiniva) {
        this.valorsiniva = valorsiniva;
    }

    public String getSecopcodigoproceso() {
        return secopcodigoproceso;
    }

    public void setSecopcodigoproceso(String secopcodigoproceso) {
        this.secopcodigoproceso = secopcodigoproceso;
    }

    public String getSecopnumeroproceso() {
        return secopnumeroproceso;
    }

    public void setSecopnumeroproceso(String secopnumeroproceso) {
        this.secopnumeroproceso = secopnumeroproceso;
    }

    public String getSecopnumeroconstancia() {
        return secopnumeroconstancia;
    }

    public void setSecopnumeroconstancia(String secopnumeroconstancia) {
        this.secopnumeroconstancia = secopnumeroconstancia;
    }

    public Date getSecopfechapublicacion() {
        return secopfechapublicacion;
    }

    public void setSecopfechapublicacion(Date secopfechapublicacion) {
        this.secopfechapublicacion = secopfechapublicacion;
    }

    public String getAlcance() {
        return alcance;
    }

    public void setAlcance(String alcance) {
        this.alcance = alcance;
    }

    public String getAnalisisriesgos() {
        return analisisriesgos;
    }

    public void setAnalisisriesgos(String analisisriesgos) {
        this.analisisriesgos = analisisriesgos;
    }

    public String getCondicionesentrega() {
        return condicionesentrega;
    }

    public void setCondicionesentrega(String condicionesentrega) {
        this.condicionesentrega = condicionesentrega;
    }

    public String getDiastiempopago() {
        return diastiempopago;
    }

    public void setDiastiempopago(String diastiempopago) {
        this.diastiempopago = diastiempopago;
    }

    public String getEstimacion() {
        return estimacion;
    }

    public void setEstimacion(String estimacion) {
        this.estimacion = estimacion;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public Date getFechaactainicio() {
        return fechaactainicio;
    }

    public void setFechaactainicio(Date fechaactainicio) {
        this.fechaactainicio = fechaactainicio;
    }

    public Date getFechaentrega() {
        return fechaentrega;
    }

    public void setFechaentrega(Date fechaentrega) {
        this.fechaentrega = fechaentrega;
    }

    public Date getFechafichatecnica() {
        return fechafichatecnica;
    }

    public void setFechafichatecnica(Date fechafichatecnica) {
        this.fechafichatecnica = fechafichatecnica;
    }

    public Date getFechainvitacion() {
        return fechainvitacion;
    }

    public void setFechainvitacion(Date fechainvitacion) {
        this.fechainvitacion = fechainvitacion;
    }

    public String getLugarejecucion() {
        return lugarejecucion;
    }

    public void setLugarejecucion(String lugarejecucion) {
        this.lugarejecucion = lugarejecucion;
    }

    public String getModalidadarticulo() {
        return modalidadarticulo;
    }

    public void setModalidadarticulo(String modalidadarticulo) {
        this.modalidadarticulo = modalidadarticulo;
    }

    public String getModalidadfundamento() {
        return modalidadfundamento;
    }

    public void setModalidadfundamento(String modalidadfundamento) {
        this.modalidadfundamento = modalidadfundamento;
    }

    public String getNecesidad() {
        return necesidad;
    }

    public void setNecesidad(String necesidad) {
        this.necesidad = necesidad;
    }

    public String getObjetoespecifico() {
        return objetoespecifico;
    }

    public void setObjetoespecifico(String objetoespecifico) {
        this.objetoespecifico = objetoespecifico;
    }

    public String getObligacionescontratista() {
        return obligacionescontratista;
    }

    public void setObligacionescontratista(String obligacionescontratista) {
        this.obligacionescontratista = obligacionescontratista;
    }

    public String getObligacionesuniversidad() {
        return obligacionesuniversidad;
    }

    public void setObligacionesuniversidad(String obligacionesuniversidad) {
        this.obligacionesuniversidad = obligacionesuniversidad;
    }

    public String getObservacionesactainicio() {
        return observacionesactainicio;
    }

    public void setObservacionesactainicio(String observacionesactainicio) {
        this.observacionesactainicio = observacionesactainicio;
    }

    public String getPerfilrequerido() {
        return perfilrequerido;
    }

    public void setPerfilrequerido(String perfilrequerido) {
        this.perfilrequerido = perfilrequerido;
    }

    public String getPlanadquisicion() {
        return planadquisicion;
    }

    public void setPlanadquisicion(String planadquisicion) {
        this.planadquisicion = planadquisicion;
    }

    public String getRequerimientostecnicos() {
        return requerimientostecnicos;
    }

    public void setRequerimientostecnicos(String requerimientostecnicos) {
        this.requerimientostecnicos = requerimientostecnicos;
    }

    public String getTipotiempopago() {
        return tipotiempopago;
    }

    public void setTipotiempopago(String tipotiempopago) {
        this.tipotiempopago = tipotiempopago;
    }

    public String getTipoestimacion() {
        return tipoestimacion;
    }

    public void setTipoestimacion(String tipoestimacion) {
        this.tipoestimacion = tipoestimacion;
    }

    public String getTipofinanciacion() {
        return tipofinanciacion;
    }

    public void setTipofinanciacion(String tipofinanciacion) {
        this.tipofinanciacion = tipofinanciacion;
    }

    public String getValorletras() {
        return valorletras;
    }

    public void setValorletras(String valorletras) {
        this.valorletras = valorletras;
    }
    
    
}
