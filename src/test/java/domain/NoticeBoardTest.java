/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import com.mycompany.tpnew.domain.NoticeBoard;
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
public class NoticeBoardTest {
    
    public NoticeBoardTest() {
    }
    
    @Test
    public void testCreation(){
        NoticeBoard user = new NoticeBoard
                .Builder("Jean-PaulD")
                .build();
        
        Assert.assertEquals("Jean-PaulD", user.getNotice());
        
    }
    
    @Test
    public void testUpdate(){
        NoticeBoard user = new NoticeBoard
                .Builder("Jean-PaulD")
                
                .build();
        Assert.assertEquals("Jean-PaulD", user.getNotice());
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
