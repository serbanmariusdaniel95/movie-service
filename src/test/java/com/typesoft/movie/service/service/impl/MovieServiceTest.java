package com.typesoft.movie.service.service.impl;

import com.typesoft.movie.service.feign.TheMovieDatabaseClient;
import com.typesoft.movie.service.feign.model.Movie;
import com.typesoft.movie.service.feign.model.TopRatedRecordings;
import com.typesoft.movie.service.service.MovieService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class MovieServiceTest {

    private MovieService movieService;

    @Mock
    private TheMovieDatabaseClient<TopRatedRecordings<Movie>> movieDatabaseClient;

    @BeforeEach
    void init() {
        movieService = new MovieService(movieDatabaseClient);
    }

    @Test
    void should_return_top_rated_movies_based_on_movieNumber_parameter() {
        TopRatedRecordings<Movie> topRatedMovies = new TopRatedRecordings<>();
        topRatedMovies.setResults(getMovieList());
        doReturn(topRatedMovies).when(movieDatabaseClient).getTopRated(any(), any(), any());
        assertEquals(5, movieService.getTopRatedRecordings(5).size());
    }

    private List<Movie> getMovieList() {
        List<Movie> movies = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            movies.add(new Movie());
        }

        return movies;
    }
}