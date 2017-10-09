import com.example.dao.TransactionDao;
import com.example.pojo.Customer;
import com.example.pojo.Txn;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class HibernateOneToOneTest extends BaseTest {
    @Autowired
    private TransactionDao transactionDao;

    @Test
    public void testSave() {
        Txn txn = new Txn();
        txn.setDate(new Date());
        txn.setTotal(100);

        Customer cust = new Customer();
        cust.setAddress("San Jose, USA");
        cust.setEmail("pankaj@yahoo.com");
        cust.setName("Pankaj Kr");
        txn.setCustomer(cust);
        cust.setTxn(txn);
        transactionDao.saveTransaction(txn);
    }

    @Test
    public void testGetTransactionById() {
        Txn txn = transactionDao.getTransactionById(4);
        Assert.assertNotNull(txn.getCustomer());
    }

    @Test
    public void testUpdateCustomer() {
        Txn txn = transactionDao.getTransactionById(4);
        Assert.assertNotNull(txn.getCustomer());
        Customer customer = txn.getCustomer();
        customer.setEmail("lucaschen@ebet.com");
        txn.setCustomer(customer);
        transactionDao.updateCustomer(txn);
    }

    @Test
    public void deleteTransaction() {
        transactionDao.deleteTransactionById(4);
        Txn txn = transactionDao.getTransactionById(4);
        Assert.assertNull(txn);
    }
}
