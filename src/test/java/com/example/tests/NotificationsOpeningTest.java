package com.example.tests;

import com.example.pages.MessagesPage;
import com.example.pages.NotificationsPage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class NotificationsOpeningTest extends BaseTest {
    @Test
    void openNotifications() throws IOException {
        authorize().openNotifications();
        Assertions.assertTrue(NotificationsPage.isOpen());
    }
}