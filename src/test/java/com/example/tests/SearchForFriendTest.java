package com.example.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import com.example.pages.FeedPage;
import com.example.utils.NonExistentFriendsProvider;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchForFriendTest extends BaseTest {

    @ParameterizedTest
    @Tag("Friends")
    @DisplayName("Find non existent friends test")
    @ArgumentsSource(NonExistentFriendsProvider.class)
    public void findNonExistentFriendTest(String nonExistentFriendName) {
        FeedPage.openPage();
        assertThat(new FeedPage()
                .openFriends()
                .searchPerson(nonExistentFriendName)
                .friendNotFound()).isTrue();
    }
}
