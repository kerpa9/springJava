package com.kevenreyes.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SeriesData(
                @JsonAlias("Title") String title,
                @JsonAlias("totalSeasons") int totalTemp,
                @JsonAlias("imdbRating") String evaluate,
                @JsonAlias("Genre") String genre,
                @JsonAlias("Poster") String poster,
                @JsonAlias("Actors") String actors,
                @JsonAlias("Plot") String sinopsis
                
                ) {

}
