package order.test.delete;

import fote.entry.Comment;
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
public class Test03 {
    
    private Comment comment = new Comment("This is a comment", 1);
    
    public Test03() {
        
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
        MongoHelper.getCollection("users").drop();
        MongoHelper.getCollection("suggestions").drop();
       
        if(!MongoHelper.save(comment, "comments")) {
            TestHelper.failed("comments save failed!");
        }
    }
    
    @After
    public void tearDown() {
        TestHelper.signoff(this);
    }
    
     @Test
     public void test() {
        if (!MongoHelper.delete(comment, "comments")) {
            TestHelper.failed("delete failed");
        }

        if (MongoHelper.fetch(comment, "comments") != null) {
            TestHelper.failed("comment was not deleted");
        }

        System.out.println("Deleted suggestion id: " + comment.getId());
            
         TestHelper.passed();
     }
}
