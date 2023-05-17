/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
/**
 *
 * @author Ingytelcom
 */
public class Conexion {
    
    public Connection getConexion (){
        try {
            
            Connection conexion = DriverManager.getConnection("jdbc:myql//localhost:3305/gestionevento", "root", "1234");
            return conexion;
            
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }
}
