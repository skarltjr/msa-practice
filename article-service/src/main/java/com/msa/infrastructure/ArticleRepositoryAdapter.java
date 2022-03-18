package com.msa.infrastructure;

import com.msa.domain.model.Article;
import com.msa.domain.model.ArticleRepository;
import com.msa.infrastructure.jpaRepository.JpaArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ArticleRepositoryAdapter implements ArticleRepository {
    private final JpaArticleRepository jpaArticleRepository;

    @Override
    public Article save(Article article) {
        return jpaArticleRepository.save(article);
    }
}
