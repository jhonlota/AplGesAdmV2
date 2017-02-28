/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import clases.ClaseBaseDatos;
import clases.ClaseGeneral;
import clases.ClaseInformacion;
import clases.ClaseMensaje;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jhon Lopez
 */
public class ContratosJpaController {

    private ClaseBaseDatos datos = new ClaseBaseDatos();

    public ContratosJpaController() {
    }

    public void create(Contratos contratos) {
        try {
            datos.update("INSERT INTO " + contratos.tabla + " VALUES ("
                    + "'" + contratos.getContrato() + "', "
                    + "'" + contratos.getAnticipio() + "', "
                    + contratos.getCantidadespreciosvariables() + ", "
                    + "'" + contratos.getCausal() + "', "
                    + "'" + contratos.getCodigoactividad() + "', "
                    + "'" + contratos.getCodigodepartamento() + "', "
                    + "'" + contratos.getCodigomodalidad() + "', "
                    + "'" + contratos.getCodigomunicipio() + "', "
                    + "'" + contratos.getCodigoproyecto() + "', "
                    + "'" + contratos.getCodigotipo() + "', "
                    + "'" + contratos.getDocumentoterminacion() + "', "
                    + "'" + ClaseInformacion.ConvertirFecha(contratos.getFechaactaavance()) + "', "
                    + "'" + ClaseInformacion.ConvertirFecha(contratos.getFechaadjudicacion()) + "', "
                    + "'" + ClaseInformacion.ConvertirFecha(contratos.getFechacierre()) + "', "
                    + "'" + ClaseInformacion.ConvertirFecha(contratos.getFechafinalactividad()) + "', "
                    + "'" + ClaseInformacion.ConvertirFecha(contratos.getFechainicialactividad()) + "', "
                    + "'" + ClaseInformacion.ConvertirFecha(contratos.getFechainicio()) + "', "
                    + "'" + ClaseInformacion.ConvertirFecha(contratos.getFechalegalizacion()) + "', "
                    + "'" + ClaseInformacion.ConvertirFecha(contratos.getFechaperfeccionamiento()) + "', "
                    + "'" + ClaseInformacion.ConvertirFecha(contratos.getFechasuscripcion()) + "', "
                    + "'" + ClaseInformacion.ConvertirFecha(contratos.getFechaterminacion()) + "', "
                    + "'" + contratos.getFktercero() + "', "
                    + "'" + contratos.getFktercerointersuper() + "', "
                    + "'" + contratos.getFkterceroordenadorgasto() + "', "
                    + "'" + contratos.getInversion() + "', "
                    + contratos.getLey80() + ", "
                    + "'" + contratos.getModalidad() + "', "
                    + "'" + contratos.getMonedapago() + "', "
                    + "'" + contratos.getObservaciones() + "', "
                    + "'" + contratos.getObjeto() + "', "
                    + "'" + contratos.getPlazo() + "', "
                    + "'" + contratos.getPorcentajeactividad() + "', "
                    + "'" + contratos.getPorcentajeavance() + "', "
                    + "'" + contratos.getResolucionadjudicacion() + "', "
                    + contratos.getTasacambio() + ", "
                    + "'" + contratos.getTipoactaavance() + "', "
                    + "'" + contratos.getTipocontrato() + "', "
                    + "'" + contratos.getTipointerventoria() + "', "
                    + "'" + contratos.getTipoterminacion() + "', "
                    + "'" + contratos.getTipovinculacionintersuper() + "', "
                    + "'" + contratos.getUnidadduracion() + "', "
                    + contratos.getValor() + ", "
                    + contratos.getValoradministracion() + ", "
                    + contratos.getValorimprevisto() + ", "
                    + contratos.getValorivaobra() + ", "
                    + contratos.getValormonedaextranjera() + ", "
                    + contratos.getValorsaldo() + ", "
                    + contratos.getValorutilidad() + ", "
                    + "'" + contratos.getNombreproyecto() + "', "
                    + "'" + contratos.getFormapago() + "', "
                    + "'" + contratos.getTiempogarantia() + "', "
                    + "'" + contratos.getContratovigente() + "', "
                    + "'" + ClaseInformacion.ConvertirFecha(contratos.getFechaterminacionvigente()) + "', "
                    + "'" + contratos.getFktercerofuncionario() + "', "
                    + contratos.getValorsiniva() + ", "
                    + "'" + contratos.getSecopcodigoproceso() + "', "
                    + "'" + contratos.getSecopnumeroproceso() + "', "
                    + "'" + contratos.getSecopnumeroconstancia() + "', "
                    + "'" + ClaseInformacion.ConvertirFecha(contratos.getSecopfechapublicacion()) + "')");
            if (!datos.isError) {
                ClaseMensaje.informacionGuardarBD("Contrato " + contratos.getContrato());
            }
        } catch (Exception ex) {
            ClaseMensaje.errorGuardarBD();
        } finally {
        }
    }

