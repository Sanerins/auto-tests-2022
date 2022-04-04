package com.example.pages;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class NotificationsPage {
    private static final String url = "https://ok.ru/notifications";
    private static final SelenideElement notificationsHeader = $(By.id("hook_Block_NotificationsLayerTitle"));

    public NotificationsPage() {
        notificationsHeader.shouldBe(Condition.visible);
    }

    public static NotificationsPage openPage() {
        open(url);
        return new NotificationsPage();
    }

    public static boolean isOpen() {
        return notificationsHeader.isDisplayed();
    }

    public static String getURL() {
        return url;
    }
}