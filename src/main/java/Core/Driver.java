package Core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

final public class Driver { // final - нельзя унаследовать. все его методы тоже становятся final - их нельзя переопределить

    private static final ThreadLocal<Driver> driverThread = new ThreadLocal<>();
    private static WebDriver driver = null;

    public static Driver getInstance() {
        if (driverThread.get() == null) {
            synchronized (Driver.class) {
                driverThread.set(new Driver());
            }
        }
        return driverThread.get();
    }

    private Driver() {    }

    public static WebDriver getDriver() {
        //singleton pattern
        if (driver == null) {
            if (Constants.browserName.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", "/home/tatiana/_Projects/ebay/drivers/chromedriver");
                ChromeOptions chromeOptions = new ChromeOptions();
              //  chromeOptions.addArguments("--headless");
                driver = new ChromeDriver(chromeOptions);

            } else if (Constants.browserName.equalsIgnoreCase("firefox")) {
                System.setProperty("webdriver.gecko.driver", "/home/tatiana/_Projects/ebay/drivers/geckodriver");
               driver = new FirefoxDriver(new FirefoxOptions());
            }
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
           // driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.get(Constants.url);
        }
        return driver;
    }

    public static void quite() {
        System.out.println("Quitting the browser");
        driver.quit();
        driver = null;
    }

    /*
    public static void close() {
        System.out.println("Closing the browser");
        driver.close();
        driver = null;
    }*/
}
