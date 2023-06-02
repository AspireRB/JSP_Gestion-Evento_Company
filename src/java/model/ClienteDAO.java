/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import config.Conexion;
import domain.Cliente;
import java.sql.*;
import domain.Inscripcion;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juan Guevara
 */
public class ClienteDAO {
    
    Connection cn;
    
    public ClienteDAO() {
        Conexion con = new Conexion();
        cn = con.connect();

    }
    
    public List<Cliente> listarClientesEvento(int idEvento) {
        PreparedStatement ps;
        ResultSet rs;

        List<Cliente> clientes = new ArrayList<>();

        try {
            ps = cn.prepareStatement(
                    "SELECT \n" +
                    "a.idCliente\n" +
                    ", a.cedula \n" +
                    ", a.nombre\n" +
                    ", a.apellido\n" +
                    ", a.correo\n" +
                    ", a.telefono\n" +
                    "FROM `Cliente` a \n" +
                    "inner join Inscripcion b on a.idCliente = b.Cliente_idCliente\n" +
                    "inner join Evento c on b.Evento_idEvento = c.idEvento\n" +
                    "WHERE c.idEvento=?");
            ps.setInt(1, idEvento);
            rs = ps.executeQuery();

            while (rs.next()) {

                int id = rs.getInt(1);
                long cedula = rs.getLong(2);
                String nombre = rs.getString(3);
                String apellido = rs.getString(4);
                String correo = rs.getString(5);
                long telefono = rs.getLong(6);

                Cliente cli = new Cliente(id,cedula,nombre,apellido,correo,telefono);
                System.out.println(cli.getCedula() + "cedulaaaaaaaaa");
                clientes.add(cli);
            }

        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return null;
        }
        return clientes;
    }
}
