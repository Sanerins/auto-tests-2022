package com.example.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import com.codeborne.selenide.Selenide;
import com.example.pages.FeedPage;
import com.example.pages.MessagesPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class FeedTest implements Authorized {

    @BeforeEach
    public void openFeedPage() {
        new FeedPage().openPage();
    }

    @Test
    public void openMessages() {
        FeedPage page = new FeedPage();
        Assertions.assertTrue(FeedPage.isOpen(), "The page provided wasn't a main page");
        page.openMessages().checkOpened();
    }

    @Test
    public void findNonExistentFriendTest() {
        FeedPage page = new FeedPage();
        Assertions.assertTrue(FeedPage.isOpen(), "The page provided wasn't a main page");
        page.openFriends().checkOpened().searchPerson("Пивень").checkFriendsNotFound();
    }

}
