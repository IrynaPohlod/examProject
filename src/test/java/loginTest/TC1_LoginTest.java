package loginTest;

import baseTest.BaseTest;
import libs.TestData;
import org.junit.Test;

public class TC1_LoginTest extends BaseTest {

    @Test
    public void validLogin(){
        loginPopup
                .openLoginPopup()
                .checkLoginPopupIsOpened()
                .enterEmailIntoTheEmailInputField(TestData.VALID_LOGIN)
                .enterPasswordIntoThePasswordInputField(TestData.VALID_PASSWORD)
                .clickOnTheSignInButton()
                .getTopHeaderElements().checkIfCabinetUrlIsShown()
        ;
    }

}
