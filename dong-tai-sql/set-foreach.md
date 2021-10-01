---
description: set 元素可以用于动态包含需要更新的列，忽略其它不更新的列;foreach对集合进行遍历（尤其是在构建 IN 条件语句的时候）
---

# set、foreach

场景1:通过set的方式更新用户信息

1、定义接口

```text
    /**
     *  根据用户修改的用户对象信息去更新用户，判断是否更新成功
     * @param userPOJO  用户对象信息
     * @return  是否更新成功
     */
    boolean updateUserBySet(UserPOJO userPOJO);
```

2、编写mapper

```text
    <update id="updateUserBySet" parameterType="UserPOJO">
        update user1
        <set>
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
        </set>
        where userid=#{id}
    </update>
```

3、测试

```text
    @Test
    public void updateUserBySet()
    {
        UserPOJO userPOJO = new UserPOJO();
        userPOJO.setId(1);
        userPOJO.setUsername("蔡需昆");
        userPOJO.setPassword("123456");
        userPOJO.setuserHobby("唱，跳，rap,篮球");
        userPOJO.setRemark("练习生");
        boolean flag = userMapper.updateUserBySet(userPOJO);
        System.out.println(flag);
    }

```

场景2：按照多个id查询用户信息

1、定义接口

```text
    /**
     *  根据ID数组查询用户信息列表
     * @param Ids  多个用户的ID
     * @return   用户信息列表
     *  使用Mybatis的foreach
     */
    List<UserVO> selectUserListByIds(@Param("Ids") Integer[] Ids);
```

2、编写mapper

```text
    <!--select * from  table where column  in  (1,2,3,4,5)-->
    <select id="selectUserListByIds" resultMap="UserVO1ResultMap" parameterType="Integer[]">
        select
        <include refid="sqlCommon.sqlColumnComm"></include>
        from user1
        where userid in
        <foreach collection="Ids" item="id" open="(" separator="," close=")">
            #{id}
        </foreach>
    </select>

```

3、测试

```text
    @Test
    public void selectUserListByIds()
    {   
        Integer[] Ids  = {1,4,3,4,5,1,7};
        List<UserVO> userVOList = userMapper.selectUserListByIds(Ids);
        for (UserVO vo : userVOList) {
            System.out.println(vo);
        }
    }
```

foreach 元素的功能非常强大，它允许你指定一个集合，声明可以在元素体内使用的集合项（item）和索引（index）变量。它也允许你指定开头与结尾的字符串以及集合项迭代之间的分隔符。这个元素也不会错误地添加多余的分隔符，看它多智能！

提示 你可以将任何可迭代对象（如 List、Set 等）、Map 对象或者数组对象作为集合参数传递给 foreach。当使用可迭代对象或者数组时，index 是当前迭代的序号，item 的值是本次迭代获取到的元素。当使用 Map 对象（或者 Map.Entry 对象的集合）时，index 是键，item 是值。

