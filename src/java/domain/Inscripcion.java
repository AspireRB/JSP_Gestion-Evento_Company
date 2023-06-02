/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.time.LocalDate;
import java.time.LocalTime;

enum Estado{
    Por_confirmar,
    Inscrito
}

enum Asistencia{
    Asistio,
    No_asistio,
    Pendiente
}
/**
 *
 * @author Juan Guevara
 */
public class Inscripcion {
    private int idInscripcion; 
    private LocalDate fecha;
    private LocalTime hora;
    private Estado estado;
    private Asistencia asistencia;
    private int idCliente;
    private int idEvento;
    private int idEmpleado; 
   

    public Inscripcion(int idInscripcion, LocalDate fecha, LocalTime hora, Estado estado, Asistencia asistencia, int idCliente, int idEvento) {
        this.idInscripcion = idInscripcion;
        this.fecha = fecha;
        this.hora = hora;
        this.estado = estado;
        this.asistencia = asistencia;
        this.idCliente = idCliente;
        this.idEvento = idEvento;
    }

    public Inscripcion(int idInscripcion, LocalDate fecha, LocalTime hora, Estado estado, Asistencia asistencia, int idCliente, int idEvento, int idEmpleado) {
        this.idInscripcion = idInscripcion;
        this.fecha = fecha;
        this.hora = hora;
        this.estado = estado;
        this.asistencia = asistencia;
        this.idCliente = idCliente;
        this.idEvento = idEvento;
        this.idEmpleado = idEmpleado;
    }

    public int getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(int idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Asistencia getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(Asistencia asistencia) {
        this.asistencia = asistencia;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
    
    
}
