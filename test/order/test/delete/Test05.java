package order.test.delete;

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
public class Test05 {
    
    Attachment attachment = new Attachment(new Integer(0), "test.txt");
    
    public Test05() {
        
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
       
        if(!MongoHelper.save(attachment, "attachments")) {
            TestHelper.failed("attachment save failed!");
        }
    }
    
    @After
    public void tearDown() {
        TestHelper.signoff(this);
    }
    
     @Test
     public void test() {
        if (!MongoHelper.delete(attachment, "attachments")) {
            TestHelper.failed("delete failed");
        }

        if (MongoHelper.fetch(attachment, "attachments") != null) {
            TestHelper.failed("vote was not deleted");
        }

        System.out.println("Deleted attachment id: " + attachment.getId());
            
         TestHelper.passed();
     }
}
