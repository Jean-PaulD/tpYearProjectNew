package service;

import com.mycompany.tpnew.App;
import com.mycompany.tpnew.config.factory.ComplaintsFactory;
import com.mycompany.tpnew.domain.Complaints;
import com.mycompany.tpnew.repository.ComplaintsRepository;
import com.mycompany.tpnew.services.ComplaintsService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 5/17/15.
 */

@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class ComplaintsServiceTestNGTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private ComplaintsService service;

    private List<Complaints> complaints;
    private Long id;

    @Autowired
    private ComplaintsRepository repository;

    @Test
    public void create() throws Exception {

        Complaints complaint1 = ComplaintsFactory
                .createComplaint("JP","14:00", "This sucks1");
        Complaints complaint2 = ComplaintsFactory
                .createComplaint("JP","14:00", "This sucks2");
        Complaints complaint3 = ComplaintsFactory
                .createComplaint("JP","14:00", "This sucks3");

        Complaints complaint4 = ComplaintsFactory
                .createComplaint("JP","14:00", "This sucks3");


        complaints.add(complaint1);
        complaints.add(complaint2);
        complaints.add(complaint3);
        complaints.add(complaint4);


        repository.save(complaints);
        id=complaint4.getId();


        Assert.assertNotNull(complaint1.getId());
        Assert.assertNotNull(complaint2.getId());
        Assert.assertNotNull(complaint3.getId());
        Assert.assertNotNull(complaint4.getId());

    }


    @Test
    public void testGetComplaints() throws Exception {
        List<Complaints> departments = service.getComplaints();
        Assert.assertTrue(departments.size() == 2);

    }


    @BeforeMethod
    public void setUp() throws Exception {
        complaints = new ArrayList<Complaints>();

    }



    @AfterMethod
    public void tearDown() throws Exception {

    }
}