package elements;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class story01_Elements {

    WebDriver driver;

    @FindBy(xpath = "//input[@id='loginForm.loginId']") public WebElement loginId;
    @FindBy(xpath = "//input[@id='loginForm.lastName']") public WebElement lastName;
    @FindBy(xpath = "//input[@id='loginForm.password']") public WebElement password;
    @FindBy(xpath = "//input[@name='_button_go']") public WebElement btnLogin;
    @FindBy(id = "reservationFlightSearchForm.originAirport") public WebElement txt_from;
    @FindBy(id = "reservationFlightSearchForm.destinationAirport") public WebElement txt_to;
    @FindBy(id = "flightSearchForm.adultOrSeniorPassengerCount") public WebElement select_passenger;
    @FindBy(id = "aa-leavingOn") public WebElement txt_Depart;
    @FindBy(id = "aa-returningFrom") public WebElement txt_Return;
    @FindBy(id = "flightSearchForm.button.reSubmit") public WebElement btn_SearchFlights;
    @FindBy(id = "chooseFlightsHeader") public WebElement lbl_ChooseFlights;
    @FindBy(className = "result-count") public WebElement lbl_resultCount;

    public story01_Elements(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
