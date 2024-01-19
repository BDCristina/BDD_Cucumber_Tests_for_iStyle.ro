package my_proj_bdd.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import my_proj_bdd.driver.DriverManager;
import my_proj_bdd.pages.HomePage;

public class HomeSteps extends DriverManager {

    HomePage homePage = new HomePage(driver);

    @Given("I am a user on iStyle home page")
    public void openHomepage(){
        homePage.openHomePage();
    }

    @Then("I click accept cookies button")
    public void acceptCookieHeader(){
        homePage.clickAcceptCookiesButton();
    }


    @When("I click 'Account' button")
    public void clickMyAccount() {
        homePage.clickAccountToggle();
        homePage.clickAccountButton();
    }

    @When("I click 'Adauga' button with index: (.*)$")
    public void clickAdauga(String index) {
        homePage.clickAddToBasketButtonByIndex(index);

    }

    @When("I click 'Shopping Cart' button")
    public void clickShoppingCart() {
        homePage.clickShoppingCartButton();
    }

    @When("I click 'Vezi Cos' button")
    public void clickVeziCos() {
        homePage.clickVeziCosButton();
    }

    @When("I close promotion popup")
    public void clickToClosePopep(){ homePage.clickPromotionPopupBtn();

    }
}

