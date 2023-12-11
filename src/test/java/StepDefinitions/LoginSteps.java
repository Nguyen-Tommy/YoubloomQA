package StepDefinitions;

import Base.BasePage;
import Pages.LoginPage;
import io.cucumber.java.en.Given;

public class LoginSteps {
    private BasePage base;
    private LoginPage loginPage;

    public LoginSteps(BasePage base) {
        this.base = base;
        loginPage = new LoginPage(base.driver);
    }

    @Given("the user is logged into the connect dashboard")
    public void the_user_is_logged_into_the_connect_dashboard() throws InterruptedException {
        base.driver.navigate().to("https://ybctest.ybdevservr.com/login");
        loginPage.login("er.tommynguyen@gmail.com", "Nguyen05");
    }
}
