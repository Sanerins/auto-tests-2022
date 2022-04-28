package com.example.pages;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class NotificationsPage implements Page {
    private static final String URL = "https://ok.ru/notifications";
    private static final SelenideElement NOTIFICATIONS_HEADER = $(byId("hook_Block_NotificationsLayerTitle"));

    public static NotificationsPage openPage() {
        open(URL);
        return new NotificationsPage();
    }

    public boolean isOpen() {
        return NOTIFICATIONS_HEADER.isDisplayed();
    }

    @Override
    public void await() {
        NOTIFICATIONS_HEADER.shouldBe(visible);
    }

    @Override
    public String getURL() {
        return URL;
    }
}