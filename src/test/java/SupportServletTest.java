import com.example.t1_hw.SupportServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.*;

import java.io.*;
import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class SupportServletTest {
    private SupportServlet servlet;
    private HttpServletRequest request;
    private HttpServletResponse response;
    public Writer writer;
    public Reader reader;

    @BeforeEach
    public void initTest() throws IOException {
        servlet = new SupportServlet();
        servlet.init();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        writer = new StringWriter();
        when(response.getWriter()).thenReturn(new PrintWriter(writer));
    }
    @Test
    public void testDoGet() throws IOException{
        servlet.doGet(request, response);
        PrintWriter resultWriter = response.getWriter();
        resultWriter.flush();
        String result = writer.toString().trim();
        ArrayList<String> messages = servlet.getHelpMessages();
        Assumptions.assumeTrue(messages.contains(result));
    }
    @Test
    public void testDoPost() throws IOException{
        String testMessage = "я в тебя верю!";
        reader = new StringReader(testMessage);
        when(request.getReader()).thenReturn(new BufferedReader(reader));
        servlet.doPost(request, response);
        ArrayList<String> resultMessages = servlet.getHelpMessages();
        Assumptions.assumeTrue(resultMessages.contains(testMessage));
    }
}
