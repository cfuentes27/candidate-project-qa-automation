package steps;

import actions.common_Actions;
import actions.story01_Actions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *  Comments: This section puts the steps definition in code and is related to the gerkin of the feature sotry01.feature.
 *
 *  @author Carlos Fuentes
 *  @since 03-29-2023
 */

public class story01_Steps {

    common_Actions common_actions;
    story01_Actions story01_actions;


    public  story01_Steps(common_Actions common_actions, story01_Actions story01_actions){
        this.common_actions = common_actions;
        this.story01_actions = story01_actions;

    }

    @Given("Open Browser and goto American Earline Page {string}")
    public void open_browser_and_goto_american_earline_page(String url) {
        //System.setProperty("WebDriver.chrome.driver","webDrivers/chromedriver_mac64/chromedriver");
        //driver = new ChromeDriver();
        common_actions.openUrl(url);
        //driver.manage().window().maximize();
        System.out.println("STEP -> Open Browser");
    }


    @Then("Validate Name of page {string}")
    public void validate_name_of_page(String string) {
        Assert.assertTrue(string.equals(common_actions.getNamePage()));
        System.out.println("STEP -> Validate name of Page");
    }

    @Then("Put {string} and {string} and {string} in web page")
    public void put_in_web_page(String string, String string2 , String string3) throws Exception {
        Thread.sleep(1000);
        story01_actions.login(string, string2, string3);

        Thread.sleep(1000);
    }
    @Then("Validate the successful login {string}")
    public void validate_the_successful_login(String string) {
        Assert.assertTrue(string.equals(common_actions.getNamePage()));
    }

    @When("Put fly information {string} {string} {string} {string} {string}")
    public void put_fly_information(String From, String To, String Passengers, String Depart, String Return) throws Exception {
        story01_actions.putFlyInformation(From, To, Passengers, Depart, Return);
    }

    @Then("Validate page Results {string}")
    public void validate_page_results(String string) throws Exception {
        story01_actions.validateResult(string);
    }
}
