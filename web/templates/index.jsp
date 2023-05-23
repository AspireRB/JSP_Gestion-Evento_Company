<%@page import="config.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Conexion con SQL Workbench</title>
    </head>
    <body>
        <h1>Conexion</h1>
        <%
            try{
                Conexion conexion = new Conexion();
                out.write("Conexion exitosa");
            }catch(Exception error){
                out.write("Ha ocurrido un error, "+error.getMessage());
            }
        %>
    </body>
</html>
