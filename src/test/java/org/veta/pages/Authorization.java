package org.veta.pages;

import com.codeborne.selenide.Condition;
import lombok.Data;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Data
public class Authorization {

    private String correctEmail = "test@protei.ru";
    private String correctPassword = "test";

 //   public Authorization openPage() {
    //    open("qa-test/qa-test.html");
    //    return this;
   // }

    public Authorization setEmail(String value) {
        $("#loginEmail").setValue(value);
        return this;
    }

    public Authorization setPassword(String value) {
        $("#loginPassword").setValue(value);
        return this;
    }

    public Authorization clickSubmit() {
        $("#authButton").click();
        $("#loginEmail").shouldHave(Condition.text("Неверный E-Mail или пароль"));
        return this;
    }


    public Authorization checkResultWithNotCorrectEmail() {
        $("#authButton").click();
        $("#loginEmail").shouldHave(Condition.text("Неверный E-Mail или пароль"));
        return this;
    }

    public Authorization checkResultWithEmptyEmail() {
        $("#authButton").click();
        $("#loginEmail").shouldHave(Condition.text("Неверный формат E-Mail"));
        return this;
    }
}
