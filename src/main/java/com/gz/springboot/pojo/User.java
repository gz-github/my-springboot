package com.gz.springboot.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class User {
    private Integer id;
    private String name;
    private String password;

    //com.alibaba.fastjson.annotation.JSONField
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    //@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date createTime;//创建时间.

    /*
     * 我们不想返回remarks?
     * serialize:是否需要序列化属性.
     */
    @JSONField(serialize=false)
    private String remarks;//备注信息.

    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
