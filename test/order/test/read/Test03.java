package order.test.read;

import fote.entry.Comment;
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
        MongoHelper.getCollection("comments").drop();
        
        if (!MongoHelper.save(comment, "comments")) {
            TestHelper.failed("save comment failed");
        }   
    }
    
    @After
    public void tearDown() {
        TestHelper.signoff(this);
    }
    
     @Test
     public void test() {
         MongoHelper.setDB("fote");
         Iterable<Entry> queryComments = MongoHelper.query("{id:{$gte:0}}", 
                 Comment.class, "comments");
         
         int count = 0;
         for(Entry entry : queryComments) {
             Comment comment = (Comment) entry;
             System.out.println("retrieved comment id: " + comment.getId()
                     + " " + comment.toString());
             
             count++;
         }
         TestHelper.asserting(count == 1);
     }
}
