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
    private String message;
    @Resource(lookup="jdbc/books")
    private DataSource myds;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Tuoteraportti</h1>");
        try{
            
            Connection con=myds.getConnection();
                Statement stm=con.createStatement();
                ResultSet rs=stm.executeQuery("select * from product LEFT JOIN manufacturer on product.manufacturer_id = manufacturer.id UNION SELECT * FROM product RIGHT JOIN manufacturer ON product.manufacturer_id=manufacturer.id"); 
                out.println("<table>");
                out.println("<thead><tr><th>Manufacturer</th><th>Product</th><th>Price</th></tr></thead>");
                
                out.println("<tbody>");
                
                while(rs.next()){
                        out.println("<tr><td>"+rs.getString("manufacturer_id")+"</td><td>"+rs.getString("product_name")+"</td><td>"+rs.getDouble("price")+"</td></tr>");
                }
                out.println("</tbody>");
                out.println("</table>");
                rs.close();
                con.close();
                
            // Tähän tietokantahaku ja taulukon tulostaminen toimeksiannon mukaisesti
            
        }
        catch(Exception ex){
            System.out.println("******************Virhe");
            ex.printStackTrace();
        }
    }

}