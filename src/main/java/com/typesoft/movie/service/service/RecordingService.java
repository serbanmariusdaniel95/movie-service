package com.typesoft.movie.service.service;

import com.typesoft.movie.service.model.Recording;

import java.util.List;

public interface RecordingService {

    List<Recording> getTopRatedRecordings(Integer number);
}
