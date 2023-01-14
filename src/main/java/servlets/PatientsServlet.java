package servlets;

import helpers.Helpers;
import models.Patient;
import services.PatientService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/patients")
public class PatientsServlet extends HttpServlet
{
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
  {
    if(request.getSession().getAttribute("user") == null) {
      response.sendRedirect(Helpers.redirectUrl(request, "/login"));
      return;
    }

    ArrayList<Patient> patients = PatientService.Instance.list();

    request.setAttribute("patients", patients);

    // Invoke the JSP page.
    ServletContext context = getServletContext();
    RequestDispatcher dispatch = context.getRequestDispatcher("/patients.jsp");
    dispatch.forward(request, response);
  }
}
