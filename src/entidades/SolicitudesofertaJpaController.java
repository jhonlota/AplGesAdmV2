/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
 * @author andres
 */
public class SolicitudesofertaJpaController {
    
    
    private ClaseBaseDatos datos = new ClaseBaseDatos();

    public SolicitudesofertaJpaController() {
    }
    
    public void create(Solicitudesoferta solicitudesoferta) {
        try {
            datos.update("INSERT INTO " + solicitudesoferta.tabla + " VALUES ("
                    //+ solicitudesoferta.getId() + ", "
                    + "'" + ClaseInformacion.ConvertirFecha(solicitudesoferta.getFechaelaboracion()) + "', "
                    + "'" + ClaseInformacion.ConvertirHora(solicitudesoferta.getHoraelaboracion()) + "', "
                    + "'" + solicitudesoferta.getFktercero()+ "', "
                    + "'" + solicitudesoferta.getFktercerofuncionario() + "', "
                    + "'" + solicitudesoferta.getNumerocertificado()+ "', "
                    + solicitudesoferta.getValorcertificado()+ ", "
                    + "'"+ ClaseInformacion.ConvertirFecha(solicitudesoferta.getFechaentrega())+"',"
                    + "'" + solicitudesoferta.getInformacionservicio()+ "', "
                    + solicitudesoferta.getAno() + ", "
                    + "'" + solicitudesoferta.getSecopnumeroproceso()+ "', "
                    + "'" + solicitudesoferta.getSecopnumeroconstancia()+ "', "
                    + "'" + ClaseInformacion.ConvertirFecha(solicitudesoferta.getSecopfechapublicacion())+ "')");
            if (!datos.isError) {
                try {
                    datos.query("SELECT * FROM SOLICITUDESOFERTA WHERE "
                            + "FECHAELABORACION = '" + ClaseInformacion.ConvertirFecha(solicitudesoferta.getFechaelaboracion()) + "' AND "
                            + "HORAELABORACION = '" + ClaseInformacion.ConvertirHora(solicitudesoferta.getHoraelaboracion()) + "' AND "
                            + "FKTERCERO = '" + solicitudesoferta.getFktercero()+ "' AND "
                            + "FKTERCEROFUNCIONARIO = '" + solicitudesoferta.getFktercerofuncionario() + "' AND "
                            + "NUMEROCERTIFICADO = " + solicitudesoferta.getNumerocertificado()+ " AND "
                            + "FECHAENTREGA = '" + ClaseInformacion.ConvertirFecha(solicitudesoferta.getFechaentrega()) + "' AND "
                            + "ANO = " + solicitudesoferta.getAno() + " ORDER BY ID DESC");
                    
                    while (ClaseBaseDatos.resultado.next()) {
                        solicitudesoferta = new Solicitudesoferta();
                        solicitudesoferta.setId(ClaseBaseDatos.resultado.getInt("ID"));
                        ClaseMensaje.informacionGuardarBD("Solicitud de Oferta (" + solicitudesoferta.getId() + ")");
                        break;
                    }
                } catch (SQLException ex) {
                    ClaseMensaje.errorGuardarBD();
                }
            }
        } catch (Exception ex) {
            ClaseMensaje.errorGuardarBD();
        } finally {
        }
    }
    
    public void edit(Solicitudesoferta solicitudesoferta, Solicitudesoferta id) {
        try {
            datos.update("UPDATE SOLICITUDESOFERTA SET "
                    + "FECHAELABORACION = '" + ClaseInformacion.ConvertirFecha(solicitudesoferta.getFechaelaboracion()) + "', "
                    + "HORAELABORACION = '" + ClaseInformacion.ConvertirHora(solicitudesoferta.getHoraelaboracion()) + "', "
                    + "FKTERCERO = '" + solicitudesoferta.getFktercero()+ "', "
                    + "FKTERCEROFUNCIONARIO = '" + solicitudesoferta.getFktercerofuncionario()+ "', "
                    + "NUMEROCERTIFICADO = '" + solicitudesoferta.getNumerocertificado()+ "', "
                    + "VALORCERTIFICADO = '" + solicitudesoferta.getValorcertificado() + "', "
                    + "FECHAENTREGA = '" + solicitudesoferta.getFechaentrega() + "', "
                    + "INFORMACIONSERVICIO = '" + solicitudesoferta.getInformacionservicio()+ "', "
                    + "SECOPNUMEROPROCESO = '" + solicitudesoferta.getSecopnumeroproceso()+ "', "
                    + "SECOPNUMEROCONSTANCIA = '" + solicitudesoferta.getSecopnumeroconstancia()+ "', "
                    + "SECOPFECHAPUBLICACION = '" + ClaseInformacion.ConvertirFecha(solicitudesoferta.getSecopfechapublicacion())+ "' "
                    + "WHERE "
                    + "ID = " + id.getId() + " "
                    + "AND ANO = " + id.getAno());
            if (!datos.isError) {
                ClaseMensaje.informacionActualizarBD("Solicitud de Oferta (" + id.getId() + ")");
            }
        } catch (Exception ex) {
            System.out.println("Exepcion = "+ex);
            System.out.println("solicitudesoferta.getFechaelaboracion()"+solicitudesoferta.getFechaelaboracion());
            System.out.println("id.getId()"+id.getId());
            ClaseMensaje.errorActualizarBD();
        } finally {
        }
    }

