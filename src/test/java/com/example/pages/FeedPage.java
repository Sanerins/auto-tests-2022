package com.example.pages;

import org.openqa.selenium.By;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FeedPage {
    public static String url = "https://ok.ru";

    public FeedPage openPage() {
        open(url);
        return this;
    }

    public LoginPage logOff() {
        $(By.xpath("//div[contains(@class, 'ucard-mini toolbar_ucard js-toolbar-menu')]")).click();
        $(By.xpath("//a[@data-l='t,logout']")).click();
        $(By.id("hook_FormButton_logoff.confirm_not_decorate")).click();
        return new LoginPage();
    }

    public static String getURL() {
        return url;
    }

    public FeedPage checkOpened() {
        locator().shouldBe(Condition.visible);
        return this;
    }

    public MessagesPage openMessages() {
        $(By.xpath("//div[@id='msg_toolbar_button']")).click();
        return new MessagesPage();
    }

    public static boolean isOpen() {
        return locator().exists();
    }

    public static SelenideElement locator() {
        return $(By.id("viewImageLinkId"));
    }
}
