package com.example.demo;

import com.example.demo.entity.U;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.HashMap;

/**
 * FileName:RestTemplateTest
 * Author: kaishen
 * Date: 2020/10/27 12:05
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RestTemplateTest {

    @Autowired
    RestTemplateBuilder restTemplateBuilder;

    //返回String，不带参数
    @Test
    public void notparam(){
        RestTemplate template = restTemplateBuilder.build();
        ResponseEntity<String> responseEntity = template.getForEntity("http://localhost:8080/getU1", String.class);
        System.out.println(responseEntity.getBody());
    }
    //返回String,带参数
    @Test
    public void withparam(){
        RestTemplate template = restTemplateBuilder.build();
        ResponseEntity<String> responseEntity = template.getForEntity("http://localhost:8080/getparameter?name={1}&age={2}"
                , String.class, "周伯通", 2);
        System.out.println(responseEntity.getBody());
    }
    @Test
    public void withparamMap(){
        RestTemplate template = restTemplateBuilder.build();
        HashMap<String, String> map = new HashMap<>();
        map.put("name","周伯通");
        map.put("age","2");
        ResponseEntity<String> responseEntity = template.getForEntity("http://localhost:8080/getparameter?name={name}&age={age}"
                , String.class, map);
        System.out.println(responseEntity.getBody());
    }

    //返回对象
    @Test
    public void restU(){
        RestTemplate template = restTemplateBuilder.build();
        ResponseEntity<U> responseEntity = template.getForEntity("http://localhost:8080/getU1", U.class);
        U u = responseEntity.getBody();
        System.out.println(u);
    }

    //使用getForObject,只返回消息体的内容
    @Test
    public void getForObject(){
        RestTemplate template = restTemplateBuilder.build();
        U u = template.getForObject("http://localhost:8080/getU1", U.class);
        System.out.println(u);
    }

    //使用postForEntity
    @Test
    public void postForEntity(){
        RestTemplate template = restTemplateBuilder.build();
        MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<String,Object>();
        paramMap.add("name","周伯通");
        paramMap.add("age",2);
        ResponseEntity<U> entity = template.postForEntity("http://localhost:8080/postuser", paramMap, U.class);
        System.out.println(entity.getBody());
    }

    //使用postForObject
    @Test
    public void postForObject(){
        RestTemplate template = restTemplateBuilder.build();
        MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<String,Object>();
        paramMap.add("name","周伯通");
        paramMap.add("age",2);
        String s = template.postForObject("http://localhost:8080/postuser", paramMap, String.class);
        System.out.println(s);
    }

    //使用exchange
    @Test
    public void postForexchange(){
        RestTemplate template = restTemplateBuilder.build();
        MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<String,Object>();
        paramMap.add("name","周伯通");
        paramMap.add("age",2);
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<MultiValueMap<String, Object>> httpEntity = new HttpEntity<>(paramMap, httpHeaders);
        ResponseEntity<String> exchange = template.exchange("http://localhost:8080/postuser", HttpMethod.POST, httpEntity, String.class, paramMap);
        System.out.println(exchange.getBody());
    }

    //使用postForLocation
    @Test
    public void postForLocation(){
        RestTemplate template = restTemplateBuilder.build();
        MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<String,Object>();
        paramMap.add("name","周伯通");
        paramMap.add("age",2);
        paramMap.add("id",100);
        URI uri = template.postForLocation("http://localhost:8080/post", paramMap);
        System.out.println(uri);
    }

    @Test
    public void put(){
        RestTemplate template = restTemplateBuilder.build();
        U u = new U();
        u.setName("周伯通");
        template.put("http://localhost:8080/{1}",u,4);
    }

    @Test
    public void delete(){
        RestTemplate template = restTemplateBuilder.build();
        template.delete("http://localhost:8080/{1}",4);
    }

}
