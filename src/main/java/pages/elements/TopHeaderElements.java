package pages.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.CommonActionsWithElements;
import pages.LoginPopup;
import pages.UserPage;

public class TopHeaderElements extends CommonActionsWithElements {

    @FindBy(xpath = ".//*[text()='Вхід до кабінету']")
    private WebElement signIn;

    @FindBy(xpath = ".//a[text()=\"Кабінет\"]")
    private WebElement cabinetUrl;

    public TopHeaderElements(WebDriver webDriver) {
        super(webDriver);
    }

    public WebElement getSignIn() {
        return signIn;
    }

    public WebElement getCabinetUrl() {
        return cabinetUrl;
    }

    public LoginPopup clickOnTheSignIn(){
        clickOnElement(signIn);
        return new LoginPopup(webDriver);
    }

    public TopHeaderElements checkIfCabinetUrlIsShown (){
        isElementDisplayed(cabinetUrl);
        return this;
    }

    public UserPage clickOnTheCabinetLink(){
        clickOnElement(cabinetUrl);
        return new UserPage(webDriver);
    }


}
