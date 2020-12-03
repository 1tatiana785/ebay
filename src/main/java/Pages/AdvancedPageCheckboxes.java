package Pages;

import Core.Driver;
import Core.MyActions;
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

    public void clickAnyCheckbox(String number, String number1) {
        MyActions.clickString2(selectedCheckbox, number, number1);
    }

    public void verifySizeBuyingCheckbox() {
        List<WebElement> listCheckbox = MyActions.findElements(allCheckboxBuying);
        if (listCheckbox.size() == 2) System.out.println("It's Ok! Number of checkboxes is " + listCheckbox.size());
        else System.out.println("Fail!");
    }

    /*public void selectedListBuyingCheckbox() {
        List<WebElement> listCheckbox = MyActions.findElements(allCheckboxBuying);
        listCheckbox.get(0).click();
    }*/

    public void selectAllBuyingCheckboxes() {    // выделяет все чекбоксы не работает на этом примере
        List<WebElement> listSearchCheckbox = MyActions.findElements(allCheckboxBuying);
        for (WebElement checkbox : listSearchCheckbox) {
            checkbox.click();
        }
    }

    public void selectBuyingCheckbox(String number) {
        if (!MyActions.selectString1(checkboxBuying, number)) { // проверяет что чекбокс включен
            MyActions.clickString1(checkboxBuying, number); // включаем чекбокс усли не включен
        }
    }

    public void deselectedBuyingCheckbox(String number) {
        if (MyActions.selectString1(checkboxBuying, number)) {  // проверяет что чекбокс включен
            MyActions.clickString1(checkboxBuying, number); // включаем чекбокс
        } else System.out.println("!");
    }

    public boolean verifyCheckbox(String number, String number1) {
        if (MyActions.selectString2(selectedCheckbox, number, number1)) {  // проверяет что чекбокс не включен
        } else return false;
        return true;
    }

    public void backMainPage() {
        MyActions.click(eBayLink); // возващаемся на окно mainWindow
    }

        /*public void openElementInNewWindow () { // open element in new window
        actions.contextClick(Driver.getDriver().findElement(element));
    }*/
}


