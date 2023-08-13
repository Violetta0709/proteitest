package org.veta.tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.veta.pages.Authorization;
import org.veta.pages.FillingForm;

import static org.veta.tests.testdata.TestData.email;
import static org.veta.tests.testdata.TestData.password;

public class AuthorizationTest extends TestBase {

    Authorization auth = new Authorization();
    FillingForm filling = new FillingForm();

    @Test
    @Owner("V.Yuziykhovich")
    @DisplayName("Successfull authorization")
    void successAuthTest() {
        auth.openPage()
                .setEmail(auth.getCorrectEmail())
                .setPassword(auth.getCorrectPassword())
                .clickSubmit();
        filling.checkSuccessAuth();
    }

    @Test
    @Owner("V.Yuzykhovich")
    @DisplayName("Unsuccessfull authorization with incorrect email and password")
    void unsuccessAuthTestRandomEmail() {
        auth.openPage()
                .setEmail(email)
                .setPassword(password)
                .checkResultWithNotCorrectEmail();
    }

    @Test
    @Owner("V.Yuzykhovich")
    @DisplayName("Unsuccessfull authorization with blank email field")
    void unsuccessAuthTestBlankEmail() {
        auth.openPage()
                .setEmail(" ")
                .setPassword(password)
                .checkResultWithEmptyEmail();
    }

    @ParameterizedTest(name = "Unsuccessfull authorization test")
    @CsvSource(value = {
            "polgthoil@bk.ru, %$&KOL",
            "plknoil@gmail.com, #Plkjh",
            "biuolty@mail.com,      ",
            "wetur@rambler.ru, lk%opdFGH!",
            "lkhnmu@yandex.ru, 798*fgt"
    })
    public void authTest(String emailSource, String passwordSource) {
        auth.openPage()
                .setEmail(emailSource)
                .setPassword(passwordSource)
                .checkResultWithNotCorrectEmail();
    }
}
