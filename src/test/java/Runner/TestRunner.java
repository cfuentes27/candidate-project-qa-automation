package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/Features"},
        glue = {"steps"},
        plugin = {"pretty", "html:Report/Report.html"},
        dryRun= false
)
public class TestRunner {
}
