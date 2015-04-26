/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import com.mycompany.tpnew.domain.Admin;
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
public class AdminTest {
    
    public AdminTest() {
    }
    
     @Test
    public void testCreation(){
        Admin user = new Admin
                .Builder("Jean-PaulD")
                .build();
        
        Assert.assertEquals(user.getUsername(), "Jean-PaulD" );
        
    }
    
    @Test
    public void testUpdate(){
        Admin admin = new Admin
                .Builder("Jean-PaulD")
                .build();
        
         Assert.assertEquals(admin.getUsername(), "Jean-PaulD" );
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
