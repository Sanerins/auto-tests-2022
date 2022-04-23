package com.example.pages;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class NotificationsPage {
    private static final String URL = "https://ok.ru/notifications";
    private static final SelenideElement NOTIFICATIONS_HEADER = $(byId("hook_Block_NotificationsLayerTitle"));

    public NotificationsPage() {
        NOTIFICATIONS_HEADER.shouldBe(Condition.visible);
    }

    public static NotificationsPage openPage() {
        open(URL);
        return new NotificationsPage();
    }

    public static boolean isOpen() {
        return NOTIFICATIONS_HEADER.isDisplayed();
    }

    public static String getURL() {
        return URL;
    }
}