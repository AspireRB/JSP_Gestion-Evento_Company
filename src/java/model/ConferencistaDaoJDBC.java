/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import config.Conexion;
import domain.Conferencista;
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
public class ConferencistaDaoJDBC {

    Connection cn;

    public ConferencistaDaoJDBC() {
        Conexion con = new Conexion();
        cn = con.connect();

    }

    private static final String SQL_INSERT = "INSERT INTO Conferencista (cedula, nombre, apellido, correo, telefono)"
            + "VALUES (?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE Conferencista "
            + " SET cedula=?, nombre=?, apellido=?, correo=?, telefono=? WHERE idConferencista=?";
    private static final String SQL_SELECT_BY_ID = "SELECT idConferencista, cedula, nombre, apellido, correo, telefono "
            + " FROM Conferencista WHERE idConferencista = ?";
    private static final String SQL_SELECT_BY_cedula_or_correo = "SELECT idConferencista, cedula, nombre, apellido, correo, telefono "
            + "FROM Conferencista WHERE cedula = ? OR correo = ?";
    private static final String SQL_DELETE = "DELETE FROM Conferencista WHERE idConferencista = ?";

    public int insertar(Conferencista conferencista) {
        PreparedStatement stmt;

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
            ex.printStackTrace(System.out);
        }

        return rows;
    }

    public List<Conferencista> obtenerConferencistas() {
        System.out.println("entraaaaaaaaaa");
        PreparedStatement stmt;
        ResultSet rs;

        List<Conferencista> conferencistas = new ArrayList<>();

        try {
            System.out.println("ejecutarquery");
            stmt = cn.prepareStatement("SELECT idConferencista, cedula, nombre, apellido, correo, telefono FROM Conferencista");
            System.out.println("Ejecutando consulta SQL");
            rs = stmt.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("idConferencista");
                long cedula = rs.getLong("cedula");
                System.out.println(cedula + "cedulaaaaaaaaa");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String correo = rs.getString("correo");
                long telefono = rs.getLong("telefono");

                Conferencista conferencista = new Conferencista();
                conferencista.setId(id);
                conferencista.setCedula(cedula);
                conferencista.setNombre(nombre);
                conferencista.setApellido(apellido);
                conferencista.setCorreo(correo);
                conferencista.setTelefono(telefono);

                conferencistas.add(conferencista);
            }

        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return null;
        }
        return conferencistas;
    }

    public int modificar(Conferencista conferencista) {
        PreparedStatement stmt;

        int rows = 0;
        try {
            stmt = cn.prepareStatement(SQL_UPDATE);
            stmt.setLong(1, conferencista.getCedula());
            stmt.setString(2, conferencista.getNombre());
            stmt.setString(3, conferencista.getApellido());
            stmt.setString(4, conferencista.getCorreo());
            stmt.setLong(5, conferencista.getTelefono());
            stmt.setInt(6, conferencista.getId());

            rows = stmt.executeUpdate();
            System.out.println(rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }

        return rows;
    }

    public Conferencista buscar(Conferencista conferencista) {
        PreparedStatement stmt;
        ResultSet rs;

        try {
            stmt = cn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, conferencista.getId());
            rs = stmt.executeQuery();
            System.out.println(rs);
            if (rs.next()) {
                long cedula = rs.getLong("cedula");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String correo = rs.getString("correo");
                long telefono = rs.getLong("telefono");

                System.out.println(nombre + "Nombrebusquedasirve");
                System.out.println(apellido + "Nombrebusquedasirve");

                conferencista.setCedula(cedula);
                conferencista.setNombre(nombre);
                conferencista.setApellido(apellido);
                conferencista.setCorreo(correo);
                conferencista.setTelefono(telefono);

            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }

        return conferencista;
    }

    public boolean buscarConferencista(Conferencista conferencista) {
        PreparedStatement stmt;
        ResultSet rs;
        boolean existe = false;
        try {
            stmt = cn.prepareStatement(SQL_SELECT_BY_cedula_or_correo);
            stmt.setLong(1, conferencista.getCedula());
            stmt.setString(2, conferencista.getCorreo());
            rs = stmt.executeQuery();
            if (rs.next()) {
                long cedula = rs.getLong("cedula");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String correo = rs.getString("correo");
                long telefono = rs.getLong("telefono");

                conferencista.setCedula(cedula);
                conferencista.setNombre(nombre);
                conferencista.setApellido(apellido);
                conferencista.setCorreo(correo);
                conferencista.setTelefono(telefono);

                existe = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return existe;
    }

    public boolean eliminar(Conferencista conferencista) {
        PreparedStatement stmt;
        boolean eliminado = false;
        try {
            stmt = cn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, conferencista.getId());

            eliminado = stmt.executeUpdate() > 0;
            System.out.println(eliminado);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return eliminado;
    }

}
