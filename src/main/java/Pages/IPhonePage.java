package Pages;

import Core.Element;
import org.openqa.selenium.By;

public class IPhonePage {
    private By firstEle = By.xpath("//div[@class='b-carousel__header ']/following-sibling::*//li[1]");
    private By eBayLink = By.id("gh-la");

    public void clickFirstEl() {
        Element.click(firstEle);
    }

    public void backMainPage() {
        Element.click(eBayLink); // возващаемся на окно mainWindow
    }
}