package net.moodel.demo.utils;

import com.frameworkium.core.ui.tests.BaseTest;
import org.junit.runner.notification.Failure;
import org.openqa.selenium.OutputType;
import ru.yandex.qatools.allure.annotations.Attachment;
//import ru.yandex.qatools.allure.cucumberjvm.AllureRunListener;

/**
 * This class overrides the ru.yandex.qatools.allure.cucumberjvm.AllureRunListener
 * class as screenshots on test failures were not being attached to the allure
 * reports
 */
public class CustomAllureRunListener  {

//    @Override
//    public void testFailure(Failure failure) {
//        super.testFailure(failure);
//        if (!failure.getDescription().isSuite()) {
//            failureScreenshot();
//        }
//    }
//
//    @Attachment
//    public byte[] failureScreenshot() {
//        return takeScreenshot();
//    }
//
//    private byte[] takeScreenshot() {
//        return BaseTest.getDriver().getScreenshotAs(OutputType.BYTES);
//    }

}
