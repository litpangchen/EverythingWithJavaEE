import com.example.pojo.Todo;
import com.example.service.TodoService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MongoCRUDTest extends BaseTest {
    @Autowired
    private TodoService todoService;

    @Test
    public void testGetDocuments() {
        List<Todo> todos =  todoService.getTodos();
        System.out.println(todos);
    }
}
