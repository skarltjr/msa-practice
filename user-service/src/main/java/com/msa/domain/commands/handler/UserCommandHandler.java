package com.msa.domain.commands.handler;

import com.msa.domain.UserRepository;
import com.msa.domain.commands.CreateUserCommand;
import com.msa.domain.commands.DeleteUserCommand;
import com.msa.domain.model.User;
import com.msa.domain.model.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserCommandHandler {
    private final UserRepository userRepository;


    public User createUser(CreateUserCommand command) {
        User user = User.builder()
                .email(command.getEmail())
                .username(command.getUserName())
                .password(command.getPassword())
                .role(UserRole.ROLE_USER)
                .build();
        return userRepository.save(user);
    }

    public void deleteUser(DeleteUserCommand command) {
        User user = userRepository.findByIdAndUsername(command.getId(), command.getUserName());
    }
}
