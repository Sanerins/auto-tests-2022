package com.example.tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class MessageTest {

    @Test
    public void openMessages() {
        logIn("piven", "secret");
        $(By.xpath("//div[@id='msg_toolbar_button']")).click();
        $(By.xpath("//input[contains(@class, 'base-input')]")).shouldBe(appear);
        logOff();
    }

    public static void logIn(String login, String pass) {
        open("https://ok.ru");
        $(By.id("field_email")).setValue(login);
        $(By.id("field_password")).setValue(pass);
        $(By.xpath("//input[@data-l='t,sign_in']")).click();
    }

    public static void logOff() {
        $(By.xpath("//div[contains(@class, 'ucard-mini toolbar_ucard js-toolbar-menu')]")).click();
        $(By.xpath("//a[@data-l='t,logout']")).click();
        $(By.id("hook_FormButton_logoff.confirm_not_decorate")).click();
    }

}
