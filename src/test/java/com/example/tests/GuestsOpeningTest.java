package com.example.tests;

import com.example.pages.FeedPage;
import com.example.pages.GuestsPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GuestsOpeningTest extends BaseTest {
    @Test
    @Tag("Guests")
    @DisplayName("Best guests test ever")
    public void openGuests() {
        FeedPage.openPage().openGuests();
        assertThat(GuestsPage.isOpen()).isTrue();
    }
}
