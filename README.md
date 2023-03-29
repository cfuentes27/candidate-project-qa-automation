# Code Challenge ZoomCare
## Part 1 Test Cases
### SET - Smoke Test Cases

With this Smoke set there will be a confirmation for the QA team to proceed with further software testing.

| Automated | Test Case                  | Expected Result                                                  | Description                                                         |
|-----------|----------------------------|------------------------------------------------------------------|---------------------------------------------------------------------|
| Yes       | Application is up          | When I navigate to the AA page, it should be displayed correctly | Validate that the application is up                                 |
| Yes       | Valid login credentials    | Whe the user enter user and password, The login is successful    | Whe the user enter user and password, The login is successful       |
| Yes       | Search flights -Round trip | The application displays the search correctly to Round Trip      | Displays the search to Run Trip correctly in the app                |
| No        | Search flights -One Way    | The application displays the search correctly to One way         | Displays the search To Onw Way correctly in the app                 |
| No        | Buy a flight -Round trip   | Successfully buy a flight -Round trip                            | Validate the complete flow of the purchase of a flight (Round Trip) |
| No        | Buy a flight -One Way      | Successfully buy a flight -One Way                               | Validate the complete flow of the purchase of a flight (One Way)    |
| No        | Find trip                  | The search for the trip must be successful                       | Validate that the travel search works correctly                     |
| No        | Serach Flight Status       | The flight status search works correctly                         | Validate that the flight status search works correctly              |

## Part 2 - Framework Automation (Java, Selenium, Cucumber)
### Introduction
This is an automation framework that use Selenium, Java and Cucumber. We can execute scenarios in Mozilla Firefox or Google Chrome

### Software Requirements
JDK 1.8 or higher.

### Installation
1. Clone repository
```bash
git https://github.com/zoom-care/candidate-project-qa-automation.git
```
2. Open file src/test/java/Runers/TestRunner.java right click and run

### Run Configuration or Cucumber Option
1. The automation framework only take scenarios in this path "src/test/resources/cvCreator"
2. glue: Is where the steps are kept for the features
3. plugin: It is the option that we have to generate a report, in this case we have html.
4. dryRun: Only boolean value true or false.
    * true: It doesn't run any code, but it's just going to find out if there are any scenarios.
    * false: Run code if there are any scenarios.
5. The run configuration only runs scenarios that has tags with name "@SmokeTest"
```java
@CucumberOptions(
        features = {"src/test/resources/Features"},
        glue = {"steps"},
        plugin = {"pretty", "html:Report/Report.html"},
        dryRun= false,
        tags = "@SmokeTest"
)
```

### Driver configuration (Chrome or Firefox)
1. Only we need change the code in this path "src/test/java/Steps/common_Steps.java"
* Chrome
````java
public void setUp(){
        System.setProperty("webDriver.chrome.driver", "webDrivers/chromedriver_mac64/chromedriver");
        //System.setProperty("webDriver.gecko.driver", "webDrivers/gekoDriver/geckodriver");
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }
````
* Firefox
````java
public void setUp(){
        //System.setProperty("webDriver.chrome.driver", "webDrivers/chromedriver_mac64/chromedriver");
        System.setProperty("webDriver.gecko.driver", "webDrivers/gekoDriver/geckodriver");
        //driver = new ChromeDriver();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }
````
***
<sub>Note: Import the class from ChromeDriver or FirefoxDriver, depending on which one you use

### Run Execution.
1. You need to right-click on the file "src/test/java/Runner/TestRunner" and Select Run TestRunner
2. When the execution is finished, a report is created in the Report folder, you can open it from a browser.