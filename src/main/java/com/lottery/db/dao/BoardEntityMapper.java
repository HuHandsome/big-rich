package com.lottery.db.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lottery.db.entity.BoardEntity;
import com.lottery.db.entity.BoardEntityExample;

public interface BoardEntityMapper {
    int countByExample(BoardEntityExample example);

    int deleteByExample(BoardEntityExample example);

    int deleteByPrimaryKey(Integer boardId);

    int insert(BoardEntity record);

    int insertSelective(BoardEntity record);

    List<BoardEntity> selectByExample(BoardEntityExample example);

    BoardEntity selectByPrimaryKey(Integer boardId);

    int updateByExampleSelective(@Param("record") BoardEntity record, @Param("example") BoardEntityExample example);

    int updateByExample(@Param("record") BoardEntity record, @Param("example") BoardEntityExample example);

    int updateByPrimaryKeySelective(BoardEntity record);

    int updateByPrimaryKey(BoardEntity record);
}