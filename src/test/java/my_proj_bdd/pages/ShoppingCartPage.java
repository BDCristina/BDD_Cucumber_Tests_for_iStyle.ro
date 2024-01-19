package my_proj_bdd.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.JavascriptExecutor;

import java.util.List;


public class ShoppingCartPage extends BasePage{

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1[@class='block__title']")
    private WebElement cartHeader;

    @FindBy(xpath = "//i[@class='icon icon-close-circle']")
    private List<WebElement> removeProductBtnAsList;

    @FindBy(xpath = "//p[ contains(text(), 'Nu ai produse în coșul de cumpărături')]")
    private WebElement emptyBasketMsg;


    //actiuni

    public void clickRemoveProductBtnForAll() {
        for (int i = 0; i < removeProductBtnAsList.size(); i++) {
            WebElement element = removeProductBtnAsList.get(i);
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", element);
        }

    }


    //validari daca vrem sa facem anumite verificari

    public void validateCartHeader(String expectedMsg) {
        String actualText = ((String)((JavascriptExecutor) driver)
                .executeScript("return arguments[0].childNodes[0].nodeValue", cartHeader)).trim();
        expectedMsg = expectedMsg.trim();

        Assert.assertEquals("Cart header is wrong", expectedMsg, actualText);
    }

    public void validateEmptyBasketMsg() {
        Assert.assertTrue(emptyBasketMsg.isDisplayed());
    }


}
