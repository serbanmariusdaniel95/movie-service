package com.typesoft.movie.service.controller;

import com.typesoft.movie.service.service.RecordingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class TvShowControllerTest {

    private TvShowController tvShowController;

    @Mock
    private RecordingService recordingService;

    @BeforeEach
    void init() {
        tvShowController = new TvShowController(recordingService);
    }

    @Test
    void should_call_get_top_rated_method() {
        tvShowController.getTopRatedTvShows(1);
        verify(recordingService).getTopRatedRecordings(anyInt());
    }
}