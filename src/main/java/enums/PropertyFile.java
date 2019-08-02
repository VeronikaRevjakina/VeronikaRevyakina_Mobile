package enums;

public enum PropertyFile {

    NATIVE("/nativetest.properties"),
    WEB("/webtest.properties");

    final String path;

    PropertyFile(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
