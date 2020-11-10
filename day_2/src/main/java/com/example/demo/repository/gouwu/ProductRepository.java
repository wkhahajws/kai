package com.example.demo.repository.gouwu;

import com.example.demo.entity.gouwu.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * FileName:ProductRepository
 * Author: kaishen
 * Date: 2020/11/3 20:14
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */
public interface ProductRepository extends JpaRepository<Product,Long> {
}
