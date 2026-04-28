package org.camp.gestor_empleados.model;

public abstract class Ubicacion {

    private int codigoPostal;
    private String edificio;
    private String planta;

    // Constructor
    public Ubicacion (int codigoPostal, String edificio, String planta) {
        this.codigoPostal = codigoPostal;
        this.edificio = edificio;
        this.planta = planta;
    }

    // Getters y setters
    public int getCodigoPostal() {return this.codigoPostal;}
    public void setCodigoPostal(int codigoPostal) {this.codigoPostal = codigoPostal;}
    public String getEdificio() {return this.edificio;}
    public void setEdificio(String edificio) {this.edificio = edificio;}
    public String getPlanta() {return this.planta;}
    public void setPlanta(String planta) {this.planta = planta;}


}
