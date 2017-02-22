/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import clases.ClaseBaseDatos;
import clases.ClaseGeneral;
import clases.ClaseMensaje;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jhon Lopez
 */
public class TercerosJpaController {

    private ClaseBaseDatos datos = new ClaseBaseDatos();

    public TercerosJpaController() {
    }

    public void create(Terceros terceros) {
        try {
            datos.update("INSERT INTO " + terceros.tabla + " VALUES ("
                    + "'" + terceros.getId() + "', "
                    + "'" + terceros.getDireccion() + "', "
                    + "'" + terceros.getEmail() + "', "
                    + "'" + terceros.getNombre() + "', "
                    + "'" + terceros.getTelefono() + "', "
                    + "'" + terceros.getTipoid() + "', "
                    + "'" + terceros.getCargo() + "', "
                    + "'" + terceros.getDependencia() + "', "
                    + "'" + terceros.getEdificio() + "', "
                    + "'" + terceros.getNombrebanco() + "', "
                    + "'" + terceros.getNumerocuenta() + "', "
                    + "'" + terceros.getOficina() + "', "
                    + "'" + terceros.getProfesion() + "', "
                    + "'" + terceros.getRegimen() + "', "
                    + "'" + terceros.getTipocuenta() + "', "
                    + "'" + terceros.getPerfil() + "', "
                    + "'" + terceros.getIp() + "', "
                    + "'" + terceros.getSalario() + "', "
                    + "'" + terceros.getIdrepresentante() + "', "
                    + "'" + terceros.getTipoidrepresentante() + "', "
                    + "'" + terceros.getNombrerepresentante()+ "', "
                    + "'" + terceros.getSedebanco()+ "', "
                    + "'" + terceros.getSededependencia() + "')");
            if (!datos.isError) {
                ClaseMensaje.informacionGuardarBD("El Tercero " + terceros.getId());
            }
        } catch (Exception ex) {
            ClaseMensaje.errorGuardarBD();
        } finally {
        }
    }

    public void edit(Terceros terceros, Terceros id) {
        try {
            datos.update("UPDATE TERCEROS SET "
                    + "ID = '" + terceros.getId() + "', "
                    + "DIRECCION = '" + terceros.getDireccion() + "', "
                    + "EMAIL = '" + terceros.getEmail() + "', "
                    + "NOMBRE = '" + terceros.getNombre() + "', "
                    + "TELEFONO = '" + terceros.getTelefono() + "', "
                    + "TIPOID = '" + terceros.getTipoid() + "', "
                    + "CARGO = '" + terceros.getCargo() + "', "
                    + "DEPENDENCIA = '" + terceros.getDependencia() + "', "
                    + "EDIFICIO = '" + terceros.getEdificio() + "', "
                    + "NOMBREBANCO = '" + terceros.getNombrebanco() + "', "
                    + "NUMEROCUENTA = '" + terceros.getNumerocuenta() + "', "
                    + "OFICINA = '" + terceros.getOficina() + "', "
                    + "PROFESION = '" + terceros.getProfesion() + "', "
                    + "REGIMEN = '" + terceros.getRegimen() + "', "
                    + "TIPOCUENTA = '" + terceros.getTipocuenta() + "', "
                    + "PERFIL = '" + terceros.getPerfil() + "', "
                    + "IP = '" + terceros.getIp() + "', "
                    + "SALARIO = " + terceros.getSalario() + ", "
                    + "IDREPRESENTANTE = '" + terceros.getIdrepresentante() + "', "
                    + "TIPOIDREPRESENTANTE = '" + terceros.getTipoidrepresentante() + "', "
                    + "NOMBREREPRESENTANTE = '" + terceros.getNombrerepresentante() + "', "
                    + "SEDEBANCO = '" + terceros.getSedebanco() + "', "
                    + "SEDEDEPENDENCIA = '" + terceros.getSededependencia() + "' "
                    + "WHERE "
                    + "ID = '" + id.getId() + "'");
            if (!datos.isError) {
                ClaseMensaje.informacionActualizarBD("El Tercero " + terceros.getId());
            }
        } catch (Exception ex) {
            ClaseMensaje.errorActualizarBD();
        } finally {
        }
    }

    public void editSalario(String id, BigDecimal salario) {
        try {
            datos.update("UPDATE TERCEROS SET "
                    + "SALARIO = " + salario + " "
                    + "WHERE "
                    + "ID = '" + id.substring(0, id.indexOf(" - ")) + "'");
            if (!datos.isError) {
                ClaseMensaje.informacionActualizarBD("El Tercero " + id.substring(0, id.indexOf(" - ")));
            }
        } catch (Exception ex) {
            ClaseMensaje.errorActualizarBD();
        } finally {
        }
    }
    
    public void editEmail(String id, String email) {
        try {
            datos.update("UPDATE TERCEROS SET "
                    + "EMAIL = '" + email + "' "
                    + "WHERE "
                    + "ID = '" + id.substring(0, id.indexOf(" - ")) + "'");
            if (!datos.isError) {
                ClaseMensaje.informacionActualizarBD("El Tercero " + id.substring(0, id.indexOf(" - ")));
            }
        } catch (Exception ex) {
            ClaseMensaje.errorActualizarBD();
        } finally {
        }
    }

