# 一对一关系

方法一：核心思想扩展order对象，来完成映射

场景一：查询某个订单的隶属会员信息

新建OrderUser实体类继承Order

```text
public class OrderUserVO extends Orders
{
    /**扩展信息 (user表里的信息)*/
    private Integer usersId;
    private String username;
    private String birthday;
    private String sex;
    private String address;
}
```



OrderMapper接口：

```text
public interface OrdersMapper
{
    /**
     * 按照订单id查询  订单的用户信息  通过resultType
     *
     * @param orderId 订单ID
     * @return
     */
    OrderUserVO queryOrdersUserByOrderIdResultType(Integer orderId);
```

编写mapper

```text
    <select id="queryOrdersUserByOrderIdResultType" resultType="OrderUserVO">
        select o.*,
               u.id usersid,
               u.username,
               u.birthday,
               u.sex,
               u.address
        from orders o,
             user u
        where o.user_id = u.id
          and o.id = #{oid}
    </select>
```

测试

```text
   @Test
    public void queryOrdersUserByOrderIdResultType()
    {
        OrderUserVO orderUserVO = ordersMapper.queryOrdersUserByOrderIdResultType(3);
        System.out.println(orderUserVO);
    }
```



