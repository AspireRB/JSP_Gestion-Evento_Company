/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import domain.Conferencia;
import domain.Material;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import model.ConferenciaDAO;
import model.MaterialDAO;

/**
 *
 * @author DANIELA
 */
@MultipartConfig
public class MaterialController extends HttpServlet {

    private final String folderName = "MATERIAL";
    private File uploads;

    @Override
    public void init() throws ServletException {
        super.init();

        String appPath = getServletContext().getRealPath("");
        String folderPath = appPath + File.separator + folderName;

        uploads = new File(folderPath);
        System.out.println(uploads + "uploads que tiene");
        if (!uploads.exists()) {
            uploads.mkdirs();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "nuevo":
                    this.listaConferencias(request, response);
                    break;
                case "ver":
                    this.verMaterial(request, response);
                    break;
                case "editar":
                    System.out.println("ENTRO AL BUSCAR");
                    this.buscarMaterial(request, response);
                    break;
                case "eliminar":
                    this.eliminarMaterial(request, response);
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

    private void listaConferenciasSinDirigir(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Conferencia> conferencia = new ConferenciaDAO().listarConferencia();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("listaConferencia", conferencia);
        System.out.println("conferencia");
        System.out.println(conferencia.get(0).getNombre());
    }

    private void buscarMaterial(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int con = Integer.parseInt(request.getParameter("idMaterial"));
        Material material = new MaterialDAO().buscar(new Material(con));

        HttpSession session = request.getSession();
        session.setAttribute("material", material);
        System.out.println("idddddd" + con);
        System.out.println("el material" + material);
        this.listaConferenciasSinDirigir(request, response);

        response.sendRedirect("templates/company/modificarMaterial.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");
        System.out.println(accion + "QUE ACCION ENTRA");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    System.out.println("entro a insertar post");
                    this.insertarMaterial(request, response);
                    break;
                case "modificar":
                    System.out.println("ENTRO A MODIFICAR");
                    this.modificarMaterial(request, response);
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
                System.out.println("No seleccionó ningún archivo");
            } else {
                String rutaCompleta = guardarArchivo(filePart, uploads);
                String relativa = folderName + "/" + rutaCompleta; 

                System.out.println(rutaCompleta + " RUTA COMPLETA");

                MaterialDAO materialDAO = new MaterialDAO();

                if (materialDAO.buscarRuta(relativa)) {
                    String mensajeError = "El archivo ya existe. No se puede insertar nuevamente.";
                    request.setAttribute("error", mensajeError);
                    response.sendRedirect("templates/company/crearMaterial.jsp?mensajeError=" + mensajeError);
                    return;
                }

                Material material = new Material(nombre, descripcion, relativa, conferencia);
                materialDAO.insertar(material);
            }
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }

        this.listaMaterial(request, response);
    }

    private String guardarArchivo(Part part, File referenciaRutaArchivo) {
        String rutaCompleta = "";

        try {
            String nombreArchivo = Paths.get(part.getSubmittedFileName()).getFileName().toString();
            InputStream inputStream = part.getInputStream();
            if (inputStream != null) {
                File archivo = new File(referenciaRutaArchivo, nombreArchivo);
                rutaCompleta = archivo.getName();
                Files.copy(inputStream, archivo.toPath());
            }
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }

        return rutaCompleta;
    }

    private void verMaterial(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rutaArchivo = request.getParameter("ruta");
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "inline; filename=material.pdf");

        String appPath = getServletContext().getRealPath("");
        String rutaCompleta = appPath + File.separator + rutaArchivo;

        try (InputStream inputStream = new FileInputStream(rutaCompleta); OutputStream outputStream = response.getOutputStream()) {

            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        }
    }

    private void modificarMaterial(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idMaterial = Integer.parseInt(request.getParameter("idMaterial"));
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        int conferencia = Integer.parseInt(request.getParameter("conferencia"));
        Part filePart = request.getPart("archivo");
        

        String rutaCompleta = guardarArchivo(filePart, uploads);
        String relativa = folderName + "/" + rutaCompleta; 

        System.out.println(rutaCompleta + " RUTA COMPLETA");

        Material material = new Material(idMaterial, nombre, descripcion, relativa, conferencia);
        MaterialDAO materialDAO = new MaterialDAO();
        int valor = materialDAO.modificar(material);
        System.out.println(valor + "Se modifico");
        this.listaMaterial(request, response);

    }

    private void eliminarMaterial(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idMaterial = Integer.parseInt(request.getParameter("idMaterial"));
        Material material = new Material(idMaterial);
        boolean eliminado = new MaterialDAO().eliminar(material);
        System.out.println("se elimino = " + eliminado);
        this.listaMaterial(request, response);
    }

}
