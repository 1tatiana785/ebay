package Core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static Core.Constants.DRIVER_CHROME;
import static Core.Constants.DRIVER_FIREFOX;

// final - нельзя унаследовать.
// все его методы тоже становятся final - их нельзя переопределить
final public class Driver {

    private static WebDriver driver;

    private Driver() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            if (Constants.browserName.equalsIgnoreCase("chrome")) {
                if ((System.getProperty("os.name")).contains("linux")) {
                    System.setProperty("webdriver.chrome.driver", "/path/to/linux/chromedriver");
                } else {
                    System.setProperty("webdriver.chrome.driver", "/path/to/win/chromedriver.exe");
                }
            }
            System.setProperty("webdriver.chrome.driver", DRIVER_CHROME);
            driver = new ChromeDriver(new DriverOptions().chromeOptions());
        } else if (Constants.browserName.equalsIgnoreCase("firefox")) {
            if ((System.getProperty("os.name")).contains("linux")) {
                System.setProperty("webdriver.chrome.driver", "/path/to/linux/chromedriver");
            } else {
                System.setProperty("webdriver.chrome.driver", "/path/to/win/chromedriver.exe");
            }
            System.setProperty("webdriver.gecko.driver", DRIVER_FIREFOX);
            driver = new FirefoxDriver(new DriverOptions().firefoxOptions());
        }
        return driver;
    }
}



       /*switch (Constants.browserName) {
             case "Chrome":
                 System.setProperty("webdriver.chrome.driver", "/home/tatiana/_Projects/ebay/drivers/chromedriver");
                 ChromeOptions chromeOptions = new ChromeOptions();
                 //  chromeOptions.addArguments("--headless");
                 driver = new ChromeDriver(chromeOptions);
                // return new ChromeDriver();
                break;
             case "Firefox":
                 System.setProperty("webdriver.gecko.driver", "/home/tatiana/_Projects/ebay/drivers/geckodriver");
                 driver = new FirefoxDriver(new FirefoxOptions());
                // return new FirefoxDriver();
                break;
               // default:
         }
         driver.manage().deleteAllCookies();
         driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
         // driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
         driver.manage().window().maximize();
         driver.get(Constants.url);
     }
          return driver;*/