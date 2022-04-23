package com.example.tests;

import com.example.pages.FeedPage;
import com.example.pages.MessagesPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MessageOpeningTest extends BaseTest {
    @Test
    @Tag("Messages")
    @DisplayName("Open messages test")
    public void openMessages() {
        FeedPage.openPage().openMessages();
        assertThat(MessagesPage.isOpen()).isTrue();
    }
}
