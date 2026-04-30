package org.camp.gestor_empleados.database;

import org.camp.gestor_empleados.model.Departamento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DepartamentoDAO {
    private Connection con = ConexionBD.conectar();

    public boolean insertar (Departamento departamento){
        String sql = "INSERT INTO departamento (id_dep, nombre, presupuesto, ubicacion) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, departamento.getId_dep());
            ps.setString(2, departamento.getNombre());
            ps.setDouble(3, departamento.getPresupuesto());
            ps.setString(4, String.valueOf(departamento.getIdUbi()));

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;


        } catch (SQLException e) {
            throw new RuntimeException(e);
            return false;
        }
    }


    public ArrayList<Departamento> obtenerTodos() {
        ArrayList<Departamento> lista = new ArrayList<>();
        String sql = "SELECT id_dep, nombre, presupuesto, ubicacion FROM departamento";

        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Departamento d = new Departamento();

                d.setId_dep(rs.getInt("id_dep"));
                d.setNombre(rs.getString("nombre"));
                d.setPresupuesto(rs.getDouble("presupuesto"));
                d.setIdUbi(Integer.parseInt(rs.getString("ubicacion")));

                lista.add(d);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }


    public boolean actualizar(Departamento departamento) {
        String sql = "UPDATE departamento SET nombre = ?, presupuesto = ?, ubicacion = ? WHERE id_dep = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, departamento.getNombre());
            ps.setDouble(2, departamento.getPresupuesto());
            ps.setString(3, String.valueOf(departamento.getIdUbi()));
            ps.setInt(4, departamento.getId_dep());

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }


    }
    public boolean eliminar(int id_dep) {
        String sql = "DELETE FROM departamento WHERE id_dep = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id_dep);

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
