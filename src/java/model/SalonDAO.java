/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import config.Conexion;
import domain.Salon;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SalonDAO {
    
    Connection connecting;
    
    public SalonDAO() {
        Conexion conexion = new Conexion ();
        connecting = conexion.connect();
    }
    
    private static final String SQL_INSERT = "INSERT INTO Salon (nombre, capacidad)"
            + "VALUES (?, ?)";
    private static final String SQL_UPDATE = "UPDATE Salon"
            + " SET nombre=?, capacidad=? WHERE idSalon=?";
    private static final String SQL_SELECT_BY_ID = "SELECT idSalon, nombre, capacidad"
            + " FROM Salon WHERE idSalon = ?";
    private static final String SQL_SELECT_BY_nombre = "SELECT idSalon, nombre, capacidad"
            + "FROM Salon WHERE nombre = ?";
    private static final String SQL_DELETE = "DELETE FROM Salon WHERE idSalon = ?";
        
    public int insertar(Salon salon){
        PreparedStatement stmt;
        
        int rows = 0;
        try {
            stmt = connecting.prepareStatement(SQL_INSERT);
            stmt.setString(1,salon.getNombre());
            stmt.setInt(2, salon.getCapacidad());
            
            rows = stmt.executeUpdate();
        } catch (SQLException error) {
            error.printStackTrace(System.out);
        }
        
        return rows;
    }
    
    public List<Salon> listar() {
        PreparedStatement stmt;
        ResultSet rs;

        List<Salon> salones = new ArrayList<>();

        try {
            stmt = connecting.prepareStatement("SELECT idConferencia, nombre, fecha, horaInicio, horaFin, Evento_idEvento, Salon_idSalon, Conferencista_idConferencista, Empleado_idEmpleado FROM Conferencia");
            rs = stmt.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("idSalon");
                String nombre = rs.getString("nombre");
                int capacidad = rs.getInt("capacidad");
                              
                Salon salon = new Salon();
                salon.setId(id);
                salon.setNombre(nombre);
                salon.setCapacidad(capacidad);

                salones.add(salon);
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return null;
        }
        return salones;
    }
    
    public int modificar(Salon salon) {
        PreparedStatement stmt;
        int rows = 0;
        
        try {
            stmt = connecting.prepareStatement(SQL_UPDATE);
            stmt.setString(1,salon.getNombre());            
            stmt.setInt(2, salon.getCapacidad());
            
            rows = stmt.executeUpdate();
            System.out.println(rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return rows;
    }
    
    public Salon buscar(Salon salon) {
        PreparedStatement stmt;
        ResultSet rs;

        try {
            stmt = connecting.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, salon.getId());
            rs = stmt.executeQuery();
            if (rs.next()) {
               
                String nombre = rs.getString("nombre");
                int capacidad = rs.getInt("capacidad");
                
                salon.setNombre(nombre);
                salon.setCapacidad(capacidad);              
               
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }

        return salon;
    }
    
    public boolean buscarSalon(Salon salon) {
        PreparedStatement stmt;
        ResultSet rs;
        boolean existe = false;
        try {
            stmt = connecting.prepareStatement(SQL_SELECT_BY_nombre);
            stmt.setString(1, salon.getNombre());
            rs = stmt.executeQuery();
            if (rs.next()) {
                
                String nombre = rs.getString("nombre");
                int capacidad = rs.getInt("Capacidad");
                
                salon.setNombre(nombre);
                salon.setCapacidad(capacidad);                 
                
                existe = true;
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return existe;
    }
    
    public boolean eliminar(Salon salon) {
        PreparedStatement stmt;
        boolean eliminado = false;
        try {
            stmt = connecting.prepareStatement(SQL_DELETE);
            stmt.setInt(1, salon.getId());

            eliminado = stmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return eliminado;
    }
}
