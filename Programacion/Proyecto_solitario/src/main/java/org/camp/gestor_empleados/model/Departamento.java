package org.camp.gestor_empleados.model;

public class Departamento {

    private int idDep;
    private String nombre;
    private double presupuesto;
    private Ubicacion ubicacion;
    private Direccion direccion;

    // Constructores

    public Departamento(int idDep, String nombre, double presupuesto, Ubicacion ubicacion, Direccion direccion) {
        this.idDep = idDep;
        this.nombre = nombre;
        this.presupuesto = presupuesto;
        this.ubicacion = ubicacion;
        this.direccion = direccion;
    }

    // Setters y getters

    public int getId_dep() {return this.idDep;}
    public void setId_dep(int id_dep) {this.idDep = id_dep;}
    public String getNombre() {return this.nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public double getPresupuesto() {return this.presupuesto;}
    public void setPresupuesto(double presupuesto) {this.presupuesto = presupuesto;}
    public Ubicacion getUbicacion() {return this.ubicacion;}
    public void setUbicacion(Ubicacion ubicacion) {this.ubicacion = ubicacion;}
    public Direccion getDireccion() {return this.direccion;}
    public void setDireccion(Direccion direccion) {this.direccion = direccion;}
}
