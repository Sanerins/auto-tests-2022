package com.example.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GuestsPage {
    private static final String URL = "https://ok.ru/guests";
    private static final SelenideElement GUESTS_HEADER = $(By.id("hook_Block_UserGuests"));

    public GuestsPage() {
        GUESTS_HEADER.shouldBe(visible);
    }

    public static GuestsPage openPage() {
        open(URL);
        return new GuestsPage();
    }

    public static boolean isOpen() {
        return GUESTS_HEADER.isDisplayed();
    }

    public static String getURL() {
        return URL;
    }
}
