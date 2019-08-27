package scenarios.webTests;

import hooks.Hooks;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.testng.Assert.assertEquals;

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
        //Check status OK
        checkStatusCode(SUT,200);
        //Check page is opened
        assertEquals(driver().getTitle(),"Internet Assigned Numbers Authority");
        System.out.println("Page is opened");
    }

    private void checkStatusCode(String site, int expectedCode) throws Exception {
        URL url = new URL(site);
        HttpURLConnection http = (HttpURLConnection) url.openConnection();
        int statusCode = http.getResponseCode();
        assertEquals(statusCode, expectedCode);
    }

}


