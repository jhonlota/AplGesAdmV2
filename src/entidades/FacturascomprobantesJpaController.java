/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import clases.ClaseBaseDatos;
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
public class FacturascomprobantesJpaController {

    private ClaseBaseDatos datos = new ClaseBaseDatos();

    public FacturascomprobantesJpaController() {
    }

    public void create(Facturascomprobantes facturascomprobantes) {
        try {
            datos.update("INSERT INTO " + facturascomprobantes.tabla + " VALUES ("
                    + facturascomprobantes.getFacturascomprobantesPK().getFkcomprobante() + ", "
                    + "'" + facturascomprobantes.getFacturascomprobantesPK().getNumero() + "', "
                    + facturascomprobantes.getValor() + ", "
                    + facturascomprobantes.getFacturascomprobantesPK().getAno() + ", "
                    + "'" + facturascomprobantes.getFecha() + "')");
            if (!datos.isError) {
                ClaseMensaje.informacionGuardarBD("Factura");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorGuardarBD();
        } finally {
        }
    }

    public void edit(Facturascomprobantes facturascomprobantes, Facturascomprobantes id) {
        try {
            datos.update("UPDATE FACTURASCOMPROBANTES SET "
                    + "VALOR = " + facturascomprobantes.getValor() + ", "
                    + "FECHA = '" + facturascomprobantes.getFecha() + "' "
                    + "WHERE "
                    + "FKCOMPROBANTE = " + id.getFacturascomprobantesPK().getFkcomprobante() + " AND "
                    + "NUMERO = '" + id.getFacturascomprobantesPK().getNumero() + "' AND "
                    + "ANO = " + id.getFacturascomprobantesPK().getAno());
            if (!datos.isError) {
                ClaseMensaje.informacionActualizarBD("Factura");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorActualizarBD();
        } finally {
        }
    }

    public void destroy(FacturascomprobantesPK id) {
        try {
            datos.update("DELETE FROM FACTURASCOMPROBANTES "
                    + "WHERE "
                    + "FKCOMPROBANTE = " + id.getFkcomprobante() + " AND "
                    + "NUMERO = '" + id.getNumero() + "' AND "
                    + "ANO = " + id.getAno());
            if (!datos.isError) {
                ClaseMensaje.informacionEliminarBD("Factura");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorEliminarBD();
        } finally {
        }
    }

    public void destroyFkcomprobanteAno(Comprobantes id) {
        try {
            datos.update("DELETE FROM FACTURASCOMPROBANTES "
                    + "WHERE "
                    + "FKCOMPROBANTE = " + id.getId() + " AND "
                    + "ANO = " + id.getAno());
            if (!datos.isError) {
                ClaseMensaje.informacionEliminarBD("Factura");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorEliminarBD();
        } finally {
        }
    }

    public List<Facturascomprobantes> findAllInFacturascomprobantesByFkcomprobante(int fkcomprobante, int ano) {
        List<Facturascomprobantes> listFacturascomprobantes = new ArrayList<Facturascomprobantes>();
        Facturascomprobantes facturascomprobantes;
        FacturascomprobantesPK facturascomprobantesPK;

        try {
            datos.query("SELECT * FROM FACTURASCOMPROBANTES WHERE FKCOMPROBANTE = " + fkcomprobante + " AND ANO = " + ano + " ORDER BY NUMERO");
            while (ClaseBaseDatos.resultado.next()) {
                facturascomprobantes = new Facturascomprobantes();
                facturascomprobantesPK = new FacturascomprobantesPK();
                facturascomprobantesPK.setFkcomprobante(ClaseBaseDatos.resultado.getInt("FKCOMPROBANTE"));
                facturascomprobantesPK.setNumero(ClaseBaseDatos.resultado.getString("NUMERO"));
                facturascomprobantesPK.setAno(ClaseBaseDatos.resultado.getInt("ANO"));
                facturascomprobantes.setFacturascomprobantesPK(facturascomprobantesPK);
                facturascomprobantes.setValor(BigDecimal.valueOf(Long.parseLong("" + ClaseBaseDatos.resultado.getBigDecimal("VALOR"))));
                facturascomprobantes.setFecha(ClaseBaseDatos.resultado.getDate("FECHA"));

                listFacturascomprobantes.add(facturascomprobantes);
            }
            return listFacturascomprobantes;
        } catch (SQLException ex) {
            ClaseMensaje.errorFind(this.toString(), ex.toString());
            return null;
        }
    }
    
    public String findNumeroFechaValorInFacturascomprobantesByFkcomprobante(int fkcomprobante, int ano) {
        String texto = new String();

        try {
            datos.query("SELECT * FROM FACTURASCOMPROBANTES WHERE FKCOMPROBANTE = " + fkcomprobante + " AND ANO = " + ano + " ORDER BY NUMERO");
            while (ClaseBaseDatos.resultado.next()) {
                texto += "<li>" + ClaseBaseDatos.resultado.getString("NUMERO");
                texto += ",  (" + ClaseBaseDatos.resultado.getDate("FECHA") + ") : ";
                texto += " $ " + ClaseInformacion.formatoDecimal.format(ClaseBaseDatos.resultado.getBigDecimal("VALOR"));
                texto += "</li>";
            }
            return texto;
        } catch (SQLException ex) {
            ClaseMensaje.errorFind(this.toString(), ex.toString());
            return texto;
        }
    }
}
