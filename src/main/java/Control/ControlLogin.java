/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Control;

import DAO.ClienteDAO;
import Interfaces.ICliente;
import Modelo.Cliente;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

/**
 *
 * @author vivia
 */
@WebServlet(name = "ControlLogin", urlPatterns = {"/ControlLogin"})
public class ControlLogin extends HttpServlet {
    private final ICliente clienteDAO = new ClienteDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("accion");
        HttpSession session = request.getSession();

        switch (accion) {
            case "Login":
                String usuario = request.getParameter("usuario");
                String contrasena = request.getParameter("contrasena");
                Cliente c = clienteDAO.getClienteUsuarioContrasena(usuario, contrasena);
                if (c != null) {
                    session.setAttribute("Cliente", c);
                    if (c.getPerfil().equals("ADMINISTRADOR")) {
                        request.getRequestDispatcher("Controlador?menu=Principal").forward(request, response);
                    } else {
                        request.setAttribute("Mensaje", "El Perfil no es Administrador");
                        request.getRequestDispatcher("mensaje.jsp").forward(request, response);
                    }
                } else {
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
                break;
            case "Salir":
                session.setAttribute("Cliente", new Cliente());
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;
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