    public void edit(Contratos contratos, Contratos id) {
        try {
            datos.update("UPDATE CONTRATOS SET "
                    + "CONTRATO = '" + contratos.getContrato() + "', "
                    + "ANTICIPIO = '" + contratos.getAnticipio() + "', "
                    + "CANTIDADESPRECIOSVARIABLES = " + contratos.getCantidadespreciosvariables() + ", "
                    + "CAUSAL = '" + contratos.getCausal() + "', "
                    + "CODIGOACTIVIDAD = '" + contratos.getCodigoactividad() + "', "
                    + "CODIGODEPARTAMENTO = '" + contratos.getCodigodepartamento() + "', "
                    + "CODIGOMODALIDAD = '" + contratos.getCodigomodalidad() + "', "
                    + "CODIGOMUNICIPIO = '" + contratos.getCodigomunicipio() + "', "
                    + "CODIGOPROYECTO = '" + contratos.getCodigoproyecto() + "', "
                    + "CODIGOTIPO = '" + contratos.getCodigotipo() + "', "
                    + "DOCUMENTOTERMINACION = '" + contratos.getDocumentoterminacion() + "', "
                    + "FECHAACTAAVANCE = '" + ClaseInformacion.ConvertirFecha(contratos.getFechaactaavance()) + "', "
                    + "FECHAADJUDICACION = '" + ClaseInformacion.ConvertirFecha(contratos.getFechaadjudicacion()) + "', "
                    + "FECHACIERRE = '" + ClaseInformacion.ConvertirFecha(contratos.getFechacierre()) + "', "
                    + "FECHAFINALACTIVIDAD = '" + ClaseInformacion.ConvertirFecha(contratos.getFechafinalactividad()) + "', "
                    + "FECHAINICIALACTIVIDAD = '" + ClaseInformacion.ConvertirFecha(contratos.getFechainicialactividad()) + "', "
                    + "FECHAINICIO = '" + ClaseInformacion.ConvertirFecha(contratos.getFechainicio()) + "', "
                    + "FECHALEGALIZACION = '" + ClaseInformacion.ConvertirFecha(contratos.getFechalegalizacion()) + "', "
                    + "FECHAPERFECCIONAMIENTO = '" + ClaseInformacion.ConvertirFecha(contratos.getFechaperfeccionamiento()) + "', "
                    + "FECHASUSCRIPCION = '" + ClaseInformacion.ConvertirFecha(contratos.getFechasuscripcion()) + "', "
                    + "FECHATERMINACION = '" + ClaseInformacion.ConvertirFecha(contratos.getFechaterminacion()) + "', "
                    + "FKTERCERO = '" + contratos.getFktercero() + "', "
                    + "FKTERCEROINTERSUPER = '" + contratos.getFktercerointersuper() + "', "
                    + "FKTERCEROORDENADORGASTO = '" + contratos.getFkterceroordenadorgasto() + "', "
                    + "INVERSION = '" + contratos.getInversion() + "', "
                    + "LEY80 = " + contratos.getLey80() + ", "
                    + "MODALIDAD = '" + contratos.getModalidad() + "', "
                    + "MONEDAPAGO = '" + contratos.getMonedapago() + "', "
                    + "OBSERVACIONES = '" + contratos.getObservaciones() + "', "
                    + "OBJETO = '" + contratos.getObjeto() + "', "
                    + "PLAZO = '" + contratos.getPlazo() + "', "
                    + "PORCENTAJEACTIVIDAD = '" + contratos.getPorcentajeactividad() + "', "
                    + "PORCENTAJEAVANCE = '" + contratos.getPorcentajeavance() + "', "
                    + "RESOLUCIONADJUDICACION = '" + contratos.getResolucionadjudicacion() + "', "
                    + "TASACAMBIO = " + contratos.getTasacambio() + ", "
                    + "TIPOACTAAVANCE = '" + contratos.getTipoactaavance() + "', "
                    + "TIPOCONTRATO = '" + contratos.getTipocontrato() + "', "
                    + "TIPOINTERVENTORIA = '" + contratos.getTipointerventoria() + "', "
                    + "TIPOTERMINACION = '" + contratos.getTipoterminacion() + "', "
                    + "TIPOVINCULACIONINTERSUPER = '" + contratos.getTipovinculacionintersuper() + "', "
                    + "UNIDADDURACION = '" + contratos.getUnidadduracion() + "', "
                    + "VALOR = " + contratos.getValor() + ", "
                    + "VALORADMINISTRACION = " + contratos.getValoradministracion() + ", "
                    + "VALORIMPREVISTO = " + contratos.getValorimprevisto() + ", "
                    + "VALORIVAOBRA = " + contratos.getValorivaobra() + ", "
                    + "VALORMONEDAEXTRANJERA = " + contratos.getValormonedaextranjera() + ", "
                    + "VALORSALDO = " + contratos.getValorsaldo() + ", "
                    + "VALORUTILIDAD = " + contratos.getValorutilidad() + ", "
                    + "NOMBREPROYECTO = '" + contratos.getNombreproyecto() + "', "
                    + "FORMAPAGO = '" + contratos.getFormapago() + "', "
                    + "TIEMPOGARANTIA = '" + contratos.getTiempogarantia() + "', "
                    + "CONTRATOVIGENTE = '" + contratos.getContratovigente() + "', "
                    + "FECHATERMINACIONVIGENTE = '" + ClaseInformacion.ConvertirFecha(contratos.getFechaterminacionvigente()) + "', "
                    + "FKTERCEROFUNCIONARIO = '" + contratos.getFktercerofuncionario() + "', "
                    + "VALORSINIVA = " + contratos.getValorsiniva() + ", "
                    + "SECOPCODIGOPROCESO = '" + contratos.getSecopcodigoproceso() + "', "
                    + "SECOPNUMEROPROCESO = '" + contratos.getSecopnumeroproceso() + "', "
                    + "SECOPNUMEROCONSTANCIA = '" + contratos.getSecopnumeroconstancia() + "', "
                    + "SECOPFECHAPUBLICACION = '" + ClaseInformacion.ConvertirFecha(contratos.getSecopfechapublicacion()) + "' "
                    + "WHERE "
                    + "CONTRATO = '" + id.getContrato() + "'");
            if (!datos.isError) {
                ClaseMensaje.informacionActualizarBD("El Contrato " + contratos.getContrato());
            }
        } catch (Exception ex) {
            ClaseMensaje.errorActualizarBD();
        } finally {
        }
    }

