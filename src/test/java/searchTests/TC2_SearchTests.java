package searchTests;

import baseTest.BaseTest;
import org.junit.Test;

public class TC2_SearchTests extends BaseTest {

    final String searchedItem = "туш";

    @Test
    public void searchForItem (){
        homePage.openHomePage()
                .getHeaderElements().loginTextIntoTheSearchField(searchedItem)
                .getHeaderElements().clickOnTheSearchIcon()
                .checkIsRedirectToSearchResultPage()
                .checkSearchedInfoText(searchedItem)
                .checkProducts(searchedItem)
        ;

    }

}
