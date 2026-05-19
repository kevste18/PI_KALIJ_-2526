package org.camp.gestor_empleados.database;

import org.camp.gestor_empleados.model.Departamento;
import org.camp.gestor_empleados.model.Empleado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class EmpleadoDAO {
    private Connection con = ConexionBD.conectar();
    public boolean insertarCompleto (Empleado empleado) {
        String sql = "INSERT INTO empleado (dni, nombre, apellidos, fecha_contrato, salario, teletrabajo, tlf, tlf_trabajo, id_dep," +
                " id_rol, dispositivo_asignado, num_dirige, num_gestiona, id_empleado )" +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, empleado.getDni());
            ps.setString(2, empleado.getNombre());
            ps.setString(3, empleado.getApellido());
            ps.setDate(4, java.sql.Date.valueOf(empleado.getFechaContrato())); // LocalDate → Date
            ps.setDouble(5, empleado.getSalario());
            ps.setBoolean(6, empleado.getTeletrabajo());
            ps.setString(7, empleado.getTelefono());
            ps.setString(8, empleado.getTelefonoTrabajo());
            ps.setInt(9, empleado.getIdDepartamento());
            ps.setInt(10, empleado.getIdRol());
            ps.setString(11, empleado.getDispositivoAsignado());
            ps.setInt(12, empleado.getNumDirige());
            ps.setInt(13, empleado.getNumGestiona());
            ps.setInt(14, empleado.getIdEmpleado());

            int filas = ps.executeUpdate();
            return filas > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean insertar(Empleado empleado) {
        String sql = "INSERT INTO empleado (dni, nombre, apellidos, fecha_contrato, salario, id_empleado, id_rol) VALUES (?,?,?,?,?,?,?)";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, empleado.getDni());
            ps.setString(2, empleado.getNombre());
            ps.setString(3, empleado.getApellido());
            ps.setDate(4, java.sql.Date.valueOf(empleado.getFechaContrato())); // si usas LocalDate
            ps.setDouble(5, empleado.getSalario());
            ps.setInt(6, empleado.getIdEmpleado());
            ps.setInt(7, empleado.getIdRol());

            int filas = ps.executeUpdate();
            return filas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public ArrayList<Empleado> obtenerMinimo() {
        ArrayList<Empleado> lista = new ArrayList<>();

        String sql = "SELECT dni, nombre, apellidos, fecha_contrato, salario, id_empleado, id_rol FROM empleado";

        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Empleado e = new Empleado();

                e.setDni(rs.getString("dni"));
                e.setNombre(rs.getString("nombre"));
                e.setApellido(rs.getString("apellidos"));
                e.setFechaContrato(rs.getDate("fecha_contrato").toLocalDate()); // si usas LocalDate
                e.setSalario(rs.getDouble("salario"));
                e.setIdEmpleado(rs.getInt("id_empleado"));
                e.setIdRol(rs.getInt("id_rol"));

                lista.add(e);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public ArrayList<Empleado> obtenerTodos() {
        ArrayList<Empleado> lista = new ArrayList<>();

        String sql = "SELECT dni, nombre, apellidos, fecha_contrato, salario, teletrabajo, tlf, tlf_trabajo, id_dep, " +
                "id_rol, dispositivo_asignado, num_dirige, num_gestiona, id_empleado FROM empleado";

        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Empleado e = new Empleado();

                e.setDni(rs.getString("dni"));
                e.setNombre(rs.getString("nombre"));
                e.setApellido(rs.getString("apellidos"));

                Date fecha = rs.getDate("fecha_contrato");
                if (fecha != null) {
                    e.setFechaContrato(((java.sql.Date) fecha).toLocalDate());
                }

                e.setSalario(rs.getDouble("salario"));
                e.setTeletrabajo(rs.getBoolean("teletrabajo"));
                e.setTelefono(rs.getString("tlf"));
                e.setTelefonoTrabajo(rs.getString("tlf_trabajo"));
                e.setIdDepartamento(rs.getInt("id_dep"));
                e.setIdRol(rs.getInt("id_rol"));
                e.setDispositivoAsignado(rs.getString("dispositivo_asignado"));
                e.setNumDirige(rs.getInt("num_dirige"));
                e.setNumGestiona(rs.getInt("num_gestiona"));
                e.setIdEmpleado(rs.getInt("id_empleado"));

                lista.add(e);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

<<<<<<< Updated upstream
=======
    public enum ResultadoLogin {
        USUARIO_NO_EXISTE,
        PASSWORD_INCORRECTA,
        LOGIN_CORRECTO
    }

    public static ResultadoLogin verificarUsuario(String dni, String password) {

        if (dni == null || dni.isEmpty() || password == null || password.isEmpty()) {
            throw new IllegalArgumentException("DNI y contraseña obligatorios");
        }

        String sql = "SELECT contrasena FROM departamento WHERE dni = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, dni);
            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                // No existe el DNI
                return ResultadoLogin.USUARIO_NO_EXISTE;
            }

            String passwordBD = rs.getString("password");

            if (!passwordBD.equals(password)) {
                // Existe el usuario pero contraseña incorrecta
                return ResultadoLogin.PASSWORD_INCORRECTA;
            }

            return ResultadoLogin.LOGIN_CORRECTO;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ResultadoLogin.USUARIO_NO_EXISTE;
    }

    public Empleado obtenerPorDni(String dni) {

        String sql = "SELECT dni, nombre, apellidos, fecha_contrato, salario, teletrabajo, " +
                "tlf, tlf_trabajo, id_dep, id_rol, dispositivo_asignado, " +
                "num_dirige, num_gestiona, id_empleado " +
                "FROM empleado WHERE dni = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, dni);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    Empleado e = new Empleado();

                    e.setDni(rs.getString("dni"));
                    e.setNombre(rs.getString("nombre"));
                    e.setApellido(rs.getString("apellidos"));

                    Date fecha = rs.getDate("fecha_contrato");
                    if (fecha != null) {
                        e.setFechaContrato(((java.sql.Date) fecha).toLocalDate());
                    }

                    e.setSalario(rs.getDouble("salario"));
                    e.setTeletrabajo(rs.getBoolean("teletrabajo"));
                    e.setTelefono(rs.getString("tlf"));
                    e.setTelefonoTrabajo(rs.getString("tlf_trabajo"));
                    e.setIdDepartamento(rs.getInt("id_dep"));
                    e.setIdRol(rs.getInt("id_rol"));
                    e.setDispositivoAsignado(rs.getString("dispositivo_asignado"));
                    e.setNumDirige(rs.getInt("num_dirige"));
                    e.setNumGestiona(rs.getInt("num_gestiona"));
                    e.setIdEmpleado(rs.getInt("id_empleado"));

                    return e;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

>>>>>>> Stashed changes
    public boolean actualizar(Departamento departamento) {
        String sql = "UPDATE departamento SET nombre = ?, presupuesto = ?, ubicacion = ? WHERE id_dep = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, departamento.getNombre());
            ps.setDouble(2, departamento.getPresupuesto());
            ps.setInt(3, departamento.getIdUbi());
            ps.setInt(4, departamento.getId_dep());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminar(int id_dep) {
        String sql = "DELETE FROM departamento WHERE id_dep = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id_dep);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
