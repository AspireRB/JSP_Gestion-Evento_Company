<%-- 
    Document   : guardarDB
    Created on : 23 may. 2023, 21:39:36
    Author     : Lytos
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>

<%
    // Recibir los datos del formulario
    String nombre = request.getParameter("nombre");
    String apellido = request.getParameter("apellido");
    String cedula = request.getParameter("cedula");
    String telefono = request.getParameter("telefono");
    String correo = request.getParameter("correo");

    // Realizar las operaciones de conexión y guardar en la base de datos
    Connection conn = null;
    PreparedStatement stmt = null;
    try {
        // Establecer la conexión a la base de datos
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_evento", "root", "root");

        // Crear la consulta SQL para insertar los datos en la tabla correspondiente
        String sql = "INSERT INTO cliente (nombre, apellido, cedula, telefono, correo) VALUES (?, ?, ?, ?, ?)";
        stmt = conn.prepareStatement(sql);

        // Asignar los valores a los parámetros de la consulta
        stmt.setString(1, nombre);
        stmt.setString(2, apellido);
        stmt.setString(3, cedula);
        stmt.setString(4, telefono);
        stmt.setString(5, correo);

        // Ejecutar la consulta
        stmt.executeUpdate();

        // Redireccionar al usuario a una página de éxito o mostrar un mensaje de éxito
        response.sendRedirect("exito.jsp");
    } catch (Exception e) {
        e.printStackTrace();
        // Mostrar un mensaje de error o redireccionar a una página de error
        response.sendRedirect("error.jsp");
    } finally {
        // Cerrar la conexión y liberar los recursos
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
%>




