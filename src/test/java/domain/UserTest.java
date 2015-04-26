/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

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
public class UserTest {
    
    public UserTest() {
    }
    
     @Test
    public void testCreation(){
        User user = new User
                .Builder("Jean-PaulD")
                .age(23)
                .build();
        
        Assert.assertEquals(user.getUsername(), "Jean-PaulD" );
        Assert.assertEquals(user.getAge(), 23 );
        
    }
    
    @Test
    public void testUpdate(){
        User user = new User
                .Builder("Jean-PaulD")
                .age(23)
                .build();
        
        User newUser = new User
                .Builder(user.getUsername())
                .copy(user)
                .age(24).build();
        
        Assert.assertEquals(user.getAge(), 23);
        Assert.assertEquals(newUser.getAge(), 24);
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
