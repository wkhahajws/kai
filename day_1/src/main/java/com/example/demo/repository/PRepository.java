package com.example.demo.repository;

import com.example.demo.model.P;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * FileName:PRepository
 * Author: kaishen
 * Date: 2020/9/21 12:46
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */
@Component
public interface PRepository extends ElasticsearchRepository<P,Long> {
    P findById(long id);
    P findByName(String name);
    List<P> findByPriceBetween(double price1,double price2);
}
