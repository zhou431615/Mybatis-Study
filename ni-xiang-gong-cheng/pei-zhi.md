---
description: 推荐使用maven插件
---

# 配置

项目目录结构：

![Mybatis-generator](../.gitbook/assets/image%20%287%29.png)

其中，接口userMapper、UserMapper.xml、User类、UserWithBLOBS类为mybatis逆向工程生成的，其他的文件需要先进行配置。

需要在pom.xml进行，配置mybatsi-generator的插件，如下

其中，需要指明CponfigurationFile的存放位置，在 &lt;configurationFile&gt;${basedir}/src/main/resources/generator-config.xml&lt;/configurationFile&gt;此处,进行修改。

```text
   <build>
        <plugins>
            <plugin>
             <!--mybatis反向生成代码的插件配置-->
                <groupId>org.mybatis.generator</groupId>
                <artifactId>mybatis-generator-maven-plugin</artifactId>
                <version>1.4.0</version>
                <executions>
                    <execution>
                        <id>Generate MyBatis Artifacts</id>
                        <goals>
                            <goal>generate</goal>
                        </goals>
                    </execution>
                </executions>
                <configuration>
                    <!-- 输出详细信息 -->
                    <verbose>true</verbose>
                    <!-- 覆盖生成文件 -->
                    <overwrite>true</overwrite>
                    <!-- 定义配置文件 -->
                    <configurationFile>${basedir}/src/main/resources/generator-config.xml</configurationFile>
                </configuration>
            </plugin>
        </plugins>
    </build>
```

在配置generator-config.xml之前，配置用与数据库连接驱动的generator.properties文件。（当然，也可以直接在generator-config.xml中直接配置数据库驱动。但不推荐这样做!）

```text
# 8.0 Version+  用于mybatis.xml逆向工程使用
jdbc.driverLocation=D:/apache-maven-3.8.2/maven-repository/mysql/mysql-connector-java/8.0.26/mysql-connector-java-8.0.26.jar
jdbc.driverClass=com.mysql.cj.jdbc.Driver
jdbc.connectionURL=jdbc:mysql://localhost:3306/user?characterEncoding=utf-8&serverTimezone=GMT%2B8
jdbc.userId=root
jdbc.password=123456
jdbc.initialSize = 20
jdbc.maxActive = 50
jdbc.maxIdle = 20
jdbc.minIdle = 10
jdbc.maxWait = 10
jdbc.defaultAutoCommit = true
jdbc.minEvictableIdleTimeMillis = 3600000
```

最后，就可以配置generator-config.xml文件了。

```text
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE generatorConfiguration
        PUBLIC "-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN"
        "http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd">

<generatorConfiguration>
    <!--导入属性配置-->
    <properties resource="generator.properties"/>

    <!--指定特定数据库的jdbc驱动jar包的位置-->
    <classPathEntry location="${jdbc.driverLocation}"/>

    <context id="default" targetRuntime="MyBatis3">
        <!--        默认文件创建人-->
        <property name="createBy" value="zhoujk"/>
        <!-- lombok代替get/set方法-->
        <!-- <plugin type="org.mybatis.generator.custom.plugins.LombokPlugin"/>-->
        <!-- 实现序列化接口-->
        <plugin type="org.mybatis.generator.plugins.SerializablePlugin"/>
        <!-- 生成service和serviceImpl-->
        <!-- <plugin type="org.mybatis.generator.custom.plugins.ServicePlugin"/>-->

        <!-- optional，旨在创建class时，对注释进行控制 -->
        <commentGenerator>
            <property name="suppressDate" value="false"/>
            <property name="suppressAllComments" value="false"/>
        </commentGenerator>

        <!--jdbc的数据库连接 -->
        <jdbcConnection
                driverClass="${jdbc.driverClass}"
                connectionURL="${jdbc.connectionURL}"
                userId="${jdbc.userId}"
                password="${jdbc.password}">
            <property name="nullCatalogMeansCurrent" value="true"/>
        </jdbcConnection>


        <!--非必需，类型处理器，在数据库类型和java类型之间的转换控制-->
        <javaTypeResolver>
            <property name="forceBigDecimals" value="false"/>
        </javaTypeResolver>


        <!--生成java实体类-->
        <javaModelGenerator targetPackage="com.zhoujk.pojo"
                            targetProject="src/main/java">

            <!-- 是否允许子包，即targetPackage.schemaName.tableName -->
            <property name="enableSubPackages" value="false"/>
            <!-- 是否对model添加 构造函数 -->
            <property name="constructorBased" value="true"/>
            <!-- 是否对类CHAR类型的列的数据进行trim操作 -->
            <property name="trimStrings" value="true"/>
            <!-- 建立的Model对象是否 不可改变  即生成的Model对象不会有 setter方法，只有构造方法 -->
            <property name="immutable" value="false"/>
        </javaModelGenerator>

        <!--生成mapper接口文件-->
        <sqlMapGenerator targetPackage="com.zhoujk.mapper"
                         targetProject="src/main/java">
            <property name="enableSubPackages" value="false"/>
        </sqlMapGenerator>

        <!--生成mapper.xml文件,并指定存放位置-->
        <javaClientGenerator targetPackage="com.zhoujk.mapper"
                             targetProject="src/main/java" type="XMLMAPPER">
            <property name="enableSubPackages" value="true"/>
        </javaClientGenerator>

        <!--tableName:指定了表名 domainObjectName:指定了实体类的名称-->
        <!--
        <table tableName="emp" domainObjectName="Employee"
               enableCountByExample="false" enableUpdateByExample="false"
               enableDeleteByExample="false" enableSelectByExample="false"
               selectByExampleQueryId="false">
              区分大小写，与数据库保持一致
            <property name= "useActualColumnNames" value= "true"/>
        </table>
        -->

        <table tableName="user2"
               enableCountByExample="false"
               enableDeleteByExample="false"
               enableSelectByExample="false"
               enableUpdateByExample="false"
               domainObjectName="User"
               mapperName="UserMapper">
            <generatedKey column="id" sqlStatement="MySql"/>
        </table>

    </context>
</generatorConfiguration>
```

这是基本的设置。无论怎么设置，设置必须包含这7部分参数：

* classPathEntry 配置数据库驱动包位置
* commentGenerator下配置是否去掉注释
* jdbcConnection数据库链接URL、用户名、密码
* javaModelGenerator生成模型的包名和位置
* sqlMapGenerator生成映射文件包名和位置
* javaClientGenerator生成DAO的包名和位置
* table要生成哪些表

后面会详细介绍上面的参数内容。

### 参考文章（特别感谢）

[https://www.cnblogs.com/throwable/p/12046848.html](https://www.cnblogs.com/throwable/p/12046848.html)

