package com.msa.application.request;

import com.msa.domain.commands.DeleteUserCommand;
import lombok.Data;

@Data
public class DeleteUserRequest {
    private Long userId;
    private String userName;

    public DeleteUserCommand toCommand() {
        return DeleteUserCommand.builder()
                .id(userId)
                .userName(userName)
                .build();
    }
}
