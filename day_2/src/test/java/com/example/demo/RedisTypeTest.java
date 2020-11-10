package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * FileName:RedisTypeTest
 * Author: kaishen
 * Date: 2020/10/29 0:05
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTypeTest {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate redisTemplate;

    //操作字符串
    @Test
    public void string(){
        redisTemplate.opsForValue().set("num",123);
        redisTemplate.opsForValue().set("string","some Strings");
        Object num = redisTemplate.opsForValue().get("num");
        Object string = redisTemplate.opsForValue().get("string");
        System.out.println(num);
        System.out.println(string);
    }

    @Test
    public void string2(){
        //设置失效时间为3秒
        redisTemplate.opsForValue().set("num","123XYZ",3, TimeUnit.SECONDS);
        try {
            Object num = redisTemplate.opsForValue().get("num");
            System.out.println(num);
            Thread.sleep(2000);
            num = redisTemplate.opsForValue().get("num");
            System.out.println(num);
            Thread.sleep(5000);
            num = redisTemplate.opsForValue().get("num");
            System.out.println(num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //有点问题
    @Test
    public void string3(){
        redisTemplate.opsForValue().set("key","helloworld",6);
        System.out.println(redisTemplate.opsForValue().get("key"));
    }


    @Test
    public void string4(){
        redisTemplate.opsForValue().set("getSetTest","test");
        //拿到旧值
        System.out.println(redisTemplate.opsForValue().getAndSet("getSetTest","test22"));
        System.out.println(redisTemplate.opsForValue().get("getSetTest"));
    }

    //字符串追加
    @Test
    public void string5(){
        redisTemplate.opsForValue().append("k","test");
        Object k = redisTemplate.opsForValue().get("k");
        System.out.println(k);
        redisTemplate.opsForValue().append("k","test2");
        k = redisTemplate.opsForValue().get("k");
        System.out.println(k);
    }

    //获取长度
    @Test
    public void string6(){
        Long size = redisTemplate.opsForValue().size("key");
        System.out.println(size);
    }

    //操作散列
    @Test
    public void hash(){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("name","洪七公");
        map.put("age","25");
        redisTemplate.opsForHash().putAll("HASH",map);      //添加散列
        redisTemplate.opsForHash().put("HASH","hobby","降龙十八掌");
//        redisTemplate.opsForHash().delete("HASH","name");          //删除指定key的散列
        Map hash = redisTemplate.opsForHash().entries("HASH");      //取出散列 {name=洪七公, age=25, hobby=降龙十八掌}
        List list = redisTemplate.opsForHash().values("HASH");      //取出散列所有的值 [洪七公, 25, 降龙十八掌]
        System.out.println(hash);
        System.out.println(redisTemplate.opsForHash().hasKey("HASH","name"));
        System.out.println(redisTemplate.opsForHash().hasKey("HASH","age"));    //确定hashKey是否存在
        System.out.println(redisTemplate.opsForHash().get("HASH","name"));      //获取指定hashKey的值
        System.out.println(redisTemplate.opsForHash().keys("HASH"));        //获取所有的key
        System.out.println(redisTemplate.opsForHash().size("HASH"));        //获取散列表的大小个数
    }

    //操作列表
    @Test
    public void list(){
        /*String[] strings = new String[]{"1","2","3"};
        redisTemplate.opsForList().leftPushAll("list",strings);     //左侧添加数据
        System.out.println(redisTemplate.opsForList().range("list",0,-1));      //读取指定范围数据
        System.out.println(redisTemplate.opsForList().size("list"));        //获取列表的长度
        redisTemplate.opsForList().leftPush("list","456");      //左侧添加数据
        System.out.println(redisTemplate.opsForList().range("list",0,-1));
        redisTemplate.opsForList().rightPush("list","789");     //右侧添加数据
        System.out.println(redisTemplate.opsForList().range("list",0,-1));*/

        /*String[] strings = new String[]{"10","11","12"};
        redisTemplate.opsForList().rightPushAll("list",strings);*/       //右侧添加数据

        //redisTemplate.opsForList().set("list",1,"值");   //在指定位置插入值

//        redisTemplate.opsForList().remove("list",2,"2");     //删除列表第二个2
//        System.out.println(redisTemplate.opsForList().index("list", 2));//根据下标取值
//        System.out.println(redisTemplate.opsForList().rightPop("list"));//弹出最右边的值，弹出之后列表之内不存在
//        System.out.println(redisTemplate.opsForList().leftPop("list"));//弹出最左边的值，弹出之后列表之内不存在


        System.out.println(redisTemplate.opsForList().range("list",0,-1));

    }

    //操作集合 set是存放不重复值得集合
    @Test
    public void set(){
        //添加
        String[] strings = new String[]{"str1","str2"};
        redisTemplate.opsForSet().add("set",strings);
        redisTemplate.opsForSet().add("set","str3","str4","str5");
        //删除
//        redisTemplate.opsForSet().remove("set",strings);
        //移除并返回集合中的一个随机元素
//        redisTemplate.opsForSet().pop("set");
        //元素移动
//        redisTemplate.opsForSet().move("set","str1","set2");
        //获取集合大小
//        System.out.println(redisTemplate.opsForSet().size("set"));

        //遍历set
        Cursor<Object> scan = redisTemplate.opsForSet().scan("set", ScanOptions.NONE);
        while (scan.hasNext()){
            System.out.println(scan.next());
        }

        //返回集合所有成员
//        System.out.println(redisTemplate.opsForSet().members("set"));
    }


    //操作有序集合,不允许重复,每个元素都会关联一个double类型的分数。根据分数从小到大排序
    @Test
    public void testZset(){
        /*ZSetOperations.TypedTuple<Object> objectTypedTuple1 = new DefaultTypedTuple<>("zset-1", 9.6);
        ZSetOperations.TypedTuple<Object> objectTypedTuple2 = new DefaultTypedTuple<>("zset-2", 9.9);
        Set<ZSetOperations.TypedTuple<Object>> tuples = new HashSet<ZSetOperations.TypedTuple<Object>>();
        tuples.add(objectTypedTuple1);
        tuples.add(objectTypedTuple2);
        System.out.println(redisTemplate.opsForZSet().add("zset",tuples));
        System.out.println(redisTemplate.opsForZSet().range("zset",0,-1));*/
        //新增一个有序集合，如果存在则返回false，如果不存在则返回true。
        redisTemplate.opsForZSet().add("zset2","zset-1",1.0);
        redisTemplate.opsForZSet().add("zset2","zset-2",1.2);
        redisTemplate.opsForZSet().add("zset2","zset-3",0.5);
        redisTemplate.opsForZSet().add("zset2","zset-4",1.8);

        //删除一个或多个元素
//        System.out.println(redisTemplate.opsForZSet().remove("zset","zset-1","zset-2"));

        //返回有序集合中指定成员的排名，按分数递增排列
//        System.out.println(redisTemplate.opsForZSet().rank("zset2","zset-1"));
        //返回有序集合中指定区间内的成员，按分数递增排列
//        System.out.println(redisTemplate.opsForZSet().range("zset2",0,-1));

        //通过分数返回有序集合指定区间内的成员个数
//        System.out.println(redisTemplate.opsForZSet().count("zset2",1,5));
        //获取有序集合的成员数
//        System.out.println(redisTemplate.opsForZSet().size("zset2"));

        //获取指定成员的分数
//        System.out.println(redisTemplate.opsForZSet().score("zset2","zset-1"));

        //移除指定索引位置的成员
//        System.out.println(redisTemplate.opsForZSet().removeRange("zset2",1,2));

        //遍历
        Cursor<ZSetOperations.TypedTuple<Object>> scan = redisTemplate.opsForZSet().scan("zset2", ScanOptions.NONE);
        while (scan.hasNext()){
            ZSetOperations.TypedTuple<Object> next = scan.next();
            System.out.println(next.getValue()+","+next.getScore());
        }
    }

}
