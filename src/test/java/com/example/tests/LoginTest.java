package com.example.tests;

import com.example.pages.FeedPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import static org.assertj.core.api.Assertions.assertThat;

public class LoginTest extends BaseTest {
    @Test
    @Tag("Login")
    @DisplayName("Login test")
    public void loginTest() throws IOException {
        authorize();
        assertThat(FeedPage.isOpen()).isTrue();
    }
}
