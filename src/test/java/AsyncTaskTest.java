import com.example.method.AsyncTask;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AsyncTaskTest extends BaseTest {

    @Autowired
    AsyncTask asyncTask;

    @Test
    public void AsyncTaskTest() throws InterruptedException {
        asyncTask.someHeavyBackgroundTask(1000);
        asyncTask.printLog();
        Thread.sleep(4000);
    }
}
