package Pages;

import io.cucumber.java.ca.Cal;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;

public class ShowSetupPage {
    private File photo = new File("C:\\Users\\tommy\\IdeaProjects\\YoubloomQA\\src\\test\\java\\download.jpg");

    public ShowSetupPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//*[@id=\"input-grp-double\"]/div/div/div[2]/div/div/div[3]/div/label[1]/input")
    public WebElement yesRequestingDiscounts;

    @FindBy(how = How.NAME, using = "operations_phone")
    public WebElement operationsPhone;

    @FindBy(how = How.NAME, using = "event_photo")
    public WebElement eventPhoto;

    @FindBy(how = How.XPATH, using = "//*[@id=\"btn-next\"]")
    public WebElement nextBtn1;

    @FindBy(how = How.NAME, using = "event_name")
    public WebElement eventName;

    @FindBy(how = How.NAME, using = "exact_address")
    public WebElement exactAddress;

    @FindBy(how = How.NAME, using = "venue_address")
    public WebElement venueAddress;

    @FindBy(how = How.NAME, using = "venue_name")
    public WebElement venueName;

    @FindBy(how = How.NAME, using = "country")
    public WebElement country;

    @FindBy(how = How.NAME, using = "event_date")
    public WebElement event_date;

    @FindBy(how = How.NAME, using = "event_time")
    public WebElement event_time;

    @FindBy(how = How.NAME, using = "event_end_date")
    public WebElement event_end_date;

    @FindBy(how = How.NAME, using = "event_end_time")
    public WebElement event_end_time;

    @FindBy(how = How.NAME, using = "artist_checkin_time")
    public WebElement artistCheckinTime;

    @FindBy(how = How.NAME, using = "event_description")
    public WebElement eventDescription;

    @FindBy(how = How.XPATH, using = "//*[@id=\"next-prev-buttons\"]/button[2]")
    public WebElement nextBtn2;

    @FindBy(how = How.NAME, using = "regular_price")
    public WebElement regularPrice;

    @FindBy(how = How.NAME, using = "ticket_quantity")
    public WebElement ticketQuantity;

    @FindBy(how = How.NAME, using = "currency")
    public WebElement currency;

    @FindBy(how = How.NAME, using = "date_on_sale_from")
    public WebElement dateOnSaleFrom;

    @FindBy(how = How.NAME, using = "date_on_sale_to")
    public WebElement dateOnSaleTo;

    @FindBy(how = How.NAME, using = "_ticket_checkin_availability_from_date")
    public WebElement ticketCheckinAvailabilityFromDate;

    @FindBy(how = How.NAME, using = "_ticket_checkin_availability_to_date")
    public WebElement ticketCheckinAvailabilityToDate;

    @FindBy(how = How.NAME, using = "parking_info")
    public WebElement parkingInfo;

    @FindBy(how = How.NAME, using = "artist_performance_start")
    public WebElement artistPerformanceStart;

    @FindBy(how = How.NAME, using = "artist_performance_end")
    public WebElement artistPerformanceEnd;

    @FindBy(how = How.NAME, using = "personal_items_info")
    public WebElement personalItemsInfo;

    @FindBy(how = How.XPATH, using = "//*[@id=\"next-prev-buttons-1\"]/button[2]")
    public WebElement publishBtn;

    public void enterOnlyRequiredInfo() {
        yesRequestingDiscounts.click();
        operationsPhone.sendKeys("3016615313");
        eventPhoto.sendKeys(photo.getAbsolutePath());
        nextBtn1.click();

        eventName.sendKeys("Band");
        exactAddress.sendKeys("a");
        venueAddress.sendKeys("a");
        venueName.sendKeys("Silver Spring");
        Select ddCountry = new Select(country);
        ddCountry.selectByIndex(1);
        SimpleDateFormat formatter1 = new SimpleDateFormat("MM/dd/yyyy");
        SimpleDateFormat formatter2 = new SimpleDateFormat("HH:mmaa");
        SimpleDateFormat formatter3 = new SimpleDateFormat("MM/dd/yyyyHH:mm");

        Calendar date = Calendar.getInstance();
        date.add(Calendar.DAY_OF_MONTH, 1);

        event_date.sendKeys(formatter1.format(date.getTime()));
        event_time.sendKeys(formatter2.format(date.getTime()));
        event_end_date.sendKeys(formatter1.format(date.getTime()));
        date.add(Calendar.HOUR,2);
        event_end_time.sendKeys(formatter2.format(date.getTime()));
        date.add(Calendar.HOUR,-4);
        artistCheckinTime.sendKeys(formatter2.format(date.getTime()));
        eventDescription.sendKeys("Band");
        nextBtn2.click();

        regularPrice.sendKeys("2");
        ticketQuantity.sendKeys("1");
        Select ddCurrency = new Select(currency);
        ddCurrency.selectByIndex(1);

        date.add(Calendar.HOUR,2);
        ticketCheckinAvailabilityFromDate.sendKeys(formatter3.format(date.getTime()));
        date.add(Calendar.HOUR,2);
        dateOnSaleTo.sendKeys(formatter3.format(date.getTime()));
        ticketCheckinAvailabilityToDate.sendKeys(formatter3.format(date.getTime()));
        date = Calendar.getInstance();
        dateOnSaleFrom.sendKeys(formatter3.format(date.getTime()));
        artistPerformanceStart.sendKeys(formatter2.format(date.getTime()));
        date.add(Calendar.HOUR, 2);
        artistPerformanceEnd.sendKeys(formatter2.format(date.getTime()));
        parkingInfo.sendKeys("a");
        personalItemsInfo.sendKeys("a");
    }
    public void publish() {
        publishBtn.submit();
    }
}
