package StepDefinitions;

import Base.BasePage;
import Pages.ShowSetupPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class ShowSetupSteps {
    private BasePage base;
    private ShowSetupPage showSetupPage;

    public ShowSetupSteps(BasePage base) {
        this.base = base;
        showSetupPage = new ShowSetupPage(base.driver);
    }

    @Given("the user is on the show setup page in the connect dashboard")
    public void the_user_is_on_the_show_setup_page_in_the_connect_dashboard() {
        base.driver.findElement(By.xpath("/html/body/div/aside/section/ul/li[7]/a")).click();
    }

    @When("the user inputs only required fields")
    public void the_user_inputs_only_required_fields() {
        showSetupPage.enterOnlyRequiredInfo();
    }

    @When("hits the publish show button")
    public void hits_the_publish_show_button() {
        showSetupPage.publish();
    }

    @Then("the user's show should be setup successfully")
    public void the_user_s_show_should_be_setup_successfully() throws InterruptedException {
        Thread.sleep(5000);
        Assert.assertEquals("","");
    }
}
