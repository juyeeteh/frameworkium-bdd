package net.moodel.demo.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.moodel.demo.pages.HomePage;
import net.moodel.demo.pages.LoginPage;
import org.apache.commons.lang3.RandomStringUtils;
import ru.yandex.qatools.allure.annotations.Step;

import static com.google.common.truth.Truth.assertThat;


/**
 * Step Definition class for login related steps
 */
public class LoginSteps {

    private static final String CORRECT_USERNAME = "admin";
    private static final String CORRECT_PASSWORD = "sandbox";

    private LoginPage loginPage;
    private HomePage homePage;

    public LoginSteps() {
        loginPage = new LoginPage().get();
        homePage = new HomePage().get();
    }


    @Step
    @Given("^I have successfully logged in$")
    public void i_have_successfully_logged_in() throws Throwable {
        i_am_on_the_login_page();
        loginPage.successfullyCompleteLoginPage(CORRECT_USERNAME,CORRECT_PASSWORD);
        i_will_be_logged_in();
    }

    @Step
    @Given("^I am on the login page$")
    public void i_am_on_the_login_page() throws Throwable {
        loginPage.navigateToPage();
    }

    @Step
    @When("^I submit login with incorrect details")
    public void i_enter_incorrect_login_details() throws Throwable {
        loginPage.enterIntoUsernameField(RandomStringUtils.randomAlphabetic(5));
        loginPage.enterIntoPasswordField(RandomStringUtils.randomAlphabetic(5));
        loginPage.clickLoginButton();
    }

    @Step
    @When("^I submit login with correct details$")
    public void i_submit_login_with_correct_details() throws Throwable {
        loginPage.enterIntoUsernameField(CORRECT_USERNAME);
        loginPage.enterIntoPasswordField(CORRECT_PASSWORD);
        loginPage.clickLoginButton();
    }

    @Step
    @Then("^I will be logged in$")
    public void i_will_be_logged_in() throws Throwable {
        assertThat(homePage.isUserLoggedIn()).isTrue();
    }

    @Step
    @Then("^I will not be logged in$")
    public void i_will_not_be_not_be_logged_in() throws Throwable {
        assertThat(homePage.isUserLoggedIn()).isFalse();
    }



}
