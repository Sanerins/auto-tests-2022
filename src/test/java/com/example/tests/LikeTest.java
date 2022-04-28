package com.example.tests;

import com.example.pages.FeedPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LikeTest extends BaseTest {
    private static FeedPage feedPage;
    
    @Test
    @Tag("Likes")
    @DisplayName("Likes test")
    public void setLike() {
        feedPage = FeedPage.openPage();
        feedPage.unlikeFirstFeedBlock();

        int initialLikeCount = feedPage.getLikeCount();
        feedPage.likeFirstFeedBlock();

        assertThat(feedPage.getLikeCount()).isEqualTo(initialLikeCount + 1);
    }

    @AfterAll
    static void unlike() {
        feedPage.unlikeFirstFeedBlock();
    }
}
