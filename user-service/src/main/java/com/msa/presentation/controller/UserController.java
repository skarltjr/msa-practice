package com.msa.presentation.controller;

import com.msa.application.UserFacade;
import com.msa.application.request.DeleteUserRequest;
import com.msa.application.request.SignUpRequest;
import com.msa.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users/")
public class UserController {
    private final UserFacade userFacade;

    @PostMapping("signUp")
    private ResponseEntity singUp(@RequestBody SignUpRequest request) {
        User user = userFacade.signUp(request);
        return ResponseEntity.ok().body(user);
    }

    @DeleteMapping()
    private ResponseEntity deleteUser(DeleteUserRequest request) {
        userFacade.deleteUser(request);
        return ResponseEntity.ok().body(request.getUserId());
    }
}
