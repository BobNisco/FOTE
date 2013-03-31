package order.test.update;

import fote.entry.Attachment;
import fote.entry.Suggestion;
import fote.entry.User;
import fote.util.MongoHelper;
import java.util.ArrayList;
import order.test.util.TestHelper;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Bob Nisco
 */
public class Test01 {
    private Suggestion mySuggestion = new Suggestion();
    
    public Test01() {
        
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
        MongoHelper.getCollection("suggestions").drop();
        MongoHelper.save(mySuggestion, "suggestions");
    }
    
    @After
    public void tearDown() {
        TestHelper.signoff(this);
    }
    
     @Test
     public void test() {
         Suggestion suggestion = (Suggestion) MongoHelper.fetch(mySuggestion, "suggestions");
         if (suggestion == null) {
             TestHelper.failed("suggestion not found");
         }
         
         suggestion.setSubject("Test Subject");
         if (!MongoHelper.save(suggestion, "suggestions")) {
             TestHelper.failed("subject update failed");
         }
         
         suggestion.setDescription("Test Description");
         if (!MongoHelper.save(suggestion, "suggestions")) {
             TestHelper.failed("description update failed");
         }
         
         ArrayList<Integer> attachments = new ArrayList<Integer>();
         attachments.add(1);
         attachments.add(2);
         suggestion.setAttachments(attachments);
         if (!MongoHelper.save(suggestion, "suggestions")) {
             TestHelper.failed("attachments update failed");
         }
         
         suggestion.setAuthor(1);
         if (!MongoHelper.save(suggestion, "suggestions")) {
             TestHelper.failed("AuthorID update failed");
         }
         
         ArrayList<Integer> comments = new ArrayList<Integer>();
         comments.add(1);
         comments.add(2);
         suggestion.setComments(comments);
         if (!MongoHelper.save(suggestion, "suggestions")) {
             TestHelper.failed("comments update failed");
         }         
         
         Suggestion fetchedSuggestion = (Suggestion) MongoHelper.fetch(suggestion, "suggestions");

         TestHelper.asserting(suggestion.getSubject().equals(fetchedSuggestion.getSubject()));
         TestHelper.asserting(suggestion.getAttachments().equals(fetchedSuggestion.getAttachments()));
         TestHelper.asserting(suggestion.getAuthor().equals(fetchedSuggestion.getAuthor()));
         TestHelper.asserting(suggestion.getComments().equals(fetchedSuggestion.getComments()));
         TestHelper.asserting(suggestion.getDescription().equals(fetchedSuggestion.getDescription()));
         
         System.out.println("updated suggestion id: " + suggestion.getId());
         
         TestHelper.passed();
     }
}
