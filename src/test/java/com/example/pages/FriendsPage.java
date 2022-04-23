package com.example.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FriendsPage {
    private static final SelenideElement FRIENDS_SEARCH_FIELD = $(byXpath("//input[@accesskey='s']"));
    public static String url = "https://ok.ru/friends";

    public FriendsPage() {
        FRIENDS_SEARCH_FIELD.shouldBe(visible);
    }

    public FriendsPage openPage() {
        open(url);
        return new FriendsPage();
    }

    public SearchFriendsPage searchPerson(String input) {
        char[] chars = input.toCharArray();
        for (char letter : chars) {
            FRIENDS_SEARCH_FIELD.append(String.valueOf(letter));
            Selenide.sleep(50);
        }
        FRIENDS_SEARCH_FIELD.pressEnter();
        Selenide.sleep(100);
        return new SearchFriendsPage();
    }
}

