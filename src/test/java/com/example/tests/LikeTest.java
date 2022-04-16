package com.example.tests;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.example.pages.FeedPage;

import static org.assertj.core.api.Assertions.*;

public class LikeTest extends BaseTest {
    @Test
    public void setLike() throws IOException {
        FeedPage feedPage = authorize();
        feedPage.unlikeFirstFeedBlock();

        int initialLikeCount = feedPage.getLikeCount();
        feedPage.likeFirstFeedBlock();

        assertThat(feedPage.getLikeCount()).isEqualTo(initialLikeCount + 1);
    }
}
