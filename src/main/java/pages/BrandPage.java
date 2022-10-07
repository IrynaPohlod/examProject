package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BrandPage extends ParentPage{

    private String letterItemLocator = ".//div[@id=\"brands-filter\"]//*[text()='%s']";
    @FindBy(xpath = ".//div[@id=\"brands-filter\"]//*[text()='R']")
    private WebElement letterItem;

    private String brandLocator = ".//a[text()=\"%s\"]";

    @FindBy(xpath = ".//h1[@class='page-header']")
    private WebElement brandTitle;

    private String productTitle = ".//div[@class=\"catalog-products\"]//ul[@class=\"simple-slider-list\"]//li[@class=\"simple-slider-list__item labeled\"]";

    @FindBy(xpath = ".//li[@class=\"catalog-checkbox-list__item has-action readonly checked\"]")
    private WebElement brandCheckbox;

    public BrandPage(WebDriver webDriver) {
        super(webDriver);
    }


    public BrandPage clickOnTheLetter(String letter) {
        WebElement letterLocator = webDriver.findElement(By.xpath(String.format(letterItemLocator,letter)));
        clickOnElement(letterLocator);
        return this;
    }

    public BrandPage clickOnTheBrandName (String brand) {
        try {
            webDriver.findElement(By.xpath(String.format(brandLocator, brand))).click();
        } catch (Exception e){
            logger.info("Brand not found " + e);
        }
        return this;
    }

    public BrandPage checkBrandPageHeader (String brand){
        Assert.assertEquals("Brands do not match",brand,brandTitle.getText());
        logger.info("The title matches with the brand name");
        return this;
    }

    public BrandPage checkProductTitles (String brand){
        List<WebElement> productTitlesList = getProductsListTitles(brand);
        int index = 0;
        int product = 0;
        while (!productTitlesList.isEmpty() && index<productTitlesList.size()) {
        String productTitle = productTitlesList.get(index).getAttribute("data-brand");
        if (productTitle.contains(brand)){
            product++;
        } else {
            Assert.fail("Product attribute does not contain text " + brand);
        } index++;
        }
        logger.info(String.format("%s products of %s contain %s text", product, productTitlesList.size(), brand));
               return this;
    }


    private List<WebElement> getProductsListTitles(String brand) {
        return webDriver.findElements(By.xpath(productTitle));
    }

    public BrandPage checkBrandCheckbox (String brand){
        String checkbox = brandCheckbox.getText();
        if(checkbox.contains(brand)){
            logger.info("Checkbox has " + brand + " name");
        } else{
            Assert.fail();
            logger.info("Checkbox with incorrect text");
        }

        return this;
    }



}
