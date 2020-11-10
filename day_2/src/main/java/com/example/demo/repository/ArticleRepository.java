package com.example.demo.repository;

import com.example.demo.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * FileName:ArticleRepository
 * Author: kaishen
 * Date: 2020/10/26 10:05
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */
public interface ArticleRepository extends JpaRepository<Article,Long> {
}
