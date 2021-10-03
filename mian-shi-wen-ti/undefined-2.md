# Ⅲ

### 十三、如何获取自动生成的\(主\)键值?

insert 方法总是返回一个 int 值 ，这个值代表的是插入的行数。

如果采用自增长策略，自动生成的键值在 insert 方法执行完后可以被设置到传入的参数对象中。示例如下：

```text
<insert id=”insertname” usegeneratedkeys=”true” keyproperty=”
id”>
insert into names (name) values (#{name})
</insert>
name name = new name();
name.setname(“fred”);
int rows = mapper.insertname(name);
// 完成后,id 已经被设置到对象中
system.out.println(“rows inserted = ” + rows);
system.out.println(“generated key value = ” + name.getid());
```

### 十四、在 mapper 中如何传递多个参数？

1、第一种：

DAO 层的函数

```text
/**public UserselectUser(String name,String area);
对应的 xml,#{0}代表接收的是 dao 层中的第一个参数，#{1}代表 dao 层中第二
参数，更多参数一致往后加即可。*/
<select id="selectUser"resultMap="BaseResultMap">
select * fromuser_user_t whereuser_name = #{0}
anduser_area=#{1}
</select>
```

2、第二种： 使用 @param 注解:

```text
public interface usermapper {
user selectuser(@param(“username”) string
username,@param(“hashedpassword”) string hashedpassword);
}
```

然后,就可以在 xml 像下面这样使用\(推荐封装为一个 map,作为单个参数传递给mapper\):

```text
<select id=”selectuser” resulttype=”user”>
select id, username, hashedpassword
from some_table
where username = #{username}
and hashedpassword = #{hashedpassword}
</select>
```

3、第三种：多个参数封装成 map

```text
try {
//映射文件的命名空间.SQL 片段的 ID，就可以调用对应的映射文件中的
SQL
//由于我们的参数超过了两个，而方法中只有一个 Object 参数收集，因此
我们使用 Map 集合来装载我们的参数
Map < String, Object > map = new HashMap();
map.put("start", start);
map.put("end", end);
return sqlSession.selectList("StudentID.pagination", map);
} catch (Exception e) {
e.printStackTrace();
sqlSession.rollback();
throw e;
} finally {
MybatisUtil.closeSqlSession();
}
```

### 十五、Mybatis 动态 sql 有什么用？执行原理？有哪些动态 sql？

Mybatis 动态 sql 可以在 Xml 映射文件内，以标签的形式编写动态 sql，执行原理是根据表达式的值 完成逻辑判断并动态拼接 sql 的功能。

Mybatis 提供了 9 种动态 sql 标签：trim \| where \| set \| foreach \| if \| choose\| when \| otherwise \| bind。

### 十六、Xml 映射文件中，除了常见select\|insert\|updae\|delete标签之外，还有哪些标签？

答:&lt;resultMap&gt;、&lt;parameterMap&gt;、&lt;sql&gt;、&lt;include&gt;、&lt;selectKey&gt;，加上动态 sql 的 9 个标签，其中&lt;sql&gt;为 sql 片段标签，通过&lt;include&gt;标签引入 sql 片段，&lt;selectKey&gt;为不支持自增的主键生成策略标签。

### 十七、Mybatis 的 Xml 映射文件中，不同的 Xml 映射文件，id 是否可以重复？ 

不同的 Xml 映射文件，如果配置了 namespace，那么 id 可以重复；如果没有配 置 namespace，那么 id 不能重复；

 原因就是 namespace+id 是作为 Map的 key 使用的，如果没有 namespace，就剩下 id，那么，id 重复会导致数据互相覆盖。 有了 namespace，自然 id 就可以重复，namespace 不同，namespace+id 自然 也就不同。

