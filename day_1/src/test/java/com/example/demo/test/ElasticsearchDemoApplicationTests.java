package com.example.demo.test;


import com.alibaba.fastjson.JSONArray;
import com.example.demo.model.Product;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.xcontent.XContentType;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.ArrayList;

/**
 * FileName:ElasticsearchDemoApplicationTests
 * Author: kaishen
 * Date: 2020/9/21 0:08
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ElasticsearchDemoApplicationTests {


    @Autowired
    @Qualifier("getRestHighLevelClient")
    private RestHighLevelClient client;

    @Test
    public void test1(){
        CreateIndexRequest request = new CreateIndexRequest("springboot_es_test1");
        try {
            CreateIndexResponse createIndexResponse = client.indices().create(request, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2(){
        GetIndexRequest request = new GetIndexRequest("springboot_es_test1");
        try {
            boolean exists = client.indices().exists(request, RequestOptions.DEFAULT);
            System.out.println(exists);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test3(){
        Product product = new Product("王凯", 25);
        IndexRequest request = new IndexRequest("posts");
        request.id("1");
        request.source(JSONArray.toJSON(product), XContentType.JSON);
        try {
            IndexResponse indexResponse = client.index(request, RequestOptions.DEFAULT);

            GetRequest getRequest = new GetRequest("posts","1");
            GetResponse getResponse = client.get(getRequest, RequestOptions.DEFAULT);
            System.out.println(getResponse);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test4(){
        //创建批量请求
        BulkRequest bulkRequest = new BulkRequest();
        //超时时间
        bulkRequest.timeout("10s");
        //模拟数据
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("张1",1));
        products.add(new Product("张2",2));
        products.add(new Product("张3",3));
        products.add(new Product("张4",4));
        int i=0 ;
        //批量插入
        for(Product product:products){
            bulkRequest.add(
                    new IndexRequest("test2")
                            .id(""+i++)
                            .source(JSONArray.toJSON(product), XContentType.JSON)
            );
        }
        try {
            //发送请求
            BulkResponse bulk = client.bulk(bulkRequest, RequestOptions.DEFAULT);
            //获取是否失败标志
            System.out.println(bulk.hasFailures());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
