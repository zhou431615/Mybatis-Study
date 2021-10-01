---
description: 简单介绍Mybatis
---

# 概述

##  Mybatis简介

MyBatis 本是apache的一个开源项目iBatis, 2010年这个项目由apache software foundation 迁移到了google code，并且改名为MyBatis。是一个基于Java的持久层框架。

*  持久层： 可以将业务数据存储到磁盘，具备长期存储能力，只要磁盘不损坏，在断电或者其他情况下，重新开启系统仍然可以读取到这些数据。
*  **优点： 可以使用巨大的磁盘空间存储相当量的数据，并且很廉价**
*  缺点：慢（相对于内存而言）

![Mybatis](.gitbook/assets/image%20%285%29.png)

## 为什么要使用Mybatis

在我们**传统的 JDBC** 中，我们除了需要自己提供 SQL 外，还必须操作 Connection、Statment、ResultSet，不仅如此，为了访问不同的表，不同字段的数据，我们需要些很多雷同模板化的代码，显的繁琐又枯燥。

 而我们在使用了 MyBatis 之后，**只需要提供 SQL 语句就好了**，其余的诸如：建立连接、操作 Statment、ResultSet，处理 JDBC 相关异常等等都可以交给 MyBatis 去处理，我们的关注点于是可以就此集中**在 SQL 语句上，关注在增删改查这些操作层面上**。

 并且 MyBatis 支持使用简单的 XML 或注解来配置和映射原生信息，将接口和 Java 的 POJOs\(Plain Old Java Objects,普通的 Java对象\)映射成数据库中的记录。

## 感谢

1. 老师的讲义
2. [https://mybatis.org/mybatis-3/zh/configuration.html](https://mybatis.org/mybatis-3/zh/configuration.html)
3. [https://github.com/brianway/springmvc-mybatis-learning](https://github.com/brianway/springmvc-mybatis-learning)

