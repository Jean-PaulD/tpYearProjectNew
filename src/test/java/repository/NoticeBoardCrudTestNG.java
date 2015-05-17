package repository;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.tpnew.App;
import com.mycompany.tpnew.config.factory.NoticeBoardFactory;
import com.mycompany.tpnew.domain.NoticeBoard;
import com.mycompany.tpnew.repository.NoticeBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 *
 * @author JEAN-PAUL
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class NoticeBoardCrudTestNG extends AbstractTestNGSpringContextTests{
    
    private Long id;
    @Autowired 
    private NoticeBoardRepository repository;
    
    @Test
    public void create() throws Exception {

        NoticeBoard newNoticeBoard = NoticeBoardFactory
                
                .createNoticeBoard("user1");
        
        repository.save(newNoticeBoard);
        id = newNoticeBoard.getId();
        Assert.assertNotNull(newNoticeBoard);
        
        
        }
    
    @org.testng.annotations.Test(dependsOnMethods = "create")
    public void read() throws Exception {
        NoticeBoard lecturer = repository.findOne(id);
        org.testng.Assert.assertNotNull(lecturer);


    }

    @org.testng.annotations.Test(dependsOnMethods = "read")
    public void update() throws Exception {
        NoticeBoard lecturer = repository.findOne(id);

        NoticeBoard newlewcturer = new NoticeBoard
                .Builder(lecturer.getNotice())
                .copy(lecturer)
                .build();

        repository.save(newlewcturer);

        NoticeBoard updatedLecturer = repository.findOne(id);
        //org.testng.Assert.assertEquals(updatedLecturer.getPassword(),"123");

    }

    @org.testng.annotations.Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        NoticeBoard lecturer = repository.findOne(id);
        repository.delete(lecturer);
        NoticeBoard deletedLecturer = repository.findOne(id);
        org.testng.Assert.assertNull(deletedLecturer);

    }
    
    
    
    
    
    
    public NoticeBoardCrudTestNG() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}
