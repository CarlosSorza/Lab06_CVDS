package edu.eci.cvds.servlet;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Writer;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.eci.cvds.servlet.model.Todo;

@WebServlet(
    urlPatterns = "/HSSampleServlet"
)

public class HSSampleServlet extends HttpServlet{
	
   static final long serialVersionUID = 35L;

    @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
        Writer responseWriter = resp.getWriter();
        try {
            Optional<String> optId = Optional.ofNullable(req.getParameter("entrada"));
            Integer id = (Integer.parseInt(optId.get()));
            Todo lista = Service.getTodo(id);           
            ArrayList<Todo> listaDeToDos = new ArrayList<Todo>();
            listaDeToDos.add(lista);
            resp.setStatus(HttpServletResponse.SC_OK);
            responseWriter.write(Service.todosToHTMLTable(listaDeToDos));
            responseWriter.flush();              
        }
        //Id invalido (Se paso un String o no hubo valor)
        catch ( NumberFormatException e){
            responseWriter.write("Requerimiento Inválido1");
        }
        //Id No encontrado
        catch (FileNotFoundException e){
            responseWriter.write("No encontrado.");
            
            
            
        }
        //MalformedURL
        catch (MalformedURLException e){
            responseWriter.write("Error interno en el Servidor");
        }
        //otros Errores
        catch (Exception e){
            responseWriter.write("Requerimiento Invalido");
        }  
   }
   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
        Writer responseWriter = resp.getWriter();
        try {
            Optional<String> optId = Optional.ofNullable(req.getParameter("entrada"));
            Integer id = (Integer.parseInt(optId.get()));
            Todo lista = Service.getTodo(id);           
            ArrayList<Todo> listaDeToDos = new ArrayList<Todo>();
            listaDeToDos.add(lista);
            resp.setStatus(HttpServletResponse.SC_OK);
            responseWriter.write(Service.todosToHTMLTable(listaDeToDos));
            responseWriter.flush();              
        }
        //Id invalido (Se paso un String o no hubo valor)
        catch ( NumberFormatException e){
            responseWriter.write("Requerimiento Inválido3");
        }
        //Id No encontrado
        catch (FileNotFoundException e){
        
            responseWriter.write("No encontrado.");
            
            
            
        }
        //MalformedURL
        catch (MalformedURLException e){
            responseWriter.write("Error interno en el Servidor ");
        }
        //otros Errores
        catch (Exception e){
            responseWriter.write("Requerimiento Invalido");
        }  
   }
}