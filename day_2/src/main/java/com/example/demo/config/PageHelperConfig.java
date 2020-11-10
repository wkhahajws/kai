package com.example.demo.config;

import com.github.pagehelper.PageHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * FileName:PageHelperConfig
 * Author: kaishen
 * Date: 2020/10/26 22:11
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */
@Configuration
public class PageHelperConfig {
    @Bean
    public PageHelper pageHelper(){
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        //offsetAsPageNum设置为true时，会将RowBounds第一个参数offset当成pageNum(页码)使用
        properties.setProperty("offsetAsPageNum","true");
        //rowBoundsWithCount设置为true时，使用RowBounds分页进行count查询
        properties.setProperty("rowBoundsWithCount","true");
        //启用合理化时，如果pageNum<1,查询第一页，如果pageNum>pages,会查询最后一页
        properties.setProperty("reasonable","true");
        pageHelper.setProperties(properties);
        return pageHelper;
    }
}
