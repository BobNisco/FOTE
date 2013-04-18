package order.test.create;

import fote.entry.User;
import fote.util.MongoHelper;
import order.test.util.TestHelper;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Evan
 */
public class Test01 {
    private User[] users = {
      // Put in some dummy data
      new User("Evan", "Van Dam", "evan@marist.edu", "password123"),
      new User("Bob", "Nisco", "bob@marist.edu", "password123"),
      new User("Jason", "Parraga", "jason@marist.edu", "password123")
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
    }
    
    @After
    public void tearDown() {
        TestHelper.signoff(this);
    }
    
     @Test
     public void test() {
         for(User user : users) {
            if(!MongoHelper.save(user, "users"))
                TestHelper.failed("save failed");
            System.out.println("saved user id: " + user.getId() + " " + user.toString());
         } 
         TestHelper.passed();
     }
}