package com.todomvc.testconfigs;

import core.BaseTest;
import org.junit.Before;
import org.junit.BeforeClass;

import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.open;

public class AtToDoMVCWithClearedDataAfterEachTest extends BaseTest {

    @BeforeClass
    public static void openToDoMVC() {
        open("http://todomvc.com/examples/troopjs_require/");
    }

    @Before
    public void clearData() {
        executeJavaScript("localStorage.clear()");
        open("http://todomvc.com");
        open("http://todomvc.com/examples/troopjs_require/");
    }
}
