package Pages;

import Core.MyActions;
import org.openqa.selenium.By;

public class ElectronicsPageDropDown {

    private By electronicsText = By.xpath("//span[text()='Electronics']");
    private By dropdownField = By.id("gh-cat-box");
    private By getDropdownList = By.xpath("//div[@id='gh-cat-box']");
    String getDropdown = "//div[@id='gh-cat-box']//option[text()='%s']";

    public void loadPage() {
        MyActions.presenceElLocation(electronicsText);
    }

    public void selectDropdown(String name) {
        MyActions.click(dropdownField);
        MyActions.visibility(getDropdownList);
        MyActions.click(dropdownField);
        MyActions.clickString1(getDropdown, name);
        MyActions.visibility(getDropdownList);

    }
}
