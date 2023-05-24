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

    Conexion con = new Conexion();
    Connection cn = con.connect();
    PreparedStatement stmt;

    private static final String SQL_INSERT = "INSERT INTO conferencista (cedula, nombre, apellido, correo, telefono)"
            + "VALUES (?, ?, ?, ?, ?)";

    public int insertar(Conferencista conferencista) {

        int rows = 0;
        try {
            stmt = cn.prepareStatement(SQL_INSERT);
            stmt.setLong(1, conferencista.getCedula());
            stmt.setString(2, conferencista.getNombre());
            stmt.setString(3, conferencista.getApellido());
            stmt.setString(4, conferencista.getCorreo());
            stmt.setLong(5, conferencista.getTelefono());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return rows;
    }

}
