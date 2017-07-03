package com.lottery.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lottery.common.ConstForum;
import com.lottery.db.entity.BoardEntity;
import com.lottery.service.ForumService;

@Controller
public class ForumManageController extends BaseController {
    @Resource
    private ForumService forumService;

    @RequestMapping("/index")
    public String listAllBorads(HttpServletRequest request) {
        List<BoardEntity> boradList = forumService.getAllBoards();
        request.setAttribute(ConstForum.BOARDS_CXT, boradList);
        return "/board/listAllBoard";
    }

}
