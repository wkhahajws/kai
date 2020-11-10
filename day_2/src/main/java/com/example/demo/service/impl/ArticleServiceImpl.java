package com.example.demo.service.impl;

import com.example.demo.entity.Article;
import com.example.demo.repository.ArticleRepository;
import com.example.demo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * FileName:ArticleServiceImpl
 * Author: kaishen
 * Date: 2020/10/26 10:08
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public Page<Article> getArticleList(Pageable pageable) {
        Page<Article> page = articleRepository.findAll(pageable);
        return page;
    }

    @Override
    public Optional<Article> findArticleById(long id) {
        Optional<Article> article = articleRepository.findById(id);
        return article;
    }

    @Override
    public void saveArticle(Article article) {
        articleRepository.save(article);
    }

    @Override
    public void deleteArticle(long id) {
        articleRepository.deleteById(id);
    }
}
