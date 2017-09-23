import com.example.dao.PersonRepository;
import com.example.pojo.Person2;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JpaCRUBTest extends BaseTest {
    @Autowired
    private PersonRepository personRepository;

    @Test
    public void testJpa() {
        Person2 person = personRepository.findOne(1);
        System.out.println("Person2 id - " + person.getId()
                + " Person2 email - " + person.getEmail()
                + " Person2 last name - " + person.getLastName());
    }
}
