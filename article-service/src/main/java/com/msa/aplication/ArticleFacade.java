package com.msa.aplication;

import com.msa.aplication.request.CreateArticleRequest;
import com.msa.domain.commands.handler.ArticleCommandHandler;
import com.msa.domain.model.Article;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArticleFacade {
    private final ArticleCommandHandler handler;
    public Article createArticle(CreateArticleRequest req) {
        // user 검증
        Article article = handler.createArticle(req.toCommand());
        return article;
    }
}
