package com.zhoujk.vo;

import com.zhoujk.po.OrderDetail;
import com.zhoujk.po.Orders;
import com.zhoujk.po.User;

import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 *
 * @Author: ZhouJiankang
 * @Date: 2021/9/26  17:13
 * @Description:
 */
public class OrderUserCustomerVO extends Orders
{
    /** 扩展信息 (user表里的信息)
     *
     */
    private User user;
    /**一个订单 对应多个详单
     *
     */
    private List<OrderDetail> orderDetailList;
    @Override
    public String toString() {
        return super.toString() + user+orderDetailList;
    }

    public OrderUserCustomerVO() {
    }

    public OrderUserCustomerVO(Integer id, Integer userId, String number, Date createTime, String note) {
        super(id, userId, number, createTime, note);
    }


    public OrderUserCustomerVO(Integer id, Integer userId, String number, Date createTime, String note, User user, List <OrderDetail> orderDetailList) {
        super(id, userId, number, createTime, note);
        this.user = user;
        this.orderDetailList = orderDetailList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List <OrderDetail> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List <OrderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }
}
