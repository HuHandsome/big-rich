package com.lottery.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lottery.common.ConstForum;
import com.lottery.db.dao.TopicEntityMapper;
import com.lottery.db.entity.TopicEntity;
import com.lottery.db.entity.TopicEntityExample;

@Service
public class TopicService {

    @Resource
    private TopicEntityMapper topicEntityMapper;

    public List<TopicEntity> listTopicByBoardId(int boardId, Integer pageNo, Integer pageSize) {
        if (pageNo == null || pageNo <= 0) pageNo = 1;
        if (pageSize == null || pageSize <= 0) pageSize = ConstForum.TOPIC_PAGE_SIZE;
        TopicEntityExample example = new TopicEntityExample();
        example.createCriteria().andBoardIdEqualTo(boardId);
        example.setOrderByClause("last_post desc");
        example.setLimitSize(pageSize);
        example.setLimitStart(pageSize * (pageNo - 1));
        return topicEntityMapper.selectByExample(example);
    }
}
