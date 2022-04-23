package com.example.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MessagesPage {
    public static String url = "https://ok.ru/messages";
    private static final SelenideElement MESSAGE_BUTTON = $(byId("msg_toolbar_button"));

    public MessagesPage() {
        MESSAGE_BUTTON.shouldBe(Condition.visible);
    }

    public static MessagesPage openPage() {
        open(url);
        return new MessagesPage();
    }

    public static String getURL() {
        return url;
    }

    public static boolean isOpen() {
        return MESSAGE_BUTTON.isDisplayed();
    }
}
