package com.msa.domain.commands.handler;

import com.msa.domain.UserRepository;
import com.msa.domain.commands.CreateUserCommand;
import com.msa.domain.commands.DeleteUserCommand;
import com.msa.domain.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserCommandHandler {
    private UserRepository userRepository;


    public User createUser(CreateUserCommand command) {
        User user = User.builder()
                .email(command.getEmail())
                .username(command.getUserName())
                .password(command.getPassword())
                .build();
        return userRepository.save(user);
    }

    public void deleteUser(DeleteUserCommand command) {
        User user = userRepository.findByIdAndUsername(command.getId(), command.getUserName());
    }
}
