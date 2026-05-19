package org.camp.gestor_empleados.database;

import org.camp.gestor_empleados.model.Dispositivo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DispositivoDAO {

    private Connection con = ConexionBD.conectar();

    // CREATE
    public boolean insertar(Dispositivo d) {

        String sql = "INSERT INTO dispositivo " +
                "(mac, ip, modelo, sistema_operativo, id_dispo) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, d.getMac());
            ps.setString(2, d.getIp());
            ps.setString(3, d.getModelo());
            ps.setString(4, d.getSistemaOperativo());
            ps.setString(5, d.getIdDispo());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // READ POR MAC
    public Dispositivo obtenerPorMac(String mac) {

        String sql = "SELECT * FROM dispositivo WHERE mac = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, mac);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    return new Dispositivo(
                            rs.getString("mac"),
                            rs.getString("ip"),
                            rs.getString("modelo"),
                            rs.getString("sistema_operativo"),
                            rs.getString("id_dispo")
                    );
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // READ TODOS
    public List<Dispositivo> listar() {

        List<Dispositivo> lista = new ArrayList<>();

        String sql = "SELECT * FROM dispositivo";

        try (Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {

                Dispositivo d = new Dispositivo(
                        rs.getString("mac"),
                        rs.getString("ip"),
                        rs.getString("modelo"),
                        rs.getString("sistema_operativo"),
                        rs.getString("id_dispo")
                );

                lista.add(d);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    // UPDATE
    public boolean actualizar(Dispositivo d) {

        String sql = "UPDATE dispositivo " +
                "SET ip = ?, modelo = ?, sistema_operativo = ?, id_dispo = ? " +
                "WHERE mac = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, d.getIp());
            ps.setString(2, d.getModelo());
            ps.setString(3, d.getSistemaOperativo());
            ps.setString(4, d.getIdDispo());
            ps.setString(5, d.getMac());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // DELETE
    public boolean eliminar(String mac) {

        String sql = "DELETE FROM dispositivo WHERE mac = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, mac);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}