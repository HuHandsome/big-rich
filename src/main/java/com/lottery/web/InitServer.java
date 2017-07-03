package com.lottery.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lottery.service.ConfigInitService;

public class InitServer extends HttpServlet {
    private static final long serialVersionUID = -3793484850850613257L;
    private static final Logger logger = LoggerFactory.getLogger(InitServer.class);

    @Override
    public void init() throws ServletException {
        logger.info(">>> Start Init bookingcom-service");
        ConfigInitService configInitService = new ConfigInitService();
        configInitService.loaderEscapeURI();
        configInitService = null;
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
