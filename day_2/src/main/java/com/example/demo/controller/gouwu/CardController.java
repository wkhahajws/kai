package com.example.demo.controller.gouwu;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.gouwu.Cart;
import com.example.demo.repository.gouwu.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * FileName:CardController
 * Author: kaishen
 * Date: 2020/11/3 20:34
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */
@Controller
@RequestMapping("cart")
public class CardController {
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping(value = "",method = RequestMethod.POST)
    public String saveCard(Cart cart){
        cartRepository.save(cart);

        Map<String,Object> hasmap = new HashMap<String,Object>();
        hasmap.put("product_id",cart.getProduct_id());
        hasmap.put("product_name",cart.getProduct_name());
        hasmap.put("user_id",cart.getUser_id());
        hasmap.put("product_num",cart.getProduct_num());
        hasmap.put("cart_id",cart.getId());

        JSONObject itemJSONObj = JSONObject.parseObject(JSON.toJSONString(hasmap));
        System.out.println(itemJSONObj);
        String valueStr = JSONObject.toJSONString(itemJSONObj);
        long timestamp = System.currentTimeMillis()/1000;
        String sname=cart.getUser_id().toString();
        redisTemplate.boundZSetOps(sname).add(valueStr,timestamp);
        System.out.println(redisTemplate.opsForZSet().range(sname,0,-1));
        System.out.println(redisTemplate.opsForZSet().size(sname));


        return "redirect:/cart/?user_id=" + cart.getUser_id();
    }

    @GetMapping("")
    @PreAuthorize("principal.id.equals(#user_id)")
    public ModelAndView cartlist(Long user_id, Principal principal) {
        List<Cart> cartList = cartRepository.findCartByIdNative(user_id);
        ModelAndView mav = new ModelAndView("gouwu/cartList");
        mav.addObject("cartList", cartList);
        return mav;
    }
}
