package order.test.create;

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
 * This class tests an insert of a Suggestion into the MongoDB persistence layer
 * @author Bob Nisco
 */
public class Test01 {
    private Suggestion suggestion = new Suggestion("Test Suggestion", 
            "Test Description", 0, new ArrayList<Integer>(),  
            new ArrayList<Integer>());
    
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
        // Put in a test user beforehand
        User user = new User("Linus", "Torvalds");
        if (!MongoHelper.save(user, "users")) {
            TestHelper.failed("save failed");
        }
    }
    
    @After
    public void tearDown() {
        TestHelper.signoff(this);
    }

     @Test
     public void test() {
        if (!MongoHelper.save(suggestion, "suggestions")) {
            TestHelper.failed("save failed");
        }
        System.out.println("saved suggestion with ID: " + suggestion.getId() + 
                " " + suggestion.toString());
        TestHelper.passed();
     }
}
