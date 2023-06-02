/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

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
import model.EventoDAO;

@WebServlet(name = "EventoController", urlPatterns = {"/EventoController"})
public class EventoController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "editar":
                    this.buscarEvento(request, response);
                    break;
                case "eliminar":
                    this.eliminarEvento(request, response);
                    break;
                default:
                    this.listaEventos(request, response);
            }
        } else {
            this.listaEventos(request, response);
        }
    }
    
    private void listaEventos (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Evento> evento = new EventoDAO().listar();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("listaEvento", evento);
        response.sendRedirect("templates/company/Eventos.jsp");
    }
    
    private void listaEmpleado (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Empleado> empleado = new EmpleadoDAO().listarEmpleado();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("listaEvento", empleado);
        response.sendRedirect("templates/company/crearEvento.jsp");
    }
    
    private void listaLugar (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Lugar> lugar = new LugarDAO().listar();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("listaEvento", lugar);
        response.sendRedirect("templates/company/crearEvento.jsp");
    }
    
    private void buscarEvento(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int con = Integer.parseInt(request.getParameter("idEvento"));
        Evento evento = new EventoDAO().buscar(new Evento(con));
        HttpSession session = request.getSession();
        session.setAttribute("evento", evento);
        response.sendRedirect("templates/company/modificarEvento.jsp");
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    this.insertarEvento(request, response);
                    break;
                case "modificar":
                    this.modificarEvento(request, response);
                    break;
                default:
                    this.listaEventos(request, response);
            }
        } else {
            this.listaEventos(request, response);
        }
    }
    
    private void insertarEvento (HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException, ParseException { 
        SimpleDateFormat formatter_date = new SimpleDateFormat("yyyy-mm-dd");
        SimpleDateFormat formatter_time = new SimpleDateFormat("hh:mm:ss");
        
        String nombre = request.getParameter("nombre");
        String fechaI = request.getParameter("fechaInicio");
        Date fechaInicio = formatter_date.parse(fechaI);
        String horaI = request.getParameter("horaInicio");
        Date horaInicio = formatter_time.parse(horaI);
        String fechaF = request.getParameter("fechaFin");
        Date fechaFin = formatter_date.parse(fechaF);
        String horaF = request.getParameter("horaFin");
        Date horaFin = formatter_date.parse(horaF);
        String descripcion = request.getParameter("descripcion");
        Double costo = Double.parseDouble(request.getParameter("costo"));
        String estado = request.getParameter("estado");
        
        Evento evento = new Evento();
        evento.setNombre(nombre);
        evento.setFechaInicio(fechaInicio);
        evento.setHoraInicio(horaInicio);
        evento.setFechaFin(fechaFin);
        evento.setHoraFin(horaFin);
        evento.setDescripcion(descripcion);
        evento.setCosto(costo);
        evento.setEstado(estado);
        
        Evento evento1 = new Evento();
        evento1.setNombre(nombre);
        evento1.setFechaInicio(fechaInicio);
        evento1.setHoraInicio(horaInicio);
        evento1.setFechaFin(fechaFin);
        evento1.setHoraFin(horaFin);
        evento1.setDescripcion(descripcion);
        evento1.setCosto(costo);
        evento1.setEstado(estado);  
        
        EventoDAO eventoDAO = new EventoDAO();
        boolean eventoExistente = eventoDAO.buscarEvento(evento1);

        if (eventoExistente) {
            System.out.println("Ya existe");
            String mensajeError = "Ya existe un conferencista con esa cedula o correo";
            response.sendRedirect("templates/company/crearEvento.jsp?mensajeError=" + mensajeError);
        } else {
            System.out.println("No existe");
            EventoDAO eventoDAO1 = new EventoDAO();
            eventoDAO1.insertar(evento);
            this.listaEventos(request, response);
        }
    }
    
    private void modificarEvento(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        SimpleDateFormat formatter_date = new SimpleDateFormat("yyyy-mm-dd");
        SimpleDateFormat formatter_time = new SimpleDateFormat("hh:mm:ss");
         
        int id = Integer.parseInt(request.getParameter("idEvento"));
        String nombre = request.getParameter("nombre");
        String fechaI = request.getParameter("fechaInicio");
        Date fechaInicio = formatter_date.parse(fechaI);
        String horaI = request.getParameter("horaInicio");
        Date horaInicio = formatter_time.parse(horaI);
        String fechaF = request.getParameter("fechaFin");
        Date fechaFin = formatter_date.parse(fechaF);
        String horaF = request.getParameter("horaFin");
        Date horaFin = formatter_date.parse(horaF);
        String descripcion = request.getParameter("descripcion");
        Double costo = Double.parseDouble(request.getParameter("costo"));
        String estado = request.getParameter("estado");
        int idEmpleado = Integer.parseInt(request.getParameter("Empleado_idEmpleado"));
        int idLugar = Integer.parseInt(request.getParameter("Lugar_idLugar"));
        
        Evento evento = new Evento(id, nombre, fechaInicio, horaInicio, fechaFin, horaFin, descripcion, costo, estado, idEmpleado, idLugar);
        EventoDAO eventoDAO = new EventoDAO();
        eventoDAO.modificar(evento);
        this.listaEventos(request, response);
        
    }
    
    private void eliminarEvento(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("idEvento"));
        Evento evento = new Evento(id);
        boolean eliminado = new EventoDAO().eliminar(evento);
        System.out.println("se elimino = " + eliminado);
        this.listaEventos(request, response);
    }
    
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
