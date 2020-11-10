package com.example.demo.repository.gouwu;

import com.example.demo.entity.gouwu.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * FileName:CartRepository
 * Author: kaishen
 * Date: 2020/11/3 20:15
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */
public interface CartRepository extends JpaRepository<Cart,Long> {

    @Query(value = "select * from cart c where c.user_id=:user_id",nativeQuery = true)
    List<Cart>  findCartByIdNative(long user_id);
}
