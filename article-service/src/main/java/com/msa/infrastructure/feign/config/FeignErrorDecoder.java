package com.msa.infrastructure.feign.config;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.msa.exception.exception.InternalServerErrorException;
import com.msa.exception.response.ErrorResponse;
import feign.Response;
import feign.codec.ErrorDecoder;


public class FeignErrorDecoder implements ErrorDecoder {
    private ObjectMapper objectMapper;

    public FeignErrorDecoder(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    /**
     *
     * article에서 user 검증
     * 없는 유저 에러 발생
     * feign을 통해 article이 해당 에러 전달받는다.
     * */
    @Override
    public Exception decode(String methodKey, Response response) {
        ErrorResponse errorResponse = null;
        if (response.body() != null) {
            errorResponse = FeignResponseUtils.getResponseBody(response, objectMapper);
        }
        throw new InternalServerErrorException(response.status(), errorResponse.getMessage());
    }
}
