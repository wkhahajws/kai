package com.example.demo.mapper;

import com.example.demo.entity.U;
import org.apache.ibatis.annotations.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * FileName:UMapper
 * Author: kaishen
 * Date: 2020/10/26 21:35
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */
@Repository
@Mapper
public interface UMapper {

    @Select("select * from u where id = #{id}")
    U queryById(@Param("id")String id);

    @Select("select * from u")
    List<U> queryAll();

    @Insert("insert into u(name,age) values(#{name},#{age})")
    int add(U u);

    @Delete("delete from u where id = #{id}")
    int delById(String id);

    @Update("update u set name=#{name},age=#{age} where id=#{id}")
    int updateById(U u);
}
