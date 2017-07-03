package com.lottery.web.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
@RequestMapping("/login")
public class LoginController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Resource
    private UserService userService;

    @RequestMapping
    public String index() {
        return "/user/login";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String login(@ModelAttribute("form") UserEntity userinfo, HttpServletRequest rq, ModelMap model) {
        try {
            logger.debug("接收到登录请求:" + GsonUtil.toJsonStr(userinfo));
            UserEntity dbUser = userService.getUserByUsername(userinfo.getUserName());
            model.addAttribute(ConstUser.USERNAME_TAG, userinfo.getUserName());
            if (dbUser == null) {
                model.addAttribute(ERR_MSG_TAG, "用户名不存在");
            } else if (ConstUser.USER_LOCKED == dbUser.getLocked()) {
                model.addAttribute(ERR_MSG_TAG, "用户已被锁定,不能登录");
            } else if (!StringUtils.equals(userinfo.getPassword(), dbUser.getPassword())) {
                model.addAttribute(ERR_MSG_TAG, "用户名/密码错误");
            } else {
                dbUser.setLastvisit(new Date());
                dbUser.setLastip(rq.getRemoteAddr());
                userService.loginSuccess(dbUser);
                setSessionUser(rq, dbUser);
                String toUrl = (String) rq.getSession().getAttribute(ConstUser.LOGIN_TOURL);
                rq.getSession().removeAttribute(ConstUser.LOGIN_TOURL);
                if (StringUtils.isBlank(toUrl)) {
                    toUrl = "/index";
                }
                model.remove(ConstUser.USERNAME_TAG);
                rq.getSession().setAttribute(ConstUser.USERNAME_TAG, dbUser.getUserName());
                return "redirect:" + toUrl;
            }
        } catch (Exception e) {
            String errMsg = String.format("用户登录异常userinfo:%s", GsonUtil.toJsonStr(userinfo));
            logger.error(errMsg, e);
            model.addAttribute(ERR_MSG_TAG, "登录失败,未知异常");
        }
        return "user/login";
    }

    @RequestMapping("/doLogout")
    public String logout(HttpSession session) {
        session.removeAttribute(ConstUser.USER_CONTEXT);
        return "redirect:/index";
    }
}
