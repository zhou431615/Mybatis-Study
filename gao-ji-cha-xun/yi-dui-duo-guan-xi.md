# 一对多关系

一对多查询：查询订单，查询出下单人信息，并且查询出订单详情。

Orders

```text
public class Orders
{
    private Integer id;
    private Integer userId;
    private String number;
    private Date createTime;
    private String note;
}
```

OrderUserCustomerVO 

```text
public class OrderUserCustomerVO extends Orders
{
    /** 扩展信息 (user表里的信息)
     *
     */
    private User user;
    /**一个订单 对应多个详单
     *
     */
    private List<OrderDetail> orderDetailList;
}

```

编写mapper

```text
    /**
     * 按照订单id查询  订单的用户信息 和详单信息
     *
     * @param orderId 订单ID
     * @return
     */
    OrderUserCustomerVO queryOrdersUserAndDetailListByOrderIdResultMap(Integer orderId);
```

测试

```text
    @Test
    public void queryOrdersUserAndDetailListByOrderIdResultMap()
    {
        OrderUserCustomerVO orderUserCustomerVO = ordersMapper.queryOrdersUserAndDetailListByOrderIdResultMap(3);
        System.out.println(orderUserCustomerVO);
    }
```

