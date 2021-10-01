---
description: 结果映射
---

# ResultMap

 `resultMap` 元素是 MyBatis 中最重要最强大的元素。它可以让你从 90% 的 JDBC `ResultSets` 数据提取代码中解放出来，并在一些情形下允许你进行一些 JDBC 不支持的操作。实际上，在为一些比如连接的复杂语句编写映射代码的时候，一份 `resultMap` 能够代替实现同等功能的数千行代码。ResultMap 的设计思想是，对简单的语句做到零配置，对于复杂一点的语句，只需要描述语句之间的关系就行了。

使用ResultMap可以解决两大问题:

* POJO属性名和表结构字段名不一致的间题（有些情况下也不是标准的驼峰格式\) 
* 完成高级查询，比如说，一对一、一对多、多对多。 

解决表字段名和属性名不一致的间题有两种方法:

1. 如果是驼峰似的命名规则可以在Mybatis 配置文件中设置解决 
2. 使用ResultMap解决。 高级查询后面详细讲解。

看一个高级查询例子吧

```text
<resultMap id="queryOrdersListByUserLazyLoadingResultMap" type="OrderUserCustomerVO">
        <id column="id" property="id"></id>
        <!--非主键对应-->
        <result column="user_id" property="userId"></result>
        <result column="number" property="number"></result>
        <result column="createtime" property="createTime"></result>
        <result column="note" property="note"></result>
        <!--一对一的关系   user 对应的是类型中的对象名称-->
        <!--延迟加载查找订单信息如果你需要进行查找程序调用select queryUserById调用的statementId查询结果
        select *from user where id =orders.user_id

        select后面的值如果再同一个namespace中那么直接写名字即可
        如果不在同一namespace中那么需要把namespace的名字也写上
        -->
        <association property="user" javaType="User" select="com.zhoujk.mapper.UserMapper.queryUserById"
                     column="user_id">
        </association>
        <!-- 实现对用户信息进行延迟加载 -->
    </resultMap>
    
        <select id="queryOrdersListByUserLazyLoading" resultMap="queryOrdersListByUserLazyLoadingResultMap">
        select *
        from orders
    </select>
```

`resultMap` 元素有很多子元素和一个值得深入探讨的结构。 下面是`resultMap` 元素的概念视图。

**结果映射（resultMap）**

* `constructor` - 用于在实例化类时，注入结果到构造方法中
  * `idArg` - ID 参数；标记出作为 ID 的结果可以帮助提高整体性能
  * `arg` - 将被注入到构造方法的一个普通结果
* `id` – 一个 ID 结果；标记出作为 ID 的结果可以帮助提高整体性能
* `result` – 注入到字段或 JavaBean 属性的普通结果
* `association` – 一个复杂类型的关联；许多结果将包装成这种类型
  * 嵌套结果映射 – 关联可以是 `resultMap` 元素，或是对其它结果映射的引用
* `collection` – 一个复杂类型的集合
  * 嵌套结果映射 – 集合可以是 `resultMap` 元素，或是对其它结果映射的引用
* `discriminator` – 使用结果值来决定使用哪个 `resultMap`
  * `case` – 基于某些值的结果映射
    * 嵌套结果映射 – `case` 也是一个结果映射，因此具有相同的结构和元素；或者引用其它的结果映射

| ResultMap 的属性列表 |  |
| :--- | :--- |
| 属性 | 描述 |
| `id` | 当前命名空间中的一个唯一标识，用于标识一个结果映射。 |
| `type` | 类的完全限定名, 或者一个类型别名（关于内置的类型别名，可以参考上面的表格）。 |
| `autoMapping` | 如果设置这个属性，MyBatis 将会为本结果映射开启或者关闭自动映射。 这个属性会覆盖全局的属性 autoMappingBehavior。默认值：未设置（unset）。 |

最佳实践 最好逐步建立结果映射。单元测试可以在这个过程中起到很大帮助。 如果你尝试一次性创建像上面示例那么巨大的结果映射，不仅容易出错，难度也会直线上升。 所以，从最简单的形态开始，逐步迭代。而且别忘了单元测试！ 有时候，框架的行为像是一个黑盒子（无论是否开源）。因此，为了确保实现的行为与你的期望相一致，最好编写**单元测试**。 并且单元测试在提交 bug 时也能起到很大的作用。

### 单元测试（以Junit4为例）

### Junit4使用配置

```text
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.12</version>
        </dependency>
```

在这里推荐使用插件**JunitGenerator V2.0**,使用该插件后有几点配置注意事项Properties：

![&#x914D;&#x7F6E;&#x9875;&#x9762;](../.gitbook/assets/image%20%284%29.png)

1. default template : Junit4
2. Output Path要修改为:

```text
${SOURCEPATH}/../../test/java/${PACKAGE}/${FILENAME}
```

 最后，我的个人习惯是将Junit4生成的模板修改为

```text

// package test.$entry.packageName; 
// 去掉test.
package $entry.packageName;
```

使用很简单！ So easy!

补充说明：[Junit5配置使用教程](https://tonydeng.github.io/2017/10/09/junit-5-tutorial-introduction/)

#### 参考文章

[Junit4使用教程](https://juejin.cn/post/6844903791494447112)

