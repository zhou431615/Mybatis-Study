---
description: trim裁剪字符串   prefix 前缀填充  suffixOverrides  后缀尾部覆盖prefixOverrides  头部覆盖
---

# trim关键字

1、定义接口

```text
    /**
     *  根据用户的输入更新用户信息
     * @param userPOJO 用户对象
     * @return   是否更新成功
     */
    boolean updateUser(UserPOJO userPOJO);
```

2、编写mapper

```text
    <!--根据用户输入更新用户信息-->
    <update id="updateUser" parameterType="UserPOJO">
        update user1
        <trim prefix="set" suffixOverrides=",">
            <if test="username!=null  and username.trim()!=''">
                username=#{username},
            </if>
            <if test="password!=null and password.trim()!=''">
                userpassword=#{password},
            </if>
            <if test="age!=null">
                userage=#{age},
            </if>
            <if test="sex!=null and  sex.trim()!=''">
                usersex=#{sex},
            </if>
            <if test="userHobby!=null and userHobby.trim()!=''">
                user_hobby=#{userHobby},
            </if>
            <if test="remark!=null  and  remark.trim()!=''">
                user_remark=#{remark},
            </if>
        </trim>
        where userid=#{id}
    </update>

```

3、测试

```text
    @Test
    public void updateUser()
    {
        UserPOJO userPOJO = new UserPOJO();
        userPOJO.setId(5);
        userPOJO.setuserHobby("睡觉，吃饭，打豆豆");
        boolean flag = userMapper.updateUser(userPOJO);
        System.out.println(flag);
    }

```

