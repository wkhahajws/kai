package com.example.demo.service;

import com.example.demo.model.Article;

import java.util.List;

/**
 * FileName:AriticleService
 * Author: kaishen
 * Date: 2020/9/7 11:47
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */

public interface AriticleService {
    public List<Article> getArticleList();
    public Article findArticleById(long id);
}
