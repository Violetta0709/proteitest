package org.veta.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Configuration.baseUrl;

public class TestBase {
    @BeforeAll
    static void configure() {
        baseUrl = "/qa-test.html";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
        Selenide.clearBrowserCookies();
    }
}
