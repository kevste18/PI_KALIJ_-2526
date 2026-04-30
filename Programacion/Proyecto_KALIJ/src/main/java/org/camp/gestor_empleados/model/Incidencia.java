package org.camp.gestor_empleados.model;

import java.sql.Date;

public class Incidencia {
    private int numIncidencia;
    private String estado;
    private String dniEmpleado;
    private String dniResponsable;
    private Date fechaAlta;
    private Date fechaResolucion;
    private String dispositivoAfect;

    // Getters y setters
    public int getNumIncidencia() { return numIncidencia; }
    public void setNumIncidencia(int numIncidencia) { this.numIncidencia = numIncidencia; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getDniEmpleado() { return dniEmpleado; }
    public void setDniEmpleado(String dniEmpleado) { this.dniEmpleado = dniEmpleado; }

    public String getDniResponsable() { return dniResponsable; }
    public void setDniResponsable(String dniResponsable) { this.dniResponsable = dniResponsable; }

    public Date getFechaAlta() { return fechaAlta; }
    public void setFechaAlta(Date fechaAlta) { this.fechaAlta = fechaAlta; }

    public Date getFechaResolucion() { return fechaResolucion; }
    public void setFechaResolucion(Date fechaResolucion) { this.fechaResolucion = fechaResolucion; }

    public String getDispositivoAfect() { return dispositivoAfect; }
    public void setDispositivoAfect(String dispositivoAfect) { this.dispositivoAfect = dispositivoAfect; }
}
