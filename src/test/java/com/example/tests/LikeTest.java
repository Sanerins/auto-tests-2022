package com.example.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.example.pages.FeedPage;

import static org.assertj.core.api.Assertions.assertThat;

public class LikeTest extends BaseTest {
    @Test
    @Tag("Likes")
    @DisplayName("Likes test")
    public void setLike() {
        FeedPage feedPage = FeedPage.openPage();
        feedPage.unlikeFirstFeedBlock();

        int initialLikeCount = feedPage.getLikeCount();
        feedPage.likeFirstFeedBlock();

        assertThat(feedPage.getLikeCount()).isEqualTo(initialLikeCount + 1);
        feedPage.unlikeFirstFeedBlock();
    }
}
