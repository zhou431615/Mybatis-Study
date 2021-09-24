package com.zhoujk.test;

import com.zhoujk.dao.IUserDao;
import com.zhoujk.pojo.UserPOJO;
import com.zhoujk.utils.MybatisDBUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * Created by IntelliJ IDEA
 *
 * @Author: ZhouJiankang
 * @Date: 2021/9/23  14:42
 * @Description:
 */
public class MyBatisTest03_Mapper
{
    public static void main(String[] args)
    {
        //获得mybatis提供过的实现类型
        SqlSession sqlSession = MybatisDBUtil.getSqlSession();
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        //查询用户信息
/*        UserVO userVO = userDao.selectUserById(5);
        System.out.println(userVO);*/
       //更新用户信息
        UserPOJO userPOJO1 = new UserPOJO(7, "赵六", "123456", 20, "女", "Sing，Rap", "多情却被无情恼");
        boolean flag1 = userDao.updateById(userPOJO1);
        System.out.println(flag1);
/*        //插入用户信息
        UserPOJO userPOJO2 = new UserPOJO("王五", "123456", 20, "女", "Sing", "singer");
        boolean flag2 = userDao.insert(userPOJO2);
        sqlSession.commit();
        System.out.println(flag2);
        //删除用户信息
        boolean flag3 = userDao.deleteById(7);
        sqlSession.commit();
        System.out.println(flag3);
        //查询所有用户信息
        List<UserVO> userVOList = userDao.selectAll();
        for (UserVO vo : userVOList) {
            System.out.println(vo);
        }*/
    }
}
