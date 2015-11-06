package testconfigs;

import core.BrowserConfigAndReportedScreenshotsPerTest;
import org.junit.After;
import org.junit.Before;

import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.open;
import static pages.ToDoMVCPage.openTodoMVCPage;

public class AtToDoMVCWithClearedDataAfterEachTest extends BrowserConfigAndReportedScreenshotsPerTest {

    @Before
    public void loadToDoMVCPage() {
        openTodoMVCPage();
    }

    @After
    public void clearData() {
        executeJavaScript("localStorage.clear()");
        open("http://todomvc.com");
    }
}