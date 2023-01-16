package servlets;

import com.mongodb.client.MongoCollection;
import helpers.Helpers;
import models.User;
import services.PatientService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.Document;
import java.io.IOException;

@WebServlet("/patient/thresholds")
public class ThresholdServlet extends HttpServlet
{
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
  {
    User user = (User)request.getSession().getAttribute("user");
    
    if(user == null) {
      response.sendRedirect("/login");
      return;
    } else if(!user.getRole().equals("Doctor")) {
      response.setStatus(403); //forbidden access error
      return;
    }

    var patientId = request.getParameter("id");
    var patient = PatientService.Instance.get(patientId);

    request.setAttribute("patient", patient);

    // Invoke the JSP page.
    ServletContext context = getServletContext();
    RequestDispatcher dispatch = context.getRequestDispatcher("/thresholds.jsp");
    dispatch.forward(request, response);
  }
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    var lower = request.getParameter("lower");
    var upper = request.getParameter("upper");

    var id = request.getParameter("id");

    var patient = PatientService.Instance.get(id);

    patient.setLowerThreshold(Double.parseDouble(lower));
    patient.setUpperThreshold(Double.parseDouble(upper));

    PatientService.Instance.replace(id, patient);

    response.sendRedirect("/patient/data?id=" + id);
  }
}
