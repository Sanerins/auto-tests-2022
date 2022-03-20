package com.example.pages;

import java.util.concurrent.ExecutionException;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import com.example.utils.User;
import com.google.common.util.concurrent.ExecutionError;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {
    public static String url = "https://ok.ru";

    public LoginPage openPage() {
        open(url);
        return this;
    }

    public FeedPage login(User user) {
        $(By.id("field_email")).setValue(user.login);
        $(By.id("field_password")).setValue(user.password);
        $(By.xpath("//input[@data-l='t,sign_in']")).click();
        return new FeedPage();
    }

    public static String getURL() {
        return url;
    }

    public LoginPage checkOpened() {
        locator().shouldBe(Condition.visible);
        return this;
    }

    public static boolean isOpen() {
        return locator().exists();
    }

    public static SelenideElement locator() {
        return $(By.xpath("//a[@data-l='t,login_tab']"));
    }
}
