package com.example.tests;

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
        if(!FeedPage.isOpen()) {
            System.err.println("The page provided wasn't a main page");
            assert(false);
        } else {
            page.openMessages().checkOpened();
        }
    }

    @Test
    public void findNonExistentFriendTest() {
        //Пока что просто открывает друзей и ищет пивня
        FeedPage page = new FeedPage();
        if(!FeedPage.isOpen()) {
            System.err.println("The page provided wasn't a main page");
            assert(false);
        } else {
            page.openFriends().checkOpened().searchPerson("Piven").checkFriendsNotFound();
        }
    }

}
