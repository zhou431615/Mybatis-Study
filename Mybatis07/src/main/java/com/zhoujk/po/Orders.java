package com.zhoujk.po;

import java.util.Date;

/**
 * Created by IntelliJ IDEA
 *
 * @Author: ZhouJiankang
 * @Date: 2021/9/26  17:07
 * @Description:
 */
public class Orders
{
    private Integer id;
    private Integer userId;
    private String number;
    private Date createTime;
    private String note;

    public Orders()
    {
    }

    public Orders(Integer id, Integer userId, String number, Date createTime, String note)
    {
        this.id = id;
        this.userId = userId;
        this.number = number;
        this.createTime = createTime;
        this.note = note;
    }

    /**
     * private User user;
     * private List<OrderDetail> orderDetails;
     */


    @Override
    public String toString()
    {
        return "Orders{" +
                "id=" + id +
                ", userId=" + userId +
                ", number='" + number + '\'' +
                ", createTime=" + createTime +
                ", note='" + note + '\'' +
                '}';
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getUserId()
    {
        return userId;
    }

    public void setUserId(Integer userId)
    {
        this.userId = userId;
    }

    public String getNumber()
    {
        return number;
    }

    public void setNumber(String number)
    {
        this.number = number == null ? null : number.trim();
    }

    public Date getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public String getNote()
    {
        return note;
    }

    public void setNote(String note)
    {
        this.note = note == null ? null : note.trim();
    }
}

