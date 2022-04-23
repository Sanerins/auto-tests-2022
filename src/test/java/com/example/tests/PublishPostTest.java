package com.example.tests;

import org.junit.jupiter.api.Test;

import com.example.pages.FeedPage;

import static org.assertj.core.api.Assertions.assertThat;

public class PublishPostTest extends BaseTest {
    private static final String QUOTE = "Если волк молчит, лучше его не перебивать.";

    @Test
    public void publishPost() {
        FeedPage feedPage = FeedPage.openPage().publishPost(QUOTE);
        assertThat(feedPage.checkWhetherPostWithTextDisplayed(QUOTE)).isTrue();
    }
}
