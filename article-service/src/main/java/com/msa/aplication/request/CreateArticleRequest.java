package com.msa.aplication.request;

import com.msa.domain.commands.CreateArticleCommand;
import lombok.Data;

@Data
public class CreateArticleRequest {
    private Long writerId;
    private String title;
    private String content;

    public CreateArticleCommand toCommand() {
        return CreateArticleCommand.builder()
                .writerId(this.writerId)
                .content(this.content)
                .title(this.title)
                .build();
    }
}
