package com.typesoft.movie.service.feign;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

public interface TheMovieDatabaseClient<T> {

    @GetMapping(value = "/{recording}/top_rated")
    T getTopRated(@PathVariable("recording") String recording,
                  @RequestParam("api_key") String apiKey,
                  @RequestParam("page") Integer page);
}
