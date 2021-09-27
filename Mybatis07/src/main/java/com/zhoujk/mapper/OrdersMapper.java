package com.zhoujk.mapper;

import com.zhoujk.vo.OrderUserCustomerVO;
import com.zhoujk.vo.OrderUserVO;

import java.util.List;

/**
 * Created by IntelliJ IDEA
 *
 * @Author: ZhouJiankang
 * @Date: 2021/9/27  9:19
 * @Description:
 */

/**
 *
 *      需要代理的接口             mapper.xml文件
 *      全路径名称                 namespace
 *      方法名称                   statementId
 *      参数列表                   parameterType
 *      返回值                     resultType/resultMap
 *
 *
 *
 * */
public interface OrdersMapper
{
    /**
     * 按照订单id查询  订单的用户信息  通过resultType
     *
     * @param orderId 订单ID
     * @return
     */
    OrderUserVO queryOrdersUserByOrderIdResultType(Integer orderId);

    /**
     * 按照订单id查询  订单的用户信息  通过resultMap
     *
     * @param orderId 订单ID
     * @return
     */
    OrderUserCustomerVO queryOrdersUserByOrderIdResultMap(Integer orderId);

    /**
     * 按照订单id查询  订单的用户信息 和详单信息
     *
     * @param orderId 订单ID
     * @return
     */
    OrderUserCustomerVO queryOrdersUserAndDetailListByOrderIdResultMap(Integer orderId);

    /**
     * 按照订单id查询  订单的用户信息 和详单信息 再详单信息里面再查找商品信息
     *
     * @param orderId 订单ID
     * @return
     */
    OrderUserCustomerVO queryOrdersUserAndDetailListAndItemsByOrderIdResultMap(Integer orderId);

    /**
     * 延迟加载的接口方法
     * @param id
     * @return
     */
    
    
    /**
     * 
     UserVO queryUserById(Integer id);*/

    /**
     * 延迟加载测试
     *
     * @return
     */
    List<OrderUserCustomerVO> queryOrdersListByUserLazyLoading();


}