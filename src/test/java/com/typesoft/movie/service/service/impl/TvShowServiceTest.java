package com.typesoft.movie.service.service.impl;

import com.typesoft.movie.service.feign.TheMovieDatabaseClient;
import com.typesoft.movie.service.feign.model.TopRatedRecordings;
import com.typesoft.movie.service.feign.model.TvShow;
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
class TvShowServiceTest {

    private TvShowService tvShowService;

    @Mock
    private TheMovieDatabaseClient<TopRatedRecordings<TvShow>> movieDatabaseClient;

    @BeforeEach
    void init() {
        tvShowService = new TvShowService(movieDatabaseClient);
    }

    @Test
    void should_return_top_rated_tv_shows_based_on_tvShowNumber_parameter() {
        TopRatedRecordings<TvShow> topRatedTvShows = new TopRatedRecordings<>();
        topRatedTvShows.setResults(getTvShowList());
        doReturn(topRatedTvShows).when(movieDatabaseClient).getTopRated(any(), any(), any());
        assertEquals(30, tvShowService.getTopRatedRecordings(30).size());
    }

    private List<TvShow> getTvShowList() {
        List<TvShow> tvShows = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            tvShows.add(new TvShow());
        }

        return tvShows;
    }
}