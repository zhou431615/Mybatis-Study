package com.zhoujk.dao;

import com.zhoujk.pojo.UserPOJO;
import com.zhoujk.utils.MybatisDBUtil;
import com.zhoujk.vo.UserVO;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by IntelliJ IDEA
 *
 * @Author: ZhouJiankang
 * @Date: 2021/9/24  21:28
 * @Description:
 */

/**
 * 这几天做Junit测试接触到了setup和teardown两个方法，
 * 简单的可以这样理解它们，setup主要实现测试前的初始化工作，
 * 而teardown则主要实现测试完成后的垃圾回收等工作。
 */
public class IUserDaoTest
{
    SqlSession sqlSession;
    @Before
    public void setUp() throws Exception
    {
        sqlSession = MybatisDBUtil.getSqlSession();

    }

    @After
    public void tearDown() throws Exception
    {
        sqlSession.commit();
    }


    @Test
    public void selectUserById()
    {
    }

    @Test
    public void selectAll()
    {
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        List<UserVO> userVOList = userDao.selectAll();
        for (UserVO vo : userVOList) {
            System.out.println(vo);
        }
    }
    @Test
    public void insert()
    {
    }

    @Test
    public void updateById()
    {
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        UserPOJO userPOJO1 = new UserPOJO(9, "刘一凡", "123456", 20, "女", "Sing，Rap", "看书");
        boolean flag1 = userDao.updateById(userPOJO1);
        System.out.println(flag1);
    }

    @Test
    public void deleteById()
    {
    }
}