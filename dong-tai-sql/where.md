---
description: >-
  where拼接原理: where 元素只会在子元素返回任何内容的情况下才插入 “WHERE” 子句。而且，若子句的开头为 “AND” 或
  “OR”，where 元素也会将它们去除。
---

# Where

场景一：查询所有用户，如果输入了姓名按照姓名进行模糊查询，如果输入年龄，按照年龄进行查询，如果两者都输入，两个条件都要成立。

1、定义接口

```text
/**
     *  询男性用户，如果输入了姓名则按照姓名模糊查找，
     *  否则如果输入了年龄则按照年龄查找，如果两者都输入，两个条件都要成立
     *  否则查找姓名为"张三"的用户。
     *  使用动态SQL的where
     *
     * @param username  用户名称
     * @param age   年龄
     * @return  用户信息列表
     */

    List<UserVO> selectUserListByNameAndAgeWhere2(@Param("username") String username, @Param("age") Integer age);

```

2、编写mapper

```text
  <select id="selectUserListByNameAndAgeWhere2" resultMap="UserVO1ResultMap">
        select
        <include refid="sqlCommon.sqlColumnComm"></include>
        from user1
        <where>
      <!-- 如果多出一个and,会自动清除。
      如果少个and或者多出多个and，会报错-->
            <if test="username!=null and username.trim()!=''">
                and username like "%"#{username}"%"
            </if>
            <if test="age!=null">
                and userage=#{age}
            </if>
        </where>
    </select>
    
```

3、测试

```text
    @Test
    public void selectUserListByNameAndAgeWhere2()
    {
        List<UserVO> userVOList = userMapper.selectUserListByNameAndAgeWhere2("张三", 23);
        for (UserVO vo : userVOList) {
            System.out.println(vo);
        }
        System.out.println("看看结果与selectUserListByNameAndAgeWhere1的有什么不同！");
    }
```

