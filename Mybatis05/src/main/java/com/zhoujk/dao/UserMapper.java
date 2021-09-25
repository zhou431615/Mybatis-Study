package com.zhoujk.dao;

import com.zhoujk.pojo.UserPOJO;
import com.zhoujk.vo.UserVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by IntelliJ IDEA
 *
 * @Author: ZhouJiankang
 * @Date: 2021 /9/23  13:52
 * @Description:
 */


/**
 * 使用代理接口
 * <p>
 * 需要代理的接口        mapper.xml文件
 * 全路径名称        namespace
 * 方法名称        statementId
 * 参数列表        parameterType
 * 返回值         resultType/resultMap
 * <p>
 * 以上需要一一对应 或者一致
 *
 * @author ZhouJiankang
 */


public interface UserMapper
{
    /**
     * 根据用户ID查询该用户信息
     *
     * @param id 用户的ID
     * @return UserVO 用户对象
     */
    UserVO selectUserById(Integer id);

    /**
     * 按照用户名称 模糊查询 包含某个字符串的用户信息
     *
     * @param userName 用户名称
     * @return 用户信息列表
     */

    List<UserVO> selectUserListByNameLike(String userName);


    /**
     * 插入用户信息通过$方式
     * Insert boolean.
     *
     * @param userPOJO the user pojo
     * @return the boolean
     */
    boolean insertBy$(UserPOJO userPOJO);


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


    /**
     * 查询男性用户，如果输入了姓名则按照姓名模糊查找，
     * 否则如果输入了年龄则按照年龄查找，否则查找姓名为"张三"的用户。
     *
     * @param username 用户名称
     * @param age      年龄
     * @return 用户信息列表
     */

    List<UserVO> selectUserListByNameAndAge(@Param("username") String username, @Param("age") Integer age);

    /**
     *  询男性用户，如果输入了姓名则按照姓名模糊查找，
     *  否则如果输入了年龄则按照年龄查找，否则查找姓名为"张三"的用户。
     *  使用动态SQL的where
     *
     * @param username  用户名称
     * @param age   年龄
     * @return  用户信息列表
     */

    List<UserVO> selectUserListByNameAndAgeWhere1(@Param("username") String username, @Param("age") Integer age);

   /**
     *  询男性用户，如果输入了姓名则按照姓名模糊查找，
     *  否则如果输入了年龄则按照年龄查找，否则查找姓名为"张三"的用户。
     *  使用动态SQL的where
     *
     * @param username  用户名称
     * @param age   年龄
     * @return  用户信息列表
     */

    List<UserVO> selectUserListByNameAndAgeWhere2(@Param("username") String username, @Param("age") Integer age);

    /**
     *  根据用户的输入更新用户信息
     * @param userPOJO 用户对象
     * @return   是否更新成功
     */
    boolean updateUser(UserPOJO userPOJO);


    List<UserVO> selectUserListBySexOrAge(@Param("sex") String sex, @Param("age") Integer age);

}
