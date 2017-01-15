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
public class SoportescontratosJpaController {

    private ClaseBaseDatos datos = new ClaseBaseDatos();
    private ClaseInformacion informacion = new ClaseInformacion();

    public SoportescontratosJpaController() {
    }

    public void create(Soportescontratos soportescontratos) {
        try {
            datos.update("INSERT INTO " + soportescontratos.tabla + " VALUES ("
                    + "'" + soportescontratos.getSoportescontratosPK().getFkcontrato() + "', "
                    //+ soportescontratos.getSoportescontratosPK().getId() + ", "
                    + "'" + soportescontratos.getNumero() + "', "
                    + "'" + soportescontratos.getTipo() + "', "
                    + "'" + soportescontratos.getActividad() + "', "
                    + "'" + soportescontratos.getCcostos() + "', "
                    + "'" + soportescontratos.getCinfo() + "', "
                    + "'" + soportescontratos.getCuenta() + "', "
                    + "'" + ClaseInformacion.ConvertirFecha(soportescontratos.getFecha()) + "', "
                    + "'" + soportescontratos.getSubgrupo() + "', "
                    + soportescontratos.getValor() + ")");
            if (!datos.isError) {
                ClaseMensaje.informacionGuardarBD("Soporte");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorGuardarBD();
        } finally {
        }
    }

    public void edit(Soportescontratos soportescontratos, Soportescontratos id) {
        try {
            datos.update("UPDATE SOPORTESCONTRATOS SET "
                    + "NUMERO = '" + soportescontratos.getNumero() + "', "
                    + "TIPO = '" + soportescontratos.getTipo() + "', "
                    + "ACTIVIDAD = '" + soportescontratos.getActividad() + "', "
                    + "CCOSTOS = '" + soportescontratos.getCcostos() + "', "
                    + "CINFO = '" + soportescontratos.getCinfo() + "', "
                    + "CUENTA = '" + soportescontratos.getCuenta() + "', "
                    + "FECHA = '" + ClaseInformacion.ConvertirFecha(soportescontratos.getFecha()) + "', "
                    + "SUBGRUPO = '" + soportescontratos.getSubgrupo() + "', "
                    + "VALOR = " + soportescontratos.getValor() + " "
                    + "WHERE "
                    + "FKCONTRATO = '" + id.getSoportescontratosPK().getFkcontrato() + "' AND "
                    + "ID = " + id.getSoportescontratosPK().getId());
            if (!datos.isError) {
                ClaseMensaje.informacionActualizarBD("Soporte");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorActualizarBD();
        } finally {
        }
    }

    public void editFkcontrato(String fkcontrato, String id) {
        try {
            datos.update("UPDATE SOPORTESCONTRATOS SET "
                    + "FKCONTRATO = '" + fkcontrato + "' "
                    + "WHERE "
                    + "FKCONTRATO = '" + id + "'");
        } catch (Exception ex) {
            ClaseMensaje.errorActualizarBD();
        } finally {
        }
    }

    public void destroy(SoportescontratosPK id) {
        try {
            datos.update("DELETE FROM SOPORTESCONTRATOS "
                    + "WHERE "
                    + "FKCONTRATO = '" + id.getFkcontrato() + "' AND "
                    + "ID = '" + id.getId() + "'");
            if (!datos.isError) {
                ClaseMensaje.informacionEliminarBD("Soporte");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorEliminarBD();
        } finally {
        }
    }

    public void destroyFkcontrato(String id) {
        try {
            datos.update("DELETE FROM SOPORTESCONTRATOS "
                    + "WHERE "
                    + "FKCONTRATO = '" + id + "'");
            if (!datos.isError) {
                ClaseMensaje.informacionEliminarBD("Soporte");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorEliminarBD();
        } finally {
        }
    }

    public boolean verify(Soportescontratos soportescontratos) {
        try {
            ClaseGeneral.errorValidacion = "";
            if (ClaseInformacion.ValidarSeleccione(soportescontratos.getNumero(), "NÚMERO")
                    && ClaseInformacion.ValidarSeleccione(soportescontratos.getTipo(), "TIPO SOPORTE")
                    && ClaseInformacion.ValidarSeleccione(soportescontratos.getCuenta(), "CUENTA")
                    && ClaseInformacion.ValidarSeleccione(soportescontratos.getActividad(), "ACTIVIDAD")
                    && ClaseInformacion.ValidarSeleccione(soportescontratos.getSubgrupo(), "SUBGRUPO")
                    && ClaseInformacion.ValidarSeleccione(soportescontratos.getCcostos(), "C. COSTOS")
                    && ClaseInformacion.ValidarSeleccione(soportescontratos.getCinfo(), "C. INFO")
                    && ClaseInformacion.ValidarSeleccione("" + soportescontratos.getValor(), "VALOR")) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            return false;
        } finally {
        }
    }

    public List<Soportescontratos> findAllInSoportescontratosByFkcontrato(String fkcontrato) {
        List<Soportescontratos> listSoportescontratos = new ArrayList<Soportescontratos>();
        Soportescontratos soportescontratos;
        SoportescontratosPK soportescontratosPK;

        try {
            datos.query("SELECT * FROM SOPORTESCONTRATOS WHERE FKCONTRATO = '" + fkcontrato + "' ORDER BY TIPO");
            while (ClaseBaseDatos.resultado.next()) {
                soportescontratos = new Soportescontratos();
                soportescontratosPK = new SoportescontratosPK();
                soportescontratosPK.setFkcontrato(ClaseBaseDatos.resultado.getString("FKCONTRATO"));
                soportescontratosPK.setId(ClaseBaseDatos.resultado.getInt("ID"));
                soportescontratos.setSoportescontratosPK(soportescontratosPK);
                soportescontratos.setNumero(ClaseBaseDatos.resultado.getString("NUMERO"));
                soportescontratos.setTipo(ClaseBaseDatos.resultado.getString("TIPO"));
                soportescontratos.setActividad(ClaseBaseDatos.resultado.getString("ACTIVIDAD"));
                soportescontratos.setCcostos(ClaseBaseDatos.resultado.getString("CCOSTOS"));
                soportescontratos.setCinfo(ClaseBaseDatos.resultado.getString("CINFO"));
                soportescontratos.setCuenta(ClaseBaseDatos.resultado.getString("CUENTA"));
                soportescontratos.setFecha(ClaseBaseDatos.resultado.getDate("FECHA"));
                soportescontratos.setSubgrupo(ClaseBaseDatos.resultado.getString("SUBGRUPO"));
                soportescontratos.setValor(BigDecimal.valueOf(Long.parseLong("" + ClaseBaseDatos.resultado.getBigDecimal("VALOR"))));

                listSoportescontratos.add(soportescontratos);
            }
            return listSoportescontratos;
        } catch (SQLException ex) {
            ClaseMensaje.errorFind(this.toString(), ex.toString());
            return null;
        }
    }

    public BigDecimal CALCInSoportescontratosByFkcontrato(String fkcontrato) {
        BigDecimal valor = BigDecimal.ZERO;

        try {
            datos.query("SELECT SUM(CASE WHEN TIPO = 'Registro' THEN VALOR ELSE 0 END) AS REGISTRO,\n"
                    + "SUM(CASE WHEN TIPO = 'Ajuste Debito' THEN VALOR ELSE 0 END) AS AJUSTEDEBITO,\n"
                    + "SUM(CASE WHEN TIPO = 'Ajuste Crédito' THEN VALOR ELSE 0 END) AS AJUSTECREDITO\n"
                    + "FROM SOPORTESCONTRATOS WHERE FKCONTRATO = '" + fkcontrato + "'");
            while (ClaseBaseDatos.resultado.next()) {
                valor = (BigDecimal.valueOf(Long.parseLong("" + ClaseBaseDatos.resultado.getBigDecimal("REGISTRO"))
                        + Long.parseLong("" + ClaseBaseDatos.resultado.getBigDecimal("AJUSTEDEBITO"))
                        - Long.parseLong("" + ClaseBaseDatos.resultado.getBigDecimal("AJUSTECREDITO"))));
            }
            return valor;
        } catch (SQLException ex) {
            ClaseMensaje.errorFind(this.toString(), ex.toString());
            return valor;
        }
    }

    public String findTipoInSoportescontratosByFkcontratoRESGITRO(String fkcontrato) {
        String tipo = "";
        Soportescontratos soportescontratos;
        SoportescontratosPK soportescontratosPK;

        try {
            datos.query("SELECT * FROM SOPORTESCONTRATOS WHERE FKCONTRATO = '" + fkcontrato + "' AND TIPO = 'Registro' ORDER BY TIPO");
            while (ClaseBaseDatos.resultado.next()) {
                if (ClaseBaseDatos.resultado.getString("SUBGRUPO").equals("282")
                        || ClaseBaseDatos.resultado.getString("SUBGRUPO").equals("283")) {
                    return "PRESTACION DE SERVICIOS";
                } else if (ClaseBaseDatos.resultado.getString("SUBGRUPO").equals("064")
                        || ClaseBaseDatos.resultado.getString("SUBGRUPO").equals("065")
                        || ClaseBaseDatos.resultado.getString("SUBGRUPO").equals("066")
                        || ClaseBaseDatos.resultado.getString("SUBGRUPO").equals("067")) {
                    tipo = "SERVICIOS";
                } else if (ClaseBaseDatos.resultado.getString("SUBGRUPO").equals("072")
                        || ClaseBaseDatos.resultado.getString("SUBGRUPO").equals("073")
                        || ClaseBaseDatos.resultado.getString("SUBGRUPO").equals("101")) {
                    tipo = "RESOLUCION";
                } else if (ClaseBaseDatos.resultado.getString("SUBGRUPO").equals("000")) {
                    tipo = "CORPORATIVO";
                } else {
                    tipo = "COMPRAS";
                }
            }
            return tipo;
        } catch (SQLException ex) {
            ClaseMensaje.errorFind(this.toString(), ex.toString());
            return "";
        }
    }
}