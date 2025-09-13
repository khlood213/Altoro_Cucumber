package runners;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/main/resources/features", glue = {"steps"}, monochrome = true, plugin = {
        "pretty", "html:target/HtmlReports/report.html", "json:target/JsonReport/report.json",
        "junit:target/JunitReport/report.xml"}, tags = "@SmokeScenario"
)
public class TestNGRunner extends AbstractTestNGCucumberTests{
}
