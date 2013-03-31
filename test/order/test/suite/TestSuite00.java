package order.test.suite;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Runs the entire suite of tests for FOTE.
 * @author Bob Nisco, Evan Van Dam, Jason Parraga
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
    order.test.create.UserCreate.class,
    order.test.create.Test01.class,
    order.test.read.UserRead.class,
    order.test.read.Test01.class,
    order.test.update.UserUpdate.class,
    order.test.update.Test01.class,
    order.test.delete.UserDelete.class,
    order.test.delete.Test01.class
})

public class TestSuite00 {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
