package org.camp.gestor_empleados.model;

public class Departamento {

        private int idDep;
        private String nombre;
        private double presupuesto;
        private int idUbi;

        // Constructores

        public Departamento(int idDep, String nombre, double presupuesto, int idUbi) {
            this.idDep = idDep;
            this.nombre = nombre;
            this.presupuesto = presupuesto;
            this.idUbi = idUbi;
        }

        // Setters y getters

        public int getId_dep() {return this.idDep;}
        public void setId_dep(int id_dep) {this.idDep = id_dep;}
        public String getNombre() {return this.nombre;}
        public void setNombre(String nombre) {this.nombre = nombre;}
        public double getPresupuesto() {return this.presupuesto;}
        public void setPresupuesto(double presupuesto) {this.presupuesto = presupuesto;}
        public int getIdUbi() {return this.idUbi;}
        public void setIdUbi(int idUbi) {this.idUbi = idUbi;}
}
