import models.Patient;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import services.PatientService;
import servlets.DataServlet;

import static org.mockito.Mockito.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;

import static org.junit.Assert.*;

public class TestingDataServlet {
    @Test
    public void TestingDataServlet() throws Exception {
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet("http://localhost:8080/patient/data"); //request has succeeded
        HttpResponse response = client.execute(request);
        int statusCode = response.getStatusLine().getStatusCode();
        assertEquals(200, statusCode);
    }

    @Test
    public void doGet_redirectsToLogin() throws IOException, ServletException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        //Create mock of session
        HttpSession session = mock(HttpSession.class);
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("user")).thenReturn(null);

        new DataServlet().doGet(request, response);
        // Asserting getting redirected to login
        verify(response).sendRedirect("/login");
    }
    @Test
    public void doGet_PatientMissing() throws IOException, ServletException {
        // Arrange
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        HttpSession session = mock(HttpSession.class);
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("user")).thenReturn(new Object());
        when(request.getParameter("id")).thenReturn(null);
        // Act
        new DataServlet().doGet(request, response);
        // Assert
        verify(response).setStatus(404);
    }
    @Test
    public void doGet_PatientNotFound() throws IOException, ServletException {
        // Arrange
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        HttpSession session = mock(HttpSession.class);
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("user")).thenReturn(new Object());
        when(request.getParameter("id")).thenReturn("1");

        PatientService patientService = mock(PatientService.class);
        when(patientService.get("1")).thenReturn(null);
        // Act
        new DataServlet().doGet(request, response);
        // Assert
        verify(response).setStatus(404);
    }

}







