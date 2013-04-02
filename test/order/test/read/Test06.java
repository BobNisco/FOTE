package order.test.read;

import fote.entry.Attachment;
import fote.entry.Entry;
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
         MongoHelper.setDB("fote");
         Iterable<Entry> queryAttachments = MongoHelper.query("{id:{$gte:0}}", 
                 Attachment.class, "attachments");
         
         int count = 0;
         for(Entry entry : queryAttachments) {
             Attachment attachment = (Attachment) entry;
             System.out.println("retrieved attachment id: " + attachment.getId()
                     + " " + attachment.toString());
             
             count++;
         }
         TestHelper.asserting(count == 1);
     }
}
