package com.example.demo.controller;

import com.example.demo.entity.Article;
import com.example.demo.repository.ArticleRepository;
import com.example.demo.result.ExceptionMsg;
import com.example.demo.result.Response;
import com.example.demo.result.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * FileName:ArticleController
 * Author: kaishen
 * Date: 2020/10/26 10:05
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */
@RestController
@RequestMapping("article")
public class ArticleController {

    protected Response result(ExceptionMsg msg){
        return new Response(msg);
    }

    protected Response result(){
        return new Response();
    }

    @Autowired
    private ArticleRepository articleRepository;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ResponseData listArticle(){
        ArrayList<Article> list = new ArrayList<>(articleRepository.findAll());
        return new ResponseData(ExceptionMsg.SUCCESS,list);
    }

    //增
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public ResponseData addArticle(Article article){
        articleRepository.save(article);
        return new ResponseData(ExceptionMsg.SUCCESS,article);
    }

    //删
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public ResponseData saveArticle(@PathVariable("id") long id){
        articleRepository.deleteById(id);
        return new ResponseData(ExceptionMsg.SUCCESS,"");
    }

    //改
    @RequestMapping(value = "/",method = RequestMethod.PUT)
    public ResponseData viewArticle(Article article){
        articleRepository.save(article);
        return new ResponseData(ExceptionMsg.SUCCESS,article);
    }

    //查
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseData editArticle(@PathVariable("id")long id){
        Article article = articleRepository.findById(id).get();
        if(article != null){
            return new ResponseData(ExceptionMsg.SUCCESS,article);
        }
        return new ResponseData(ExceptionMsg.FAILED,article);
    }


}
