package pages;

import com.beust.ah.A;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UserPage extends ParentPage {

    @FindBy(xpath = ".//h1[text()='Особистий кабінет'] ")
    private WebElement titleCabinet;

    @FindBy(xpath = ".//h2[text()=\"Редагування особистих даних\"]")
    private WebElement titleContactInfoTab;

    @FindBy(xpath = ".//input[@id=\"name\"]")
    private WebElement inputUserName;

    @FindBy(xpath = ".//input[@id=\"surname\"]")
    private WebElement inputUserSurname;

    @FindBy(xpath = ".//div[@class=\"private-office__column\"]//button[text()='Зберегти']")
    private WebElement buttonSave;

    @FindBy(xpath = ".//p[text()=\"Данні успішно збережені\"]")
    private WebElement messageSuccess;

    @FindBy(xpath = ".//div[@id=\"popup__window\"]")
    private WebElement successPopup;

    @FindBy(xpath = ".//div[@id=\"popup__window\"]//div[@class=\"popup-close close-icon\"]")
    private WebElement buttonCloseOnSuccessPopup;

    @FindBy(xpath = ".//li[@data-source=\"/ajax/user/address-book/\"]")
    private WebElement tabAddressBook;

    @FindBy(xpath = "//li[contains(text(),'Контактна інформація')]")
    private WebElement tabContactInfo;

    @FindBy(xpath = ".//input[@id=\"input-name\"]")
    private WebElement firstNameAddressBook;

    @FindBy(xpath = ".//input[@id=\"input-surname\"]")
    private WebElement lastNameAddressBook;

    public UserPage(WebDriver webDriver) {
        super(webDriver);
    }

    public UserPage checkIsRedirectToUserPage(){
        isElementDisplayed(titleCabinet);
        return this;
    }

    public UserPage checkContactInfoTabIsActive(){
        isElementDisplayed(titleContactInfoTab);
        logger.info("Contact info tab is opened");
        return this;
    }

    public UserPage enterUserNameIntoTheUserNameInputField (String userName){
       enterTextIntoElement(inputUserName, userName);
        return this;
    }

    public UserPage enterUserNameIntoTheUserSurnameInputField (String userSurname){
        enterTextIntoElement(inputUserSurname, userSurname);
        return this;
    }

    public UserPage clickOnTheSaveButton(){
        clickOnElement(buttonSave);
        return this;
    }

    public UserPage checkSuccessMessageIsDisplayed(){
        webDriverWait10.withMessage("Success popup is shown").until(ExpectedConditions.visibilityOf(successPopup));
        isElementDisplayed(messageSuccess);
        return this;
    }

    public UserPage closeSuccessPopup (){
        clickOnElement(buttonCloseOnSuccessPopup);
        logger.info("Success popup was closed");
        return this;
    }

    public UserPage openAddressBookTab (){
        clickOnElement(tabAddressBook);
        return this;
    }

    public UserPage checkDataOnTheAddressBookTab (String firstName, String lastName){
        Assert.assertEquals("First name",firstName,firstNameAddressBook.getAttribute("value"));
        Assert.assertEquals("Last name",lastName,lastNameAddressBook.getAttribute("value"));
        logger.info("Data matches");
        return this;
    }


    public UserPage openContactInfoTab() {
        clickOnElement(tabContactInfo);
        checkContactInfoTabIsActive();
        return this;
    }

    public UserPage clearAllInputs() {
        inputUserName.clear();
        inputUserSurname.clear();
        clickOnElement(buttonSave);
        return this;
    }
}
