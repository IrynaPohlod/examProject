package brandsTests;

import baseTest.BaseTest;
import org.junit.Test;

public class TC5_FindByBrandTest extends BaseTest {

    private String brand = "Rexona";

    @Test
    public void findByBrandTest(){
        homePage
                .openHomePage()
                .getHeaderElements().clickOnTheBrandSubmenuItem()
                .clickOnTheLetter("R")
                .clickOnTheBrandName(brand)
                .checkBrandPageHeader(brand)
                .checkBrandCheckbox(brand)
                .checkProductTitles(brand)
                ;
    }

}
