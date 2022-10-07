package pages.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BrandPage;
import pages.CommonActionsWithElements;
import pages.HomePage;
import pages.SearchPage;

public class HeaderElements extends CommonActionsWithElements {

    @FindBy(xpath = ".//input[@id=\"search-input\"]")
    private WebElement searchInput;

    @FindBy(xpath = ".//button[@class=\"search-button\"]")
    private WebElement searchIcon;

    @FindBy(xpath = ".//a[text()='Бренди']")
    private WebElement submenuBrand;

    @FindBy(xpath = ".//*[text()=\"Обране\"]")
    private WebElement selectedLink;

    public HeaderElements(WebDriver webDriver) {
        super(webDriver);
    }

    public HomePage loginTextIntoTheSearchField(String text){
        enterTextIntoElement(searchInput,text);
        return new HomePage(webDriver);
    }

    public SearchPage clickOnTheSearchIcon(){
        clickOnElement(searchIcon);
        return new SearchPage(webDriver);
    }

    public BrandPage clickOnTheBrandSubmenuItem() {
        clickOnElement(submenuBrand);
        return new BrandPage(webDriver);
    }


}
