package com.msa.application;

import com.msa.application.request.DeleteUserRequest;
import com.msa.application.request.SignUpRequest;
import com.msa.domain.commands.handler.UserCommandHandler;
import com.msa.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserFacade {
    private final UserCommandHandler handler;

    public User signUp(SignUpRequest request) {
        return handler.createUser(request.toCommand());
    }

    public void deleteUser(DeleteUserRequest request) {
        handler.deleteUser(request.toCommand());
    }
}
