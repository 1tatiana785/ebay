package Core;

import java.io.File;

public class Constants {
    public static String browserName = "chrome";
    public static String url = "https://www.ebay.com/";
    public static String DRIVER_CHROME = new File("src/main/resources/chromedriver").getAbsolutePath();
    public static String DRIVER_FIREFOX = new File("src/main/resources/geckodriver").getAbsolutePath();
}
