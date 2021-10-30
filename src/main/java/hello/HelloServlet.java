/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author viter
 */
@WebServlet("/alomundo")
public class HelloServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HelloServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HelloServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        
        // Instância para verificar as horas e formatar a data atual
        Calendar calendar = new GregorianCalendar();
        Date date = new Date();
        SimpleDateFormat dt = new SimpleDateFormat("dd/MM/YYYY");
        
        String msg = "";
        
        // Verificação da linguagem
        String lang = request.getParameter("lang");
        if(lang==null)
            lang = "pt";
        switch(lang){
            case "pt":
                if(calendar.get(Calendar.HOUR_OF_DAY) < 12) {
                    msg = "Bom dia, ";
	        }
                else if(calendar.get((Calendar.HOUR_OF_DAY)) >= 12 && (calendar.get(Calendar.HOUR_OF_DAY) < 18)) {
                    msg = "Boa tarde, ";
	        }
                else if(calendar.get(Calendar.HOUR_OF_DAY) >= 18){
                    msg = "Boa noite, ";
                }	        	
	        break;
                
	    case "en":
                if(calendar.get(Calendar.HOUR_OF_DAY) < 12) {
                    msg = "Good morning, ";
                }
                else if(calendar.get((Calendar.HOUR_OF_DAY)) >= 12 && (calendar.get(Calendar.HOUR_OF_DAY) < 18)) {
                    msg = "Good afternoon, ";
                }
                else if(calendar.get(Calendar.HOUR_OF_DAY) >= 18){
                    msg = "Good night, ";
                }	  
	        break;
                    
            case "fr":
                if(calendar.get(Calendar.HOUR_OF_DAY) < 12) {
                    msg = "Bonjour, ";
	     	}
                else if(calendar.get((Calendar.HOUR_OF_DAY)) >= 12 && (calendar.get(Calendar.HOUR_OF_DAY) < 18)) {
                    msg = "Bon apres-midi, ";
                }
                else if(calendar.get(Calendar.HOUR_OF_DAY) >= 18){
                    msg = "Bonne nuit, ";
	        }
                break;
                        
            case "de":
	      	if(calendar.get(Calendar.HOUR_OF_DAY) < 12) {
                    msg = "Guten morgen, ";
	      	}
                else if(calendar.get((Calendar.HOUR_OF_DAY)) >= 12 && (calendar.get(Calendar.HOUR_OF_DAY) < 18)) {
                    msg = "Guten nachmittag, ";
	      	}
                else if(calendar.get(Calendar.HOUR_OF_DAY) >= 18){
                    msg = "Gute nacht, ";
	      	}	
                break;
                        
            case "es":
	      	if(calendar.get(Calendar.HOUR_OF_DAY) < 12) {
                    msg = "Buenos dias, ";
	      	}
                else if(calendar.get((Calendar.HOUR_OF_DAY)) >= 12 && (calendar.get(Calendar.HOUR_OF_DAY) < 18)) {
                    msg = "Buenas tardes, ";
	      	}
                else if(calendar.get(Calendar.HOUR_OF_DAY) >= 18){
                    msg = "Buenas noches, ";
	      	}
                break;
	    
            case "ho":
	      	if(calendar.get(Calendar.HOUR_OF_DAY) < 12) {
                    msg = "Goedemorgen, ";
	      	}
                else if(calendar.get((Calendar.HOUR_OF_DAY)) >= 12 && (calendar.get(Calendar.HOUR_OF_DAY) < 18)) {
                    msg = "Goedenmiddag, ";
	      	}
                else if(calendar.get(Calendar.HOUR_OF_DAY) >= 18){
                    msg = "Welterusten, ";
	      	}	 
                break;
            }
        
        // Verificação do nome
        String nome = request.getParameter("nome");
        if(nome==null)
            nome = "Fulano";
        
        // Verificação do tratamento
        String trat = request.getParameter("trat");
        switch(trat){
            case "nenhum":
                trat = "";	        	
	        break;
                
            case "sr":
                trat = "Sr. ";	        	
	        break;
                
            case "sra":
                trat = "Sra. ";	        	
	        break;
        }
        
        msg = msg+trat+nome+"!"+" Data: "+dt.format(date);

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HelloServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HelloServlet</h1>");
            out.println("<p>" + msg + "</p>");
            out.println("</body>");
            out.println("</html>");
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
        
        // Instância para verificar as horas e formatar a data atual
        Calendar calendar = new GregorianCalendar();
        Date date = new Date();
        SimpleDateFormat dt = new SimpleDateFormat("dd/MM/YYYY");
        
        String msg = "";
        
        // Verificação da linguagem
        String lang = request.getParameter("lang");
        if(lang==null)
            lang = "pt";
        switch(lang){
            case "pt":
                if(calendar.get(Calendar.HOUR_OF_DAY) < 12) {
                    msg = "Bom dia, ";
	        }
                else if(calendar.get((Calendar.HOUR_OF_DAY)) >= 12 && (calendar.get(Calendar.HOUR_OF_DAY) < 18)) {
                    msg = "Boa tarde, ";
	        }
                else if(calendar.get(Calendar.HOUR_OF_DAY) >= 18){
                    msg = "Boa noite, ";
                }	        	
	        break;
                
	    case "en":
                if(calendar.get(Calendar.HOUR_OF_DAY) < 12) {
                    msg = "Good morning, ";
                }
                else if(calendar.get((Calendar.HOUR_OF_DAY)) >= 12 && (calendar.get(Calendar.HOUR_OF_DAY) < 18)) {
                    msg = "Good afternoon, ";
                }
                else if(calendar.get(Calendar.HOUR_OF_DAY) >= 18){
                    msg = "Good night, ";
                }	  
	        break;
                    
            case "fr":
                if(calendar.get(Calendar.HOUR_OF_DAY) < 12) {
                    msg = "Bonjour, ";
	     	}
                else if(calendar.get((Calendar.HOUR_OF_DAY)) >= 12 && (calendar.get(Calendar.HOUR_OF_DAY) < 18)) {
                    msg = "Bon apres-midi, ";
                }
                else if(calendar.get(Calendar.HOUR_OF_DAY) >= 18){
                    msg = "Bonne nuit, ";
	        }
                break;
                        
            case "de":
	      	if(calendar.get(Calendar.HOUR_OF_DAY) < 12) {
                    msg = "Guten morgen, ";
	      	}
                else if(calendar.get((Calendar.HOUR_OF_DAY)) >= 12 && (calendar.get(Calendar.HOUR_OF_DAY) < 18)) {
                    msg = "Guten nachmittag, ";
	      	}
                else if(calendar.get(Calendar.HOUR_OF_DAY) >= 18){
                    msg = "Gute nacht, ";
	      	}	
                break;
                        
            case "es":
	      	if(calendar.get(Calendar.HOUR_OF_DAY) < 12) {
                    msg = "Buenos dias, ";
	      	}
                else if(calendar.get((Calendar.HOUR_OF_DAY)) >= 12 && (calendar.get(Calendar.HOUR_OF_DAY) < 18)) {
                    msg = "Buenas tardes, ";
	      	}
                else if(calendar.get(Calendar.HOUR_OF_DAY) >= 18){
                    msg = "Buenas noches, ";
	      	}
                break;
	    
            case "ho":
	      	if(calendar.get(Calendar.HOUR_OF_DAY) < 12) {
                    msg = "Goedemorgen, ";
	      	}
                else if(calendar.get((Calendar.HOUR_OF_DAY)) >= 12 && (calendar.get(Calendar.HOUR_OF_DAY) < 18)) {
                    msg = "Goedenmiddag, ";
	      	}
                else if(calendar.get(Calendar.HOUR_OF_DAY) >= 18){
                    msg = "Welterusten, ";
	      	}	 
                break;
            }
        
        // Verificação do nome
        String nome = request.getParameter("nome");
        if(nome==null)
            nome = "Fulano";
        
        // Verificação do tratamento
        String trat = request.getParameter("trat");
        switch(trat){
            case "nenhum":
                trat = "";	        	
	        break;
                
            case "sr":
                trat = "Sr. ";	        	
	        break;
                
            case "sra":
                trat = "Sra. ";	        	
	        break;
        }
        
        msg = msg+trat+nome+"!"+" Data: "+dt.format(date);

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HelloServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HelloServlet</h1>");
            out.println("<p>" + msg + "</p>");
            out.println("</body>");
            out.println("</html>");
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
