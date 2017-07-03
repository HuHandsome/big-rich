package com.lottery.web.controller;

import javax.servlet.http.HttpServletRequest;

import com.lottery.common.ConstUser;
import com.lottery.db.entity.UserEntity;

public class BaseController {
    static final String ERR_MSG_TAG = "errorMsg";

    void setSessionUser(HttpServletRequest request, UserEntity user) {
        request.getSession().setAttribute(ConstUser.USER_CONTEXT, user);
    }
}
