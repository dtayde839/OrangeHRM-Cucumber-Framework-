package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = ".//Features/Dashboard.feature",
		glue="StepDefinition",
		dryRun = false,
		monochrome = true,
//		plugin = {"pretty", "html:target/cucumber-reports/report1.html"}
//		plugin = {"pretty", "json:target/cucumber-reports/report_json.json"} 
		plugin = {
					"pretty", "junit:target/cucumber-reports/report_xml.xml", 
							  "html:target/cucumber-reports/report1.html", 
							  "json:target/cucumber-reports/report_json.json"
				 }
		)
public class Run extends AbstractTestNGCucumberTests
{
	
}
