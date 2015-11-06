package core;

import com.codeborne.selenide.Configuration;

public class BaseTest extends WithReportedScreenshotsPerTest {

    {
        Configuration.browser = System.getProperty("driver.browser");
    }
}
