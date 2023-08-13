package org.veta.pages;

import com.codeborne.selenide.Condition;
import lombok.Data;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Data
public class Authorization {

    private String correctEmail = "test@protei.ru";
    private String correctPassword = "test";

    public Authorization openPage() {
        open("/qa-test.html");
        return this;
    }

    public Authorization setEmail(String value) {
        $("#loginEmail").setValue(value);
        return this;
    }

    public Authorization setPassword(String value) {
        $("#loginPassword").setValue(value);
        return this;
    }

    public void clickSubmit() {
        $("#authButton").click();
    }

    public void checkResultWithNotCorrectEmail() {
        $("#authButton").click();
        $("#invalidEmailPassword").shouldHave(Condition.text("Неверный E-Mail или пароль"));
    }

    public void checkResultWithEmptyEmail() {
        $("#authButton").click();
        $("#emailFormatError").shouldHave(Condition.text("Неверный формат E-Mail"));
    }
}
