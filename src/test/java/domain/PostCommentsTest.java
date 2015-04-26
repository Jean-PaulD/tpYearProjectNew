/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import com.mycompany.tpnew.domain.PostComments;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author JEAN-PAUL
 */
public class PostCommentsTest {
    
    public PostCommentsTest() {
    }
    
    
    @Test
    public void testCreation(){
        PostComments user = new PostComments
                .Builder("Jean-PaulD")
                .comment("I love you")
                .build();
        
        Assert.assertEquals("I love you", user.getComment());
        
    }
    
    @Test
    public void testUpdate(){
        PostComments user = new PostComments
                .Builder("Post17")
                .comment("I love you")
                .build();
        
        PostComments newUser = new PostComments
                .Builder(user.getPost())
                .copy(user)
                .comment("i HATE YOU")
                .build();
        
        Assert.assertEquals(user.getComment(), "I love you");
        Assert.assertEquals(newUser.getComment(), "i HATE YOU");
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
