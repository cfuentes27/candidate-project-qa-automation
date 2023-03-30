package actions;

import elements.story01_Elements;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import steps.common_Steps;

/**
 *  Comments: This section contains all the elements of the features
 *
 *  @author Carlos Fuentes
 *  @since 03-29-2023
 */

public class story01_Actions {

    private WebDriver driver;
    common_Steps common_steps;
    common_Actions common_actions;
    story01_Elements story01_elements;

    public story01_Actions(common_Steps common_steps, common_Actions common_actions){
        this.driver = common_steps.getDriver();
        this.common_actions = common_actions;
        story01_elements = new story01_Elements(driver);
    }

    public void login(String loginId, String lastName, String password){
        story01_elements.loginId.sendKeys(loginId);
        story01_elements.lastName.sendKeys(lastName);
        story01_elements.password.sendKeys(password);
        story01_elements.btnLogin.click();
    }

    public void putFlyInformation(String str_from, String str_to, String str_passengers, String str_depart, String str_Return) throws Exception {
        //Clear all Fields
        story01_elements.txt_from.clear();
        story01_elements.txt_to.clear();

        story01_elements.txt_from.sendKeys(str_from);
        story01_elements.txt_from.sendKeys(" ");
        Thread.sleep(1000);
        story01_elements.txt_from.sendKeys(Keys.DOWN);
        story01_elements.txt_from.sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        story01_elements.txt_to.sendKeys(str_to);
        story01_elements.txt_to.sendKeys(" ");
        Thread.sleep(1000);
        story01_elements.txt_to.sendKeys(Keys.DOWN);
        story01_elements.txt_to.sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        common_actions.selectOption(story01_elements.select_passenger,str_passengers);

        story01_elements.txt_Depart.clear();
        story01_elements.txt_Return.clear();
        story01_elements.txt_Depart.sendKeys(str_depart);
        story01_elements.txt_Return.sendKeys(str_Return);
        Thread.sleep(2000);
        story01_elements.btn_SearchFlights.click();
    }

    public void validateResult(String result) throws Exception {
        common_actions.waitExplicit(story01_elements.lbl_ChooseFlights);
        Thread.sleep(2000);
        String resultCounts_str = story01_elements.lbl_resultCount.getText();
        int resultCounts = Integer.parseInt(resultCounts_str);
        Assert.assertTrue(resultCounts>0);
    }
}
