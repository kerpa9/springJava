package com.kevenreyes.model;

import java.util.OptionalDouble;


public class Serie {

    private String title;
    private int totalTemp;
    private Double evaluate;
    private String genre;
    private String poster;
    private Category category;
    private String actors;
    private String sinopsis;

    public Serie(SeriesData seriesData) {
        this.title = seriesData.title();
        this.totalTemp = seriesData.totalTemp();
        this.evaluate = OptionalDouble.of(Double.valueOf(seriesData.evaluate())).orElse(0);
        this.poster = seriesData.poster();
        this.genre = seriesData.genre();
    }

}
