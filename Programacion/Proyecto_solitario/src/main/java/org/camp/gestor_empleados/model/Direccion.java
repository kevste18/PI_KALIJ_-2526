package org.camp.gestor_empleados.model;

public class Direccion {

    private int id_dir;
    private String calle;
    private String despacho;
    private int numero;


    // Constructor
    public Direccion(int id_dir, String calle, String despacho, int numero) {
        this.id_dir = id_dir;
        this.calle = calle;
        this.despacho = despacho;
        this.numero = numero;
    }

    // Getters y setters
    public int getId_dir() {return this.id_dir;}
    public void setId_dir(int id_dir) {this.id_dir = id_dir;}
    public String getCalle() {return this.calle;}
    public void setCalle(String calle) {this.calle = calle;}
    public String getDespacho() {return this.despacho;}
    public void setDespacho(String despacho) {this.despacho = despacho;}
    public int getNumero() {return this.numero;}
    public void setNumero(int numero) {this.numero = numero;}
}
