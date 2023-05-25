package config;

import java.sql.*;

public class Conexion {

    Connection conexion = null;

    public Connection connect() {

        String driver = "com.mysql.cj.jdbc.Driver";
        try {
            Class.forName(driver);
            System.out.println("Driver cargado con exito");
            try {
                conexion = DriverManager.getConnection("jdbc:mysql://localhost:3305/gestion_evento?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true", "root", "1234");
                if (conexion != null) {
                    System.out.println("Conexion realizada con exito");
                }
            } catch (SQLException error) {
                System.out.println("Ha ocurrido un error al intentar conectar con la base de datos, " + error.getMessage());
            }
        } catch (ClassNotFoundException error) {
            System.out.println("Ha ocurrido un error al cargar el driver, " + error.getMessage());
        }
        return conexion;
    }
}
