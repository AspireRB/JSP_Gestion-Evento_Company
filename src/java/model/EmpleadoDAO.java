/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.*;

import config.Conexion;

import domain.Empleado;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan Guevara
 */
public class EmpleadoDAO {
    
    Conexion cnnxn=new Conexion();
    
    Connection cn=cnnxn.connect();
    PreparedStatement ps;
    ResultSet rs;
    
    public Empleado logIn(Empleado us) {
		
		Empleado resultado = null;
		try {
			ps=cn.prepareStatement("SELECT idEmpleado,cedula,nombre,apellido,telefono,correo,clave,tipoEmpleado FROM Empleado WHERE correo=? and clave=?");
			ps.setString(1, us.getCorreo());
			ps.setString(2, us.getContrasenia());
			rs=ps.executeQuery();
			if (rs.next()) {
				resultado = new Empleado(rs.getInt("idEmpleado"), rs.getLong("cedula"), rs.getString("nombre"), rs.getString("apellido"), rs.getLong("telefono"),  rs.getString("correo"), rs.getString("clave"));
                                //usu=new Empleado(rs.getFloat(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			}
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		return resultado;
		
	}
}
