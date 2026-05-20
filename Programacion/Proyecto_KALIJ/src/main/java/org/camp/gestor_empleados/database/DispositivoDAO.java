package org.camp.gestor_empleados.database;

import org.camp.gestor_empleados.model.Dispositivo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DispositivoDAO {

    // CREATE
    public boolean insertar(Dispositivo d) {

        String sql = "INSERT INTO dispositivo " +
                "(mac, ip, modelo, sistema_operativo, id_dispo) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

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

        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, mac);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    Dispositivo d = new Dispositivo();

                    d.setMac(rs.getString("mac"));
                    d.setIp(rs.getString("ip"));
                    d.setModelo(rs.getString("modelo"));
                    d.setSistemaOperativo(rs.getString("sistema_operativo"));
                    d.setIdDispo(rs.getString("id_dispo"));

                    return d;
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

        try (Connection con = ConexionBD.conectar();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {

                Dispositivo d = new Dispositivo();

                d.setMac(rs.getString("mac"));
                d.setIp(rs.getString("ip"));
                d.setModelo(rs.getString("modelo"));
                d.setSistemaOperativo(rs.getString("sistema_operativo"));
                d.setIdDispo(rs.getString("id_dispo"));

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

        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

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

        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, mac);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}