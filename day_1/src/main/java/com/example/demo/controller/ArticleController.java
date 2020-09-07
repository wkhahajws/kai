package com.example.demo.controller;

import com.example.demo.model.Article;
import com.example.demo.repository.ArticleRepository;
import com.example.demo.service.AriticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * FileName:ArticleController
 * Author: kaishen
 * Date: 2020/9/7 11:52
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */
@Controller
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleRepository articleRepository;

    /**
     * 文章列表
     * @return
     */
    @RequestMapping("/list")
    public ModelAndView articleList(@RequestParam(value = "start",defaultValue = "0") Integer start,
                                    @RequestParam(value = "limt",defaultValue = "5") Integer limit){
        start = start<0 ?0:start;
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(0, limit, sort);
        Page<Article> page = articleRepository.findAll(pageable);
        ModelAndView mv = new ModelAndView("article/list");
        mv.addObject("page",page);
        return mv;
    }


    /**
     * 新增操作视图
     */

    @GetMapping("/add")
    public String addArticle(){
        return "article/add";
    }

    /**
     * 新增保存数据
     */
    @PostMapping("/add")
    public String saveArticle(Article article){
        articleRepository.save(article);
        return "redirect:/article/list";
    }



}