    public void editFktercero(String fktercero, String id) {
        try {
            datos.update("UPDATE CONTRATOS SET "
                    + "FKTERCERO = '" + fktercero + "' "
                    + "WHERE "
                    + "FKTERCERO LIKE '" + id + " - %'");
        } catch (Exception ex) {
            ClaseMensaje.errorActualizarBD();
        } finally {
        }

        try {
            datos.update("UPDATE CONTRATOS SET "
                    + "FKTERCEROINTERSUPER = '" + fktercero + "' "
                    + "WHERE "
                    + "FKTERCEROINTERSUPER LIKE '" + id + " - %'");
        } catch (Exception ex) {
            ClaseMensaje.errorActualizarBD();
        } finally {
        }

        try {
            datos.update("UPDATE CONTRATOS SET "
                    + "FKTERCEROORDENADORGASTO = '" + fktercero + "' "
                    + "WHERE "
                    + "FKTERCEROORDENADORGASTO LIKE '" + id + " - %'");
        } catch (Exception ex) {
            ClaseMensaje.errorActualizarBD();
        } finally {
        }

        try {
            datos.update("UPDATE CONTRATOS SET "
                    + "FKTERCEROFUNCIONARIO = '" + fktercero + "' "
                    + "WHERE "
                    + "FKTERCEROFUNCIONARIO LIKE '" + id + " - %'");
        } catch (Exception ex) {
            ClaseMensaje.errorActualizarBD();
        } finally {
        }
    }

    public void destroy(String id) {
        try {
            datos.update("DELETE FROM CONTRATOS "
                    + "WHERE "
                    + "CONTRATO = '" + id + "'");
            if (!datos.isError) {
                ClaseMensaje.informacionEliminarBD("El Contrato " + id);
            }
        } catch (Exception ex) {
            ClaseMensaje.errorEliminarBD();
        } finally {
        }
    }

    public boolean verify(Contratos contratos, String estado) {
        try {
            ClaseGeneral.errorValidacion = "";
            if (ClaseInformacion.ValidarContratos(contratos.getContrato())
                    && ClaseInformacion.ValidarSeleccione(contratos.getAnticipio(), "SE PACTÓ ANTICIPO AL CONTRATO")
                    && ClaseInformacion.ValidarSeleccione(contratos.getCausal(), "CAUSAL")
                    && ClaseInformacion.ValidarSeleccione(contratos.getCodigodepartamento(), "CÓDIGO DEPARTAMENTO")
                    && ClaseInformacion.ValidarSeleccione(contratos.getCodigomodalidad(), "CÓDIGO MODALIDAD CONTRATACIÓN")
                    && ClaseInformacion.ValidarSeleccione(contratos.getCodigomunicipio(), "CÓDIGO MUNICIPIO")
                    && ClaseInformacion.ValidarSeleccione(contratos.getCodigotipo(), "CODIGO TIPO CONTRATO")
                    && ClaseInformacion.ValidarSeleccione(contratos.getFktercero(), "CÉDULA / NIT DEL CONTRATISTA")
                    && ClaseInformacion.ValidarSeleccione(contratos.getFktercerofuncionario(), "CÉDULA DEL FUNCIONARIO")
                    && ClaseInformacion.ValidarSeleccione(contratos.getFktercerointersuper(), "CÉDULA / NIT DEL INTERVENTOR")
                    && ClaseInformacion.ValidarSeleccione(contratos.getFkterceroordenadorgasto(), "CÉDULA DEL ORDENADOR DE GASTO")
                    && ClaseInformacion.ValidarSeleccione(contratos.getFormapago(), "FORMA DE PAGO DEL CONTRATO")
                    && ClaseInformacion.ValidarSeleccione(contratos.getInversion(), "ES INVERSION")
                    && ClaseInformacion.ValidarSeleccione(contratos.getModalidad(), "MODALIDAD DE CONTRATACIÓN")
                    && ClaseInformacion.ValidarSeleccione(contratos.getMonedapago(), "MONEDA DE PAGO")
                    && ClaseInformacion.ValidarSeleccione(contratos.getObservaciones(), "OBSERVACIÓN AL CONTRATO")
                    && ClaseInformacion.ValidarSeleccione(contratos.getObjeto(), "OBJETO DEL CONTRATO")
                    && ClaseInformacion.ValidarSeleccione(contratos.getPlazo(), "PLAZO")
                    && ClaseInformacion.ValidarSeleccione(contratos.getTiempogarantia(), "TIEMPO DE GARANTIA DE CONTRATO")
                    && ClaseInformacion.ValidarSeleccione(contratos.getTipocontrato(), "TIPO DE CONTRATO")
                    && ClaseInformacion.ValidarSeleccione(contratos.getTipointerventoria(), "TIPO DE INTERVENTORÍA")
                    && ClaseInformacion.ValidarSeleccione(contratos.getTipovinculacionintersuper(), "TIPO DE VINCULACIÓN INTERVENTOR o  SUPERVISOR")
                    && ClaseInformacion.ValidarSeleccione(contratos.getUnidadduracion(), "UNIDAD DE DURACIÓN")
                    && ClaseInformacion.ValidarSeleccione("" + contratos.getValor(), "VALOR INICIAL DEL CONTRATO")
                    && ClaseInformacion.ValidarSeleccione("" + contratos.getValorsiniva(), "VALOR SIN IVA")
                    && (ClaseGeneral.perfil.equals("root") ? 
                        true 
                        : (estado.equals("create") ? 
                            ClaseInformacion.ValidarCondicion(ClaseInformacion.calcularDiasEntreFechas(ClaseGeneral.controlUtilidades.fechaServidor(), contratos.getFechasuscripcion()) >= 0 && ClaseInformacion.calcularDiasEntreFechas(ClaseGeneral.controlUtilidades.fechaServidor(), contratos.getFechasuscripcion()) <= 8, "ERROR EN LA FECHA DE ELABORACION")
                            : true)
                    )
                    && (ClaseGeneral.perfil.equals("root") ? true : (estado.equals("create") ? ClaseInformacion.ValidarCondicion(ClaseInformacion.calcularDiasEntreFechas(ClaseGeneral.controlUtilidades.fechaServidor(), contratos.getFechainicio()) >= 0 && ClaseInformacion.calcularDiasEntreFechas(ClaseGeneral.controlUtilidades.fechaServidor(), contratos.getFechainicio()) <= 8, "ERROR EN LA FECHA DE INICIO") : true))
                    && (ClaseGeneral.perfil.equals("root") ? true : (estado.equals("create") ? ClaseInformacion.ValidarContiene(ClaseGeneral.controlAnexosterceros.findDocumentoDiasTotalInAnexostercerosByFkterceroPersonaFecha(contratos.getFktercero(), ClaseGeneral.controlTerceros.findPersonaInTercerosById(contratos.getFktercero()), ClaseGeneral.contratos.getFechasuscripcion()), "NO ADJUNTO", "FALTAN DOCUMENTOS DEL TERCERO") : true))
                    && (ClaseGeneral.perfil.equals("root") ? true : (estado.equals("create") ? ClaseInformacion.ValidarContiene(ClaseGeneral.controlAnexosterceros.findDocumentoDiasTotalInAnexostercerosByFkterceroPersonaFecha(contratos.getFktercero(), ClaseGeneral.controlTerceros.findPersonaInTercerosById(contratos.getFktercero()), ClaseGeneral.contratos.getFechasuscripcion()), "VENCIDO", "EL TERCERO TIENE DOCUMENTOS VENCIDOS") : true))) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            return false;
        } finally {
        }
    }

