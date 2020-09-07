package com.example.demo.model;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * FileName:BaseEntity
 * Author: kaishen
 * Date: 2020/9/7 12:38
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {

    @Column(name = "create_time")
    @CreatedDate
    private Date createTime;    //创建时间

    @Column(name = "update_time")
    @LastModifiedDate
    private Date updateTime;    //最后修改时间

    @Column(name = "create_by")
    @CreatedBy
    private String createBy;    //创建人

    @Column(name = "update_by")
    @LastModifiedBy
    private String updateBy;    //最后修改人

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }
}
