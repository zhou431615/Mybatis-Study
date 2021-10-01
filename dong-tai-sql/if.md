# If

动态 SQL 是 MyBatis 的强大特性之一。如果你使用过 JDBC 或其它类似的框架，你应该能理解根据不同条件拼接 SQL 语句有多痛苦，例如拼接时要确保不能忘记添加必要的空格，还要注意去掉列表最后一个列名的逗号。利用动态 SQL，可以彻底摆脱这种痛苦。

使用动态 SQL 并非一件易事，但借助可用于任何 SQL 映射语句中的强大的动态 SQL 语言，MyBatis 显著地提升了这一特性的易用性。

如果你之前用过 JSTL 或任何基于类 XML 语言的文本处理器，你对动态 SQL 元素可能会感觉似曾相识。在 MyBatis 之前的版本中，需要花时间了解大量的元素。借助功能强大的基于 OGNL 的表达式，MyBatis 3 替换了之前的大部分元素，大大精简了元素种类，现在要学习的元素种类比原来的一半还要少。

* if
* choose \(when, otherwise\)
* trim \(where, set\)
* foreach

### If

实现按照输入姓名模糊查询案例

1、定义接口

```text
    /**
     * 查询男性会员  如果姓名不为空  则按照姓名进行模糊筛选
     * 按照用户名称和性别 模糊查询 包含某个字符串的用户信息
     * mybatis中 如果含有多个参数列表  建议使用对象传值
     *
     * 使用Mybatis的动态SQL的if
     * @param username 用户名称
     * @param sex      性别
     * @param age      年龄
     * @return 用户信息列表
     */
    List<UserVO> selectUserListBySexAndNameLike(@Param("sex") String sex, @Param("username") String username, @Param("age") int age);

```

2、编写mapper

```text
    <select id="selectUserListBySexAndNameLike" resultMap="UserVO1ResultMap" parameterType="String">
        select
        <include refid="sqlCommon.sqlColumnComm"></include>
        from user1
        where usersex = #{sex}
        <if test="username!=null and username.trim()!=null">
            and username like "%"#{username}"%"
        </if>
        <if test="age!=0">
            and userage=#{age}
        </if>
    </select>
```

3、测试

```text
    @Test
    public void selectUserListBySexAndNameLike()
    {
        List<UserVO> userVOList = userMapper.selectUserListBySexAndNameLike("男", "三", 23);
        for (UserVO vo : userVOList) {
            System.out.println(vo);
        }
    }

```

