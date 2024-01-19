package my_proj_bdd.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import my_proj_bdd.driver.DriverManager;
import my_proj_bdd.pages.RegisterPage;
import my_proj_bdd.pages.ShoppingCartPage;

public class ShoppingCartSteps extends DriverManager {

    ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);

    @Then("I validate cart header : (.*)$")
    public void validateCartHeader(String expectedMsg) {
        shoppingCartPage.validateCartHeader(expectedMsg);
    }

    @When("I click 'Remove' button")
    public void clickRemove(){
        shoppingCartPage.clickRemoveProductBtnForAll();
    }

    @Then("I validate shopping cart url is correct")
    public void validateCartUrl() {
        shoppingCartPage.validatePageURL("/checkout/cart/");
    }

    @Then("I validate empty basket message is displayed")
    public void validateEmptyBasket() {
        shoppingCartPage.validateEmptyBasketMsg();
    }

}
