/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.reijo.booksweb.servlet;

import jakarta.annotation.Resource;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.sql.DataSource;

/**
 *
 * @author Reijo
 */

@WebServlet(name = "personServlet", value = "/person-servlet")
public class PersonServlet extends HttpServlet { 
    private String message;
    @Resource(lookup="jdbc/books")
    private DataSource myds;

    @Override
    public void init() {
        message = "Hello World from Servlet!";
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request,response);
    }
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        //String par=request.getParameter("joku");
        //if (par==null) par="";
        out.println("<h1>" + message + "</h1>");
        //out.println("<form method='post'><input name='joku' value='"+par+"' /><input type='submit' value='Send' /></form>");
        try{
                Connection con=myds.getConnection();
                Statement stm=con.createStatement();
                ResultSet rs=stm.executeQuery("select p.* FROM passanger p left join car c on (regcity = p.name)");
                out.println("<table>");
                out.println("<thead><tr><th>Auto</th><th>NIMI</th><th>PSG</th></tr></thead>");
                
                out.println("<tbody>");
                
                while(rs.next()){
                        out.println("<tr><td>"+rs.getString("car_id")+"</td><td>"+rs.getString("name")+"</td><td>"+rs.getString("psgtype")+"</td></tr>");
                }
                out.println("</tbody>");
                out.println("</table>");
                rs.close();
                con.close();
                
        }
        catch(Exception ex){
                out.println(ex.getMessage());
        }
        
        out.println("</body></html>");
    }

 

}
    
    

