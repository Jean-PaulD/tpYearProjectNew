/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import com.mycompany.tpnew.App;
import com.mycompany.tpnew.config.factory.PostFactory;
import com.mycompany.tpnew.domain.Post;
import com.mycompany.tpnew.repository.PostRepository;
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
public class PostCrudTestNG extends AbstractTestNGSpringContextTests{
    
    private Long id;
    @Autowired 
    private PostRepository repository;
    
    @Test
    public void create() throws Exception {

        Post newAccount = PostFactory
                
                .createPost("user1", true, 3, "123");
           
        
        repository.save(newAccount);
        id = newAccount.getId();
        Assert.assertNotNull(newAccount.getId());
        
        
        }
    
    @org.testng.annotations.Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Post lecturer = repository.findOne(id);
        org.testng.Assert.assertNotNull(lecturer);


    }

    @org.testng.annotations.Test(dependsOnMethods = "read")
    public void update() throws Exception {
        Post lecturer = repository.findOne(id);

        Post newlewcturer = new Post
                .Builder(lecturer.getUsername())
                .copy(lecturer)
                .accept(true)
                .build();

        repository.save(newlewcturer);

        Post updatedLecturer = repository.findOne(id);
        org.testng.Assert.assertEquals(updatedLecturer.getAcceptNum(),true);

    }

    @org.testng.annotations.Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        Post lecturer = repository.findOne(id);
        repository.delete(lecturer);
        Post deletedLecturer = repository.findOne(id);
        org.testng.Assert.assertNull(deletedLecturer);

    }
public PostCrudTestNG() {
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
