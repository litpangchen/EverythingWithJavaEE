import com.example.pojo.Person;
import com.example.service.PersonService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class HibernateCRUBTest extends BaseTest {
    @Autowired
    private PersonService personService;

    @Test
    public void testGetAllPerson() {
        List<Person> persons = personService.getAllPerson();
        boolean isHasPerson = persons.size() > 0;
        Assert.assertTrue(isHasPerson);
        for (Person person : persons) {
            printPerson(person);
        }
    }

    @Test
    public void testGetPersonById() {
        Person person = personService.getPersonById(0);
        Assert.assertNull(person);
        person = personService.getPersonById(5);
        Assert.assertNotNull(person);
        printPerson(person);
    }

    @Test
    public void testInsertPerson() {
        Person person = new Person();
        person.setId(7);
        person.setName("lucas2");
        person.setCountry("Finland");
        int id = personService.insertPerson(person);
        Assert.assertNotNull(id);
        System.out.println("Inserted new person with id " + id);
    }

    @Test
    public void testUpdatePerson() {
        Person person = personService.getPersonById(5);
        String name = "Lucas2";
        person.setName(name);
        personService.updatePersonById(person);
        person = personService.getPersonById(5);
        boolean isEqual = person.getName().equals(name);
        Assert.assertTrue(isEqual);
    }

    @Test

    public void testDeletePerson() {
        personService.removePersonById(8);
        Person person = personService.getPersonById(8);
        Assert.assertNull(person);
    }

    private void printPerson(final Person person) {
        System.out.println("ID - " + person.getId()
                + " Name - " + person.getName()
                + " Country - " + person.getCountry());
    }

}