    public List<Contratos> findAllInContratosByEntities() {
        List<Contratos> listContratos = new ArrayList<Contratos>();
        Contratos contratos;

        try {
            if (ClaseGeneral.perfil.equals("usuario")) {
                datos.query("SELECT * FROM CONTRATOS "
                        + "WHERE FKTERCEROINTERSUPER IN ("
                        + "SELECT ID || ' - ' || NOMBRE "
                        + "FROM TERCEROS "
                        + "WHERE DEPENDENCIA = '" + ClaseGeneral.dependencia + "') "
                        + "OR FKTERCEROFUNCIONARIO IN ("
                        + "SELECT ID || ' - ' || NOMBRE "
                        + "FROM TERCEROS "
                        + "WHERE DEPENDENCIA = '" + ClaseGeneral.dependencia + "') ORDER BY FECHASUSCRIPCION DESC");
            } else {
                datos.query("SELECT * FROM CONTRATOS  ORDER BY FECHASUSCRIPCION DESC");
            }
            while (ClaseBaseDatos.resultado.next()) {
                contratos = new Contratos();
                contratos.setContrato(ClaseBaseDatos.resultado.getString("CONTRATO"));
                contratos.setAnticipio(ClaseBaseDatos.resultado.getString("ANTICIPIO"));
                contratos.setCantidadespreciosvariables(BigDecimal.valueOf(Long.parseLong("" + ClaseBaseDatos.resultado.getBigDecimal("CANTIDADESPRECIOSVARIABLES"))));
                contratos.setCausal(ClaseBaseDatos.resultado.getString("CAUSAL"));
                contratos.setCodigoactividad(ClaseBaseDatos.resultado.getString("CODIGOACTIVIDAD"));
                contratos.setCodigodepartamento(ClaseBaseDatos.resultado.getString("CODIGODEPARTAMENTO"));
                contratos.setCodigomodalidad(ClaseBaseDatos.resultado.getString("CODIGOMODALIDAD"));
                contratos.setCodigomunicipio(ClaseBaseDatos.resultado.getString("CODIGOMUNICIPIO"));
                contratos.setCodigoproyecto(ClaseBaseDatos.resultado.getString("CODIGOPROYECTO"));
                contratos.setCodigotipo(ClaseBaseDatos.resultado.getString("CODIGOTIPO"));
                contratos.setDocumentoterminacion(ClaseBaseDatos.resultado.getString("DOCUMENTOTERMINACION"));
                contratos.setFechaactaavance(ClaseBaseDatos.resultado.getDate("FECHAACTAAVANCE"));
                contratos.setFechaadjudicacion(ClaseBaseDatos.resultado.getDate("FECHAADJUDICACION"));
                contratos.setFechacierre(ClaseBaseDatos.resultado.getDate("FECHACIERRE"));
                contratos.setFechafinalactividad(ClaseBaseDatos.resultado.getDate("FECHAFINALACTIVIDAD"));
                contratos.setFechainicialactividad(ClaseBaseDatos.resultado.getDate("FECHAINICIALACTIVIDAD"));
                contratos.setFechainicio(ClaseBaseDatos.resultado.getDate("FECHAINICIO"));
                contratos.setFechalegalizacion(ClaseBaseDatos.resultado.getDate("FECHALEGALIZACION"));
                contratos.setFechaperfeccionamiento(ClaseBaseDatos.resultado.getDate("FECHAPERFECCIONAMIENTO"));
                contratos.setFechasuscripcion(ClaseBaseDatos.resultado.getDate("FECHASUSCRIPCION"));
                contratos.setFechaterminacion(ClaseBaseDatos.resultado.getDate("FECHATERMINACION"));
                contratos.setFktercero(ClaseBaseDatos.resultado.getString("FKTERCERO"));
                contratos.setFktercerointersuper(ClaseBaseDatos.resultado.getString("FKTERCEROINTERSUPER"));
                contratos.setFkterceroordenadorgasto(ClaseBaseDatos.resultado.getString("FKTERCEROORDENADORGASTO"));
                contratos.setInversion(ClaseBaseDatos.resultado.getString("INVERSION"));
                contratos.setLey80(BigDecimal.valueOf(Long.parseLong("" + ClaseBaseDatos.resultado.getBigDecimal("LEY80"))));
                contratos.setModalidad(ClaseBaseDatos.resultado.getString("MODALIDAD"));
                contratos.setMonedapago(ClaseBaseDatos.resultado.getString("MONEDAPAGO"));
                contratos.setObservaciones(ClaseBaseDatos.resultado.getString("OBSERVACIONES"));
                contratos.setObjeto(ClaseBaseDatos.resultado.getString("OBJETO"));
                contratos.setPlazo(ClaseBaseDatos.resultado.getString("PLAZO"));
                contratos.setPorcentajeactividad(ClaseBaseDatos.resultado.getString("PORCENTAJEACTIVIDAD"));
                contratos.setPorcentajeavance(ClaseBaseDatos.resultado.getString("PORCENTAJEAVANCE"));
                contratos.setResolucionadjudicacion(ClaseBaseDatos.resultado.getString("RESOLUCIONADJUDICACION"));
                contratos.setTasacambio(BigDecimal.valueOf(Long.parseLong("" + ClaseBaseDatos.resultado.getBigDecimal("TASACAMBIO"))));
                contratos.setTipoactaavance(ClaseBaseDatos.resultado.getString("TIPOACTAAVANCE"));
                contratos.setTipocontrato(ClaseBaseDatos.resultado.getString("TIPOCONTRATO"));
                contratos.setTipointerventoria(ClaseBaseDatos.resultado.getString("TIPOINTERVENTORIA"));
                contratos.setTipoterminacion(ClaseBaseDatos.resultado.getString("TIPOTERMINACION"));
                contratos.setTipovinculacionintersuper(ClaseBaseDatos.resultado.getString("TIPOVINCULACIONINTERSUPER"));
                contratos.setUnidadduracion(ClaseBaseDatos.resultado.getString("UNIDADDURACION"));
                contratos.setValor(BigDecimal.valueOf(Long.parseLong("" + ClaseBaseDatos.resultado.getBigDecimal("VALOR"))));
                contratos.setValoradministracion(BigDecimal.valueOf(Long.parseLong("" + ClaseBaseDatos.resultado.getBigDecimal("VALORADMINISTRACION"))));
                contratos.setValorimprevisto(BigDecimal.valueOf(Long.parseLong("" + ClaseBaseDatos.resultado.getBigDecimal("VALORIMPREVISTO"))));
                contratos.setValorivaobra(BigDecimal.valueOf(Long.parseLong("" + ClaseBaseDatos.resultado.getBigDecimal("VALORIVAOBRA"))));
                contratos.setValormonedaextranjera(BigDecimal.valueOf(Long.parseLong("" + ClaseBaseDatos.resultado.getBigDecimal("VALORMONEDAEXTRANJERA"))));
                contratos.setValorsaldo(BigDecimal.valueOf(Long.parseLong("" + ClaseBaseDatos.resultado.getBigDecimal("VALORSALDO"))));
                contratos.setValorutilidad(BigDecimal.valueOf(Long.parseLong("" + ClaseBaseDatos.resultado.getBigDecimal("VALORUTILIDAD"))));
                contratos.setNombreproyecto(ClaseBaseDatos.resultado.getString("NOMBREPROYECTO"));
                contratos.setFormapago(ClaseBaseDatos.resultado.getString("FORMAPAGO"));
                contratos.setTiempogarantia(ClaseBaseDatos.resultado.getString("TIEMPOGARANTIA"));
                contratos.setContratovigente(ClaseBaseDatos.resultado.getString("CONTRATOVIGENTE"));
                contratos.setFechaterminacionvigente(ClaseBaseDatos.resultado.getDate("FECHATERMINACIONVIGENTE"));
                contratos.setFktercerofuncionario(ClaseBaseDatos.resultado.getString("FKTERCEROFUNCIONARIO"));
                contratos.setValorsiniva(BigDecimal.valueOf(Long.parseLong("" + ClaseBaseDatos.resultado.getBigDecimal("VALORSINIVA"))));
                contratos.setSecopcodigoproceso(ClaseBaseDatos.resultado.getString("SECOPCODIGOPROCESO"));
                contratos.setSecopnumeroproceso(ClaseBaseDatos.resultado.getString("SECOPNUMEROPROCESO"));
                contratos.setSecopnumeroconstancia(ClaseBaseDatos.resultado.getString("SECOPNUMEROCONSTANCIA"));
                contratos.setSecopfechapublicacion(ClaseBaseDatos.resultado.getDate("SECOPFECHAPUBLICACION"));

                listContratos.add(contratos);
            }
            return listContratos;
        } catch (SQLException ex) {
            ClaseMensaje.errorFind(this.toString(), ex.toString());
            return null;
        }
    }

