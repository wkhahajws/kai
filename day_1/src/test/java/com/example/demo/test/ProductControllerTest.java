package com.example.demo.test;

import com.example.demo.model.P;
import com.example.demo.repository.PRepository;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * FileName:ProductControllerTest
 * Author: kaishen
 * Date: 2020/9/21 12:51
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductControllerTest {
    private Integer PAGESIZE=10;
    @Autowired
    private PRepository pRepository;

    /**
     * 保存
     */
    @Test
    public void save() {
        List<P> list = new ArrayList<P>();
        list.add(new P(1600666304610L,
                "红富士","水果",7.99,"/img/p1.jpg","这是一个测试商品"));
        list.add(new P(1600666304611L,
                "金帅","水果",7.99,"/img/p1.jpg","金帅也和红富士一样，非常好吃，脆脆的"));
        list.add(new P(1600666304612L,
                "红富士","水果",7.99,"/img/p1.jpg","这是一个测试商品"));
        list.add(new P(1600666304613L,
                "红富士","水果",7.99,"/img/p1.jpg","这是一个测试商品"));
        Iterable iterable = list;
        pRepository.saveAll(iterable);
    }

    /**
     * 根据名字查找
     */
    @Test
    public void getP(){
        P p = pRepository.findByName("红富士");
        System.out.println(p.getId());
    }

    /**
     * 更新
     */
    @Test
    public void updateP(){
        long id = 1600666304612L;
        P p = new P(id,"香蕉","水果",8.03,"/img/p2.jpg","香蕉黄黄的，好吃又好用");
        pRepository.save(p);
    }

    /**
     * 根据id查找
     */
    @Test
    public void getPById(){
        P p = pRepository.findById(1600664137366L);
        System.out.println(p.toString());
    }

    /**
     * 删除
     */
    @Test
    public void deleteByID(){
        long id = 1600664137366L;
        pRepository.deleteById(id);
    }

    /**
     * 查找所有并按照id升序排列
     */
    @Test
    public void getPs(){
        Iterable<P> it = pRepository.findAll(Sort.by("id").ascending());
        for (P p:it
             ) {
            System.out.println(p);
        }
    }

    /**
     * 按照价格区间查询
     */
    @Test
    public void findByPriceBetween(){
        List<P> list = pRepository.findByPriceBetween(7.00, 8.00);
        for (P p:list){
            System.out.println(p);
        }
    }

    /**
     * 单参数查询
     */
    @Test
    public void termQuery(){
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        nativeSearchQueryBuilder.withQuery(QueryBuilders.termQuery("name","富"));

        Page<P> search = pRepository.search(nativeSearchQueryBuilder.build());
        for (P p:search
             ) {
            System.out.println(p);
        }
    }

    /**
     * 多参数查询
     */
    @Test
    public void termsQuery(){
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        nativeSearchQueryBuilder.withQuery(QueryBuilders.termsQuery("name","富","帅"));
        Page<P> search = pRepository.search(nativeSearchQueryBuilder.build());
        for (P p:search
        ) {
            System.out.println(p);
        }
    }

    /**
     * 分词查询
     */
    @Test
    public void matchQuery(){
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        nativeSearchQueryBuilder.withQuery(QueryBuilders.matchQuery("name","红士"));
        Page<P> search = pRepository.search(nativeSearchQueryBuilder.build());
        for (P p:search
        ) {
            System.out.println(p);
        }
    }

    /**
     * 多字段查询
     */
    @Test
    public void multiMatchQuery(){
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        nativeSearchQueryBuilder.withQuery(QueryBuilders.multiMatchQuery("红富士金帅","name","body"));
        Page<P> search = pRepository.search(nativeSearchQueryBuilder.build());
        for (P p:search
        ) {
            System.out.println(p);
        }
    }

    /**
     * 模糊查询 之 左右模糊
     */
    @Test
    public void queryStringQuery(){
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        nativeSearchQueryBuilder.withQuery(QueryBuilders.queryStringQuery("我觉得红富士好吃").field("name"));
        Page<P> search = pRepository.search(nativeSearchQueryBuilder.build());
        for (P p:search
             ) {
            System.out.println(p);
        }
    }

    /**
     * 模糊查询之前缀模糊
     */
    @Test
    public void prefixQuery(){
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        nativeSearchQueryBuilder.withQuery(QueryBuilders.prefixQuery("name","士"));
        Page<P> search = pRepository.search(nativeSearchQueryBuilder.build());
        for (P p:search
             ) {
            System.out.println(p);
        }
    }

    /**
     * 模糊查询之通配符*
     */
    @Test
    public void wildcardQuery(){
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        nativeSearchQueryBuilder.withQuery(QueryBuilders.wildcardQuery("name","金*"));
        Page<P> search = pRepository.search(nativeSearchQueryBuilder.build());
        for (P p:search
             ) {
            System.out.println(p);
        }
    }

    /**
     * 模糊查询之通配符?
     */
    @Test
    public void wildcardQuery2(){
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        nativeSearchQueryBuilder.withQuery(QueryBuilders.wildcardQuery("name","金?"));
        Page<P> search = pRepository.search(nativeSearchQueryBuilder.build());
        for (P p:search
             ) {
            System.out.println(p);
        }
    }

    /**
     * 模糊查询之分词
     */
    @Test
    public void fuzzyQuery(){
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        nativeSearchQueryBuilder.withQuery(QueryBuilders.fuzzyQuery("name","士").fuzziness(Fuzziness.ONE));
        Page<P> search = pRepository.search(nativeSearchQueryBuilder.build());
        for (P p:search
             ) {
            System.out.println(p);
        }
    }


}
