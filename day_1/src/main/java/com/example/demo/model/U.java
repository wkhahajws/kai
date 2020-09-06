package com.example.demo.model;


import lombok.Data;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * FileName:U
 * Author: kaishen
 * Date: 2020/9/6 21:50
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */
@Data
public class U implements RowMapper<U> {
    private int id;
    private String username;
    private String password;

    @Override
    public U mapRow(ResultSet resultSet, int i) throws SQLException {
        U u = new U();
        u.setId(resultSet.getInt("id"));
        u.setUsername(resultSet.getString("username"));
        u.setPassword(resultSet.getString("password"));
        return u;
    }
}
