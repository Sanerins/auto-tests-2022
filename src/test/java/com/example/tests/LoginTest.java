package com.example.tests;

import com.example.pages.FeedPage;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginTest extends BaseTest {
    @Test
    public void loginTest() {
        assertThat(FeedPage.isOpen()).isTrue();
    }
}
