package com.lottery.db.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lottery.db.entity.LoginLogEntity;
import com.lottery.db.entity.LoginLogEntityExample;

public interface LoginLogEntityMapper {
    int countByExample(LoginLogEntityExample example);

    int deleteByExample(LoginLogEntityExample example);

    int deleteByPrimaryKey(Integer loginLogId);

    int insert(LoginLogEntity record);

    int insertSelective(LoginLogEntity record);

    List<LoginLogEntity> selectByExample(LoginLogEntityExample example);

    LoginLogEntity selectByPrimaryKey(Integer loginLogId);

    int updateByExampleSelective(@Param("record") LoginLogEntity record, @Param("example") LoginLogEntityExample example);

    int updateByExample(@Param("record") LoginLogEntity record, @Param("example") LoginLogEntityExample example);

    int updateByPrimaryKeySelective(LoginLogEntity record);

    int updateByPrimaryKey(LoginLogEntity record);
}