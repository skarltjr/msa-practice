package com.msa.presentation.controller.internal;

import com.msa.application.UserFacade;
import com.msa.application.response.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/internal/users/")
public class InternalUserController {
    private final UserFacade userFacade;

    @PostMapping("{id}")
    private UserDto checkUserVerification(@PathVariable Long id) {
        // 여기라면 application - domain - infra를 걸쳐서 가져와야하는가
        return userFacade.verifyUser(id);
    }
}
