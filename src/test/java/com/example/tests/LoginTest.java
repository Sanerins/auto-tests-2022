package com.example.tests;

import com.example.pages.FeedPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class LoginTest extends BaseTest {
    @Test
    void loginTest() throws IOException {
        authorize();
        Assertions.assertTrue(FeedPage.isOpen());
    }
}
