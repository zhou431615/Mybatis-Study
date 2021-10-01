---
description: 关于db.properties的各种配置
---

# db.properties

注意：如果，属性不止在一个地方进行配置，则 MyBatis 将按照下面的顺序\(优先级\)来加载属性：

* 在`properties`元素体内定义的属性首先被读取。
* 然后会读取`properties`元素中resource或url加载的属性，它会覆盖已读取的同名属性。
* 最后读取`parameterType`传递的属性，它会覆盖已读取的同名属性。

**因此，通过方法参数传递的属性具有最高优先级，resource/url属性中的指定的配置文件此致，最低优先级的是properties属性中制定的属性。**

建议：

* 不要在`properties`元素体内添加任何属性值，只将属性值定义在properties文件中。
* 在properties文件中定义属性名要有一定的特殊性，如：XXXXX.XXXXX.XXXX

```text
# 适用于8.0+版本Mysql的数据库连接配置
mysql.driver=com.mysql.cj.jdbc.Driver
mysql.url=jdbc:mysql://localhost:3306/user?characterEncoding=utf-8&serverTimezone=GMT%2B8
mysql.username=root
mysql.password=123456
```

```text
# 适用于5.0+版本Mysql的数据库连接配置
mysql.driver=com.mysql.jdbc.Driver
mysql.url=jdbc:mysql://localhost:3306/user?characterEncoding=utf-8&serverTimezone=GMT%2B8
mysql.username=root
mysql.password=123456
```

```text
# JDBC jar包位置，使用MybatisGenerator时用到
db.driverLocation=D:\apache-maven-3.8.2\maven-repository\mysql\mysql-connector-java\8.0.26\mysql-connector-java-8.0.26.jar
db.driverClassName=com.mysql.cj.jdbc.Driver
db.url=jdbc:mysql://localhost:3306/test?characterEncoding=utf-8&serverTimezone=GMT%2B8
db.username=root
db.password=123456
db.initialSize = 20
db.maxActive = 50
db.maxIdle = 20
db.minIdle = 10
db.maxWait = 10
db.defaultAutoCommit = true
db.minEvictableIdleTimeMillis = 3600000
```

```text
#database.properties
mysql.driver=com.mysql.cj.jdbc.Driver
mysql.url=jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf-8
mysql.user=root
mysql.password=123456
#连接池当前最大允许连接的空闲连接数
mysql.minIdle=45
mysql.maxIdle=50
#初始创建的连接个数
mysql.initialSize=5
#最大并发活动连接数
mysql.maxActive=100
#最大等待时间
mysql.maxWait=100
#无用连接回收机制
mysql.removeAbandoned=true
mysql.removeAbandonedTimeout=180
```

适用于Oracle数据库连接配置

```text
#  一定要填写正确的服务名
jdbc.driverClassName=oracle.jdbc.driver.OracleDriver
jdbc.url=jdbc\:oracle\:thin\:@localhost\:1521\:orcl
jdbc.username=sytem
jdbc.password=123456
jdbc.initialPoolSize=20
jdbc.maxPoolSize=100
jdbc.minPoolSize=10
jdbc.maxIdleTime=600
jdbc.acquireIncrement=5
jdbc.maxStatements=5
jdbc.idleConnectionTestPeriod=60
```

## 拓展

c3p0-config.xml

