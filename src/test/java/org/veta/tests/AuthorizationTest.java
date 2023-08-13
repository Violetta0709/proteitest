package org.veta.tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.veta.pages.Authorization;
import org.veta.pages.FillingForm;

import static org.veta.tests.testdata.TestData.email;
import static org.veta.tests.testdata.TestData.password;

public class AuthorizationTest extends TestBase {

    Authorization auth = new Authorization();
    FillingForm fillingForm = new FillingForm();

    @Test
    @Owner("V.Yuziykhovich")
    @DisplayName("Successfull authorization")
    void successAuthTest() {
        auth.setEmail(auth.getCorrectEmail())
                .setPassword(auth.getCorrectPassword())
                .clickSubmit();
        fillingForm.confirmSuccessAuth();
    }

    @Test
    @Owner("V.Yuzykhovich")
    @DisplayName("Unsuccessfull authorization with empty email field")
    void unsuccessAuthTest() {
        auth.setEmail(email)
                .setPassword(password)
                .checkResultWithEmptyEmail();
    }

    @Test
    @Owner("V.Yuzykhovich")
    @DisplayName("Unsuccessfull authorization with incorrect email and password")
    void unsuccessAuthTestWithRandomEmail() {
        auth.setEmail(" ")
                .setPassword(password)
                .checkResultWithNotCorrectEmail();
    }
}
