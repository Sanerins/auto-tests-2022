package com.example.pages;

import org.openqa.selenium.By;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.refresh;

public class FeedPage {
    public static String url = "https://ok.ru/feed";
    private static final SelenideElement feedNavBar = $(By.xpath("//div[contains(@data-l, 't,filter')]"));
    private static final SelenideElement friendsLink = $(By.xpath("//*[contains(@data-l, 't,friends')]"));
    private static final SelenideElement messagesLink = $(By.xpath("//*[contains(@data-l, 't,messages')]"));
    private static final SelenideElement guestsLink = $(By.xpath("//*[contains(@data-l, 't,guests')]"));
    private static final SelenideElement notificationsLink = $(By.xpath("//*[contains(@data-l, 't,notifications')]"));
    private static final SelenideElement miniUserCard =
            $(By.xpath("//div[contains(@class, 'ucard-mini toolbar_ucard js-toolbar-menu')]"));
    private static final SelenideElement logoutLink = $(By.xpath("//a[@data-l='t,logout']"));
    private static final SelenideElement logoutConfirmation =
            $(By.id("hook_FormButton_logoff.confirm_not_decorate"));
    private static final SelenideElement likeBtn
            = $(By.xpath("//*[contains(@class, 'feed-w')][1]//*[@data-like-icon]/parent::*"));
    private static final SelenideElement likeCount
            = $(By.xpath("//*[contains(@class, 'feed-w')][1]//*[@data-like-icon]//*[contains(@class, 'widget_count')]"));
    private static final SelenideElement openPostingMenuBtn
            = $(By.xpath("//*[contains(@data-l, 't,feed.posting.ui.input')]"));
    private static final SelenideElement inputPostTextForm
            = $(By.xpath("//*[contains(@class, 'posting_itx ')]"));
    private static final SelenideElement submitPostBtn
            = $(By.xpath("//*[contains(@data-l, 't,button.submit')]"));
    private static final SelenideElement bestBackground
            = $(By.xpath("//*[contains(@class, 'posting_cp_i js-color-picker-i js-color-picker-i-103')]"));
    private static final SelenideElement firstPostFromFeed
            = $(By.xpath("//*[contains(@class, 'feed-list')]//*[contains(@class, 'media-text_cnt_tx')]"));;

    public FeedPage() {
        feedNavBar.shouldBe(Condition.visible);
    }

    public FeedPage openPage() {
        open(url);
        return new FeedPage();
    }

    public LoginPage logout() {
        miniUserCard.click();
        logoutLink.click();
        logoutConfirmation.click();
        return LoginPage.openPage();
    }

    public static String getURL() {
        return url;
    }

    public MessagesPage openMessages() {
        messagesLink.click();
        return new MessagesPage();
    }

    public FriendsPage openFriends() {
        friendsLink.click();
        return new FriendsPage();
    }

    public GuestsPage openGuests() {
        guestsLink.click();
        return new GuestsPage();
    }

    public NotificationsPage openNotifications() {
        notificationsLink.click();
        return new NotificationsPage();
    }


    public static boolean isOpen() {
        return feedNavBar.isDisplayed();
    }

    public int getLikeCount() {
        return Integer.parseInt(likeCount.getText());
    }

    public void unlikeFirstFeedBlock() {
        if (containsClass(likeBtn, "__active")) {
            likeBtn.click();
        }
    }

    public void likeFirstFeedBlock() {
        likeBtn.click();
        likeBtn.shouldHave(Condition.attribute("class", "widget  __active __wide-count"));
    }

    private static boolean containsClass(SelenideElement element, String className) {
        String attributes = element.getAttribute("class");
        if (attributes != null) {
            return attributes.contains(className);
        }
        return false;
    }

    public FeedPage publishPost(String quote) {
        openPostingMenuBtn.click();
        inputPostTextForm.shouldBe(Condition.visible);
        inputPostTextForm.clear();
        inputPostTextForm.setValue(quote);
        bestBackground.click();
        submitPostBtn.click();
        return this;
    }

    public boolean checkWhetherPostWithTextDisplayed(String text) {
        return firstPostFromFeed.innerText().equals(text);
    }
}
