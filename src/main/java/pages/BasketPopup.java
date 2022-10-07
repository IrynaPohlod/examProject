package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasketPopup extends ParentPage{

    @FindBy(xpath = ".//div[text()=\"Кошик\"]")
    private WebElement basketHeader;

    @FindBy(xpath = ".//div[@class=\"product__header-desc\"]")
    private WebElement productBlock;

    @FindBy(xpath = ".//div[@class=\"popup__window\"]//div[@class=\"popup-close close-icon\"]")
    private WebElement closeButton;

    public BasketPopup(WebDriver webDriver) {
        super(webDriver);
    }


    public BasketPopup checkBasketPopupIsOpened(){
        isElementDisplayed(basketHeader);
        logger.info("Basket popup is opened");
        return this;
    }

    public BasketPopup checkProductIsAdded(){
        isElementDisplayed(productBlock);
        return this;
    }

    public HomePage closeBasketPopup(){
        clickOnElement(closeButton);
        return new HomePage(webDriver);
    }



}
