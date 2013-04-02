/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package order.test.create;

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
    }
    
    @After
    public void tearDown() {
        TestHelper.signoff(this);
    }

     @Test
     public void test() {
        if (!MongoHelper.save(attachment, "attachments")) {
            TestHelper.failed("save failed");
        }
        System.out.println("saved attachment with ID: " + attachment.getId() + 
                " " + attachment.toString());
        TestHelper.passed();
     }
}
