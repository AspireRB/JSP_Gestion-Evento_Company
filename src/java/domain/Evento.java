/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.util.Date;

public class Evento {
    
    private int id;
    private String nombre;
    private Date fechaInicio;
    private Date horaInicio;
    private Date fechaFin;
    private Date horaFin;
    private String descripcion;
    private Double costo;
    private String estado;
    private int idEmpleado;
    private int idLugar;

    public Evento() {
        
    }

    public Evento(int id, String nombre, Date fechaInicio, Date horaInicio, Date fechaFin, Date horaFin, String descripcion, Double costo, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.horaInicio = horaInicio;
        this.fechaFin = fechaFin;
        this.horaFin = horaFin;
        this.descripcion = descripcion;
        this.costo = costo;
        this.estado = estado;
    }

    public Evento(int id) {
        this.id = id;
    }  

    public Evento(String nombre, Date fechaInicio, Date horaInicio, Date fechaFin, Date horaFin, String descripcion, Double costo, String estado) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.horaInicio = horaInicio;
        this.fechaFin = fechaFin;
        this.horaFin = horaFin;
        this.descripcion = descripcion;
        this.costo = costo;
        this.estado = estado;
    }

    public Evento(int idEmpleado, int idLugar) {
        this.idEmpleado = idEmpleado;
        this.idLugar = idLugar;
    } 

    public Evento(int id, String nombre, Date fechaInicio, Date horaInicio, Date fechaFin, Date horaFin, String descripcion, Double costo, String estado, int idEmpleado, int idLugar) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
        
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Date getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Date horaFin) {
        this.horaFin = horaFin;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getIdLugar() {
        return idLugar;
    }

    public void setIdLugar(int idLugar) {
        this.idLugar = idLugar;
    }

    @Override
    public String toString() {
        return "Evento{" + "id=" + id + ", nombre=" + nombre + ", fechaInicio=" + fechaInicio + ", horaInicio=" + horaInicio + ", fechaFin=" + fechaFin + ", horaFin=" + horaFin + ", descripcion=" + descripcion + ", costo=" + costo + ", estado=" + estado + ", idEmpleado=" + idEmpleado + ", idLugar=" + idLugar + '}';
    } 
           
}