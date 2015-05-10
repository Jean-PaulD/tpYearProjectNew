/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import com.mycompany.tpnew.App;
import com.mycompany.tpnew.config.factory.UserFactory;
import com.mycompany.tpnew.domain.User;
import com.mycompany.tpnew.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author JEAN-PAUL
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class UserCrudTestNG extends AbstractTestNGSpringContextTests{
    
    private Long id;
    @Autowired 
    private UserRepository repository;
    
    @Test
    public void create() throws Exception {

        User newAccount = UserFactory
                .createUser("user1", 15, null, null, null, null, null, null);
                        
        repository.save(newAccount);
        id = newAccount.getId();
        Assert.assertNotNull(newAccount.getId());
        
        
        }
    
    @org.testng.annotations.Test(dependsOnMethods = "create")
    public void read() throws Exception {
        User lecturer = repository.findOne(id);
        org.testng.Assert.assertNotNull(lecturer);


    }

    @org.testng.annotations.Test(dependsOnMethods = "read")
    public void update() throws Exception {
        User lecturer = repository.findOne(id);

        User newlewcturer = new User
                .Builder(lecturer.getUsername())
                .copy(lecturer)
                .age(16)
                .build();

        repository.save(newlewcturer);

        User updatedLecturer = repository.findOne(id);
        org.testng.Assert.assertEquals(updatedLecturer.getAge(), 16);

    }

    @org.testng.annotations.Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        User lecturer = repository.findOne(id);
        repository.delete(lecturer);
        User deletedLecturer = repository.findOne(id);
        org.testng.Assert.assertNull(deletedLecturer);

    }
    
    
    
    
    public UserCrudTestNG() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}
