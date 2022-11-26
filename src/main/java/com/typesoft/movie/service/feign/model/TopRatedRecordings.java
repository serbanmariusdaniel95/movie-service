package com.typesoft.movie.service.feign.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class TopRatedRecordings<T> {

    @JsonProperty("page")
    private Integer page;

    @JsonProperty("results")
    private List<T> results;
}
