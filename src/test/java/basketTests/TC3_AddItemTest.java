package basketTests;

import baseTest.BaseTest;
import org.junit.Test;

public class TC3_AddItemTest extends BaseTest {

    @Test
    public void addItemToTheBasket(){
        homePage.openHomePage()
                .clickOnTheBuyButton()
                .checkBasketPopupIsOpened()
                .checkProductIsAdded()
                .closeBasketPopup()
                .checkBasketCounter()
        ;
    }

}
