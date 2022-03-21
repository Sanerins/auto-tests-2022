package com.example.pages;

import org.openqa.selenium.By;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class FriendsPage {
    public FriendsPage checkOpened() {
        locator().shouldBe(Condition.visible);
        return this;
    }

    public static boolean isOpen() {
        return locator().exists();
    }

    public FriendsPage searchPerson(String input) {
        SelenideElement elem = $(By.xpath("//input[@accesskey='s']"));
        char[] chars = input.toCharArray();
        for(char letter : chars) {
            elem.append(String.valueOf(letter));
            Selenide.sleep(10);
        }
        elem.pressEnter();
        Selenide.sleep(100);
        return this;
    }

    public FriendsPage checkFriendsNotFound() {
        $(By.className("stub-empty")).shouldBe(Condition.visible);
        return this;
    }

    public static SelenideElement locator() {
        return $(By.className("friend-search-w__g4cu4"));
    }
}

