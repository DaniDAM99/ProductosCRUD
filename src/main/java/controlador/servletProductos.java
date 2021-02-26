/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Productos;
import modelo.ProductosCRUD;

/**
 *
 * @author Cristian
 */
public class servletProductos extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet servletProductos</title>");            
            out.println("</head>");
            out.println("<body>");
            
            out.println("<h1>Servlet servletProductos at " + request.getContextPath() + "</h1>");
            
            List<Productos> productos = ProductosCRUD.getProductos();
            
            for (Productos producto : productos) {
                out.println("<p>" + producto.getNombre() + "<p>");
            }
            
            ProductosCRUD.actualizaProducto();
            ProductosCRUD.actualizaProducto2();
           
            Productos prod = new Productos();
            prod.setId(11);
            prod.setNombre("Tarta de fresa");
            prod.setImagen("tarta.jpg");
            prod.setCategoria("Postres");
            prod.setPrecio(6.0f);
            ProductosCRUD.actualizaProducto(prod);
            ProductosCRUD.insertaProducto();
            
            Productos prod2 = new Productos();
            prod2.setId(14);
            prod2.setNombre("Donut");
            prod2.setCategoria("postre");
            prod2.setImagen("donut.png");
            prod2.setPrecio(1.99f);
            
            ProductosCRUD.insertaProducto(prod2);
            
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
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
