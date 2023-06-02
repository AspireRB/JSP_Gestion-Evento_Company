/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import domain.Salon;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import model.SalonDAO;


@WebServlet(name = "SalonController", urlPatterns = {"/SalonController"})
public class SalonController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "editar":
                    this.buscarSalon(request, response);
                    break;
                case "eliminar":
                    this.eliminarSalon(request, response);
                    break;
                default:
                    this.listaSalones(request, response);
            }
        } else {
            this.listaSalones(request, response);
        }
    }
    
    private void listaSalones (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Salon> salon = new SalonDAO().listar();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("listaSalon", salon);
        response.sendRedirect("templates/company/Salones.jsp");
    }  
    
    private void buscarSalon(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int con = Integer.parseInt(request.getParameter("idSalon"));
        Salon salon = new SalonDAO().buscar(new Salon(con));
        HttpSession session = request.getSession();
        session.setAttribute("evento", salon);
        response.sendRedirect("templates/company/modificarSalon.jsp");
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    this.insertarSalon(request, response);
                    break;
                case "modificar":
                    this.modificarSalon(request, response);
                    break;
                default:
                    this.listaSalones(request, response);
            }
        } else {
            this.listaSalones(request, response);
        }
    }
    
    private void insertarSalon (HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {         
        String nombre = request.getParameter("nombre");
        int capacidad = Integer.parseInt(request.getParameter("capacidad"));        
        
        Salon salon = new Salon();
        salon.setNombre(nombre);
        salon.setCapacidad(capacidad);
        
        Salon salon1 = new Salon();
        salon1.setNombre(nombre);
        salon1.setCapacidad(capacidad);
                 
        SalonDAO salonDAO = new SalonDAO();
        boolean salonExistente = salonDAO.buscarSalon(salon1);

        if (salonExistente) {
            System.out.println("Ya existe");
            String mensajeError = "Ya existe un conferencista con esa cedula o correo";
            response.sendRedirect("templates/company/crearEvento.jsp?mensajeError=" + mensajeError);
        } else {
            System.out.println("No existe");
            SalonDAO salonDAO1 = new SalonDAO();
            salonDAO1.insertar(salon);
            this.listaSalones(request, response);
        }
    }
    
    private void modificarSalon(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {        
        int id = Integer.parseInt(request.getParameter("idSalon"));
        String nombre = request.getParameter("nombre");
        int capacidad = Integer.parseInt(request.getParameter("capacidad"));
                
        Salon salon = new Salon(id, nombre, capacidad);
        SalonDAO salonDAO = new SalonDAO();
        salonDAO.modificar(salon);
        this.listaSalones(request, response);
        
    }
    
    private void eliminarSalon(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("idSalon"));
        Salon salon = new Salon(id);
        boolean eliminado = new SalonDAO().eliminar(salon);
        System.out.println("se elimino = " + eliminado);
        this.listaSalones(request, response);
    }
    
}