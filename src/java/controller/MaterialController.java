/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import domain.Conferencia;
import domain.Conferencista;
import domain.Material;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import model.ConferenciaDAO;
import model.ConferencistaDaoJDBC;
import model.MaterialDAO;

/**
 *
 * @author DANIELA
 */
@MultipartConfig
public class MaterialController extends HttpServlet {

    private final String file = "C:\\Users\\DANIELA\\Documents\\NetBeansProjects\\JSP_Gestion-Evento_Company\\web\\MATERIAL\\";
    private final File uploads = new File(file);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "nuevo":
                    this.listaConferencias(request, response);
                    break;
                case "eliminar":

                    break;
                default:
                    this.listaMaterial(request, response);
            }
        } else {
            this.listaMaterial(request, response);
        }
    }

    private void listaMaterial(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Material> material = new MaterialDAO().listarMaterial();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("listaMaterial", material);
        response.sendRedirect("templates/company/Material.jsp");
    }

    private void listaConferencias(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Conferencia> conferencia = new ConferenciaDAO().listarConferencia();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("listaConferencia", conferencia);
        System.out.println("conferencia");
        System.out.println(conferencia.get(0).getNombre());
        response.sendRedirect("templates/company/crearMaterial.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    System.out.println("entro a insertar post");
                    this.insertarMaterial(request, response);
                    break;
                case "modificar":
                    System.out.println("entro al modificar");
                    break;

                default:
                    this.listaMaterial(request, response);
            }
        } else {
            System.out.println("es null");
            this.listaMaterial(request, response);
        }
    }

    private void insertarMaterial(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        

        try {
            String nombre = request.getParameter("nombre");
            String descripcion = request.getParameter("descripcion");
            int conferencia = Integer.parseInt(request.getParameter("conferencia"));
            Part filePart = request.getPart("archivo");
            
            if (filePart == null) {
                System.out.println("No selecciono ningun archivo");
                               
            }else{
                String rutapdf = guardarArchivo(filePart, uploads);
                Material material = new Material(nombre, descripcion, rutapdf, conferencia);
                MaterialDAO materialDAO = new MaterialDAO();
                materialDAO.insertar(material);
                        
            }
           

        } catch (IOException e) {
            e.printStackTrace(System.err);
        }

        // Redireccionar al listado de materiales
        this.listaMaterial(request, response);
    }

    private String guardarArchivo(Part part, File referenciaRutaArchivo) {
        String rutaAbsoluta = "";

        try {
            Path path = Paths.get(part.getSubmittedFileName());
            String nombreArchivo = path.getFileName().toString();
            InputStream inputStream = part.getInputStream();

            if (inputStream != null) {
                File archivo = new File(referenciaRutaArchivo, nombreArchivo);
                rutaAbsoluta = archivo.getAbsolutePath();
                Files.copy(inputStream, archivo.toPath());

            }
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }

        return rutaAbsoluta;
    }

}
