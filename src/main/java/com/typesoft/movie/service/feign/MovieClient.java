package com.typesoft.movie.service.feign;

import com.typesoft.movie.service.feign.model.Movie;
import com.typesoft.movie.service.feign.model.TopRatedRecordings;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "MovieClient", url = "${the-movie-database.url}")
public interface MovieClient extends TheMovieDatabaseClient<TopRatedRecordings<Movie>> {
}