    public void editFktercero(String fktercero, String id) {
        try {
            datos.update("UPDATE SOLICITUDESOFERTA SET "
                    + "FKTERCERO = '" + fktercero + "' "
                    + "WHERE "
                    + "FKTERCERO LIKE '" + id + " - %'");
        } catch (Exception ex) {
            ClaseMensaje.errorActualizarBD();
        } finally {
        }

        try {
            datos.update("UPDATE SOLICITUDESOFERTA SET "
                    + "FKTERCEROFUNCIONARIO = '" + fktercero + "' "
                    + "WHERE "
                    + "FKTERCEROFUNCIONARIO LIKE '" + id + " - %'");
        } catch (Exception ex) {
            ClaseMensaje.errorActualizarBD();
        } finally {
        }
    }
    
    public void editFechaaplicacion() {//EN ESTE CASO SE PUEDE IMPLEMENTAR EDIT FECHA ENTREGA EN CASO DE QUE SE REQUIERA MODIFICAR LA FECHA DE ENTRAGA
        
    }
    
    public void destroy(Solicitudesoferta id) {
        try {
            datos.update("DELETE FROM SOLICITUDESOFERTA "
                    + "WHERE "
                    + "ID = " + id.getId() + " "
                    + "AND ANO = " + id.getAno());
            if (!datos.isError) {
                ClaseMensaje.informacionEliminarBD("Solicitud de Oferta (" + id + ")");
            }
        } catch (Exception ex) {
            ClaseMensaje.errorEliminarBD();
        } finally {
        }
    }

    public boolean verify(Solicitudesoferta solicitudesoferta, String estado) {
        try {
            ClaseGeneral.errorValidacion = "";
            if (ClaseInformacion.ValidarSeleccione(solicitudesoferta.getFktercero(), "CÉDULA DEL PROVEEDOR")
                    && ClaseInformacion.ValidarSeleccione(solicitudesoferta.getFktercerofuncionario(), "CEDULA DE QUIEN SOLICITA")
                    && (ClaseGeneral.perfil.equals("root") ? 
                        true 
                        : (estado.equals("create") ? 
                            ClaseInformacion.ValidarCondicion(ClaseInformacion.calcularDiasEntreFechas(ClaseGeneral.controlUtilidades.fechaServidor(), solicitudesoferta.getFechaelaboracion()) >= 0 && ClaseInformacion.calcularDiasEntreFechas(ClaseGeneral.controlUtilidades.fechaServidor(), solicitudesoferta.getFechaelaboracion()) <= 8, "ERROR EN LA FECHA DE ELABORACION")
                            : true)
                    )) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            return false;
        } finally {
        }
    }
        
