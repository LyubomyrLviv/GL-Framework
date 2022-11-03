package util;

public class SystemProperties {

    public static final String APPLICATION_URL = System.getProperty("application.url");
    public static final String API_KEY = System.getProperty("api.key");
    public static final String API_TOKEN = System.getProperty("api.secret");
    public static final String TEST_NAME_PREFIX = "FUNCTIONAL_TEST_BLAH_";


    private SystemProperties() {   }



}
