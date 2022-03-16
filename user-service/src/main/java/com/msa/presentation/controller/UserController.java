package com.msa.presentation.controller;

import com.msa.application.UserFacade;
import com.msa.application.request.DeleteUserRequest;
import com.msa.application.request.SignUpRequest;
import com.msa.domain.model.User;
import com.msa.reponse.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users/")
public class UserController {
    private UserFacade userFacade;

    @PostMapping("signUp")
    private CommonResponse singUp(SignUpRequest request) {
        User user = userFacade.signUp(request);
        return new CommonResponse(user);
    }

    @DeleteMapping()
    private CommonResponse deleteUser(DeleteUserRequest request) {
        userFacade.deleteUser(request);
        return new CommonResponse(request.getUserId());
    }
}