    public List<Solicitudesoferta> findAllInSolicitudesofertaByORDERBYAno(int ano) {
        List<Solicitudesoferta> listSolicitudesoferta = new ArrayList<Solicitudesoferta>();
        Solicitudesoferta solicitudesoferta;

        try {
            if (ClaseGeneral.perfil.equals("usuario")) {
                if (ClaseGeneral.parametro.equals("CAST(id AS TEXT)")) {
                    datos.query("SELECT * "
                            + "FROM (SELECT *, ROW_NUMBER() OVER(ORDER BY SOLICITUDESOFERTA.ID D"
                            + "ESC, SOLICITUDESOFERTA.ANO DESC) AS FILA "
                            + "FROM SOLICITUDESOFERTA "
                            + "WHERE " + ClaseGeneral.parametro + " LIKE '" + ClaseGeneral.valor + "' "
                            + "AND ANO = " + ano + " "
                            + "AND FKTERCEROFUNCIONARIO IN ("
                            + "SELECT ID || ' - ' || NOMBRE "
                            + "FROM TERCEROS "
                            + "WHERE DEPENDENCIA = '" + ClaseGeneral.dependencia + "')"
                            + ") AS TABLA "
                            + "WHERE FILA BETWEEN 1 AND 1000");
                } else {
                    datos.query("SELECT * "
                            + "FROM (SELECT *, ROW_NUMBER() OVER(ORDER BY SOLICITUDESOFERTA.ID DESC, SOLICITUDESOFERTA.ANO DESC) AS FILA "
                            + "FROM SOLICITUDESOFERTA "
                            + "WHERE " + ClaseGeneral.parametro + " LIKE '%" + ClaseGeneral.valor + "%' "
                            + "AND ANO = " + ano + " "
                            + "AND FKTERCEROFUNCIONARIO IN ("
                            + "SELECT ID || ' - ' || NOMBRE "
                            + "FROM TERCEROS "
                            + "WHERE DEPENDENCIA = '" + ClaseGeneral.dependencia + "')"
                            + ") AS TABLA "
                            + "WHERE FILA BETWEEN 1 AND 1000");
                }
            } else {
                if (ClaseGeneral.parametro.equals("CAST(id AS TEXT)")) {
                    datos.query("SELECT * "
                            + "FROM (SELECT *, ROW_NUMBER() OVER(ORDER BY SOLICITUDESOFERTA.ID DESC, SOLICITUDESOFERTA.ANO DESC) AS FILA "
                            + "FROM SOLICITUDESOFERTA "
                            + "WHERE " + ClaseGeneral.parametro + " LIKE '" + ClaseGeneral.valor + "' "
                            + "AND ANO = " + ano + ""
                            + ") AS TABLA "
                            + "WHERE FILA BETWEEN 1 AND 1000");
                } else {
                    datos.query("SELECT * "
                            + "FROM (SELECT *, ROW_NUMBER() OVER(ORDER BY SOLICITUDESOFERTA.ID DESC, SOLICITUDESOFERTA.ANO DESC) AS FILA "
                            + "FROM SOLICITUDESOFERTA "
                            + "WHERE " + ClaseGeneral.parametro + " LIKE '%" + ClaseGeneral.valor + "%' "
                            + "AND ANO = " + ano + ""
                            + ") AS TABLA "
                            + "WHERE FILA BETWEEN 1 AND 1000");
                }
            }
            while (ClaseBaseDatos.resultado.next()) {
                solicitudesoferta = new Solicitudesoferta();
                solicitudesoferta.setId(ClaseBaseDatos.resultado.getInt("ID"));
                solicitudesoferta.setFechaelaboracion(ClaseBaseDatos.resultado.getDate("FECHAELABORACION"));
                solicitudesoferta.setHoraelaboracion(ClaseBaseDatos.resultado.getTime("HORAELABORACION"));
                solicitudesoferta.setFktercero(ClaseBaseDatos.resultado.getString("FKTERCERO"));
                solicitudesoferta.setFktercerofuncionario(ClaseBaseDatos.resultado.getString("FKTERCEROFUNCIONARIO"));
                solicitudesoferta.setNumerocertificado(ClaseBaseDatos.resultado.getInt("NUMEROCERTIFICADO"));
                solicitudesoferta.setValorcertificado(BigDecimal.valueOf(Long.parseLong("" + ClaseBaseDatos.resultado.getBigDecimal("VALORCERTIFICADO"))));
                solicitudesoferta.setFechaentrega(ClaseBaseDatos.resultado.getDate("FECHAENTREGA"));
                solicitudesoferta.setInformacionservicio(ClaseBaseDatos.resultado.getString("INFORMACIONSERVICIO"));
                solicitudesoferta.setAno(ClaseBaseDatos.resultado.getInt("ANO"));
                solicitudesoferta.setSecopnumeroproceso(ClaseBaseDatos.resultado.getString("SECOPNUMEROPROCESO"));
                solicitudesoferta.setSecopnumeroconstancia(ClaseBaseDatos.resultado.getString("SECOPNUMEROCONSTANCIA"));
                solicitudesoferta.setSecopfechapublicacion(ClaseBaseDatos.resultado.getDate("SECOPFECHAPUBLICACION"));

                listSolicitudesoferta.add(solicitudesoferta);
            }
            return listSolicitudesoferta;
        } catch (SQLException ex) {
            ClaseMensaje.errorFind(this.toString(), ex.toString());
            return null;
        }
    }

