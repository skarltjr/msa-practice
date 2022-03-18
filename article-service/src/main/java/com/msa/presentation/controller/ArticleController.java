package com.msa.presentation.controller;

import com.msa.aplication.ArticleFacade;
import com.msa.aplication.request.CreateArticleRequest;
import com.msa.domain.model.Article;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/articles/")
public class ArticleController {
    private final ArticleFacade articleFacade;

    @PostMapping
    private ResponseEntity createArticle(@RequestBody CreateArticleRequest req) {
        Article article = articleFacade.createArticle(req);
        return ResponseEntity.ok().body(article);
    }
}
