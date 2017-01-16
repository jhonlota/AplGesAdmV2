package entidades;

import clases.ClaseBaseDatos;
import clases.ClaseGeneral;
import clases.ClaseInformacion;
import clases.ClaseMensaje;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

public class TercerosresolucionesJpaController {

    private ClaseBaseDatos datos = new ClaseBaseDatos();
    private ClaseInformacion informacion = new ClaseInformacion();

    public TercerosresolucionesJpaController() {
    }

    public void create(Tercerosresoluciones tercerosresoluciones) {
        try {
            datos.update("INSERT INTO " + tercerosresoluciones.tabla + " VALUES ("// IMPOTANTE
//            Se utiliza query, debido a que se debe retornar el id con el que se hace la insercion, para utilizarla en soportesresolucion
//            datos.query("INSERT INTO " + tercerosresoluciones.tabla + " VALUES ("
                    //                    + tercerosresoluciones.getId() + ", "
                    + tercerosresoluciones.getAno() + ", "
                    + tercerosresoluciones.getFkresolucion() + ", "
                    + "'" + tercerosresoluciones.getFktercero() + "', "
                    + tercerosresoluciones.getValor() + ", "
                    + "'" + tercerosresoluciones.getDestino() + "', "
                    + "'" + tercerosresoluciones.getObjetivo() + "', "
                    + "'" + tercerosresoluciones.getSoporte() + "', "
                    + "'" + tercerosresoluciones.getTarifa() + "', "
                    + tercerosresoluciones.getSalario() + ", "
                    + tercerosresoluciones.getDiario() + ", "
                    + "'" + tercerosresoluciones.getFkcomprobante() + "', "
                    + "'" + tercerosresoluciones.getFkcuenta() + "')  RETURNING id");

//            while (ClaseBaseDatos.resultado.next()) {
//                ClaseGeneral.idTercerosresolucion = ClaseBaseDatos.resultado.getInt("ID");
//            }

            if (!datos.isError) {
                ClaseMensaje.informacionGuardarBD("Articulos - Resolucion");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorGuardarBD();
        } finally {
        }
    }

    public void edit(Tercerosresoluciones tercerosresoluciones, Tercerosresoluciones id) {
        try {
            datos.update("UPDATE TERCEROSRESOLUCION SET "
                    //                    + "ID = " + tercerosresoluciones.getId() + ", "
                    + "ANO = " + tercerosresoluciones.getAno() + ", "
                    + "FKRESOLUCION = " + tercerosresoluciones.getFkresolucion() + ", "
                    + "FKTERCERO = '" + tercerosresoluciones.getFktercero() + "', "
                    + "VALOR = " + tercerosresoluciones.getValor() + ", "
                    + "DESTINO = '" + tercerosresoluciones.getDestino() + "', "
                    + "OBJETIVO = '" + tercerosresoluciones.getObjetivo() + "', "
                    + "SOPORTE = '" + tercerosresoluciones.getSoporte() + "', "
                    + "TARIFA = '" + tercerosresoluciones.getTarifa() + "', "
                    + "SALARIO = " + tercerosresoluciones.getSalario() + ", "
                    + "DIARIO = " + tercerosresoluciones.getDiario() + ", "
                    + "FKCOMPROBANTE = '" + tercerosresoluciones.getFkcomprobante()+ "', "
                    + "FKCUENTA = '" + tercerosresoluciones.getFkcuenta() + "' "
                    + "WHERE "
                    + "ID = " + id.getId() + " "
                    + "AND ANO = " + id.getAno());
            if (!datos.isError) {
                ClaseMensaje.informacionActualizarBD("Articulos - Resolucion");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorActualizarBD();
        } finally {
        }
    }
    
    public void editFktercero(String fktercero, String id) {
        try {
            datos.update("UPDATE TERCEROSRESOLUCION SET "
                    + "FKTERCERO = '" + fktercero + "' "
                    + "WHERE "
                    + "FKTERCERO LIKE '" + id + " - %'");

        } catch (Exception ex) {
            ClaseMensaje.errorActualizarBD();
        } finally {
        }
    }

    public void destroy(Tercerosresoluciones id) {
        try {
            datos.update("DELETE FROM TERCEROSRESOLUCION "
                    + "WHERE "
                    + "ID = " + id.getId() + " "
                    + "AND ANO = " + id.getAno());
            if (!datos.isError) {
                ClaseMensaje.informacionEliminarBD("Articulos - Resolucion");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorEliminarBD();
        } finally {
        }
    }
    
    public void destroyFkresolucionAno(Resoluciones id) {
        try {
            datos.update("DELETE FROM TERCEROSRESOLUCION "
                    + "WHERE "
                    + "FKRESOLUCION = " + id.getResolucionPK().getId() + " AND "
                    + "ANO = " + id.getResolucionPK().getAno());
            if (!datos.isError) {
                ClaseMensaje.informacionEliminarBD("Articulos - Resolucion");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorEliminarBD();
        } finally {
        }
    }

    public List<Tercerosresoluciones> findAllInTercerosresolucionesBy() {
        List<Tercerosresoluciones> listTercerosresoluciones = new ArrayList<Tercerosresoluciones>();
        Tercerosresoluciones tercerosresoluciones = new Tercerosresoluciones();
        try {
            datos.query("SELECT * FROM TERCEROSRESOLUCION "
                    + "WHERE "
                    + ClaseGeneral.parametro + " LIKE '%" + ClaseGeneral.valor + "%'");//ORDER BY
            while (ClaseBaseDatos.resultado.next()) {
                tercerosresoluciones = new Tercerosresoluciones();
                tercerosresoluciones.setId(ClaseBaseDatos.resultado.getInt("ID"));
                tercerosresoluciones.setAno(ClaseBaseDatos.resultado.getInt("ANO"));
                tercerosresoluciones.setFkresolucion(ClaseBaseDatos.resultado.getInt("FKRESOLUCION"));
                tercerosresoluciones.setFktercero(ClaseBaseDatos.resultado.getString("FKTERCERO"));
                tercerosresoluciones.setValor(BigDecimal.valueOf(Long.parseLong("" + ClaseBaseDatos.resultado.getBigDecimal("VALOR"))));
                tercerosresoluciones.setDestino(ClaseBaseDatos.resultado.getString("DESTINO"));
                tercerosresoluciones.setObjetivo(ClaseBaseDatos.resultado.getString("OBJETIVO"));
                tercerosresoluciones.setSoporte(ClaseBaseDatos.resultado.getString("SOPORTE"));
                tercerosresoluciones.setTarifa(ClaseBaseDatos.resultado.getString("TARIFA"));
                tercerosresoluciones.setSalario(BigDecimal.valueOf(Long.parseLong("" + ClaseBaseDatos.resultado.getBigDecimal("SALARIO"))));
                tercerosresoluciones.setDiario(ClaseBaseDatos.resultado.getDouble("DIARIO"));
                tercerosresoluciones.setFkcomprobante(ClaseBaseDatos.resultado.getString("FKCOMPROBANTE"));
                tercerosresoluciones.setFkcuenta(ClaseBaseDatos.resultado.getString("FKCUENTA"));
                listTercerosresoluciones.add(tercerosresoluciones);
            }
            return listTercerosresoluciones;
        } catch (SQLException ex) {
            ClaseMensaje.errorFind(this.toString(), ex.toString());
            return null;
        }
    }

    public List<Tercerosresoluciones> findAllInTercerosresolucionesByFkresolucionAno(int fkresolucion, int ano) {
        List<Tercerosresoluciones> listTercerosresoluciones = new ArrayList<Tercerosresoluciones>();
        Tercerosresoluciones tercerosresoluciones = new Tercerosresoluciones();
        try {
            datos.query("SELECT * FROM TERCEROSRESOLUCION "
                    + "WHERE "
                    + "fkresolucion = " + fkresolucion + " "
                    + "AND ano = " + ano + "");//ORDER BY
            while (ClaseBaseDatos.resultado.next()) {
                tercerosresoluciones = new Tercerosresoluciones();
                tercerosresoluciones.setId(ClaseBaseDatos.resultado.getInt("ID"));
                tercerosresoluciones.setAno(ClaseBaseDatos.resultado.getInt("ANO"));
                tercerosresoluciones.setFkresolucion(ClaseBaseDatos.resultado.getInt("FKRESOLUCION"));
                tercerosresoluciones.setFktercero(ClaseBaseDatos.resultado.getString("FKTERCERO"));
                tercerosresoluciones.setValor(BigDecimal.valueOf(Long.parseLong("" + ClaseBaseDatos.resultado.getBigDecimal("VALOR"))));
                tercerosresoluciones.setDestino(ClaseBaseDatos.resultado.getString("DESTINO"));
                tercerosresoluciones.setObjetivo(ClaseBaseDatos.resultado.getString("OBJETIVO"));
                tercerosresoluciones.setSoporte(ClaseBaseDatos.resultado.getString("SOPORTE"));
                tercerosresoluciones.setTarifa(ClaseBaseDatos.resultado.getString("TARIFA"));
                tercerosresoluciones.setSalario(BigDecimal.valueOf(Long.parseLong("" + ClaseBaseDatos.resultado.getBigDecimal("SALARIO"))));
                tercerosresoluciones.setDiario(ClaseBaseDatos.resultado.getDouble("DIARIO"));
                tercerosresoluciones.setFkcomprobante(ClaseBaseDatos.resultado.getString("FKCOMPROBANTE"));
                tercerosresoluciones.setFkcuenta(ClaseBaseDatos.resultado.getString("FKCUENTA"));
                listTercerosresoluciones.add(tercerosresoluciones);
            }
            return listTercerosresoluciones;
        } catch (SQLException ex) {
            ClaseMensaje.errorFind(this.toString(), ex.toString());
            return null;
        }
    }

//    public int findFkresolucionInTercerosresolucionesBySoporte(String soporte) {
//        int fkresolucion = 0;
//        
//        try {
//            datos.query("SELECT * FROM TERCEROSRESOLUCION "
//                    + "WHERE "
//                    + "soporte = '" + soporte + "'");//ORDER BY
//            while (ClaseBaseDatos.resultado.next()) {
//                fkresolucion = ClaseBaseDatos.resultado.getInt("FKRESOLUCION");
//            }
//            return fkresolucion;
//        } catch (SQLException ex) {
//            ClaseMensaje.errorFind(this.toString(), ex.toString());
//            return fkresolucion;
//        }
//    }
    
    public int findFkresolucionInTercerosresolucionesByFkcomprobanteAno(String fkcomprobante, int ano) {
        int fkresolucion = 0;
        
        try {
            datos.query("SELECT * FROM TERCEROSRESOLUCION "
                    + "WHERE "
                    + "fkcomprobante = '" + fkcomprobante + "' "
                    + "AND ano = " + ano + "");
            while (ClaseBaseDatos.resultado.next()) {
                fkresolucion = ClaseBaseDatos.resultado.getInt("FKRESOLUCION");
            }
            return fkresolucion;
        } catch (SQLException ex) {
            ClaseMensaje.errorFind(this.toString(), ex.toString());
            return fkresolucion;
        }
    }

    public double CALCLiquidacionviaticosresoluciontercero(String tarifa, int fkresolucion, int ano, String fktercero) {
        double valor = 0;

        try {
            datos.query("SELECT f_liquidacionviaticosresoluciontercero("
                    + "'" + tarifa + "', "
                    + fkresolucion + ", "
                    + ano + ", "
                    + "'" + fktercero.substring(0, fktercero.indexOf(" - ")) + "') FROM TERCEROSRESOLUCION");
            while (ClaseBaseDatos.resultado.next()) {
                valor = ClaseBaseDatos.resultado.getDouble("f_liquidacionviaticosresoluciontercero");
            }
            return valor;
        } catch (SQLException ex) {
            ClaseMensaje.errorFind(this.toString(), ex.toString());
            return 0;
        }
    }

    public DefaultComboBoxModel COMBOIdNombreInTercerosresolucionesBy() {
        DefaultComboBoxModel<String> modeloCombo = new DefaultComboBoxModel<String>();
        try {
            modeloCombo.addElement("Seleccione - ");
            datos.query("SELECT DISTINCT(ID), FKRESOLUCION FROM TERCEROSRESOLUCION");// ORDER BY id
            while (ClaseBaseDatos.resultado.next()) {
                modeloCombo.addElement(ClaseBaseDatos.resultado.getInt("ID") + " - " + ClaseBaseDatos.resultado.getInt("FKRESOLUCION"));
            }
            return modeloCombo;
        } catch (SQLException ex) {
            ClaseMensaje.errorFind(this.toString(), ex.toString());
            return modeloCombo;
        }
    }
}