    public List<Contratos> findAllInContratosBy() {
        List<Contratos> listContratos = new ArrayList<Contratos>();
        Contratos contratos;

        try {
            if (ClaseGeneral.perfil.equals("usuario")) {
                datos.query("SELECT * FROM CONTRATOS "
                        + "WHERE " + ClaseGeneral.parametro + " LIKE '%" + ClaseGeneral.valor + "%' "
                        + "AND (FKTERCEROINTERSUPER IN ("
                        + "SELECT ID || ' - ' || NOMBRE "
                        + "FROM TERCEROS "
                        + "WHERE DEPENDENCIA = '" + ClaseGeneral.dependencia + "') "
                        + "OR FKTERCEROFUNCIONARIO IN ("
                        + "SELECT ID || ' - ' || NOMBRE "
                        + "FROM TERCEROS "
                        + "WHERE DEPENDENCIA = '" + ClaseGeneral.dependencia + "')) ORDER BY FECHASUSCRIPCION DESC");
            } else {
                datos.query("SELECT * FROM CONTRATOS "
                        + "WHERE "
                        + ClaseGeneral.parametro + " LIKE '%" + ClaseGeneral.valor + "%' ORDER BY FECHASUSCRIPCION DESC");
            }
            while (ClaseBaseDatos.resultado.next()) {
                contratos = new Contratos();
                contratos.setContrato(ClaseBaseDatos.resultado.getString("CONTRATO"));
                contratos.setAnticipio(ClaseBaseDatos.resultado.getString("ANTICIPIO"));
                contratos.setCantidadespreciosvariables(BigDecimal.valueOf(Long.parseLong("" + ClaseBaseDatos.resultado.getBigDecimal("CANTIDADESPRECIOSVARIABLES"))));
                contratos.setCausal(ClaseBaseDatos.resultado.getString("CAUSAL"));
                contratos.setCodigoactividad(ClaseBaseDatos.resultado.getString("CODIGOACTIVIDAD"));
                contratos.setCodigodepartamento(ClaseBaseDatos.resultado.getString("CODIGODEPARTAMENTO"));
                contratos.setCodigomodalidad(ClaseBaseDatos.resultado.getString("CODIGOMODALIDAD"));
                contratos.setCodigomunicipio(ClaseBaseDatos.resultado.getString("CODIGOMUNICIPIO"));
                contratos.setCodigoproyecto(ClaseBaseDatos.resultado.getString("CODIGOPROYECTO"));
                contratos.setCodigotipo(ClaseBaseDatos.resultado.getString("CODIGOTIPO"));
                contratos.setDocumentoterminacion(ClaseBaseDatos.resultado.getString("DOCUMENTOTERMINACION"));
                contratos.setFechaactaavance(ClaseBaseDatos.resultado.getDate("FECHAACTAAVANCE"));
                contratos.setFechaadjudicacion(ClaseBaseDatos.resultado.getDate("FECHAADJUDICACION"));
                contratos.setFechacierre(ClaseBaseDatos.resultado.getDate("FECHACIERRE"));
                contratos.setFechafinalactividad(ClaseBaseDatos.resultado.getDate("FECHAFINALACTIVIDAD"));
                contratos.setFechainicialactividad(ClaseBaseDatos.resultado.getDate("FECHAINICIALACTIVIDAD"));
                contratos.setFechainicio(ClaseBaseDatos.resultado.getDate("FECHAINICIO"));
                contratos.setFechalegalizacion(ClaseBaseDatos.resultado.getDate("FECHALEGALIZACION"));
                contratos.setFechaperfeccionamiento(ClaseBaseDatos.resultado.getDate("FECHAPERFECCIONAMIENTO"));
                contratos.setFechasuscripcion(ClaseBaseDatos.resultado.getDate("FECHASUSCRIPCION"));
                contratos.setFechaterminacion(ClaseBaseDatos.resultado.getDate("FECHATERMINACION"));
                contratos.setFktercero(ClaseBaseDatos.resultado.getString("FKTERCERO"));
                contratos.setFktercerointersuper(ClaseBaseDatos.resultado.getString("FKTERCEROINTERSUPER"));
                contratos.setFkterceroordenadorgasto(ClaseBaseDatos.resultado.getString("FKTERCEROORDENADORGASTO"));
                contratos.setInversion(ClaseBaseDatos.resultado.getString("INVERSION"));
                contratos.setLey80(BigDecimal.valueOf(Long.parseLong("" + ClaseBaseDatos.resultado.getBigDecimal("LEY80"))));
                contratos.setModalidad(ClaseBaseDatos.resultado.getString("MODALIDAD"));
                contratos.setMonedapago(ClaseBaseDatos.resultado.getString("MONEDAPAGO"));
                contratos.setObservaciones(ClaseBaseDatos.resultado.getString("OBSERVACIONES"));
                contratos.setObjeto(ClaseBaseDatos.resultado.getString("OBJETO"));
                contratos.setPlazo(ClaseBaseDatos.resultado.getString("PLAZO"));
                contratos.setPorcentajeactividad(ClaseBaseDatos.resultado.getString("PORCENTAJEACTIVIDAD"));
                contratos.setPorcentajeavance(ClaseBaseDatos.resultado.getString("PORCENTAJEAVANCE"));
                contratos.setResolucionadjudicacion(ClaseBaseDatos.resultado.getString("RESOLUCIONADJUDICACION"));
                contratos.setTasacambio(BigDecimal.valueOf(Long.parseLong("" + ClaseBaseDatos.resultado.getBigDecimal("TASACAMBIO"))));
                contratos.setTipoactaavance(ClaseBaseDatos.resultado.getString("TIPOACTAAVANCE"));
                contratos.setTipocontrato(ClaseBaseDatos.resultado.getString("TIPOCONTRATO"));
                contratos.setTipointerventoria(ClaseBaseDatos.resultado.getString("TIPOINTERVENTORIA"));
                contratos.setTipoterminacion(ClaseBaseDatos.resultado.getString("TIPOTERMINACION"));
                contratos.setTipovinculacionintersuper(ClaseBaseDatos.resultado.getString("TIPOVINCULACIONINTERSUPER"));
                contratos.setUnidadduracion(ClaseBaseDatos.resultado.getString("UNIDADDURACION"));
                contratos.setValor(BigDecimal.valueOf(Long.parseLong("" + ClaseBaseDatos.resultado.getBigDecimal("VALOR"))));
                contratos.setValoradministracion(BigDecimal.valueOf(Long.parseLong("" + ClaseBaseDatos.resultado.getBigDecimal("VALORADMINISTRACION"))));
                contratos.setValorimprevisto(BigDecimal.valueOf(Long.parseLong("" + ClaseBaseDatos.resultado.getBigDecimal("VALORIMPREVISTO"))));
                contratos.setValorivaobra(BigDecimal.valueOf(Long.parseLong("" + ClaseBaseDatos.resultado.getBigDecimal("VALORIVAOBRA"))));
                contratos.setValormonedaextranjera(BigDecimal.valueOf(Long.parseLong("" + ClaseBaseDatos.resultado.getBigDecimal("VALORMONEDAEXTRANJERA"))));
                contratos.setValorsaldo(BigDecimal.valueOf(Long.parseLong("" + ClaseBaseDatos.resultado.getBigDecimal("VALORSALDO"))));
                contratos.setValorutilidad(BigDecimal.valueOf(Long.parseLong("" + ClaseBaseDatos.resultado.getBigDecimal("VALORUTILIDAD"))));
                contratos.setNombreproyecto(ClaseBaseDatos.resultado.getString("NOMBREPROYECTO"));
                contratos.setFormapago(ClaseBaseDatos.resultado.getString("FORMAPAGO"));
                contratos.setTiempogarantia(ClaseBaseDatos.resultado.getString("TIEMPOGARANTIA"));
                contratos.setContratovigente(ClaseBaseDatos.resultado.getString("CONTRATOVIGENTE"));
                contratos.setFechaterminacionvigente(ClaseBaseDatos.resultado.getDate("FECHATERMINACIONVIGENTE"));
                contratos.setFktercerofuncionario(ClaseBaseDatos.resultado.getString("FKTERCEROFUNCIONARIO"));
                contratos.setValorsiniva(BigDecimal.valueOf(Long.parseLong("" + ClaseBaseDatos.resultado.getBigDecimal("VALORSINIVA"))));
                contratos.setSecopcodigoproceso(ClaseBaseDatos.resultado.getString("SECOPCODIGOPROCESO"));
                contratos.setSecopnumeroproceso(ClaseBaseDatos.resultado.getString("SECOPNUMEROPROCESO"));
                contratos.setSecopnumeroconstancia(ClaseBaseDatos.resultado.getString("SECOPNUMEROCONSTANCIA"));
                contratos.setSecopfechapublicacion(ClaseBaseDatos.resultado.getDate("SECOPFECHAPUBLICACION"));

                listContratos.add(contratos);
            }
            return listContratos;
        } catch (SQLException ex) {
            ClaseMensaje.errorFind(this.toString(), ex.toString());
            return null;
        }
    }

