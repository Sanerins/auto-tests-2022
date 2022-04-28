package com.example.tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.example.pages.FeedPage;
import com.example.pages.GuestsPage;

import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

public class GuestsOpeningTest extends BaseTest {
    private static FeedPage page;
    @BeforeAll
    public static void openPage() {
        page = new FeedPage();
        open(page.getURL());
    }

    @Test
    @Tag("Guests")
    @DisplayName("Best guests test ever")
    public void openGuests() {
        GuestsPage guestsPage = page.openGuests();
        assertThat(guestsPage.isOpen()).isTrue();
    }
}
