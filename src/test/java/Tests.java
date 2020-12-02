import Core.Driver;
import Core.Listener;
import Pages.*;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({Listener.class})
public class Tests {

    MainPage mainPage = new MainPage();
    ElectronicsPageDropDown electronicsPage = new ElectronicsPageDropDown();
    TableWorkPage tableWorkPage = new TableWorkPage();
    AdvancedPageCheckboxes advancedPage = new AdvancedPageCheckboxes();
    //JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
    // jse.executeScript("alert('Hello');");

    @Test(priority = 1, description = "work with checkboxes in page")
    public void testingCheckboxes() {
        mainPage.selectAdvancedLink();
        advancedPage.verifySizeBuyingCheckbox(); // проверяет длину списка
        advancedPage.selectAllBuyingCheckboxes();
        advancedPage.clickAnyCheckbox("4", "1");
        advancedPage.selectBuyingCheckbox("1");
        Assert.assertEquals(advancedPage.verifyCheckbox("4", "1"), true); // проверяет включен ли чекбокс
        advancedPage.deselectedBuyingCheckbox("2");
        Assert.assertEquals(advancedPage.verifyCheckbox("4", "2"), false); // проверяет включен ли чекбокс
    }

/*   @Test(priority = 1, description = "work with dropdowns in page")
    public void testDropdown () {
        mainPage.selectCategory();
        electronicsPage.selectDropdown(" Art");
       }*/

    /*@Test(priority = 1, description = "work with table in page")
    public void tableTest() {
        Driver.getDriver().get("https://www.w3schools.com/html/html_tables.asp");
        System.out.println("Rows number is " + tableWorkPage.getRows().size());
        System.out.println(tableWorkPage.getValueFromCell(1,1));
        System.out.println(tableWorkPage.getValueFromCell(4,2));
        //System.out.println(tableWorkPage.getValueFromCell(1,"Company"));
        //System.out.println(tableWorkPage.getValueFromCell(2,"Country"));
        tableWorkPage.verifySize();
        System.out.println("Columns number is " + tableWorkPage.getHeadings());
    }*/
}