```text
<?xml version="1.0"  encoding="utf-8"?>
<c3p0-config>
<!--默认数据库连接配置-->
    <default-config>
        <property name="user">root</property>
        <property name="password">123456</property>
        <property name="jdbcUrl">jdbc:mysql://localhost:3306/test?characterEncoding=UTF-8&amp;useUnicode=true</property>
        <property name="driverClass">com.mysql.jdbc.Driver</property>
        <property name="checkoutTimeout">30000</property>
        <property name="initialPoolSize">15</property>
        <property name="maxPoolSize">50</property>
        <property name="minPoolSize">10</property>
        <property name="acquireIncrement">5</property>
    </default-config>
<!--    mysql数据库自定义连接配置-->
    <named-config name="mysqlConn1">
        <property name="user">root</property>
        <property name="password">123456</property>
        <property name="jdbcUrl">jdbc:mysql://localhost:3306/book?characterEncoding=UTF-8&amp;useUnicode=true</property>
        <property name="driverClass">com.mysql.cj.jdbc.Driver</property>
        <!-- 如果池中数据连接不够时一次增长多少个 -->
        <property name="acquireIncrement">5</property>
        <!-- 初始化数据库连接池时连接的数量 -->
        <property name="initialPoolSize">20</property>
        <!-- 数据库连接池中的最大的数据库连接数 -->
        <property name="maxPoolSize">25</property>
        <!-- 数据库连接池中的最小的数据库连接数 -->
        <property name="minPoolSize">5</property>
    </named-config>
<!--    Oracle数据库自定义连接配置-->
<named-config  name="OracleConn1">
    <property name="driverClass">oracle.jdbc.driver.OracleDriver</property>
    <property name="jdbcUrl">jdbc:oracle:thin:@localhost:ORCL</property>
    <property name="user">xiaobaicai</property>
    <property name="password">123456</property>
    <property name="initialPoolSize">10</property>
    <property name="maxIdleTime">30</property>
    <property name="maxPoolSize">100</property>
    <property name="minPoolSize">10</property>
    <property name="maxStatements">200</property>
</named-config>

</c3p0-config>
```

Spring中的万能读取方式

```text
<!-- 数据源配置信息 -->
    <bean id="propertyConfigurer"
        class="org.springframework.beans.factory.config.PropertyPlaceholderConfigurer">
        <property name="location" value="classpath:jdbc.properties" />
    </bean>
    <!-- 配置数据源 -->
    <bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource">
        <!-- 指定连接数据库的驱动-->  
        <property name="driverClass" value="${jdbc.driverClassName}"/>  
        <!-- 指定连接数据库的URL-->  
        <property name="jdbcUrl" value="${jdbc.url}"/>  
        <!-- 指定连接数据库的用户名-->  
        <property name="user" value="${jdbc.username}"/>  
        <!-- 指定连接数据库的密码-->  
        <property name="password" value="${jdbc.password}"/>  
        <!-- 指定连接池中保留的最大连接数. Default:15-->  
        <property name="maxPoolSize" value="${jdbc.maxPoolSize}"/>  
        <!-- 指定连接池中保留的最小连接数-->  
        <property name="minPoolSize" value="${jdbc.minPoolSize}"/>  
        <!-- 指定连接池的初始化连接数  取值应在minPoolSize 与 maxPoolSize 之间.Default:3-->  
        <property name="initialPoolSize" value="${jdbc.initialPoolSize}"/>  
        <!-- 最大空闲时间,60秒内未使用则连接被丢弃。若为0则永不丢弃。 Default:0-->  
        <property name="maxIdleTime" value="${jdbc.maxIdleTime}"/>  
        <!-- 当连接池中的连接耗尽的时候c3p0一次同时获取的连接数. Default:3-->  
        <property name="acquireIncrement" value="${jdbc.acquireIncrement}"/>  
        <!-- JDBC的标准,用以控制数据源内加载的PreparedStatements数量。  
        但由于预缓存的statements属于单个connection而不是整个连接池所以设置这个参数需要考虑到多方面的因数.如果maxStatements与maxStatementsPerConnection均为0,则缓存被关闭。Default:0-->  
        <property name="maxStatements" value="${jdbc.maxStatements}"/>  
        <!-- 每60秒检查所有连接池中的空闲连接.Default:0 -->  
        <property name="idleConnectionTestPeriod" value="${jdbc.idleConnectionTestPeriod}"/>  
    </bean>

<!-- 配置SessionFactory -->
    <bean id="sessionFactory"
        class="org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean">
        <!-- 引用连接池 -->
        <property name="dataSource">
            <ref bean="dataSource" />
        </property>
        <!-- 配置Hibernate的行为 -->
        <property name="hibernateProperties">
            <props>
                <!-- 方言 -->
                <prop key="hibernate.dialect">
                    org.hibernate.dialect.Oracle10gDialect
                </prop>
                <!-- 是否显示SQL语句 -->
                <prop key="hibernate.show_sql">true</prop>
                <!-- 是否格式化SQL语句 -->
                <prop key="hibernate.format_sql">true</prop>
                <!-- 配置本地JDBC事务 -->
                <prop key="hibernate.current_session_context_class">thread</prop>
            </props>
        </property>
    </bean>
```

