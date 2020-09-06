package com.example.demo.test;

import com.example.demo.model.U;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * FileName:UControllerTest
 * Author: kaishen
 * Date: 2020/9/6 22:08
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UControllerTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void createUTable(){
        //创建表sql语句，id自增从1开始 ，使用INNODB引擎
        String sql = "CREATE TABLE U(\n" +
                "\tid INT(10) NOT NULL AUTO_INCREMENT,\n" +
                "\tusername varchar(100) NOT NULL,\n" +
                "\tpassword varchar(100) NOT NULL,\n" +
                "\tPRIMARY KEY (id)\n" +
                ")ENGINE=INNODB AUTO_INCREMENT = 1 DEFAULT CHARSET = utf8";
        jdbcTemplate.execute(sql);
    }

    @Test
    public void saveU(){
        //插入一条数据
        String sql = "INSERT INTO U(username,password) VALUES('kai_wang','123456')";
        int rows = jdbcTemplate.update(sql);
        System.out.println(rows);
    }

    @Test
    public void getUserByName(){
        //根据名字查询语句
        String name = "kai_wang";
        String sql = "select * from u where username = ?";
        List<U> list = jdbcTemplate.query(sql, new U(), new Object[]{name});
        for (U u:list
             ) {
            System.out.println(u.getUsername());
            System.out.println(u.getPassword());
        }
    }

    @Test
    public void getUsers(){
        //查询所有数据
        String sql = "select * from u";
        List<U> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper(U.class));
        for (U u:list
             ) {
            System.out.println(u);
        }
    }

    @Test
    public void updateU(){
        int id = 1;
        String password = "789456";
        //更新数据
        String sql = "update u set password = ? where id = ?";
        int i = jdbcTemplate.update(sql, password, id);
        System.out.println(i);
    }

    @Test
    public void deleteU(){
        int id = 1;
        //删除一条数据
        String sql = "delete from u where id = ?";
        int i = jdbcTemplate.update(sql, id);
        System.out.println(i);
    }
}
