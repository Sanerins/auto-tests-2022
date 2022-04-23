package com.example.tests;

import com.example.pages.FeedPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PublishPostTest extends BaseTest {
    private static final String QUOTE = "Если волк молчит, лучше его не перебивать.";

    @Test
    @Tag("Posts")
    @DisplayName("Publish post test")
    public void publishPost() {
        FeedPage feedPage = FeedPage.openPage().publishPost(QUOTE);
        assertThat(feedPage.checkWhetherPostWithTextDisplayed(QUOTE)).isTrue();
    }
}
