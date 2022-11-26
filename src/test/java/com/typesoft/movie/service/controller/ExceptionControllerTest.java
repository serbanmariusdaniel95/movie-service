package com.typesoft.movie.service.controller;

import feign.FeignException;
import feign.Request;
import feign.RequestTemplate;
import feign.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class ExceptionControllerTest {

    private final ExceptionController exceptionController = new ExceptionController();

    @Test
    public void should_return_500_error_when_feign_exception_is_thrown() {
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR,
                exceptionController.handleException(FeignException.errorStatus("", getResponse())).getStatusCode());
    }

    private Response getResponse() {
        return Response.builder()
                .request(Request.create(Request.HttpMethod.GET, "", Collections.emptyMap(), Request.Body.create(""), new RequestTemplate()))
                .build();
    }
}