package pages;

import pages.elements.TopHeaderElements;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPopup extends ParentPage{

    HomePage homePage = new HomePage(webDriver);
    TopHeaderElements topHeader = new TopHeaderElements(webDriver);


    @FindBy(xpath = ".//input[@name=\"user_login\"]")
    private WebElement emailInputField;

    @FindBy(xpath = ".//input[@name=\"user_pw\"]")
    private WebElement passwordInputField;

    @FindBy(xpath = ".//h2[text()=\"вхід до особистого кабінету\"]")
    private WebElement loginPopupTitle;


    @FindBy(xpath = ".//button[text()='Увійти']")
    private WebElement signInButton;


    public LoginPopup(WebDriver webDriver) {
        super(webDriver);
    }



    public LoginPopup openLoginPopup(){
       try{
        homePage.openHomePage()
                .getTopHeaderElements().clickOnTheSignIn();
        logger.info("Login popup is opened");
       }catch (Exception e){
           logger.error("Can not work with site");
           Assert.fail("Can not work with site");
       }
       return this;
    }

    public LoginPopup checkLoginPopupIsOpened(){
        Assert.assertTrue("Login Popup is not opened", isElementDisplayed(loginPopupTitle));
        return  this;
    }


    public LoginPopup enterEmailIntoTheEmailInputField(String email) {
        enterTextIntoElement(emailInputField,email);
        return this;
    }

    public LoginPopup enterPasswordIntoThePasswordInputField(String password) {
        enterTextIntoElement(passwordInputField,password);
        return this;
    }

    public HomePage clickOnTheSignInButton(){
        clickOnElement(signInButton);
        return new HomePage(webDriver);
    }
}
