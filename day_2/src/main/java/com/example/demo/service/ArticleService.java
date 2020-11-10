package com.example.demo.service;

import com.example.demo.entity.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * FileName:ArticleService
 * Author: kaishen
 * Date: 2020/10/26 10:07
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */
public interface ArticleService {
    public Page<Article> getArticleList(Pageable pageable);
    public Optional<Article> findArticleById(long id);
    public void saveArticle(Article article);
    public void deleteArticle(long id);
}
