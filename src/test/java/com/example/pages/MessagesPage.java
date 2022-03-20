package com.example.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MessagesPage {
    public static String url = "https://ok.ru/messages";

    public static void openPage() {
        open(url);
        if (!isOpen()) {
            throw new UnsupportedOperationException();
        }
    }

    public static String getURL() {
        return url;
    }

    public static boolean isOpen() {
        return $(By.id("msg_toolbar_button")).exists();
    }
}
