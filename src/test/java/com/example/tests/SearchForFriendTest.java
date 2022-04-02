package com.example.tests;

import com.example.pages.FeedPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class SearchForFriendTest extends BaseTest {
    private static final String nonExistentFriendName = "Пивень";

    @Test
    void findNonExistentFriendTest() throws IOException {
        authorize();
        Assertions.assertTrue(new FeedPage()
                .openFriends()
                .searchPerson(nonExistentFriendName)
                .friendNotFound());
    }
}
