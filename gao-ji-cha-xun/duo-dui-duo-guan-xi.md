# 多对多关系

多对多查询：查询订单，查询出下单人信息并且查询出订单详情中商品数据。

OrderDetail类及item类

```text
public class OrderDetail
{
    private Integer id;
    private Integer ordersId;
    private Integer itemsId;
    private Integer itemsNum;
    private Items items;
}

public class Items
{
    private Integer id;
    private String name;
    private Float price;
    private String pic;
    private Date createTime;
    private String detail;
}
```

编写mapper

```text
<!--根据订单 查询用户和订单详情   在订单详情中查找商品信息 -->
    <resultMap id="OrderUserCustomerVOResultMap3" type="OrderUserCustomerVO">
        <!--主键对应-->
        <id column="id" property="id"></id>
        <!--非主键对应-->
        <result column="user_id" property="userId"></result>
        <result column="number" property="number"></result>
        <result column="createtime" property="createTime"></result>
        <result column="note" property="note"></result>
        <!--一对一的关系   user 对应的是类型中的对象名称-->
        <association property="user" javaType="User">
            <!--主键对应-->
            <id column="usersid" property="id"></id>
            <!--非主键对应-->
            <result column="username" property="username"></result>
            <result column="birthday" property="birthday"></result>
            <result column="sex" property="sex"></result>
            <result column="address" property="address"></result>
        </association>
        <!--多个详单-->
        <collection property="orderDetailList" ofType="OrderDetail">
            <!--主键对应-->
            <id column="detail_id" property="id"></id>
            <!--非主键对应-->
            <result column="orders_id" property="ordersId"></result>
            <result column="items_id" property="itemsId"></result>
            <result column="items_num" property="itemsNum"></result>

            <!--1对1     1个详单对应一个商品-->
            <!--这里面的property 写的是父亲orderDetail里面的items这个类定义的名字  用这个名字找的对应关系      而不是指的是Items这个实体类   直接实体的话就没对应关系了，因为父亲里没有-->
            <association property="items" javaType="Items">
                <!--主键对应-->
                <id column="goodsid" property="id"></id>
                <!--非主键对应-->
                <result column="goodsName" property="name"></result>
                <result column="goodsPrice" property="price"></result>
                <result column="goodsDetail" property="detail"></result>
                <result column="goodsPic" property="pic"></result>
                <result column="goodsCreatetime" property="createTime"></result>
            </association>
        </collection>
    </resultMap>
    <select id="queryOrdersUserAndDetailListAndItemsByOrderIdResultMap" resultMap="OrderUserCustomerVOResultMap3">
        select o.*,
               u.id             usersid,
               u.username,
               u.birthday,
               u.sex,
               u.address,
               d.id             detail_id,
               d.orders_id      orders_id,
               d.items_id       items_id,
               d.items_num      items_num,
               items.id         goodsid,
               items.name       goodsName,
               items.price      goodsPrice,
               items.detail     goodsDetail,
               items.pic        goodsPic,
               items.createtime goodsCreatetime
        from orders o,
             user u,
             orderdetail d,
             items items
        where o.user_id = u.id
          and o.id = d.orders_id
          and d.items_id = items.id
          and o.id = #{oid}
    </select>
```

测试

```text
    @Test
    public void queryOrdersUserAndDetailListAndItemsByOrderIdResultMap()
    {
        OrderUserCustomerVO orderUserCustomerVO = ordersMapper.queryOrdersUserAndDetailListAndItemsByOrderIdResultMap(3);
        System.out.println(orderUserCustomerVO);
    }

```

