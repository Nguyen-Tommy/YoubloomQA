package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MyLocationPage {

    public MyLocationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.ID, using = "searchInput")
    public WebElement inputLocation;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/section[2]/div/div/div[2]/div/form/div/div[3]/button")
    public WebElement setupMyLocationBtn;

    public void enterLocation(String address) throws InterruptedException {
        inputLocation.sendKeys(address);
        Thread.sleep(1000);
        inputLocation.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(1000);
        inputLocation.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(1000);
        inputLocation.sendKeys(Keys.ENTER);
        Thread.sleep(1000);
    }
    public void submit() {
        setupMyLocationBtn.click();
    }
}
