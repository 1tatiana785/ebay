package Pages;

import Core.Driver;
import Core.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class AdvancedPageCheckboxes {

    Actions actions = new Actions(Driver.getDriver());
    String selectedCheckbox = "//form[@id='adv_search_from']/fieldset[%s]/label[%s]/input";
    private By allCheckboxBuying = By.xpath("//form[@id='adv_search_from']/fieldset[4]/label//input");
    String checkboxBuying = "//form[@id='adv_search_from']/fieldset[4]/label[%s]/input";
    private By eBayLink = By.id("gh-la");
    private By CheckboxSpecificSellers = By.xpath("//div[@class='c-cont']/label[1]/input");
    private By CheckboxSellers = By.id("_fss");
    private By dropDownSellers = By.id("_saslop");
    private By fieldSellers = By.xpath("//div[@class='c-cont']//input[@class='space-top']");

    public void clickAnyCheckbox(String number, String number1) {
        Element.clickStringNumber2(selectedCheckbox, number, number1);
    }

    public void isEnableCheckbox() {
        WebElement button1 = Driver.getDriver().findElement(CheckboxSpecificSellers);
        WebElement button = Driver.getDriver().findElement(CheckboxSellers);
        Element.click(CheckboxSellers);
        /// System.out.println(button.isDisplayed()); // проверяем виден элемент или нет
        if (button1.isEnabled())           // проверяем задисеблен элемент или нет
            Element.click(CheckboxSpecificSellers);
        else Element.click(CheckboxSellers);
    }

    public void isSelectedDropDown() {
        WebElement dropDown = Driver.getDriver().findElement(dropDownSellers);
        WebElement button = Driver.getDriver().findElement(CheckboxSellers);
        Element.click(CheckboxSellers);
        if (button.isSelected())                    //проверяем выделен элемент или нет
            Element.click(dropDownSellers);
        else Element.click(CheckboxSellers);
        Element.click(dropDownSellers);
    }

    public void isEnabledField() {
        WebElement field = Driver.getDriver().findElement(fieldSellers);
        if (!field.isEnabled()) {
            Element.click(CheckboxSellers);
        }
        Element.click(fieldSellers);
    }

    public void verifySizeBuyingCheckbox() {
        List<WebElement> listCheckbox = Element.findLestElements(allCheckboxBuying);
        if (listCheckbox.size() == 2) System.out.println("It's Ok! Number of checkboxes is " + listCheckbox.size());
        else System.out.println("Fail!");
    }

    /*public void selectedListBuyingCheckbox() {
        List<WebElement> listCheckbox = MyActions.findElements(allCheckboxBuying);
        listCheckbox.get(0).click();
    }*/

    public void selectAllBuyingCheckboxes() {    // выделяет все чекбоксы не работает на этом примере
        List<WebElement> listSearchCheckbox = Element.findLestElements(allCheckboxBuying);
        for (WebElement checkbox : listSearchCheckbox) {
            checkbox.click();
        }
    }

    public void selectBuyingCheckbox(String number) {
        if (!Element.selectStringNumber(checkboxBuying, number)) { // проверяет что чекбокс включен
            Element.clickStringNumber(checkboxBuying, number); // включаем чекбокс усли не включен
        }
    }

    public void deselectedBuyingCheckbox(String number) {
        if (Element.selectStringNumber(checkboxBuying, number)) {  // проверяет что чекбокс включен
            Element.clickStringNumber(checkboxBuying, number); // включаем чекбокс
        } else System.out.println("!");
    }

    public boolean verifyCheckbox(String number, String number1) {
        if (Element.selectStringNumber2(selectedCheckbox, number, number1)) {  // проверяет что чекбокс не включен
        } else return false;
        return true;
    }

    public void backMainPage() {
        Element.click(eBayLink); // возващаемся на окно mainWindow
    }

        /*public void openElementInNewWindow () { // open element in new window
        actions.contextClick(Driver.getDriver().findElement(element));
    }*/
}


