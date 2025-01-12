package RunnerClasses;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = "src/main/java/Features",
	    glue = "Login",
	    tags = "@Login"  // Specify the tag you want to run
	)

public class TestRunner extends AbstractTestNGCucumberTests {

}
