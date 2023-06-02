/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import config.Conexion;
import domain.Lugar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LugarDAO {
    
    Connection connecting;
    
    public LugarDAO() {
        Conexion conexion = new Conexion ();
        connecting = conexion.connect();
    }
    
    private static final String SQL_INSERT = "INSERT INTO Lugar (nombre, Ciudad_idCiudad)"
            + "VALUES (?, ?)";
    private static final String SQL_UPDATE = "UPDATE Lugar"
            + " SET nombre=?, Ciudad_idCiudad=? WHERE idLugar=?";
    private static final String SQL_SELECT_BY_ID = "SELECT idLugar, nombre, Ciudad_idCiudad"
            + " FROM Lugar WHERE idLugar = ?";
    private static final String SQL_SELECT_BY_nombre = "SELECT idLugar, nombre, Ciudad_idCiudad"
            + "FROM Lugar WHERE nombre = ?";
    private static final String SQL_DELETE = "DELETE FROM Lugar WHERE idLugar = ?";
        
    public int insertar(Lugar lugar){
        PreparedStatement stmt;
        
        int rows = 0;
        try {
            stmt = connecting.prepareStatement(SQL_INSERT);
            stmt.setString(1,lugar.getNombre());
            stmt.setInt(2, lugar.getCiudad_idCiudad());
            
            rows = stmt.executeUpdate();
        } catch (SQLException error) {
            error.printStackTrace(System.out);
        }
        
        return rows;
    }
    
    public List<Lugar> listar() {
        PreparedStatement stmt;
        ResultSet rs;

        List<Lugar> lugares = new ArrayList<>();

        try {
            stmt = connecting.prepareStatement("SELECT idLugar, nombre, Ciudad_idCiudad FROM Lugar");
            rs = stmt.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("idLugar");
                String nombre = rs.getString("nombre");
                int idCiudad = rs.getInt("capacidad");
                              
                Lugar lugar = new Lugar();
                lugar.setId(id);
                lugar.setNombre(nombre);
                lugar.setCiudad_idCiudad(idCiudad);

                lugares.add(lugar);
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return null;
        }
        return lugares;
    }
    
    public int modificar(Lugar lugar) {
        PreparedStatement stmt;
        int rows = 0;
        
        try {
            stmt = connecting.prepareStatement(SQL_UPDATE);
            stmt.setString(1,lugar.getNombre());            
            stmt.setInt(2, lugar.getCiudad_idCiudad());
            
            rows = stmt.executeUpdate();
            System.out.println(rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return rows;
    }
    
    public Lugar buscar(Lugar lugar) {
        PreparedStatement stmt;
        ResultSet rs;

        try {
            stmt = connecting.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, lugar.getId());
            rs = stmt.executeQuery();
            if (rs.next()) {
               
                String nombre = rs.getString("nombre");
                int idCiudad = rs.getInt("Ciudad_idCiudad");
                
                lugar.setNombre(nombre);
                lugar.setCiudad_idCiudad(idCiudad);              
               
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }

        return lugar;
    }
    
    public boolean buscarLugar(Lugar lugar) {
        PreparedStatement stmt;
        ResultSet rs;
        boolean existe = false;
        try {
            stmt = connecting.prepareStatement(SQL_SELECT_BY_nombre);
            stmt.setString(1, lugar.getNombre());
            rs = stmt.executeQuery();
            if (rs.next()) {
                
                String nombre = rs.getString("nombre");
                int idCiudad = rs.getInt("Ciudad_idCiudad");
                
                lugar.setNombre(nombre);
                lugar.setCiudad_idCiudad(idCiudad);                 
                
                existe = true;
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return existe;
    }
    
    public boolean eliminar(Lugar lugar) {
        PreparedStatement stmt;
        boolean eliminado = false;
        try {
            stmt = connecting.prepareStatement(SQL_DELETE);
            stmt.setInt(1, lugar.getId());

            eliminado = stmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return eliminado;
    }
}