package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src\\test\\resources\\Features\\loginPF.feature", 
					glue={"StepDefinations"},
					monochrome=true,
					plugin={"pretty","html:Reports\\html\\HTMLReport.html",
						"pretty","json:Reports\\json\\JSONReport.json",
						"pretty","junit:Reports\\xml\\XMLReport.xml"},
					tags= ("@smoke or @regression")
		)

public class TestRunner {
}
