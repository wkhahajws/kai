package com.example.demo.model;


import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * FileName:Product
 * Author: kaishen
 * Date: 2020/9/20 23:28
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */
@Data
@AllArgsConstructor
public class Product implements Comparable<Product>{
    @Override
    public int compareTo(Product o) {
        return 0;
    }

    private String username;
    private Integer age;
}
