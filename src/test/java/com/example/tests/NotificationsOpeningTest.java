package com.example.tests;

import com.example.pages.NotificationsPage;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class NotificationsOpeningTest extends BaseTest {
    @Test
    void openNotifications() throws IOException {
        authorize().openNotifications();
        assertThat(NotificationsPage.isOpen()).isTrue();
    }
}