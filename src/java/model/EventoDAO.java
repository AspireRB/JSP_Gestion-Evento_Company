/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import config.Conexion;
import domain.Evento;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EventoDAO {
    
    Connection connecting;
    
    public EventoDAO() {
        Conexion conexion = new Conexion ();
        connecting = conexion.connect();
    }
    
    private static final String SQL_INSERT = "INSERT INTO Evento (nombre, fechaIncio, horaInicio, fechaFin, horaFin, descripcion, costo, estado, Empleado_idEmpleado, Lugar_idLugar)"
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE Evento"
            + " SET nombre=?, fechaInicio=?, horaIncio=?, fechaFin=?, horaFin=?, descripcion=?, costo=?, estado=? Empleado_idEmpleado=?, Lugar_idLugar=? WHERE idEvento=?";
    private static final String SQL_SELECT_BY_ID = "SELECT idEvento, nombre, fechaInicio, horaInicio, fechaFin, horaFin, descripcion, costo, estado, Empleado_idEmpleado, Lugar_idLugar"
            + " FROM Evento WHERE idEvento = ?";
    private static final String SQL_SELECT_BY_nombre = "SELECT idEvento, nombre, fechaInicio, horaInicio, fechaFin, horaFin, descripcion, costo, estado, Empleado_idEmpleado, Lugar_idLugar"
            + "FROM Evento WHERE nombre = ?";
    private static final String SQL_DELETE = "DELETE FROM Evento WHERE idEvento = ?";
        
    public int insertar(Evento evento){
        PreparedStatement stmt;
        
        int rows = 0;
        try {
            stmt = connecting.prepareStatement(SQL_INSERT);
            stmt.setString(1,evento.getNombre());
            stmt.setDate(2, (Date) evento.getFechaInicio());
            stmt.setDate(3, (Date) evento.getHoraInicio());
            stmt.setDate(4, (Date) evento.getFechaFin());
            stmt.setDate(5, (Date) evento.getHoraFin());
            stmt.setString(6, evento.getDescripcion());
            stmt.setDouble(7, evento.getCosto());
            stmt.setString(8, evento.getEstado());
            stmt.setInt(9, evento.getIdEmpleado());
            stmt.setInt(10, evento.getIdLugar());
            
            rows = stmt.executeUpdate();
        } catch (SQLException error) {
            error.printStackTrace(System.out);
        }
        
        return rows;
    }
    
    public List<Evento> listar() {
        PreparedStatement stmt;
        ResultSet rs;

        List<Evento> eventos = new ArrayList<>();

        try {
            stmt = connecting.prepareStatement("SELECT idEvento, nombre, fechaInicio, horaInicio, fechaFin, horaFin, descripcion, costo, estado, Empleado_idEmpleado, Lugar_idLugar FROM Evento");
            rs = stmt.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("idEvento");
                String nombre = rs.getString("nombre");
                Date fechaInicio = rs.getDate("fechaInicio");
                Date horaInicio = rs.getDate("horaInicio");
                Date fechaFin = rs.getDate("fechaFin");
                Date horaFin = rs.getDate("horaFin");
                String descripcion = rs.getString("descripcion");
                Double costo = rs.getDouble("costo");
                String estado = rs.getString("estado");
                              
                Evento evento = new Evento();
                evento.setId(id);
                evento.setNombre(nombre);
                evento.setFechaInicio(fechaInicio);
                evento.setHoraInicio(horaInicio);
                evento.setFechaFin(fechaFin);
                evento.setHoraFin(horaFin);
                evento.setDescripcion(descripcion);
                evento.setCosto(costo);
                evento.setEstado(estado);

                eventos.add(evento);
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return null;
        }
        return eventos;
    }
    
    public int modificar(Evento evento) {
        PreparedStatement stmt;
        int rows = 0;
        
        try {
            stmt = connecting.prepareStatement(SQL_UPDATE);
            stmt.setString(1,evento.getNombre());
            stmt.setDate(2, (Date) evento.getFechaInicio());
            stmt.setDate(3, (Date) evento.getHoraInicio());
            stmt.setDate(4, (Date) evento.getFechaFin());
            stmt.setDate(5, (Date) evento.getHoraFin());
            stmt.setString(6, evento.getDescripcion());
            stmt.setDouble(7, evento.getCosto());
            stmt.setString(8, evento.getEstado());
            stmt.setInt(9, evento.getIdEmpleado());
            stmt.setInt(10, evento.getIdLugar());
            
            rows = stmt.executeUpdate();
            System.out.println(rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return rows;
    }
    
    public Evento buscar(Evento evento) {
        PreparedStatement stmt;
        ResultSet rs;

        try {
            stmt = connecting.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, evento.getId());
            rs = stmt.executeQuery();
            if (rs.next()) {
               
                String nombre = rs.getString("nombre");
                Date fechaInicio = rs.getDate("fechaInicio");
                Date horaInicio = rs.getDate("horaInicio");
                Date fechaFin = rs.getDate("fechaFin");
                Date horaFin = rs.getDate("horaFin");
                String descripcion = rs.getString("descripcion");
                Double costo = rs.getDouble("costo");
                String estado = rs.getString("estado");
                
                evento.setNombre(nombre);
                evento.setFechaInicio(fechaInicio);
                evento.setHoraInicio(horaInicio);
                evento.setFechaFin(fechaFin);
                evento.setHoraFin(horaFin);
                evento.setDescripcion(descripcion);
                evento.setCosto(costo);
                evento.setEstado(estado);               
               
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }

        return evento;
    }
    
    public boolean buscarEvento(Evento evento) {
        PreparedStatement stmt;
        ResultSet rs;
        boolean existe = false;
        try {
            stmt = connecting.prepareStatement(SQL_SELECT_BY_nombre);
            stmt.setString(1, evento.getNombre());
            rs = stmt.executeQuery();
            if (rs.next()) {
                
                String nombre = rs.getString("nombre");
                Date fechaInicio = rs.getDate("fechaInicio");
                Date horaInicio = rs.getDate("horaInicio");
                Date fechaFin = rs.getDate("fechaFin");
                Date horaFin = rs.getDate("horaFin");
                String descripcion = rs.getString("descripcion");
                Double costo = rs.getDouble("costo");
                String estado = rs.getString("estado");
   
                evento.setNombre(nombre);
                evento.setFechaInicio(fechaInicio);
                evento.setHoraInicio(horaInicio);
                evento.setFechaFin(fechaFin);
                evento.setHoraFin(horaFin);
                evento.setDescripcion(descripcion);
                evento.setCosto(costo);
                evento.setEstado(estado); 

                existe = true;
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return existe;
    }
    
    public boolean eliminar(Evento evento) {
        PreparedStatement stmt;
        boolean eliminado = false;
        try {
            stmt = connecting.prepareStatement(SQL_DELETE);
            stmt.setInt(1, evento.getId());

            eliminado = stmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return eliminado;
    }
}
