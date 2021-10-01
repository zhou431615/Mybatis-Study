---
description: >-
  全局配置参数，用来配置一些改变运行时行为的信息，例如是否使用缓存机制，是否使用延迟加载，是否使用错误处理机制等。并且可以设置最大并发请求数量、最大并发事务数量，以及是否启用命令空间等。
---

# Settings

setting 标签的配置是配置 MyBatis 框架运行时的一些行为的，例如缓存、延迟加载、结果集控制、执行器、分页设置、命名规则等一系列控制性参数，其所有的 setting 配置都放在父标签 settings 标签中。

![Setting&#x90E8;&#x5206;&#x5C5E;&#x6027;&#x8BF4;&#x660E;](../.gitbook/assets/image%20%283%29.png)

开启驼蜂匹配:完成经典的数据库命名到java属性的映射，经典数据库命名:如果多个单词之间，通常使用下划线进行连接.java中命名:第二个单词首字母大写。 **驼峰匹配:相当于去掉数据中的名字的下划线，和java进行匹配。**

总的来说，Settings属性中属性很多，就不一一列举，没必要完全记住。详情看官网。[https://mybatis.org/mybatis-3/zh/configuration.html\#settings](https://mybatis.org/mybatis-3/zh/configuration.html#settings)

一个配置完整的 settings 元素的示例如下：

```text
<settings>
  <!-- 全局性地开启或关闭所有映射器配置文件中已配置的任何缓存。-->
  <setting name="cacheEnabled" value="true"/>
  <!-- 延迟加载的全局开关。 -->
  <setting name="lazyLoadingEnabled" value="true"/>
  <!-- 是否允许单个语句返回多结果集（需要数据库驱动支持) -->
  <setting name="multipleResultSetsEnabled" value="true"/>
  <!-- 使用列标签代替列名 -->
  <setting name="useColumnLabel" value="true"/>
  <!-- 允许 JDBC 支持自动生成主键，需要数据库驱动支持 -->
  <setting name="useGeneratedKeys" value="false"/>
  <!-- 指定 MyBatis 应如何自动映射列到字段或属性-->
  <setting name="autoMappingBehavior" value="PARTIAL"/>
  <!-- 指定发现自动映射目标未知列（或未知属性类型）的行为 -->
  <setting name="autoMappingUnknownColumnBehavior" value="WARNING"/>
  <!-- 配置默认的执行器 -->
  <setting name="defaultExecutorType" value="SIMPLE"/>
  <!-- 设置超时时间，它决定数据库驱动等待数据库响应的秒数。-->
  <setting name="defaultStatementTimeout" value="25"/>
  <!-- 为驱动的结果集获取数量（fetchSize）设置一个建议值 -->
  <setting name="defaultFetchSize" value="100"/>
  <!-- 是否允许在嵌套语句中使用分页（RowBounds） -->
  <setting name="safeRowBoundsEnabled" value="false"/>
  <!-- 是否开启驼峰命名自动映射 -->
  <setting name="mapUnderscoreToCamelCase" value="false"/>
  <!-- MyBatis 利用本地缓存机制（Local Cache）防止循环引用和加速重复的嵌套查询 -->
  <setting name="localCacheScope" value="SESSION"/>
  <!-- 当没有为参数指定特定的 JDBC 类型时，空值的默认 JDBC 类型 -->
  <setting name="jdbcTypeForNull" value="OTHER"/>
  <!-- 指定对象的哪些方法触发一次延迟加载。 -->
  <setting name="lazyLoadTriggerMethods" value="equals,clone,hashCode,toString"/>
</settings>
```



