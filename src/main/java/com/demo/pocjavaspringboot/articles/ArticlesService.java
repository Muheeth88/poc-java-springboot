package com.demo.pocjavaspringboot.articles;

import org.springframework.stereotype.Service;

import com.demo.pocjavaspringboot.articles.dtos.CreateArticleDto;
import com.demo.pocjavaspringboot.articles.dtos.UpdateArticelDto;
import com.demo.pocjavaspringboot.users.UsersRepository;
import com.demo.pocjavaspringboot.users.UsersService;

@Service
public class ArticlesService {

    private ArticlesRepository articlesRepository;
    private UsersRepository usersRepository;

    public ArticlesService(ArticlesRepository articlesRepository, UsersRepository usersRepository) {
        this.articlesRepository = articlesRepository;
        this.usersRepository =  usersRepository;
    }

    // Get All Articles
    public Iterable<ArticleEntity> getAllArticles() {
        return articlesRepository.findAll();
    }

    // Get Article by Slug
    public ArticleEntity getArticleBySlug(String slug) {
        var article = articlesRepository.findBySlug(slug);
        if(article == null) {
            throw new ArticleNotFoundException(slug);
        }
        return article;
    }

        static class ArticleNotFoundException extends IllegalArgumentException {
            public ArticleNotFoundException(String title) {
                super("Article Not found");
            }
            public ArticleNotFoundException(Long articleId) {
                super("Article Not found");
            }
        }

    // Create Article
    public ArticleEntity createArticle(CreateArticleDto req, Long authorId) {

        var author = usersRepository.findById(authorId)
            .orElseThrow(() -> new UsersService.UserNotFoundException(authorId));

        return articlesRepository.save(ArticleEntity.builder()
            .title(req.getTitle())
            .slug(req.getTitle().toLowerCase().replaceAll("\\s+", "_"))
            .subTitle(req.getSubTitle())
            .body(req.getBody())
            .author(author)
            .build()
        );
    }

    // Edit Article

    public ArticleEntity editArticle(Long articleId, UpdateArticelDto req) {
        var article = articlesRepository.findById(articleId).orElseThrow(() -> new ArticleNotFoundException(articleId));

        article.setTitle(req.getTitle());
        article.setSlug(req.getTitle().toLowerCase().replaceAll("\\s+", "_"));
        article.setSubTitle(req.getSubTitle());
        article.setBody(req.getBody());
       
        return articlesRepository.save(article);
    }
}
