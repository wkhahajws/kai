package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * FileName:Article
 * Author: kaishen
 * Date: 2020/9/7 10:16
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */
@Entity
@Data
public class Article extends BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false,unique = true)
    @NotEmpty(message = "标题不能为空")
    private String title;   //标题

    @Column(columnDefinition = "enum('图','图文','文')")
    private String type;    //枚举类型

    private Boolean available = Boolean.FALSE;

    @Size(min = 1,max = 20)
    private String keyword;

    @Size(max = 255)
    private String description;

    @Column(nullable = false)
    private String body;

    @Transient
    private List keywordlists;

    public List getKeywordlists() {
        return Arrays.asList(this.keyword.trim().split("|"));
    }

    public void setKeywordlists(List keywordlists) {
        this.keywordlists = keywordlists;
    }
}
