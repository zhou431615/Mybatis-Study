## Mybatis开发学习笔记

### mybatis-config.xml配置

```xml
<?xml version="1.0" encoding="UTF8"?>
<!DOCTYPE configuration PUBLIC
        "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<!--configuration核心配置文件-->
<configuration>
    <!--加载类路径下的属性文件-->
    <properties resource="db.properties"/>
    <!-- 设置一个默认的连接环境信息-->
    <environments default="Mysql8.0_development">
        <!-- 连接环境信息  取一个任意的唯一名字-->
        <environment id="Mysql8.0_development">
            <!-- mybatis使用jdbc事务管理方式 -->
            <transactionManager type="JDBC"/>
            <!--mybatis使用连接池的方式来获取连接-->
            <dataSource type="POOLED">
                <!--配置与数据库交互的4必要属性-->
                <property name="driver" value="${mysql.driver}"/>
                <property name="url"  value="${mysql.url}"/>
                <property name="username" value="${mysql.username}"/>
                <property name="password" value="${mysql.password}"/>
            </dataSource>
        </environment>

        <!-- 再配置一个(可配置多个)连接环境信息  取一个任意的唯一名字-->
        <environment id="Oracle_development">
            <!-- mybatis使用jdbc事务管理方式 -->
            <transactionManager type="JDBC"/>
            <!--mybatis使用连接池的方式来获取连接-->
            <dataSource type="POOLED">
                <!--配置与数据库交互的4必要属性-->
                <property name="driver" value="${oracle.driver}"/>
                <property name="url"  value="${oracle.url}"/>
                <property name="username" value="${oracle.username}"/>
                <property name="password" value="${oracle.password}"/>
            </dataSource>
        </environment>
    </environments>
    <!--每一个Mapper.xml都需要在Mybatis的核心配置文件中注册-->
    <mappers>
        <mapper resource="Mapper/UserMapper.xml"/>
    </mappers>
</configuration>
```

### 关于db.properties的各种配置

```properties
# 适用于8.0+版本Mysql的数据库连接配置
mysql.driver=com.mysql.cj.jdbc.Driver
mysql.url=jdbc:mysql://localhost:3306/user?characterEncoding=utf-8&serverTimezone=GMT%2B8
mysql.username=root
mysql.password=123456
```


```properties
# 适用于5.0+版本Mysql的数据库连接配置
mysql.driver=com.mysql.jdbc.Driver
mysql.url=jdbc:mysql://localhost:3306/user?characterEncoding=utf-8&serverTimezone=GMT%2B8
mysql.username=root
```


```properties
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

```properties
#database.properties
driver=com.mysql.cj.jdbc.Driver
url=jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf-8
user=root
password=123456
#连接池当前最大允许连接的空闲连接数
minIdle=45
maxIdle=50
#初始创建的连接个数
initialSize=5
#最大并发活动连接数
maxActive=100
#最大等待时间
maxWait=100
#无用连接回收机制
removeAbandoned=true
removeAbandonedTimeout=180
```

适用于Oracle数据库连接配置

```properties
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


