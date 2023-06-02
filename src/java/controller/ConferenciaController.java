/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import domain.Conferencia;
import domain.Conferencista;
import domain.Empleado;
import domain.Evento;
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
import model.ConferenciaDAO;
import model.ConferencistaDaoJDBC;
import model.EmpleadoDAO;
import model.EventoDAO;

@WebServlet(name = "ConferenciaController", urlPatterns = {"/ConferenciaController"})
public class ConferenciaController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "editar":
                    this.buscarConferencia(request, response);
                    break;
                case "eliminar":
                    this.eliminarConferencia(request, response);
                    break;
                default:
                    this.listaConferencias(request, response);
            }
        } else {
            this.listaConferencias(request, response);
        }
    }
    
    private void listaConferencias (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Conferencia> conferencia = new ConferenciaDAO().listarConferencia();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("listaConferencia", conferencia);
        response.sendRedirect("templates/company/Conferencias.jsp");
    }
    
    private void listaEvento (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Evento> evento = new EventoDAO().listar();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("listaEvento", evento);
        response.sendRedirect("templates/company/Eventos.jsp");
    } 
    
    private void listaSalon (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Salon> salon = new SalonDAO().listar();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("listaEvento", salon);
        response.sendRedirect("templates/company/Salones.jsp");
    } 
    
     private void listaConferencista (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Conferencista> conferencista = new ConferencistaDaoJDBC().listarConferencista();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("listaEvento", conferencista);
        response.sendRedirect("templates/company/Conferencistas.jsp");
    }
    
    private void listaEmpleado (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Empleado> empleado = new EmpleadoDAO().listarEmpleado();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("listaEvento", empleado);
        response.sendRedirect("templates/company/Empleados.jsp");
    } 
    
    private void buscarConferencia(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int con = Integer.parseInt(request.getParameter("idConferencia"));
        Conferencia conferencia = new ConferenciaDAO().buscar(new Conferencia(con));
        HttpSession session = request.getSession();
        session.setAttribute("conferencia", conferencia);
        response.sendRedirect("templates/company/modificarConferencia.jsp");
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    this.insertarConferencia(request, response);
                    break;
                case "modificar":
                    this.modificarConferencia(request, response);
                    break;
                default:
                    this.listaConferencias(request, response);
            }
        } else {
            this.listaConferencias(request, response);
        }
    }
    
    private void insertarConferencia (HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException, ParseException { 
        SimpleDateFormat formatter_date = new SimpleDateFormat("yyyy-mm-dd");
        SimpleDateFormat formatter_time = new SimpleDateFormat("hh:mm:ss");
        
        String nombre = request.getParameter("nombre");
        String fechaI = request.getParameter("fecha");
        Date fecha = formatter_date.parse(fechaI);
        String horaI = request.getParameter("horaInicio");
        Date horaInicio = formatter_time.parse(horaI);
        String horaF = request.getParameter("horaFin");
        Date horaFin = formatter_date.parse(horaF);
        
        Conferencia conferencia = new Conferencia();
        conferencia.setNombre(nombre);
        conferencia.setFecha(fecha);
        conferencia.setHoraInicio(horaInicio);
        conferencia.setHoraFin(horaFin);
        
        Conferencia conferencia1 = new Conferencia();
        conferencia1.setNombre(nombre);
        conferencia1.setFecha(fecha);
        conferencia1.setHoraInicio(horaInicio);
        conferencia1.setHoraFin(horaFin);
                 
        ConferenciaDAO conferenciaDAO = new ConferenciaDAO();
        boolean conferenciaExistente = conferenciaDAO.buscarConferencia(conferencia1);

        if (conferenciaExistente) {
            System.out.println("Ya existe");
            String mensajeError = "Ya existe un conferencista con esa cedula o correo";
            response.sendRedirect("templates/company/crearConferencia.jsp?mensajeError=" + mensajeError);
        } else {
            System.out.println("No existe");
            ConferenciaDAO conferenciaDAO1 = new ConferenciaDAO();
            conferenciaDAO1.insertar(conferencia);
            this.listaConferencias(request, response);
        }
    }
    
    private void modificarConferencia(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        SimpleDateFormat formatter_date = new SimpleDateFormat("yyyy-mm-dd");
        SimpleDateFormat formatter_time = new SimpleDateFormat("hh:mm:ss");
         
        int id = Integer.parseInt(request.getParameter("idConferencia"));
        String nombre = request.getParameter("nombre");
        String fechaI = request.getParameter("fecha");
        Date fecha = formatter_date.parse(fechaI);
        String horaI = request.getParameter("horaInicio");
        Date horaInicio = formatter_time.parse(horaI);
        String horaF = request.getParameter("horaFin");
        Date horaFin = formatter_date.parse(horaF);
        int idEvento = Integer.parseInt(request.getParameter("Evento_idEvento"));
        int idSalon = Integer.parseInt(request.getParameter("Salon_idSalon"));
        int idConferencista = Integer.parseInt(request.getParameter("Conferencista_idConferencista"));
        int idEmpleado = Integer.parseInt(request.getParameter("Empleado_idEmpleado"));
                
        Conferencia conferencia = new Conferencia(id, nombre, fecha, horaInicio, horaFin, idEvento, idSalon,idConferencista, idEmpleado);
        ConferenciaDAO conferenciaDAO = new ConferenciaDAO();
        conferenciaDAO.modificar(conferencia);
        this.listaConferencias(request, response);
        
    }
    
    private void eliminarConferencia(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("idConferencia"));
        Conferencia conferencia = new Conferencia(id);
        boolean eliminado = new ConferenciaDAO().eliminar(conferencia);
        System.out.println("se elimino = " + eliminado);
        this.listaConferencias(request, response);
    }

}