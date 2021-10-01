# choose \(when, otherwise\)

场景：查询男性用户，如果输入了姓名则按照姓名模糊查找，否则如果输入了年龄则按照年龄查找，否则查找姓名为"张三"的用户。

1、定义接口

```text
 /**
     * 查询男性用户，如果输入了姓名则按照姓名模糊查找，
     * 否则如果输入了年龄则按照年龄查找，否则查找姓名为"张三"的用户。
     *
     * @param username 用户名称
     * @param age      年龄
     * @return 用户信息列表
     */

    List<UserVO> selectUserListByNameAndAge(@Param("username") String username, @Param("age") Integer age);
```

2、编写mapper

```text
    <!--按照姓名和年龄查询，如果没有填入信息，就直接按照张三查询-->
    <select id="selectUserListByNameAndAge" resultMap="UserVO1ResultMap">
        select *
        from user1
        where usersex = '男'
        <choose>
            <when test="username!=null and username.trim()!=''">
                and username=#{username}
            </when>
            <when test="age!=null">
                and userage=#{age}
            </when>
            <otherwise>
                and username='张三'
            </otherwise>
        </choose>
    </select>

```

3、测试

```text
    @Test
    public void selectUserListByNameAndAge()
    {
        List<UserVO> userVOList = userMapper.selectUserListByNameAndAge(null, null);
        for (UserVO vo : userVOList) {
            System.out.println(vo);
        }
        System.out.println("有结果");
    }
```

