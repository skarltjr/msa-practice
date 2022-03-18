package com.msa.infrastructure.jpaRepository;

import com.msa.domain.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaArticleRepository extends JpaRepository<Article,Long> {
}
