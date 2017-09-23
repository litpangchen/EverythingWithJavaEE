import com.example.dao.BookDao;
import com.example.pojo.Book;
import org.junit.Assert;
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
public class MyBatisCRUDTest {

    @Autowired
    private BookDao bookDao;

    @Test
    public void testQueryById() {
        long bookId = 1000;
        Book book = bookDao.queryById(bookId);
        Assert.assertNotNull(book);
        System.out.println("Book Id " + String.valueOf(book.getBookId())
                + " Book name " + book.getName()
                + " Total book " + book.getNumber());
    }
}
