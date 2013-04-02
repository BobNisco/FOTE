/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package order.test.create;

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
    
    Proposal proposal = new Proposal(new Date(), "Test subject", "Test description", new Integer(5), new Integer(0), new ArrayList<String>(), new ArrayList<Vote>(), new ArrayList<Integer>(), new ArrayList<Integer>());
    
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
    }
    
    @After
    public void tearDown() {
        TestHelper.signoff(this);
    }

     @Test
     public void test() {
        if (!MongoHelper.save(proposal, "proposals")) {
            TestHelper.failed("save failed");
        }
        System.out.println("saved comment with ID: " + proposal.getId() + 
                " " + proposal.toString());
        TestHelper.passed();
     }
}
