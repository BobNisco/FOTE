package order.test.read;

import fote.entry.Attachment;
import fote.entry.Entry;
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
        
        if (!MongoHelper.save(vote, "votes")) {
            TestHelper.failed("save vote failed");
        }   
    }
    
    @After
    public void tearDown() {
        TestHelper.signoff(this);
    }
    
     @Test
     public void test() {
         MongoHelper.setDB("fote");
         Iterable<Entry> queryVotes = MongoHelper.query("{id:{$gte:0}}", 
                 Vote.class, "votes");
         
         int count = 0;
         for(Entry entry : queryVotes) {
             Vote vote = (Vote) entry;
             System.out.println("retrieved vote id: " + vote.getId()
                     + " " + vote.toString());
             
             count++;
         }
         TestHelper.asserting(count == 1);
     }
}
