package Core;

import io.qameta.allure.model.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

final public class MyActions {

    private MyActions() {    }

    public static void findElement (By element) {
        Driver.getDriver().findElement(element);
    }

    public static List<WebElement> findElements (By elementLocation) {
        List<WebElement> list = Driver.getDriver().findElements(elementLocation);
        return list;
    }

    public static void click (By elementLocation) {
        Driver.getDriver().findElement(elementLocation).click();
    }
    public static void clickString1 (String elementLocation, String name) {
       Driver.getDriver().findElement(By.xpath(String.format(elementLocation, name))).click();
    }
    public static void clickString2 (String elementLocation, String number, String number1) {
        // Element.waitingClickable(By.xpath(String.format(elementLocation, name)));
        Driver.getDriver().findElement(By.xpath(String.format(elementLocation, number, number1))).click();
        //test.log(Status.INFO  , "Click specified element:  "+ elementLocation.toString());
    }

    public static boolean selectString1 (String elementLocation, String number) {
        if (Driver.getDriver().findElement(By.xpath(String.format(elementLocation, number))).isSelected()){ }
        else return false;
        return true;
    }

    public static boolean selectString2 (String elementLocation, String number, String number1) {
        if (Driver.getDriver().findElement(By.xpath(String.format(elementLocation, number, number1))).isSelected()){ }
        else return false;
        return true;
    }

    public static void visibility (By locator) {
        Element.visibilityElLocation(locator);
    }

    public static void visibilityString (String elementLocation, String name) {
        Element.visibilityElLocation(By.xpath(String.format(elementLocation, name)));
    }

    public static void presenceElLocation (By locator) {
        Element.presenceElLocation(locator);
    }
}
