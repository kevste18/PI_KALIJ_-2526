package org.camp.gestor_empleados.database;

import org.camp.gestor_empleados.model.Ubicacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DireccionDAO {

    private Connection con = ConexionBD.conectar();

    public boolean insertar(Ubicacion direccion) {

        String sql = "INSERT INTO direccion " +
                "(id_dir, calle, despacho, cp, numero) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, direccion.getIdDir());
            ps.setString(2, direccion.getCalle());
            ps.setString(3, direccion.getDespacho());
            ps.setInt(4, direccion.getCodigoPostal());
            ps.setInt(5, direccion.getNumeroCalle());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<Ubicacion> obtenerTodos() {

        ArrayList<Ubicacion> lista = new ArrayList<>();

        String sql = "SELECT id_dir, calle, despacho, cp, numero FROM direccion";

        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Ubicacion d = new Ubicacion();

                d.setIdDir(rs.getInt("id_dir"));
                d.setCalle(rs.getString("calle"));
                d.setDespacho(rs.getString("despacho"));
                d.setCodigoPostal(rs.getInt("cp"));
                d.setNumeroCalle(rs.getInt("numero"));

                lista.add(d);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public boolean actualizar(Ubicacion direccion) {

        String sql = "UPDATE direccion " +
                "SET calle = ?, despacho = ?, cp = ?, numero = ? " +
                "WHERE id_dir = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, direccion.getCalle());
            ps.setString(2, direccion.getDespacho());
            ps.setInt(3, direccion.getCodigoPostal());
            ps.setInt(4, direccion.getNumeroCalle());
            ps.setInt(5, direccion.getIdDir());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminar(int idDir) {

        String sql = "DELETE FROM direccion WHERE id_dir = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idDir);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Ubicacion obtenerPorId(int id) {

        String sql = "SELECT id_dir, calle, despacho, cp, numero " +
                "FROM direccion WHERE id_dir = ?";

        Ubicacion d = null;

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    d = new Ubicacion();

                    d.setIdDir(rs.getInt("id_dir"));
                    d.setCalle(rs.getString("calle"));
                    d.setDespacho(rs.getString("despacho"));
                    d.setCodigoPostal(rs.getInt("cp"));
                    d.setNumeroCalle(rs.getInt("numero"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return d;
    }
}