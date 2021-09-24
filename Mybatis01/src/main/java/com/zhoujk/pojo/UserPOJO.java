package com.zhoujk.pojo;

/**
 * Created by IntelliJ IDEA
 *
 * @Author: ZhouJiankang
 * @Date: 2021/9/23  8:25
 * @Description:
 */
public class UserPOJO
{
    private Integer id;
    private String username;
    private String password;
    private Integer age;
    private String sex;
    private String hobby;
    private String remark;

    public UserPOJO()
    {
    }

    public UserPOJO(Integer id, String username, String password, Integer age, String sex, String hobby, String remark)
    {
        this.id = id;
        this.username = username;
        this.password = password;
        this.age = age;
        this.sex = sex;
        this.hobby = hobby;
        this.remark = remark;
    }

    public UserPOJO(String username, String password, Integer age, String sex, String hobby, String remark)
    {
        this.username = username;
        this.password = password;
        this.age = age;
        this.sex = sex;
        this.hobby = hobby;
        this.remark = remark;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public Integer getAge()
    {
        return age;
    }

    public void setAge(Integer age)
    {
        this.age = age;
    }

    public String getSex()
    {
        return sex;
    }

    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public String getHobby()
    {
        return hobby;
    }

    public void setHobby(String hobby)
    {
        this.hobby = hobby;
    }

    public String getRemark()
    {
        return remark;
    }

    public void setRemark(String remark)
    {
        this.remark = remark;
    }

    @Override public String toString()
    {
        return "UserPOJO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", hobby='" + hobby + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
