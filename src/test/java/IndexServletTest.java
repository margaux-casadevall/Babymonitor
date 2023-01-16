import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.Test;
import servlets.IndexServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class IndexServletTest {
    @Test
    public void IndexServletTest() throws Exception {
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet("http://localhost:8080/"); //request has succeeded
        HttpResponse response = client.execute(request);
        int statusCode = response.getStatusLine().getStatusCode();
        assertEquals(200, statusCode);
}
    @Test
    public void doGet_redirectsToLogin() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        //Create mock of session
        HttpSession session = mock(HttpSession.class);

        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("user")).thenReturn(null);    // user not found
        new IndexServlet().doGet(request, response);
        // Asserting getting redirected to login
        verify(response).sendRedirect("/login");
    }
    @Test
    public void doGet_redirectsToPatients() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        //Create mock of session
        HttpSession session = mock(HttpSession.class);

        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("user")).thenReturn("user");  // correct user
        new IndexServlet().doGet(request, response);
        // Redirects to patients
        verify(response).sendRedirect("/patients");
    }
    @Test
    public void doPost_PrintThreshold() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        //Create mock of session
        HttpSession session = mock(HttpSession.class);

        // Default threshold values
        when(request.getParameter("Lower threshold (4.5)")).thenReturn("4.5");
        when(request.getParameter("Upper threshold (14)")).thenReturn("14");

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

        // Act
        new IndexServlet().doPost(request, response);

        // Assert
        writer.flush();
        // checks output written to stringWriter object is equal to expected output
        assertEquals("144.5", stringWriter.toString());
    }
}