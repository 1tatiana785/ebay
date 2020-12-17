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
    AdvancedPageCheckboxes advancedPage = new AdvancedPageCheckboxes();
    IPhonePage iPhonePage = new IPhonePage();
    FirstIPhonePage firstIPhonePage = new FirstIPhonePage();
    //JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
    // jse.executeScript("alert('Hello');");

    /*@Test(priority = 1, description = "work with checkboxes in page")
    public void testingCheckboxes() {
        mainPage.selectAdvancedLink();
        advancedPage.verifySizeBuyingCheckbox(); // проверяет длину списка
        advancedPage.selectAllBuyingCheckboxes();
        advancedPage.clickAnyCheckbox("4", "1");
        advancedPage.selectBuyingCheckbox("1");
        Assert.assertEquals(advancedPage.verifyCheckbox("4", "1"), true); // проверяет включен ли чекбокс
        advancedPage.deselectedBuyingCheckbox("2");
        Assert.assertEquals(advancedPage.verifyCheckbox("4", "2"), false); // проверяет включен ли чекбокс
        advancedPage.isEnableCheckbox();
        advancedPage.isSelectedDropDown();
        advancedPage.isEnabledField();
        advancedPage.backMainPage();
    }*/

    @Test(priority = 2, description = "work with dropdowns in page")
    public void testDropDown () {
        mainPage.clickElectronicsLink();
        electronicsPage.loadPage();
        electronicsPage.selectDropdown(" Art");
        electronicsPage.clickSmartGlassesLink();
        electronicsPage.backMainPage();
       }

   /* @Test(priority = 3, description = "work with table in page")
    public void tableTest() {
        mainPage.selectIPhoneCategory();
        iPhonePage.clickFirstEl();
        System.out.println("Rows number is " + firstIPhonePage.getRows().size());
        System.out.println(firstIPhonePage.getValueFromCell(1,1));
        System.out.println(firstIPhonePage.getValueFromCell(1,2));
      //  System.out.println(firstIPhonePage.getValueFromCell(1,""));
      //  System.out.println(firstIPhonePage.getValueFromCell(2,""));
        firstIPhonePage.verifySize();
        firstIPhonePage.verifyHeadings();
        firstIPhonePage.backMainPage();
        iPhonePage.backMainPage();
    }

    @Test(priority = 4, description = "work with dropdowns in page")
    public void testOpenWindows () {
        mainPage.selectIPhoneCategory();
        iPhonePage.clickFirstEl();
        firstIPhonePage.clickBuyButton();
        firstIPhonePage.clickCancelButton();
        firstIPhonePage.clickLink();
        firstIPhonePage.clickLink1();
        firstIPhonePage.backPage();
        firstIPhonePage.clickAddButton();
        firstIPhonePage.backMainPage();
        iPhonePage.backMainPage();
    }*/
}
