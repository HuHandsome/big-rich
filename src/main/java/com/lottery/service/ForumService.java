package com.lottery.service;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lottery.db.dao.BoardEntityMapper;
import com.lottery.db.entity.BoardEntity;
import com.lottery.db.entity.BoardEntityExample;

@Service
public class ForumService {
    private Logger logger = LoggerFactory.getLogger(ForumService.class);

    @Resource
    private BoardEntityMapper boardEntityMapper;

    public List<BoardEntity> getAllBoards() {
        BoardEntityExample example = new BoardEntityExample();
        example.createCriteria();
        return boardEntityMapper.selectByExample(example);
    }

    public BoardEntity findBoardById(Integer boardId) {
        try {
            if (boardId != null) {
                return boardEntityMapper.selectByPrimaryKey(boardId);
            }
        } catch (Exception e) {
            logger.error("查询异常", e);
        }
        return null;
    }
}
