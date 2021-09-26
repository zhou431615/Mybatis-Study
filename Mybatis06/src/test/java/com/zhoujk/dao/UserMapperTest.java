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
    public void cache1()
    {
        /**一级缓存  存在sqlSession 会话。
         * 中间没有执行增删改的话  就直接从缓存中取。
         *
         * Mybatis的一级缓存的作用域是session，当openSession()后，
         * 如果执行相同的SQL（相同语句和参数），Mybatis不进行执行sQL，
         * 而是从缓存中命中返回。
         *
         * 原理:
         * Mybatis执行查询时首先去缓存区命中，如果命中直接返回，
         * 没有命中则执行sQL，从数据库中查询。
         *
         * 在mybatis中，一级缓存默认是开启的，并且一直无法关闭—级缓存满足条件:
         * 1、同一个session中
         * 2、相同的SQL和参数
         *
         * */


        SqlSession sqlSession = MybatisDBUtil.getSqlSession();
        UserMapper userDao = sqlSession.getMapper(UserMapper.class);

        UserVO userVO = userDao.selectUserById(1);
        System.out.println(userVO);
        UserVO userVO2 = userDao.selectUserById(1);
        System.out.println(userVO == userVO2);

        /** userVO == userVO2的值为true
         *  userVO与userVO2是同一对象，同一地址
         *  只执行一遍SQL语句，通过缓存，查询命中
         * */
    }

    @Test
    public void cache2()
    {
        // 一级缓存
        SqlSession sqlSession1 = MybatisDBUtil.getSqlSession();
        UserMapper userDao = sqlSession.getMapper(UserMapper.class);

        UserVO userVO = userDao.selectUserById(1);
        System.out.println(userVO);
        // 清除缓存
        sqlSession.clearCache();
        /*boolean flag = userMapper.deleteById(10);*/

        UserVO userVO2 = userDao.selectUserById(1);
        System.out.println(userVO == userVO2);

        /** userVO == userVO2的值为false
         *  userVO与userVO2是同不同对象
         *  清除缓存后，在重新执行一遍的SQL查询
         *
         *  还有一点，当执行insert、update、delete等操作，也会清空缓存。
         * */
    }

    @Test
    public void cache3()
    {
        // 一级缓存
        SqlSession sqlSession1 = MybatisDBUtil.getSqlSession();
        UserMapper userDao1 = sqlSession1.getMapper(UserMapper.class);

        UserVO userVO = userDao1.selectUserById(1);
        System.out.println(userVO);

        SqlSession sqlSession2 = MybatisDBUtil.getSqlSession();
        UserMapper userDao2 = sqlSession2.getMapper(UserMapper.class);
        UserVO userVO2 = userDao2.selectUserById(1);
        System.out.println(userVO);
        System.out.println(userVO == userVO2);

        /** userVO == userVO2的值为false
         *  userVO与userVO2是同不同对象
         *
         * 不同sqlSession下的，缓存也是不同的。
         *
         */
    }


    @Test
    public void cache4()
    {
        // 一级缓存
        SqlSession sqlSession = MybatisDBUtil.getSqlSession();
        UserMapper userDao = sqlSession.getMapper(UserMapper.class);

        UserVO userVO = userDao.selectUserById(1);
        // 二级缓存 首先必须要关闭sqlSession对象，之后写入到缓存区中。
        sqlSession.close();
        //  这样“ UserVO userVO = userDao.selectUserById(1); ” 就写入到缓存中了
        SqlSession sqlSession2 = MybatisDBUtil.getSqlSession();
        UserMapper userDao2 = sqlSession2.getMapper(UserMapper.class);
        // 这里直接调用二级缓存下的同名selectUserById，直接命中
        UserVO userVO2 = userDao2.selectUserById(1);
        UserVO userVO3 = userDao2.selectUserById(1);
        UserVO userVO4 = userDao2.selectUserById(1);
        UserVO userVO5 = userDao2.selectUserById(1);
        System.out.println(userVO);
        System.out.println(userVO2);
        System.out.println(userVO3);
        System.out.println(userVO4);
        System.out.println(userVO5);
        System.out.println(userVO == userVO2);


        /** SQL，只执行一遍，但是两者会话Session不用,返回的对象不同。
         * */

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
        UserPOJO userPOJO1 = new UserPOJO(9, "刘一凡", "123456", 20, "女", "踏青", "看书,游山玩水");
        boolean flag = userMapper.updateById(userPOJO1);
        System.out.println(flag);
    }

    @Test
    public void deleteById()
    {
        boolean flag = userMapper.deleteById(10);
        System.out.println(flag);
    }



}