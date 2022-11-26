package com.typesoft.movie.service.service.impl;

import com.typesoft.movie.service.feign.TheMovieDatabaseClient;
import com.typesoft.movie.service.feign.model.TopRatedRecordings;
import com.typesoft.movie.service.feign.model.TvShow;
import com.typesoft.movie.service.model.Recording;
import com.typesoft.movie.service.service.RecordingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TvShowService extends AbstractRecordingService<TvShow> implements RecordingService {

    private final TheMovieDatabaseClient<TopRatedRecordings<TvShow>> movieDatabaseClient;

    @Value("${the-movie-database.key}")
    private String apiKey;

    @Override
    public List<Recording> getTopRatedRecordings(Integer tvShowsNumber) {
        return getTopRated("tv", tvShowsNumber, apiKey, this::getTopRatedTvShows);
    }

    @Override
    public Recording createRecordingFrom(Integer rank, TvShow tvShow) {
        return new Recording(rank, tvShow);
    }

    private List<TvShow> getTopRatedTvShows(String recording, String apiKey, Integer page) {
        return movieDatabaseClient.getTopRated(recording, apiKey, page).getResults();
    }
}
