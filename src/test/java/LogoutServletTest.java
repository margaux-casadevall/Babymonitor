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
import servlets.LogoutServlet;

import java.io.IOException;

import static org.junit.Assert.*;

public class LogoutServletTest {

    @Test
    public void LogoutServletTest() throws Exception {
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet("http://localhost:8080/logout"); //request has succeeded
        HttpResponse response = client.execute(request);
        int statusCode = response.getStatusLine().getStatusCode();
        assertEquals(200, statusCode);
    }
    @Test
    public void doGet_RemovesUser() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        //Create mock of session
        HttpSession session = mock(HttpSession.class);

        when(request.getSession()).thenReturn(session);
        new LogoutServlet().doGet(request, response);

        // Removes user attribute (logs out user)
        verify(session).removeAttribute("user");
    }

    @Test
    public void doGet_RedirectsToLogin() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        //Create mock of session
        HttpSession session = mock(HttpSession.class);
        when(request.getSession()).thenReturn(session);
        new LogoutServlet().doGet(request, response);

        // Asserting getting redirected to login
        verify(response).sendRedirect("/login");
    }
}