/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import com.mycompany.tpnew.App;
import com.mycompany.tpnew.config.factory.PostCommentsFactory;
import com.mycompany.tpnew.domain.PostComments;
import com.mycompany.tpnew.repository.PostCommentsRepository;
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
public class PostCommentsCrudTestNG extends AbstractTestNGSpringContextTests{
    
    private Long id;
    @Autowired 
    private PostCommentsRepository repository;
    
    @Test
    public void create() throws Exception {

        PostComments newAccount = PostCommentsFactory
                .createAccount("user1", "3rd", "xxx");
        
        repository.save(newAccount);
        id = newAccount.getId();
        Assert.assertNotNull(newAccount.getId());
        
        
        }
    
    @org.testng.annotations.Test(dependsOnMethods = "create")
    public void read() throws Exception {
        PostComments lecturer = repository.findOne(id);
        org.testng.Assert.assertNotNull(lecturer);


    }

    @org.testng.annotations.Test(dependsOnMethods = "read")
    public void update() throws Exception {
        PostComments lecturer = repository.findOne(id);

        PostComments newlewcturer = new PostComments
                .Builder(lecturer.getComment())
                .copy(lecturer)
                .comment("123")
                .build();

        repository.save(newlewcturer);

        PostComments updatedLecturer = repository.findOne(id);
        org.testng.Assert.assertEquals(updatedLecturer.getComment(),"123");

    }

    @org.testng.annotations.Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        PostComments lecturer = repository.findOne(id);
        repository.delete(lecturer);
        PostComments deletedLecturer = repository.findOne(id);
        org.testng.Assert.assertNull(deletedLecturer);

    }

    public PostCommentsCrudTestNG() {
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
