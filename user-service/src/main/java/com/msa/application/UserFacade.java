package com.msa.application;

import com.msa.application.request.DeleteUserRequest;
import com.msa.application.request.SignUpRequest;
import com.msa.application.response.UserDto;
import com.msa.domain.commands.handler.UserCommandHandler;
import com.msa.domain.model.User;
import com.msa.domain.query.UserQueryProcessor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserFacade {
    private final UserCommandHandler handler;
    private final UserQueryProcessor processor;

    public User signUp(SignUpRequest request) {
        return handler.createUser(request.toCommand());
    }

    public void deleteUser(DeleteUserRequest request) {
        handler.deleteUser(request.toCommand());
    }

    public UserDto verifyUser(Long id) {
        User user = processor.findById(id);
        return UserDto.builder()
                .id(user.getId())
                .name(user.getUsername())
                .build();
    }
}
