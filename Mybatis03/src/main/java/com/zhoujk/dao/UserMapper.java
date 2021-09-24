package com.zhoujk.dao;

import com.zhoujk.pojo.UserPOJO;
import com.zhoujk.vo.UserVO;

import java.util.List;

/**
 * Created by IntelliJ IDEA
 *
 * @Author: ZhouJiankang
 * @Date: 2021 /9/23  13:52
 * @Description:
 */


/**  使用代理接口
 *
 *   需要代理的接口        mapper.xml文件
 *      全路径名称        namespace
 *       方法名称        statementId
 *       参数列表        parameterType
 *        返回值         resultType/resultMap
 *
 *   以上需要一一对应 或者一致
 *
 *
 * @author ZhouJiankang*/


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
     * 查询所有的用户信息
     *
     * @return UserVO list
     */
    List<UserVO> selectAll();

    /**
     * Insert boolean.
     *
     * @param userPOJO the user pojo
     * @return the boolean
     */
    boolean insert(UserPOJO userPOJO);

    /**
     * Update by id boolean.
     *
     * @param userPOJO the user pojo
     * @return the boolean
     */
    boolean updateById(UserPOJO userPOJO);

    /**
     * Delete by id boolean.
     *
     * @param id the id
     * @return the boolean
     */
    boolean deleteById(Integer id);

}
