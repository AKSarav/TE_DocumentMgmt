/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sarav.donormgmttool;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sarav
 */
public class Processor extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
    
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        System.out.println("DEBUG#3"+request.getParameter("task"));
        DBImpl obj = new DBImpl();
        if (request.getParameterMap().size()>0)
        {
        if (request.getParameter("task").equals("sendmail"))
        {    
            System.out.println("Hoorey It works!!!");
            com.sarav.donormgmttool.SendMail sm = new com.sarav.donormgmttool.SendMail();
            
            String[] Selectedids = request.getParameterValues("did");
            
            int valuelen = Selectedids.length;
            for(int i=0; i<valuelen;i++)
            {
                System.out.println("DEBUG#30"+Selectedids[i]);
            
            String[] SelID = Selectedids[i].split("TE-REF-ID-");
            System.out.println("SELID"+SelID[1]);
            for(donation don: obj.get_donations_by_id(Integer.parseInt(SelID[1])))
            {
                System.out.println("IS IT COMING HERE");
                sm.send(don.getDonorname(),don.getDonoremail(),don.getAmount(),don.getDonationid(),don.getMode(), (Date) don.getDonationdate());
            }
            }
            
        }
        }
        /* TODO output your page here. You may use following sample code. */
            
            
            
            
            request.setAttribute("alldonations", obj.get_donations());
            System.out.println(" OBJ GET DONATIONS" +obj.get_donations());
            
            //This is print the content of the object
            //System.out.println("Amount"+obj.get_donations().get(0).getAmount());
            
            
            getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);
            
            
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Processor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Processor.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Processor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Processor.class.getName()).log(Level.SEVERE, null, ex);
        }
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
