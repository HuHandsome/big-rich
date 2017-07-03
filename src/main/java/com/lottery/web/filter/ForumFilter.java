package com.lottery.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

import com.lottery.common.ConstUser;
import com.lottery.common.Constant;
import com.lottery.db.entity.UserEntity;

public class ForumFilter implements Filter {
    private static final String FILTERED_REQUEST = "session_context_filtered_request";

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (request != null && request.getAttribute(FILTERED_REQUEST) != null) {
            // 在一次请求中,过滤器只调用一次
            chain.doFilter(request, response);
        } else if (request != null) {
            request.setAttribute(FILTERED_REQUEST, Boolean.TRUE);
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            UserEntity userContext = (UserEntity) httpRequest.getAttribute(ConstUser.USER_CONTEXT);
            if (userContext == null && needLogin(httpRequest)) {
                String toUrl = httpRequest.getRequestURI();
                if (StringUtils.isNotBlank(httpRequest.getQueryString())) {
                    toUrl += httpRequest.getQueryString();
                }
                httpRequest.setAttribute(ConstUser.LOGIN_TOURL, toUrl);
                request.getRequestDispatcher("/login.html").forward(request, response);
                return;
            }
            chain.doFilter(request, response);
        }
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
    }

    /**
     * 判断该地址是否需要登录访问
     *
     * @param httpRequest 请求参数
     * @return 返回是否需要登录
     */
    private boolean needLogin(HttpServletRequest httpRequest) {
        String path = httpRequest.getContextPath();
        String rqURI = httpRequest.getRequestURI();
        if (path.equalsIgnoreCase(rqURI) || (path + "/").equalsIgnoreCase(rqURI)) {
            return false;
        }
        for (String uri : Constant.ESCAPE_URI) {
            if (StringUtils.isNotBlank(rqURI) && rqURI.contains(uri)) {
                return false;
            }
        }
        return true;
    }
}
