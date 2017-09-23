import com.example.dao.BookDao;
import com.example.pojo.Book;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyBatisCRUDTest extends BaseTest {

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
