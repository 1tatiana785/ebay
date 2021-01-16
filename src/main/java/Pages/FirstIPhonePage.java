package Pages;

import Core.Driver;
import Core.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FirstIPhonePage {

    private By addButton = By.xpath("//a[contains(text(), 'Add to cart')]");
    private By buyButton = By.xpath("//a[contains(text(), 'Buy It')]");
    private By cancelButton = By.className("clzBtn");
    private By link = By.xpath("//div[@class='vi-swc-message-wrapper']//a");
    private By link1 = By.xpath("//a[contains(text(),'Seller levels')]");
    private By eBayLink = By.id("gh-la");
    // table locations
    private By tableRows = By.xpath("//table[@id='itmSellerDesc']/following-sibling::*//tr");
    private By headingRows = By.xpath("//table[@id='itmSellerDesc']/following-sibling::*//tr[1]");
    private By headingsColumns = By.xpath("//table[@id='itmSellerDesc']/following-sibling::*//tr[1]/td");
    private By tableHeadingColumns = By.xpath("//table[@id='itmSellerDesc']/following-sibling::*//td");
    String mainWindow = Driver.getDriver().getWindowHandle();  // запоминаем имя текущего окна

    public void clickBuyButton() {
        Element.click(buyButton);
    }

    public void clickLink() {
        Element.click(link);
    }

    public void clickCancelButton() {
        for (String windowHandle : Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(windowHandle); // переходим на последнее открытое окно
        }
        Element.click(cancelButton);
    }

    public void clickLink1() {
        for (String tab : Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(tab);
        }
        Element.click(link1);
    }

    public void backPage() {
        Driver.getDriver().switchTo().window(mainWindow); // возващаемся на окно mainWindow
    }

    public void backMainPage() {
        Element.click(eBayLink); // возващаемся на окно mainWindow
    }

    public void clickAddButton() {
        Element.click(addButton);
    }

    public void verifySize() {
        List<WebElement> rows = Element.findLestElements(tableRows);
        if (rows.size() == 12) System.out.println("It's Ok!");
        else System.out.println("Fail!");
    }

    public List<WebElement> getRows() {  //возврвщает все строки без заглавной
        List<WebElement> rows = Element.findLestElements(tableRows);
        rows.remove(0);
        return rows;
    }

    public List<WebElement> getHeadings() {  //возврвщает все столбци заглавной строки
        List<WebElement> headingColumns = Element.findLestElements(headingsColumns);
        System.out.println("Columns number is " + headingColumns.size());
        return headingColumns;
    }

    public void verifyHeadings() {  //возврвщает все столбци заглавной строки
        List<WebElement> headingColumns = Element.findLestElements(headingsColumns);
        System.out.println("Columns number is " + headingColumns.size());
    }

    public List<List<WebElement>> getRowsWithColumns() { // получим список строк разбитых на столбци
        List<WebElement> rows = getRows();
        List<List<WebElement>> rowsWithColumns = new ArrayList<List<WebElement>>();
        for (WebElement row : rows) {
            List<WebElement> rowWithColumns = row.findElements(tableHeadingColumns);
            rowsWithColumns.add(rowWithColumns);
        }
        return rowsWithColumns;
    }

    public List<Map<String, WebElement>> getRowsWithColumnsByHeadings() {
        // вернет список (List) из строк (МАР)б String(заголовок), WebElement (конкретная ячейка)
        List<List<WebElement>> rowsWithColumns = getRowsWithColumns();
        List<Map<String, WebElement>> rowsWithColumnsByHeadings = new ArrayList<Map<String, WebElement>>();
        Map<String, WebElement> rowByHeadings; //строка разбирая на столбци
        List<WebElement> headingColumns = getHeadings(); // получим список заголовков

        for (List<WebElement> row : rowsWithColumns) {
            //перебираем каждую стору, внутри цикла есть цикл, в
            // котором перебираем все колонки строки заголовка, чтобы получить текст заголовка и пивезать заголовок к конкретной колонке
            rowByHeadings = new HashMap<String, WebElement>();
            for (int i = 0; i < headingColumns.size(); i++) {
                String heading = headingColumns.get(1).getText(); //берем конкретный заголовок и его текст записываем в переменную heading
                WebElement cell = row.get(1); // получаем первый заголовок и первую ячейку в строке
                rowByHeadings.put(heading, cell); // помещаем в мап ячейку и заголовок
            }
            rowsWithColumnsByHeadings.add(rowByHeadings); // в список добавляем нужную нам строку, которую получили
        }
        return rowsWithColumnsByHeadings; // вернем нужный нам лист
    }

    public String getValueFromCell(int rowNumber, int columnNumber) { //узнаем значение ячейки по номеру стрики и столбца
        List<List<WebElement>> rowsWithColumns = getRowsWithColumns(); // получим список списка столбцов
        WebElement cell = rowsWithColumns.get(rowNumber - 1).get(columnNumber - 1);
        return cell.getText(); // выдаст значение первой ячейки
    }

    public String getValueFromCell(int rowNumber, String columnName) { //узнаем значение ячейки по номеру стрики и столбца
        List<Map<String, WebElement>> rowsWithColumnsByHeadings = getRowsWithColumnsByHeadings(); // получим список списка столбцов
        return rowsWithColumnsByHeadings.get(rowNumber - 1).get(columnName).getText(); // выдаст значение первой ячейки
    }
}