package com.lottery.db.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lottery.db.entity.UserEntity;
import com.lottery.db.entity.UserEntityExample;

public interface UserEntityMapper {
    int countByExample(UserEntityExample example);

    int deleteByExample(UserEntityExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(UserEntity record);

    int insertSelective(UserEntity record);

    List<UserEntity> selectByExample(UserEntityExample example);

    UserEntity selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") UserEntity record, @Param("example") UserEntityExample example);

    int updateByExample(@Param("record") UserEntity record, @Param("example") UserEntityExample example);

    int updateByPrimaryKeySelective(UserEntity record);

    int updateByPrimaryKey(UserEntity record);
}