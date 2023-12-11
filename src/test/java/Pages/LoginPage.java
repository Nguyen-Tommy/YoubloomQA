package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.NAME, using = "email")
    public WebElement inputEmail;

    @FindBy(how = How.NAME, using = "password")
    public WebElement inputPassword;

    @FindBy(how = How.XPATH, using = "/html/body/div/div[2]/form/div[3]/div[2]/button")
    public WebElement loginBtn;

    public void login(String email, String password) {
        inputEmail.sendKeys(email);
        inputPassword.sendKeys(password);
        loginBtn.click();
    }
}
