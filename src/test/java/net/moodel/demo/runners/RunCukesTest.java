package net.moodel.demo.runners;

import com.frameworkium.core.ui.tests.BaseTest;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.Test;

public class RunCukesTest extends BaseTest {

    @Test
    @CucumberOptions(plugin = {"pretty", "html:target/cucumber", "net.moodel.demo.utils.CustomCukeListener"},
            glue = "net.moodel.demo.steps",
            features = "src/test/resources/features",
            tags = "~@ignore")
    public class RunTests extends AbstractTestNGCucumberTests {

    }

}