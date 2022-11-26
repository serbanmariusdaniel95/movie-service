package com.typesoft.movie.service.feign;

import com.typesoft.movie.service.feign.model.TopRatedRecordings;
import com.typesoft.movie.service.feign.model.TvShow;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "TvShowClient", url = "${the-movie-database.url}")
public interface TvShowClient extends TheMovieDatabaseClient<TopRatedRecordings<TvShow>> {
}
