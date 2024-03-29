/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.service;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import framework.database.utilitaire.GConnection;
import java.sql.Connection;
import model.service.Service;
import java.util.ArrayList;
import java.sql.Date;
import model.service.TypeService;

/**
 *
 * @author ITU
 */
public class ServiceController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        Connection connex = null;
        try {
            connex = GConnection.getSimpleConnection();
            TypeService service = new TypeService();
            ArrayList<TypeService> allService = service.findAll(connex);
            request.setAttribute("listeService", allService);
            
        } catch (Exception exe) {
            //out.println(exe.getMessage());
            request.setAttribute("erreur",exe.getMessage());
        }
        RequestDispatcher dispat = request.getRequestDispatcher("./pages/service.jsp");
        dispat.forward(request, response);
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
        PrintWriter out = response.getWriter();
        Connection connex = null;
        try {
            connex = GConnection.getSimpleConnection();
            
            String nomClient = request.getParameter("nom_client");

            Date dateService = Date.valueOf(request.getParameter("date"));

            int id_type_Service = Integer.valueOf(request.getParameter("service"));

            Service service = new Service(id_type_Service, nomClient, dateService);

            service.create(connex);

            request.setAttribute("message", "insertion reussie");
        } catch (Exception exe) {
            //String message = exe.getMessage();
            //out.println(exe.getMessage());
            exe.printStackTrace();
            request.setAttribute("erreur", exe.getMessage());
        }
        doGet(request, response);
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
