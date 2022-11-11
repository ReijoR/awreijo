<%-- 
    Document   : index
    Created on : Nov 7, 2022, 3:45:53 PM
    Author     : Reijo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
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
            
        <h1>Hello World!</h1>
    </body>
</html>
