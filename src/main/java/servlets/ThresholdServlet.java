package servlets;

import helpers.Helpers;
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

@WebServlet("/patient/thresholds")
public class ThresholdServlet extends HttpServlet
{
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
  {
    if(request.getSession().getAttribute("user") == null) {
      response.sendRedirect(Helpers.redirectUrl(request, "/login"));
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
}
