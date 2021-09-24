package com.zhoujk.test;

import com.zhoujk.vo.UserVO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 *
 * @Author: ZhouJiankang
 * @Date: 2021/9/23  8:30
 * @Description:
 */
public class MybatisTest01
{
    public static void main(String[] args)
    {
        Reader reader;
        try {
            reader = Resources.getResourceAsReader("mybatis-config.xml");
            // 1- 获得sqlSession工厂类型对象
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            // 2-从工厂对象中获得一个回话对象
            SqlSession sqlSession = sqlSessionFactory.openSession();
            System.out.println(sqlSession);


            // 3-操作数据库库 第一个参数传递的是调用映射文件中的那个statementId 传递的参数
            //  按照id查询用户信息
            UserVO userVO = sqlSession.selectOne("test.selectUserById", 1);
            System.out.println(userVO);


/*            //  statementId  参数列表  建议传递最好是POJO类型  把参数封装到一个对象那个传递
            UserPOJO userPOJO = new UserPOJO("张三", "123456", 20, "男", "sing", "就热爱学习");
            int row1 = sqlSession.insert("test.insert", userPOJO);
            // 提交事务  需要自己手动提交(控制)  默认不是自动提交
            sqlSession.commit();
            System.out.println(row1);*/

/*            //  更新操作
            // statementId  参数列表  建议传递最好是POJO类型  把参数封装到一个对象那个传递
            UserPOJO userPOJO_update = new UserPOJO(3, "张三", "123456", 20, "男", "dance", "就热爱学习");
            int row2 = sqlSession.update("test.updateById", userPOJO_update);
            // 提交事务  需要自己手动提交(控制)  默认不是自动提交
            sqlSession.commit();
            System.out.println(row2);*/
/*
            //  删除操作
            int row3 = sqlSession.delete("test.deleteById", 4);
            // 提交事务  需要自己手动提交(控制)  默认不是自动提交
            sqlSession.commit();
            System.out.println(row3);
            // 查询所有
            List<UserVO> userVOList = sqlSession.selectList("test.selectAll");
            for (UserVO vo : userVOList) {
                System.out.println(vo);
            }*/
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

