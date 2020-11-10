package com.example.demo.controller.gouwu;

import com.example.demo.controller.BaseController;
import com.example.demo.entity.gouwu.Product;
import com.example.demo.repository.gouwu.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * FileName:ProductController
 * Author: kaishen
 * Date: 2020/11/3 20:18
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */
@Controller
@RequestMapping("product")
public class ProductController extends BaseController {

    @Autowired
    private ProductRepository productRepository;
    //根据id查询商品信息，并显示
    @RequestMapping("/{id}")
    public ModelAndView showProduct(@PathVariable("id")long id, HttpServletRequest request){
        Product product= productRepository.findById(id).get();
        ModelAndView mv = new ModelAndView("gouwu/showProduct");

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        mv.addObject("principals",principal);
        mv.addObject("product",product);
        return mv;
    }
}
