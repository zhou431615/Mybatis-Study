package com.zhoujk.po;

/**
 * Created by IntelliJ IDEA
 *
 * @Author: ZhouJiankang
 * @Date: 2021/9/26  17:10
 * @Description:
 */
public class OrderDetail
{
    private Integer id;
    private Integer ordersId;
    private Integer itemsId;
    private Integer itemsNum;
    private Items items;

    public OrderDetail() {
    }

    public OrderDetail(Integer id, Integer ordersId, Integer itemsId, Integer itemsNum, Items items) {
        this.id = id;
        this.ordersId = ordersId;
        this.itemsId = itemsId;
        this.itemsNum = itemsNum;
        this.items = items;
    }

    public OrderDetail(Integer id, Integer ordersId, Integer itemsId, Integer itemsNum) {
        this.id = id;
        this.ordersId = ordersId;
        this.itemsId = itemsId;
        this.itemsNum = itemsNum;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "id=" + id +
                ", ordersId=" + ordersId +
                ", itemsId=" + itemsId +
                ", itemsNum=" + itemsNum +
                '}'+items;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(Integer ordersId) {
        this.ordersId = ordersId;
    }

    public Integer getItemsId() {
        return itemsId;
    }

    public void setItemsId(Integer itemsId) {
        this.itemsId = itemsId;
    }

    public Integer getItemsNum() {
        return itemsNum;
    }

    public void setItemsNum(Integer itemsNum) {
        this.itemsNum = itemsNum;
    }
}
