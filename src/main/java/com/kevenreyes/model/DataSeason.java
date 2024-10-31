package com.kevenreyes.model;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown=true)
public record DataSeason(
        @JsonAlias("Season") Integer numberSeason,
        @JsonAlias("Episodes") List<EspisodeData> episodes) {

}
