/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import config.Conexion;
import domain.Ciudad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CiudadDAO {
    
    Connection connecting;
    
    public CiudadDAO() {
        Conexion conexion = new Conexion ();
        connecting = conexion.connect();
    }
    
    private static final String SQL_INSERT = "INSERT INTO Ciudad (nombre)"
            + "VALUES (?)";
    private static final String SQL_UPDATE = "UPDATE Ciudad"
            + " SET nombre=? WHERE idCiudad=?";
    private static final String SQL_SELECT_BY_ID = "SELECT idCiudad, nombre"
            + " FROM Ciudad WHERE idCiudad = ?";
    private static final String SQL_SELECT_BY_nombre = "SELECT idSalon, nombre"
            + "FROM Ciudad WHERE nombre = ?";
    private static final String SQL_DELETE = "DELETE FROM Ciudad WHERE idCiudad = ?";
        
    public int insertar(Ciudad ciudad){
        PreparedStatement stmt;
        
        int rows = 0;
        try {
            stmt = connecting.prepareStatement(SQL_INSERT);
            stmt.setString(1,ciudad.getNombre());
            
            rows = stmt.executeUpdate();
        } catch (SQLException error) {
            error.printStackTrace(System.out);
        }
        
        return rows;
    }
    
    public List<Ciudad> listar() {
        PreparedStatement stmt;
        ResultSet rs;

        List<Ciudad> ciudades = new ArrayList<>();

        try {
            stmt = connecting.prepareStatement("SELECT idCiudad, nombre FROM Ciudad");
            rs = stmt.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("idCiudad");
                String nombre = rs.getString("nombre");
                              
                Ciudad ciudad = new Ciudad();
                ciudad.setId(id);
                ciudad.setNombre(nombre);

                ciudades.add(ciudad);
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return null;
        }
        return ciudades;
    }
    
    public int modificar(Ciudad ciudad) {
        PreparedStatement stmt;
        int rows = 0;
        
        try {
            stmt = connecting.prepareStatement(SQL_UPDATE);
            stmt.setString(1,ciudad.getNombre()); 
            
            rows = stmt.executeUpdate();
            System.out.println(rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return rows;
    }
    
    public Ciudad buscar(Ciudad ciudad) {
        PreparedStatement stmt;
        ResultSet rs;

        try {
            stmt = connecting.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, ciudad.getId());
            rs = stmt.executeQuery();
            if (rs.next()) {
               
                String nombre = rs.getString("nombre");
                
                ciudad.setNombre(nombre);
                
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }

        return ciudad;
    }
    
    public boolean buscarSalon(Ciudad ciudad) {
        PreparedStatement stmt;
        ResultSet rs;
        boolean existe = false;
        try {
            stmt = connecting.prepareStatement(SQL_SELECT_BY_nombre);
            stmt.setString(1, ciudad.getNombre());
            rs = stmt.executeQuery();
            if (rs.next()) {
                
                String nombre = rs.getString("nombre");
                
                ciudad.setNombre(nombre);
                
                existe = true;
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return existe;
    }
    
    public boolean eliminar(Ciudad ciudad) {
        PreparedStatement stmt;
        boolean eliminado = false;
        try {
            stmt = connecting.prepareStatement(SQL_DELETE);
            stmt.setInt(1, ciudad.getId());

            eliminado = stmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return eliminado;
    }
}
