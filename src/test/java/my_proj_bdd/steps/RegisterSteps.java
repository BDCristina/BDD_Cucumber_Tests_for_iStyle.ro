package my_proj_bdd.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import my_proj_bdd.driver.DriverManager;
import my_proj_bdd.pages.RegisterPage;

public class RegisterSteps extends DriverManager {

    RegisterPage registerPage = new RegisterPage(driver);

    @When("I click 'Autentificare' button")
    public void clickAutentificare() {
        registerPage.clickAutentificareButton();
    }

    @When("I fill email input: (.*)$")
    public void fillEmail(String email) {
        registerPage.fillEmailInput(email);
    }

    @When("I fill pass input: (.*)$")
    public void fillPass(String pass) {
        registerPage.fillPassInput(pass);
    }

    @Then("I validate error message 'A login email and password are required'.")
    public void validateMissingEmailAndPassMsg() {
        registerPage.validateMissingEmailAndPassMsg();
    }
    @Then("I validate error message 'Utilizator sau parola incorecta.'.")
    public void validateUserAndEmailInvalidMsg() {
        registerPage.validateUserAndPassInvalidMsg();
    }

    @Then("I validate error message email: (.*)$")
    public void validateMsgMail(String expectedMsg) {
          registerPage.validateErrorMessageMail(expectedMsg);
    }

    @Then("I validate error message pass: (.*)$")
    public void validateMsgPass(String expectedMsg) {
        registerPage.validateErrorMessagePass(expectedMsg);
    }

    @Then("I am in my account")
    public void openCustomerAccount(){
        registerPage.openCustomerAccountPage();
    }




}
