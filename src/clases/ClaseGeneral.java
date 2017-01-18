/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import entidades.*;
import java.awt.Color;

/**
 *
 * @author Jhon Lopez
 */
public class ClaseGeneral {

    public static Anexoscontratos anexoscontratos = new Anexoscontratos();
    public static AnexoscontratosJpaController controlAnexoscontratos = new AnexoscontratosJpaController();
    public static AnexoscontratosPK anexoscontratosPK = new AnexoscontratosPK();
    public static Anexosterceros anexosterceros = new Anexosterceros();
    public static AnexostercerosJpaController controlAnexosterceros = new AnexostercerosJpaController();
    public static AnexostercerosPK anexostercerosPK = new AnexostercerosPK();
    public static Bienessolicitudesoferta bienessolicitudesoferta = new Bienessolicitudesoferta();
    public static BienessolicitudesofertaJpaController controlBienessolicitudesoferta = new BienessolicitudesofertaJpaController();
    public static BienessolicitudesofertaPK bienessolicitudesofertaPK = new BienessolicitudesofertaPK();
    public static Calificacion calificacion = new Calificacion();
    public static CalificacionJpaController controlCalificacion = new CalificacionJpaController();
    public static Cinfo cinfo = new Cinfo();
    public static CinfoJpaController controlCinfo = new CinfoJpaController();
    public static Comprobantes comprobantes = new Comprobantes();
    public static Comprobantes comprobantesnoreembolsados = new Comprobantes();
    public static Comprobantes comprobantespendientes = new Comprobantes();
    public static ComprobantesJpaController controlComprobantes = new ComprobantesJpaController();
    public static Contratos contratos = new Contratos();
    public static ContratosJpaController controlContratos = new ContratosJpaController();
    public static Cubs cubs = new Cubs();
    public static CubsJpaController controlCubs = new CubsJpaController();
    public static CubsPK cubsPK = new CubsPK();
    public static Cuentainterna cuentainterna = new Cuentainterna();
    public static CuentainternaJpaController controlCuentainterna = new CuentainternaJpaController();
    public static Cuentas cuentas = new Cuentas();
    public static CuentasJpaController controlCuentas = new CuentasJpaController();
    public static Cuentas cuentasPendientes = new Cuentas();
    public static Cumplidoscomprobantes cumplidoscomprobantes = new Cumplidoscomprobantes();
    public static CumplidoscomprobantesJpaController controlCumplidoscomprobantes = new CumplidoscomprobantesJpaController();
    public static CumplidoscomprobantesPK cumplidoscomprobantesPK = new CumplidoscomprobantesPK();
    public static Facturascomprobantes facturascomprobantes = new Facturascomprobantes();
    public static FacturascomprobantesJpaController controlFacturascomprobantes = new FacturascomprobantesJpaController();
    public static FacturascomprobantesPK facturascomprobantesPK = new FacturascomprobantesPK();
    public static Formadepagocontratos formadepagocontratos = new Formadepagocontratos();
    public static FormadepagocontratosJpaController controlFormadepagocontratos = new FormadepagocontratosJpaController();
    public static FormadepagocontratosPK formadepagocontratosPK = new FormadepagocontratosPK();
    public static Modificaciones modificaciones = new Modificaciones();
    public static ModificacionesJpaController controlModificaciones = new ModificacionesJpaController();
    public static ModificacionesPK modificacionesPK = new ModificacionesPK();
    public static Observacionescontratos observacionescontratos = new Observacionescontratos();
    public static ObservacionescontratosJpaController controlObservacionescontratos = new ObservacionescontratosJpaController();
    public static ObservacionescontratosPK observacionescontratosPK = new ObservacionescontratosPK();
    public static Observacionescuentas observacionescuentas = new Observacionescuentas();
    public static ObservacionescuentasJpaController controlObservacionescuentas = new ObservacionescuentasJpaController();
    public static ObservacionescuentasPK observacionescuentasPK = new ObservacionescuentasPK();
    public static Planestrategico planestrategico = new Planestrategico();
    public static PlanestrategicoJpaController controlPlanestrategico = new PlanestrategicoJpaController();
    public static Planestrategicocontratos planestrategicocontratos = new Planestrategicocontratos();
    public static PlanestrategicocontratosJpaController controlPlanestrategicocontratos = new PlanestrategicocontratosJpaController();
    public static Polizas polizas = new Polizas();
    public static PolizasJpaController controlPolizas = new PolizasJpaController();
    public static PolizasPK polizasPK = new PolizasPK();
    public static Resoluciones resoluciones = new Resoluciones();
    public static ResolucionesJpaController controlResoluciones = new ResolucionesJpaController();
    public static ResolucionesPK resolucionesPK = new ResolucionesPK();
    public static Solicitudesoferta solicitudesoferta = new Solicitudesoferta();
    public static SolicitudesofertaJpaController controlSolicitudesoferta = new SolicitudesofertaJpaController();
    public static Soportescomprobantes soportescomprobantes = new Soportescomprobantes();
    public static SoportescomprobantesJpaController controlSoportescomprobantes = new SoportescomprobantesJpaController();
    public static SoportescomprobantesPK soportescomprobantesPK = new SoportescomprobantesPK();
    public static Soportescontratos soportescontratos = new Soportescontratos();
    public static SoportescontratosJpaController controlSoportescontratos = new SoportescontratosJpaController();
    public static SoportescontratosPK soportescontratosPK = new SoportescontratosPK();
    public static Soportescuentas soportescuentas = new Soportescuentas();
    public static SoportescuentasJpaController controlSoportescuentas = new SoportescuentasJpaController();
    public static SoportescuentasPK soportescuentasPK = new SoportescuentasPK();
    public static Soportesresoluciones soportesresoluciones = new Soportesresoluciones();
    public static SoportesresolucionesJpaController controlSoportesresoluciones = new SoportesresolucionesJpaController();
    public static SoportesresolucionesPK soportesresolucionesPK = new SoportesresolucionesPK();
    public static Subgrupo subgrupo = new Subgrupo();
    public static SubgrupoJpaController controlSubgrupo = new SubgrupoJpaController();
    public static Terceros terceros = new Terceros();
    public static TercerosJpaController controlTerceros = new TercerosJpaController();
    public static Tercerosresoluciones tercerosresoluciones = new Tercerosresoluciones();
    public static TercerosresolucionesJpaController controlTercerosresoluciones = new TercerosresolucionesJpaController();
    public static UtilidadesJpaController controlUtilidades = new UtilidadesJpaController();
    public static ClaseEscribir escribir = new ClaseEscribir();
    public static ClaseLeer leer = new ClaseLeer();
    public static boolean[][] estados = new boolean[][]{
        //Cre...Inse...Cons...Mod...Elim
        {false, true, false, false, false},//Crear
        {true, false, true, false, false},//Insertar
        {false, false, false, true, true},//Consultar
        {true, false, true, false, false},//Modificar
        {true, false, true, false, false}//Eliminar
    };
    public static String parametro;
    public static String valor;
    public static String perfil;
    public static String dependencia;
    public static String errorValidacion;
    public static String servidor;
    public static boolean cargando;
    public static Color boton = new Color(255, 205, 70);
    public static Color campo = new Color(255, 255, 204);
    public static Color titulo = new Color(255, 170, 20);
    public static Color automatico = new Color(55, 93, 129);
    public static Color busqueda = new Color(255, 204, 204);
    public static Color gris = new Color(240, 240, 240);
    public static Color blanco = new Color(255, 255, 255);
    public static Color negro = new Color(0, 0, 0);
    public static Color rojo = new Color(255, 3, 26);
    public static Color verde = new Color(165, 240, 89);
    /**
     * *****************************************************************
     */
//    public static int idTercerosresolucion;//Guarda el id retornado de la inserción en tercerosresolucion
    /**
     * *****************************************************************
     */
}
