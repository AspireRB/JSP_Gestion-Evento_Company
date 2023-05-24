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
import java.sql.SQLException;

public class EventoDAO {
    
    Conexion con = new Conexion();
    Connection cn = con.connect();
    PreparedStatement stmt;
    
    private static final String SQL_INSERT = "INSERT INTO evento (nombre, fechaIncio, horaIncio, fechaFin, horaFin, descripcion, costo, estado)"
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    
    public int insert(Evento evento){
        int rows = 0;
        try {
            stmt = cn.prepareStatement(SQL_INSERT);
            stmt.setString(1,evento.getNombre());
            stmt.setDate(2, (Date) evento.getFechaInicio());
        } catch (SQLException error) {
            error.printStackTrace();
        }
        
        return rows;
    }
}
