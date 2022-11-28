package com.typesoft.movie.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.typesoft.movie.service.config.WireMockConfig;
import com.typesoft.movie.service.model.Recording;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.typesoft.movie.service.constant.Constants.MOVIE_TOP;
import static com.typesoft.movie.service.constant.Constants.TV_SHOW_TOP;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = WireMockConfig.class)
class MovieServiceIT {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WireMockServer wireMockServer;

    @Test
    void should_return_top_rated_movies() throws Exception {
        setupGet("/movie/top_rated?api_key=test&page=1", MOVIE_TOP);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/movie/top/1")).andReturn();
        assertEquals(200, mvcResult.getResponse().getStatus());
        List<Recording> recordings = OBJECT_MAPPER.readValue(mvcResult.getResponse().getContentAsString(), new TypeReference<>() {
        });
        assertEquals(1, recordings.size());
    }

    @Test
    void should_return_top_rated_tv_shows() throws Exception {
        setupGet("/tv/top_rated?api_key=test&page=1", TV_SHOW_TOP);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/tv-show/top/1")).andReturn();
        assertEquals(200, mvcResult.getResponse().getStatus());
        List<Recording> recordings = OBJECT_MAPPER.readValue(mvcResult.getResponse().getContentAsString(), new TypeReference<>() {
        });
        assertEquals(1, recordings.size());
    }

    private void setupGet(String url, String response) {
        wireMockServer.stubFor(WireMock.get(urlEqualTo(url))
                .willReturn(aResponse().withStatus(200)
                        .withHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                        .withBody(response)));
    }
}
