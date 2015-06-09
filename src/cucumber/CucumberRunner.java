package cucumber;

import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options( 
		format = {"preety", "json:target/"},
		features = {"src/cucumber/"}
		)
public class CucumberRunner {

}
