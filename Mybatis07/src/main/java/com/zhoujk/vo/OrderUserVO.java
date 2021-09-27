package com.zhoujk.vo;

import com.zhoujk.po.Orders;

import java.util.Date;

/**
 * Created by IntelliJ IDEA
 *
 * @Author: ZhouJiankang
 * @Date: 2021/9/26  17:07
 * @Description:
 */
public class OrderUserVO extends Orders
{
    /**扩展信息 (user表里的信息)*/
    private Integer usersId;
    private String username;
    private String birthday;
    private String sex;
    private String address;

    @Override
    public String toString() {
        return super.toString() +
                "usersId=" + usersId +
                ", username='" + username + '\'' +
                ", birthday='" + birthday + '\'' +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public OrderUserVO() {
    }

    public OrderUserVO(Integer id, Integer userId, String number, Date createTime, String note) {
        super(id, userId, number, createTime, note);
    }

    public Integer getUsersId() {
        return usersId;
    }

    public void setUsersId(Integer usersId) {
        this.usersId = usersId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