    public void destroy(String id) {
        try {
            datos.update("DELETE FROM TERCEROS "
                    + "WHERE "
                    + "ID = '" + id + "'");
            if (!datos.isError) {
                ClaseMensaje.informacionEliminarBD("El Tercero " + id);
            }
        } catch (Exception ex) {
            ClaseMensaje.errorEliminarBD();
        } finally {
        }
    }

    public List<Terceros> findAllInTercerosByEntities() {
        List<Terceros> listTerceros = new ArrayList<Terceros>();
        Terceros terceros;

        try {
            datos.query("SELECT * FROM TERCEROS ORDER BY ID");
            while (ClaseBaseDatos.resultado.next()) {
                terceros = new Terceros();
                terceros.setId(ClaseBaseDatos.resultado.getString("ID"));
                terceros.setDireccion(ClaseBaseDatos.resultado.getString("DIRECCION"));
                terceros.setEmail(ClaseBaseDatos.resultado.getString("EMAIL"));
                terceros.setNombre(ClaseBaseDatos.resultado.getString("NOMBRE"));
                terceros.setTelefono(ClaseBaseDatos.resultado.getString("TELEFONO"));
                terceros.setTipoid(ClaseBaseDatos.resultado.getString("TIPOID"));
                terceros.setCargo(ClaseBaseDatos.resultado.getString("CARGO"));
                terceros.setDependencia(ClaseBaseDatos.resultado.getString("DEPENDENCIA"));
                terceros.setEdificio(ClaseBaseDatos.resultado.getString("EDIFICIO"));
                terceros.setNombrebanco(ClaseBaseDatos.resultado.getString("NOMBREBANCO"));
                terceros.setNumerocuenta(ClaseBaseDatos.resultado.getString("NUMEROCUENTA"));
                terceros.setOficina(ClaseBaseDatos.resultado.getString("OFICINA"));
                terceros.setProfesion(ClaseBaseDatos.resultado.getString("PROFESION"));
                terceros.setRegimen(ClaseBaseDatos.resultado.getString("REGIMEN"));
                terceros.setTipocuenta(ClaseBaseDatos.resultado.getString("TIPOCUENTA"));
                terceros.setPerfil(ClaseBaseDatos.resultado.getString("PERFIL"));
                terceros.setIp(ClaseBaseDatos.resultado.getString("IP"));
                terceros.setSalario(BigDecimal.valueOf(Long.parseLong("" + ClaseBaseDatos.resultado.getBigDecimal("SALARIO"))));
                terceros.setIdrepresentante(ClaseBaseDatos.resultado.getString("IDREPRESENTANTE"));
                terceros.setTipoidrepresentante(ClaseBaseDatos.resultado.getString("TIPOIDREPRESENTANTE"));
                terceros.setNombrerepresentante(ClaseBaseDatos.resultado.getString("NOMBREREPRESENTANTE"));
                terceros.setSedebanco(ClaseBaseDatos.resultado.getString("SEDEBANCO"));
                terceros.setSededependencia(ClaseBaseDatos.resultado.getString("SEDEDEPENDENCIA"));
                
                listTerceros.add(terceros);
            }
            return listTerceros;
        } catch (SQLException ex) {
            ClaseMensaje.errorFind(this.toString(), ex.toString());
            return null;
        }
    }

