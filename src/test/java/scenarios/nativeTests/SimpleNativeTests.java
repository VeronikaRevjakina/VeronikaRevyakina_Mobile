package scenarios.nativeTests;

import hooks.Hooks;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.AddContactPage;
import pages.HomePage;
import setup.Driver;

import java.io.IOException;

import static org.testng.Assert.assertTrue;

/**
 * Native Test for checking web application is working properly
 */
@Test(groups = "native")
public class SimpleNativeTests extends Hooks {

    private HomePage homePage;
    private AddContactPage addContactPage;
    /**
     * Constructor with
     * @parameter "web"/"native"
     * to pass to parent constructor for
     * right initialization
     */
    protected SimpleNativeTests() throws Exception {
        super("native");
        homePage=new HomePage(driver());
        addContactPage=new AddContactPage(driver());
    }

    @Test(description = "Just click on button 'Add contact'")
    public void simpleNativeTest(){

        String appPackageName = Driver.packageName;

        //Click add contact button
        homePage.getAddContactButton().click();
        System.out.println("Add contact button is clicked");

        //Check target account appears
        assertTrue(addContactPage.getAccountSpinner().isDisplayed());
        System.out.println("Target account field is displayed");

        //Check contact name appears
        assertTrue(addContactPage.getContactName().isDisplayed());
        System.out.println("Contact Name field is displayed");

        //Check contact phone appears
        assertTrue(addContactPage.getContactPhone().isDisplayed());
        System.out.println("Contact Phone field is displayed");

        //Check contact email appears
        assertTrue(addContactPage.getContactEmail().isDisplayed());
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
