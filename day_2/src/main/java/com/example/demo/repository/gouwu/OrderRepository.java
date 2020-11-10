package com.example.demo.repository.gouwu;

import com.example.demo.entity.gouwu.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * FileName:OrderRepository
 * Author: kaishen
 * Date: 2020/11/3 20:15
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */
public interface OrderRepository extends JpaRepository<Order,Long> {
}
