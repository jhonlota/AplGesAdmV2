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
public class CubsJpaController {

    private ClaseBaseDatos datos = new ClaseBaseDatos();

    public CubsJpaController() {
    }

    public void create(Cubs cubs) {
        try {
            datos.update("INSERT INTO " + cubs.tabla + " VALUES ("
                    + "'" + cubs.getCubsPK().getDescripcion() + "', "
                    + "'" + cubs.getCubsPK().getFkcontrato() + "', "
                    + cubs.getCantidad() + ", "
                    + "'" + cubs.getCertificado() + "', "
                    + "'" + cubs.getCodigo() + "', "
                    + cubs.getValor() + ", "
                    + cubs.getValorsiniva() + ", "
                    + cubs.getValortotal() + ", "
                    + cubs.getValortotalsiniva() + ")");
            if (!datos.isError) {
                ClaseMensaje.informacionGuardarBD("Articulo");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorGuardarBD();
        } finally {
        }
    }

    public void edit(Cubs cubs, Cubs cubsId) {
        try {
            datos.update("UPDATE CUBS SET "
                    + "CANTIDAD = " + cubs.getCantidad() + ", "
                    + "CERTIFICADO = '" + cubs.getCertificado()+ "', "
                    + "CODIGO = '" + cubs.getCodigo() + "', "
                    + "VALOR = " + cubs.getValor() + ", "
                    + "VALORSINIVA = " + cubs.getValorsiniva() + ", "
                    + "VALORTOTAL = " + cubs.getValortotal() + ", "
                    + "VALORTOTALSINIVA = " + cubs.getValortotalsiniva() + " "
                    + "WHERE "
                    + "DESCRIPCION = '" + cubsId.getCubsPK().getDescripcion()+ "' AND "
                    + "FKCONTRATO = '" + cubsId.getCubsPK().getFkcontrato() + "'");
            if (!datos.isError) {
                ClaseMensaje.informacionActualizarBD("Articulo");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorActualizarBD();
        } finally {
        }
    }

    public void editFkcontrato(String fkcontrato, String id) {
        try {
            datos.update("UPDATE CUBS SET "
                    + "FKCONTRATO = '" + fkcontrato + "' "
                    + "WHERE "
                    + "FKCONTRATO = '" + id + "'");
        } catch (Exception ex) {
            ClaseMensaje.errorActualizarBD();
        } finally {
        }
    }

    public void destroy(CubsPK id) {
        try {
            datos.update("DELETE FROM CUBS "
                    + "WHERE "
                    + "DESCRIPCION = '" + id.getDescripcion()+ "' AND "
                    + "FKCONTRATO = '" + id.getFkcontrato() + "'");
            if (!datos.isError) {
                ClaseMensaje.informacionEliminarBD("Articulo");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorEliminarBD();
        } finally {
        }
    }

    public void destroyFkcontrato(String id) {
        try {
            datos.update("DELETE FROM CUBS "
                    + "WHERE "
                    + "FKCONTRATO = '" + id + "'");
            if (!datos.isError) {
                ClaseMensaje.informacionEliminarBD("Articulo");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorEliminarBD();
        } finally {
        }
    }
    
    public boolean verify(Cubs cubs) {
        try {
            ClaseGeneral.errorValidacion = "";
            if (ClaseInformacion.ValidarSeleccione(cubs.getCubsPK().getDescripcion(), "DESCRIPCION ELEMENTO")
                    && ClaseInformacion.ValidarSeleccione("" + cubs.getCantidad(), "CANTIDAD")
                    && ClaseInformacion.ValidarSeleccione(cubs.getCodigo(), "CÓDIGO CUBS ELEMENTO")
                    && ClaseInformacion.ValidarSeleccione("" + cubs.getValor(), "VALOR UNITARIO CON IVA")
                    && ClaseInformacion.ValidarSeleccione("" + cubs.getValorsiniva(), "VALOR UNITARIO SIN IVA")
                    && ClaseInformacion.ValidarSeleccione("" + cubs.getValortotal(), "VALOR TOTAL CON IVA")
                    && ClaseInformacion.ValidarSeleccione("" + cubs.getValortotalsiniva(), "VALOR TOTAL SIN IVA")) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            return false;
        } finally {
        }
    }

    public List<Cubs> findAllInCubsByFkcontrato(String fkcontrato) {
        List<Cubs> listCubs = new ArrayList<Cubs>();
        Cubs cubs;
        CubsPK cubsPK;

        try {
            datos.query("SELECT * FROM CUBS WHERE FKCONTRATO = '" + fkcontrato + "' ORDER BY DESCRIPCION");
            while (ClaseBaseDatos.resultado.next()) {
                cubs = new Cubs();
                cubsPK = new CubsPK();
                cubsPK.setDescripcion(ClaseBaseDatos.resultado.getString("DESCRIPCION"));
                cubsPK.setFkcontrato(ClaseBaseDatos.resultado.getString("FKCONTRATO"));
                cubs.setCubsPK(cubsPK);
                cubs.setCantidad(BigDecimal.valueOf(Long.parseLong("" + ClaseBaseDatos.resultado.getBigDecimal("CANTIDAD"))));
                cubs.setCertificado(ClaseBaseDatos.resultado.getString("CERTIFICADO"));
                cubs.setCodigo(ClaseBaseDatos.resultado.getString("CODIGO"));
                cubs.setValor(BigDecimal.valueOf(Long.parseLong("" + ClaseBaseDatos.resultado.getBigDecimal("VALOR"))));
                cubs.setValorsiniva(BigDecimal.valueOf(Long.parseLong("" + ClaseBaseDatos.resultado.getBigDecimal("VALORSINIVA"))));
                cubs.setValortotal(BigDecimal.valueOf(Long.parseLong("" + ClaseBaseDatos.resultado.getBigDecimal("VALORTOTAL"))));
                cubs.setValortotalsiniva(BigDecimal.valueOf(Long.parseLong("" + ClaseBaseDatos.resultado.getBigDecimal("VALORTOTALSINIVA"))));

                listCubs.add(cubs);
            }
            return listCubs;
        } catch (SQLException ex) {
            ClaseMensaje.errorFind(this.toString(), ex.toString());
            return null;
        }
    }
    
    public int findCALCInCubsByFkcontrato(String fkcontrato) {
        int count = 0;

        try {
            datos.query("SELECT COUNT(DESCRIPCION) AS COUNT FROM CUBS WHERE FKCONTRATO = '" + fkcontrato + "' GROUP BY DESCRIPCION");
            while (ClaseBaseDatos.resultado.next()) {
                count = ClaseBaseDatos.resultado.getInt("COUNT");
                
            }
            return count;
        } catch (SQLException ex) {
            ClaseMensaje.errorFind(this.toString(), ex.toString());
            return 0;
        }
    }
}
