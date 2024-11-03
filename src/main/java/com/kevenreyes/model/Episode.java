package com.kevenreyes.model;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Episode {

    private int seasonNum;
    private String title;
    private int episodeNum;
    private double evaluate;
    private LocalDate releaseDate;

    public Episode(int number, EspisodeData d) {
        this.seasonNum = number;
        this.title = d.title();
        this.episodeNum = d.numberEpisode();

        try {

            this.evaluate = Double.valueOf(d.evaluation());

        } catch (NumberFormatException e) {

            this.evaluate = 0.0;
        }

        try {

            this.releaseDate = LocalDate.parse(d.releaseDate());

        } catch (DateTimeParseException e) {
            this.releaseDate = null;
        }

    }

    public LocalDate getRealeaseDate() {
        return releaseDate;
    }

    public int getSeason() {
        return seasonNum;
    }

    public int getEpisode() {
        return episodeNum;
    }

    @Override
    public String toString() {
        return "season" + seasonNum + ", title: " + title + "episode: " + episodeNum + "evaluate: "
                + evaluate + "realease date: " + releaseDate;

    }
}
