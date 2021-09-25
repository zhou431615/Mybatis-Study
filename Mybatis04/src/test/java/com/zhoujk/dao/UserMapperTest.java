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
 * @Date: 2021/9/24  22:30
 * @Description:
 */
public class UserMapperTest
{
    SqlSession sqlSession;
    UserMapper userMapper;
    @Before
    public void setUp() throws Exception
    {
        sqlSession = MybatisDBUtil.getSqlSession();
        userMapper = sqlSession.getMapper(UserMapper.class);
    }

    @After
    public void tearDown() throws Exception
    {
        sqlSession.commit();
    }

    @Test
    public void selectUserById()
    {
        UserVO userVO = userMapper.selectUserById(1);
        System.out.println(userVO);
    }

    @Test
    public void selectAll()
    {
        List<UserVO> userVOList = userMapper.selectAll();
        for (UserVO vo : userVOList) {
            System.out.println(vo);
        }
    }

    @Test
    public void insert()
    {
        UserPOJO userPOJO = new UserPOJO("程韩一", "123456", 23, "女", "绘画", "艺术家");
        boolean flag = userMapper.insert(userPOJO);
        System.out.println(flag);
    }

    @Test
    public void updateById()
    {
        UserPOJO userPOJO1 = new UserPOJO(9, "刘一凡", "123456", 20, "女", "Sing，Rap", "看书");
        boolean flag = userMapper.updateById(userPOJO1);
        System.out.println(flag);
    }

    @Test
    public void deleteById()
    {
        boolean flag = userMapper.deleteById(10);
        System.out.println(flag);
    }

    @Test
    public void selectUserListByNameLike()
    {
        List<UserVO> userVOList = userMapper.selectUserListByNameLike("三");
        System.out.println(userVOList.size());
        for (UserVO vo : userVOList) {
            System.out.println(vo);
        }
    }

    @Test
    public void insertBy$()
    {
        System.out.println("通过%插入！");
        UserPOJO userPOJO = new UserPOJO("李西娜", "123456", 23, "女", "演讲", "艺术家");
        boolean flag = userMapper.insertBy$(userPOJO);
        System.out.println(flag);
    }

    @Test
    public void selectUserListBySexAndNameLike()
    {
        List<UserVO>  userVOList = userMapper.selectUserListBySexAndNameLike("男", "三","23");
        for (UserVO vo : userVOList) {
            System.out.println(vo);
        }
    }

}