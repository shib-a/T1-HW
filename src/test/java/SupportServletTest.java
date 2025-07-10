import com.example.t1_hw.SupportServiceImpl;
import com.example.t1_hw.SupportServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.*;

import java.io.*;
import java.util.logging.Logger;

import static org.mockito.Mockito.*;

public class SupportServletTest {
    private SupportServlet servlet;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private SupportServiceImpl service;
    public Writer writer;
    public Reader reader;
    private static final Logger logger = Logger.getLogger("Tests");
    private final String testRandomMessage = "У тебя все получится";

    @BeforeEach
    public void initTest() throws IOException {
        service = mock(SupportServiceImpl.class);
        when(service.getRandomMessage()).thenReturn(testRandomMessage);
        servlet = new SupportServlet(service);
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
        logger.info(result);
        Assertions.assertEquals(testRandomMessage, result);
    }

    @Test
    public void testDoPost() throws IOException{
        String testMessage = "я в тебя верю!";
        reader = new StringReader(testMessage);
        when(request.getReader()).thenReturn(new BufferedReader(reader));
        servlet.doPost(request, response);
        PrintWriter resultWriter = response.getWriter();
        resultWriter.flush();
        String result = writer.toString().trim();
        logger.info(result);
        Assertions.assertEquals(testMessage, result);
    }
}
