package org.veta.pages;

import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class FillingForm {

    public void confirmSuccessAuth() {
        $("#dataSend").shouldHave(text("Добавить"));
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

    public FillingForm selectOptionsFirst() {
        $$("[type=checkbox]").first().click();
        return this;
    }

    public FillingForm selectOptinsSecond() {
        $$("[type=radio]").first().click();
        return this;
    }

    public FillingForm submitData() {
        $("#dataSend").click();
        return this;
    }

    public FillingForm checkTableFilled() {
        $("#dataTable").shouldNotBe(empty);
        return this;
    }

    public FillingForm checkDataAdded() {
        $(".uk-modal-content").shouldHave(text("Данные добавлены"));
        return this;
    }

    public FillingForm checkNameFieldBlank() {
        $("#blankNameError").shouldHave(text("Поле имя не может быть пустым"));
        return this;
    }

    public FillingForm checkEmailFormatError() {
        $("#emailFormatError").shouldHave(text("Неверный формат E-mail"));
        return this;
    }
}

