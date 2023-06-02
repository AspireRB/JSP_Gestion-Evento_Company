/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import domain.Cliente;
import domain.Conferencista;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.ClienteDAO;
import model.ConferencistaDaoJDBC;

/**
 *
 * @author Juan Guevara
 */
@WebServlet(name = "ClienteController", urlPatterns = {"/ClienteController"})
public class ClienteController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "editar":
                    this.buscarConferencista(request, response);
                    break;
                case "eliminar":
                    this.eliminarConferencista(request, response);
                    break;
                default:
                    this.listarClientesEvento(request, response);
            }
        } else {
            this.listarClientesEvento(request, response);
        }
    }

    private void listaConferencistas(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Conferencista> conferencista = new ConferencistaDaoJDBC().obtenerConferencistas();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("listaconferencista", conferencista);
        response.sendRedirect("templates/company/Conferencistas.jsp");
    }

    private void buscarConferencista(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int con = Integer.parseInt(request.getParameter("idConferencista"));
        Conferencista conferencista = new ConferencistaDaoJDBC().buscar(new Conferencista(con));

        HttpSession session = request.getSession();
        session.setAttribute("conferencista", conferencista);
        System.out.println("idddddd" + con);
        System.out.println("el cof¿nfer" + conferencista);
        response.sendRedirect("templates/company/modificarConferencista.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    System.out.println("entro a insertar post");
                    this.insertarConferencista(request, response);
                    break;
                case "modificar":
                    System.out.println("entro al modificar");
                    this.modificarConferencista(request, response);
                    break;

                default:
                    this.listaConferencistas(request, response);
            }
        } else {
            System.out.println("es null");
            this.listaConferencistas(request, response);
        }
    }

    private void insertarConferencista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long cedula = Long.parseLong(request.getParameter("cedula"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String correo = request.getParameter("correo");
        long telefono = Long.parseLong(request.getParameter("telefono"));

        Conferencista conferencista = new Conferencista();
        conferencista.setCedula(cedula);
        conferencista.setNombre(nombre);
        conferencista.setApellido(apellido);
        conferencista.setCorreo(correo);
        conferencista.setTelefono(telefono);

        Conferencista conferencista1 = new Conferencista();
        conferencista1.setCedula(cedula);
        conferencista1.setCorreo(correo);
        ConferencistaDaoJDBC conferencistaDaoJDBC = new ConferencistaDaoJDBC();
        boolean conferencistaExistente = conferencistaDaoJDBC.buscarConferencista(conferencista1);

        if (conferencistaExistente) {
            System.out.println("Ya existe");
            String mensajeError = "Ya existe un conferencista con esa cedula o correo";
            response.sendRedirect("templates/company/CrearConferencista.jsp?mensajeError=" + mensajeError);
        } else {
            System.out.println("No existe");
            ConferencistaDaoJDBC conferencistaDao = new ConferencistaDaoJDBC();
            conferencistaDao.insertar(conferencista);
            this.listaConferencistas(request, response);
        }
    }

    private void modificarConferencista(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idConferencista = Integer.parseInt(request.getParameter("idConferencista"));
        long cedula = Long.parseLong(request.getParameter("cedula"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String correo = request.getParameter("correo");
        long telefono = Long.parseLong(request.getParameter("telefono"));

        Conferencista conferencista = new Conferencista(idConferencista, cedula, nombre, apellido, correo, telefono);
        ConferencistaDaoJDBC conferencistaDaoJDBC = new ConferencistaDaoJDBC();
        conferencistaDaoJDBC.modificar(conferencista);
        this.listaConferencistas(request, response);

    }

    private void eliminarConferencista(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idConferencista = Integer.parseInt(request.getParameter("idConferencista"));
        Conferencista conferencista = new Conferencista(idConferencista);
        boolean eliminado = new ConferencistaDaoJDBC().eliminar(conferencista);
        System.out.println("se elimino = " + eliminado);
        this.listaConferencistas(request, response);
    }

    private void listarClientesEvento(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idEvento = Integer.parseInt(request.getParameter("idEvento"));
        List<Cliente> clientes = new ClienteDAO().listarClientesEvento(idEvento);
        HttpSession sesion = request.getSession();
        sesion.setAttribute("listaclientes", clientes);
        response.sendRedirect("templates/company/Clientes.jsp");
    }

}
