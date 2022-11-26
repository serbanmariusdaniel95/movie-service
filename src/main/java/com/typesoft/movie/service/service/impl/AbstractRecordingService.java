package com.typesoft.movie.service.service.impl;

import com.typesoft.movie.service.model.Recording;
import org.apache.commons.lang3.function.TriFunction;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractRecordingService<U> {

    public List<Recording> getTopRated(String recording, Integer number, String apiKey, TriFunction<String, String, Integer, List<U>> function) {
        Integer pagesNumber = getPagesNumberFrom(number);
        Integer page = 1;
        List<U> movieDatabaseTopRatedList = new ArrayList<>();
        while (page <= pagesNumber) {
            movieDatabaseTopRatedList.addAll(function.apply(recording, apiKey, page));
            page++;
        }

        return computeRecordingsFrom(number, movieDatabaseTopRatedList);
    }

    public Integer getPagesNumberFrom(Integer recordingsNumber) {
        if (recordingsNumber < 20) {
            return 1;
        }

        return recordingsNumber / 20 + 1;
    }

    public abstract Recording createRecordingFrom(Integer rank, U movieDatabaseTopRatedElement);

    private List<Recording> computeRecordingsFrom(Integer topRatedNumber, List<U> movieDatabaseTopRatedList) {
        List<Recording> recordings = new ArrayList<>();
        for (int i = 0; i < topRatedNumber; i++) {
            recordings.add(createRecordingFrom(i + 1, movieDatabaseTopRatedList.get(i)));
        }

        return recordings;
    }
}
