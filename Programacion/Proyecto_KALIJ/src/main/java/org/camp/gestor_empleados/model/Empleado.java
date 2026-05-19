package org.camp.gestor_empleados.model;

import java.time.LocalDate;

public class Empleado {

    private int idEmpleado;
    private String nombre;
    private String apellido;
    private String dni;
    private String telefono;
    public String telefonoTrabajo;
    private LocalDate fechaContrato;
    private double salario;
    private boolean teletrabajo;
    private int idDepartamento;
    private int idRol;
    private String dispositivoAsignado;
    private int numDirige;
    private int numGestiona;

    // Constructor
    // Vacío
    public Empleado(){};

    // Completo
    public Empleado(
            int idEmpleado,
            String nombre,
            String apellido,
            String dni,
            String telefono,
            String telefonoTrabajo,
            LocalDate fechaContrato,
            double salario,
            boolean teletrabajo,
            int idDepartamento,
            int idRol,
            String dispositivoAsignado,
            int numDirige,
            int numGestiona){
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.telefono = telefono;
        this.telefonoTrabajo = telefonoTrabajo;
        this.fechaContrato = fechaContrato;
        this.salario = salario;
        this.teletrabajo = teletrabajo;
        this.idDepartamento = idDepartamento;
        this.idRol = idRol;
        this.dispositivoAsignado = dispositivoAsignado;
        this.numDirige = numDirige;
        this.numGestiona = numGestiona;
    }

    // Getters y setters
    public int getIdEmpleado() {return this.idEmpleado;}
    public void setIdEmpleado(int idEmpleado) {this.idEmpleado = idEmpleado;}
    public String getNombre() {return this.nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public String getApellido() {return this.apellido;}
    public void setApellido(String apellido) {this.apellido = apellido;}
    public String getDni() {return this.dni;}
    public void setDni(String dni) {this.dni = dni;}
    public String getTelefono() {return this.telefono;}
    public void setTelefono(String telefono) {this.telefono = telefono;}
    public String getTelefonoTrabajo() {return this.telefonoTrabajo;}
    public void setTelefonoTrabajo(String telefonoTrabajo) {this.telefonoTrabajo = telefonoTrabajo;}
    public LocalDate getFechaContrato() {return this.fechaContrato;}
    public void setFechaContrato(LocalDate fechaContrato) {this.fechaContrato = fechaContrato;}
    public double getSalario() {return this.salario;}
    public void setSalario(double salario) {this.salario = salario;}
    public boolean getTeletrabajo() {return this.teletrabajo;}
    public void setTeletrabajo(boolean teletrabajo) {this.teletrabajo = teletrabajo;}
    public int getIdDepartamento() {return this.idDepartamento;}
    public void setIdDepartamento(int idDepartamento) {this.idDepartamento = idDepartamento;}
    public int getIdRol() {return this.idRol;}
    public void setIdRol(int idRol) {this.idRol = idRol;}
    public String getDispositivoAsignado() {return this.dispositivoAsignado;}
    public void setDispositivoAsignado(String dispositivoAsignado){this.dispositivoAsignado = dispositivoAsignado;}
    public int getNumDirige() {return this.numDirige;}
    public void setNumDirige(int numDirige) {this.numDirige = numDirige;}
    public int getNumGestiona() {return this.numGestiona;}
    public void setNumGestiona(int numGestiona) {this.numGestiona = numGestiona;}
}
