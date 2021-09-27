package com.zhoujk.mapper;

import com.zhoujk.po.User;
import com.zhoujk.utils.MybatisDBUtil;
import com.zhoujk.vo.OrderUserCustomerVO;
import com.zhoujk.vo.OrderUserVO;
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
 * @Description:  测试案例
 */
public class UserMapperTest
{
    SqlSession sqlSession;
    UserMapper userMapper;
    OrdersMapper ordersMapper;

    @Before
    public void setUp() throws Exception
    {
        sqlSession = MybatisDBUtil.getSqlSession();
        userMapper = sqlSession.getMapper(UserMapper.class);
        ordersMapper = sqlSession.getMapper(OrdersMapper.class);

    }

    @After
    public void tearDown() throws Exception
    {
        sqlSession.commit();
    }

    @Test
    public void queryOrdersUserByOrderIdResultType()
    {
        OrderUserVO orderUserVO = ordersMapper.queryOrdersUserByOrderIdResultType(3);
        System.out.println(orderUserVO);
    }

    @Test
    public void queryOrdersUserByOrderIdResultMap()
    {
        OrderUserCustomerVO orderUserCustomerVO = ordersMapper.queryOrdersUserByOrderIdResultMap(4);
        System.out.println(orderUserCustomerVO);
    }

    @Test
    public void queryOrdersUserAndDetailListByOrderIdResultMap()
    {
        OrderUserCustomerVO orderUserCustomerVO = ordersMapper.queryOrdersUserAndDetailListByOrderIdResultMap(3);
        System.out.println(orderUserCustomerVO);
    }

    @Test
    public void queryOrdersUserAndDetailListAndItemsByOrderIdResultMap()
    {
        OrderUserCustomerVO orderUserCustomerVO = ordersMapper.queryOrdersUserAndDetailListAndItemsByOrderIdResultMap(3);
        System.out.println(orderUserCustomerVO);
    }

    @Test
    public void queryOrdersListByUserLazyLoading()
    {
        List<OrderUserCustomerVO> orderUserList = ordersMapper.queryOrdersListByUserLazyLoading();
        for (OrderUserCustomerVO vo : orderUserList) {
            User user = vo.getUser();
            System.out.println(user);
        }

    }


}