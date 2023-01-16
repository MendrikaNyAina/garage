/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.employe;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import framework.database.utilitaire.GConnection;
import model.employe.EmployeSpecialite;
import model.employe.Specialite;
import model.Genre;
import java.util.ArrayList;
import java.sql.Date;
import javax.servlet.RequestDispatcher;
import model.employe.Employe;
import model.employe.NiveauEtude;
/**
 *
 * @author ITU
 */
public class EmployeCreateController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
  protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException  { 
        res.setContentType("text/plain");
        PrintWriter out = res.getWriter();
        Connection connex = null;
       try {
                connex = GConnection.getSimpleConnection();
                Specialite specialite = new Specialite();
                Genre genre = new Genre();
                NiveauEtude niveau = new NiveauEtude();
                ArrayList<Specialite> allSp = specialite.findAll(connex);
                ArrayList<Genre> allGr = genre.findAll(connex);
                ArrayList<NiveauEtude> allNv = niveau.findAll(connex);
                req.setAttribute("listeSpecialite",allSp);
                req.setAttribute("listeGenre",allGr);
                req.setAttribute("listeNiveau",allNv);
                
                RequestDispatcher dispat = req.getRequestDispatcher("pages/create_employe.jsp");
                dispat.forward(req,res);
       }catch(Exception exe){
           exe.printStackTrace();
            out.println(exe.getMessage());
            req.setAttribute("erreur", exe.getMessage());
       }
    }
     protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException  { 
        res.setContentType("text/plain");
        PrintWriter out = res.getWriter();
        Connection connex = null;
       try {
                connex = GConnection.getSimpleConnection();
                String nom = req.getParameter("nom");
                String prenom = req.getParameter("prenom");
                Date date_naissance = Date.valueOf(req.getParameter("date_naissance"));
                Date date_embauche = Date.valueOf(req.getParameter("date_embauche"));
                double salary = Double.parseDouble(req.getParameter("salaire"));
                String[] specialite = req.getParameterValues("specialite");
                int genre = Integer.valueOf(req.getParameter("Genre"));
                EmployeSpecialite empSp = new EmployeSpecialite();
                EmployeSpecialite[] liste = empSp.createEmpSpecialite(specialite);
                Genre g = new Genre();
                Genre gg = g.findById(connex,genre);
                String nom_niveau = req.getParameter("niveau");
                NiveauEtude niveau = new NiveauEtude(nom_niveau);
                Employe employe = new Employe(nom,prenom,date_embauche,date_naissance,gg,niveau);
                employe.create(connex,liste);

                req.setAttribute("message","insertion reussie");
                doGet(req, res);
       }catch(Exception exe){
            String message = exe.getMessage();
            //out.println(exe.getMessage());
            req.setAttribute("erreur",message);
            doGet(req, res);
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
  
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

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
