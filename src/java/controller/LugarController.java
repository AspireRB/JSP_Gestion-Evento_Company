/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import domain.Ciudad;
import domain.Lugar;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.CiudadDAO;
import model.LugarDAO;


@WebServlet(name = "LugarController", urlPatterns = {"/LugarController"})
public class LugarController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "editar":
                    this.buscarLugar(request, response);
                    break;
                case "eliminar":
                    this.eliminarLugar(request, response);
                    break;
                default:
                    this.listaLugares(request, response);
            }
        } else {
            this.listaLugares(request, response);
        }
    }
    
    private void listaLugares (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Lugar> lugar = new LugarDAO().listar();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("listaLugar", lugar);
        response.sendRedirect("templates/company/Lugares.jsp");
    }
    
    private void listaCiudad (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Ciudad> ciudad = new CiudadDAO().listar();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("listaCiudad", ciudad);
        response.sendRedirect("templates/company/Ciudades.jsp");
    } 
    
    private void buscarLugar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int con = Integer.parseInt(request.getParameter("idSalon"));
        Lugar lugar = new LugarDAO().buscar(new Lugar(con));
        HttpSession session = request.getSession();
        session.setAttribute("lugar", lugar);
        response.sendRedirect("templates/company/modificarSalon.jsp");
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    this.insertarLugar(request, response);
                    break;
                case "modificar":
                    this.modificarLugar(request, response);
                    break;
                default:
                    this.listaLugares(request, response);
            }
        } else {
            this.listaLugares(request, response);
        }
    }
    
    private void insertarLugar (HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {         
        String nombre = request.getParameter("nombre");
        int  ciudad = Integer.parseInt(request.getParameter("Ciudad_idCiudad"));        
        
        Lugar lugar = new Lugar();
        lugar.setNombre(nombre);
        lugar.setCiudad_idCiudad(ciudad);
        
        Lugar lugar1 = new Lugar();
        lugar1.setNombre(nombre);
        lugar1.setCiudad_idCiudad(ciudad);
                 
        LugarDAO lugarDAO = new LugarDAO();
        boolean lugarExistente = lugarDAO.buscarLugar(lugar1);

        if (lugarExistente) {
            System.out.println("Ya existe");
            String mensajeError = "Ya existe un conferencista con esa cedula o correo";
            response.sendRedirect("templates/company/crearSalon.jsp?mensajeError=" + mensajeError);
        } else {
            System.out.println("No existe");
            LugarDAO lugarDAO1 = new LugarDAO();
            lugarDAO1.insertar(lugar);
            this.listaLugares(request, response);
        }
    }
    
    private void modificarLugar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {        
        int id = Integer.parseInt(request.getParameter("idLugar"));
        String nombre = request.getParameter("nombre");
        int  Ciudad_idCiudad = Integer.parseInt(request.getParameter("Ciudad_idCiudad")); 
                
        Lugar lugar = new Lugar(id, nombre, Ciudad_idCiudad);
        LugarDAO lugarDAO = new LugarDAO();
        lugarDAO.modificar(lugar);
        this.listaLugares(request, response);
        
    }
    
    private void eliminarLugar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("idLugar"));
        Lugar lugar = new Lugar(id);
        boolean eliminado = new LugarDAO().eliminar(lugar);
        System.out.println("se elimino = " + eliminado);
        this.listaLugares(request, response);
    }
    
}