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

    // Constructor
    public Ubicacion (int idUbi, String edificio, String planta, String calle, int numeroCalle ) {
        this.idUbi = idUbi;
        this.codigoPostal = codigoPostal;
        this.edificio = edificio;
        this.planta = planta;
        this.calle = calle;
        this.despacho = despacho;
        this.numeroCalle = numeroCalle;
    }

    // Getters y setters
    public int getIdUbi() {return this.idUbi;}
    public void setIdUbi(int idUbi) {this.idUbi = idUbi;}
    public int getCodigoPostal() {return this.codigoPostal;}
    public void setCodigoPostal(int codigoPostal) {this.codigoPostal = codigoPostal;}
    public String getEdificio() {return this.edificio;}
    public void setEdificio(String edificio) {this.edificio = edificio;}
    public String getPlanta() {return this.planta;}
    public void setPlanta(String planta) {this.planta = planta;}
    public int getIdDir() {return this.idDir;}
    public void setIdDir(int id_dir) {this.idDir = idDir;}
    public String getCalle() {return this.calle;}
    public void setCalle(String calle) {this.calle = calle;}
    public String getDespacho() {return this.despacho;}
    public void setDespacho(String despacho) {this.despacho = despacho;}
    public int getNumeroCalle() {return this.numeroCalle;}
    public void setNumeroCalle(int numeroCalle) {this.numeroCalle = numeroCalle;}
}
