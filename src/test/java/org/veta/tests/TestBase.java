package org.veta.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    @BeforeAll

    static void configure() {
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }
}
