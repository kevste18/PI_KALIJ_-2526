package org.camp.gestor_empleados.view;

import org.camp.gestor_empleados.database.EmpleadoDAO;
import org.camp.gestor_empleados.database.IncidenciaDAO;
import org.camp.gestor_empleados.model.Empleado;
import org.camp.gestor_empleados.model.Incidencia;

import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class AppGestorEmpleados {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        IncidenciaDAO dao = new IncidenciaDAO();
        System.out.println("Bienvenido a el sistema de la empresa :");
        Empleado empleado = login(teclado);
        String rol = mostrarRol(empleado);
        try {
            ArrayList<Incidencia> gestionadas =
                    dao.getIncidenciasPorResponsable(empleado.getDni());

            ArrayList<Incidencia> creadas =
                    dao.getIncidenciasPorEmpleado(empleado.getDni());

        } catch (SQLException e) {
            System.out.println("Error al obtener incidencias: " + e.getMessage());
        }
        teclado.close();
    }

    public static Empleado login(Scanner t) {

        EmpleadoDAO dao = new EmpleadoDAO();

        System.out.println("=== LOGIN EMPLEADO ===");

        System.out.print("Introduce DNI: ");
        String dni = t.nextLine();

        System.out.print("Introduce contraseña: ");
        String password = t.nextLine();

        EmpleadoDAO.ResultadoLogin resultado =
                EmpleadoDAO.verificarUsuario(dni, password);

        switch (resultado) {

            case USUARIO_NO_EXISTE:
                System.out.println("El usuario no existe");
            return null;

            case PASSWORD_INCORRECTA:
                System.out.println("Contraseña incorrecta");
                return null;

            case LOGIN_CORRECTO:

                System.out.println("\nLogin correcto\n");

                 return  dao.obtenerPorDni(dni);

        }
        return null;
    }
    public static String mostrarRol(Empleado empleado) {
        switch (empleado.getIdRol()) {
            case 1:  return "Administrador";
            case 2:  return "Gestor de incidencias";
            case 3:  return "Empleado";
            default: return "ID Rol no coincidente con ningún rol.";
        }
    }
    private static void mostrarEmpleado(Empleado empleado) {

        System.out.println("=== DATOS DEL EMPLEADO ===");

        System.out.println("DNI: " + empleado.getDni());
        System.out.println("Nombre: " + empleado.getNombre());
        System.out.println("Apellidos: " + empleado.getApellido());
        System.out.println("Fecha contrato: " + empleado.getFechaContrato());
        System.out.println("Salario: " + empleado.getSalario());
        System.out.println("Teletrabajo: " + empleado.getTeletrabajo());
        System.out.println("Teléfono: " + empleado.getTelefono());
        System.out.println("Teléfono trabajo: " + empleado.getTelefonoTrabajo());
        System.out.println("ID Departamento: " + empleado.getIdDepartamento());
        System.out.println("ID Rol: " + empleado.getIdRol());
        System.out.println("Dispositivo asignado: " + empleado.getDispositivoAsignado());
        System.out.println("Num dirige: " + empleado.getNumDirige());
        System.out.println("Num gestiona: " + empleado.getNumGestiona());
        System.out.println("ID Empleado: " + empleado.getIdEmpleado());
    }
}