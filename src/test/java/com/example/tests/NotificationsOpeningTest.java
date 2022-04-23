package com.example.tests;

import com.example.pages.FeedPage;
import com.example.pages.NotificationsPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NotificationsOpeningTest extends BaseTest {
    @Test
    @Tag("Notifications")
    @DisplayName("Open notifications test")
    public void openNotifications() {
        NotificationsPage notificationsPage = FeedPage.openPage().openNotifications();
        assertThat(notificationsPage.isOpen()).isTrue();
    }
}