package org.veta.tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.veta.pages.Authorization;
import org.veta.pages.FillingForm;

import static org.veta.tests.testdata.TestData.email;
import static org.veta.tests.testdata.TestData.name;

public class CheckingFormTest extends TestBase {

    FillingForm filling = new FillingForm();
    Authorization auth = new Authorization();

    @Test
    @Owner("V.Yuziykhovich")
    @DisplayName("Checking form filled successfull")
    void checkFilledFormTest() {
        auth.openPage()
                .setEmail(auth.getCorrectEmail())
                .setPassword(auth.getCorrectPassword())
                .clickSubmit();
        filling.fillEmail(email)
                .fillName(name)
                .selectGender()
                .checkOptionsFirst()
                .checkOptinsSecond()
                .submitData()
                .checkTableFilled()
                .checkDataAdded();
    }

    @ParameterizedTest(name = "Unsusccessfull filling form (email error)")
    @CsvSource(value = {
            "xxxmail.ru , cvbny678!",
            "polgthoilbk.ru, %$&KOL",
            "plknoilgmail.com, #Plkjh",
            "biuoltymail.com, Bnmth56",
            "weturrambler.ru, lkopdFGH!",
    })
    void checkFilledFormEmailErrorTest(String emailSource, String nameSource) {
        auth.openPage()
                .setEmail(auth.getCorrectEmail())
                .setPassword(auth.getCorrectPassword())
                .clickSubmit();
        filling.fillEmail(emailSource)
                .fillName(nameSource)
                .selectGender()
                .checkOptionsFirst()
                .checkOptinsSecond()
                .submitData()
                .checkEmailFormatError();
    }

    @ParameterizedTest(name = "Unsuccessfull filling form (invalid name)")
    @CsvSource(value = {
            "xxx@mail.ru ,    ",
            "polgthoil@bk.ru, %$&KOL",
            "plknoil@gmail.com, #Plkjh",
            "biuolty@mail.com, !!Bnmth56",
            "wetur@rambler.ru,      ",
            "pricrtu@gmail.com, %$&KOL",
            "lkhnmu@yandex.ru, 798*fgt"
    })
    void checkFilledFormInvalidErrorTest(String emailSource, String nameSource) {
        auth.openPage()
                .setEmail(auth.getCorrectEmail())
                .setPassword(auth.getCorrectPassword())
                .clickSubmit();
        filling.fillEmail(emailSource)
                .fillName(nameSource)
                .selectGender()
                .checkOptionsFirst()
                .checkOptinsSecond()
                .submitData()
                .checkNameFieldBlank();
    }
}
