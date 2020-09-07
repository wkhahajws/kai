package com.example.demo.repository;

import com.example.demo.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * FileName:ArticleRepository
 * Author: kaishen
 * Date: 2020/9/7 11:05
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */
public interface ArticleRepository extends JpaRepository<Article,Long>, JpaSpecificationExecutor<Article> {
    Article findById(long id);

}
