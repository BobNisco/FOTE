package order.test.delete;

import fote.entry.Proposal;
import fote.entry.Vote;
import fote.util.MongoHelper;
import java.util.ArrayList;
import java.util.Date;
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
public class Test04 {
    
    Proposal proposal = new Proposal(new Date(), "Test subject", "Test description", new Integer(5), new Integer(0), new ArrayList<String>(), new ArrayList<Integer>(), new ArrayList<Integer>(), new ArrayList<String>());
    
    public Test04() {
        
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
        MongoHelper.getCollection("proposals").drop();
       
        if(!MongoHelper.save(proposal, "proposals")) {
            TestHelper.failed("proposal save failed!");
        }
    }
    
    @After
    public void tearDown() {
        TestHelper.signoff(this);
    }
    
     @Test
     public void test() {
        if (!MongoHelper.delete(proposal, "proposals")) {
            TestHelper.failed("delete failed");
        }

        if (MongoHelper.fetch(proposal, "proposals") != null) {
            TestHelper.failed("proposal was not deleted");
        }

        System.out.println("Deleted proposal id: " + proposal.getId());
            
         TestHelper.passed();
     }
}
