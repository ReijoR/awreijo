package net.tutorit.assessment1.servlet;

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


@WebServlet(name = "reportingServlet", value = "/reporting")
public class ReportingServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Tuoteraportti</h1>");
        try{
            /*
            Connection con=myds.getConnection();
                Statement stm=con.createStatement();
                ResultSet rs=stm.executeQuery("select p.* FROM passanger p left join car c on (regcity = p.name)");
                out.println("<table>");
                out.println("<thead><tr><th>Valmistaja</th><th>Tuote</th><th>Hinta</th></tr></thead>");
                
                out.println("<tbody>");
                
                while(rs.next()){
                        out.println("<tr><td>"+rs.getString("car_id")+"</td><td>"+rs.getString("name")+"</td><td>"+rs.getString("psgtype")+"</td></tr>");
                }
                out.println("</tbody>");
                out.println("</table>");
                rs.close();
                con.close();
                
            // Tähän tietokantahaku ja taulukon tulostaminen toimeksiannon mukaisesti
            */
        }
        catch(Exception ex){
            System.out.println("******************Virhe");
            ex.printStackTrace();
        }
    }

}