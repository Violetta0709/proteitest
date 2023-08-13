package org.veta.tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.veta.pages.FillingForm;

import static org.veta.tests.testdata.TestData.email;
import static org.veta.tests.testdata.TestData.name;

public class CheckingFormTest extends TestBase {

    FillingForm filling = new FillingForm();

    @Test
    @Owner("V.Yuziykhovich")
    @DisplayName("Checking form filled successfull")
    void checkFilledFormTest() {
        filling.fillEmail(email)
                .fillName(name)
                .selectGender()
                .selectOptionsFirst()
                .selectOptinsSecond()
                .submitData()
                .checkTableFilled()
                .checkDataAdded();
    }

    @Test
    @Owner("V.Yuziykhovich")
    @DisplayName("Checking form filled successfull")
    void checkFilledFormTest2() {
        filling.fillEmail(email)
                .fillName(name)
                .selectGender()
                .selectOptionsFirst()
                .selectOptinsSecond()
                .submitData()
                .checkTableFilled()
                .checkDataAdded();
    }
}
