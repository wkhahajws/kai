package com.example.demo.service.impl;

import com.example.demo.model.Article;
import com.example.demo.repository.ArticleRepository;
import com.example.demo.service.AriticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * FileName:AriticleServiceImpl
 * Author: kaishen
 * Date: 2020/9/7 11:49
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */
@Service
public class AriticleServiceImpl implements AriticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public List<Article> getArticleList() {
        return articleRepository.findAll();
    }

    @Override
    public Article findArticleById(long id) {
        return articleRepository.findById(id);
    }
}
