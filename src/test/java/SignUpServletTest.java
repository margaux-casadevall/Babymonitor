/*
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import servlets.SignupServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.AssertJUnit.assertEquals;

public class SignUpServletTest {

    @Test
    public void testDoPost_validInput() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        //Create mock of session
        HttpSession session = mock(HttpSession.class);

        when(request.getParameter("username")).thenReturn("test_user");
        when(request.getParameter("password")).thenReturn("test_password");
        when(request.getParameter("role")).thenReturn("admin");
        ;
        SignupServlet servlet = new SignupServlet();
        servlet.doPost(request, response);

        Assertions.assertEquals(202, response.getStatus());
        // assert that user is created with the correct username, hashed password and role
    }
}

*/

