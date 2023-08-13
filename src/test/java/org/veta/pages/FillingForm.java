package org.veta.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class FillingForm {

    public FillingForm confirmSuccessAuth() {
        $("#dataSend").shouldHave(text("Добавить"));
        return this;
    }

    public FillingForm fillEmail(String value) {
        $("#dataEmail").setValue(value);
        return this;
    }

    public FillingForm fillName(String value) {
        $("#dataName").setValue(value);
        return this;
    }

    public FillingForm selectGender() {
        $("#dataGender").selectOptionByValue("мужской");
        return this;

    }

}