    public List<Terceros> findAllInTercerosBy() {
        
        List<Terceros> listTerceros = new ArrayList<Terceros>();
        Terceros terceros;

        try {
            datos.query("SELECT * FROM TERCEROS "
                    + "WHERE "
                    + ClaseGeneral.parametro + " LIKE '%" + ClaseGeneral.valor + "%' "
                    + "ORDER BY ID");
            while (ClaseBaseDatos.resultado.next()) {
                terceros = new Terceros();
                terceros.setId(ClaseBaseDatos.resultado.getString("ID"));
                terceros.setDireccion(ClaseBaseDatos.resultado.getString("DIRECCION"));
                terceros.setEmail(ClaseBaseDatos.resultado.getString("EMAIL"));
                terceros.setNombre(ClaseBaseDatos.resultado.getString("NOMBRE"));
                terceros.setTelefono(ClaseBaseDatos.resultado.getString("TELEFONO"));
                terceros.setTipoid(ClaseBaseDatos.resultado.getString("TIPOID"));
                terceros.setCargo(ClaseBaseDatos.resultado.getString("CARGO"));
                terceros.setDependencia(ClaseBaseDatos.resultado.getString("DEPENDENCIA"));
                terceros.setEdificio(ClaseBaseDatos.resultado.getString("EDIFICIO"));
                terceros.setNombrebanco(ClaseBaseDatos.resultado.getString("NOMBREBANCO"));
                terceros.setNumerocuenta(ClaseBaseDatos.resultado.getString("NUMEROCUENTA"));
                terceros.setOficina(ClaseBaseDatos.resultado.getString("OFICINA"));
                terceros.setProfesion(ClaseBaseDatos.resultado.getString("PROFESION"));
                terceros.setRegimen(ClaseBaseDatos.resultado.getString("REGIMEN"));
                terceros.setTipocuenta(ClaseBaseDatos.resultado.getString("TIPOCUENTA"));
                terceros.setPerfil(ClaseBaseDatos.resultado.getString("PERFIL"));
                terceros.setIp(ClaseBaseDatos.resultado.getString("IP"));
                terceros.setSalario(BigDecimal.valueOf(Long.parseLong("" + ClaseBaseDatos.resultado.getBigDecimal("SALARIO"))));
                terceros.setIdrepresentante(ClaseBaseDatos.resultado.getString("IDREPRESENTANTE"));
                terceros.setTipoidrepresentante(ClaseBaseDatos.resultado.getString("TIPOIDREPRESENTANTE"));
                terceros.setNombrerepresentante(ClaseBaseDatos.resultado.getString("NOMBREREPRESENTANTE"));
                terceros.setSedebanco(ClaseBaseDatos.resultado.getString("SEDEBANCO"));
                terceros.setSededependencia(ClaseBaseDatos.resultado.getString("SEDEDEPENDENCIA"));
                
                listTerceros.add(terceros);
            }
            return listTerceros;
        } catch (SQLException ex) {
            ClaseMensaje.errorFind(this.toString(), ex.toString());
            return null;
        }
    }

//    public DefaultComboBoxModel COMBOIdNombreInTercerosBy() {
//        DefaultComboBoxModel<String> modeloCombo = new DefaultComboBoxModel<String>();
//
//        modeloCombo.addElement("Seleccione - ");
//        try {
//            datos.query("SELECT DISTINCT(ID), NOMBRE FROM TERCEROS ORDER BY ID");
//            while (ClaseBaseDatos.resultado.next()) {
//                modeloCombo.addElement(ClaseBaseDatos.resultado.getString("ID") + " - " + ClaseBaseDatos.resultado.getString("NOMBRE"));
//            }
//            return modeloCombo;
//        } catch (SQLException ex) {
//            ClaseMensaje.errorFind(this.toString(), ex.toString());
//            return modeloCombo;
//        }
//    }

    public String findPersonaInTercerosById(String id) {
        String persona = "";
        try {
            datos.query("SELECT REGIMEN FROM TERCEROS WHERE ID = '" + id.substring(0, id.indexOf(" - ")) + "'");
            while (ClaseBaseDatos.resultado.next()) {
                if (ClaseBaseDatos.resultado.getString("REGIMEN").equals("Régimen Común")) {
                    persona = "PERSONAJURIDICA";
                } else {
                    persona = "PERSONANATURAL";
                }
            }
            return persona;
        } catch (SQLException ex) {
            ClaseMensaje.errorFind(this.toString(), ex.toString());
            return persona;
        }
    }
    
    public String findNombreInTercerosById(String id) {
        String nombre = "";
        try {
            datos.query("SELECT NOMBRE FROM TERCEROS WHERE ID = '" + id + "'");
            while (ClaseBaseDatos.resultado.next()) {
                nombre = ClaseBaseDatos.resultado.getString("NOMBRE");
            }
            return nombre;
        } catch (SQLException ex) {
//            ClaseMensaje.errorFind(this.toString(), ex.toString());
            return nombre;
        }
    }

    public BigDecimal findSalarioInTercerosById(String id) {
        BigDecimal salario = BigDecimal.ZERO;
        try {
            datos.query("SELECT SALARIO FROM TERCEROS WHERE ID = '" + id.substring(0, id.indexOf(" - ")) + "'");
            while (ClaseBaseDatos.resultado.next()) {
                salario = BigDecimal.valueOf(Long.parseLong("" + ClaseBaseDatos.resultado.getBigDecimal("SALARIO")));
            }
            return salario;
        } catch (SQLException ex) {
            ClaseMensaje.errorFind(this.toString(), ex.toString());
            return salario;
        }
    }
    
    public String findEmailInTercerosById(String id) {
        String email = "";
        try {
            datos.query("SELECT EMAIL FROM TERCEROS WHERE ID = '" + id.substring(0, id.indexOf(" - ")) + "'");
            while (ClaseBaseDatos.resultado.next()) {
                email = ClaseBaseDatos.resultado.getString("EMAIL");
            }
            return email;
        } catch (SQLException ex) {
            ClaseMensaje.errorFind(this.toString(), ex.toString());
            return email;
        }
    }

    public double CALCLiquidacionViativosInTercerosBySalarioTarifa(BigDecimal salario, String tarifa) {
        double diario = 0.0;
        try {
            datos.query("SELECT f_liquidacionviaticos(" + salario + ", '" + tarifa + "') AS DIARIO FROM TERCEROS");
            while (ClaseBaseDatos.resultado.next()) {
                diario = ClaseBaseDatos.resultado.getDouble("DIARIO");
            }
            return diario;
        } catch (SQLException ex) {
            ClaseMensaje.errorFind(this.toString(), ex.toString());
            return diario;
        }
    }

}
