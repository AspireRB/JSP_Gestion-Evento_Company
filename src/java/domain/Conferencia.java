/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.util.Date;

public class Conferencia {
    int idConferencia;
    String nombre;
    Date fecha;
    Date horaInicio;
    Date horaFin;
    int idEvento;
    int idSalon;
    int idConferencista;
    int idEmpleado;

    public Conferencia() {
    }

    public Conferencia(int idConferencia, String nombre, Date fecha, Date horaInicio, Date horaFin) {
        this.idConferencia = idConferencia;
        this.nombre = nombre;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public Conferencia(int idConferencia) {
        this.idConferencia = idConferencia;
    }

    public Conferencia(String nombre, Date fecha, Date horaInicio, Date horaFin) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public Conferencia(int idEvento, int idSalon, int idConferencista, int idEmpleado) {
        this.idEvento = idEvento;
        this.idSalon = idSalon;
        this.idConferencista = idConferencista;
        this.idEmpleado = idEmpleado;
    }

    public int getIdConferencia() {
        return idConferencia;
    }

    public void setIdConferencia(int idConferencia) {
        this.idConferencia = idConferencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Date horaFin) {
        this.horaFin = horaFin;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public int getIdSalon() {
        return idSalon;
    }

    public void setIdSalon(int idSalon) {
        this.idSalon = idSalon;
    }

    public int getIdConferencista() {
        return idConferencista;
    }

    public void setIdConferencista(int idConferencista) {
        this.idConferencista = idConferencista;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    @Override
    public String toString() {
        return "Conferencia{" + "idConferencia=" + idConferencia + ", nombre=" + nombre + ", fecha=" + fecha + ", horaInicio=" + horaInicio + ", horaFin=" + horaFin + ", idEvento=" + idEvento + ", idSalon=" + idSalon + ", idConferencista=" + idConferencista + ", idEmpleado=" + idEmpleado + '}';
    }   
   
}