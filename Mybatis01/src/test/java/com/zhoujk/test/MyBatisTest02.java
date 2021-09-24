package com.zhoujk.test;

import com.zhoujk.dao.IUserDao;
import com.zhoujk.dao.UserDao;
import com.zhoujk.pojo.UserPOJO;
import com.zhoujk.vo.UserVO;

import java.util.List;

/**
 * Created by IntelliJ IDEA
 *
 * @Author: ZhouJiankang
 * @Date: 2021/9/23  14:42
 * @Description:
 */
public class MyBatisTest02
{
    public static void main(String[] args)
    {
        IUserDao userDao = new UserDao();
        //查询用户信息
        UserVO userVO = userDao.selectUserById(5);
        System.out.println(userVO);
        //查询用户信息
        UserPOJO userPOJO1 = new UserPOJO(6, "赵六", "123456", 20, "女", "Sing，Rap", "singer");
        boolean flag1 = userDao.updateById(userPOJO1);
        System.out.println(flag1);
        //插入用户信息
        UserPOJO userPOJO2 = new UserPOJO("王五", "123456", 20, "女", "Sing", "singer");
        boolean flag2 = userDao.insert(userPOJO2);
        System.out.println(flag2);
        //删除用户信息
        boolean flag3 = userDao.deleteById(7);
        System.out.println(flag3);
        //查询所有用户信息
        List<UserVO> userVOList = userDao.selectAll();
        for (UserVO vo : userVOList) {
            System.out.println(vo);
        }
    }
}
