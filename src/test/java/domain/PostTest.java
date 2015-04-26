/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import com.mycompany.tpnew.domain.Post;
import com.mycompany.tpnew.domain.User;
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
public class PostTest {
    
    public PostTest() {
    }
    
     @Test
    public void testCreation(){
        Post post = new Post 
                .Builder("Jean-PaulD")
                .username("Jean-PaulD")
                .acceptNum(2)
                .build();
        
        Assert.assertEquals("Jean-PaulD", post.getUsername());
        Assert.assertEquals(2, post.getAcceptNum());
        
    }
    
    @Test
    public void testUpdate(){
        Post post = new Post 
                .Builder("Jean-PaulD")
                .accept(true)
                .build();
        
        Post newPost = new Post 
                 .Builder(post.getUsername())
                .copy(post)
                .accept(false)
                .build();
                
        
        Assert.assertEquals(true, post.isAccept());
        Assert.assertEquals(false, newPost.isAccept());
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
