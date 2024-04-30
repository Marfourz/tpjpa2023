package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import dao.ProjectDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Project;




@WebServlet(name="project",
urlPatterns={"/project/*"})
public class ProjectServlet extends HttpServlet {


    ProjectDao projectDao;

    @Override
    public void init() throws ServletException {
        super.init();
        projectDao = new ProjectDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
        

        List<Project> projects = projectDao.findAll();

        PrintWriter out = new PrintWriter(resp.getOutputStream());
        String pathInfo = req.getPathInfo();
       

        resp.setContentType("text/html");

        out.println("<html>");
        out.println("<body>");
        
        if(pathInfo == null){
            
            out.println("<body>");
            out.println("<h1>Liste des projets</h1>");
            out.println("<a href='project/create' >Nouveau projet</a>");
            out.println("<table border='1'>");
            out.println("<tr><th>Id</th><th>Name</th><th>Description</th></tr>");
    
           
            for (int i = 0; i <= projects.size() - 1; i++) {
                out.println("<tr>");
                out.println("<td>" + projects.get(i).getId() + "</td>");
                out.println("<td>" + projects.get(i).getName() + "</td>");
                out.println("<td>" + projects.get(i).getDescription() + "</td>");
                out.println("</tr>");
            }

            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
        }

        else if(pathInfo.equals("/create")){
            out.println("<h1>Nouveau projet</h1>");
           
            out.println("<form action='' method='post'>");
            out.println("  <label for='nom'>Nom:</label>");
            out.println("  <input required type='text' id='name' name='name'><br>");
            out.println("  <label for='description'>Description:</label>");
            out.println("  <textarea required id='description' name='description'></textarea><br>");
            out.println("  <input type='submit' value='Envoyer'>");
            out.println("</form>");
        } 

        out.println("</body>");
        out.println("</html>");

        out.flush();
    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException{

        String name = req.getParameter("name");
        String description = req.getParameter("description");

        Project project = new Project(name, description);

        projectDao.save(project);
        
        resp.sendRedirect("/project");   
    }

}