    public List<Solicitudesoferta> findAllInSolicitudesofertaAndBienessolicitudofertaBy() {
        List<Solicitudesoferta> listSolicitudesoferta = new ArrayList<Solicitudesoferta>();
        Solicitudesoferta solicitudesoferta;

        try {
            if (ClaseGeneral.perfil.equals("usuario")) {                
                if (ClaseGeneral.parametro.equals("CAST(id AS TEXT)")) {
                    datos.query("SELECT DISTINCT(TABLA.ID), FECHAELABORACION, HORAELABORACION, FKTERCERO, FKTERCEROFUNCIONARIO, NUMEROCERTIFICADO, VALORCERTIFICADO, FECHAENTREGA, INFORMACIONSERVICIO, ANO "
                            + "FROM (SELECT SOLICITUDESOFERTA.*, ROW_NUMBER() OVER(ORDER BY SOLICITUDESOFERTA.ID DESC, SOLICITUDESOFERTA.ANO DESC) AS FILA "
                            + "FROM SOLICITUDESOFERTA LEFT JOIN BIENESSOLICITUDESOFERTA ON SOLICITUDESOFERTA.ID = BIENESSOLICITUDESOFERTA.FKSOLICITUDOFERTA "
                            + "WHERE " + ClaseGeneral.parametro + " LIKE '" + ClaseGeneral.valor + "' "
                            + "AND FKTERCEROFUNCIONARIO IN ("
                            + "SELECT ID || ' - ' || NOMBRE "
                            + "FROM TERCEROS "
                            + "WHERE DEPENDENCIA = '" + ClaseGeneral.dependencia + "')"
                            + ") AS TABLA "
                            + "WHERE FILA BETWEEN 1 AND 1000");
                } else {
                    datos.query("SELECT DISTINCT(TABLA.ID), FECHAELABORACION, HORAELABORACION, FKTERCERO, FKTERCEROFUNCIONARIO, NUMEROCERTIFICADO, VALORCERTIFICADO, FECHAENTREGA, INFORMACIONSERVICIO, ANO "
                            + "FROM (SELECT SOLICITUDESOFERTA.*, ROW_NUMBER() OVER(ORDER BY SOLICITUDESOFERTA.ID DESC, SOLICITUDESOFERTA.ANO DESC) AS FILA "
                            + "FROM SOLICITUDESOFERTA LEFT JOIN BIENESSOLICITUDESOFERTA ON SOLICITUDESOFERTA.ID = BIENESSOLICITUDESOFERTA.FKSOLICITUDOFERTA "
                            + "WHERE " + ClaseGeneral.parametro + " LIKE '%" + ClaseGeneral.valor + "%' "
                            + "AND FKTERCEROFUNCIONARIO IN ("
                            + "SELECT ID || ' - ' || NOMBRE "
                            + "FROM TERCEROS "
                            + "WHERE DEPENDENCIA = '" + ClaseGeneral.dependencia + "')"
                            + ") AS TABLA "
                            + "WHERE FILA BETWEEN 1 AND 1000");
                }
            } else {
                if (ClaseGeneral.parametro.equals("CAST(id AS TEXT)")) {
                    datos.query("SELECT DISTINCT(TABLA.ID), FECHAELABORACION, HORAELABORACION, FKTERCERO, FKTERCEROFUNCIONARIO, NUMEROCERTIFICADO, VALORCERTIFICADO, FECHAENTREGA, INFORMACIONSERVICIO, ANO "
                            + "FROM (SELECT SOLICITUDESOFERTA.*, ROW_NUMBER() OVER(ORDER BY SOLICITUDESOFERTA.ID DESC, SOLICITUDESOFERTA.ANO DESC) AS FILA "
                            + "FROM SOLICITUDESOFERTA LEFT JOIN BIENESSOLICITUDESOFERTA ON SOLICITUDESOFERTA.ID = BIENESSOLICITUDESOFERTA.FKSOLICITUDOFERTA "
                            + "WHERE " + ClaseGeneral.parametro + " LIKE '" + ClaseGeneral.valor + "' "
                            + ") AS TABLA "
                            + "WHERE FILA BETWEEN 1 AND 1000");
                } else {
                    datos.query("SELECT DISTINCT(TABLA.ID), FECHAELABORACION, HORAELABORACION, FKTERCERO, FKTERCEROFUNCIONARIO, NUMEROCERTIFICADO, VALORCERTIFICADO, FECHAENTREGA, INFORMACIONSERVICIO, ANO "
                            + "FROM (SELECT SOLICITUDESOFERTA.*, ROW_NUMBER() OVER(ORDER BY SOLICITUDESOFERTA.ID DESC, SOLICITUDESOFERTA.ANO DESC) AS FILA "
                            + "FROM SOLICITUDESOFERTA LEFT JOIN BIENESSOLICITUDESOFERTA ON SOLICITUDESOFERTA.ID = BIENESSOLICITUDESOFERTA.FKSOLICITUDOFERTA "
                            + "WHERE " + ClaseGeneral.parametro + " LIKE '%" + ClaseGeneral.valor + "%' "
                            + ") AS TABLA "
                            + "WHERE FILA BETWEEN 1 AND 1000");
                }
            }
            while (ClaseBaseDatos.resultado.next()) {
                solicitudesoferta = new Solicitudesoferta();
                solicitudesoferta.setId(ClaseBaseDatos.resultado.getInt("ID"));
                solicitudesoferta.setFechaelaboracion(ClaseBaseDatos.resultado.getDate("FECHAELABORACION"));
                solicitudesoferta.setHoraelaboracion(ClaseBaseDatos.resultado.getTime("HORAELABORACION"));
                solicitudesoferta.setFktercero(ClaseBaseDatos.resultado.getString("FKTERCERO"));
                solicitudesoferta.setFktercerofuncionario(ClaseBaseDatos.resultado.getString("FKTERCEROFUNCIONARIO"));
                solicitudesoferta.setNumerocertificado(ClaseBaseDatos.resultado.getInt("NUMEROCERTIFICADO"));
                solicitudesoferta.setValorcertificado(BigDecimal.valueOf(Long.parseLong("" + ClaseBaseDatos.resultado.getBigDecimal("VALORCERTIFICADO"))));
                solicitudesoferta.setFechaentrega(ClaseBaseDatos.resultado.getDate("FECHAENTREGA"));
                solicitudesoferta.setInformacionservicio(ClaseBaseDatos.resultado.getString("INFORMACIONSERVICIO"));
                solicitudesoferta.setAno(ClaseBaseDatos.resultado.getInt("ANO"));
                solicitudesoferta.setSecopnumeroproceso(ClaseBaseDatos.resultado.getString("SECOPNUMEROPROCESO"));
                solicitudesoferta.setSecopnumeroconstancia(ClaseBaseDatos.resultado.getString("SECOPNUMEROCONSTANCIA"));
                solicitudesoferta.setSecopfechapublicacion(ClaseBaseDatos.resultado.getDate("SECOPFECHAPUBLICACION"));

                listSolicitudesoferta.add(solicitudesoferta);
            }
            return listSolicitudesoferta;
        } catch (SQLException ex) {
            ClaseMensaje.errorFind(this.toString(), ex.toString());
            return null;
        }
    }

