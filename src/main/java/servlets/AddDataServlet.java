package servlets;

import helpers.Helpers;
import models.Comment;
import models.GlucoseLevel;
import services.PatientService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;

@WebServlet("/patient/add")
public class AddDataServlet extends HttpServlet
{
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
  {
    if(request.getSession().getAttribute("user") == null) {
      response.sendRedirect(Helpers.redirectUrl(request, "/login"));
      return;
    }

    var patientId = request.getParameter("id");
    
//Error not found envoked
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
    RequestDispatcher dispatch = context.getRequestDispatcher("/addData.jsp");
    dispatch.forward(request, response);
  }

  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    if(request.getSession().getAttribute("user") == null) {
      response.sendRedirect(Helpers.redirectUrl(request, "/login"));
      return;
    }

    var id = request.getParameter("id");
    var type = request.getParameter("type");
    var value = request.getParameter("value");

    var patient = PatientService.Instance.get(id);

    if(type.equals("glucose")) {
      patient.getGlucoseLevels().add(new GlucoseLevel(new Date(), Double.parseDouble(value)));
    }
    else if(type.equals("comment")) {
      patient.getComments().add(new Comment(new Date(), value));
    }

    PatientService.Instance.replace(id, patient);

    response.sendRedirect(Helpers.redirectUrl(request, "/patient/data?id=" + id));

  }
}
