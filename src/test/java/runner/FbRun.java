package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\ibu95\\eclipse-workspace2\\Mvn02Pm\\src\\test\\resources\\Features", 
glue = "stepDef", dryRun = false, tags = "@chrome", monochrome = true,
plugin = {
		"pretty", "html:target/htmlrep.html",
		"json:target/jsonrep.json",
		"junit:target/junitrep.xml",
		"rerun:target/rerunfile.txt", 
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class FbRun {

}
