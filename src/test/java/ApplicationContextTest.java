import com.example.t1_hw.ApplicationContext;
import com.example.t1_hw.SupportService;
import com.example.t1_hw.SupportServiceImpl;
import com.example.t1_hw.SupportServlet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ApplicationContextTest {
    @Test
    public void application_context_should_return_SupportService(){
        ApplicationContext context = new ApplicationContext();
        assertEquals(SupportServiceImpl.class, context.getInstance(SupportServiceImpl.class).getClass());
    }
    @Test
    public void application_context_should_return_SupportServlet(){
        ApplicationContext context = new ApplicationContext();
        assertEquals(SupportServlet.class, context.getInstance(SupportServlet.class).getClass());
    }
}
