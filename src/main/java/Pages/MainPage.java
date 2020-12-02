package Pages;

import Core.Driver;
import Core.MyActions;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class MainPage {

    Actions actions= new Actions(Driver.getDriver());
    private By electronicsLink = By.linkText("Electronics");
    private By iPhoneCategory = By.linkText("iPhone");
    private By AdvancedLink = By.linkText("Advanced");

    public void clickElectronicsLink (){
        MyActions.click(electronicsLink);
    }


    public void selectCategory (){
        actions.moveToElement(Driver.getDriver().findElement(electronicsLink)).build().perform();
        MyActions.visibility(iPhoneCategory);
        actions.moveToElement(Driver.getDriver().findElement(iPhoneCategory)).click().build().perform();
    }

    public void selectAdvancedLink (){
        MyActions.click(AdvancedLink);
    }


}
