package servlets;

import helpers.Helpers;
import models.User;
import services.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet
{
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
  {
    // Invoke the JSP page.
    ServletContext context = getServletContext();
    RequestDispatcher dispatch = context.getRequestDispatcher("/login.jsp");
    dispatch.forward(request, response);
  }

  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
  {
    var username = request.getParameter("username");
    var password = request.getParameter("password");

    var user = UserService.Instance.login(username, Helpers.sha256(password));

    if(user == null) {
      //Invalid login
      request.setAttribute("errorMessage", "Invalid username or password");

      ServletContext context = getServletContext();
      RequestDispatcher dispatch = context.getRequestDispatcher("/login.jsp");
      dispatch.forward(request, response);
    } else {
      // valid login- to patient directory
      request.getSession().setAttribute("user", user);
      response.sendRedirect("/patients");
    }
  }
}
