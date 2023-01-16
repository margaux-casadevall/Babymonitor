import models.Patient;
import models.User;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.Test;
import services.PatientService;
import servlets.PatientsServlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class PatientsServletTest {
    @Test
    public void testDoGet_redirectsToLogin() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        // Create mock of session
        HttpSession session = mock(HttpSession.class);
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("user")).thenReturn(null);

        // create and invoke the servlet
        PatientsServlet servlet = new PatientsServlet();
        servlet.doGet(request, response);

        // verify redirected to login page
        verify(response).sendRedirect("/login");
    }
/*
    @Test
    public void testDoGet_userLoggedIn() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        // Create mock of session
        HttpSession session = mock(HttpSession.class);

        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("user")).thenReturn(new User());

        ServletContext context = mock(ServletContext.class);
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);
        when(context.getRequestDispatcher("/patients.jsp")).thenReturn(dispatcher);
        when(request.getServletContext()).thenReturn(context);

        PatientService patientService = mock(PatientService.class);
        ArrayList<Patient> patients = new ArrayList<>();
        when(patientService.list()).thenReturn(patients);

        servlet.doGet(request, response);

        verify(request).setAttribute("patients", patients);
        verify(dispatcher).forward(request, response);
    }
*/
}

