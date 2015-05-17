/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package old;

import com.mycompany.tpnew.App;
import com.mycompany.tpnew.config.factory.AccountFactory;

import com.mycompany.tpnew.domain.AccountInfo;
import com.mycompany.tpnew.repository.AccountInfoRepository;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 *
 * @author JEAN-PAUL
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class AccountRespositoryTest extends AbstractTestNGSpringContextTests{
    
    private Long id;
    @Autowired 
    private AccountInfoRepository repository;
    
    @Test
    public void create() throws Exception {

        AccountInfo newAccount = AccountFactory
                .createAccount("user1", "3rd", "xxx");
        
        repository.save(newAccount);
        id = newAccount.getId();
        Assert.assertNotNull(newAccount.getId());
        
        
        }
    
    @org.testng.annotations.Test(dependsOnMethods = "create")
    public void read() throws Exception {
        AccountInfo lecturer = repository.findOne(id);
        org.testng.Assert.assertNotNull(lecturer);


    }

    @org.testng.annotations.Test(dependsOnMethods = "read")
    public void update() throws Exception {
        AccountInfo lecturer = repository.findOne(id);

        AccountInfo newlewcturer = new AccountInfo
                .Builder(lecturer.getUsername())
                .copy(lecturer)
                .password("123")
                .build();

        repository.save(newlewcturer);

        AccountInfo updatedLecturer = repository.findOne(id);
        org.testng.Assert.assertEquals(updatedLecturer.getPassword(),"123");

    }

    @org.testng.annotations.Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        AccountInfo lecturer = repository.findOne(id);
        repository.delete(lecturer);
        AccountInfo deletedLecturer = repository.findOne(id);
        org.testng.Assert.assertNull(deletedLecturer);

    }
    
    

    
    public AccountRespositoryTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
