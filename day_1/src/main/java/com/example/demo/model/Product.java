package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

/**
 * FileName:Product
 * Author: kaishen
 * Date: 2020/10/28 15:49
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */

/**
 * 索引名称可以理解为数据库名，必须为小写。
 */
@Document(indexName = "ec",type = "product",replicas = 0,shards = 5)
@Data
@AllArgsConstructor
public class Product implements Serializable {
    @Id
    private Long id;
    @Field(type = FieldType.Text,analyzer = "ik_max_word")  //使用IK分词器
    private String name;
    @Field(type = FieldType.Keyword)//存储数据时，不会对category进行分词
    private String category;    //分类
    @Field(type = FieldType.Double)
    private Double price;
    @Field(index = false,type = FieldType.Keyword)//表示不建立索引
    private String images;
    private String body;

}
