import com.example.dao.BookRepository;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SpringCacheTest extends BaseTest {

    private static final Logger LOGGER =
            Logger.getLogger(SpringCacheTest.class);

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void testCacheData() {
        LOGGER.info(bookRepository.getById(1));
        LOGGER.info(bookRepository.getById(2));
        LOGGER.info(bookRepository.getById(3));
        LOGGER.info(bookRepository.getById(1));
        LOGGER.info(bookRepository.getById(2));
        LOGGER.info(bookRepository.getById(3));
    }

}
