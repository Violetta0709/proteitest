package org.veta.tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.veta.pages.Authorization;

import static org.veta.tests.testdata.TestData.email;
import static org.veta.tests.testdata.TestData.password;

public class CheckingFormTest extends TestBase {

    Authorization auth = new Authorization();

    @Test
    @Owner("V.Yuziykhovich")
    @DisplayName("Successfull authorization")
    void successAuthorizationTest() {
        auth
                .setEmail(auth.getCorrectEmail())
                .setPassword(auth.getCorrectPassword())
                .clickSubmit();
    }

}
