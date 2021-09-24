package com.zhoujk.dao;

import com.zhoujk.utils.MybatisDBUtil;
import com.zhoujk.vo.UserVO;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by IntelliJ IDEA
 *
 * @Author: ZhouJiankang
 * @Date: 2021/9/24  14:50
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
    }

    @Test
    public void deleteById()
    {
    }
}