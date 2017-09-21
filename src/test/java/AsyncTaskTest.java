import com.example.method.AsyncTask;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "file:src/main/webapp/WEB-INF/spring-dispatcher-servlet.xml"
})
@WebAppConfiguration
public class AsyncTaskTest {

    @Autowired
    AsyncTask asyncTask;

    @Test
    public void AsyncTaskTest() throws InterruptedException {
        asyncTask.someHeavyBackgroundTask(1000);
        asyncTask.printLog();
        Thread.sleep(4000);
    }
}
