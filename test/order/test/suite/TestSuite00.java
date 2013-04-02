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
    order.test.create.Test06.class,
    order.test.create.Test05.class,
    order.test.create.Test04.class,
    order.test.create.Test03.class,
    order.test.create.Test02.class,
    order.test.create.Test01.class,
    order.test.read.Test06.class,
    order.test.read.Test05.class,
    order.test.read.Test04.class,
    order.test.read.Test03.class,
    order.test.read.Test02.class,
    order.test.read.Test01.class,
    order.test.update.Test06.class,
    order.test.update.Test05.class,
    order.test.update.Test04.class,
    order.test.update.Test03.class,
    order.test.update.Test02.class,
    order.test.update.Test01.class,
    order.test.delete.Test06.class,
    order.test.delete.Test05.class,
    order.test.delete.Test04.class,
    order.test.delete.Test03.class,
    order.test.delete.Test02.class,
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
