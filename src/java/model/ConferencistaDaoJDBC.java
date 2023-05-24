/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import config.Conexion;
import domain.Conferencista;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author DANIELA
 */
public class ConferencistaDaoJDBC {

    private static final String SQL_INSERT = "INSERT INTO conferencista (cedula, nombre, apellido, correo, telefono)"
            + "VALUES (?, ?, ?, ?, ?)";
  
     
    public int insertar(Conferencista conferencista) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setLong(1, conferencista.getCedula());
            stmt.setString(2, conferencista.getNombre());
            stmt.setString(3, conferencista.getApellido());
            stmt.setString(4, conferencista.getCorreo());
            stmt.setLong(5, conferencista.getTelefono());

            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);

        } finally {

            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }
    
    

}
