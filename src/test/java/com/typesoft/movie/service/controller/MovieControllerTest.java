package com.typesoft.movie.service.controller;

import com.typesoft.movie.service.feign.model.Movie;
import com.typesoft.movie.service.service.RecordingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class MovieControllerTest {

    private MovieController movieController;

    @Mock
    private RecordingService<Movie> recordingService;

    @BeforeEach
    void init() {
        movieController = new MovieController(recordingService);
    }

    @Test
    void should_call_get_top_rated_method() {
        movieController.getTopRatedMovies(1);
        verify(recordingService).getTopRatedRecordings(anyInt());
    }
}