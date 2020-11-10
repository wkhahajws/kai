package com.example.demo.service;

import com.example.demo.entity.U;
import com.example.demo.mapper.UMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * FileName:UService
 * Author: kaishen
 * Date: 2020/10/28 23:45
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */
@Service
@CacheConfig(cacheNames = "us")
public class UService {
    @Autowired
    UMapper uMapper;

    //@Cacheable将查询结果缓存到redis中，（key="#p0"）指定传入的第一个参数作为redis的key。
    @Cacheable(key ="#p0")
    public U selectU(String id){
        System.out.println("select");
        return uMapper.queryById(id);
    }

    //@CachePut，指定key，将更新的结果同步到redis中
    @CachePut(key = "#p0")
    public void updataById(U u){
        System.out.println("update");
        uMapper.updateById(u);
    }

    //@CacheEvict，指定key，删除缓存数据，allEntries=true,方法调用后将立即清除缓存
    //如果指定为 true，则方法调用后将立即清空所有缓存
    @CacheEvict(key ="#p0",allEntries=true)
    public void deleteById(String id){
        System.out.println("delete");
        uMapper.delById(id);
    }

//    @Cacheable(key = "#p0")
    public List<U> queryAll(){
        List<U> uList = uMapper.queryAll();
        return uList;
    }
}
