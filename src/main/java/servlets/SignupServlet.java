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

@WebServlet("/signup")
public class SignupServlet extends HttpServlet
{
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
  {
    var username = request.getParameter("username");
    var password = request.getParameter("password");
    var role = request.getParameter("role");

    var user = new User(username, Helpers.sha256(password), role);

    UserService.Instance.create(user);

    response.setStatus(202);
  }
}
