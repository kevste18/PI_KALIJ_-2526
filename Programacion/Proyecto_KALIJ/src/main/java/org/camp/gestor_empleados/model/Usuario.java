package org.camp.gestor_empleados.model;

import org.camp.gestor_empleados.database.EmpleadoDAO;

public class Usuario {
    private String dni;
    private String password;

    public Usuario(String dni,String password){
        setPassword(password);
        setDni(dni);
    }

   public void conectarUser() {
       EmpleadoDAO.ResultadoLogin resultado = EmpleadoDAO.verificarUsuario(getDni(), getPassword());
       switch (resultado) {
           case USUARIO_NO_EXISTE:
               System.out.println("El usuario no existe");
               break;
           case PASSWORD_INCORRECTA:
               System.out.println("Contraseña incorrecta");
               break;
           case LOGIN_CORRECTO:
               System.out.println("Login correcto");
               break;
       }
   }

    public String getDni() {return dni;}

    public void setDni(String dni) {
        if (dni == null || !dni.matches("\\d{8}[A-Za-z]")) {
            throw new IllegalArgumentException("El DNI debe tener 8 números y 1 letra");
        }
        this.dni = dni;
    }

    public String getPassword() {return password;}

    public void setPassword(String password) {
        if (password == null || password.length() < 5) {
            throw new IllegalArgumentException("La contraseña debe tener al menos 5 caracteres");
        }
        this.password = password;
    }
}
