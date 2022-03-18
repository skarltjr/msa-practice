package com.msa.infrastructure.feign.client;

import com.msa.infrastructure.feign.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@FeignClient(name = "user",url = "http://localhost:8080/internal/users/")
public interface UserClient {
    @PostMapping("{id}")
    UserDto checkUserVerification(@PathVariable Long id);
}
