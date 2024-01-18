package my_proj_bdd.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    //validari daca vrem sa facem anumite verificari


}
