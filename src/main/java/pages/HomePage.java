package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    protected AppiumDriver driver;
    private static final String appPackageName =
            "com.example.android.contactmanager:id/";

    @AndroidFindBy(id = appPackageName + "addContactButton")
    private AndroidElement addContactButton;

    public AndroidElement getAddContactButton() {
        return addContactButton;
    }

    public HomePage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
}
