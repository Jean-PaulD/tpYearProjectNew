/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import com.mycompany.tpnew.App;
import com.mycompany.tpnew.config.factory.AdminFactory;
import com.mycompany.tpnew.domain.Admin;
import com.mycompany.tpnew.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 *
 * @author JEAN-PAUL
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class AdminCrudTestNG extends AbstractTestNGSpringContextTests{
    
    public AdminCrudTestNG() {
    }

        private Long id;
    @Autowired 
    private AdminRepository repository;
    
    @Test
    public void create() throws Exception {

        Admin newAdmin = AdminFactory
                .createAdmin("user1", "3rd");
        
        repository.save(newAdmin);
        id = newAdmin.getId();
        Assert.assertNotNull(newAdmin.getId());
        
        
        }
    
    @org.testng.annotations.Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Admin lecturer = repository.findOne(id);
        org.testng.Assert.assertNotNull(lecturer);


    }

    @org.testng.annotations.Test(dependsOnMethods = "read")
    public void update() throws Exception {
        Admin lecturer = repository.findOne(id);

        Admin newlewcturer = new Admin
                .Builder(lecturer.getUsername())
                .copy(lecturer)
                .build();

        repository.save(newlewcturer);

        Admin updatedLecturer = repository.findOne(id);
        org.testng.Assert.assertEquals(updatedLecturer.getUsername(),"123");

    }

    @org.testng.annotations.Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        Admin lecturer = repository.findOne(id);
        repository.delete(lecturer);
        Admin deletedLecturer = repository.findOne(id);
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
