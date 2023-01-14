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
import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet
{
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
  {
    request.getSession().removeAttribute("user");
    response.sendRedirect(Helpers.redirectUrl(request, "/login"));
  }
}
