package scenarios.webTests;

import hooks.Hooks;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

@Test(groups = "web")
public class SimpleWebTests extends Hooks {

    protected SimpleWebTests() throws IOException {
        super("web");
    }

    @Test(description = "Open website")
    public void webTest() throws Exception {
        driver().get(SUT);
        driverWait().until(ExpectedConditions.urlToBe(SUT + "/"));
        //Check status OK
        driver().getStatus().containsValue("200");
        //Check page is opened
        assertEquals(driver().getTitle(),"Internet Assigned Numbers Authority");
        System.out.println("Page is opened");
    }

}


