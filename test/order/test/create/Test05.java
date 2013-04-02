/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package order.test.create;

import fote.entry.Vote;
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
    
    Vote vote = new Vote(new Integer(0), new Integer(1), new Integer(1));
    
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
        MongoHelper.getCollection("votes").drop();
    }
    
    @After
    public void tearDown() {
        TestHelper.signoff(this);
    }

     @Test
     public void test() {
        if (!MongoHelper.save(vote, "votes")) {
            TestHelper.failed("save failed");
        }
        System.out.println("saved vote with ID: " + vote.getId() + 
                " " + vote.toString());
        TestHelper.passed();
     }
}
