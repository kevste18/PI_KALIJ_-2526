package org.camp.gestor_empleados.model;

import java.util.Date;

public class Incidencia {

    private int idIncidencia;
    private String estado;
    private Date fechaAlta;
    private Date fechaResolucion;

    // Constructor
    public Incidencia(int idIncidencia, String estado, Date fechaAlta, Date fechaResolucion) {
        this.idIncidencia = idIncidencia;
        this.estado = estado;
        this.fechaAlta = fechaAlta;
        this.fechaResolucion = fechaResolucion;
    }

    // Getters y setters
    public int getIdIncidencia() {return this.idIncidencia;}
    public void setIdIncidencia(int idIncidencia) {this.idIncidencia = idIncidencia;}
    public String getEstado() {return this.estado;}
    public void setEstado(String estado) {this.estado = estado;}
    public Date getFechaAlta() {return this.fechaAlta;}
    public void setFechaAlta(Date fechaAlta) {this.fechaAlta = fechaAlta;}
    public Date getFechaResolucion() {return this.fechaResolucion;}
    public void setFechaResolucion(Date fechaResolucion) {this.fechaResolucion = fechaResolucion;}


}
