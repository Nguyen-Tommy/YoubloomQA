package StepDefinitions;

import Base.BasePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Hook extends BasePage {
    private BasePage base;

    public Hook(BasePage base) {
        this.base = base;
    }

    @Before
    public void InitializeTest() {
        base.driver = new ChromeDriver();
        base.driver.manage().window().maximize();
        base.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void TearDownTest() {
        base.driver.close();
    }
}
