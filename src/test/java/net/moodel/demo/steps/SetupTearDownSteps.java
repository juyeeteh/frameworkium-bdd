package net.moodel.demo.steps;

import com.frameworkium.core.ui.tests.BaseTest;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import net.moodel.demo.utils.PropertyUtils;
import org.testng.annotations.BeforeSuite;

/**
 * Functionality for setup and teardown
 */
public class SetupTearDownSteps extends BaseTest {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("in before suite ");
    }


    @Before
    public void setup() {
        PropertyUtils.loadProperties();

        // This needs to be run once at the very start of any scenario
        instantiateDriverObject();
        configureBrowserBeforeUse();
    }

    @After
    public void tearDown(Scenario scenario) {

        BaseTest.getDriver().quit();

    }

}
