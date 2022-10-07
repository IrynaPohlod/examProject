package pages;


import libs.TestData;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.elements.HeaderElements;
import pages.elements.TopHeaderElements;

import java.util.List;

public class HomePage extends ParentPage{

    private HeaderElements headerElements = new HeaderElements(webDriver);
    private TopHeaderElements topHeaderElements = new TopHeaderElements(webDriver);


    private String productBlockLocator = ".//div[@class=\"simple-slider-list__link\"]";

    @FindBy(xpath = ".//div[@class=\"button buy\"]")
    private WebElement buttonBuy;

    @FindBy(xpath = ".//span[text()=\"(1)\"]")
    private WebElement basketCounter;




    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public HeaderElements getHeaderElements() {
        return headerElements;
    }

    public TopHeaderElements getTopHeaderElements() {
        return topHeaderElements;
    }

    public HomePage openHomePage(){
            try{
                webDriver.get("https://makeup.com.ua/");
                logger.info("Home page was opened");
            } catch (Exception e){
                logger.error("Can not work with site");
                Assert.fail("Can not work with site");
            }
            return this;
    }



    public HomePage loginWithValidCreds(){
        LoginPopup loginPopup = new LoginPopup(webDriver);
        loginPopup.openLoginPopup()
                .enterEmailIntoTheEmailInputField(TestData.VALID_LOGIN)
                .enterPasswordIntoThePasswordInputField(TestData.VALID_PASSWORD)
                .clickOnTheSignInButton()
                ;
    return this;
    }


    public BasketPopup clickOnTheBuyButton() {
        try{
            getProductsList();
            int index = 0;
            while (!getProductsList().isEmpty()) {
                hoverMouseOverElement(getProductsList().get(index));
                if (isElementDisplayed(buttonBuy)) {
                    clickOnElement(buttonBuy);
                    break;
                } else {
                    index++;
                }
            }
        } catch (Exception e) {
            logger.info("No buy button " + e);
        }
    return new BasketPopup(webDriver);
    }

    private List<WebElement> getProductsList (){
        return webDriver.findElements(By.xpath(productBlockLocator));
    }

    public HomePage checkBasketCounter(){
        isElementDisplayed(basketCounter);
        return this;
    }









}
