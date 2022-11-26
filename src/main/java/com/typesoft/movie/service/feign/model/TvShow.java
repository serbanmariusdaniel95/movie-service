package com.typesoft.movie.service.feign.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TvShow {

    @JsonProperty("first_air_date")
    private String firstAirDate;

    @JsonProperty("name")
    private String name;

    @JsonProperty("vote_average")
    private Double voteAverage;
}
