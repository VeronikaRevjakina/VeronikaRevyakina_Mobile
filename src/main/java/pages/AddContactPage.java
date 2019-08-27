package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class AddContactPage {

    protected AppiumDriver driver;
    private static final String appPackageName =
            "com.example.android.contactmanager:id/";

    @AndroidFindBy(id = appPackageName+"accountSpinner")
    private AndroidElement accountSpinner;

    @AndroidFindBy(id = appPackageName+"contactNameEditText")
    private AndroidElement contactName;

    @AndroidFindBy(id = appPackageName+"contactPhoneEditText")
    private AndroidElement contactPhone;

    @AndroidFindBy(id = appPackageName+"contactEmailEditText")
    private AndroidElement contactEmail;

    public AndroidElement getAccountSpinner() {
        return accountSpinner;
    }

    public AndroidElement getContactName() {
        return contactName;
    }

    public AndroidElement getContactEmail() {
        return contactEmail;
    }

    public AndroidElement getContactPhone() {
        return contactPhone;
    }

    public AddContactPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
}
