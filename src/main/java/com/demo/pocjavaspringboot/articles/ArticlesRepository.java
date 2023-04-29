package com.demo.pocjavaspringboot.articles;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticlesRepository extends JpaRepository<ArticleEntity, Long> {

    // Optional<ArticleEntity> findBySlug(String slug);
    ArticleEntity findBySlug(String slug);
    
}