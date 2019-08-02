package setup;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Driver extends TestProperties{
    protected static AppiumDriver driverSingle = null;
    private static WebDriverWait waitSingle;
    protected DesiredCapabilities capabilities;


    // Properties to be read
    protected static String AUT;// (mobile) app under testing
    protected static String SUT;// site under testing
    protected static String TEST_PLATFORM;
    protected static String DRIVER;
    protected static String packageName;

    // Constructor initializes properties on driverSingle creation
    protected Driver(String appType) throws IOException {
        String t_aut = getProp(appType, "aut");
        AUT = t_aut == null ? null :  System.getProperty("user.dir") + t_aut;
        packageName = getProp(appType, "packagename");
        String t_sut = getProp(appType, "sut");
        SUT = t_sut == null ? null : "https://" + t_sut;
        TEST_PLATFORM = getProp(appType, "platform");
        DRIVER = getProp(appType, "driver");
    }

    /**
     * Initialize driverSingle with appropriate capabilities
     * depending on platform and application
     *
     * @throws Exception
     */
    protected void prepareDriver() throws Exception {
        capabilities = new DesiredCapabilities();
        String browserName;

        // Setup test platform: Android or iOS. Browser is also platform-dependent
        switch (TEST_PLATFORM) {
            case "Android":
                // default Android emulator
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,
                        "emulator-5554");
                browserName = "Chrome";
                break;
            case "iOS":
                browserName = "Safari";
                break;
            default:
                throw new Exception("Unknown mobile platform");
        }
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, TEST_PLATFORM);

        // Setup type of application: mobile / web / hybrid
        if (AUT != null && SUT == null) {
            // Native
            File app = new File(AUT);
            capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        } else if (SUT != null && AUT==null) {
            // Web
            capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, browserName);
        } else {
            throw new Exception("Unclear type of mobile app");
        }

        // Init driverSingle for local Appium server with set capabilities
        if (driverSingle == null) {
            driverSingle = new AppiumDriver(new URL(DRIVER), capabilities);
        }
        // Set an object to handle timeouts
        if (waitSingle == null) {
            waitSingle = new WebDriverWait(driver(), 10);
        }
    }

    protected AppiumDriver driver() throws Exception {
        if (driverSingle == null) {
            prepareDriver();
        }
        return driverSingle;
    }

    protected WebDriverWait driverWait() throws Exception {
        return waitSingle;
    }
}
