package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.common_Steps;

import java.time.Duration;

/**
 *  Comments: This section contains all the common actions that are dealt with in the flows
 *
 *  @author Carlos Fuentes
 *  @since 03-29-2023
 */
public class common_Actions {

    private WebDriver driver;
    common_Steps common_steps;

    public common_Actions(common_Steps common_steps){
        this.driver = common_steps.getDriver();
    }

    public void openUrl(String url){
        driver.navigate().to(url);
    }

    public String getNamePage(){
        String title = driver.getTitle();
        return title;
    }


    public void selectOption(WebElement locator,String option){
        Select se = new Select(locator);
        se.selectByVisibleText(option);
    }

    public void waitExplicit(WebElement locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.visibilityOf(locator));
    }
}

