/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import com.mycompany.tpnew.App;
import com.mycompany.tpnew.config.factory.AccountFactory;

import com.mycompany.tpnew.domain.AccountInfo;
import com.mycompany.tpnew.repository.AccountInfoRepository;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 *
 * @author JEAN-PAUL
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class AccountRespositoryTest extends AbstractTestNGSpringContextTests{
    
    private Long id;
    @Autowired 
    private AccountInfoRepository repository;
    
    @Test
    public void create() throws Exception {

        AccountInfo newAccount = AccountFactory
                .createAccount("user1", "3rd", "xxx");
        
        repository.save(newAccount);
        id = newAccount.getId();
        Assert.assertNotNull(newAccount.getId());
        /*  
        
        AccountInfo deptaddress = ContactFactory
                .createContact("dept@test.com", "7550");
        AccountInfo it = DepartmentFactory
                .createDepartment(deptaddress, "IT", null);
        Department arts = DepartmentFactory
                .createDepartment(deptaddress,"ART",null);

        ContactAddress facultyaddress = ContactFactory
                .createContact("faculty@test.com", "7550");

        List<Department> departments = new ArrayList<Department>();
        departments.add(it);
        departments.add(arts);

        Faculty faculty = FacultyFactory
                .createFaculty(facultyaddress,departments,"FID");

        repository.save(faculty);
        id=faculty.getId();
        Assert.assertNotNull(faculty.getId());
    */
        
        }

    
    public AccountRespositoryTest() {
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
