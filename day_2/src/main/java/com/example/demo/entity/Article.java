package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * FileName:Article
 * Author: kaishen
 * Date: 2020/10/26 9:17
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
    private String title;

    @Column(columnDefinition = "enum('图','图文','文')")
    private String type;

    private Boolean available = Boolean.FALSE;

    private String keyword;
    private String description;

    @Column(nullable = false)
    private String body;

    @Transient
    private List keywordlists;

    public List getKeywordlists() {
        return keywordlists;
    }

    public void setKeywordlists(List keywordlists) {
        this.keywordlists = keywordlists;
    }
}
