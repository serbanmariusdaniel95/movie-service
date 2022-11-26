package com.typesoft.movie.service.model;

import com.typesoft.movie.service.feign.model.Movie;
import com.typesoft.movie.service.feign.model.TvShow;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Recording {

    private Integer rank;
    private String title;
    private Double rating;
    private String releaseDate;

    public Recording(Integer rank, Movie movie) {
        this(rank, movie.getTitle(), movie.getVoteAverage(), movie.getReleaseDate());
    }

    public Recording(Integer rank, TvShow tvShow) {
        this(rank, tvShow.getName(), tvShow.getVoteAverage(), tvShow.getFirstAirDate());
    }
}
