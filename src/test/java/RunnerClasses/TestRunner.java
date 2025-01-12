package RunnerClasses;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = "src/main/java/Features",
	    glue = "src/main/java/StepDefs/Login",
	    tags = "@Login"  // Specify the tag you want to run
	)

public class TestRunner {

}
