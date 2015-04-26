/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import com.mycompany.tpnew.domain.Complaints;
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
public class ComplaintsTest {
    
    public ComplaintsTest() {
    }
    
     @Test
    public void testCreation(){
        Complaints complaints = new Complaints
                .Builder("Jean-PaulD")
                .complaint("This website sucks")
                .build();
        
        Assert.assertEquals(complaints.getUsername(), "Jean-PaulD" );
        Assert.assertEquals(complaints.getComplaint(), "This website sucks");
        
    }
    
    @Test
    public void testUpdate(){
        Complaints complaints = new Complaints
                .Builder("Jean-PaulD")
                .complaint("This website sucks")
                .build();
        
        Complaints newComplaints = new Complaints
                .Builder(complaints.getUsername())
                .copy(complaints)
                .complaint("I am a troll").build();
        
        Assert.assertEquals(complaints.getComplaint(), "This website sucks");
        Assert.assertEquals(newComplaints.getComplaint(), "I am a troll");
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
