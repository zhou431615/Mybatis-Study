---
description: 以IDEA创建项目为例说明
---

# 搭建Mybatis项目环境

## 利用Maven创建项目

![&#x9879;&#x76EE;&#x7684;&#x7ED3;&#x6784;&#x56FE;&#x4EE5;&#x53CA;&#x521B;&#x5EFA;&#x65B0;module](../.gitbook/assets/image%20%281%29.png)

## Pom.xml配置文件

```text
    <parent>
        <artifactId>Mybatis-Study</artifactId>
        <groupId>com.zjk.cn</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <artifactId>Mybatis01</artifactId>

    <properties>
        <maven.compiler.source>8</maven.compiler.source>
        <maven.compiler.target>8</maven.compiler.target>
    </properties>
    <dependencies>
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>3.4.2</version>
        </dependency>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.12</version>
        </dependency>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.21</version>
        </dependency>
        <!-- 添加oracle驱动依赖 -->
        <dependency>
            <groupId>com.oracle.database.jdbc</groupId>
            <artifactId>ojdbc8</artifactId>
            <version>12.2.0.1</version>
        </dependency>
```

