/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import config.Conexion;
import domain.Conferencia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DANIELA
 */
public class ConferenciaDAO {
    Connection cn;

    public ConferenciaDAO() {
        Conexion con = new Conexion();
        cn = con.connect();

    }
     public List<Conferencia> listarConferencia() {
        System.out.println("entraaaaaaaaaa");
        PreparedStatement stmt;
        ResultSet rs;

        List<Conferencia> listaConferencias = new ArrayList<>();

        try {
            System.out.println("ejecutarquery");
            stmt = cn.prepareStatement("SELECT idConferencia, nombre  FROM Conferencia");
            System.out.println("Ejecutando consulta SQL");
            rs = stmt.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("idConferencia");               
                String nombre = rs.getString("nombre");
               

                Conferencia conferencia = new Conferencia();
                conferencia.setIdConferencia(id);
                conferencia.setNombre(nombre);
               

                listaConferencias.add(conferencia);
            }

        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return null;
        }
        return listaConferencias;
    }
    
}