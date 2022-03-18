package com.msa.aplication;

import com.msa.aplication.request.CreateArticleRequest;
import com.msa.domain.commands.handler.ArticleCommandHandler;
import com.msa.domain.model.Article;
import com.msa.infrastructure.feign.client.UserClient;
import com.msa.infrastructure.feign.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArticleFacade {
    private final ArticleCommandHandler handler;
    private final UserClient client;
    public Article createArticle(CreateArticleRequest req) {
        // user 검증
        UserDto userDto = client.checkUserVerification(req.getWriterId());
        Article article = handler.createArticle(req.toCommand());
        return article;
    }
}
