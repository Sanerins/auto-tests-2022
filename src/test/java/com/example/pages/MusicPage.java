package com.example.pages;

import org.openqa.selenium.Keys;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class MusicPage {
    private static final SelenideElement INPUT_FIND_MUSIC
            = $(byXpath("//*[contains(@data-l, 't,input')]/input"));
    private static final SelenideElement ARTIST_NAME
            = $(byXpath("//*[contains(@data-tsid, 'best_match_artist_name')]"));


    public MusicPage findArtist(String musicName) {
        INPUT_FIND_MUSIC.click();
        INPUT_FIND_MUSIC.sendKeys(musicName);
        INPUT_FIND_MUSIC.sendKeys(Keys.ENTER);
        return this;
    }

    public String getNameOfFirstTrack() {
        return ARTIST_NAME.getText();
    }
}
