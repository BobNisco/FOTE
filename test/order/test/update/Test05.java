package order.test.update;

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
         Vote fetchedVote = (Vote) MongoHelper.fetch(vote, "votes");
         if(fetchedVote == null)
             TestHelper.failed("vote not found");
         
         fetchedVote.setOptionID(new Integer(5));
         if(!MongoHelper.save(fetchedVote, "votes")){
             TestHelper.failed("Option ID update failed");
         }
       
         Vote updatedVote = (Vote) MongoHelper.fetch(fetchedVote, "votes");

         TestHelper.asserting(fetchedVote.getOptionID().equals(updatedVote.getOptionID()));
      
         System.out.println("updated Vote id: " + updatedVote.getId());
         
         TestHelper.passed();
     }
}