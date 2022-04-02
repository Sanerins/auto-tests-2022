package com.example.tests;

import com.example.pages.MessagesPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class MessageOpeningTest extends BaseTest {
    @Test
    void openMessages() throws IOException {
        authorize().openMessages();
        Assertions.assertTrue(MessagesPage.isOpen());
    }
}
