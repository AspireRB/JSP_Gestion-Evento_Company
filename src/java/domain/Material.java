/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author DANIELA
 */
public class Material {
    int idMaterial;
    String nombre;
    String descripcion;
    String rutaArchivo;
    int idConferencia;


    public Material(int idMaterial, String nombre, String descripcion, String rutaArchivo) {
        this.idMaterial = idMaterial;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.rutaArchivo = rutaArchivo;
    }

    public Material(int idMaterial) {
        this.idMaterial = idMaterial;
    }

    public Material() {
    }

    public Material(String nombre, String descripcion, String rutaArchivo, int idConferencia) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.rutaArchivo = rutaArchivo;
        this.idConferencia = idConferencia;
    }

   

    public int getIdConferencia() {
        return idConferencia;
    }

    public void setIdConferencia(int idConferencia) {
        this.idConferencia = idConferencia;
    }

   
    

    public int getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRutaArchivo() {
        return rutaArchivo;
    }

    public void setRutaArchivo(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }
    
    
}
