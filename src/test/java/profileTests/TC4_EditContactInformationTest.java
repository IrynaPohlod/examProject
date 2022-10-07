package profileTests;

import baseTest.BaseTest;
import org.junit.Test;


public class TC4_EditContactInformationTest extends BaseTest {

    private String firstName = "Antonia";
    private String lastName = "Banderas";


    @Test
    public void editContactInformation(){
        homePage
                .loginWithValidCreds()
                .getTopHeaderElements().clickOnTheCabinetLink()
                .checkIsRedirectToUserPage()
                .checkContactInfoTabIsActive()
                .enterUserNameIntoTheUserNameInputField(firstName)
                .enterUserNameIntoTheUserSurnameInputField(lastName)
                .clickOnTheSaveButton()
                .checkSuccessMessageIsDisplayed()
                .closeSuccessPopup()
                .openAddressBookTab()
                .checkDataOnTheAddressBookTab(firstName,lastName)
                .openContactInfoTab()
                .clearAllInputs()
                .clickOnTheSaveButton()
                .closeSuccessPopup()
                ;

    }
}
