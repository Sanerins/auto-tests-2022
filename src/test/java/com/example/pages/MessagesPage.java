package com.example.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

public class MessagesPage implements Page {
    private static final SelenideElement MESSAGE_BUTTON = $(byId("msg_toolbar_button"));
    public static final String URL = "https://ok.ru/messages";

    public boolean isOpen() {
        return MESSAGE_BUTTON.isDisplayed();
    }

    @Override
    public void await() {
        MESSAGE_BUTTON.shouldBe(visible);
    }

    @Override
    public String getURL() {
        return URL;
    }
}
