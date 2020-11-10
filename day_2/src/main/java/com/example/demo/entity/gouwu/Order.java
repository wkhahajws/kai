package com.example.demo.entity.gouwu;

import com.example.demo.entity.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * FileName:Order
 * Author: kaishen
 * Date: 2020/11/3 17:15
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */
@Entity
@Data
@Table(name = "orders")
public class Order extends BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long product_id;       //产品id

    private Long user_id;           //用户id

    private Float amount;       //订单金额

    private boolean status;     //订单状态
}
