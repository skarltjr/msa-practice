package com.msa.infrastructure.kafka.message;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ArticleCreateMessage {
    private Long articleId;
    private Long writerId;

    public ArticleCreateMessage(Long articleId, Long writerId) {
        this.articleId = articleId;
        this.writerId = writerId;
    }
}
