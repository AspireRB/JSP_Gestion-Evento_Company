/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import domain.Ciudad;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.CiudadDAO;


@WebServlet(name = "CiudadController", urlPatterns = {"/CiudadController"})
public class CiudadController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "editar":
                    this.buscarCiudad(request, response);
                    break;
                case "eliminar":
                    this.eliminarCiudad(request, response);
                    break;
                default:
                    this.listaCiudades(request, response);
            }
        } else {
            this.listaCiudades(request, response);
        }
    }
    
    private void listaCiudades (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Ciudad> ciudad = new CiudadDAO().listar();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("listaCiudad", ciudad);
        response.sendRedirect("templates/company/Ciudades.jsp");
    }  
    
    private void buscarCiudad(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int con = Integer.parseInt(request.getParameter("idCiudad"));
        Ciudad ciudad = new CiudadDAO().buscar(new Ciudad(con));
        HttpSession session = request.getSession();
        session.setAttribute("ciudad", ciudad);
        response.sendRedirect("templates/company/modificarCiudad.jsp");
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    this.insertarCiudad(request, response);
                    break;
                case "modificar":
                    this.modificarCiudad(request, response);
                    break;
                default:
                    this.listaCiudades(request, response);
            }
        } else {
            this.listaCiudades(request, response);
        }
    }
    
    private void insertarCiudad (HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {         
        String nombre = request.getParameter("nombre");              
        
        Ciudad ciudad = new Ciudad();
        ciudad.setNombre(nombre);
        
        Ciudad ciudad1 = new Ciudad();
        ciudad1.setNombre(nombre);
                 
        CiudadDAO ciudadDAO = new CiudadDAO();
        boolean salonExistente = ciudadDAO.buscarSalon(ciudad1);

        if (salonExistente) {
            System.out.println("Ya existe");
            String mensajeError = "Ya existe un conferencista con esa cedula o correo";
            response.sendRedirect("templates/company/crearCiudad.jsp?mensajeError=" + mensajeError);
        } else {
            System.out.println("No existe");
            CiudadDAO ciudadDAO1 = new CiudadDAO();
            ciudadDAO1.insertar(ciudad);
            this.listaCiudades(request, response);
        }
    }
    
    private void modificarCiudad(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {        
        int id = Integer.parseInt(request.getParameter("idCiudad"));
        String nombre = request.getParameter("nombre");
                
        Ciudad ciudad = new Ciudad(id, nombre);
        CiudadDAO ciudadDAO = new CiudadDAO();
        ciudadDAO.modificar(ciudad);
        this.listaCiudades(request, response);
        
    }
    
    private void eliminarCiudad(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("idCiudad"));
        Ciudad ciudad = new Ciudad(id);
        boolean eliminado = new CiudadDAO().eliminar(ciudad);
        System.out.println("se elimino = " + eliminado);
        this.listaCiudades(request, response);
    }
    
}