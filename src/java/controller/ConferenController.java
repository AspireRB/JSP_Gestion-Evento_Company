/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import domain.Conferencista;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import model.ConferencistaDaoJDBC;

/**
 *
 * @author DANIELA
 */
public class ConferenController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("guardar") != null) {

            long cedula = Long.parseLong(request.getParameter("cedula"));
            String cedulaString = String.valueOf(cedula);
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String correo = request.getParameter("correo");
            long telefono = Long.parseLong(request.getParameter("telefono"));
            String telefonoString = String.valueOf(cedula);

            if ( cedulaString.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || correo.isEmpty() || telefonoString.isEmpty()) {
                response.sendRedirect("templates/company/CrearConferencista.jsp");


            } else {
                request.setAttribute("cedula", cedula);
                request.setAttribute("nombre", nombre);
                request.setAttribute("apellido", apellido);
                request.setAttribute("correo", correo);
                request.setAttribute("telefono", telefono);

                Conferencista conferencista = new Conferencista();
                conferencista.setCedula(cedula);
                conferencista.setNombre(nombre);
                conferencista.setApellido(apellido);
                conferencista.setCorreo(correo);
                conferencista.setTelefono(telefono);

                ConferencistaDaoJDBC conferencistaDao = new ConferencistaDaoJDBC();
                conferencistaDao.insertar(conferencista);
                response.sendRedirect("templates/company/Conferencistas.jsp");
            }

        }

    }

}
