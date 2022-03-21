package com.msa.infrastructure.feign.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.msa.exception.response.ErrorResponse;
import feign.Response;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Component
@RequiredArgsConstructor
public class FeignResponseUtils {

    public static ErrorResponse getResponseBody(Response response, ObjectMapper objectMapper) {
        try (InputStream responseBodyStream = response.body().asInputStream()) {
            String bodyString = IOUtils.toString(responseBodyStream, StandardCharsets.UTF_8.name());
            return objectMapper.readValue(bodyString, ErrorResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
