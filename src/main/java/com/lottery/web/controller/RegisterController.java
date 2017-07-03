package com.lottery.web.controller;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lottery.common.ConstUser;
import com.lottery.db.entity.UserEntity;
import com.lottery.service.UserService;
import com.lottery.util.GsonUtil;

@Controller
public class RegisterController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(RegisterController.class);

    @Resource
    private UserService userService;

    @RequestMapping("/register")
    public String register() {
        return "/user/register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String doregister(@ModelAttribute UserEntity userinfo, ModelMap model) {
        logger.debug("接收到注册请求:" + GsonUtil.toJsonStr(userinfo));
        if (!checkParm(userinfo)) {
            model.addAttribute(ERR_MSG_TAG, "缺少必要的注册参数");
            return "/user/register";
        }
        if (userService.register(userinfo)) {
            model.addAttribute(ConstUser.USERNAME_TAG, userinfo.getUserName());
            return "/user/login";
        } else {
            model.addAttribute(ERR_MSG_TAG, "用户名已存在,请重新注册");
            return "/user/register";
        }
    }

    private boolean checkParm(UserEntity userinfo) {
        if (userinfo == null) {
            return false;
        }
        if (StringUtils.isBlank(userinfo.getUserName())) {
            return false;
        }
        if (StringUtils.isBlank(userinfo.getPassword())) {
            return false;
        }
        return true;
    }
}
