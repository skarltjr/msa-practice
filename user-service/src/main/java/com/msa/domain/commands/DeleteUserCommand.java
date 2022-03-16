package com.msa.domain.commands;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class DeleteUserCommand {
    private Long id;
    private String userName;
}
