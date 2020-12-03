package Pages;

import Core.Driver;
import Core.MyActions;
import org.openqa.selenium.By;

public class IPhonePage {
    private By firstEle = By.xpath("//div[@class='b-carousel__header ']/following-sibling::*//li[1]");
    private By eBayLink = By.id("gh-la");

    public void clickFirstEl() {
        MyActions.click(firstEle);
    }

    public void backMainPage() {
        MyActions.click(eBayLink); // возващаемся на окно mainWindow
    }

}
