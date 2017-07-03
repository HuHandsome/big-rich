package com.lottery.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lottery.common.ConstForum;
import com.lottery.db.entity.BoardEntity;
import com.lottery.db.entity.TopicEntity;
import com.lottery.service.ForumService;
import com.lottery.service.TopicService;

@Controller
public class BoardManageController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(BoardManageController.class);

    @Resource
    private TopicService topicService;
    @Resource
    private ForumService forumService;

    @RequestMapping("/board/board-{boardId}")
    public String listTopics(@PathVariable Integer boardId, @RequestParam(required = false) Integer pageNo,
            @RequestParam(required = false) Integer pageSize, ModelMap model) {
        List<TopicEntity> topicList = topicService.listTopicByBoardId(boardId, pageNo, pageSize);
        BoardEntity board = forumService.findBoardById(boardId);
        model.addAttribute(ConstForum.TOPIC_PAGE_CXT, topicList);
        model.addAttribute(ConstForum.BOARD_CXT, board);
        logger.debug("获取主题列表");
        return "board/listBoardTopics";
    }
}
