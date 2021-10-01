---
description: 可供sql语句复用
---

# Sql片段

在mybatis中通过使用SQL片段可以提高代码的重用性，如下情景：

```text
    <sql id="sqlColumnComm">
        userid,username,userpassword,userage, usersex, user_hobby,user_remark
    </sql>

```

例如，可以在UserMapper.xml中配置并使用。sql片段也可以定义在单独的.xml文件中 ，例如定义commSql.xml如下：

```text
<?xml version="1.0" encoding="UTF8"?>
<!DOCTYPE mapper PUBLIC
        "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="sqlCommon">
    <sql id="sqlColumnComm">
        userid,username,userpassword,userage, usersex, user_hobby,user_remark
    </sql>

</mapper>
```



使用Sql片段，情景如下：

```text
    <!--id statementId值  resultType返回值类型:UserVO-->
    <select id="selectUserById" resultMap="UserVO1ResultMap" parameterType="int">
        /*在这里使用了SQL片段*/
        select
        <include refid="sqlCommon.sqlColumnComm"></include>
        from user1
        where userid = #{id}
    </select>
```





