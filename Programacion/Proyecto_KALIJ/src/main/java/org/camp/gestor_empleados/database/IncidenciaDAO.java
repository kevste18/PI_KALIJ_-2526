package org.camp.gestor_empleados.database;

import org.camp.gestor_empleados.model.Incidencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class IncidenciaDAO {
    private Connection con = ConexionBD.conectar();
    public void insertar(Incidencia i) {
        String sql = "INSERT INTO incidencias (num_incidencia, estado, dni_empleado, dni_responsable, fecha_alta, fecha_resolucion, dispositivo_afect) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";


        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, i.getNumIncidencia());
            ps.setString(2, i.getEstado());
            ps.setString(3, i.getDniEmpleado());
            ps.setString(4, i.getDniResponsable());
            ps.setDate(5, i.getFechaAlta());
            ps.setDate(6, i.getFechaResolucion());
            ps.setString(7, i.getDispositivoAfect());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public List<Incidencia> listar() {
        List<Incidencia> lista = new ArrayList<>();
        String sql = "SELECT * FROM incidencias";

        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Incidencia i = new Incidencia();
                i.setNumIncidencia(rs.getInt("num_incidencia"));
                i.setEstado(rs.getString("estado"));
                i.setDniEmpleado(rs.getString("dni_empleado"));
                i.setDniResponsable(rs.getString("dni_responsable"));
                i.setFechaAlta(rs.getDate("fecha_alta"));
                i.setFechaResolucion(rs.getDate("fecha_resolucion"));
                i.setDispositivoAfect(rs.getString("dispositivo_afect"));

                lista.add(i);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    public void actualizar(Incidencia i) {
        String sql = "UPDATE incidencias SET estado=?, dni_empleado=?, dni_responsable=?, fecha_alta=?, fecha_resolucion=?, dispositivo_afect=? " +
                "WHERE num_incidencia=?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, i.getEstado());
            ps.setString(2, i.getDniEmpleado());
            ps.setString(3, i.getDniResponsable());
            ps.setDate(4, i.getFechaAlta());
            ps.setDate(5, i.getFechaResolucion());
            ps.setString(6, i.getDispositivoAfect());
            ps.setInt(7, i.getNumIncidencia());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void eliminar(int numIncidencia) {
        String sql = "DELETE FROM incidencias WHERE num_incidencia=?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, numIncidencia);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

