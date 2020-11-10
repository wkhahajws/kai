package com.example.demo.entity.gouwu;

import com.example.demo.entity.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 产品实体表
 */

@Entity
@Data
public class Product extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//由数据库控制,auto是程序统一控制
    private long id;

    @Column(nullable = false,unique = true)
    private String name;    //产品名称
    private Float price;    //产品价格

    private Double stockCount;      //库存数量

    private Long seckill_start_time;    //秒杀开始时间
    private Long seckill_end_time;       //秒杀结束时间

    private String category;        //分类

    private String brand;       //品牌
}
