package com.example.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FriendsPage {
    public static String url = "https://ok.ru/friends";
    private static final SelenideElement friendsSearchField = $(By.xpath("//input[@accesskey='s']"));

    public FriendsPage() {
        friendsSearchField.shouldBe(Condition.visible);
    }

    public FriendsPage openPage() {
        open(url);
        return new FriendsPage();
    }

    public static boolean isOpen() {
        return friendsSearchField.isDisplayed();
    }

    public SearchFriendsPage searchPerson(String input) {
        char[] chars = input.toCharArray();
        for (char letter : chars) {
            friendsSearchField.append(String.valueOf(letter));
            Selenide.sleep(50);
        }
        friendsSearchField.pressEnter();
        Selenide.sleep(100);
        return new SearchFriendsPage();
    }
}

