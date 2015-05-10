/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import com.mycompany.tpnew.App;
import com.mycompany.tpnew.config.factory.ComplaintsFactory;
import com.mycompany.tpnew.domain.Complaints;
import com.mycompany.tpnew.repository.ComplaintsRepository;
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
public class ComplaintsCrudTestNG extends AbstractTestNGSpringContextTests{
    
    private Long id;
    @Autowired 
    private ComplaintsRepository repository;
    
    @Test
    public void create() throws Exception {

        Complaints newAccount = ComplaintsFactory
                .createComplaint("user1", "3rd", "xxx");
        
        repository.save(newAccount);
        id = newAccount.getId();
        Assert.assertNotNull(newAccount.getId());
        
        
        }
    
    @org.testng.annotations.Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Complaints lecturer = repository.findOne(id);
        org.testng.Assert.assertNotNull(lecturer);


    }

    @org.testng.annotations.Test(dependsOnMethods = "read")
    public void update() throws Exception {
        Complaints lecturer = repository.findOne(id);

        Complaints newlewcturer = new Complaints
                .Builder(lecturer.getUsername())
                .copy(lecturer)
                .timeStamp("123")
                .build();

        repository.save(newlewcturer);

        Complaints updatedLecturer = repository.findOne(id);
        org.testng.Assert.assertEquals(updatedLecturer.getTimestamp(),"123");

    }

    @org.testng.annotations.Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        Complaints lecturer = repository.findOne(id);
        repository.delete(lecturer);
        Complaints deletedLecturer = repository.findOne(id);
        org.testng.Assert.assertNull(deletedLecturer);

    }

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
