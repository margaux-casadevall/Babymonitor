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

@WebServlet("/patient")
public class PatientServlet extends HttpServlet
{
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
  {
    if(request.getSession().getAttribute("user") == null) {
      response.sendRedirect("/login");
      return;
    }

    var patientId = request.getParameter("id");

    if(patientId == null) {
      response.setStatus(404);
      return;
    }

    var patient = PatientService.Instance.get(patientId);

    if(patient == null) {
      response.setStatus(404);
      return;
    }

    request.setAttribute("patient", patient);

    // Invoke the JSP page.
    ServletContext context = getServletContext();
    RequestDispatcher dispatch = context.getRequestDispatcher("/patient.jsp");
    dispatch.forward(request, response);
  }
}