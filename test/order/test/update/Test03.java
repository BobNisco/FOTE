package order.test.update;

import fote.entry.Comment;
import fote.entry.User;
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
         Comment fetchedComment = (Comment) MongoHelper.fetch(comment, "comments");
         if(fetchedComment == null)
             TestHelper.failed("comment not found");
         
         fetchedComment.setText("Edited Text");
         if(!MongoHelper.save(fetchedComment, "comments")){
             TestHelper.failed("text update failed");
         }
         
         Comment updatedComment = (Comment) MongoHelper.fetch(fetchedComment, "comments");

         TestHelper.asserting(fetchedComment.getText().equals(updatedComment.getText()));
         System.out.println("updated comment id: " + updatedComment.getId());
         
         TestHelper.passed();
     }
}