package com.zhoujk.mapper;

/**
 * Created by IntelliJ IDEA
 *
 * @Author: ZhouJiankang
 * @Date: 2021 /9/23  13:52
 * @Description:
 */


import com.zhoujk.vo.UserVO;

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
     * 延迟加载的接口方法
     * @param id
     * @return
     */
    UserVO queryUserById (Integer id);


}
