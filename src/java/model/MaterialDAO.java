/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import config.Conexion;
import domain.Material;
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
public class MaterialDAO {

    Connection cn;

    public MaterialDAO() {
        Conexion con = new Conexion();
        cn = con.connect();

    }
    private static final String SQL_INSERT = "INSERT INTO MaterialConferencia (nombre, descripcion, ruta, Conferencia_idConferencia)"
            + "VALUES (?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE MaterialConferencia "
            + " SET nombre=?, descripcion=?, ruta=?, Conferencia_idConferencia=? WHERE idMaterialConferencia=?";
    private static final String SQL_SELECT_BY_ID = "SELECT idMaterialConferencia, nombre, descripcion, ruta, Conferencia_idConferencia"
            + " FROM MaterialConferencia WHERE idMaterialConferencia = ?";
    private static final String SQL_DELETE = "DELETE FROM MaterialConferencia WHERE idMaterialConferencia = ?";
    private static final String SQL_SELECT_BY_RUTA = "SELECT idMaterialConferencia, nombre, descripcion, ruta, Conferencia_idConferencia"
            + " FROM MaterialConferencia WHERE ruta = ?";

    public List<Material> listarMaterial() {
        System.out.println("entraaaaaaaaaa");
        PreparedStatement stmt;
        ResultSet rs;

        List<Material> listaMaterial = new ArrayList<>();

        try {
            System.out.println("ejecutarquery");
            stmt = cn.prepareStatement("SELECT idMaterialConferencia, nombre, descripcion, ruta  FROM MaterialConferencia");
            System.out.println("Ejecutando consulta SQL");
            rs = stmt.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("idMaterialConferencia");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                String ruta = rs.getString("ruta");
                System.out.println(ruta + "que trae");

                Material material = new Material();
                material.setIdMaterial(id);
                material.setNombre(nombre);
                material.setDescripcion(descripcion);
                material.setRutaArchivo(ruta);

                listaMaterial.add(material);
            }

        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return null;
        }
        return listaMaterial;
    }

    public int insertar(Material material) {
        PreparedStatement stmt;

        int rows = 0;
        try {
            stmt = cn.prepareStatement(SQL_INSERT);
            System.out.println(stmt + "Que pasa");

            stmt.setString(1, material.getNombre());
            stmt.setString(2, material.getDescripcion());
            stmt.setString(3, material.getRutaArchivo());
            stmt.setLong(4, material.getIdConferencia());

            System.out.println(material.getRutaArchivo() + "EL MATERIAL SE ENCUENTRA");

            rows = stmt.executeUpdate();
            System.out.println(rows + "que me da");
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }

        return rows;
    }

    public int modificar(Material material) {
        PreparedStatement stmt;

        int rows = 0;
        try {
            stmt = cn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, material.getNombre());
            stmt.setString(2, material.getDescripcion());
            stmt.setString(3, material.getRutaArchivo());
            stmt.setInt(4, material.getIdConferencia());
            stmt.setInt(5, material.getIdMaterial());

            rows = stmt.executeUpdate();
            System.out.println(rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }

        return rows;
    }

    public Material buscar(Material material) {
        PreparedStatement stmt;
        ResultSet rs;

        try {
            stmt = cn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, material.getIdMaterial());
            rs = stmt.executeQuery();
            System.out.println(rs);
            if (rs.next()) {
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                String ruta = rs.getString("ruta");
                int id = rs.getInt("Conferencia_idConferencia");

                System.out.println(nombre + "me lo trae");
                System.out.println(descripcion + "me lo trae");

                material.setNombre(nombre);
                material.setDescripcion(descripcion);
                material.setRutaArchivo(ruta);
                material.setIdConferencia(id);

            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }

        return material;
    }

    public boolean eliminar(Material material) {
        PreparedStatement stmt;
        boolean eliminado = false;
        try {
            stmt = cn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, material.getIdMaterial());

            eliminado = stmt.executeUpdate() > 0;
            System.out.println(eliminado);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return eliminado;
    }

    public boolean buscarRuta(String rutaArchivo) {
        PreparedStatement stmt;
        ResultSet rs;
        boolean existe = false;
        try {
            stmt = cn.prepareStatement(SQL_SELECT_BY_RUTA);
            stmt.setString(1, rutaArchivo);
            rs = stmt.executeQuery();
            if (rs.next()) {
                existe = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return existe;
    }
}
