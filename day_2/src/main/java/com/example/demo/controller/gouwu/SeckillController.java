package com.example.demo.controller.gouwu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * FileName:SeckillController
 * Author: kaishen
 * Date: 2020/11/3 21:52
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */
@RestController
@RequestMapping("seckill")
public class SeckillController {
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * @Desciption: 创建秒杀库存
     * @Param: a     * @return: a
     * @Author: longzhonghua
     * @Date: 2019/4/14
     */
    @GetMapping("/createSeckillStockCount")
    public void seckillStockCount() {

        //有10个库存
        Integer count = 10;
        //添加到redis list中
        for (Integer i = 0; i < count; i++) {
            redisTemplate.opsForList().leftPush("slist", ""+1);
        }
        System.out.println(redisTemplate.opsForList().range("slist", 0, -1));
    }

    @GetMapping("/seckill")
    public void seckill() {
        //判断计数器
        if ("1".equals(redisTemplate.opsForList().leftPop("slist"))) {
            long user_id = 1903;
            redisTemplate.opsForList().leftPush("ulist", ""+user_id);
        }
        System.out.println(redisTemplate.opsForList().range("slist", 0, -1));
        System.out.println(redisTemplate.opsForList().range("ulist", 0, -1));
    }
}
