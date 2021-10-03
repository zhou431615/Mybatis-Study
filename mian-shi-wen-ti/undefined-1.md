# Ⅱ

### 七、当实体类中的属性名和表中的字段名不一样 ，怎么办 ？

第 1 种： 通过在查询的 sql 语句中定义字段名的别名，让字段名的别名和实体类的属性名一致。

```text
<select id=”selectorder” parametertype=”int” resultetype=”
me.gacl.domain.order”>
select order_id id, order_no orderno ,order_price price form
orders where order_id=#{id};
</select>
```

第 2 种： 通过来映射字段名和实体类属性名的一一对应的关系。

```text
<select id="getOrder" parameterType="int"
resultMap="orderresultmap">
select * from orders where order_id=#{id}
</select>
<resultMap type=”me.gacl.domain.order” id=”orderresultmap”>
<!–用 id 属性来映射主键字段–>
<id property=”id” column=”order_id”>
<!–用 result 属性来映射非主键字段，property 为实体类属性名，column
为数据表中的属性–>
<result property = “orderno” column =”order_no”/>
<result property=”price” column=”order_price” />
</reslutMap>
```

### 八、 模糊查询 like 语句该怎么写?

第 1 种：在 Java 代码中添加 sql 通配符。

```text
string wildcardname = “%smi%”;
list<name> names = mapper.selectlike(wildcardname);

<select id=”selectlike”>
select * from foo where bar like #{value}
</select>
```

第 2 种：在 sql 语句中拼接通配符，会引起 sql 注入。

```text
string wildcardname = “smi”;
list<name> names = mapper.selectlike(wildcardname);
<select id=”selectlike”>
select * from foo where bar like "%"#{value}"%"
</select>
```

### 九、通常一个 Xml 映射文件，都会写一个 Dao 接口与之对应， 请问，这个 Dao 接口的工作原理是什么？Dao 接口里的方法， 参数不同时，方法能重载吗？

Dao 接口即 Mapper 接口。接口的全限名，就是映射文件中的 namespace 的值；接口的方法名，就是映射文件中 Mapper 的 Statement 的 id 值；接口方法内的参数，就是传递给 sql 的参数。

Mapper 接口是没有实现类的，当调用接口方法时，接口全限名+方法名拼接字符串作为 key 值，可唯一定位一个 MapperStatement。在 Mybatis 中，每一个&lt;select&gt;、&lt;insert&gt;、&lt;update&gt;、&lt;delete&gt;标签，都会被解析为一个MapperStatement 对象。

举例：com.mybatis3.mappers.StudentDao.findStudentById，可以唯一找到 namespace 为 com.mybatis3.mappers.StudentDao 下面 id 为findStudentById 的 MapperStatement。

Mapper 接口里的方法，是不能重载的，因为是使用 全限名+方法名 的保存和寻找策略。Mapper 接口的工作原理是 JDK 动态代理，Mybatis 运行时会使用 JDK动态代理为 Mapper 接口生成代理对象 proxy，代理对象会拦截接口方法，转而执行 MapperStatement 所代表的 sql，然后将 sql 执行结果返回。

### 十、Mybatis 是如何进行分页的？分页插件的原理是什么?

Mybatis 使用 RowBounds 对象进行分页，它是针对 ResultSet 结果集执行的内 存分页，而非物理分页。可以在 sql 内直接书写带有物理分页的参数来完成物理分 页功能，也可以使用分页插件来完成物理分页。 

分页插件的基本原理是使用 Mybatis 提供的插件接口，实现自定义插件，在插件 的拦截方法内拦截待执行的 sql，然后重写 sql，根据 dialect 方言，添加对应的物 理分页语句和物理分页参数。

### 十一、Mybatis是如何将sql执行结果封装为目标对象并返回的？都有哪些映射形式？

第一种是使用&lt;resultMap&gt;标签，逐一定义数据库列名和对象属性名之间的映射关系。

第二种是使用 sql 列的别名功能，将列的别名书写为对象属性名。

有了列名与属性名的映射关系后，Mybatis 通过反射创建对象，同时使用反射给对象的属性逐一赋值并返回，那些找不到映射关系的属性，是无法完成赋值的。

### 十二、如何执行批量插入?

首先,创建一个简单的 insert 语句:

```text
<insert id=”insertname”>
insert into names (name) values (#{value})
</insert>
```

然后在 java 代码中像下面这样执行批处理插入:

```text
        list < string > names = new arraylist();
        names.add(“fred”);
        names.add(“barney”);
        names.add(“betty”);
        names.add(“wilma”);
        // 注意这里 executortype.batch
        sqlsession sqlsession =
                sqlsessionfactory.opensession(executortype.batch);
        try {
            namemapper mapper = sqlsession.getmapper(namemapper.class);
            for (string name: names) {
                mapper.insertname(name);
            }
            sqlsession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
            throw e;
        }
        finally {
            sqlsession.close();
        }
```



