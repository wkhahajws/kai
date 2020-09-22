package com.example.demo.controller;

import com.example.demo.model.P;
import com.example.demo.repository.PRepository;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * FileName:SearchController
 * Author: kaishen
 * Date: 2020/9/22 11:17
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */
@Controller
public class SearchController {
    @Autowired
    private PRepository pRepository;

    @GetMapping("/search")
    public ModelAndView searchByPageAndSort(Integer start,String key){
        if(start == null){
            start = 0;
        }

        int size = 2;
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        nativeSearchQueryBuilder.withQuery(QueryBuilders.multiMatchQuery(key,"name","body"));
        nativeSearchQueryBuilder.withPageable(PageRequest.of(start,size));
        Page<P> search = pRepository.search(nativeSearchQueryBuilder.build());
        for (P p:search
             ) {
            System.out.println(p);
        }

        ModelAndView modelAndView = new ModelAndView("search");
        modelAndView.addObject("page",search);
        modelAndView.addObject("keys",key);
        return modelAndView;
    }

}
