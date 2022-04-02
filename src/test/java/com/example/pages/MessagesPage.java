package com.example.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MessagesPage {
    public static String url = "https://ok.ru/messages";
    private static final SelenideElement messageButton = $(By.id("msg_toolbar_button"));

    public MessagesPage() {
        messageButton.shouldBe(Condition.visible);
    }

    public static MessagesPage openPage() {
        open(url);
        return new MessagesPage();
    }

    public static String getURL() {
        return url;
    }

    public static boolean isOpen() {
        return messageButton.isDisplayed();
    }
}
