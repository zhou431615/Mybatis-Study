package com.zhoujk.vo;

/**
 * Created by IntelliJ IDEA
 *
 * @Author: ZhouJiankang
 * @Date: 2021/9/23  8:28
 * @Description:
 */

import com.zhoujk.pojo.UserPOJO;
public class UserVO extends UserPOJO
{
    public UserVO()
    {
    }

    public UserVO(Integer id, String username, String password, Integer age, String sex, String hobby, String remark)
    {
        super(id, username, password, age, sex, hobby, remark);
    }

    public UserVO(String username, String password, Integer age, String sex, String hobby, String remark)
    {
        super(username, password, age, sex, hobby, remark);
    }
}
