package org.camp.gestor_empleados.database;

import org.camp.gestor_empleados.model.Ubicacion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UbicacionDAO {

    public void insertar(Ubicacion u) {

        String sql = "INSERT INTO ubicacion (cod, edificio, planta, departamento, id_dir) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, u.getIdUbi());
            ps.setString(2, u.getEdificio());
            ps.setString(3, u.getPlanta());
            ps.setString(4, u.getDespacho()); // ← antes estaba MAL usado
            ps.setInt(5, u.getIdDir());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Ubicacion obtenerPorId(int cod) {

        String sql = "SELECT cod, edificio, planta, departamento, id_dir FROM ubicacion WHERE cod = ?";

        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, cod);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    Ubicacion u = new Ubicacion();

                    u.setIdUbi(rs.getInt("cod"));
                    u.setEdificio(rs.getString("edificio"));
                    u.setPlanta(rs.getString("planta"));
                    u.setDespacho(rs.getString("departamento"));
                    u.setIdDir(rs.getInt("id_dir"));

                    return u;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Ubicacion> listar() {

        List<Ubicacion> lista = new ArrayList<>();

        String sql = "SELECT cod, edificio, planta, departamento, id_dir FROM ubicacion";

        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Ubicacion u = new Ubicacion();

                u.setIdUbi(rs.getInt("cod"));
                u.setEdificio(rs.getString("edificio"));
                u.setPlanta(rs.getString("planta"));
                u.setDespacho(rs.getString("departamento"));
                u.setIdDir(rs.getInt("id_dir"));

                lista.add(u);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public void actualizar(Ubicacion u) {

        String sql = "UPDATE ubicacion SET edificio=?, planta=?, departamento=?, id_dir=? WHERE cod=?";

        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, u.getEdificio());
            ps.setString(2, u.getPlanta());
            ps.setString(3, u.getDespacho());
            ps.setInt(4, u.getIdDir());
            ps.setInt(5, u.getIdUbi());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminar(int cod) {

        String sql = "DELETE FROM ubicacion WHERE cod = ?";

        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, cod);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}