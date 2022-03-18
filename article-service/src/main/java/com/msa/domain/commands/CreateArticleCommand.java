package com.msa.domain.commands;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CreateArticleCommand {
    private Long writerId;
    private String title;
    private String content;
}
