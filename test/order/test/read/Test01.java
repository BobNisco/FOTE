package order.test.read;

import fote.entry.Entry;
import fote.entry.Suggestion;
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
    private Suggestion[] suggestions = {
        new Suggestion("Test Suggestion1", 
            "Test Description", new Integer(0), new ArrayList<Integer>(),  
            new ArrayList<String>()),
         new Suggestion("Test Suggestion2", 
            "Test Description", new Integer(0), new ArrayList<Integer>(),  
            new ArrayList<String>()),
         new Suggestion("Test Suggestion3", 
            "Test Description", new Integer(0), new ArrayList<Integer>(),  
            new ArrayList<String>()),
    };
    
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
        
        for(Suggestion suggestion : suggestions) {
            if (!MongoHelper.save(suggestion, "suggestions")) {
                TestHelper.failed("save suggestion failed");
            }
            
        }
    }
    
    @After
    public void tearDown() {
        TestHelper.signoff(this);
    }
    
     @Test
     public void test() {
         MongoHelper.setDB("fote");
         Iterable<Entry> querySuggestions = MongoHelper.query("{id:{$gte:0}}", 
                 Suggestion.class, "suggestions");
         int count = 0;
         for(Entry entry : querySuggestions) {
             Suggestion suggestion = (Suggestion) entry;
             System.out.println("retrieved suggestion id: " + suggestion.getId()
                     + " " + suggestion.toString());
             
             count++;
         }
         TestHelper.asserting(count == suggestions.length);
     }
}
