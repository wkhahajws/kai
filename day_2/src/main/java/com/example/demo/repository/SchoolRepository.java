package com.example.demo.repository;

import com.example.demo.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * FileName:SchoolRepository
 * Author: kaishen
 * Date: 2020/10/26 19:47
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */
public interface SchoolRepository extends JpaRepository<School,Long> {
}
