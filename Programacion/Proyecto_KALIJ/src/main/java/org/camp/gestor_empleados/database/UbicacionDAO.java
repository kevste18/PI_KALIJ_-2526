package org.camp.gestor_empleados.database;

import org.camp.gestor_empleados.model.Ubicacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UbicacionDAO {
    private Connection con = ConexionBD.conectar();

    public void insertar(Ubicacion u) {
        String sql = "INSERT INTO ubicacion (cod, edificio, planta, departamento, id_dir) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, u.getIdUbi());
            ps.setString(2, u.getEdificio());
            ps.setString(3, u.getPlanta());
            ps.setString(4, String.valueOf(u.getIdDir()));
            ps.setInt(5, u.getIdDir());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ (uno por ID)
    public Ubicacion obtenerPorId(int cod) {
        String sql = "SELECT cod, edificio, planta, departamento, id_dir FROM ubicacion WHERE cod = ?";        Ubicacion u = null;

        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, cod);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                u = new Ubicacion(
                        rs.getInt("cod"),
                        rs.getString("edificio"),
                        rs.getString("planta"),
                        rs.getString("departamento"),
                        rs.getInt("id_dir")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return u;
    }

    public List<Ubicacion> listar() {
        List<Ubicacion> lista = new ArrayList<>();
        String sql = "SELECT cod, edificio, planta, departamento, id_dir FROM ubicacion";
        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Ubicacion u = new Ubicacion(
                        rs.getInt("cod"),
                        rs.getString("edificio"),
                        rs.getString("planta"),
                        rs.getString("departamento"),
                        rs.getInt("id_dir")
                );
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
            ps.setString(3, String.valueOf(u.getIdDir()));
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
