package testconfigs;

import core.BrowserConfigAndReportedScreenshotsPerTest;
import org.junit.After;
import org.junit.Before;

import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.open;
import static pages.ToDoMVCPage.openToDoMVCPage;

public class AtToDoMVCWithClearedDataAfterEachTest extends BrowserConfigAndReportedScreenshotsPerTest {

    @Before
    public void loadToDoMVCPage() {
        openToDoMVCPage();
    }

    @After
    public void clearData() {
        executeJavaScript("localStorage.clear()");
        open("http://todomvc.com");
    }
}