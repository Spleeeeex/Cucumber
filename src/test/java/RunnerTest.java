import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME,
        value = "html:target/cucumber-report/cucumber.html," +
                "json:target/cucumber-report/cucumber.json," +
                "pretty:target/cucumber-report/cucumber-pretty.txt," +
                "usage:target/cucumber-report/cucumber-usage.json," +
                "junit:target/cucumber-report/cucumber-results.xml")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "steps")

public class RunnerTest {
}