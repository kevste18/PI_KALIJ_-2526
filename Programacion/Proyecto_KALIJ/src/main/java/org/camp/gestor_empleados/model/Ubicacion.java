package org.camp.gestor_empleados.model;

public class Ubicacion {

    private int idUbi;
    private int codigoPostal;
    private String edificio;
    private String planta;
    private int idDir;
    private String calle;
    private String despacho;
    private int numeroCalle;

    public Ubicacion() {
    }

    public Ubicacion(int idUbi, int codigoPostal, String edificio, String planta, int idDir, String calle, String despacho, int numeroCalle) {
        this.idUbi = idUbi;
        this.codigoPostal = codigoPostal;
        this.edificio = edificio;
        this.planta = planta;
        this.idDir = idDir;
        this.calle = calle;
        this.despacho = despacho;
        this.numeroCalle = numeroCalle;
    }

    // Getters y Setters

    public int getIdUbi() {return idUbi;}
    public void setIdUbi(int idUbi) {this.idUbi = idUbi;}
    public int getCodigoPostal() {return codigoPostal;}
    public void setCodigoPostal(int codigoPostal) {this.codigoPostal = codigoPostal;}
    public String getEdificio() {return edificio;}
    public void setEdificio(String edificio) {this.edificio = edificio;}
    public String getPlanta() {return planta;}
    public void setPlanta(String planta) {this.planta = planta;}
    public int getIdDir() {return idDir;}
    public void setIdDir(int idDir) {this.idDir = idDir;}
    public String getCalle() {return calle;}
    public void setCalle(String calle) {this.calle = calle;}
    public String getDespacho() {return despacho;}
    public void setDespacho(String despacho) {this.despacho = despacho;}
    public int getNumeroCalle() {return numeroCalle;}
    public void setNumeroCalle(int numeroCalle) {this.numeroCalle = numeroCalle;}
}