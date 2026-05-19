package org.camp.gestor_empleados.model;

public class Dispositivo {

    private String mac;
    private String ip;
    private String modelo;
    private String sistemaOperativo;
    private String idDispo;


    // Constructor
    public Dispositivo(String mac, String ip, String modelo, String sistemaOperativo, String idDispo) {
        this.mac = mac;
        this.ip = ip;
        this.modelo = modelo;
        this.sistemaOperativo = sistemaOperativo;
        this.idDispo= idDispo;
    }

    // Getters y setters
    public String getMac() {return this.mac;}
    public void setMac(String mac) {this.mac = mac;}
    public String getIp() {return this.ip;}
    public void setIp(String ip) {this.ip = ip;}
    public String getModelo() {return this.modelo;}
    public void setModelo(String modelo) {this.modelo = modelo;}
    public String getSistemaOperativo() {return this.sistemaOperativo;}
    public void setSistemaOperativo(String sistemaOperativo) {this.sistemaOperativo = sistemaOperativo;}
    public String getIdDispo(){return this.idDispo;}
    public void setIdDispo(String idDispo){this.idDispo=idDispo;}
}
