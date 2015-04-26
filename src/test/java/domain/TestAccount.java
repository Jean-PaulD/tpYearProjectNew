package domain;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.tpnew.domain.AccountInfo;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author JEAN-PAUL
 */
public class TestAccount {
    
    public TestAccount() {
    }
    
    @Test
    public void testCreation(){
        AccountInfo account = new AccountInfo
                .Builder("Jean-PaulD")
                .dateCreated("24/04/2015")
                .build();
        
        Assert.assertEquals(account.getUsername(), "Jean-PaulD" );
        Assert.assertEquals(account.getDateCreated(), "24/04/2015" );
        
    }
    
    @Test
    public void testUpdate(){
        AccountInfo account = new AccountInfo
                .Builder("Jean-PaulD")
                .dateCreated("24/04/2015")
                .build();
        
        AccountInfo newAccount = new AccountInfo
                .Builder(account.getUsername())
                .copy(account)
                .dateCreated("24/04/2016").build();
        
        Assert.assertEquals(account.getDateCreated(), "24/04/2015");
        Assert.assertEquals(newAccount.getDateCreated(), "24/04/2016");
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
