/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import config.Conexion;
import domain.Conferencia;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConferenciaDAO {
    
    Connection connecting;
    
    public ConferenciaDAO() {
        Conexion conexion = new Conexion ();
        connecting = conexion.connect();
    }
    
    private static final String SQL_INSERT = "INSERT INTO Conferencia (nombre, fecha, horaInicio, horaFin, Evento_idEvento, Salon_idSalon, Conferencista_idConferencista, Empleado_idEmpleado)"
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE Conferencia"
            + " SET nombre=?, fecha=?, horaIncio=?, horaFin=?, Evento_idEvento=?, Salon_idSalon=?, Conferencista_idConferencista=?, Empleado_idEmpleado WHERE idConferencia=?";
    private static final String SQL_SELECT_BY_ID = "SELECT idConferencia, nombre, fecha, horaInicio, horaFin, descripcion, costo, estado, Empleado_idEmpleado, Lugar_idLugar"
            + " FROM Conferencia WHERE idConferencia = ?";
    private static final String SQL_SELECT_BY_nombre = "SELECT idConferencia, nombre, fecha, horaInicio, horaFin, Evento_idEvento, Salon_idSalon, Conferencista_idConferencista, Empleado_idEmpleado"
            + "FROM Conferencia WHERE nombre = ?";
    private static final String SQL_DELETE = "DELETE FROM Conferencia WHERE idConferencia = ?";
        
    public int insertar(Conferencia conferencia){
        PreparedStatement stmt;
        
        int rows = 0;
        try {
            stmt = connecting.prepareStatement(SQL_INSERT);
            stmt.setString(1,conferencia.getNombre());
            stmt.setDate(2, (Date) conferencia.getFecha());
            stmt.setDate(3, (Date) conferencia.getHoraInicio());
            stmt.setDate(4, (Date) conferencia.getHoraFin());
            stmt.setInt(5, conferencia.getIdEvento());
            stmt.setInt(6, conferencia.getIdSalon());
            stmt.setInt(7, conferencia.getIdConferencista());
            stmt.setInt(8, conferencia.getIdEmpleado());
            
            rows = stmt.executeUpdate();
        } catch (SQLException error) {
            error.printStackTrace(System.out);
        }
        
        return rows;
    }
    
    public List<Conferencia> listar() {
        PreparedStatement stmt;
        ResultSet rs;

        List<Conferencia> conferencias = new ArrayList<>();

        try {
            stmt = connecting.prepareStatement("SELECT idConferencia, nombre, fecha, horaInicio, horaFin, Evento_idEvento, Salon_idSalon, Conferencista_idConferencista, Empleado_idEmpleado FROM Conferencia");
            rs = stmt.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("idConferencias");
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
