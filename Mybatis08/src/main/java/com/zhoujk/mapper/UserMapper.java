package com.zhoujk.mapper;

import com.zhoujk.pojo.UserWithBLOBs;

public interface UserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user2
     *
     * @mbg.generated Mon Sep 27 14:39:59 CST 2021
     */
    int insert(UserWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user2
     *
     * @mbg.generated Mon Sep 27 14:39:59 CST 2021
     */
    int insertSelective(UserWithBLOBs record);
}