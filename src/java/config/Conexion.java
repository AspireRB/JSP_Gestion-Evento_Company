/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    
    public static void main(String[] args) {
        connect();
    }
    
    public static void connect() {
        Connection conexion = null;
        String driver = "com.mysql.cj.jdbc.Driver";        
        try{
            Class.forName(driver);
            System.out.println("Driver cargado con exito");        
            try{
                conexion = DriverManager.getConnection("jdbc:mysql://localhost:3305/gestion_evento", "root", "1234");
                if(conexion != null){
                    System.out.println("Conexion realizada con exito");
                }
            }catch(Exception error){
                System.out.println("Ha ocurrido un error al intentar conectar con la base de datos, "+error.getMessage());
            }
        }catch(Exception error){
            System.out.println("Ha ocurrido un error al cargar el driver, "+error.getMessage());
        }            
    }
    
}