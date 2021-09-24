package com.zhoujk.dao;

import com.zhoujk.pojo.UserPOJO;
import com.zhoujk.utils.MybatisDBUtil;
import com.zhoujk.vo.UserVO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created by IntelliJ IDEA
 *
 * @Author: ZhouJiankang
 * @Date: 2021/9/23  13:57
 * @Description:
 */
public class UserDao implements IUserDao
{

    @Override
    public UserVO selectUserById(Integer id)
    {
        SqlSession sqlSession = MybatisDBUtil.getSqlSession();
        UserVO userVO = sqlSession.selectOne("test.selectUserById", id);        sqlSession.close();
        sqlSession.close();
        return userVO;
    }

    @Override
    public List<UserVO> selectAll()
    {
        SqlSession sqlSession = MybatisDBUtil.getSqlSession();
        List<UserVO> userVOList = sqlSession.selectList("test.selectAll");
        sqlSession.close();
        return userVOList;
    }

    @Override
    public boolean insert(UserPOJO userPOJO)
    {
        SqlSession sqlSession = MybatisDBUtil.getSqlSession();
        int row1 = sqlSession.insert("test.insert", userPOJO);
        sqlSession.commit();
        return row1 > 0 ? true : false;
    }

    @Override
    public boolean updateById(UserPOJO userPOJO)
    {
        SqlSession sqlSession = MybatisDBUtil.getSqlSession();
        int row2 = sqlSession.update("test.updateById", userPOJO);
        sqlSession.commit();
        return row2 > 0 ? true : false;
    }

    @Override public boolean deleteById(Integer id)
    {
        SqlSession sqlSession = MybatisDBUtil.getSqlSession();
        int row3 = sqlSession.delete("test.deleteById", id);
        sqlSession.commit();
        return row3 > 0 ? true : false;
    }
}
