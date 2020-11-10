package com.example.demo.entity.gouwu;

import com.example.demo.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * 购物车表
 */
@Entity
@Data
public class Cart extends BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long Product_id;

    private String product_name;    //产品名称

    private Long product_num;   //产品数量

    private Long user_id;       //用户id

    private Float product_price;    //商品当前价格


}
