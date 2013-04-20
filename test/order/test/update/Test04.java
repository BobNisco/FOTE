package order.test.update;

import fote.entry.Comment;
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
         Proposal fetchedProposal = (Proposal) MongoHelper.fetch(proposal, "proposals");
         if(fetchedProposal == null)
             TestHelper.failed("proposal not found");
         
         fetchedProposal.setExpirationDate(new Date());
         if(!MongoHelper.save(fetchedProposal, "proposals")){
             TestHelper.failed("date update failed");
         }
         
         fetchedProposal.setSubject("Edited Subject");
         if(!MongoHelper.save(fetchedProposal, "proposals")){
             TestHelper.failed("subject update failed");
         }
         
         fetchedProposal.setDescription("Edited Description");
         if(!MongoHelper.save(fetchedProposal, "proposals")){
             TestHelper.failed("description update failed");
         }
         
         fetchedProposal.setPriority(new Integer(10));
         if(!MongoHelper.save(fetchedProposal, "proposals")){
             TestHelper.failed("priority update failed");
         }
         
         fetchedProposal.setAuthor(new Integer(10));
         if(!MongoHelper.save(fetchedProposal, "proposals")){
             TestHelper.failed("author update failed");
         }
         
         ArrayList<String> options = new ArrayList<String>();
         options.add("test");
         fetchedProposal.setOptions(options);
         if(!MongoHelper.save(fetchedProposal, "proposals")){
             TestHelper.failed("options update failed");
         }
         
         ArrayList<Vote> votes = new ArrayList<Vote>();
         Vote vote = new Vote(new Integer(0), new Integer(0), new Integer(0));
         votes.add(vote);
         fetchedProposal.setVotes(votes);
         if(!MongoHelper.save(fetchedProposal, "proposals")){
             TestHelper.failed("votes update failed");
         }
         
         ArrayList<Integer> comments = new ArrayList<Integer>();
         comments.add(new Integer(1));
         fetchedProposal.setComments(comments);
         if(!MongoHelper.save(fetchedProposal, "proposals")){
             TestHelper.failed("comments update failed");
         }
         
         ArrayList<Integer> attachments = new ArrayList<Integer>();
         attachments.add(new Integer(1));
         fetchedProposal.setComments(attachments);
         if(!MongoHelper.save(fetchedProposal, "proposals")){
             TestHelper.failed("attachments update failed");
         }
         
         Proposal updatedProposal = (Proposal) MongoHelper.fetch(fetchedProposal, "proposals");

         TestHelper.asserting(fetchedProposal.getExpirationDate().toString().equals(updatedProposal.getExpirationDate().toString()));
         TestHelper.asserting(fetchedProposal.getSubject().equals(updatedProposal.getSubject()));
         TestHelper.asserting(fetchedProposal.getDescription().equals(updatedProposal.getDescription()));
         TestHelper.asserting(fetchedProposal.getOptions().size() == updatedProposal.getOptions().size());
         TestHelper.asserting(fetchedProposal.getComments().size() == updatedProposal.getComments().size());
         TestHelper.asserting(fetchedProposal.getVotes().size() == updatedProposal.getVotes().size());
         TestHelper.asserting(fetchedProposal.getAttachments().size() == updatedProposal.getAttachments().size());
         System.out.println("updated Proposal id: " + updatedProposal.getId());
         
         TestHelper.passed();
     }
}