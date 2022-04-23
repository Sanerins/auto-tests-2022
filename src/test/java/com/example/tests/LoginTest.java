package com.example.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.example.pages.FeedPage;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginTest extends BaseTest {
    @Test
    @Tag("Likes")
    @DisplayName("Likes test")
    public void loginTest() {
        FeedPage feedPage = FeedPage.openPage();
        assertThat(feedPage.isOpen()).isTrue();
    }
}
