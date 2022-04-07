package com.example.tests;

import com.example.pages.FeedPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;

class SearchForFriendTest extends BaseTest {

    @ParameterizedTest
    @ValueSource(strings = {"Пивень", "ПивПивыч", "Пивчанский"})
    void findNonExistentFriendTest(String nonExistentFriendName) throws IOException {
        authorize();
        Assertions.assertTrue(new FeedPage()
                .openFriends()
                .searchPerson(nonExistentFriendName)
                .friendNotFound());
        logOff();
    }
}
