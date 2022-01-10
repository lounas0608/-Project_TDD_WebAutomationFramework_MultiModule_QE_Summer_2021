package pages;
import configuration.common.WebBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pageElements.HomePageWebElements;

public class HomePage extends WebBase {

    @FindBy(xpath = HomePageWebElements.searchBoxWebElementLocator)
    public WebElement searchBox;
    @FindBy(xpath = HomePageWebElements.searchButtonWebElementLocator)
    public WebElement searchButton;
    @FindBy(xpath = HomePageWebElements.searchResultWebElementLocator)
    public WebElement searchResult;

    @FindBy(xpath = HomePageWebElements.smartWatchBrandCheckBoxWebElementLocator)
    public WebElement smartWatchBrandCheckBox;
    @FindBy(xpath = HomePageWebElements.appleWatchSeries338mmWebElementLocator)
    public WebElement appleWatchSeries338mm;

    //  ActionMethod class: to keep action methods and assertion methods
    //  action methods: First Approach
    public void enterKeywordInSearchBox(String productName) {
        // driver.findElement(By.xpath(HomePageWebElements.searchBoxWebElementLocator)).sendKeys(productName);
        searchBox.clear();
        searchBox.sendKeys(productName);
    }

    public void clickOnSearchButton() {
        // driver.findElement(By.xpath(HomePageWebElements.searchButtonWebElementLocator)).click();
        searchButton.click();
    }

    // Assertion methods
    public void verifySearchKeyword(String expectedKeyword) {
        // String actualSearchKeyword = driver.findElement(By.xpath(HomePageWebElements.searchResultWebElementLocator)).getText();
        String actualSearchKeyword = searchResult.getText();
        //System.out.println("Actual text is "+actualSearchKeyword);
        Assert.assertEquals(actualSearchKeyword, expectedKeyword, "Search Box not match");
    }

    public void clickOnSmartWatchBrandCheckBox() {
        smartWatchBrandCheckBox.click();
    }

    public void clickOnAppleWatchSeries338mm() {
        appleWatchSeries338mm.click();
    }





}
