/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import com.mycompany.tpnew.domain.Notification;
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
public class NotificationTest {
    
    public NotificationTest() {
    }
    
    @Test
    public void testCreation(){
        Notification user = new Notification
                .Builder("Jean-PaulD")
                .comment("A")
                .build();
        
        Assert.assertEquals("Jean-PaulD", user.getUsername() );
        Assert.assertEquals("A", user.getComment());
        
    }
    
    @Test
    public void testUpdate(){
         Notification user = new Notification
                .Builder("Jean-PaulD")
                .comment("A")
                .build();
        
        Notification newUser = new Notification
                .Builder(user.getUsername())
                .copy(user)
                .comment("B")
                .build();
        
        Assert.assertEquals(user.getComment(), "A");
        Assert.assertEquals(newUser.getComment(), "B");
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
