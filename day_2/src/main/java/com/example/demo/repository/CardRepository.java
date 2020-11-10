package com.example.demo.repository;

import com.example.demo.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * FileName:CardRepository
 * Author: kaishen
 * Date: 2020/10/26 19:04
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */
public interface CardRepository extends JpaRepository<Card,Long> {
}
