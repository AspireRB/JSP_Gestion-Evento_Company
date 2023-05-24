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
import model.ConferencistaDaoJDBC;

/**
 *
 * @author DANIELA
 */
public class ConferenController extends HttpServlet {

    protected void processRequest(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response)
            throws jakarta.servlet.ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EventoController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EventoController at " + request.getContextPath() + "</h1>");
            long cedula = (long) request.getAttribute("cedula");
            String nombre = (String) request.getAttribute("nombre");
            String apellido = (String) request.getAttribute("apellido");
            String correo = (String) request.getAttribute("correo");
            long telefono = (long) request.getAttribute("telefono");

            out.println("<p>Cédula: " + cedula + nombre + apellido + correo + telefono + "</p>");

            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        long cedula = Long.parseLong(request.getParameter("cedula"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String correo = request.getParameter("correo");
        long telefono = Long.parseLong(request.getParameter("telefono"));

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

        processRequest(request, response);

    }

}
