package my_proj_bdd.pages;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    //elemente din pagina
    @FindBy(xpath = "//button[@id='CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll']")
    private WebElement acceptCookiesButton;

    @FindBy(xpath = "//a[@id='header-account-toggle']")
    private WebElement accountHeaderToggle;

    @FindBy(xpath = "(//a[text()='Autentificare / Cont nou'])[2]")
    private WebElement accountButton;

    @FindBy(xpath = "//button[@class='block__tocart block__tocart--icon action tocart primary']")
    private List<WebElement> addToBasketButtonsAsList;

    @FindBy(xpath = "//span[@class='counter qty new']")
    private WebElement shoppingCartButton;
    @FindBy(xpath = "//a[@class='viewcart action outline-dark']")
    private WebElement veziCosulButton;

    @FindBy(xpath = "//button[@class='mfp-close']")
    private WebElement promotionPopupBtn;


    //actiuni ale acelor elemente
    public void clickAcceptCookiesButton() {
        acceptCookiesButton.click();
    }

    public void openHomePage() {
        driver.get("https://istyle.ro/");
    }

    public void clickAccountToggle() {
        accountHeaderToggle.click();
    }

    public void clickAccountButton() {
        accountButton.click();
    }

    public void clickShoppingCartButton() {
        shoppingCartButton.click();
    }

    public void clickVeziCosButton() {
        veziCosulButton.click();
    }

    public void clickAddToBasketButtonByIndex(String index) {
        // transformam index din string in int
        int index_as_int = Integer.valueOf(index);
        // gasim elementul
        WebElement elem = addToBasketButtonsAsList.get(index_as_int);
        // mai facem un mic scroll in jos
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.scrollBy(0,1500)", "");
        // dam click pe button
        executor.executeScript("arguments[0].click();", elem);
        // asteptam o secunda sa se adauge produsul in cod
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public void clickPromotionPopupBtn() {
        try {
            // incearca sa dai click daca gasesti acest element
            promotionPopupBtn.click();
        } catch (NoSuchSessionException e) {
            // testul trece mai departe si daca nu am gasit acel element
        }
    }



}
