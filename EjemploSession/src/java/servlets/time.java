/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.text.DateFormat;

public class time extends HttpServlet {
   
 public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
        
        response.setContentType("text/html");
        java.io.PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        Date creationTime = new Date(session.getCreationTime() );
        Date lastAccessed = new Date(session.getLastAccessedTime());
        Date now = new Date();
        DateFormat formatter = DateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.MEDIUM);
        
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Displaying the Session Creation and Last-Accessed Time</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>Session Creation and Last-Accessed Time</h2>");
        out.println("The time and date now is: " + formatter.format(now) + "<br><br>");
        out.println("The session creation time: HttpSession.getCreationTime( ): " + formatter.format(creationTime) + "<br><br>");
        out.println("The last time the session was accessed: HttpSession.getLastAccessedTime( ): " + formatter.format(lastAccessed) );
        out.println("</body>");
        out.println("</html>");
        
        
    }
}