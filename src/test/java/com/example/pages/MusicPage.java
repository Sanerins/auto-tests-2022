package com.example.pages;

import org.openqa.selenium.Keys;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class MusicPage implements Page {
    private static final SelenideElement INPUT_FIND_MUSIC
            = $(byXpath("//*[contains(@data-l, 't,input')]/input"));
    private static final SelenideElement ARTIST_NAME
            = $(byXpath("//*[contains(@data-tsid, 'best_match_artist_name')]"));
    private static final String URL = "https://ok.ru/music";

    public MusicPage findArtist(String musicName) {
        INPUT_FIND_MUSIC.click();
        INPUT_FIND_MUSIC.sendKeys(musicName);
        INPUT_FIND_MUSIC.sendKeys(Keys.ENTER);
        return this;
    }

    public String getNameOfFirstTrack() {
        return ARTIST_NAME.getText();
    }

    @Override
    public void await() {
        INPUT_FIND_MUSIC.shouldBe(visible);
    }

    @Override
    public String getURL() {
        return URL;
    }
}
