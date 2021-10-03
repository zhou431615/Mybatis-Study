# Ⅳ

### 十八、为什么说 Mybatis 是半自动 ORM 映射工具？它与全自动

Hibernate 属于全自动 ORM 映射工具，使用 Hibernate 查询关联对象或者关联

### 十九、一对一、一对多的关联查询 ？

```text
<mapper namespace="com.lcb.mapping.userMapper">
<!--association 一对一关联查询 -->
<select id="getClass" parameterType="int"
resultMap="ClassesResultMap">
select * from class c,teacher t where c.teacher_id=t.t_id and
c.c_id=#{id}
</select>
<resultMap type="com.lcb.user.Classes" id="ClassesResultMap">
<!-- 实体类的字段名和数据表的字段名映射 -->
<id property="id" column="c_id"/>
<result property="name" column="c_name"/>
<association property="teacher"
javaType="com.lcb.user.Teacher">
<id property="id" column="t_id"/>
<result property="name" column="t_name"/>
</association>
</resultMap>
<!--collection 一对多关联查询 -->
<select id="getClass2" parameterType="int"
resultMap="ClassesResultMap2">
select * from class c,teacher t,student s where c.teacher_id=t.t_id
and c.c_id=s.class_id and c.c_id=#{id}
</select>
<resultMap type="com.lcb.user.Classes" id="ClassesResultMap2">
<id property="id" column="c_id"/>
<result property="name" column="c_name"/>
<association property="teacher"
javaType="com.lcb.user.Teacher">
<id property="id" column="t_id"/>
<result property="name" column="t_name"/>
</association>
<collection property="student"
ofType="com.lcb.user.Student">
<id property="id" column="s_id"/>
<result property="name" column="s_name"/>
</collection>
</resultMap>
</mapper>
```

### 二十、MyBatis 实现一对一有几种方式?具体怎么操作的？

有联合查询和嵌套查询,联合查询是几个表联合查询,只查询一次, 通过在

嵌套查询是先查一个表，根据这个表里面的结果的 外键 id，去再另外一个表里面

### 二十一、MyBatis 实现一对多有几种方式,怎么操作的？

有联合查询和嵌套查询。联合查询是几个表联合查询,只查询一次,通过在

### 二十二、Mybatis 是否支持延迟加载？如果支持，它的实现原理是

答：Mybatis 仅支持 association 关联对象和 collection 关联集合对象的延迟加





### 
