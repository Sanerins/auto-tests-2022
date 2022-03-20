package com.example.pages;

import org.openqa.selenium.By;

import com.example.utils.User;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {
    public static String url = "https://ok.ru";

    public static void openPage() {
        open(url);
        if (!isOpen()) {
            throw new UnsupportedOperationException();
        }
    }

    public static void login(User user) {
        $(By.id("field_email")).setValue(user.login);
        $(By.id("field_password")).setValue(user.password);
        $(By.xpath("//input[@data-l='t,sign_in']")).click();
        if (!FeedPage.isOpen()) {
            throw new UnsupportedOperationException();
        }
    }

    public static String getURL() {
        return url;
    }

    public static boolean isOpen() {
        return $(By.xpath("//a[@data-l='t,login_tab']")).exists();
    }
}
