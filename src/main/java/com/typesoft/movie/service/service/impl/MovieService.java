package com.typesoft.movie.service.service.impl;

import com.typesoft.movie.service.feign.TheMovieDatabaseClient;
import com.typesoft.movie.service.feign.model.Movie;
import com.typesoft.movie.service.feign.model.TopRatedRecordings;
import com.typesoft.movie.service.model.Recording;
import com.typesoft.movie.service.service.RecordingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService extends AbstractRecordingService<Movie> implements RecordingService {

    private final TheMovieDatabaseClient<TopRatedRecordings<Movie>> movieDatabaseClient;

    @Value("${the-movie-database.key}")
    private String apiKey;

    @Override
    public List<Recording> getTopRatedRecordings(Integer moviesNumber) {
        return getTopRated("movie", moviesNumber, apiKey, this::getTopRatedMovies);
    }

    @Override
    public Recording createRecordingFrom(Integer rank, Movie movie) {
        return new Recording(rank, movie);
    }

    private List<Movie> getTopRatedMovies(String recording, String apiKey, Integer page) {
        return movieDatabaseClient.getTopRated(recording, apiKey, page).getResults();
    }
}
