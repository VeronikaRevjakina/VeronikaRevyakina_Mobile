package setup;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Class required to process properties
 */
public class TestProperties {
    Properties currentProps = new Properties();

    public static final String WEB = "/webtest.properties";
    public static final String NATIVE = "/nativetest.properties";

    String propertyPath;

    /**
     * Getting property by application type "web"/"native"
     *
     * @param appType
     * @return required property
     * @throws IOException
     */
    Properties getCurrentProps(String appType) throws IOException {
        if (appType.equals("web")) {
            propertyPath = WEB;
        } else if (appType.equals("native")) {
            propertyPath = NATIVE;
        } else {
            System.out.println("Unclear type of mobile app");
        }
        FileInputStream in = new FileInputStream(
                System.getProperty("user.dir") + propertyPath);
        currentProps.load(in);
        in.close();
        return currentProps;
    }

    protected String getProp(String appType, String propKey) throws IOException {
        if (!currentProps.containsKey(propKey)) {
            currentProps = getCurrentProps(appType);
        }
        // "default" form used to handle the absence of a parameter
        return currentProps.getProperty(propKey, null);
    }
}
