import com.example.dao.IUserDao;
import com.example.pojo.UserPO;
import com.example.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class UserServiceTest {
    private UserService userService;
    @Mock
    private IUserDao userDao;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        userService = new UserService();
        userService.setUserDao(userDao);

        Mockito.when(userDao.getUserById(1L)).thenReturn(new UserPO(1L, "user1", 20));
        Mockito.when(userDao.getUserById(2L)).thenReturn(null);
        Mockito.when(userDao.updateUser(Mockito.any())).thenReturn(true);
    }

    @Test
    public void testUpdateUserNameSuccess() {
        /*测试这个被测试对象的方法*/
        boolean updated = userService.updateUserName(1L, "user_new");
        //验证结果
        Assert.assertTrue(updated);
        //验证userDao的getUserById(1L)这个方法是否被调用过
        Mockito.verify(userDao).getUserById(1L);
        //构造参数捕获器，用于捕获方法参数进行验证
        ArgumentCaptor<UserPO> personCaptor =
                ArgumentCaptor.forClass(UserPO.class);
        //验证updateUser方法是否被调用过，并且捕获入参
        Mockito.verify(userDao).updateUser(personCaptor.capture());
        //返回捕获的参数。s
        UserPO updatedPerson = personCaptor.getValue();
        System.out.println(updatedPerson.getName());
        //判断是否已经被修改过了
        Assert.assertEquals("user_new", updatedPerson.getName());
        //多余方法调用验证，保证这个测试用例中所有被Mock的对象的相关方法都已经被Verify过了
        Mockito.verifyNoMoreInteractions(userDao);
    }

    @Test
    public void testUpdateUserNameFailed() {
        boolean updated = userService.updateUserName(2L, "user_new");
        //验证结果
        Assert.assertFalse(updated);
        //验证userDao的getUserById(1L)这个方法是否被调用过
        Mockito.verify(userDao).getUserById(2L);
        //多余方法调用验证，保证这个测试用例中所有被Mock的对象的相关方法都已经被Verify过了
        Mockito.verifyZeroInteractions(userDao);
        //多余方法调用验证，保证这个测试用例中所有被Mock的对象的相关方法都已经被Verify过了
        Mockito.verifyNoMoreInteractions(userDao);
    }
}
