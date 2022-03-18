package com.msa.domain.commands.handler;

import com.msa.domain.commands.CreateArticleCommand;
import com.msa.domain.model.Article;
import com.msa.domain.model.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ArticleCommandHandler {
    private final ArticleRepository articleRepository;

    public Article createArticle(CreateArticleCommand command) {
        Article article = Article.builder()
                .writerId(command.getWriterId())
                .content(command.getContent())
                .title(command.getTitle())
                .build();
        return articleRepository.save(article);
    }
}
