package com.example.tests;

import com.example.pages.FeedPage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class SearchForFriendTest extends BaseTest {

    @ParameterizedTest
    @ValueSource(strings = {"Пивень", "ПивПивыч", "Пивчанский"})
    void findNonExistentFriendTest(String nonExistentFriendName) throws IOException {
        authorize();
        assertThat(new FeedPage()
                .openFriends()
                .searchPerson(nonExistentFriendName)
                .friendNotFound()).isTrue();
        logOff();
    }
}
