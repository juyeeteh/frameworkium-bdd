package net.moodel.demo.runners;

import com.frameworkium.core.ui.tests.BaseTest;
import cucumber.api.CucumberOptions;
import net.moodel.demo.utils.TestNgListner;
import org.junit.runner.RunWith;
import com.frameworkium.core.ui.tests.BaseTest;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners({TestNgListner.class})
public class RunCukesTest extends BaseTest{

    @Test
@CucumberOptions(plugin = {"pretty", "html:target/cucumber"},
        glue = "net.moodel.demo.steps",
        features = "src/test/resources/features",
        tags = "~@ignore")
    public class RunMapTests extends AbstractTestNGCucumberTests {
        @BeforeSuite
        public void beforeSuite(){
            System.out.println("in before suite2 ");
        }
    }

}
