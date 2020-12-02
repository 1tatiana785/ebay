package Pages;

import Core.Driver;
import Core.MyActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TableWorkPage {

    private By tableRows = By.xpath("//table[@id='customers']//tr");
    private By headingRows = By.xpath("//table[@id='customers']//tr[1]");
    private By headingsColumns = By.xpath("//table[@id='customers']//tr[1]/th");
    private By tableHeadingColumns = By.xpath("//table[@id='customers']//td");

    public void verifySize() {
        List<WebElement> rows = MyActions.findElements(tableRows);
        if (rows.size() == 7) System.out.println("It's Ok!");
        else System.out.println("Fail!");;
    }

    public List<WebElement> getRows() {  //возврвщает все строки без заглавной
        List<WebElement> rows = MyActions.findElements(tableRows);
        rows.remove(0);
        return rows;
    }


    public List<WebElement> getHeadings() {  //возврвщает все столбци заглавной строки
        List<WebElement> headingColumns = MyActions.findElements(headingsColumns);
       System.out.println(headingColumns.size());
        return headingColumns;
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

    public List<Map<String, WebElement>> getRowsWithColumnsByHeadings(){
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

    public String getValueFromCell (int rowNumber, int columnNumber){ //узнаем значение ячейки по номеру стрики и столбца
        List<List<WebElement>> rowsWithColumns = getRowsWithColumns(); // получим список списка столбцов
        WebElement cell = rowsWithColumns.get(rowNumber - 1).get(columnNumber - 1);
        return cell.getText(); // выдаст значение первой ячейки
    }
    public String getValueFromCell (int rowNumber, String columnName){ //узнаем значение ячейки по номеру стрики и столбца
        List<Map<String, WebElement>> rowsWithColumnsByHeadings = getRowsWithColumnsByHeadings(); // получим список списка столбцов
        return rowsWithColumnsByHeadings.get(rowNumber - 1).get(columnName).getText(); // выдаст значение первой ячейки
    }
}