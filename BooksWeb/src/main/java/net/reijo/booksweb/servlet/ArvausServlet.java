/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.reijo.booksweb.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Reijo
 */
@WebServlet(name="PeliServlet", value = "/arvaus-servlet" )
public class ArvausServlet extends HttpServlet{
    
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)throws IOException{
        doGet(req,resp);
    }
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        
        resp.setContentType("text/html");
        try(PrintWriter out = resp.getWriter()){
            out.println("<html><body>");
            HttpSession ses = req.getSession();
            Integer secret = (Integer)ses.getAttribute("salainen");
            if (secret == null){
                secret=(int)(Math.random()*100+1);
                ses.setAttribute("salainen", secret);
                
            }
            out.println("<p>Salainen "+secret+"</p>");
            
            out.println("<p>Arvaa luku 1-100</p>");
            
            String arvaus = req.getParameter("arvaus");
            if (arvaus==null) arvaus="";
            
            out.println("<form method='post' />");
            out.println("<input name = 'arvaus' value'"+ arvaus +"'/>");
            out.println("<input type = submit>");
            out.println("<input type='submit' value='Arvaa' />");
            out.append("</form>");
            
            try{
                int iArv=Integer.parseInt(arvaus);
                if (iArv<secret) out.println("<p> Liian pieni</p>");
                else if (iArv>secret) out.println("<p> Liian iso</p>");
                else{
                    out.println("Oikein");
                    secret=(int)(Math.random()*100+1);
                    ses.setAttribute("salainen", secret);
                }
            }
            catch(Exception ex){
                out.println("<p>Homma kusee</p>");
            }
            out.println("</body></html>");
        }
    }
}

