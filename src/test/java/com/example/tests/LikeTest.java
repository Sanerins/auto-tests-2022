package com.example.tests;

import com.example.pages.FeedPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import static org.assertj.core.api.Assertions.assertThat;

public class LikeTest extends BaseTest {
    @Test
    @Tag("Likes")
    @DisplayName("Likes test")
    public void setLike() throws IOException {
        FeedPage feedPage = authorize();
        feedPage.unlikeFirstFeedBlock();

        int initialLikeCount = feedPage.getLikeCount();
        feedPage.likeFirstFeedBlock();

        assertThat(feedPage.getLikeCount()).isEqualTo(initialLikeCount + 1);
    }
}
