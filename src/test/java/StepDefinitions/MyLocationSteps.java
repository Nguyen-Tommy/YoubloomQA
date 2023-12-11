package StepDefinitions;

import Base.BasePage;
import Pages.LoginPage;
import Pages.MyLocationPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class MyLocationSteps extends BasePage {
    private BasePage base;
    private MyLocationPage myLocationPage;
    private LoginPage loginPage;

    public MyLocationSteps(BasePage base) {
        this.base = base;
        myLocationPage = new MyLocationPage(base.driver);
        loginPage = new LoginPage(base.driver);
    }

    @Given("the user has created an account as a show creator")
    public void the_user_has_created_an_account_as_a_show_creator() throws InterruptedException {
        base.driver.navigate().to("https://internxt.com/temporary-email");

        Thread.sleep(1000);
        String randomEmail = base.driver.findElement(By.xpath("/html/body/div[1]/section[1]/div/div[2]/div[1]/div[1]/div/p")).getText();

        base.driver.navigate().to("https://libertybloom.com/become-a-show-creator/");
        base.driver.findElement(By.name("user_first_name")).sendKeys("a");
        base.driver.findElement(By.name("user_last_name")).sendKeys("a");
        base.driver.findElement(By.name("user_email")).sendKeys(randomEmail);
        base.driver.findElement(By.name("mepr_user_password")).sendKeys("a");
        base.driver.findElement(By.name("mepr_user_password_confirm")).sendKeys("a");
        base.driver.findElement(By.className("mepr-submit")).submit();

        Select ddCountry = new Select(base.driver.findElement(By.name("showcreator_country")));
        ddCountry.selectByIndex(1);
        base.driver.findElement(By.name("showcreator_city")).sendKeys("a");
        base.driver.findElement(By.name("showcreator_postalcode")).sendKeys("1");
        Select ddLegalStatus = new Select(base.driver.findElement(By.name("showcreator_legal_status")));
        ddLegalStatus.selectByIndex(1);
        Select ddEU = new Select(base.driver.findElement(By.name("eu_based")));
        ddEU.selectByIndex(1);
        base.driver.findElement(By.name("apartment_no")).sendKeys("1");
        base.driver.findElement(By.name("street_addr")).sendKeys("1");
        base.driver.findElement(By.name("save_showcreator")).click();

        base.driver.navigate().to("https://ybctest.ybdevservr.com/login");
        loginPage.login(randomEmail, "a");
    }

    @Given("the user is on the my location page in the connect dashboard")
    public void the_user_is_on_the_my_location_page_in_the_connect_dashboard() {
        base.driver.findElement(By.xpath("/html/body/div/aside/section/ul/li[3]/a")).click();
        base.driver.findElement(By.xpath("/html/body/div/div/section[2]/div/a")).click();
    }

    @When("the user enter valid address")
    public void the_user_enter_valid_address() throws InterruptedException {
        myLocationPage.enterLocation("506 East Indian Spring Drive, Silver Spring, MD, USA");
    }

    @When("hits the submit button")
    public void hits_the_submit_button() {
        myLocationPage.submit();
    }

    @Then("the user's location should be setup successfully")
    public void the_user_s_location_should_be_setup_successfully() {
        base.driver.findElement(By.xpath("/html/body/div/aside/section/ul/li[7]/a")).click();
        Assert.assertNotNull(base.driver.findElement(By.id("event_type")));
    }
}
