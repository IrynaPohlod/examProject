package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.List;
import java.util.Locale;

public class SearchPage extends ParentPage{


    @FindBy(xpath = ".//h1[text()='Результати пошуку']")
    private WebElement resultsText;

    @FindBy(xpath = ".//div[@class=\"info-product-wrapper\"]//div[@class=\"simple-slider-list__description\"]")
    private List<WebElement> listOfSearchedItems;

    @FindBy(xpath = ".//div[@class=\"search-results info-text\"]")
    private WebElement searchResultsInfoText;

    private String productBlockLocator = ".//div[@class=\"catalog-products\"]//..//li[@class=\"simple-slider-list__item labeled with-palette\"]";
            //".//div[@class=\"catalog-products\"]//..//div[@class=\"info-product-wrapper\"]";



    public SearchPage(WebDriver webDriver) {
        super(webDriver);
    }

    public SearchPage checkIsRedirectToSearchResultPage(){
        isElementDisplayed(resultsText);
        return this;
    }


    public SearchPage checkSearchedInfoText(String searchedItem) {
        String searchedText = searchResultsInfoText.getText().toLowerCase(Locale.ROOT);
        if (searchedText.contains(searchedItem)){
            logger.info("Searched info text contains " + searchedItem);
        } else {
        Assert.fail("Searched info text does not contain " + searchedItem);
        }
    return this;
    }

    public SearchPage checkProducts (String searchedItem) {
        List<WebElement> productList = getProductsList(searchedItem);
        int index = 0;
        int productCount = 0;
        int count = 0;
        while(!productList.isEmpty() && index<productList.size()){
            String productTitleText = productList.get(index).getAttribute("data-parent-category").toLowerCase();
            if(productTitleText.contains(searchedItem)) {
                count++;
            } else {
            }
            productCount++;
            index++;
        }
        logger.info(count + " products from " + productList.size() + " contain " + searchedItem);
        return this;
    }

    private List<WebElement> getProductsList(String searchedItem) {
        return webDriver.findElements(By.xpath(productBlockLocator));
    }

}
