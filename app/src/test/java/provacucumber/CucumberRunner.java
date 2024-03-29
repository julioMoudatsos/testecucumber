package provacucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "not @wip and not @quarantine",
        plugin = {"pretty","html:build/reports/cucumberReport.html"},
        features = {"src/test/resources/features"}
)
public class CucumberRunner {
}
