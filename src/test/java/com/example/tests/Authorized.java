package com.example.tests;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public interface Authorized {
    @BeforeAll
    static void authorize() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("credentials.txt"));
        open("https://ok.ru");
        $(By.id("field_email")).setValue(reader.readLine());
        $(By.id("field_password")).setValue(reader.readLine());
        $(By.xpath("//input[@data-l='t,sign_in']")).click();
    }

    @AfterAll
    static void logOff() {
        $(By.xpath("//div[contains(@class, 'ucard-mini toolbar_ucard js-toolbar-menu')]")).click();
        $(By.xpath("//a[@data-l='t,logout']")).click();
        $(By.id("hook_FormButton_logoff.confirm_not_decorate")).click();
    }
}
