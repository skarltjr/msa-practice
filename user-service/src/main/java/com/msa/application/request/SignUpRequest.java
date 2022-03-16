package com.msa.application.request;

import com.msa.domain.commands.CreateUserCommand;
import lombok.Data;

@Data
public class SignUpRequest {
    private String userName;
    private String email;
    private String password;

    public CreateUserCommand toCommand() {
        return CreateUserCommand.builder()
                .userName(this.userName)
                .email(this.email)
                .password(this.password)
                .build();
    }
}