    public List<Contratos> findAllInContratosByFktercero(String fktercero) {
        List<Contratos> listContratos = new ArrayList<Contratos>();
        Contratos contratos;

        try {
            datos.query("SELECT * FROM CONTRATOS "
                    + "WHERE "
                    + "FKTERCERO LIKE '" + fktercero + " - %'");
            while (ClaseBaseDatos.resultado.next()) {
                contratos = new Contratos();
                contratos.setContrato(ClaseBaseDatos.resultado.getString("CONTRATO"));
                contratos.setAnticipio(ClaseBaseDatos.resultado.getString("ANTICIPIO"));
                contratos.setCantidadespreciosvariables(BigDecimal.valueOf(Long.parseLong("" + ClaseBaseDatos.resultado.getBigDecimal("CANTIDADESPRECIOSVARIABLES"))));
                contratos.setCausal(ClaseBaseDatos.resultado.getString("CAUSAL"));
                contratos.setCodigoactividad(ClaseBaseDatos.resultado.getString("CODIGOACTIVIDAD"));
                contratos.setCodigodepartamento(ClaseBaseDatos.resultado.getString("CODIGODEPARTAMENTO"));
                contratos.setCodigomodalidad(ClaseBaseDatos.resultado.getString("CODIGOMODALIDAD"));
                contratos.setCodigomunicipio(ClaseBaseDatos.resultado.getString("CODIGOMUNICIPIO"));
                contratos.setCodigoproyecto(ClaseBaseDatos.resultado.getString("CODIGOPROYECTO"));
                contratos.setCodigotipo(ClaseBaseDatos.resultado.getString("CODIGOTIPO"));
                contratos.setDocumentoterminacion(ClaseBaseDatos.resultado.getString("DOCUMENTOTERMINACION"));
                contratos.setFechaactaavance(ClaseBaseDatos.resultado.getDate("FECHAACTAAVANCE"));
                contratos.setFechaadjudicacion(ClaseBaseDatos.resultado.getDate("FECHAADJUDICACION"));
                contratos.setFechacierre(ClaseBaseDatos.resultado.getDate("FECHACIERRE"));
                contratos.setFechafinalactividad(ClaseBaseDatos.resultado.getDate("FECHAFINALACTIVIDAD"));
                contratos.setFechainicialactividad(ClaseBaseDatos.resultado.getDate("FECHAINICIALACTIVIDAD"));
                contratos.setFechainicio(ClaseBaseDatos.resultado.getDate("FECHAINICIO"));
                contratos.setFechalegalizacion(ClaseBaseDatos.resultado.getDate("FECHALEGALIZACION"));
                contratos.setFechaperfeccionamiento(ClaseBaseDatos.resultado.getDate("FECHAPERFECCIONAMIENTO"));
                contratos.setFechasuscripcion(ClaseBaseDatos.resultado.getDate("FECHASUSCRIPCION"));
                contratos.setFechaterminacion(ClaseBaseDatos.resultado.getDate("FECHATERMINACION"));
                contratos.setFktercero(ClaseBaseDatos.resultado.getString("FKTERCERO"));
                contratos.setFktercerointersuper(ClaseBaseDatos.resultado.getString("FKTERCEROINTERSUPER"));
                contratos.setFkterceroordenadorgasto(ClaseBaseDatos.resultado.getString("FKTERCEROORDENADORGASTO"));
                contratos.setInversion(ClaseBaseDatos.resultado.getString("INVERSION"));
                contratos.setLey80(BigDecimal.valueOf(Long.parseLong("" + ClaseBaseDatos.resultado.getBigDecimal("LEY80"))));
                contratos.setModalidad(ClaseBaseDatos.resultado.getString("MODALIDAD"));
                contratos.setMonedapago(ClaseBaseDatos.resultado.getString("MONEDAPAGO"));
                contratos.setObservaciones(ClaseBaseDatos.resultado.getString("OBSERVACIONES"));
                contratos.setObjeto(ClaseBaseDatos.resultado.getString("OBJETO"));
                contratos.setPlazo(ClaseBaseDatos.resultado.getString("PLAZO"));
                contratos.setPorcentajeactividad(ClaseBaseDatos.resultado.getString("PORCENTAJEACTIVIDAD"));
                contratos.setPorcentajeavance(ClaseBaseDatos.resultado.getString("PORCENTAJEAVANCE"));
                contratos.setResolucionadjudicacion(ClaseBaseDatos.resultado.getString("RESOLUCIONADJUDICACION"));
                contratos.setTasacambio(BigDecimal.valueOf(Long.parseLong("" + ClaseBaseDatos.resultado.getBigDecimal("TASACAMBIO"))));
                contratos.setTipoactaavance(ClaseBaseDatos.resultado.getString("TIPOACTAAVANCE"));
                contratos.setTipocontrato(ClaseBaseDatos.resultado.getString("TIPOCONTRATO"));
                contratos.setTipointerventoria(ClaseBaseDatos.resultado.getString("TIPOINTERVENTORIA"));
                contratos.setTipoterminacion(ClaseBaseDatos.resultado.getString("TIPOTERMINACION"));
                contratos.setTipovinculacionintersuper(ClaseBaseDatos.resultado.getString("TIPOVINCULACIONINTERSUPER"));
                contratos.setUnidadduracion(ClaseBaseDatos.resultado.getString("UNIDADDURACION"));
                contratos.setValor(BigDecimal.valueOf(Long.parseLong("" + ClaseBaseDatos.resultado.getBigDecimal("VALOR"))));
                contratos.setValoradministracion(BigDecimal.valueOf(Long.parseLong("" + ClaseBaseDatos.resultado.getBigDecimal("VALORADMINISTRACION"))));
                contratos.setValorimprevisto(BigDecimal.valueOf(Long.parseLong("" + ClaseBaseDatos.resultado.getBigDecimal("VALORIMPREVISTO"))));
                contratos.setValorivaobra(BigDecimal.valueOf(Long.parseLong("" + ClaseBaseDatos.resultado.getBigDecimal("VALORIVAOBRA"))));
                contratos.setValormonedaextranjera(BigDecimal.valueOf(Long.parseLong("" + ClaseBaseDatos.resultado.getBigDecimal("VALORMONEDAEXTRANJERA"))));
                contratos.setValorsaldo(BigDecimal.valueOf(Long.parseLong("" + ClaseBaseDatos.resultado.getBigDecimal("VALORSALDO"))));
                contratos.setValorutilidad(BigDecimal.valueOf(Long.parseLong("" + ClaseBaseDatos.resultado.getBigDecimal("VALORUTILIDAD"))));
                contratos.setNombreproyecto(ClaseBaseDatos.resultado.getString("NOMBREPROYECTO"));
                contratos.setFormapago(ClaseBaseDatos.resultado.getString("FORMAPAGO"));
                contratos.setTiempogarantia(ClaseBaseDatos.resultado.getString("TIEMPOGARANTIA"));
                contratos.setContratovigente(ClaseBaseDatos.resultado.getString("CONTRATOVIGENTE"));
                contratos.setFechaterminacionvigente(ClaseBaseDatos.resultado.getDate("FECHATERMINACIONVIGENTE"));
                contratos.setFktercerofuncionario(ClaseBaseDatos.resultado.getString("FKTERCEROFUNCIONARIO"));
                contratos.setValorsiniva(BigDecimal.valueOf(Long.parseLong("" + ClaseBaseDatos.resultado.getBigDecimal("VALORSINIVA"))));
                contratos.setSecopcodigoproceso(ClaseBaseDatos.resultado.getString("SECOPCODIGOPROCESO"));
                contratos.setSecopnumeroproceso(ClaseBaseDatos.resultado.getString("SECOPNUMEROPROCESO"));
                contratos.setSecopnumeroconstancia(ClaseBaseDatos.resultado.getString("SECOPNUMEROCONSTANCIA"));
                contratos.setSecopfechapublicacion(ClaseBaseDatos.resultado.getDate("SECOPFECHAPUBLICACION"));

                listContratos.add(contratos);
            }
            return listContratos;
        } catch (SQLException ex) {
            ClaseMensaje.errorFind(this.toString(), ex.toString());
            return null;
        }
    }

