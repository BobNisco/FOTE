package order.test.update;

import fote.entry.Attachment;
import fote.util.MongoHelper;
import order.test.util.TestHelper;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Jason
 */
public class Test06 {
    Attachment attachment = new Attachment(new Integer(0), "test.txt");
    
    public Test06() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        TestHelper.signon(this);
        MongoHelper.setDB("fote");
        MongoHelper.getCollection("attachments").drop();
        if (!MongoHelper.save(attachment, "attachments")) {
            TestHelper.failed("save attachment failed");
        }   
    }
    
    @After
    public void tearDown() {
        TestHelper.signoff(this);
    }
    
     @Test
     public void test() {
         Attachment fetchedAttachment = (Attachment) MongoHelper.fetch(attachment, "attachments");
         if(fetchedAttachment == null)
             TestHelper.failed("attachment not found");
         
         fetchedAttachment.setFileName("changed.txt");
         if(!MongoHelper.save(fetchedAttachment, "attachments")){
             TestHelper.failed("FileName update failed");
         }
       
         Attachment updatedAttachment = (Attachment) MongoHelper.fetch(fetchedAttachment, "attachments");

         TestHelper.asserting(fetchedAttachment.getFileName().equals(updatedAttachment.getFileName()));
      
         System.out.println("updated Attachment id: " + updatedAttachment.getId());
         
         TestHelper.passed();
     }
}