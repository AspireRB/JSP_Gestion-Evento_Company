package controller;

import domain.Empleado;
import domain.Evento;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import javax.swing.JOptionPane;

import model.EmpleadoDAO;
import model.EventoDAO;

/**
 *
 * @author Juan Guevara
 */

@WebServlet(name = "SesionController", urlPatterns = {"/SesionController"})
public class SesionController extends HttpServlet {

	/**
     * @param request
     * @param response
     * @throws jakarta.servlet.ServletException
     * @throws java.io.IOException
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
        @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            
            HttpSession sesion;
            
            if("cerrar".equals(request.getParameter("accion"))){
                sesion=request.getSession();
                sesion.setAttribute("usuario", null);
                sesion.invalidate();
                response.sendRedirect("templates/company/ingresar.jsp");
            }else if (request.getParameter("btnLogin") != null) {
                
                String correo = request.getParameter("mail");
                String clave = request.getParameter("pass");

                Empleado usuario;
                EmpleadoDAO uc;

                usuario = new Empleado(correo, clave);
                uc = new EmpleadoDAO();
                usuario = uc.logIn(usuario);
                if (usuario != null) {
                    sesion=request.getSession();
                    sesion.setAttribute("usuario", usuario);                    
                    response.sendRedirect("EventoController");
                } else {
                    request.setAttribute("msg", "Credenciales incorrectas");
                    response.sendRedirect("templates/company/ingresar.jsp");
                }

            }
            response.getWriter().append("Served at: ").append(request.getContextPath());
	}
                
	/**
     * @param request
     * @param response
     * @throws jakarta.servlet.ServletException
     * @throws java.io.IOException
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
        @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}