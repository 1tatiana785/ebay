package Pages;

import Core.Driver;
import Core.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class MainPage {

    Actions actions = new Actions(Driver.getDriver());
    private By electronicsLink = By.linkText("Electronics");
    private By iPhoneCategory = By.linkText("iPhone");
    private By AdvancedLink = By.linkText("Advanced");
    private By listSignIn = By.xpath("//a[text()='Sign in']");
    private By searchInput = By.xpath("//input[@id='gh-ac']");

    public void findElementsSingIn() {
        if (Element.findLestElements(By.xpath("//a[text()='Sign in']")).size() > 0)
            System.out.println("Such element is presented");
        else System.out.println("Cannot find such element");
        System.out.println(Element.findLestElements(listSignIn).size());
    }

    public void sendKeysText(String name) {
        Element.sendKeys(searchInput, name);
    }

    public void keysChordShift(String name) {
        Element.keysChordShift(searchInput, name);
    }

    public void keysChordControl(String name) {
        Element.keysChordControl(searchInput, name);
    }

    public void keysEnter() {
        Element.keysEnter(searchInput);
    }

    public void clickElectronicsLink() {
        Element.click(electronicsLink);
    }

    public void selectIPhoneCategory() {
        actions.moveToElement(Driver.getDriver().findElement(electronicsLink)).build().perform();
        Element.visibilityElLoc(iPhoneCategory);
        actions.moveToElement(Driver.getDriver().findElement(iPhoneCategory)).click().build().perform();
    }

    public void selectAdvancedLink() {
        Element.click(AdvancedLink);
    }
}