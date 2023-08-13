package org.veta.pages;

import com.codeborne.selenide.CollectionCondition;

import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class FillingForm {

    public void checkSuccessAuth() {
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
        $("#dataGender").selectOptionByValue("Мужской");
        return this;
    }

    public FillingForm checkOptionsFirst() {
        $$("input[type='checkbox']")
                .shouldHave(CollectionCondition.size(2))
                .first()
                .shouldHave(text("Вариант 1.1"));
        return this;
    }

    public FillingForm checkOptinsSecond() {
        $$("input[type='radio']")
                .shouldHave(CollectionCondition.size(3))
                .first()
                .shouldHave(text("Вариан 2.1"));
        return this;
    }

    public FillingForm submitData() {
        $("#dataSend").click();
        return this;
    }

    public FillingForm checkTableFilled() {
        $$("#dataTable tbody tr").shouldHave(CollectionCondition.sizeGreaterThan(1));
        return this;
    }

    public void checkDataAdded() {
        $(".uk-modal-content").shouldHave(text("Данные добавлены"));
    }

    public void checkNameFieldBlank() {
        $("#blankNameError").shouldHave(text("Поле имя не может быть пустым"));
    }

    public void checkEmailFormatError() {
        $("#emailFormatError").shouldHave(text("Неверный формат E-Mail"));
    }
}

