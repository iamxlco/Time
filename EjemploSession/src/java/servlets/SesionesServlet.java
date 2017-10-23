/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class SesionesServlet extends HttpServlet {
   
     public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

         String nombre;
         String apellido;
        
      //recuperamos los datos del formulario
          nombre = request.getParameter("NOMBRE");
          apellido = request.getParameter("APELLIDO");
         
      HttpSession sesion = request.getSession();
      sesion.setAttribute("claveSesion", nombre + apellido);
      
      
      Date creationTime = new Date(sesion.getCreationTime() );
      Date lastAccessed = new Date(sesion.getLastAccessedTime());
      Date now = new Date();
      
      DateFormat formatter = DateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.MEDIUM);

       response.setContentType("text/html");
      //Mostramos los  valores en el cliente
      PrintWriter out = response.getWriter();
       
      out.println("<a href=\"/EjemploSession/catalogo.jsp\"> Link al catalogo del carrito  </a>");
      out.println("<br>");
      out.println("ID de la sesi&oacute;n: " + sesion.getId());
      
      out.println("<br>Hora actual " + now);
      out.println("<br>Creación:  " + creationTime);
      out.println("<br>Última vez accesada:  " + lastAccessed);

    }
   

}
