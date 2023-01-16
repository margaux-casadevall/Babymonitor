package servlets;

import helpers.Helpers;
import services.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("")
public class IndexServlet extends HttpServlet
{
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
  {
    HttpSession session = request.getSession();

    if(session.getAttribute("user") == null) {
      response.sendRedirect("/login");
    } else {
      response.sendRedirect("/patients");
    }
  }
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    var LowerThresh = request.getParameter("Lower threshold (4.5)");
    var UpperThresh = request.getParameter("Upper threshold (14)");


    response.getWriter().write(UpperThresh + LowerThresh);
  }
}
