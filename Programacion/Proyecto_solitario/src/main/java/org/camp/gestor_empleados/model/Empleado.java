package org.camp.gestor_empleados.model;

import java.util.Date;

public class Empleado {

    private String nombre;
    private String apellido;
    private String dni;
    private String telefono;
    private String email;
    private Date fechaContrato;
    private double salario;
    private boolean teletrabajo;

    // Getters y setters

    public String getNombre() {return this.nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public String getApellido() {return this.apellido;}
    public void setApellido(String apellido) {this.apellido = apellido;}
    public String getDni() {return this.dni;}
    public void setDni(String dni) {this.dni = dni;}
    public String getTelefono() {return this.telefono;}
    public void setTelefono(String telefono) {this.telefono = telefono;}
    public String getEmail() {return this.email;}
    public void setEmail(String email) {this.email = email;}
    public Date getFechaContrato() {return this.fechaContrato;}
    public void setFechaContrato(Date fechaContrato) {this.fechaContrato = fechaContrato;}
    public double getSalario() {return this.salario;}
    public void setSalario(double salario) {this.salario = salario;}
    public boolean getTeletrabajo() {return this.teletrabajo;}
    public void setTeletrabajo(boolean teletrabajo) {this.teletrabajo = teletrabajo;}
}
