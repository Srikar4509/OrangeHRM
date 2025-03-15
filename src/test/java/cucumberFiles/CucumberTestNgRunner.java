package cucumberFiles;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/cucumberFiles",glue="step_definition_package",monochrome=true,plugin= {"html:reports/cucmber.html"})
public class CucumberTestNgRunner extends AbstractTestNGCucumberTests{

}
