package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "@target\\rerunfile.txt", 
glue = "stepDef", dryRun = false, monochrome = true, plugin = {
		"pretty", "html:target/htmlrep.html", "json:target/jsonrep.json", "junit:target/junitrep.xml",
		"rerun:target/rerunfile.txt" })
public class ReRunner {

}
