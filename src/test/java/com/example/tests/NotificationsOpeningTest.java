package com.example.tests;

import com.example.pages.FeedPage;
import com.example.pages.NotificationsPage;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NotificationsOpeningTest extends BaseTest {
    @Test
    public void openNotifications() {
        FeedPage.openPage().openNotifications();
        assertThat(NotificationsPage.isOpen()).isTrue();
    }
}