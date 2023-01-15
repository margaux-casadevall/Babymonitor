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
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

@WebServlet("/patient/add")
public class AddDataServlet extends HttpServlet
{
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
  {
    if(request.getSession().getAttribute("user") == null) {
      response.sendRedirect("/login");
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
      response.sendRedirect("/login");
      return;
    }

    var id = request.getParameter("id");

    var measurement = request.getParameter("measurement");
    var comment = request.getParameter("comment");
    var time = request.getParameter("time");

    var date = java.sql.Timestamp.valueOf(LocalDate.now().atTime(LocalTime.parse(time)));

    var patient = PatientService.Instance.get(id);

    if(measurement != "") {
      patient.getGlucoseLevels().add(new GlucoseLevel(date, Double.parseDouble(measurement)));
    }
    else if(comment != "") {
      patient.getComments().add(new Comment(date, comment));
    }

    PatientService.Instance.replace(id, patient);

    response.sendRedirect("/patient/data?id=" + id);
  }
}
