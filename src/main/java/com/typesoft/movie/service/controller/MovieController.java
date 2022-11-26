package com.typesoft.movie.service.controller;

import com.typesoft.movie.service.model.Recording;
import com.typesoft.movie.service.service.RecordingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movie")
public class MovieController {

    private final RecordingService movieService;

    @GetMapping("/top/{number}")
    public ResponseEntity<List<Recording>> getTopRatedMovies(@PathVariable("number") Integer number) {
        return ResponseEntity.ok(movieService.getTopRatedRecordings(number));
    }
}