    public List<Solicitudesoferta> findAllInSolicitudesofertaByAno(int ano) {
        List<Solicitudesoferta> listSolicitudesoferta = new ArrayList<Solicitudesoferta>();
        Solicitudesoferta solicitudesoferta;

        try {
            datos.query("SELECT * "
                    + "FROM (SELECT *, ROW_NUMBER() OVER(ORDER BY FECHAELABORACION DESC, ID DESC) AS FILA "
                    + "FROM SOLICITUDESOFERTA "
                    + "WHERE ANO = " + ano + ""
                    + ") AS TABLA "
                    + "WHERE FILA BETWEEN 1 AND 100 "
                    + "ORDER BY ID");
            while (ClaseBaseDatos.resultado.next()) {
                solicitudesoferta = new Solicitudesoferta();
                solicitudesoferta.setId(ClaseBaseDatos.resultado.getInt("ID"));
                solicitudesoferta.setFechaelaboracion(ClaseBaseDatos.resultado.getDate("FECHAELABORACION"));
                solicitudesoferta.setHoraelaboracion(ClaseBaseDatos.resultado.getTime("HORAELABORACION"));
                solicitudesoferta.setFktercero(ClaseBaseDatos.resultado.getString("FKTERCERO"));
                solicitudesoferta.setFktercerofuncionario(ClaseBaseDatos.resultado.getString("FKTERCEROFUNCIONARIO"));
                solicitudesoferta.setNumerocertificado(ClaseBaseDatos.resultado.getInt("NUMEROCERTIFICADO"));
                solicitudesoferta.setValorcertificado(BigDecimal.valueOf(Long.parseLong("" + ClaseBaseDatos.resultado.getBigDecimal("VALORCERTIFICADO"))));
                solicitudesoferta.setFechaentrega(ClaseBaseDatos.resultado.getDate("FECHAENTREGA"));
                solicitudesoferta.setInformacionservicio(ClaseBaseDatos.resultado.getString("INFORMACIONSERVICIO"));
                solicitudesoferta.setAno(ClaseBaseDatos.resultado.getInt("ANO"));
                solicitudesoferta.setSecopnumeroproceso(ClaseBaseDatos.resultado.getString("SECOPNUMEROPROCESO"));
                solicitudesoferta.setSecopnumeroconstancia(ClaseBaseDatos.resultado.getString("SECOPNUMEROCONSTANCIA"));
                solicitudesoferta.setSecopfechapublicacion(ClaseBaseDatos.resultado.getDate("SECOPFECHAPUBLICACION"));

                listSolicitudesoferta.add(solicitudesoferta);
            }
            return listSolicitudesoferta;
        } catch (SQLException ex) {
            ClaseMensaje.errorFind(this.toString(), ex.toString());
            return null;
        }
    }
   
    
    public List<Solicitudesoferta> findAllInSolicitudesofertaByFktercero(String fktercero) {
        List<Solicitudesoferta> listSolicitudesoferta = new ArrayList<Solicitudesoferta>();
        Solicitudesoferta solicitudesoferta;

        try {
            datos.query("SELECT * FROM SOLICITUDESOFERTA "
                    + "WHERE "
                    + "FKTERCERO LIKE '" + fktercero + " - %' ORDER BY FECHAELABORACION DESC, ID DESC");
            while (ClaseBaseDatos.resultado.next()) {
                solicitudesoferta = new Solicitudesoferta();
                solicitudesoferta.setId(ClaseBaseDatos.resultado.getInt("ID"));
                solicitudesoferta.setFechaelaboracion(ClaseBaseDatos.resultado.getDate("FECHAELABORACION"));
                solicitudesoferta.setHoraelaboracion(ClaseBaseDatos.resultado.getTime("HORAELABORACION"));
                solicitudesoferta.setFktercero(ClaseBaseDatos.resultado.getString("FKTERCERO"));
                solicitudesoferta.setFktercerofuncionario(ClaseBaseDatos.resultado.getString("FKTERCEROFUNCIONARIO"));
                solicitudesoferta.setNumerocertificado(ClaseBaseDatos.resultado.getInt("NUMEROCERTIFICADO"));
                solicitudesoferta.setValorcertificado(BigDecimal.valueOf(Long.parseLong("" + ClaseBaseDatos.resultado.getBigDecimal("VALORCERTIFICADO"))));
                solicitudesoferta.setFechaentrega(ClaseBaseDatos.resultado.getDate("FECHAENTREGA"));
                solicitudesoferta.setInformacionservicio(ClaseBaseDatos.resultado.getString("INFORMACIONSERVICIO"));
                solicitudesoferta.setAno(ClaseBaseDatos.resultado.getInt("ANO"));
                solicitudesoferta.setSecopnumeroproceso(ClaseBaseDatos.resultado.getString("SECOPNUMEROPROCESO"));
                solicitudesoferta.setSecopnumeroconstancia(ClaseBaseDatos.resultado.getString("SECOPNUMEROCONSTANCIA"));
                solicitudesoferta.setSecopfechapublicacion(ClaseBaseDatos.resultado.getDate("SECOPFECHAPUBLICACION"));

                listSolicitudesoferta.add(solicitudesoferta);
            }
            return listSolicitudesoferta;
        } catch (SQLException ex) {
            ClaseMensaje.errorFind(this.toString(), ex.toString());
            return null;
        }
    }

}
