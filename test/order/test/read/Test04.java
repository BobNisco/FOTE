package order.test.read;

import fote.entry.Entry;
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
    Proposal proposal = new Proposal(new Date(), "Test subject", "Test description", new Integer(5), new Integer(0), new ArrayList<String>(), new ArrayList<Vote>(), new ArrayList<Integer>(), new ArrayList<String>());
    
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
        
        if (!MongoHelper.save(proposal, "proposals")) {
            TestHelper.failed("save proposal failed");
        }   
    }
    
    @After
    public void tearDown() {
        TestHelper.signoff(this);
    }
    
     @Test
     public void test() {
         MongoHelper.setDB("fote");
         Iterable<Entry> queryProposals = MongoHelper.query("{id:{$gte:0}}", 
                 Proposal.class, "proposals");
         
         int count = 0;
         for(Entry entry : queryProposals) {
             Proposal proposal = (Proposal) entry;
             System.out.println("retrieved proposal id: " + proposal.getId()
                     + " " + proposal.toString());
             
             count++;
         }
         TestHelper.asserting(count == 1);
     }
}
