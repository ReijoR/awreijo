/*
 * Copyright 2020 Diego Silva <diego.silva at apuntesdejava.com>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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




@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;
    @Resource(lookup="jdbc/books")
    private DataSource myds;

    @Override
    public void init() {
        message = "Hello from Servlet!";
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        
        
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
          
        out.println("<h1>" + message + "</h1>");
        try{
            
            Connection con=myds.getConnection();
            Statement stm = con.createStatement();
            out.println("<thead><tr><th>Auto</th><th>Kaupunki<th><tr><thead>");
            ResultSet rs = stm.executeQuery ("SELECT * FROM car"); 
            out.println("<table>");
            
                              
            
            while(rs.next()){
                out.println("<p>"+rs.getString(3)+"</p>");
                out.println("<p>"+rs.getString(2)+"</p>");
            
            }
            
            rs.close();
            con.close();
        }
        catch(Exception ex){
            System.out.println("moi");
            out.println(ex.getMessage());

        }
        out.println("</body></html>");
    }

    @Override
    public void destroy() {
    }
}