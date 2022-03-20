package com.example.pages;

import org.openqa.selenium.By;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MessagesPage {
    public static String url = "https://ok.ru/messages";

    public MessagesPage openPage() {
        open(url);
        return this;
    }

    public static String getURL() {
        return url;
    }

    public MessagesPage checkOpened() {
        locator().shouldBe(Condition.visible);
        return this;
    }

    public static boolean isOpen() {
        return locator().exists();
    }

    public static SelenideElement locator() {
        return $(By.id("msg_toolbar_button"));
    }
}
