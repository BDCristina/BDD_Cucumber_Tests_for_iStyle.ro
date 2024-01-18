package my_proj_bdd.pages;

import org.jetbrains.annotations.NotNull;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {

    public RegisterPage(WebDriver driver) {
        super(driver);
    }
    //elemente din pagina
    @FindBy(xpath = "//button[@id='send2']")
    private WebElement autentificareButton;

    @FindBy(xpath = "//div[contains(text(), 'A login and a password are required.')]")
    private WebElement missingEmailAndPassErrorMsg;

    @FindBy(xpath = "//div[contains(text(), 'Utilizator sau parola incorecta.')]")
    private WebElement userAndPassInvalidMsg;

    @FindBy(xpath = "//div[@id='email-error']")
    private WebElement validationErrorMsgEmail;
    @FindBy(xpath ="//div[@id='pass-error']")
    private WebElement validationErrorMsgPass;

    @FindBy(xpath ="//input[@id='email']")
    private WebElement emailInput;
    @FindBy(xpath ="//input[@id='pass']")
    private WebElement passInput;



    //actiuni ale acelor elemente

    public void clickAutentificareButton() {
        autentificareButton.click();
        sleepms(1000);

    }
    public void fillEmailInput(String email) {
        emailInput.sendKeys(email);
    }

    public void fillPassInput(String pass) {
        passInput.sendKeys(pass);
    }
    public void openCustomerAccountPage() {
        driver.get("https://istyle.ro/customer/account/index/");
    }

    //validari daca vrem sa facem anumite verificari
    public void validateMissingEmailAndPassMsg(){
        Assert.assertTrue(missingEmailAndPassErrorMsg.isDisplayed());

    }

    public void validateUserAndPassInvalidMsg(){
        Assert.assertTrue(userAndPassInvalidMsg.isDisplayed());

    }

    public void validateErrorMessageMail(String expectedMsg) {
        Assert.assertEquals("Validation msg is wrong", expectedMsg, validationErrorMsgEmail.getText());
    }

    public void validateErrorMessagePass(String expectedMsg) {
        Assert.assertEquals("Validation msg is wrong", expectedMsg, validationErrorMsgPass.getText());
    }


}
