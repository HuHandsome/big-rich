package com.lottery.db.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lottery.db.entity.PostEntity;
import com.lottery.db.entity.PostEntityExample;

public interface PostEntityMapper {
    int countByExample(PostEntityExample example);

    int deleteByExample(PostEntityExample example);

    int deleteByPrimaryKey(Integer postId);

    int insert(PostEntity record);

    int insertSelective(PostEntity record);

    List<PostEntity> selectByExampleWithBLOBs(PostEntityExample example);

    List<PostEntity> selectByExample(PostEntityExample example);

    PostEntity selectByPrimaryKey(Integer postId);

    int updateByExampleSelective(@Param("record") PostEntity record, @Param("example") PostEntityExample example);

    int updateByExampleWithBLOBs(@Param("record") PostEntity record, @Param("example") PostEntityExample example);

    int updateByExample(@Param("record") PostEntity record, @Param("example") PostEntityExample example);

    int updateByPrimaryKeySelective(PostEntity record);

    int updateByPrimaryKeyWithBLOBs(PostEntity record);

    int updateByPrimaryKey(PostEntity record);
}