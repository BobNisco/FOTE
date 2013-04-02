/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package order.test.create;

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
        MongoHelper.getCollection("comments").drop();
    }
    
    @After
    public void tearDown() {
        TestHelper.signoff(this);
    }

     @Test
     public void test() {
        if (!MongoHelper.save(comment, "comments")) {
            TestHelper.failed("save failed");
        }
        System.out.println("saved comment with ID: " + comment.getId() + 
                " " + comment.toString());
        TestHelper.passed();
     }
}
