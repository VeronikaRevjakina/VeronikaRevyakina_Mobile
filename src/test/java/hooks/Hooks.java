package hooks;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import setup.Driver;

import java.io.IOException;

/**
 * Class abstraction for setUp() and tearDown() methods
 */
@Test(groups = {"native", "web"})
public class Hooks extends Driver {
    /**
     * Constructor with
     * @parameter appType required "web"/"native"
     * to pass to parent constructor for
     * right initialization
     */
    public Hooks(String appType) throws IOException {
        super(appType);
    }

    @BeforeSuite(description = "Prepare driver to run test(s)")
    public void setUp() throws Exception {
        prepareDriver();
        System.out.println("Driver prepared");

    }

    @AfterSuite(description = "Close driver on all tests completion")
    public void tearDown(String appType) throws Exception {
        driverSingle.close();
        System.out.println("Driver closed");
    }


}
