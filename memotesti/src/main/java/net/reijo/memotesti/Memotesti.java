/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package net.reijo.memotesti;

/**
 *
 * @author Reijo
 */
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Memotesti extends HttpServlet {
    
    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String memo = request.getParameter("memo");
        if (memo != null) {
            // Save the memo to a file or database
        }

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Memo Pad</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<form method='get' action='/memo'>");
        out.println("<textarea name='memo' rows='10' cols='50'>" + memo + "</textarea><br>");
        out.println("<input type='submit' value='Save'>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }
}


