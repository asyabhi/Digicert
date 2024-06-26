import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/UITests.feature",
        glue = {"stepDefinitions"},
        monochrome = true,
        plugin = {"pretty", "junit:target/JUnitReports/report.xml",
                "json:target/JSONReports/report.xml",
                "html:target/HtmlReports"}
)

public class TestRunner {
}
