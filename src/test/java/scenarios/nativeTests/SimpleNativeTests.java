package scenarios.nativeTests;

import hooks.Hooks;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import setup.Driver;

import java.io.IOException;

import static org.testng.Assert.assertTrue;

@Test(groups = "native")
public class SimpleNativeTests extends Hooks {

    protected SimpleNativeTests() throws IOException {
        super("native");
    }

    @Test(description = "Just click on button 'Add contact'")
    public void simpleNativeTest(){

        String appPackageName = Driver.packageName;

        //Click add contact button
        By addContactBtn = By.id(appPackageName + "addContactButton");
        driverSingle.findElement(addContactBtn).click();
        System.out.println("Add contact button is clicked");

        //Check target account appears
        By targetAccount=By.id(appPackageName+"accountSpinner");
        assertTrue(driverSingle.findElement(targetAccount).isDisplayed());
        System.out.println("Target account field is displayed");

        //Check contact name appears
        By contactName=By.id(appPackageName+"contactNameEditText");
        assertTrue(driverSingle.findElement(contactName).isDisplayed());
        System.out.println("Contact Name field is displayed");

        //Check contact phone appears
        By contactPhone=By.id(appPackageName+"contactPhoneEditText");
        assertTrue(driverSingle.findElement(contactPhone).isDisplayed());
        System.out.println("Contact Phone field is displayed");

        //Check contact email appears
        By contactEmail=By.id(appPackageName+"contactEmailEditText");
        assertTrue(driverSingle.findElement(contactEmail).isDisplayed());
        System.out.println("Contact Email field is displayed");

        // Check keyboard appears by hideKeyboard() method which
        // hides keyboard if it is opened
        try {
            driverSingle.hideKeyboard();
            System.out.println("Keyboard was displayed");
        } catch (Exception e) {
            e.getMessage();
        }


        System.out.println("Simplest Appium test done");
    }

}
