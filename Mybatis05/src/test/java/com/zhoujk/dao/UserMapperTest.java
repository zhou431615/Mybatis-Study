package com.zhoujk.dao;

import com.zhoujk.pojo.UserPOJO;
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
        List<UserVO> userVOList = userMapper.selectUserListBySexAndNameLike("男", "三", 23);
        for (UserVO vo : userVOList) {
            System.out.println(vo);
        }
    }

    @Test
    public void selectUserListByNameAndAge()
    {
        List<UserVO> userVOList = userMapper.selectUserListByNameAndAge(null, null);
        for (UserVO vo : userVOList) {
            System.out.println(vo);
        }
        System.out.println("有结果");
    }

    @Test
    public void selectUserListByNameAndAgeWhere1()
    {
        List<UserVO> userVOList = userMapper.selectUserListByNameAndAgeWhere1(null, null);
        for (UserVO vo : userVOList) {
            System.out.println(vo);
        }
        System.out.println("有结果");
    }

    @Test
    public void selectUserListByNameAndAgeWhere2()
    {
        List<UserVO> userVOList = userMapper.selectUserListByNameAndAgeWhere2("张三", 23);
        for (UserVO vo : userVOList) {
            System.out.println(vo);
        }
        System.out.println("看看结果与selectUserListByNameAndAgeWhere1的有什么不同！");
    }

}