package com.kai.homepage.repository;

import com.kai.homepage.entity.HomepageUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * FileName:HomepageUserRepository
 * Author: kaishen
 * Date: 2020/11/9 16:18
 * Description:
 */
public interface HomepageUserRepository extends JpaRepository<HomepageUser,Long> {

    HomepageUser findByName(String name);
}
