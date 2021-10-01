---
description: 映射器
---

# Mapper.xml文件详解

MyBatis 的真正强大在于它的语句映射，这是它的魔力所在。由于它的异常强大，映射器的 XML 文件就显得相对简单。如果拿它跟具有相同功能的 JDBC 代码进行对比，你会立即发现省掉了将近 95% 的代码。MyBatis 致力于减少使用成本，让用户能更专注于 SQL 代码。

SQL 映射文件只有很少的几个顶级元素（按照应被定义的顺序列出）：

* `cache` – 该命名空间的缓存配置。
* `cache-ref` – 引用其它命名空间的缓存配置。
* `resultMap` – 描述如何从数据库结果集中加载对象，是最复杂也是最强大的元素。
* ~~`parameterMap` – 老式风格的参数映射。此元素已被废弃，并可能在将来被移除！请使用行内参数映射。文档中不会介绍此元素。~~
* `sql` – 可被其它语句引用的可重用语句块。
* `insert` – 映射插入语句。
* `update` – 映射更新语句。
* `delete` – 映射删除语句。
* `select` – 映射查询语句。

### Select

select -书写查询sql语句select中的几个属性说明: 

* id属性:当前名称空间下的statement的唯一标识。必须。要求id和mapper接口中的方法的名字一致。
* resultType:将结果集映射为java的对象类型。
* 必须\(和resultMap二选一\) parameterType :传入参数类型。可以省略

### Insert

insert的几个属性说明: 

* id :唯一标识，随便写，在同一个命名空间下保持唯一，使用动态代理之后要求和方法名保持一致
* parameterType:参数的类型，使用动态代理之后和方法的参数类型一致
*  useGeneratedKeys:开启主键回写 
* keyColumn:指定数据库的主键 
* keyProperty:主键对应的pojo属性名
* 标签内部:具体的sql语句。

### Update

* id属性:当前名称空间下的statement的唯一标识\(必须属性\);
* parameterType:传入的参数类型，可以省略。
*  标签内部:具体的sql语句。

### Delete

delete的几个属性说明: 

* id属性:当前名称空间下的statement的唯一标识\(必须属性\);
* parameterType:传入的参数类型，可以省略。
*  标签内部:具体的sql语句。



_自动映射和缓存将在后面单独总结_





