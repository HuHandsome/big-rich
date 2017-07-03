package com.lottery.db.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lottery.db.entity.BoardManagerEntityExample;
import com.lottery.db.entity.BoardManagerEntityKey;

public interface BoardManagerEntityMapper {
    int countByExample(BoardManagerEntityExample example);

    int deleteByExample(BoardManagerEntityExample example);

    int deleteByPrimaryKey(BoardManagerEntityKey key);

    int insert(BoardManagerEntityKey record);

    int insertSelective(BoardManagerEntityKey record);

    List<BoardManagerEntityKey> selectByExample(BoardManagerEntityExample example);

    int updateByExampleSelective(@Param("record") BoardManagerEntityKey record, @Param("example") BoardManagerEntityExample example);

    int updateByExample(@Param("record") BoardManagerEntityKey record, @Param("example") BoardManagerEntityExample example);
}