package homePageTest;
import configuration.common.WebBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

import static configuration.utilities.DataDriven.getItemValue;
import static configuration.utilities.DataDriven.getItemsListFromDB;

public class HomePageTest extends WebBase {

    // create object of HomePage
    // HomePage homePage = new HomePage();
    HomePage homePage;

    @BeforeMethod
    public void getInit() {
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    // Test class: to keep test methods
    // Test case / Test method
    @Test
    public void testSearchKeywordFunctionality() throws InterruptedException {
        homePage.enterKeywordInSearchBox("smart watch");
        homePage.clickOnSearchButton();
        homePage.verifySearchKeyword("smart watch");
        waitFor(5);
    }

    @Test
    public void testViewAllRevisionsFeatureFunctionality() {
        homePage.enterKeywordInSearchBox("smart watch");
        homePage.clickOnSearchButton();
        homePage.verifySearchKeyword("smart watch");
        homePage.clickOnSmartWatchBrandCheckBox();
        homePage.clickOnAppleWatchSeries338mm();
    }

    // Data Driven approach using list
    // getItemValue

    @Test
    public void testSearchKeywordFunctionality1() throws InterruptedException {
        for (int i = 0; i < getItemValue().size(); i++) {
            // getItemValue().get(i);
            homePage.enterKeywordInSearchBox(getItemValue().get(i));
            homePage.clickOnSearchButton();
            Thread.sleep(5000);
            homePage.verifySearchKeyword(getItemValue().get(i));
        }
    }
    // data driven approach using data base
    @Test(enabled = false)
    public void testSearchKeywordFunctionality2() throws Exception {
        for (int i = 0; i < getItemsListFromDB().size(); i++) {
            // getItemValue().get(i);
            homePage.enterKeywordInSearchBox(getItemsListFromDB("EBayItems","items").get(i));
            homePage.clickOnSearchButton();
            Thread.sleep(5000);
            homePage.verifySearchKeyword(getItemsListFromDB("EBayItems","items").get(i));
        }
    }


}
