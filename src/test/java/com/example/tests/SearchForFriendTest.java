package com.example.tests;


import com.example.pages.FeedPage;
import com.example.utils.NonExistentFriendsProvider;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

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
}
