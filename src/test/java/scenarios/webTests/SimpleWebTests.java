package scenarios.webTests;

import hooks.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Web Test for checking web application is working properly
 */
@Test(groups = "web")
public class SimpleWebTests extends Hooks {
    /**
     * Constructor with
     * @parameter "web"/"native"
     * to pass to parent constructor for
     * right initialization
     */
    protected SimpleWebTests() throws IOException {
        super("web");
    }

    @Test(description = "Open website")
    public void webTest() throws Exception {
        driver().get(SUT);
        driverWait().until(ExpectedConditions.urlToBe(SUT + "/"));
        //Check page is opened
        assertEquals(driver().getTitle(),"Internet Assigned Numbers Authority");

        //Check logo on site is displaye that means site is loading
        assertTrue(driverSingle.findElement(By.linkText("Domain Names")).isDisplayed());

        System.out.println("Page is opened");
    }

}


