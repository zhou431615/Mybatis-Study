package com.zhoujk.vo;

/**
 * Created by IntelliJ IDEA
 *
 * @Author: ZhouJiankang
 * @Date: 2021/9/23  8:28
 * @Description:
 */

import com.zhoujk.po.User;

import java.util.Date;

public class UserVO extends User
{
    public UserVO()
    {
    }

    public UserVO(Integer id, String username, String sex, Date birthday, String address)
    {
        super(id, username, sex, birthday, address);
    }

    @Override
    public String toString()
    {
        return super.toString();
    }
}
