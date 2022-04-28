package com.example.tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.example.pages.FeedPage;

import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

public class PublishPostTest extends BaseTest {
    private static final String QUOTE = "Если волк молчит, лучше его не перебивать.";
    private static FeedPage feedPage;

    @BeforeAll
    public static void openPage() {
        feedPage = new FeedPage();
        open(feedPage.getURL());
    }

    @Test
    @Tag("Posts")
    @DisplayName("Publish post test")
    public void publishPost() {
        feedPage.publishPost(QUOTE);
        assertThat(feedPage.checkWhetherPostWithTextDisplayed(QUOTE)).isTrue();
    }
}
