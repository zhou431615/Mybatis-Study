# Ⅴ

### 二十三、Mybatis 的一级缓存和二级缓存:

1. 一级缓存: 基于 PerpetualCache 的 HashMap 本地缓存，其存储作用域为   Session，当 Session flush 或 close 之后，该 Session 中的所有 Cache 就   将清空，默认打开一级缓存。
2. 二级缓存与一级缓存其机制相同，默认也是采用PerpetualCache，HashMap   存储，不同在于其存储作用域为 Mapper\(Namespace\)，并且可自定义存储源，   如 Ehcache。默认不打开二级缓存，要开启二级缓存，使用二级缓存属性类需要   实现 Serializable 序列化接口\(可用来保存对象的状态\),可在它的映射文件中配置   &lt;cache/&gt; 
3. 对于缓存数据更新机制，当某一个作用域\(一级缓存 Session/二级缓存   Namespaces\)的进行了 C/U/D 操作后，默认该作用域下所有 select 中的缓存将

   被 clear。

### 二十四、什么是 MyBatis 的接口绑定？有哪些实现方式？

接口绑定，就是在 MyBatis 中任意定义接口,然后把接口里面的方法和 SQL 语句绑 定, 我们直接调用接口方法就可以,这样比起原来了 SqlSession 提供的方法我们可 以有更加灵活的选择和设置。

 接口绑定有两种实现方式,一种是通过注解绑定，就是在接口的方法上面加上 @Select、@Update 等注解，里面包含 Sql 语句来绑定；另外一种就是通过 xml 里面写 SQL 来绑定, 在这种情况下,要指定 xml 映射文件里面的 namespace 必须 为接口的全路径名。当 Sql 语句比较简单时候,用注解绑定, 当 SQL 语句比较复杂 时候,用 xml 绑定,一般用 xml 绑定的比较多。

### 二十五、、使用 MyBatis 的 mapper 接口调用时有哪些要求？

1. Mapper 接口方法名和 mapper.xml 中定义的每个 sql 的 id 相同；
2. Mapper 接口方法的输入参数类型和 mapper.xml 中定义的每个 sql 的 parameterType 的类型相同；
3. Mapper 接口方法的输出参数类型和 mapper.xml 中定义的每个 sql 的 resultType 的类型相同；
4.  Mapper.xml 文件中的 namespace 即是 mapper 接口的类路径。

### 二十六、Mapper 编写有哪几种方式？

第一种：接口实现类继承 SqlSessionDaoSupport：使用此种方法需要编写 mapper 接口，mapper 接口实现类、mapper.xml 文件。 

1、在 sqlMapConfig.xml 中配置 mapper.xml 的位置:

```text
<mappers>
<mapper resource="mapper.xml 文件的地址" />
<mapper resource="mapper.xml 文件的地址" />
</mappers>
```

2、定义 mapper 接口 

3、实现类集成 SqlSessionDaoSupport mapper 方法中可以 this.getSqlSession\(\)进行数据增删改查。

 4、spring 配置

```text
<bean id=" " class="mapper 接口的实现">
<property name="sqlSessionFactory"
ref="sqlSessionFactory"></property>
</bean>
```

第二种：使用 org.mybatis.spring.mapper.MapperFactoryBean：

 1、在 sqlMapConfig.xml 中配置 mapper.xml 的位置，如果 mapper.xml 和 mappre 接口的名称相同且在同一个目录，这里可以不用配置

```text
<mappers>
<mapper resource="mapper.xml 文件的地址" />
<mapper resource="mapper.xml 文件的地址" />
</mappers>
```

2、定义 mapper 接口

3、mapper.xml 中的 namespace 为 mapper 接口的地址 

4、mapper 接口中的方法名和 mapper.xml 中的定义的 statement 的 id 保持一 致 

5、Spring 中定义

```text
<bean id="" class="org.mybatis.spring.mapper.MapperFactoryBean">
<property name="mapperInterface" value="mapper 接口地址" />
<property name="sqlSessionFactory" ref="sqlSessionFactory" />
</bean>
```

第三种：使用 mapper 扫描器： 

1、mapper.xml 文件编写： 

mapper.xml 中的 namespace 为 mapper 接口的地址； mapper 接口中的方法名和 mapper.xml 中的定义的 statement 的 id 保持一致； 如果将 mapper.xml 和 mapper 接口的名称保持一致则不用在 sqlMapConfig.xml 中进行配置。 

2、定义 mapper 接口：

 注意 mapper.xml 的文件名和 mapper 的接口名称保持一致，且放在同一个目录 

3、配置 mapper 扫描器：

```text
<bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
<property name="basePackage" value="mapper 接口包地址
"></property>
<property name="sqlSessionFactoryBeanName"
value="sqlSessionFactory"/>
</bean>
```

4、使用扫描器后从 spring 容器中获取 mapper 的实现对象。

###  二十七、简述 Mybatis 的插件运行原理，以及如何编写一个插件。

 答：

Mybatis 仅可以编写针对 ParameterHandler、ResultSetHandler、 StatementHandler、Executor 这 4 种接口的插件，Mybatis 使用 JDK 的动态代 理，为需要拦截的接口生成代理对象以实现接口方法拦截功能，每当执行这 4 种 接口对象的方法时，就会进入拦截方法，具体就是 InvocationHandler 的 invoke\(\) 方法，当然，只会拦截那些你指定需要拦截的方法。 

编写插件：实现 Mybatis 的 Interceptor 接口并复写 intercept\(\)方法，然后在给 插件编写注解，指定要拦截哪一个接口的哪些方法即可，记住，别忘了在配置文 件中配置你编写的插件。

### 



