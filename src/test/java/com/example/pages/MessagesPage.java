package com.example.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MessagesPage {
    private static final SelenideElement MESSAGE_BUTTON = $(byId("msg_toolbar_button"));
    public static String url = "https://ok.ru/messages";

    public MessagesPage() {
        MESSAGE_BUTTON.shouldBe(visible);
    }

    public static MessagesPage openPage() {
        open(url);
        return new MessagesPage();
    }

    public boolean isOpen() {
        return MESSAGE_BUTTON.isDisplayed();
    }
}
