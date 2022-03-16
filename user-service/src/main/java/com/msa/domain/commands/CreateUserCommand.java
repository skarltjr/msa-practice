package com.msa.domain.commands;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CreateUserCommand {
    private String userName;
    private String password;
    private String email;
}
