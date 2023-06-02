/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author Ingytelcom
 */
public class Lugar {
    private int id;
    private String nombre;
    private int Ciudad_idCiudad;

    public Lugar() {
    }

    public Lugar(int id) {
        this.id = id;
    }   
    
    public Lugar(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Lugar(String nombre, int Ciudad_idCiudad) {
        this.nombre = nombre;
        this.Ciudad_idCiudad = Ciudad_idCiudad;
    } 

    public Lugar(int id, String nombre, int Ciudad_idCiudad) {
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

    public int getCiudad_idCiudad() {
        return Ciudad_idCiudad;
    }

    public void setCiudad_idCiudad(int Ciudad_idCiudad) {
        this.Ciudad_idCiudad = Ciudad_idCiudad;
    }

    @Override
    public String toString() {
        return "Lugar{" + "id=" + id + ", nombre=" + nombre + ", Ciudad_idCiudad=" + Ciudad_idCiudad + '}';
    }    
    
}