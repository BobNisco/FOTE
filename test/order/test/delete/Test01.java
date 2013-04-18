package order.test.delete;

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
    private User[] users = {
      new User("Evan", "Van Dam", "evan@marist.edu", "password123"),
      new User("Bob", "Nisco", "bob@marist.edu", "password123"),
      new User("Jason", "Parraga", "jason@marist.edu", "password123")
    };
    private Suggestion[] suggestions = {
        new Suggestion("Test Suggestion1", 
            "Test Description1", 0, new ArrayList<Integer>(),  
            new ArrayList<Integer>()),
        new Suggestion("Test Suggestion2", 
            "Test Description2", 1, new ArrayList<Integer>(),  
            new ArrayList<Integer>()),
        new Suggestion("Test Suggestion3", 
            "Test Description3", 2, new ArrayList<Integer>(),  
            new ArrayList<Integer>())
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
        MongoHelper.getCollection("users").drop();
        MongoHelper.getCollection("suggestions").drop();
        
        for (User user : users) {
            if(!MongoHelper.save(user, "users")) {
                TestHelper.failed("user save failed!");
            }
        }
        for (Suggestion suggestion : suggestions) {
            if(!MongoHelper.save(suggestion, "suggestions")) {
                TestHelper.failed("suggestion save failed!");
            }
        }
    }
    
    @After
    public void tearDown() {
        TestHelper.signoff(this);
    }
    
     @Test
     public void test() {
         for(Suggestion suggestion : suggestions) {
            if (!MongoHelper.delete(suggestion, "suggestions")) {
                TestHelper.failed("delete failed");
            }

            if (MongoHelper.fetch(suggestion, "suggestions") != null) {
                TestHelper.failed("suggestion was not deleted");
            }

            System.out.println("Deleted suggestion id: " + suggestion.getId());
         }
         TestHelper.passed();
     }
}
