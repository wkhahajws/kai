package com.example.demo.repository.member;

import com.example.demo.entity.member.M_User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

/**
 * FileName:M_UserRepository
 * Author: kaishen
 * Date: 2020/11/2 12:44
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */
public interface M_UserRepository extends JpaRepository<M_User,Long> {
    M_User findByName(String name);
    M_User findByEmail(String email);
    M_User findByMobile(String mobile);

    Page<M_User> findByIdIn(List<Integer> ids, Pageable pageable);
    List<M_User> findByIdIn(List<Integer> ids);

    @Modifying(clearAutomatically=true)
    @Transactional
    @Query("update M_User set outDate=:outDate, validataCode=:validataCode where email=:email")
    int setOutDateAndValidataCode(@Param("outDate") String outDate, @Param("validataCode") String validataCode, @Param("email") String email);

    @Modifying(clearAutomatically=true)
    @Transactional
    @Query("update M_User set active=:active where email=:email")
    int setActive(@Param("active") String active, @Param("email") String email);
}
