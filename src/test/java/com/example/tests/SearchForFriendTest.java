package com.example.tests;


import com.example.pages.FeedPage;
import com.example.utils.NonExistentFriendsProvider;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

public class SearchForFriendTest extends BaseTest {
    private static FeedPage feedPage;

    @BeforeAll
    public static void openPage() {
        feedPage = new FeedPage();
        open(feedPage.getURL());
    }

    @ParameterizedTest
    @Tag("Friends")
    @DisplayName("Find non existent friends test")
    @ArgumentsSource(NonExistentFriendsProvider.class)
    public void findNonExistentFriendTest(String nonExistentFriendName) {
        assertThat(feedPage.openFriends().searchPerson(nonExistentFriendName).friendNotFound()).isTrue();
    }

    @BeforeEach
    public void setup() throws IOException {
        authorize(createUser());
    }

    @AfterEach
    public void finish() throws IOException {
        logOff();
    }
}
