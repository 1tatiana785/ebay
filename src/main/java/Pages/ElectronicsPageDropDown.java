package Pages;

import Core.Driver;
import Core.MyActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ElectronicsPageDropDown {

    private By electronicsText = By.xpath("//span[text()='Electronics']");
    private By dropdownField = By.id("gh-cat-box");
    private By getDropdownList = By.xpath("//div[@id='gh-cat-box']");
    String getDropdown = "//div[@id='gh-cat-box']//option[text()='%s']";
    private By eBayLink = By.id("gh-la");
    private By SmartGlassesLink = By.xpath("//li[@class='b-list__viewmore']//li[3]/a");
    private By disableButton = By.xpath("//div[@class='x-refine__left__nav']//li[3]//li[5]");
    private By moreButton = By.xpath("//button[@class='b-list__footer-resetbutton b-list__footer--viewall']");

   public String loadPage() {
        String text = Driver.getDriver().findElement(electronicsText).getText();
        MyActions.presenceElLocation(electronicsText);
        System.out.println(text);
        return text;}


    public void selectDropdown(String name) {
        MyActions.click(dropdownField);
        MyActions.visibility(getDropdownList);
        MyActions.click(dropdownField);
        MyActions.clickString1(getDropdown, name);
        MyActions.visibility(getDropdownList);
    }
    public void clickSmartGlassesLink() {
        WebElement link = Driver.getDriver().findElement(SmartGlassesLink);
        if (link.isDisplayed())
            MyActions.click(SmartGlassesLink);
        else MyActions.click(moreButton);
        MyActions.click(SmartGlassesLink);
    }

    public void backMainPage() {
        MyActions.click(eBayLink); // возващаемся на окно mainWindow
    }
}