    public List<String> findTiempoContratoCecopnumeroprocesoInContratosBy() {//PENDIENTES
        List<String> lista = new ArrayList<String>();

        try {
            if (ClaseGeneral.perfil.equals("usuario")) {
                datos.query("SELECT DISTINCT(CONTRATOS.CONTRATO), "
                        + "EXTRACT(DAY FROM (CURRENT_TIMESTAMP - CONTRATOS.FECHAINICIO)) TIEMPO, "
                        + "CONTRATOS.SECOPNUMEROPROCESO "
                        + "FROM CONTRATOS "
                        + "WHERE CONTRATOS.FECHAINICIO >= CAST('2013-09-01' AS DATE) "
                        + "AND (FKTERCEROINTERSUPER IN ("
                        + "SELECT ID || ' - ' || NOMBRE "
                        + "FROM TERCEROS "
                        + "WHERE DEPENDENCIA = '" + ClaseGeneral.dependencia + "') "
                        + "OR FKTERCEROFUNCIONARIO IN ("
                        + "SELECT ID || ' - ' || NOMBRE "
                        + "FROM TERCEROS "
                        + "WHERE DEPENDENCIA = '" + ClaseGeneral.dependencia + "')) "
                        + "ORDER BY TIEMPO DESC");
            } else {
                datos.query("SELECT DISTINCT(CONTRATOS.CONTRATO), "
                        + "EXTRACT(DAY FROM (CURRENT_TIMESTAMP - CONTRATOS.FECHAINICIO)) TIEMPO, "
                        + "CONTRATOS.SECOPNUMEROPROCESO "
                        + "FROM CONTRATOS "
                        + "WHERE CONTRATOS.FECHAINICIO >= CAST('2013-09-01' AS DATE) "
                        + "ORDER BY TIEMPO DESC");
            }

            while (ClaseBaseDatos.resultado.next()) {
                try {
                    String secopnumeroproceso = ClaseBaseDatos.resultado.getString("SECOPNUMEROPROCESO");
                    String contrato = ClaseBaseDatos.resultado.getString("CONTRATO");
                    String tiempo = ClaseBaseDatos.resultado.getString("TIEMPO");
                    if (secopnumeroproceso.equals("0")) {
                        lista.add(" (" + tiempo
                                + ") - " + contrato
                                + "//");
                    } else {
                        lista.add(" (" + tiempo
                                + ") - " + contrato
                                + "// SECOP");
                    }
                } catch (Exception ex) {
//                    System.out.println("Contratos - " + ex);
                }
            }
            return lista;
        } catch (SQLException ex) {
            ClaseMensaje.errorFind(this.toString(), ex.toString());
            return null;
        }
    }
}
